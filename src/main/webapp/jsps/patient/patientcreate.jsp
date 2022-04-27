<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Patient Create</title>
    
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
  <h1>Patient Create</h1>
<form action="<c:url value='/PatientServletCreate'/>" method="post">
	Patient ID    :<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id}</span>
	<br/>
	Age    :<input type="text" name="age" value="${form.age }"/>
	<span style="color: red; font-weight: 900">${errors.age}</span>
	<br/>
	Vaccination Status:<input type="text" name="vaccination_status" value="${form.vaccination_status }"/>
	<span style="color: red; font-weight: 900">${errors.vaccination_status }</span>
	<br/>
	Hospitalization Date	：<input type="text" name="hospitalization_date" value="${form.hospitalization_date }"/>
	<span style="color: red; font-weight: 900">${errors.hospitalization_date }</span>
	<br/>
	<input type="submit" value="Create Patient"/>
</form>
  </body>
</html>
