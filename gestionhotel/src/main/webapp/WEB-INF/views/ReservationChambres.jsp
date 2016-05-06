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
					<li><a href="/gestionhotel/chambre">Chambre</a></li>
					<li class="active"><a href="/gestionhotel/reservation">Reservation<span
							class="sr-only">(current)</span></a></li>
					<li><a href="">Produit</a></li>
					<li><a href="">Devis</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="panel panel-default">
		<div class="panel-heading">
			<h2>Chambres de la réservation numero : ${reservation.idReservation}</h2>
		</div>
		<table class="table table-striped">
			<tr class="info">
				<td><b>Numero de la Chambre</b></td>
				<td><b>Capacite</b></td>
				<td><b>prix</b></td>
				<td><b>Description</b></td>
				<td></td>
			</tr>
			<c:forEach items="${chares}" var="chR">
				<tr>
					<td>${chR.idChambre}</td>
					<td>${chR.capacite}</td>
					<td>${chR.prix}</td>
					<td>${chR.description}</td>
					<td><a href="/gestionhotel/reservation/delete/${reservation.idReservation}/${chR.idChambre}" class="btn btn-danger" role="button">Enlever</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h2>Chambres disponible à la réservation</h2>
		</div>
		<table class="table table-striped">
			<tr class="info">
				<td><b>Numero de la Chambre</b></td>
				<td><b>Capacite</b></td>
				<td><b>prix</b></td>
				<td><b>Description</b></td>
				<td></td>
			</tr>
			<c:forEach items="${dispo}" var="di">
				<tr>
					<td>${di.idChambre}</td>
					<td>${di.capacite}</td>
					<td>${di.prix}</td>
					<td>${di.description}</td>
					<td><a href="/gestionhotel/reservation/${reservation.idReservation}/${di.idChambre}"class="btn btn-success" role="button">Ajouter la chambre</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	

</body>
</html>