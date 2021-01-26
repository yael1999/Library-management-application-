<%-- 
    Document   : returnBook
    Created on : 04/01/2021, 14:10:50
    Author     : יעל כץ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body{
                background-image: url('http://4.bp.blogspot.com/-Nwl976knNZU/VNyNZtS9qGI/AAAAAAAAAmU/mR2Dm2t6Y_c/s1600/Beautiful%2BBooks%2B4.jpg');
            }
        </style>
    </head>
    <body>
        <% String name=(String)session.getAttribute("myName");%>
       <header class="h1" style="color:white;font-size:50px;background-color: #663046; ">Let's return your book!!!,<%=name%></header>
       <br><br>
       <form method="post" action="returnServlet">
           <label  style="color:white;font-size:20px;" class="input" for="label1">Press to see the list of your borrowed books</label>
           <br>
           <label style="color:white;font-size:20px;"  class="input" for="label2">and choose wich ones to return</label>
           <br>
          <%-- <label  style="color:white;font-size:20px;" for="name">Enter your name</label>
            <input type="text" id="name" name="myname">--%>
            <br>
            <br>
            <input type="submit">
       </form>
       <%-- Comment --%>
      
       <br>
       <br>
        
         <div class="returnHomeButton">
            <button> <a href="main.jsp"> return to home page</a></button>
        </div>
    </body>
</html>

