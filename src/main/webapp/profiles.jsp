<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Profiles</title>
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
	<img src="${pageContext.request.contextPath}/img/createuser.png" style="height: 80px;" />
	<hr />
	<section>
	 <h4>Employee Profiles</h4>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>SNo</th>
          <th>Empid</th>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Photo</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${employeeEntityList}" var="item" varStatus="counter">
      <tr>
        <td>${counter.count}</td>
        <td>${item.empid}</td>
        <td>${item.name}</td>
        <td>${item.email}</td>
          <td>${item.gender}</td>
        <td>${item.gender}</td>
          <td>C soon</td>
        <td><a href="${pageContext.request.contextPath}/deleteEmployee?rowid=${item.rowid}"><img src="${pageContext.request.contextPath}/img/delete-test-icon.png"/></a></td>
      </tr>
      </c:forEach>
     <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
     <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
          <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </tbody>
  </table>
	
		<hr/>
			<span style="color:green;font-size: 18px;"  id="pstatus">${appstatus}</span>
	</section>
	</div>

</body>
</html>