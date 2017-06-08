<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session expirée</title>
</head>
<body>
<div class="text-center">
	<h1>Session expirée</h1>
	<form id="formInscription" data-toggle="validator"
		action="DeconnexionServlet" method="get" class="form-horizontal">
		<div class="text-center">
			<input type="submit" value="Retour à l'accueil" class="btn btn-primary">
		</div>
	</form>
</div>
</body>
</html>