package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.Return;
import MODEL.hashala;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/returnServlet2"})
public class returnServlet2 extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet returnServlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet returnServlet2 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session=request.getSession();
     List<hashala>borrowedBooksList=new ArrayList<hashala>();
     String m="";
        borrowedBooksList=(List<hashala>)session.getAttribute("borrowedBooks");//all borrowed books
        String [] names=request.getParameterValues("names");// will contain the strings only for the presses books!
        List<String> borrowedBooksListNames = new ArrayList<String>();
            for(int j=0;j<borrowedBooksList.size();j++){
                hashala gr=borrowedBooksList.get(j);
            borrowedBooksListNames.add(gr.toString());
        }
            for(int i=0;i<names.length;i++){
               int index=borrowedBooksListNames.indexOf(names[i]);// index of pressed item in all borrowed bookslist
                boolean c=Return.returnBook(borrowedBooksList.get(index));
                m=m+ "Book number "+index + " was returned successfully\n";
            }
   //      for(int j=0;j<borrowedBooksList.size();j++){
    //      boolean c=Return.returnBook(borrowedBooksList.get(j));
    //   }
      // m="Return was successfull!";
       session.setAttribute("returnedBooks",m);
       request.getRequestDispatcher("displayReturnedBooks.jsp").forward(request, response);
          
       
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
