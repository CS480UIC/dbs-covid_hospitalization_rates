<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Employee</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Update Employee</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Employee ID    :<input type="text" name="employee_id1" value="${employee.employee_id }" disabled/>
	<br/>
	
	Name: <input type="text" name="name1" value="${employee.name }" disabled />
	<br/>
	Department	：<input type="text" name="department1" value="${employee.department }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="username" value="${employee.employee_id }"/>
	Name: <input type="text" name="name" value="${form.name }"/>
	<span style="color: red; font-weight: 900">${errors.name }</span>
	<br/>
	Department	：<input type="text" name="department" value="${form.department }"/>
	<span style="color: red; font-weight: 900">${errors.department }</span>
	<br/>
	<input type="submit" value="Update Department"/>
</form>

</body>
</html>
