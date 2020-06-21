package db;
import api.Charts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public abstract class ChartsDao {

        private String createSQL = "INSERT INTO mack_edu.usuario VALUES (?)";
        private String readSQL = "SELECT * FROM mack_edu.usuario";
        private String readSQL2 = "SELECT * FROM mack_edu.userstatus";

        private final mySQLConnection mysql = new mySQLConnection();
        private Object Charts;


        @Override
        public boolean create(Charts charts) {
                Connection conexao = mysql.getConnection();
                try {
                        PreparedStatement statement = conexao.prepareStatement(createSQL);

                        statement.setString(1, Charts.getUserName());

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

        @Override
        public List<Charts> read() {
                Connection conexao = mysql.getConnection();
                List<Charts> iDumbs = new ArrayList();

                try {
                        PreparedStatement statement = conexao.prepareStatement(readSQL);
                        ResultSet resultSet = statement.executeQuery();

                        while (resultSet.next()) {
                                Charts charts = new Charts();
                                charts.setUserName(resultSet.getString("UserName"));
                                charts.add(charts);
                        }
                        return charts;
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
                return (List<api.Charts>) Charts;
        }
}


