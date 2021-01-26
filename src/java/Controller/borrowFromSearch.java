package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.Borrow;
import MODEL.Book;
import MODEL.hashala;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(urlPatterns = {"/borrowFromSearch"})
public class borrowFromSearch extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet borrowFromSearch</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet borrowFromSearch at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
        HttpSession session=request.getSession();
     List<Book>BooksList=new ArrayList<Book>();
     String m="";
      String name=(String)session.getAttribute("myName");
        BooksList=(List<Book>)session.getAttribute("booktodisplay");//all books returning from search
        String [] names=request.getParameterValues("booknames");// will contain the strings only for the presses books!
        List<String> BooksListNames = new ArrayList<String>();
            for(int j=0;j<BooksList.size();j++){
                Book gr=BooksList.get(j);
            BooksListNames.add(gr.toString());
        }//will contain all book strings of founf books
            for(int i=0;i<names.length;i++){
               int index=BooksListNames.indexOf(names[i]);// index of pressed item in all borrowed bookslist
               Book b= BooksList.get(index);
               int isbn=b.getIsbn();
               boolean c=Borrow.borrow(isbn,b.getCopyNum(),name);;
                m=m+"Book number "+index + " was borrowed successfully\n";
            }
            
             session.setAttribute("whatBo",m);
          request.getRequestDispatcher("displayWhatBo.jsp").forward(request, response);
   
      // out.println(m);
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
