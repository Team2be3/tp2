<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/hotel.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<title>Devis</title>
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
					<li class="active"><a href="reservation">Reservation<span
							class="sr-only">(current)</span></a></li>
					<li><a href="">Produit</a></li>
					<li><a href="">Devis</a></li>
				</ul>
			</div>
		</div>
	</nav>

<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Liste des devis</h3>
		</div>
		<table class="table table-striped">
			<tr class="info">
				<td><b>Id Devis</b></td>
				<td><b>Id Reservation</b></td>
				<td><b>Id Produit</b></td>
		
			</tr>
			<c:forEach items="${devis}" var="de">
				<tr>
					<td>${de.idDevis}</td>
					<td>${de.idReservation}</td>
					<td>${de.idProduit}</td>
				
					<td><a href="devis/ajouter${de.idDevis}"class="btn btn-success" role="button">Ajouter devis</a></td>
					<td><a href="devis/update/${de.idDevis}" class="btn btn-warning" role="button">Modifier</a></td>
					<td><a href="devis/delete/${de.idDevis}" class="btn btn-danger" role="button">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="panel panel-default">
		<div class="panel-heading"><h3>Ajouter un devis</h3></div>
		<f:form class="form-horizontal" action="ajouterDevis" method="post"
			modelAttribute="dev">
		
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Devis</label>
				<div class="col-sm-10">
					<select class="selectpicker" name="idDevis">
						<c:forEach items="${devis}" var="de">
							<option value="${de.idDevis}"></option>
						</c:forEach>
					</select>
				</div>
			</div>
					<div class="form-group">
				<label class="control-label col-sm-2">Reservation</label>
				<div class="col-sm-10">
					<select class="selectpicker" name="idReservation">
						<c:forEach items="${reservati
						on}" var="re">
							<option value="${re.idReservation}"></option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Produit</label>
				<div class="col-sm-10">
					<select class="selectpicker" name="idProduit">
						<c:forEach items="${produit}" var="pro">
							<option value="${pro.idProduit}"></option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Ajouter</button>
				</div>
			</div>
		</f:form>
		<div class="erreur">${exc.exception}</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			



	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Supprimer un devis</h3>
		</div>
		<f:form class="form-horizontal" action="supprimerDevis" method="delete"
			modelAttribute="devS">
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Devis</label>
		<div class="col-sm-10">
			<select class="selectpicker" name="idDevis">
				<c:forEach items="${devis}" var="de">
					<option value="${de.idDevis}"></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Reservation</label>
		<div class="col-sm-10">
			<select class="selectpicker" name="idReservation">
				<c:forEach items="${reservation}" var="re">
					<option value="${re.idReservation}"></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Produit</label>
		<div class="col-sm-10">
			<select class="selectpicker" name="idProduit">
				<c:forEach items="${produit}" var="pro">
					<option value="${pro.idProduit}"></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Supprimer
				devis</button>
		</div>
		
	</div>
	</f:form>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Calculer un devis</h3>
		</div>
		<f:form class="form-horizontal" action="calculerDevis" method="get"
			modelAttribute="devC">
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Devis</label>
		<div class="col-sm-10">
			<select class="selectpicker" name="idDevis">
				<c:forEach items="${devis}" var="de">
					<option value="${de.idDevis}"></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Reservation</label>
		<div class="col-sm-10">
			<select class="selectpicker" name="idReservation">
				<c:forEach items="${reservation}" var="re">
					<option value="${re.idReservation}"></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Produit</label>
		<div class="col-sm-10">
			<select class="selectpicker" name="idProduit">
				<c:forEach items="${produit}" var="pro">
					<option value="${pro.idProduit}"></option>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-primary">Calculer
				devis</button>
		</div>
		
	</div>
	</f:form>




</body>
</html>