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
  <h1>Delete Country</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/CountryServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="country_id" value="${country.countryID }"/>
	Country ID: <input type="text" name="country_id" value="${country.countryID }" disabled/>
	<br/>
	
	Country Name:<input type="text" name="country_name" value="${country.country_name }" disabled/>
	<br/>
	Population:<input type="text" name="population" value="${country.population }" disabled/>
	<br/>
	<input type="submit" value="Delete Country"/>
</form>

</body>
</html>
