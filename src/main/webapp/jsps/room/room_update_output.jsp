<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Room</title>
    
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
  <h1>Update Room</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Room Number    :<input type="text" name="room_number" value="${room.room_number }" disabled/>
	<br/>
	
	Patient ID:<input type="text" name="patient_id" value="${room.patient_id }" disabled />
	<br/>
	Employee ID	：<input type="text" name="employee_id" value="${room.employee_id }" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/RoomServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
				<input type="hidden" name="room_number" value="${room.room_number }"/>
	Patient ID:<input type="text" name="patient_id" value="${form.patient_id }"/>
	<span style="color: red; font-weight: 900">${errors.patient_id }</span>
	<br/>
	Employee ID	：<input type="text" name="employee_id" value="${form.employee_id }"/>
	<span style="color: red; font-weight: 900">${errors.employee_id }</span>
	<br/>
	<input type="submit" value="Update Room"/>
</form>

</body>
</html>
