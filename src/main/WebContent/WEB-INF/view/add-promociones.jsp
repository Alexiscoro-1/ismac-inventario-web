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
 
 
		<form action="${pageContext.request.contextPath}/promociones/add" method="post">
>
		
        <input type="hidden" id="idPromocion" name="idPromocion" value="${promocion.idPromocion}">
        <br/>
        Nombre:
        <input type="text" id="Nombre" name="Nombre" value="${promocion.nombre}">
        <br/>
        Descuento:
        <input type="number" id="Descuento" name="Descuento" value="${promocion.descuento}" step="0.01">
        <br/>
        Fecha de Inicio:
        <input type="date" id="FechaInicio" name="FechaInicio" value="${fn:substring(promocion.fechaInicio,0,10)}">
        <br/>
        Fecha de Fin:
        <input type="date" id="FechaFin" name="FechaFin" value="${fn:substring(promocion.fechaFin,0,10)}">
        <br/>
        
        
        <button type="submit">Guardar</button>
        <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/promociones/findAll'; return false;">Cancelar</button>



 </form>
</body>
</html>