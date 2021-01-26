<%-- 
    Document   : displayReturnedBooks
    Created on : 05/01/2021, 20:49:47
    Author     : יעל כץ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>State of returned books:</h1>
        <% String m1=(String)session.getAttribute("returnedBooks");%>
        <p>
            <%=m1%>
        </p>
        <div class="returnHomeButton">
            <button> <a href="main.jsp"> return to home page</a></button>
        </div>
    </body>
</html>
