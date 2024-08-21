<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
</head>
<body>

	<h1>Clientes</h1>
	
			
				<button onclick="window.location.href='/ismac-inventario-web/clientes/findOne?opcion=1'; return false;"> Agregar </button>
	
	<table>
			<thead>
				<tr> 
			
					<th>  ID  </th>
					<th>Nombre </th>
					<th>Direccion </th>
					<th>Telefono </th>
					<th>Email </th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${clientes}"> 
				<tr>
						<td> ${item.idclientes}</td>
						<td> ${item.nombre}</td>
						<td> ${item.direccion}</td>
						<td> ${item.telefono}</td>
						<td> ${item.email}</td>
						
						 <td>
                    <!-- Formulario para actualizar -->
                    <form action="${pageContext.request.contextPath}/clientes/findOne" method="get" style="display:inline;">
					    <input type="hidden" name="idcliente" value="${item.idclientes}" />
					    <input type="hidden" name="opcion" value="1" />
					    <button type="submit">Actualizar</button>
					</form>


                    <!-- Formulario para eliminar -->
                    <form action="${pageContext.request.contextPath}/clientes/del" method="get" style="display:inline;" onsubmit="return confirm('¿Estás seguro de que deseas eliminar este cliente?');">
					    <input type="hidden" name="idcliente" value="${item.idclientes}" />
					    <button type="submit">Eliminar</button>
					</form>

				</tr>
			</c:forEach>
			</tbody>
	</table>
			
			
</body>
</html>