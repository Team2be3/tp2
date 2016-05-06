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
					<li class="active"><a href="/gestionhotel/chambre">Chambre<span
							class="sr-only">(current)</span></a></li>
					<li><a href="/gestionhotel/reservation">Reservation</a></li>
					<li><a href="">Produit</a></li>
					<li><a href="">Devis</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="panel panel-default">
		<div class="panel-heading"><h3>Modifier une chambre</h3></div>
		<f:form class="form-horizontal" action="modifierChambre" method="post"
			modelAttribute="chambreM">
			<div class="form-group" >
				<label class="control-label col-sm-2">Numero Chambre</label>
				<div class="col-sm-10">
					<f:input type="text" path="idChambre" value="${chambreM.idChambre}"/>
					<f:errors cssClass="erreur" path="idChambre"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Capacité</label>
				<div class="col-sm-10">
					<f:input type="text" path="capacite" value="${chambreM.capacite}"/>
					<f:errors cssClass="erreur" path="capacite"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Prix</label>
				<div class="col-sm-10">
					<f:input type="text" path="prix" value="${chambreM.prix}"/>
					<f:errors cssClass="erreur" path="prix"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Description</label>
				<div class="col-sm-10">
					<f:input type="text" path="description" value="${chambreM.description}"/>
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