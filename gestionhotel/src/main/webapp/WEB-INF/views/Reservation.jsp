<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/hotel.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<title>Reservation</title>
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
			<h3>Liste des reservations</h3>
		</div>
		<table class="table table-striped">
			<tr class="info">
				<td><b>Id Reservation</b></td>
				<td><b>Date de debut</b></td>
				<td><b>Date de fin</b></td>
				<td><b>Etat</b></td>
				<td><b>Nom client</b></td>
				<td><b>Employe du dossier</b></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach items="${reservations}" var="re">
				<tr>
					<td>${re.idReservation}</td>
					<td>${re.dateDebut}</td>
					<td>${re.dateFin}</td>
					<td>${re.etatReservation}</td>
					<td>${re.client.nomPersonne}</td>
					<td>${re.employe.nomPersonne}</td>
					<td><a href="reservation/chambres/${re.idReservation}"class="btn btn-success" role="button">Voir/Ajouter chambres</a></td>
					<td><a href="reservation/update/${re.idReservation}" class="btn btn-warning" role="button">Modifier</a></td>
					<td><a href="reservation/delete/${re.idReservation}" class="btn btn-danger" role="button">Supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="panel panel-default">
		<div class="panel-heading"><h3>Ajouter une reservation</h3></div>
		<f:form class="form-horizontal" action="ajouterReservation" method="post"
			modelAttribute="reser">
			<div class="form-group">
				<label class="control-label col-sm-2">Date de debut</label>
				<div class="col-sm-10">
					<f:input type="date"  path="dateDebut" />
					<f:errors cssClass="erreur" path="dateDebut"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Date de fin</label>
				<div class="col-sm-10">
					<f:input type="date" path="dateFin"/>
					<f:errors cssClass="erreur" path="dateFin"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Etat</label>
				<div class="col-sm-10">
					<f:input type="text" path="etatReservation" />
					<f:errors cssClass="erreur" path="etatReservation"></f:errors>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Client</label>
				<div class="col-sm-10">
					<select class="selectpicker" name="idClient">
						<c:forEach items="${clients}" var="cl">
							<option value="${cl.idPersonne}">${cl.nomPersonne}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Employe</label>
				<div class="col-sm-10">
					<select class="selectpicker" name="idEmploye">
						<c:forEach items="${employes}" var="em">
							<option value="${em.idPersonne}">${em.nomPersonne}</option>
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


</body>
</html>