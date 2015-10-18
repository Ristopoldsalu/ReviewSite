<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Evaluation</title>
</head>
<body>
	
    <form:form method="POST" action="addComment" >
    	<table>
    		<tr>
    			<td>
    				<h1>${name}</h1>
    			</td>
    		</tr>
    		<tr>
    			<td><form:label path="personName">Enter name: </form:label></td>
        		<td><form:input path="personName" /></td>
			</tr>
			<tr>
				<td><form:label path="comment">Enter your comment: </form:label></td>
        		<td><form:input path="comment" /></td>
			</tr>
			<tr>
				<td><form:label path="grade">Grade: </form:label></td>
       			<td><form:select path="grade">
    					<form:options items="${numbers}" />
					</form:select>
       			</td>
			</tr>
			<tr>
				<td colspan="2">
            	<input type="submit" value="Submit"/>
       			</td>	
			</tr>
			<tr>
				<td colspan="2">
            		<a href="/WebReviewApp/hello?name=${business.typeOfPlace}">Back</a>
       			</td>	
			</tr>
		</table>
	</form:form>
</body>
</html>
