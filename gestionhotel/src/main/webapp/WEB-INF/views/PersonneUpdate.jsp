<!-- Auteur : Valérian THOMAS
nom : gestionhotel
date : 07/05/2016
dossier : Deployed ressources/webapp/WEB-INF/views
Fichier : PersonneUpdate.jsp
Version : 1
association : ControllerPersonne -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/hotel.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Modifier Personne</title>
</head>
<body>
<!-- Onglets de navigation -->

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="">Accueil</a></li>
				<li class="active"><a href="/gestionhotel/Personne">Personne</a><span
					class="sr-only">(current)</span></li>
				<li><a href="/gestionhotel/chambre">Chambre</a></li>
				<li><a href="/gestionhotel/reservation">Reservation</a></li>
				<li><a href="">Produit</a></li>
				<li><a href="">Devis</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="col-xs-12">
		<!-- Création d'une marge pour toute la page -->
		
		<div class="panel panel-default">
		<div class="panel-heading"><h3>Modifier une personne</h3></div>
		<f:form class="form-horizontal" action="${clientup.idPersonne}/done" method="post"
			modelAttribute="clientup">
			<div class="form-group" >
				<label class="control-label col-sm-2">Nom</label>
				<div class="col-sm-10">
					<f:input type="text" path="nomPersonne" value="${clientup.nomPersonne}"/>
					<f:errors cssClass="erreur" path="nomPersonne"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Prenom</label>
				<div class="col-sm-10">
					<f:input type="text" path="prenomPersonne" value="${clientup.prenomPersonne}"/>
					<f:errors cssClass="erreur" path="prenomPersonne"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Sexe</label>
				<div class="col-sm-10">
					<select class="form-control" id="sexe" name="sexe">
							<option>M</option>
							<option>F</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Date de Naissance</label>
				<div class="col-sm-10">
					<f:input type="text" path="dateNaissance" value="${clientup.dateNaissance}"/>
					<f:errors cssClass="erreur" path="dateNaissance"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Adresse</label>
				<div class="col-sm-10">
					<f:input type="text" path="adresse" value="${clientup.adresse}"/>
					<f:errors cssClass="erreur" path="adresse"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">E-Mail</label>
				<div class="col-sm-10">
					<f:input type="text" path="mail" value="${clientup.mail}"/>
					<f:errors cssClass="erreur" path="mail"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Telephone</label>
				<div class="col-sm-10">
					<f:input type="text" path="tel" value="${clientup.tel}"/>
					<f:errors cssClass="erreur" path="tel"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Modifier</button>
				</div>
			</div>
		</f:form>
	</div>

</body>
</html>