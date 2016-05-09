<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/hotel.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">


<title>Chambre</title>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="">Accueil</a></li>
					<li><a href="">Personne</a></li>
					<li class="active"><a href="chambre">Chambre<span
							class="sr-only">(current)</span></a></li>
					<li><a href="reservation">Reservation</a></li>
					<li><a href="produit">Produit</a></li>
					<li><a href="devis">Devis</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Liste des chambres</h3>
		</div>
		<table class="table table-striped">
			<tr class="info">
				<td><b>Numero de la Chambre</b></td>
				<td><b>Capacite</b></td>
				<td><b>prix</b></td>
				<td><b>Description</b></td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach items="${chambres}" var="ch">
				<tr>
					<td>${ch.idChambre}</td>
					<td>${ch.capacite}</td>
					<td>${ch.prix}</td>
					<td>${ch.description}</td>
					<td><a href="chambre/${ch.idChambre}" class="btn btn-warning" role="button">Modifier</a></td>
					<td><a href="chambre/delete/${ch.idChambre}" class="btn btn-danger" role="button">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="panel panel-default">
		<div class="panel-heading"><h3>Ajouter une chambre</h3></div>
		<f:form class="form-horizontal" action="ajouterChambre" method="post"
			modelAttribute="chambre">
			<div class="form-group">
				<label class="control-label col-sm-2">Numero Chambre</label>
				<div class="col-sm-10">
					<f:input type="text" path="idChambre" />
					<f:errors cssClass="erreur" path="idChambre"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Capacité</label>
				<div class="col-sm-10">
					<f:input type="text" path="capacite" />
					<f:errors cssClass="erreur" path="capacite"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Prix</label>
				<div class="col-sm-10">
					<f:input type="text" path="prix" />
					<f:errors cssClass="erreur" path="prix"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Description</label>
				<div class="col-sm-10">
					<f:input type="text" path="description" />
					<f:errors cssClass="erreur" path="description"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</div>
			</div>
		</f:form>
	</div>

</body>
</html>