<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mise à jour du mot de passe</title>
</head>
<body>
	<form data-toggle="validator" action="MAJMotDePasseServlet" method="post"
		class="form-vertical">
		<div class="text-center">
			<textarea name="oldMdp" rows="1" cols="100">Ancien mot de passe</textarea>
			<textarea name="majMdp" rows="1" cols="100">Nouveau mot de passe</textarea>
			<textarea name="majMdpCheck" rows="1" cols="100">Vérifier nouveau mot de passe</textarea>
			<input type="submit" value="Modifier" class="btn btn-primary">
		</div>
	</form>
</body>
</html>