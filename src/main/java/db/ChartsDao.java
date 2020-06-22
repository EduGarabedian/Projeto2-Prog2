package db;
import api.Charts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChartsDao {
        private String createSQL = "INSERT INTO mack_edu.usuario VALUES (?)";
        private String readSQL = "SELECT * FROM mack_edu.usuario";
        private String updateSQL = "UPDATE mack_edu.usuario SET UserName=?";
        private  String deleteSQL= "DELETE FROM mack_edu WHERE id=?";

        private final mySQLConnection mysql = new mySQLConnection();
        private Object Charts;



        public boolean create(Charts charts) {
                Connection conexao = mysql.getConnection();
                try {
                        PreparedStatement statement = conexao.prepareStatement(createSQL);

                        statement.setString(1, charts.getUserName());

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


        public List<Charts> read() {
                Connection conexao = mysql.getConnection();
                List<Charts> Charts= new ArrayList();

                try {
                        PreparedStatement statement = conexao.prepareStatement(readSQL);
                        ResultSet resultSet = statement.executeQuery();

                        while (resultSet.next()) {
                                Charts charts = new Charts();
                                charts.set(resultSet.getString("UserName"));
                                Charts.add(charts);
                        }
                        return Charts;
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
                return Charts;
        }

        public boolean update(Charts charts){
                Connection conexao = mysql.getConnection();
                try{
                        PreparedStatement statement=conexao.prepareStatement(updateSQL);

                        statement.setString(1, charts.getUserName());

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

        public boolean delete(Charts charts){
                Connection conexao = mysql.getConnection();
                try{
                        PreparedStatement statement= conexao.prepareStatement(deleteSQL);

                        statement.setString(1,charts.getUserName());

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



