<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title> Conditions Create</title>
    
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
  <h1> Conditions Create</h1>
<form action="<c:url value='/ConditionsServletCreate'/>" method="post">
	Patient ID    :<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id}</span>
	<br/>
	Conditions Name:<input type="text" name="condition_name" value="${form.condition_name }"/>
	<span style="color: red; font-weight: 900">${errors.condition_name }</span>
	<br/>
	Condition ID:<input type="text" name="condition_id" value="${form.condition_id }"/>
	<span style="color: red; font-weight: 900">${errors.condition_id }</span>
	<br/>
	
	<input type="submit" value="Create Conditions"/>
</form>
  </body>
</html>
