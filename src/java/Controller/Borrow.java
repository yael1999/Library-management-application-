package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


/**
 *
 * @author יעל כץ
 */

public class Borrow {
    public static boolean borrow(int isbn,int copyNum,String name) 
    {
        
       boolean st=false;//wether any records were found
     //   boolean st = false;//nisui//this value is the return value, why?????
     boolean b=false;//to be used in query
        Connection con = null;
        try {

            //loading drivers for mysql
          //  Class.forName("com.derby.jdbc.Driver");
          Class.forName("org.apache.derby.jdbc.ClientDriver");
            //creating connection with the database
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HW3","yael","yael");
          
            PreparedStatement ps = con.prepareStatement("select * from booksT where isbn=? and copyNum=? and isBorrowed=?");//karagill
            ps.setInt(1, isbn);
            ps.setInt(2,copyNum);
            ps.setBoolean(3,b);
      //       ps.setInt(4,10);
            ResultSet rs =ps.executeQuery();//all records found
          //  st = rs.next();//whether any records were found//why never changes to true?????
          
            if(rs.next()){
                st=true;
                 PreparedStatement ps2 = con.prepareStatement("update booksT SET isBorrowed=? WHERE isbn = ? AND copyNum = ?");
                 // set the preparedstatement parameters
                ps2.setBoolean(1,true);
                ps2.setInt(2, isbn);
                ps2.setInt(3, copyNum);
                // call executeUpdate to execute our sql update statement
               int no=ps2.executeUpdate();
                //insert data into table?? look in mazeget
                PreparedStatement pst = con.prepareStatement("insert into borrowT values (?,?,?)");
                pst.setInt(1, isbn);
                pst.setInt(2, copyNum);
                pst.setString(3,name);
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
