<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/hotel.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<title>Modifier un Devis</title>
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
		<div class="panel-heading"><h3>Modifier un devis</h3></div>
		<f:form class="form-horizontal" action="modifierDevis" method="post"
			modelAttribute="devM">
			<div class="form-group" >
				<label class="control-label col-sm-2">Numero Devis</label>
				<div class="col-sm-10">
					<f:input type="text" path="idDevis" value="${devM.idDevis}"/>
					<f:errors cssClass="erreur" path="idDevis"></f:errors>
				</div>
			</div>
			
		</f:form>
	</div>

</body>
</html>