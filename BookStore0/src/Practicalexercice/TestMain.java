package Practicalexercice;
import java.text.*;
import java.sql.Date;
import java.sql.SQLException;

import java.util.Scanner;



public class TestMain {
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		String p = null,n11 = null,n1,c = null;
		Double pr = null;
		 Book book = new Book();
		 User user=new User();
		 CmdLine cmdline=new CmdLine();
		 int a=0;
	        do {
	        	
	            System.out.println("****************** welcome! you must choose an option****************** ");
	            System.out.println(" \n********* 1: add book ********* ");
	            System.out.println("********* 2: Update Book ********* ");
	            System.out.println("********* 3: Display BookStore ********* ");
	            System.out.println("********* 4: Buy Books ********* ");
	            System.out.println("********* 5: delete book ********* ");
	            System.out.println("********* 6: Add User ********* ");
	            System.out.println("********* 7: Display User ********* ");
	            System.out.println("********* 8: Add command *********  ");
	            System.out.println("********* 9: TOTAL PRICE TO PAY *********  ");
	            System.out.println("********* 10: Delete Command Line before you leave ********* ");
	            System.out.println("********* 11: Exit ********* ");
	            Scanner s = new Scanner( System.in );
	            a   = s.nextInt();
	            switch(a)
	            {case 1:{  try {
	       		 //add book
	        		System.out.println("Author name ");
	        		Scanner sc = new Scanner( System.in );
	        		String author   = sc.nextLine();
	        		System.out.println("Book Title ");
	        		Scanner sc1 = new Scanner( System.in );
	        		String Title   = sc1.nextLine();
	        		System.out.println("Book Price ");
	        		Scanner sc3 = new Scanner( System.in );
	        		Double Price   = sc3.nextDouble();
	        		//scanner date
	        		System.out.println("Book's Release date **Please follow this format** (yyyy-mm-dd)");
	        		Scanner sc5 = new Scanner( System.in );
	        		String doj=sc5.next();
	        		
	        		java.sql.Date releasedate=java.sql.Date.valueOf(doj);
	        		
	        		book.addBook(author, Title,Price,releasedate);
	        	                } catch (ClassNotFoundException | SQLException e) {
	        	                    // TODO Auto-generated catch block
	        	                    e.printStackTrace();
	        	                }break;  }
	            case 2:{ 
	            System.out.println("the book's id you want to update ");
    	        Scanner sc9 = new Scanner( System.in );
    	        int idb   = sc9.nextInt();
    	     
    			//simple methode 
    	         System.out.println(" Author name ");
    	            Scanner sc = new Scanner( System.in );
    	            String author   = sc.nextLine();
    	            System.out.println("Book's title ");
    	            Scanner sc1 = new Scanner( System.in );
    	            String title   = sc1.nextLine();
    	            System.out.println("Book's price ");
    	            Scanner sc3 = new Scanner( System.in );
    	            Double price   = sc3.nextDouble();
    			//scanner date
    	            
	        		System.out.println("Book's Release date to update **Please follow this format** (yyyy-mm-dd)");
	        		Scanner sc5 = new Scanner( System.in );
	        		String doj=sc5.next();
	        		java.sql.Date releasedate=java.sql.Date.valueOf(doj);
	        		
    	book.updateBook(idb, author,title, price, releasedate);
    	break;}
	            	
	            case 3:{
	                try {
	                	//display book
	            		book.displayBook();
	                } catch (ClassNotFoundException | SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }break;}
		
	            case 4:{
	            	//Total price
	            	System.out.println("which book you want to buy ");
	            	book.displayBook();
	        		System.out.println("choose Book by  ID ");
	        		Scanner sc7 = new Scanner( System.in );
	        		int id1   = sc7.nextInt();
	        		System.out.println("Quantity ");
	        		Scanner sc8 = new Scanner( System.in );
	        		int qte   = sc8.nextInt();
	        		book.displayCalculTotal(id1,qte);break;}
	            case 5:{
	            	//Delete Book
	            	System.out.println("Choose the book you want to delete by id ");
	            	book.displayBook();
	        		Scanner sc9 = new Scanner( System.in );
	        		int id   = sc9.nextInt();
	        		book.deleteBook(id);
	        		System.out.println("book number =("+id+") deleted");
	               break; } 
	            case 6:{
	            	//add User
		            	user.addUser();
	               break; } 
	           
	        		case 7:{
	        			//Display user
            	user.displayUser();
            	break; } 
	        		case 8:{
	        			//ADD command line
	    	        	book.displayBook();
	                	cmdline.addLine();
	        			int r;
	        			do
	    			{System.out.println("you want to add an other book? ");
	    			System.out.println("1:yes ");
	    			System.out.println("2:no ");
	    			Scanner sc141 = new Scanner( System.in );
	    			 r   = sc141.nextInt();}
	    			while (r!=1&&r!=2);
	    			if (r==1)
	    			{//ADD command line
	    	        	book.displayBook();
	                	cmdline.addLine();
	                	
	    			}
	        			
            	break; 
            	} 
	        		case 9:{
	        			System.out.println("The Bill to pay");
	        		cmdline.displaycmdline();
	            	cmdline.totalPrice();
	            	break;
	        		}
	        		case 10:{
	        			cmdline.deletecmdline();
	        			cmdline.displaycmdline();
	        		break;
	        		}
	            }
	        }while(a!=10);
	}
	}
		
