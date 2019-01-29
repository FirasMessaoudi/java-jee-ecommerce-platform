<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.*" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulter les produits</title>


<link href="//fonts.googleapis.com/css?family=Cinzel:400,700,900" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900" rel="stylesheet">
<!-- /fonts -->
<!-- css -->
<link href="PrduitCSS/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/gallery.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/jQuery.lightninBox.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/aos.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/index2.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/panier.css" rel="stylesheet" type="text/css" media="all" />

<!-- /css -->
<!-- js -->
<script src="PrduitCSS/js/modernizr.min.js"></script>
<!-- /js -->
<script type="text/javascript">
	
</script>
</head>
<body onload=" header('Location: client.jsp');">
<div class="topbar-w3ls">
	<div class="container">
		<a href="Client.jsp" class="logo">
			<h1>
				TechStore
			</h1>
		</a>		
		<div class="top-agileits">
			<div class="top-w3l1">
				<span class="glyphicon glyphicon-phone-alt"></span> 	
				<p class="agile1">+21650383993</p>
			</div>		
			<div class="top-w3l2">
				<a href="https://www.google.tn/maps/place/Institut+Sup%C3%A9rieur+De+Gestion+De+TUNIS/@36.8042187,10.1514986,15z/data=!4m5!3m4!1s0x0:0xfa7c2e843bea6509!8m2!3d36.8042187!4d10.1514986" target="_blank"><span class="glyphicon glyphicon-map-marker" ></span></a>
				<p class="agileits1">Menzel Bourguiba</p> 
				<p class="agileits2">Bizerte</p>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>	
</div>
<!-- /topbar -->
<!-- navigation -->
<div class="navbar-wrapper">
    <div class="container">
		<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav cl-effect-7">
						<li class="active"><a href="ControlServlet" class="page-scroll">Home</a></li>
						<li><a href="#about" class="page-scroll">About</a></li>
						<li><a href="Login.jsp" class="page-scroll" target="_blank">Check Your Orders</a></li>
						<li><a href="#gallery" class="page-scroll">Our Products</a></li>
						<li><a href="#contact" class="page-scroll">Contact</a></li>
					</ul>
				</div>
			</div>
        </nav>
	</div>
</div>
<!-- /navigation -->
<!-- banner -->
<section class="banner-w3ls"">
		<div id="block">
			<div class="overlay">
				<h2>Shopping online</h2>
				<h3>You won't be able to resist all these offers</h3>
				<p>Our extensive and affordable range features the very latest electronics and gadgets including smart phones, tablets, action cams, tv boxes...</p>
				



			</div>
		</div>	
</section>
<!-- /banner -->
<!-- about -->
<section class="gallery-info" id="gallery" >

	<div class="container">
	<h3 class="text-center" data-aos="zoom-in" style="color: red"><strong>Our Products</strong></h3>
		
		
<c:forEach items="${Produits }" var="p">

<div class="product-item">
			<div class="product-image"><img src="PrduitCSS/produit/${p.photo }"></div>
			<div><strong><td>${p.designation }</td></strong></div>
			<a href="https://www.google.com/search?q=${p.designation }" target="_blank"><strong><font color="red">View More</font></strong></a>
			<div class="product-price"><td>${p.prix }DT</td></div>
			<c:if test="${p.selectionnee==true }">
			<div><strong>En Promo!</strong></div>
			</c:if>
			<div id="qt"><td>${p.quantite } items</td></div>
		  <div><td> <a href="PanierServlet?id=${p.idProduit }&action=addtocart" class="btnAddAction">Add To Cart</a></td>
			</div>
			
</div>
</c:forEach>
<a href="Panier.jsp" target="_blank"><button class="btn btn-outline btn-lg">My cart</button></a>
</div>
</section>
<section class="about-wthree" id="about" >
	<div class="container">
		<div class="col-lg-6 col-md-6 col-sm-12" data-aos="flip-right">
			<h3 class="text-center">About Us</h3>
			<p class="text-center" ><font color="black"><strong>You are looking for a laptop at an unbeatable price or a mobile phone or a Smartphone with ease of payment without a bank account? Find your Laptop, Computer Server and Storage Server on our website. We are specialized in selling high-tech products and we are leading partners with industry leaders in Tunisia like Samsung, Sony, Evertek, Nokia, Huawei, HTC, HP, Dell, Lenovo, Acer, Asus, Lexmark , Epson & Brother. You can order your laptop, Smartphone, Touchscreen, Printer, Printer Accessories, Photocopier, LED Tv, Plasma Tv, Lcd Tv, Household Appliances, Office Suppliers in Tunisia or an Office Computer.</strong></font></p>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-12" data-aos="flip-left">
			<ul class="grid cs-style-1">
				<li>
					<figure>
						<img src="PrduitCSS/images/store3.gif" alt="img01" class="img-responsive">
						<figcaption>
							<a href="PrduitCSS/images/store3.gif" class="lightninBox" data-lb-group="1">View More</a>
						</figcaption>
					</figure>
				</li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
