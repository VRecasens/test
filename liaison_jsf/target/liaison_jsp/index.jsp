<html>
<head>
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript"
	src="webjars/jquery/3.1.1/dist/jquery.min.js"></script>
<script type="text/javascript"
	src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h2 class="text-center">Hello World!</h2>

	<form data-toggle="validator"
		action="ConnexionServlet" method="post" class="form-horizontal">

		<div class="form-group">
			<div class="col-sm-4">
				<label for="inputEmail" class="col-sm-4 control-label">Email</label>
			</div>
			<div class="col-sm-8">
				<input id="inputEmail" type="text" name="email" class="form-control"
					placeholder="Email" required>
			</div>
		</div>
		<!-- Mot de passe -->
		<div class="form-group">
			<div class="col-sm-4">
				<label for="inputPassword" class="col-sm-4 control-label">Mot
					de passe</label>
			</div>
			<div class="col-sm-8">
				<input id="inputPassword" type="password" name="motDePasse"
					class="form-control" placeholder="Mot de passe" required>
			</div>
		</div>
		<div class="text-center">
			<input type="submit" value="Connexion" class="btn btn-primary">
		</div>
		
	</form>

	<div class="text-center">
		<a class="btn btn-primary" href="InscriptionServlet">Inscription</a>
	</div>

</body>
</html>
