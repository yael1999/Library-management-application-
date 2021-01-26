package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author יעל כץ
 */
public class Validate {
  public static boolean checkUser(String email,String pass) 
    {
        
        boolean st =false;
        Connection con = null;
        String name="";
        try {

            //loading drivers for mysql
          //  Class.forName("com.derby.jdbc.Driver");
          Class.forName("org.apache.derby.jdbc.ClientDriver");
            //creating connection with the database
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/HW3","yael","yael");    
            PreparedStatement ps = con.prepareStatement("select * from studentsT where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
            name=rs.getString("firstName");
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return st;                 
    }
  
  public static String giveMyName(String email,String pass){
      boolean st =false;
        Connection con = null;
        String name="";
        try {

            //loading drivers for mysql
          //  Class.forName("com.derby.jdbc.Driver");
          Class.forName("org.apache.derby.jdbc.ClientDriver");
            //creating connection with the database
      con = DriverManager.getConnection("jdbc:derby://localhost:1527/HW3","yael","yael");
            PreparedStatement ps = con.prepareStatement("select * from studentsT where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
            name=rs.getString("firstName");
            con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return name;
  }
}
