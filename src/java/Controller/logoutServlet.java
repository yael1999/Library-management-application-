package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(urlPatterns = {"/logoutServlet"})
public class logoutServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      //  HttpSession session = request.getSession(false);
     //   if(session!=null)
      //  session.invalidate();
       //   request.getRequestDispatcher("logout.jsp").forward(request, response);
          
       // try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
      //      out.println("<!DOCTYPE html>");
          // out.println("<html>");
      //      out.println("<head>");
      //      out.println("<title>Servlet logoutServlet</title>");            
      //      out.println("</head>");
            //out.println("<body>");
           // out.println("<h1> " + request.getContextPath() + "</h1>");
         //  out.println("</body>");
           // out.println("</html>");
    //    }   
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.invalidate();
        request.getRequestDispatcher("logout.jsp").forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
