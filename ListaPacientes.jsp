<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Imprimir</title>
</head>

<% 
    List<pacientes> lospacientes=(List<pacientes>) request.getAttribute("LISTAPACIENTES");
    %>

<body>

    <% lospacientes %>

</body>

</html>