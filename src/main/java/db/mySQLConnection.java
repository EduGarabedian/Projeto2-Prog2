package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class mySQLConnection {
    String url="jdbc:mysql://127.0.0.1:3306/mack_edu?useTimezone=true&serverTimezone=UTC";
    String usuario="Edu";
    String senha="root";

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,usuario,senha);
        }catch (final Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
