<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.wileyedge.model.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Information</title>
    <style>
        body{font-family: Arial, sans-serif;}
/*         .info{margin-top: 20px;} */
        .label{font-weight: bold;}
    </style>
</head>
<body>

		<h2>Student Information</h2>
	    <span class="label">Name:</span> <c:out value="${student.name}" /><br>
	    <span class="label">Age:</span> <c:out value="${student.age}" /><br>
	    <span class="label">Mobile No:</span> <c:out value="${student.mobileNo}" /><br>
	    <span class="label">Address:</span> <c:out value="${student.address}" /><br>













<!--     <h2>Student Information from Request</h2> -->

<%--     <% --%>
<!--          Student student = (Student) request.getAttribute("student"); -->
<%--     %> --%>

<!--     <div class="info"> -->
<%--         <span class="label">Name:</span> <%= student.getName() %><br> --%>
<%--         <span class="label">Age:</span> <%= student.getAge() %><br> --%>
<%--         <span class="label">Mobile No:</span> <%= student.getMobileNo() %><br> --%>
<%--         <span class="label">Address:</span> <%= student.getAddress() %><br> --%>
<!--     </div> -->
    
    	
</body>
</html>
