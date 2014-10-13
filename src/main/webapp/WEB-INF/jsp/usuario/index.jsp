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
	
	<br/><br/>
	
	<a href="<c:url value='/usuario/lista'/>">Lista</a>
	
	<br/><br/>
	<form action="<c:url value='/usuario/adiciona'/>" method="post">
		Login: <input type="text" size="20" name="usuario.login"><br/>
		Senha: <input type="password" size="20" name="usuario.senha"><br/>
		
		<input type="submit" name="Salvar">
	</form>
</body>
</html>