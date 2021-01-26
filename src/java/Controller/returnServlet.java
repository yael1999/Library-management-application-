package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MODEL.Book;
import MODEL.hashala;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author יעל כץ
 */
@WebServlet(urlPatterns = {"/returnServlet"})
public class returnServlet extends HttpServlet {
 public static List<hashala> myBorrowedBooks=new ArrayList<hashala>();
 
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet returnServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet returnServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         HttpSession mysession=request.getSession();
         String name=(String)mysession.getAttribute("myName"); //contains "yael" only if we went through login servlet!!!!
       // String name=request.getParameter("myname");
        List<hashala>bookList=Return.make(name); // all books matchimg borrowerName return from data base
        if(bookList.size()!=0)
        {
            mysession.setAttribute("borrowedBooks",bookList);
        //    myBorrowedBooks=(List<hashala>)mysession.getAttribute("borrowedBooks");
            //RequestDispatcher rs = request.getRequestDispatcher("search.html");
           // rs.forward(request, response);
          //  out.println(bookList);
          request.getRequestDispatcher("displayBorrowedBooks.jsp").forward(request, response);
          
        }
        else
        {
           out.println("you borrowed no books!");
           
        } 
    }
   
      
    //    for(int i=0;i< borrowedBooksList.size();i++){
        //  if(request.getParameter("names") == null){
         // continue; //wasn't pressed

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         HttpSession mysession=request.getSession();
         String name=(String)mysession.getAttribute("myName"); //contains "yael" only if we went through login servlet!!!!
       // String name=request.getParameter("myname");
        List<hashala>bookList=Return.make(name); // all books matchimg borrowerName return from data base
        if(bookList.size()!=0)
        {
            mysession.setAttribute("borrowedBooks",bookList);
        //    myBorrowedBooks=(List<hashala>)mysession.getAttribute("borrowedBooks");
            //RequestDispatcher rs = request.getRequestDispatcher("search.html");
           // rs.forward(request, response);
          //  out.println(bookList);
          request.getRequestDispatcher("displayBorrowedBooks.jsp").forward(request, response);
          
        }
        else
        {
           out.println("you borrowed no books!");
           
        }   
    }
   
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
