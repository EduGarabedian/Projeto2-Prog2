package db;
import api.Regs;
import api.Results;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegsDao {
        private String createSQL = "INSERT INTO mack_edu.registros VALUES (?,?)";
        private String readSQL = "SELECT * FROM mack_edu.registros";
        private String updateSQL = "UPDATE mack_edu.registros SET date=?, acessos=?";
        private  String deleteSQL= "DELETE FROM mack_edu.registros WHERE date=?";

        private final mySQLConnection mysql = new mySQLConnection();


        public boolean create(Results res) {
                Connection conexao = mysql.getConnection();
                try {
                        PreparedStatement statement = conexao.prepareStatement(createSQL);

                        statement.setString(1, res.getDate());
                        statement.setInt(2,res.getAcessos());

                        int registros = statement.executeUpdate();

                        return registros > 0 ? true : false;
                } catch (final SQLException e) {
                        System.out.println("Falha de conexão com a base de dados!");
                        e.printStackTrace();
                } catch (final Exception e) {
                        e.printStackTrace();
                } finally {
                        try {
                                conexao.close();
                        } catch (final Exception e) {
                                e.printStackTrace();
                        }
                }
                return false;
        }

        public List<Results> read() {
                Connection conexao = mysql.getConnection();
                List<Results> Res = new ArrayList();

                try {
                        PreparedStatement statement = conexao.prepareStatement(readSQL);
                        ResultSet resultSet = statement.executeQuery();

                        while (resultSet.next()) {
                                Results res = new Results();
                                res.setDate(resultSet.getString("Date"));
                                res.setAcessos(resultSet.getInt("acessos"));
                                Res.add(res);
                        }
                        return Res;
                } catch (final SQLException e) {
                        System.out.println("Falha de conexão com a base de dados");
                        e.printStackTrace();
                } catch (final Exception e) {
                        e.printStackTrace();
                } finally {
                        try {
                                conexao.close();
                        } catch (final Exception e) {
                                e.printStackTrace();
                        }
                }
                return Res;
        }

        public boolean update(Results res){
                Connection conexao = mysql.getConnection();
                try{
                        PreparedStatement statement=conexao.prepareStatement(updateSQL);

                        statement.setInt(2, res.getAcessos());
                        statement.setString(1, res.getDate());

                        int registros= statement.executeUpdate();

                        return registros>0? true:false;
                }catch (final SQLException ex){
                        System.out.println("Falha na conexão com a base de dados");
                        ex.printStackTrace();
                }catch (final Exception ex){
                        ex.printStackTrace();
                }finally {
                        try{
                                conexao.close();
                        }catch (final Exception ex){
                                ex.printStackTrace();
                        }
                }
                return false;
        }

        public boolean delete(String date){
                Connection conexao = mysql.getConnection();
                try{
                        PreparedStatement statement= conexao.prepareStatement(deleteSQL);

                        statement.setString(1, date);

                        int registros= statement.executeUpdate();

                        return registros>0;
                }catch(final SQLException ex){
                        System.out.println("Falha na conexão com a base de dados");
                        ex.printStackTrace();
                }catch (final Exception ex){
                        ex.printStackTrace();
                }finally {
                        try{
                                conexao.close();
                        }catch (final Exception ex){
                                ex.printStackTrace();
                        }
                }
                return false;
        }
}



