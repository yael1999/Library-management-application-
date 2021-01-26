package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import MODEL.hashala;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author יעל כץ
 */
public class Return {
    
    
     public static List<hashala> make(String name) 
    {
        
       
       List <hashala> allBooks=new ArrayList<hashala>();//lim //all books he borrowed
     //   boolean st = false;//nisui//this value is the return value, why?????
        Connection con = null;
        try {

            //loading drivers for mysql
          //  Class.forName("com.derby.jdbc.Driver");
          Class.forName("org.apache.derby.jdbc.ClientDriver");
            //creating connection with the database
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HW3","yael","yael");
            PreparedStatement ps = con.prepareStatement("select * from borrowT where studentName=?");
            ps.setString(1,name);
            
      //       ps.setInt(4,10);
            ResultSet rs =ps.executeQuery();//all records found
          //  st = rs.next();//whether any records were found//why never changes to true?????
            while(rs.next()){
                int isbn=rs.getInt("isbn");
                int copyNum=rs.getInt("copyNum");
            //   String info=bookname+ "," + bookauthor +","+copyNum;//m
              MODEL.hashala hashala=new hashala(copyNum,isbn);
                allBooks.add(hashala);
            }
            con.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
      //  Search s=new Search(st,bookList);
        return allBooks;                 
    }
     public static boolean returnBook(hashala h) 
    {
          boolean st=false;//wether any records were found
        Connection con = null;
        int isbn=h.getIsbn();
        int copyNum=h.getCopyNum();
        try {

            //loading drivers for mysql
          //  Class.forName("com.derby.jdbc.Driver");
          Class.forName("org.apache.derby.jdbc.ClientDriver");
            //creating connection with the database
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HW3","yael","yael");
          
            PreparedStatement ps = con.prepareStatement("select * from borrowT where isbn=? and copyNum=?");//karagill
            ps.setInt(1, isbn);
            ps.setInt(2,copyNum);
            ResultSet rs =ps.executeQuery();//all records found -now we want to return this book(we found borrowed book in borrow database)
          
            if(rs.next()){ // if the book was found
                st=true;// we found the borrowed book
                 PreparedStatement ps2 = con.prepareStatement("update booksT SET isBorrowed=? WHERE isbn = ? AND copyNum = ?"); //update isBorrowed to false in books table
                 // set the preparedstatement parameters
                ps2.setBoolean(1,false);
                ps2.setInt(2, isbn);
                ps2.setInt(3, copyNum);
                // call executeUpdate to execute our sql update statement
               int no=ps2.executeUpdate();
                //delete data from table?? look in mazeget
                String deleteSQL = "DELETE FROM borrowT WHERE isbn = ? and copyNum=?"; //delete borrow in borrow table
                PreparedStatement pst = con.prepareStatement(deleteSQL);
                pst.setInt(1, isbn);
                pst.setInt(2, copyNum);
                
                int nor = pst.executeUpdate();
                System.out.println(nor);//num of rows updated     
           //     ps2.close();

            }
            con.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
      //  Search s=new Search(st,bookList);
        return st;      
        
    }
    
    
}
