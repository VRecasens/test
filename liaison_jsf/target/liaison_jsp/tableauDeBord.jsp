<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tableau de bord</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.idPersonne ne null}">
			<h1>Bienvenue ${personne.nom} ${personne.prenom}!</h1>
			<form action="DeconnexionServlet" method="post"
				class="form-horizontal">
				<div class="text-center">
					<input type="submit" value="Déconnexion" class="btn btn-primary">
				</div>
			</form>
			<form action="MAJMotDePasseServlet" method="get"
				class="form-horizontal">
				<div class="text-center">
					<input type="submit" value="Modifier mot de passe"
						class="btn btn-primary">
				</div>
			</form>
			<label>Vous êtes l'utilisateur Id :
				${sessionScope.idPersonne}</label>
			<br>
			<label>Vous voulez inviter un amis?</label>
			<form action="InvitationServlet" method="post"
				class="form-horizontal">
				<select name="personneInvitee" class="form-control">
					<c:forEach items="${personnes}" var="personneEnCours">
						<option value="${personneEnCours.id}">${personneEnCours.civilite.nom}
							${personneEnCours.nom}</option>
					</c:forEach>
				</select>
				<div class="text-center">
					<input type="submit" value="Inviter" class="btn btn-primary">
				</div>
			</form>

			<div class="text-center">
				<a class="btn btn-primary" href="invitation.xhtml">Inscription</a>
			</div>

		</c:when>
		<c:otherwise>
			<c:redirect url="expire.jsp"></c:redirect>
		</c:otherwise>
	</c:choose>
</body>
</html>