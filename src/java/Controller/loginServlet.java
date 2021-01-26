package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/**
 *
 * @author יעל כץ
 */

@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    
   
    Connection con;
    Statement stmt;
    String email,password;
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        HttpSession mysession=request.getSession();
      // mysession.setAttribute("booktodisplay",bookList);
         String email = request.getParameter("email");
         String pass = request.getParameter("password");
        String name="";
        if(Validate.checkUser(email, pass))
       
        {
            name=Validate.giveMyName(email, pass);
            mysession.setAttribute("myName",name);
            RequestDispatcher rs = request.getRequestDispatcher("main.jsp");
            rs.forward(request, response);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  


   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
