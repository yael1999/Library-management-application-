package Controller;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import MODEL.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
 

/**
 *
 * @author יעל כץ
 */


public class Search {
     ArrayList<String>bookList1=new ArrayList <String>();
        boolean st1 =false;
        
    public Search(boolean b, ArrayList l){
        this.st1=b;
        this.bookList1=l;
        }
    
   // public static ArrayList<String> search(String desc) 
    public static List<Book> search(String desc) 
    {
        
        ArrayList<String>bookList=new ArrayList <String>();// be
       List <Book> allBooks=new ArrayList<Book>();//lim
     //   boolean st = false;//nisui//this value is the return value, why?????
        Connection con = null;
        try {

            //loading drivers for mysql
          //  Class.forName("com.derby.jdbc.Driver");
          Class.forName("org.apache.derby.jdbc.ClientDriver");
            //creating connection with the database
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HW3","yael","yael");
            PreparedStatement ps = con.prepareStatement("select * from booksT where bookName=? or bookAuthor=? or category=?");
            ps.setString(1, desc);
            ps.setString(2, desc);
            ps.setString(3, desc);
      //       ps.setInt(4,10);
            ResultSet rs =ps.executeQuery();//all records found
          //  st = rs.next();//whether any records were found//why never changes to true?????
            while(rs.next()){
                String bookname = rs.getString("bookName");
                String bookauthor = rs.getString("bookAuthor");
                int copyNum = rs.getInt("copyNum");
                boolean isBorrowed=rs.getBoolean("isBorrowed");
                int isbn=rs.getInt("isbn");
            //   String info=bookname+ "," + bookauthor +","+copyNum;//m
               MODEL.Book book=new Book(bookname,bookauthor,copyNum,isBorrowed,isbn); //lim
              //  bookList.add(info);
                allBooks.add(book);
            }
            con.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
      //  Search s=new Search(st,bookList);
        return allBooks;                 
    }
}
