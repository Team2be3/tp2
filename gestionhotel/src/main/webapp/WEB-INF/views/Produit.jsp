<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/hotel.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


<title>Produit</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="">Accueil</a></li>
					<li><a href="">Personne</a></li>
					<li><a href="chambre">Chambre</a></li>
					<li><a href="reservation">Reservation</a></li>
					<li class="active"><a href="produit">Produit<span
							class="sr-only">(current)</span></a></li>
					<li><a href="devis">Devis</a></li>
				</ul>
			</div>
		</div>
	</nav>



	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Liste des Produits</h3>
		</div>
		<table class="table table-striped">
			<tr class="info">
				<td><b>Id Produit</b></td>
				<td><b>Nom Produit</b></td>
				<td><b>Prix Produit</b></td>
				<td><b>Description Produit</b></td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach items="${produits}" var="pro">
				<tr>
					<td>${pro.idProduit}</td>
					<td>${pro.nomProduit}</td>
					<td>${pro.prixProduit}</td>
					<td>${pro.descriptionProduit}</td>
					<td><a href="produit/${pro.idProduit}" class="btn btn-warning" role="button">Modifier</a></td>
					<td><a href="produit/delete/${pro.idProduit}" class="btn btn-danger" role="button">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
<%-- 		<div>
		<form method="post" action="ajouterProduit" class="form-inline">
			<p>
				<label for="produit">Ajouter un produit</label> : 
				<input type="text" name="idProduit" id="produit" placeholder="Prenom" class="form-control"/> 
				<input type="text" name="nomProduit" id="produit" placeholder="Nom" class="form-control"/> 
				<input type="text" name="prixProduit" placeholder="Prix" id="produit" class="form-control"/> 
				<input type="text" name="descriptionProduit" placeholder="Description" id="produit" class="form-control"/> 
				
				<input type="submit" class="btn btn-primary" value="Envoyer">
			</p>
		</form>
	</div> --%>
	
	
	

	<div class="panel panel-default">
		<div class="panel-heading"><h3>Ajouter un produit</h3></div>
		<f:form class="form-horizontal" action="ajouterProduit" method="post"
			modelAttribute="produit">
			<div class="form-group">
				<label class="control-label col-sm-2">Nom Produit</label>
				<div class="col-sm-10">
					<f:input type="text" path="nomProduit" />
					<f:errors cssClass="erreur" path="nomProduit"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Prix Produit</label>
				<div class="col-sm-10">
					<f:input type="text" path="prixProduit" />
					<f:errors cssClass="erreur" path="prixProduit"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Description Produit</label>
				<div class="col-sm-10">
					<f:input type="text" path="descriptionProduit" />
					<f:errors cssClass="erreur" path="descriptionProduit"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</div>
			</div>
		</f:form>
	</div>
	
	
	
	<div>
		<h2>Rechercher un produit par mot-clé</h2>
		<form method="post" action="rechercherProduit" class="form-inline">
			<p>
				<label for="produit">Rechercher un produit</label> : 
				<input type="text" name="motCle" id="motCle" placeholder="Mot Cle" class="form-control"/> 				
				<input type="submit"  class="btn btn-primary" value="Chercher">
			</p>
		</form>
	</div>
		</br>
	
</body>
</html>