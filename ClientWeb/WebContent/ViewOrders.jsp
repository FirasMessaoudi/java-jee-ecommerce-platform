<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="http://fonts.googleapis.com/css?family=Lato:100italic,100,300italic,300,400italic,400,700italic,700,900italic,900" rel="stylesheet" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css" ></link>
	<link rel="stylesheet" type="text/css" href="assets/css/styles.css" ></link>
	
<body>
<section class="container login-form">
		<section>
			<form method="post" action="ControlCommande" role="login">
				<img src="assets/images/login.png" alt="" class="img-responsive" />
			
				<div class="form-group">
					<input type="text" name="login" required="required" class="form-control" placeholder="Enter email or nickname" />
					<span class="glyphicon glyphicon-user"></span>
				</div>
				
				<div class="form-group">
					<input type="password" name="password" required="required" class="form-control" placeholder="Enter password" />
					<span class="glyphicon glyphicon-lock"></span>
				</div>
				
				<button type="submit" name="action" class="btn btn-primary btn-block">Login Now</button>
				
			    <a href="ControlServlet">Go Backt</a> 
			</form>
		</section>
	</section>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</body>
</html>