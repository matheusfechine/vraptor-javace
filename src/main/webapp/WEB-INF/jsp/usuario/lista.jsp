<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<a href="<c:url value='/usuario/'/>">Adiciona</a>
	
	<br/><br/>
	
	<c:forEach var="usuario" items="${usuarios}">
	    <div>${usuario.login}</div><br />
	</c:forEach>
	
</body>
</html>