<!-- Auteur : Valérian THOMAS
nom : gestionhotel
date : 05/05/2016
dossier : Deployed ressources/webapp/WEB-INF/views
Fichier : Personne.jsp
Version : 1
association : ControllerPersonne -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Lien avec Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<title>Personnes</title>
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
	<!-- Création d'une marge pour toute la page -->
	<div class="col-xs-12">


		<!-- Utilisation d'onglets Client/Employé-->
		<div>
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#Client"
					aria-controls="client" role="tab" data-toggle="tab">Client</a></li>
				<li role="presentation"><a href="#Employe"
					aria-controls="employe" role="tab" data-toggle="tab">Employe</a></li>
			</ul>
			<!-- Onglet Client -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane fade in active" id="Client">

					<h2>Ajout d'un client</h2>
					<f:form class="form-horizontal" action="addclient" method="post"
						modelAttribute="Client">
						<table>
							<!-- Nom des champs -->
							<tr>
								<td class="text-center"><label for="nomPersonne">Nom</label></td>
								<td class="text-center"><label for="prenomPersonne">Prénom</label></td>
								<td class="text-center"><label for="sexe">Sexe</label></td>
								<td class="text-center"><label for="dateNaissance">Date
										de Naissance</label></td>
								<td class="text-center"><label for="adresse">Adresse</label></td>
								<td class="text-center"><label for="mail">Mail</label></td>
								<td class="text-center"><label for="tel">Telephone</label></td>
							</tr>

							<tr>
								<td><f:input class="form-control" id="nomPersonne"
										path="nomPersonne" type="text" placeholder="Nom" /> <f:errors
										cssClass="erreur" path="nomPersonne"></f:errors></td>
								<td><f:input class="form-control" id="prenomPersonne"
										path="prenomPersonne" type="text" placeholder="Prénom" /> <f:errors
										cssClass="erreur" path="prenomPersonne"></f:errors></td>
								<td><select class="form-control" id="sexe" name="sexe">
										<option>M</option>
										<option>F</option>
								</select></td>
								<td><f:input class="form-control" id="dateNaissance"
										path="dateNaissance" type="text"
										placeholder="Date de naissance" /> <f:errors
										cssClass="erreur" path="dateNaissance"></f:errors></td>
								<td><f:input class="form-control" id="adresse"
										path="adresse" type="text" placeholder="Adresse" /> <f:errors
										cssClass="erreur" path="adresse"></f:errors></td>
								<td><f:input class="form-control" id="mail" path="mail"
										type="text" placeholder="E-Mail" /> <f:errors
										cssClass="erreur" path="mail"></f:errors></td>
								<td><f:input class="form-control" id="tel" path="tel"
										type="text" placeholder="Telephone" /> <f:errors
										cssClass="erreur" path="tel"></f:errors></td>
								<td><button type="submit" class="btn btn-success">Enregistrer
										client</button></td>
							</tr>
						</table>
					</f:form>


				 	<h2>Rechercher par mot-clé</h2>
		<form class="form-horizontal" action="rechercherclient" method="post">
			<label for="mc">Mot Clé</label>
			<input class="form-control" id="mc" name="mc" type="text" placeholder="mot-clé" />

			<button type="submit" class="btn btn-success">Rechercher</button>
		</form>


					<!-- Liste des clients -->
					<div class="table table-striped, container-fluid">

						<table class="table table-striped">
							<tr class="info">

								<th class="success">ID client</th>
								<th class="success">Nom</th>
								<th class="success">Prénom</th>
								<th class="success">Sexe</th>
								<th class="success">Date de naissance</th>
								<th class="success">Adresse</th>
								<th class="success">E-Mail</th>
								<th class="success">Telephone</th>
								<th></th>
								<th></th>

								<!-- contenu de la table Clients -->

								<c:forEach items="${Clients}" var="cl">
									<tr>
										<td>${cl.idPersonne}</td>
										<td>${cl.nomPersonne}</td>
										<td>${cl.prenomPersonne}</td>
										<td>${cl.sexe}</td>
										<td>${cl.dateNaissance}</td>
										<td>${cl.adresse}</td>
										<td>${cl.mail}</td>
										<td>${cl.tel}</td>
										<td><a href="updateclient/${cl.idPersonne}"
											class="btn btn-warning" role="button">Modifier</a></td>
										<td><a href="deleteclient/${cl.idPersonne}"
											class="btn btn-danger" role="button">Supprimer</a></td>
									</tr>
								</c:forEach>
						</table>
					</div>
				</div>

			</div>

			<!-- Onglet Employé -->
			<div role="tabpanel" class="tab-pane fade" id="Employe">
				<div role="tabpanel" class="tab-pane fade in active" id="Client">
				
				<!-- Liste des employes -->
					<div class="table table-striped, container-fluid">

						<table class="table table-striped">
							<tr class="info">

								<th class="success">ID employe</th>
								<th class="success">Nom</th>
								<th class="success">Prénom</th>
								<th class="success">Sexe</th>
								<th class="success">Date de naissance</th>
								<th class="success">Adresse</th>
								<th class="success">E-Mail</th>
								<th class="success">Telephone</th>
								

								<!-- contenu de la table Employe -->

								<c:forEach items="${Employes}" var="e">
									<tr>
										<td>${e.idPersonne}</td>
										<td>${e.nomPersonne}</td>
										<td>${e.prenomPersonne}</td>
										<td>${e.sexe}</td>
										<td>${e.dateNaissance}</td>
										<td>${e.adresse}</td>
										<td>${e.mail}</td>
										<td>${e.tel}</td>
										
									</tr>
								</c:forEach>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>