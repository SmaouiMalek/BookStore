package Practicalexercice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
private String author;
private String title;
private double price;
private Date releasedate;

public Book() {
	super();
}
public Book(String author, String title, double price, Date releasedate) {
	
	this.author = author;
	this.title = title;
	this.price = price;
	this.releasedate = releasedate;
}
//ADD methode
public void addBook(String author, String title,  double price,java.sql.Date releasedate) throws ClassNotFoundException, SQLException 
{   Connection con =null;

Class.forName("com.mysql.jdbc.Driver");

String url = "jdbc:mysql://localhost:3306/BookStore?serverTimezone=UTC";

con = DriverManager.getConnection(url,"root","");
try {
if (con==null)
    System.out.println("not connected");
else System.out.println("connected");
PreparedStatement pstmt = con.prepareStatement("INSERT INTO `book`(id,author,title,price,releasedate) VALUES (?,?, ?, ?, ?)");
pstmt.setString(1, null);
//pstmt.setNString(1, null);
pstmt.setString(2, author );
pstmt.setString(3, title );
pstmt.setDouble(4,price);
pstmt.setDate(5, releasedate );

    	   System.out.println("ajout avec success");
    	  
    	   pstmt.executeUpdate();
    }
catch(SQLException e)
{e.printStackTrace();}



 }
//Display methode
public void displayBook() throws ClassNotFoundException, SQLException 
{   Connection con =null;

Class.forName("com.mysql.jdbc.Driver");

String url = "jdbc:mysql://localhost:3306/BookStore?serverTimezone=UTC";

con = DriverManager.getConnection(url,"root","");
try {
PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Book "); 
ResultSet rs = pstmt.executeQuery();
int i=0;
while (rs.next()) {
    i++;
    System.out.println("Book "+i);



    System.out.println(" id : " + rs.getString("id")+" author : " + rs.getString("author")+" title : " + rs.getString("title")+" price : " + rs.getString("price")+" releaseDate : " + rs.getString("releaseDate"));
    /*System.out.println("author : " + rs.getString("author"));
    System.out.println("title : " + rs.getString("title"));
    System.out.println("price : " + rs.getString("price"));
    System.out.println("releaseDate : " + rs.getString("releaseDate"));*/
}}
catch(SQLException e)
{e.printStackTrace();}



 }
//Total price methode
public void displayCalculTotal(int quantity,double id) throws ClassNotFoundException, SQLException
{   Connection con =null;
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/BookStore?serverTimezone=UTC";
    con = DriverManager.getConnection(url,"root","");
    try {
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Book where id = ? ");
        pstmt.setDouble(1,id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
           
            System.out.println("CalculTotal = "+Double.parseDouble(rs.getString("price"))*quantity);
           
        }}
        catch(SQLException e)
        {e.printStackTrace();}

}
//delete methode
public void deleteBook(int id) throws ClassNotFoundException, SQLException 
{   Connection con =null;

Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/BookStore?serverTimezone=UTC";
con = DriverManager.getConnection(url,"root","");
try {
PreparedStatement pstmt = con.prepareStatement("DELETE FROM book WHERE id =?"); 

pstmt.setInt(1,id);
pstmt.executeUpdate();}
catch(SQLException e)
{e.printStackTrace();}
    	
    }

public void updateBook(int id, String author,String title, double price,Date releasedate) throws ClassNotFoundException, SQLException
{   Connection con =null;
Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/BookStore?serverTimezone=UTC";
con = DriverManager.getConnection(url,"root","");
try {
PreparedStatement pstmt = con.prepareStatement("UPDATE book SET author = ?,title = ?,price = ?,releasedate = ? WHERE id = ?");

 

pstmt.setString(1, author );
pstmt.setString(2, title );
pstmt.setDouble(3,price);
pstmt.setDate(4, releasedate );
pstmt.setDouble(5, id );

 

           pstmt.executeUpdate();
           System.out.println("updated succefully");}
catch(SQLException e)
{e.printStackTrace();}
       
    }

public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Date getReleasedate() {
	return releasedate;
}
public void setReleasedate(Date releasedate) {
	this.releasedate = releasedate;
}


}
