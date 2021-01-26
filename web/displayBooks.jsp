<%-- 
    Document   : displayBooks
    Created on : 27/12/2020, 20:54:13
    Author     : יעל כץ
--%>
<%@page import="java.util.List"%>
<%@page import="MODEL.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        
        <h1>Books are: </h1>
        
            
        <form method="get" action="borrowFromSearch">
        
          <%
            //  ArrayList<String>list=(ArrayList<String>)session.getAttribute("booktodisplay");
            List<Book>list=(List<Book>)session.getAttribute("booktodisplay");
            String color="";
              for(int i=0;i<list.size();i++){
                  if(list.get(i).isIsBorrowed()){
                      color="red";}   //red for borrowed books
                  else {color="green";}  //green for not borrowed books
                %>
                <% if (list.get(i).isIsBorrowed()){%>
                 <li style="color:<%=color%> "><%=list.get(i)%></li>
                 <%} else {%>
            <%--     <li style="color:<%=color%> "><a href="borrowBook.jsp"><%=list.get(i)%>></li> --%>
                  <input type="checkbox" style="color:<%=color%> " name="booknames" value="<%=list.get(i)%>" id="ch<%=i%>"><%=list.get(i)%> <br>
            <%--    <li style="color:<%=color%> "><a href="borrowServlet"><%=list.get(i)%>></li> --%>
                <%}%>
                <%
                    }
                %>   
                <br>
         <input type="submit">
         </form>
                <br>
                 <div class="returnHomeButton">
            <button> <a href="main.jsp"> return to home page</a></button>
        </div>
                <%-- Comment --%>
        
        
        
        
        
        <br>  
       
    </body>
</html>
