<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Country</title>
    
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
  <h1>Update Country</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Country ID    :<input type="text" name="country_id1" value="${country.country_id1 }" disabled/>
	<br/>
	
	Country Name:<input type="text" name="country_name1" value="${country.country_name1 }" disabled />
	<br/>
	Population	：<input type="text" name="population1" value="${country.population1 }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/Entity1ServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="country_id" value="${country.country_id }"/>
	Country Name:<input type="text" name="country_name" value="${form.country_name }"/>
	<span style="color: red; font-weight: 900">${errors.country_name }</span>
	<br/>
	Population：<input type="text" name="population" value="${form.population }"/>
	<span style="color: red; font-weight: 900">${errors.population }</span>
	<br/>
	<input type="submit" value="Update Country"/>
</form>

</body>
</html>
