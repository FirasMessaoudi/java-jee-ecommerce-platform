<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Client Signup Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="PrduitCSS/css/checkout.css" rel="stylesheet" type="text/css" media="all" />
<!-- //Custom Theme files -->
<!-- web font -->
<link href="//fonts.googleapis.com/css?family=Old+Standard+TT:400,400i,700" rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'><!--web font-->
<!-- //web font -->
</head>
<body>
	<!-- main -->
	<div class="main main-agileits">
		<h1>CheckOut</h1>
		<div class="main-agilerow"> 
			<div class="signup-wthreetop">
				<h2>Sign Up</h2>
				
			</div>	
			<div class="contact-wthree">
				<form action="ControlSignUp" method="post">
					<h3>Step 1 :</h3>
					<div class="form-w3step1">
						<input type="text" name="nom" placeholder="Your Name" required="required"> 
						<input type="email" class="email agileits-btm" name="Email" placeholder="Email" required="required"> 
						
					</div> 
					<h3>Step 2 :</h3>
					<div class="form-w3step1">  
						<input type="text" name="Login" id="phone" placeholder="Login" required="required">
						<input type="password" name="password" id="pass" placeholder="password" required="required">
					      	

					</div>
					<h3>Step 3 :</h3>
					<div class="form-w3step1 w3ls-formrow">
						<input type="text" name="tel" placeholder="Phone number" required="">
						<input type="text" class="agileits-btm" name="adresse" placeholder="Your Adress" required="required">
						
					</div>
					
					<input type="submit" value="Order Now">

				</form>
			</div>  
		</div>	
	</div>	
	<!-- //main -->
	<script type="text/javascript">
		window.onload = function () {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
			document.getElementById("cin").onchange=validateCin;
		}
		function validatePassword(){
			var pass2=document.getElementById("password2").value;
			var pass1=document.getElementById("password1").value;
			if(pass1!=pass2)
				document.getElementById("password2").setCustomValidity("Passwords Don't Match");
			else
				document.getElementById("password2").setCustomValidity('');	 
				//empty string means no validation error
		}
		function validateCin(){
			var c=document.getElementById("cin").value;
			if(c.length()!=8)
				document.getElementById("cin").setCustomValidity("invalid cin");
			else
				document.getElementById("cin").setCustomValidity('');


		}

</script>
	
</body>
</html>