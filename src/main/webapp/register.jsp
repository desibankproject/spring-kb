<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Form</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<header style="background-color: white; height: 146x;">
			<img alt="" src="${pageContext.request.contextPath}/img/header.jpg" style="width: 1170px;">
		</header>
	<hr/>	
	<img src="${pageContext.request.contextPath}/img/users_delete.png" style="height: 80px;margin-right: 50px;" />
	<a href="${pageContext.request.contextPath}/profiles"><img src="${pageContext.request.contextPath}/img/createuser.png" style="height: 80px;" /></a>
	<hr />
	<section>
		<!--
		http://localhost:8080/spring-kb/ check
		 -->	
		<form name="mathform" action="${pageContext.request.contextPath}/register-employee" method="post">
		<table>
		
		<tr>
				<td>Empid :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<input type="text" name="empid" style="width: 300px;" class="form-control"/>
					<span style="color:red;font-size: 16px;"  id="empidError"></span>
				</td>
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			<tr>
				<td>Name :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<input type="text" name="name" style="width: 600px;" class="form-control"/>
					<span style="color:red;font-size: 16px;"  id="nameError"></span>
				</td>
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
			
				<tr>
				<td>Email :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<input type="text" name="email" style="width: 600px;" class="form-control"/>
					<span style="color:red;font-size: 16px;"  id="emailError"></span>
				</td>
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
				<tr>
				<td>Gender :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<select name="gender" style="width: 300px;display: inline;" class="form-control">
					<option>Male</option>
					<option>Female</option>
				</select>
				&nbsp;&nbsp;&nbsp;
				Photo : 
				&nbsp;&nbsp;&nbsp;
				<input type="file" name="photo" style="width: 300px;display: inline;" class="form-control"/>
				</td>
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
				<tr>
				<td>Address :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<textarea name="address" cols="50" rows="2"  class="form-control"></textarea>
				</td>
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
				<tr>
				<td>&nbsp;</td>
				<td><button type="submit" class="btn btn-primary">Register Employee</button></td>
			</tr>
		</table>
		</form>
		<hr/>
			<span style="color:green;font-size: 18px;"  id="pstatus">${appstatus}</span>
	</section>
	</div>

</body>
</html>