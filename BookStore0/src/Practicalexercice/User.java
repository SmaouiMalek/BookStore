package Practicalexercice;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class User {
    private String login;
    private String pass;
    private String name;
    private String sname;
    private String phone;
    
    public User() {
		
	}
    
	public User(String login, String pass, String name, String sname, String phone) {
		super();
		this.login = login;
		this.pass = pass;
		this.name = name;
		this.sname = sname;
		this.phone = phone;
	}

	public void addUser() throws ClassNotFoundException, SQLException
    {
        MyConnection con;
        PreparedStatement pstmt;
        con = new MyConnection();
        System.out.println(" login ");
        Scanner a1 = new Scanner( System.in );
        String log   = a1.nextLine();
        System.out.println(" password ");
        Scanner a2 = new Scanner( System.in );
        String pass   = a2.nextLine();
        System.out.println("  Name ");
        Scanner a3 = new Scanner( System.in );
        String name   = a3.nextLine();
        System.out.println(" Second Name ");
        Scanner a4 = new Scanner( System.in );
        String sname   = a4.nextLine();
        System.out.println(" phone ");
        Scanner a5 = new Scanner( System.in );
        String phone  = a5.nextLine();
        pstmt = con.MyConnec().prepareStatement("INSERT INTO `user`(login,pass,name,sname,phone) VALUES (?, ?, ?, ?, ?)");
        pstmt.setNString(1, log );
        pstmt.setString(2, pass );
        pstmt.setString(3, name );
        pstmt.setString(4,sname);
        pstmt.setString(5, phone );
                   System.out.println("User added");
                   pstmt.executeUpdate();
    }
    public void displayUser() throws ClassNotFoundException, SQLException
    {
         MyConnection con;
         PreparedStatement pstmt;
         con = new MyConnection();
          pstmt = con.MyConnec().prepareStatement("SELECT * FROM user "); 
         ResultSet rs = pstmt.executeQuery();
         int i=0;
         while (rs.next()) {
             
                String login = rs.getString("login");
                String pass = rs.getString("pass");
                String name = rs.getString("name");
                String sname = rs.getString("sname");
                String phone = rs.getString("phone");
    
                //Display values
                System.out.print("login: " + login);
                System.out.print(", password: " + pass);
                System.out.print(", name: " + name);
                System.out.print(", sname: " + sname);
                System.out.print(", phone: " + phone);
    }
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getMdp() {
        return pass;
    }
    public void setMdp(String mdp) {
        this.pass = mdp;
    }
    public String getNom() {
        return name;
    }
    public void setNom(String nom) {
        this.name = nom;
    }
    public String getPrenom() {
        return sname;
    }
    public void setPrenom(String prenom) {
        this.sname = prenom;
    }
    public String getTel() {
        return phone;
    }
    public void setTel(String tel) {
        this.phone = tel;
    }
   
}