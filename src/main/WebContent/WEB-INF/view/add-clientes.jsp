<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>

<meta charset=""UTF-8"">
<title>Insert title here</title>
</head>
<body>
 
 
		<form action="${pageContext.request.contextPath}/clientes/add" method="post">
>
		
        <input type="hidden" id="idclientes" name="idclientes" value="${promocion.idclientes}">
        <br/>
        Nombre:
        <input type="text" id="Nombre" name="Nombre" value="${clientes.nombre}">
        <br/>
        Direccion:
        <input type="text" id="Direccion" name="Direccion" value="${clientes.direccion}">
        <br/>
        Telefono:
        <input type="text" id="Telefono" name="Telefono" value="${clientes.telefono}">
        <br/>
        Email:
        <input type="text" id="Email" name="Email" value=""${clientes.email}">
        <br/>
        
        
        <button type="submit">Guardar</button>
        <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/clientes/findAll'; return false;">Cancelar</button>



 </form>
</body>
</html>