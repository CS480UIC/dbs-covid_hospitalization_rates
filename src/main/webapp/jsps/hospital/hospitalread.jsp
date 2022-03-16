<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read hospital</title>
    
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
  <h1>Read hospital</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/hospitalServletRead'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	Hospital ID  : <input type="text" name="hospital_id" value="${form.hospital_id }"/>
	<span style="color: red; font-weight: 900">${errors.hospital_id }</span>
	<br/>
<%-- 		Hospital Address   ：<input type="text" name="hospital_address" value="${form.hospital_address }" disabled/>
		<span style="color: red; font-weight: 900">${errors.hospital_address }</span>
	<br/>
	Hospital Name	：<input type="text" name="hospital_name" value="${form.hospital_name }" disabled/>
		<span style="color: red; font-weight: 900">${errors.hospital_name }</span>
	<br/> --%>
	<input type="submit" value="Read Hospital"/>
</form>
  </body>
</html>
