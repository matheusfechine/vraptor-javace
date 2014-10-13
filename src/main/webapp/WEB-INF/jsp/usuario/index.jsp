<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<c:forEach var="error" items="${errors}">
	    <div>${error.category} - ${error.message}</div><br />
	</c:forEach>
	<form action="<c:url value='/usuario/adiciona'/>" method="post">
		Nome: <input type="text" size="20" name="usuario.nome">
		
		<span class="error"> ${errors.from('usuario.nome')}</span><br/>
		
		e-mail: <input type="text" size="20" name="usuario.email"><br/>
		password: <input type="password" size="20" name="usuario.password"><br/>
		
		<input type="submit" name="salvar">
	</form>
</body>
</html>