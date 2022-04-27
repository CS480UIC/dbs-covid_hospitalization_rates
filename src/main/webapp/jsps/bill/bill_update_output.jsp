<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	<input type="hidden" name="bill_id" value="${bill.bill_id }"/>
	Bill ID    :<input type="text" name="bill_id1" value="${bill.bill_id }" disabled/>
	<br/>
	Cost    :<input type="text" name="cost1" value="${bill.cost }" disabled/>
	<br/>
	Patient ID：<input type="text" name="patient_id1" value="${bill.patient_id }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/billServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
	Bill ID    :<input type="text" name="bill_id" value="${form.bill_id }" disabled/>
		<span style="color: red; font-weight: 900">${errors.bill_id }</span>
	<br/>
	Cost    :<input type="text" name="cost" value="${form.cost }" disabled/>
		<span style="color: red; font-weight: 900">${errors.cost }</span>
	<br/>
	Patient ID：<input type="text" name="patient_id" value="${form.patient_id }" disabled/>
		<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	<input type="submit" value="Update bill"/>
</form>

</body>
</html>
