<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/theme1/mainView.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring4 MVC -HelloWorld</title>
</head>
<body>
<div id="heading">
	<h1>${name}</h1>
	<div>
	</div>
</div>
<div id="menu">
	
	<table id="menuTable" border="1" >
		<c:forEach items="${typeOfPlaces}" var="place">
		    <tr class="place" onclick="document.location ='change?name=${place}';">      
		        <td>${place}</td>
		        
		    </tr>
		</c:forEach>
	</table>
</div>
<div id="content">
	<c:choose>
		<c:when test="${businesses != null}">
			<table border="1" >
				<c:forEach items="${businesses}" var="business">
				    <tr onclick="document.location ='evaluate?name=${business.busName}';">      
				        <td>${business.busName}</td>
				        <td>${business.address}</td>
				        <td>${business.averageScore}</td>
				        <td>${business.timesGraded}</td>
				    </tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h2 align="center">Please choose type of place.</h2>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>