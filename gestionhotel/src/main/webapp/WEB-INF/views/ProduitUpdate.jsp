<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier un Produit</title>
</head>
<body>
<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="">Accueil</a></li>
					<li><a href="">Personne</a></li>
					<li class="active"><a href="/gestionhotel/chambre">Chambre<span
							class="sr-only">(current)</span></a></li>
					<li><a href="/gestionhotel/reservation">Reservation</a></li>
					<li><a href="produit">Produit</a></li>
					<li><a href="devis">Devis</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="panel panel-default">
		<div class="panel-heading"><h3>Modifier un produit</h3></div>
		<f:form class="form-horizontal" action="modifierProduit" method="post"
			modelAttribute="produitM">
			<div class="form-group" >
				<label class="control-label col-sm-2">Numero Produit</label>
				<div class="col-sm-10">
					<f:input type="text" path="idProduit" value="${produitM.idProduit}"/>
					<f:errors cssClass="erreur" path="idProduit"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Nom Produit</label>
				<div class="col-sm-10">
					<f:input type="text" path="idProduit" value="${produitM.idProduit}"/>
					<f:errors cssClass="erreur" path="idProduit"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Prix Produit</label>
				<div class="col-sm-10">
					<f:input type="text" path="prix" value="${produitM.prix}"/>
					<f:errors cssClass="erreur" path="prix"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Description Produit</label>
				<div class="col-sm-10">
					<f:input type="text" path="description" value="${produitM.description}"/>
					<f:errors cssClass="erreur" path="description"></f:errors>
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