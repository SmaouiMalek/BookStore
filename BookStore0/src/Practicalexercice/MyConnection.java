package Practicalexercice;

 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 

public class MyConnection {
Connection c =null;
    
    public MyConnection() throws ClassNotFoundException, SQLException
    {}
         

    public Connection MyConnec() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
        c = DriverManager.getConnection(url,"root","");
        
        return c;}

 

 

 

}