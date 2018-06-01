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
  <script type="text/javascript">
  		function openModal(rowid) {
  				
	  			var row = document.getElementById(rowid);
  				//this code for second column for selected row
  			 	var col1 = row.cells[1];
  				var empid=col1.innerHTML;
  				$("#empid").val(empid);
  				
  			   //this code for third column for selected row
  			 	var col2 = row.cells[2];
  				var name=col2.innerHTML;
  				$("#name").val(name);
  				
  			//this code for third column for selected row
  			 	var col3 = row.cells[3];
  				var email=col3.innerHTML;
  				$("#email").val(email);
  				
  			//this code for third column for selected row
  			 	var col4 = row.cells[4];
  				var gender=col4.innerHTML;
  				$("#gender").val(gender);
  				
  			//this code for third column for selected row
  			 	var col5 = row.cells[5];
  				var address=col5.innerHTML;
  				console.log("address -"+address);
  				//$("#address").html(address);
  				$("#address").val(address);
  				
		    	$('#editEmployeeModal').modal('show'); 
  		}
  
  </script>
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
	 <span style="color:green;font-size: 18px;" id="pmessage">${param.appstatus}</span>
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
      <tr  id="${item.rowid}">
        <td>${counter.count}</td>
        <td>${item.empid}</td>
        <td>${item.name}</td>
        <td>${item.email}</td>
          <td>${item.gender}</td>
        <td>${item.address}</td>
          <td><img src="${pageContext.request.contextPath}/load-image?imageid=${item.rowid}" style="height: 60px;"/></td>
        <td><a href="${pageContext.request.contextPath}/deleteEmployee?rowid=${item.rowid}"><img src="${pageContext.request.contextPath}/img/delete-test-icon.png"/></a>
       		 &nbsp;&nbsp;
        <a href="javascript:openModal(${item.rowid});"><img src="${pageContext.request.contextPath}/img/edit.png"/></a>
        </td>
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
    </tbody>
  </table>
	
		<hr/>
			<span style="color:green;font-size: 18px;"  id="pstatus">${appstatus}</span>
	</section>
	</div>
	
	<!-- The Modal -->
<div class="modal" id="editEmployeeModal">
  <div class="modal-dialog">
    <div class="modal-content" style="width: 700px;background-image: url('img/backgrounds.jpg');">
      <!-- Modal Header -->
      <div class="modal-header">
              <h4 class="modal-title"><span id="pagetitle">Edit Employee Profile</span>
               <img src="img/profile.png" style="height: 40px;">
              </h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
         <span style="color:red;font-size: 18px;" id="pmessage">${param.appstatus}</span>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
     						<form  id="editEmployeeForm"  name="editEmployeeForm" action="${pageContext.request.contextPath}/update-employee" method="post">
									  <div class="form-group">
									  	 <input type="hidden" name="rowid" id="rowid">
									    <label for="empid">Empid</label>
									 	   <input type="text" class="form-control" id="empid" name="empid" readonly="readonly">
									  </div>
									  
									  <div class="form-group">
									    <label for="name">Name:</label>
									    <input type="text" class="form-control" id="name" name="name" onkeyup="clearErrorMessage();">
									  </div>
									  
									    
									  <div class="form-group">
									    <label for="email">email:</label>
									    <input type="email" class="form-control" id="email" name="email" onkeyup="clearErrorMessage();">
									  </div>
									  
									  	  
									   <div class="form-group">
									    <label for="address">Gender:</label>
									    	<select class="form-control" id="gender" name="gender">
									    			<option>Male</option>
									    			<option>Female</option>
									    	</select>
									  </div>
									  
									  <div class="form-group">
									    <label for="address">address:</label>
									 <textarea name="address" cols="50" rows="2"  id="address"  class="form-control"></textarea>
									  </div>
									  	  <div class="form-group">
									    <label for="image">Image:</label>
									    <input type="file" class="form-control" id="photo" name="photo"/>
									  </div>
									      <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
         					<button type="submit" class="btn btn-primary"   id="updateProductBt">Update</button>
									  
		</form>
      </div>
    </div>
  </div>
</div>

</body>
</html>