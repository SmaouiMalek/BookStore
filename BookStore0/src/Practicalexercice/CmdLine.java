package Practicalexercice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CmdLine {
	private int idline;
	private int qty;
	private double totalprice=0;
	
	public void addLine() throws ClassNotFoundException, SQLException
    { double pricebook = 0;
    MyConnection con;
    PreparedStatement pstmt;
    con = new MyConnection();
    System.out.println("Put in the book's id ");
    Scanner sc1 = new Scanner( System.in );
    long id   = sc1.nextLong();
    System.out.println("Put in the quantity ");
    Scanner sc2 = new Scanner( System.in );
    int qty   = sc2.nextInt();
   
    //give book
     try {
            pstmt = con.MyConnec().prepareStatement("SELECT * FROM book where id = ? ");
            pstmt.setDouble(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
                {
                 pricebook =Double.parseDouble(rs.getString("price"));
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
     
    pstmt =  con.MyConnec().prepareStatement("INSERT INTO `cmdline`(idline,id,price,qty,totalprice) VALUES ( ?, ?, ?, ?,?)");
    pstmt.setNString(1, null );
    pstmt.setLong(2, id );
    pstmt.setDouble(3,pricebook);
    pstmt.setInt(4, qty );
    pstmt.setDouble(5,pricebook*qty );
    
    System.out.println("Command line added");
    pstmt.executeUpdate();
    }
	public void totalPrice() throws ClassNotFoundException {
		try {
			 MyConnection con;
			    PreparedStatement pstmt;
			    con = new MyConnection();
            pstmt = con.MyConnec().prepareStatement("SELECT totalprice FROM cmdline ");
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
                {
                 setTotalprice(getTotalprice() + Double.parseDouble(rs.getString("totalprice")));
                }
            
            System.out.println(" \n total price of COMMAND LINE  ***"+totalprice+"***");
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
		
		
	}
	public void displaycmdline() throws ClassNotFoundException, SQLException {
	 MyConnection con;
     PreparedStatement pstmt;
     con = new MyConnection();
      pstmt = con.MyConnec().prepareStatement("SELECT * FROM cmdline "); 
     ResultSet rs = pstmt.executeQuery();
     int i=0;
     while (rs.next()) {
         
            String idline = rs.getString("idline");
            String id = rs.getString("id");
            String price = rs.getString("price");
            String qty = rs.getString("qty");
            String totalprice = rs.getString("totalprice");
            
            System.out.print("\n"+"id commande: " + idline);
            System.out.print(", id book: " + id);
            System.out.print(", price book: " +price);
            System.out.print(", quantity: " + qty);
            System.out.print(", total price: " + totalprice);
}}
	public void deletecmdline() throws ClassNotFoundException, SQLException {
	 MyConnection con;
     PreparedStatement pstmt;
     con = new MyConnection();
     try {
     pstmt = con.MyConnec().prepareStatement("TRUNCATE TABLE cmdline ");
     pstmt.executeUpdate();
     System.out.println("Command Line deleted");
     }catch(SQLException e)
     {e.printStackTrace();
     }
	
	}
	
	public CmdLine() {
	
	}
	
	
	
	public int getIdline() {
		return idline;
	}
	public void setIdline(int idline) {
		this.idline = idline;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
}
