<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
	<div align="center" style="background-color: #684D91; height: 100px; vertical-align: middle;">
		<h1 style="display: inline-block; color: white"><a href="/">Contact</a></h1>
	</div>
	<nav class="navbar navbar-default">
	   <ul class="nav navbar-nav navbar-left">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Change Entity <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="/contact/page">Contact</a></li>
            <li><a href="/product/page">Product</a></li>
          </ul>
        </li>
      </ul>
	</nav>
	<div align="center" style="margin-top: 10px">
		<button id="addCnt" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addContactModal">Add Contact</button>
	</div>
	<div style="padding: 1%">
		<table id="contacts" class="table table-striped table-bordered dataTable no-footer">
			<thead>
				<tr>
					<th>Index</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone</th>
					<th>Adress</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	
	<div class="modal fade" id="addContactModal" tabindex="-1" role="dialog" aria-labelledby="addContactModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="addContactModalLabel">Add Contact</h4>
		        <h4 class="modal-title" style="display: none;" id="updateContactModalLabel">Update Contact</h4>
		      </div>
		      <div class="modal-body">
		        <form role="form" name="contactForm" id="contactForm">
		        	<input type="hidden" name="id" id="id"/>
				  <div class="form-group">
				    <label for="firstName">First Name</label>
				    <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter First Name">
				  </div>
				  <div class="form-group">
				    <label for="lastName">Last Name</label>
				    <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter Last Name">
				  </div>
				  <div class="form-group">
				    <label for="phone">Phone</label>
				    <input type="text" name="phone" class="form-control" id="phone" placeholder="Enter Phone">
				  </div>
				  <div class="form-group">
				    <label for="adress">Adress</label>
				    <input type="text" name="adress" class="form-control" id="adress" placeholder="Enter Adress">
				  </div>
				</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" style="display: none;" id="updateContactB">Update</button>
		        <button type="button" class="btn btn-primary" id="addContactB">Add</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>
  		</div>
	</div>
	
	<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.4/js/jquery.dataTables.js"></script>
	<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://jqueryvalidation.org/files/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/contact.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.maskedinput.js'/>"></script>
</body>
</html>
