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
	Hospital ID   :<input type="text" name="hospital_id1" value="${hospital.hospital_id }" disabled/>
	<br/>
	Hospital Address   ：<input type="text" name="hospital_address1" value="${hospital.hospital_address }" disabled/>
	<br/>
	Hospital Name	：<input type="text" name="hospital_name1" value="${hospital.hospital_name }" disabled/>
	<br/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/hospitalServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
		<input type="hidden" name="hospital_id" value="${hospital.hospital_id }"/>
	Hospital ID   :<input type="text" name="hospital_id" value="${form.hospital_id }" disabled/>
		<span style="color: red; font-weight: 900">${errors.hospital_id }</span>
	<br/>
	Hospital Address   ：<input type="text" name="hospital_address" value="${form.hospital_address }" disabled/>
		<span style="color: red; font-weight: 900">${errors.hospital_address }</span>
	<br/>
	Hospital Name	：<input type="text" name="hospital_name" value="${form.hospital_name }" disabled/>
		<span style="color: red; font-weight: 900">${errors.hospital_name }</span>
	<br/>
	<input type="submit" value="Update hospital"/>
</form>

</body>
</html>
