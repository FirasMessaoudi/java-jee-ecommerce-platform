<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.*" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<link href="PrduitCSS/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/gallery.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/jQuery.lightninBox.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/aos.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/index2.css" rel="stylesheet" type="text/css" media="all" />
<link href="PrduitCSS/css/panier.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<a href="ControlServlet"><button class="btn btn-outline btn-lg" type="submit">Continue Shopping</button></a>
<table border="1" width="80%">
<tr>
<th>ID Product</th>
<th>Product Name</th>
<th>Price</th>
<th>Quantity</th> 
<th>Total</th>
<th>Option</th>
</tr>
<c:forEach var="it" items="${sessionScope.cart }">
<c:set var="s"  value="${s+ it.quantite*it.article.prix}"></c:set>
<tr>
<td>${it.article.idProduit }</td>
<td>${it.article.designation }</td>
<td>${it.article.prix }DT</td>
<td>${it.quantite }</td>
<td>${it.quantite*it.article.prix}</td>
<td align="center"><a id="btnEmpty" href="PanierServlet?id=${it.article.idProduit}&action=delete" onclick="return confirm('Are you sure')">Delete</a></td>
</tr>
</c:forEach>
<tr>
<td colspan="5" align="right">Sum</td>
<td>=${s }</td>
</tr>
</table>
<a href="Login.jsp" target="_blank"><button class="btn btn-outline btn-lg" type="submit">CheckOut</button></a>
</body>
</html>