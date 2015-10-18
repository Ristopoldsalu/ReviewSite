<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring4 MVC -HelloWorld</title>
<style type="text/css">

#heading {
	
  	height:10%;
  	width:100%;
  	border: 1px;
  	padding: 10px;
}

#menu {
	width:30%;
  	height:90%;
  	float:left;
  	border: 1px;
  	background-color:blue;
}

#content {
	width:70%;
  	height:80%;
  	float:left;
  	border: 1px;
  	background-color:red;
}
</style>
</head>
<body>
<div id="heading">
	<h1>Hello : ${name}</h1>
</div>
<div id="menu">
	
	<table border="1" >
		<c:forEach items="${typeOfPlaces}" var="place">
		    <tr>      
		        <td><a href="/WebReviewApp/change?name=${place}">${place}</a></td>
		        
		    </tr>
		</c:forEach>
	</table>
</div>
<div id="content">
	<c:if test="${businesses != null}">
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
	</c:if>
</div>
</body>
</html>