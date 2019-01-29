<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.*" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulter les Categories</title>
</head>
<body>
<div id="formRecherche">
<form action ="ServletCategorie" method="post">
<input type="submit" value="Consulter tous les categories" name="action">
<table border="1" width="80%">
<tr>
<th>Code Categorie</th><th>Nom </th><th>Description</th><th>Photo</th>
</tr>
<c:forEach items="${Categorie }" var="c">
<tr>
<td>${c.getIdCategorie() }</td><td>${c.getNomCategorie() }</td><td>${c.getDescription() }</td><td>${ c.getPhoto()} <!-- lien pour conbsulter cette categorie  -->
</tr>
</c:forEach>
</table>
</form>
</div>
</body>
</html>