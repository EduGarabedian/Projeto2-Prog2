package db;
import api.Regs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegsDao {
        private String createSQL = "INSERT INTO mack_edu.registros VALUES (?,?)";
        private String readSQL = "SELECT * FROM mack_edu.registros";
        private String updateSQL = "UPDATE mack_edu.registros SET date=? and acessos=?";
        private  String deleteSQL= "DELETE FROM mack_edu.registros WHERE date=?";

        private final mySQLConnection mysql = new mySQLConnection();
        private Object Regs;



        public boolean create(Regs regs) {
                Connection conexao = mysql.getConnection();
                try {
                        PreparedStatement statement = conexao.prepareStatement(createSQL);

                        statement.setString(1, regs.getDate());
                        statement.setInt(2,regs.getAcessos());

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


        public List<Regs> read() {
                Connection conexao = mysql.getConnection();
                List<Regs> Regs = new ArrayList();

                try {
                        PreparedStatement statement = conexao.prepareStatement(readSQL);
                        ResultSet resultSet = statement.executeQuery();

                        while (resultSet.next()) {
                                Regs regs = new Regs();
                                regs.setDate(resultSet.getString("Date"));
                                regs.setAcessos(resultSet.getInt("Acessos"));
                                Regs.add(regs);
                        }
                        return Regs;
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
                return Regs;
        }

        public boolean update(Regs regs){
                Connection conexao = mysql.getConnection();
                try{
                        PreparedStatement statement=conexao.prepareStatement(updateSQL);

                        statement.setString(1, regs.getDate());
                        statement.setInt(2, regs.getAcessos());

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

        public boolean delete(Regs regs){
                Connection conexao = mysql.getConnection();
                try{
                        PreparedStatement statement= conexao.prepareStatement(deleteSQL);

                        statement.setString(1, regs.getDate());

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



