<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Palindom</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
	<header style="background-color: pink; height: 30px;"> Welcome
		@ BizService </header>
	
	<div class="container">
	<img src="img/login.png" style="height: 100px;" />
	<hr />
	<section>
		<!--
		http://localhost:8080/spring-kb/ check
		 -->	
		<form name="mathform" action="${pageContext.request.contextPath}/check" method="get">
		<table>
			<tr>
				<td>Enter Name :&nbsp;&nbsp;&nbsp;</td>
				<td>
				<input type="text" name="username" style="width: 300px;" class="form-control"/>
					<span style="color:red;font-size: 16px;"  id="usernameError"></span>
				</td>
			
				<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			</tr>
				<tr>
				<td>&nbsp;</td>
				<td><button type="submit" class="btn btn-primary">Check String</button></td>
			</tr>
		</table>
		</form>
		<hr/>
		<span style="color:green;font-size: 18px;"  id="pstatus">${appstatus}</span>
	</section>
	</div>

</body>
</html>