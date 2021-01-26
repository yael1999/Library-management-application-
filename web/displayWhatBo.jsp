<%-- 
    Document   : displayWhatBo
    Created on : 10/01/2021, 14:57:57
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
         <%
            //  ArrayList<String>list=(ArrayList<String>)session.getAttribute("booktodisplay");
            String mstr=(String)session.getAttribute("whatBo"); %>
            
            <h1><%=mstr%></h1>
    </body>
</html>
