<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<meta charset="ISO-8859-1">
	<title>Ajouter un �tudiant � un cours</title>
</head>
<body style="background: black">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="accueil.jsp">Gestion Etudiants</a>
	  	<div class="collapse navbar-collapse" id="navbarNavDropdown">
    		<ul class="navbar-nav">
    			<li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Menu �tudiant
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
			          <a class="dropdown-item" href="listeEtudiants">Lister �tudiants</a>
			          <a class="dropdown-item" href="getFormLireEtudiant">Info �tudiant</a>
			          <a class="dropdown-item" href="getFormSupprimerEtudiant">Supprimer un �tudiant</a>
			          <a class="dropdown-item" href="getFormModifierEtudiant">Modifier un �tudiant</a>
			          <a class="dropdown-item" href="getFormAjoutEtudiant">Ajouter un �tudiant</a>
			          <a class="dropdown-item" href="getFormAjoutEtudiantCours">Rajouter un �tudiant � un cours</a>
			        </div>
			    </li>
				<li class="nav-item active" style="padding-right: 10px">
		       		<a class="nav-link" href="index.jsp">D�connexion <span class="sr-only">(current)</span></a>
		   		</li>
    		</ul>
  		</div>
	</nav>
	
	<link href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900|Roboto:100,300,400,500,700,900" rel="stylesheet" />
	<div class="container">
	    <div class="error-wrapper">
	        <div class="man-icon"></div>
	        <h3 class="title">404</h3>
	        <p class="info">Oh! Page not found</p>
	        <button type="button" class="home-btn" onclick="location.href = '/gestionscolairespringboot/accueil.jsp';">Accueil</button>
    	</div>
	</div>
</body>
</html>