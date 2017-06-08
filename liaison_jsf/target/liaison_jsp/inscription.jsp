<%@ include file = "includes/header.jsp" %>
	<div class="col-md-6 col-md-offset-3">
		<h1 class="text-center text-info">Inscription au site liaison</h1>
		
			<c:out value="${message}" default="" />
		
		<form id="formInscription" data-toggle="validator" action="InscriptionServlet?inscription=ok" method="post" class="form-horizontal">
			<!-- Nom -->
			<div class="form-group">
			   <label for="inputNom" class="col-sm-4 control-label">Nom</label>
			   <div class="col-sm-8">
			     <input id="inputNom" type="text" name="nom" class="form-control" placeholder="Nom" required>
			   </div>
			</div>
			<!-- Prénom --> 
			<div class="form-group">
			   <label for="inputPrenom" class="col-sm-4 control-label">Prénom</label>
			   <div class="col-sm-8">
			     <input id="inputPrenom" type="text" name="prenom" class="form-control" placeholder="Prénom" required>
			   </div>
			</div>		
			<!-- Civilite -->
			<div class="form-group">
			   	<label for="inputCivilite" class="col-sm-4 control-label">Civilité</label>			
				<div class="col-sm-8">
					<select id="inputCivilite" name="civilite" class="form-control">						
						<c:forEach items="${civilite}" var="civilite">
							<option value="${civilite.id}">${civilite.nom}</option>
						</c:forEach>
					</select>
				</div>
			</div>				
			<!-- Ville -->
			<div class="form-group">
			   	<label for="inputVille" class="col-sm-4 control-label">Ville</label>			
				<div class="col-sm-8">
					<select id="inputVille" name="ville" class="form-control">						
						<c:forEach items="${ville}" var="ville">
							<option value="${ville.id}">${ville.nom}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<!-- Email -->
			<div class="form-group">
			   <label for="inputEmail" class="col-sm-4 control-label">Email</label>
			   <div class="col-sm-8">
			     <input id="inputEmail" type="text" name="email" class="form-control" placeholder="Email" required>
			   </div>
			</div>
			<!-- Mot de passe -->
			<div class="form-group">
			   <label for="inputPassword" class="col-sm-4 control-label">Mot de passe</label>
			   <div class="col-sm-8">
			     <input id="inputPassword" type="password" name="motDePasse" class="form-control" placeholder="Mot de passe" required>
			   </div>
			</div>
			<!-- Date d'inscription -->
			<!--<div class="form-group">
			   <label for="inputDateInscription" class="col-sm-4 control-label">Date d'inscription</label>
			   <div class="col-sm-8">
			     <input id="inputDateInscription" type="date" name="dateInscription" class="form-control" placeholder="Date d'inscription">
			   </div>
			</div>-->
			<!-- Date de naissance -->
			<div class="form-group">
			   <label for="inputDateNaissance" class="col-sm-4 control-label">Date de naissance</label>
			   <div class="col-sm-8">
			     <input id="inputDateNaissance" type="date" name="dateNaissance" class="form-control" placeholder="Date de naissance">
			   </div>
			</div>
			<!-- Inscription -->
			<div class="form-group">
			   <label class="col-sm-4 control-label">&nbsp;</label>
			   <div class="col-sm-8">
			     <input type="submit" value="Inscription" class="btn btn-primary">
			   </div>
			</div>
			
		</form>
	</div>
<%@ include file = "includes/footer.jsp" %>
<script>
	$(document).ready(function(){
		$('#formInscription').validator();
	});

</script>		