</section>
<!-- /about -->
<!-- gallery -->
<section class="contact-w3-agileits" id="contact">
	<div class="container">
		<h3 class="text-center" data-aos="zoom-in" style="color: #e74c3c" ><strong>GET IN TOUCH</strong></h3>
		
		<div class="col-lg-8 col-md-8 contact-w3l2" data-aos="flip-left">
			<form action="contact.php" method="post">
				<div class="form-group col-md-4 col-sm-4">
					<input type="text" class="form-control" id="name" name="name" placeholder=" Your Name" required  />
				</div>
				<div class="form-group col-md-4 col-sm-4">
					<input type="email" class="form-control" id="email2" name="email2" placeholder="Your Email" required />
				</div>
				<div class="form-group col-md-4 col-sm-4">
					<input type="tel" class="form-control" id="phone" name="phone" placeholder="Your Phone" required />
				</div>
				<div class="clearfix"></div>
				<div class="form-group col-md-12">
					<textarea class="form-control" rows="6" name="message" placeholder="Your Message" required ></textarea>
				</div>
				<div class="form-group col-md-12">
					<button type="submit" class="btn-outline2"><i class="fa fa-check-circle-o" aria-hidden="true"></i> Submit</button>
				</div>
				<div class="clearfix"></div>
			</form>	
		</div>
		<div class="clearfix"></div>
	</div>
</section>
<!-- /contact -->
<!-- footer -->
<section class="footer-w3-agileits">
	<div class="container">
		<div class="col-lg-8 col-md-8">
			<ul class="w3-agile">
				<li><a href="index.php" class="page-scroll">Home</a></li>
				<li><a href="#about" class="page-scroll">About</a></li>
				<li><a href="login.html" class="page-scroll" target="_blank">Log In</a></li>
				<li><a href="#gallery" class="page-scroll">Our Products</a></li>
				<!--<li><a href="#team" class="page-scroll">Team</a></li>-->
				<li><a href="#contact" class="page-scroll">Contact</a></li>
			</ul>
		</div>
		<div class="col-lg-4 col-md-4">
			<ul class="social-icons2">
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-youtube"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
			</ul>	
		</div>
		
	</div>
	<div class="w3footeragile">
		<p align="center"> &copy; 2017 online shopping. All Rights Reserved | created by<strong><font color="blue"> Messaoudi Firas</font></strong></p>
	</div>s


</section>
<!-- /footer -->
<!-- back to top -->
<a href="#0" class="cd-top">Top</a>
<!-- /back to top -->
<!-- js files -->
<!-- js files -->
<script src="PrduitCSS/js/jquery.min.js"></script>
<script src="PrduitCSS/js/bootstrap.min.js"></script>
<script src="PrduitCSS/js/smoothscroll.js"></script>
<script src="PrduitCSS/js/jquery.easing.min.js"></script>
<script src="PrduitCSS/js/grayscale.js"></script>
<script src='PrduitCSS/js/aos.js'></script>
<script src="PrduitCSS/js/index.js"></script>
<!-- js for back to top -->
<script src="PrduitCSS/js/top.js"></script>
<!-- /js for back to top -->
<!-- js for about lightbox -->
<script src="PrduitCSS/js/jQuery.lightninBox.js"></script>
<script type="text/javascript">
	$(".lightninBox").lightninBox();
</script>
<!-- /js for about lightbox -->
<!-- js for gallery -->
<script src="js/jquery.picEyes.js"></script>
<script>
$(function(){
	//picturesEyes($('li'));
	$('ul.demo li').picEyes();
});
</script>
<!-- /js for gallery -->
<!-- js for banner -->
<script src="PrduitCSS/js/jquery.vide.js"></script>
<!-- /js for banner -->
<!-- /js files -->
</body>
</html>