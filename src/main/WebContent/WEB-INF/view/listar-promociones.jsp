<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Promociones</title>
</head>
<body>

	<h1>Promociones</h1>
	
			<button onclick="window.location.href='/ismac-inventario-web/promociones/findOne?opcion=1'; return false;"> Agregar </button>
	
	<table>
			<thead>
				<tr> 
			
					<th>idPromocion </th>
					<th>Nombre </th>
					<th>Descuento </th>
					<th>FechaInicio </th>
					<th>FechaFin </th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${promociones}"> 
				<tr>
				
						<td> ${item.idPromocion}</td>
						<td> ${item.nombre}</td>
						<td> ${item.descuento}</td>
						<td> ${item.fechaInicio}</td>
						<td> ${item.fechaFin}</td>
						
						
					 <td>
                    <!-- Formulario para actualizar -->
                    <form action="${pageContext.request.contextPath}/promociones/findOne" method="get" style="display:inline;">
                        <input type="hidden" name="idpromocion" value="${item.idPromocion}" />
                        <input type="hidden" name="opcion" value="1" />
                        <button type="submit">Actualizar</button>
                    </form>

                    <!-- Formulario para eliminar -->
                    <form action="${pageContext.request.contextPath}/promociones/del" method="get" style="display:inline;" onsubmit="return confirm('¿Estás seguro de que deseas eliminar esta promoción?');">
                        <input type="hidden" name="idpromocion" value="${item.idPromocion}" />
                        <button type="submit">Eliminar</button>
                    </form>
						
				</tr>
			</c:forEach>
			</tbody>
	</table>
			
			
</body>
</html>