package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/borrowServlet"})
public class borrowServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
       //     out.println("<!DOCTYPE html>");
       //     out.println("<html>");
        //    out.println("<head>");
        //    out.println("<title>Servlet borrowServlet</title>");            
          //  out.println("</head>");
          //  out.println("<body>");
         ////   out.println("<h1>Servlet borrowServlet at " + request.getContextPath() + "</h1>");
          out.println("blaaaa");
       //     out.println("</body>");
       //     out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         int isbn = Integer.parseInt(request.getParameter("isbn"));
         int copyNum = Integer.parseInt(request.getParameter("copyNum"));
        HttpSession mysession=request.getSession();
        //Object test = mysession.getAttributeNames();
         String name=(String) mysession.getAttribute("myName");
         String result="";
     //   String name1=request.getParameter("name");
         boolean st=Borrow.borrow(isbn,copyNum,name);// will say whether the book was alrady borrowed or was borrowed successfully
        if(!st)
        {
            result="Book is borrowed or doesn't exist!";
            mysession.setAttribute("resultF",result);
               request.getRequestDispatcher("borrowResult.jsp").forward(request, response);
       //  out.println("Book is borrowed or doesn't exist!");
        }
        else
        {
         result="Book was found and borrowed successfully!";
            mysession.setAttribute("resultS",result);
               request.getRequestDispatcher("borrowResult.jsp").forward(request, response);
       //   out.println("Book was found and borrowed successfully!");
         
        }

        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
