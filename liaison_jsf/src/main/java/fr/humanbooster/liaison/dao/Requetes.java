package fr.humanbooster.liaison.dao;

public class Requetes {

	//Ville
	public static final String TOUTES_LES_VILLES = "SELECT * FROM ville";
	public static final String VILLE_PAR_ID = "SELECT * FROM ville WHERE idVille = ?";
	
	//Civilite
	public static final String TOUTES_LES_CIVILITES = "SELECT * FROM civilite";
	public static final String CIVILITE_PAR_ID = "SELECT * FROM civilite WHERE idCivilite = ?";
	
	//Personne
	public static final String TOUTES_LES_PERSONNES = "SELECT * FROM personne";
	public static final String PERSONNE_PAR_ID = "SELECT * FROM personne WHERE idPersonne = ?";
	public static final String AJOUT_PERSONNE = "INSERT INTO personne (idCivilite, nom, prenom, mail, mdp, date_naissance, idVille) VALUES (?, ?, ?, ?, ?, ?, ?)";	
	public static final String SUPPR_PERSONNE_PAR_ID = "DELETE FROM PERSONNE WHERE idPersonne = ?";
	public static final String PERSONNE_PAR_MAIL_ET_MDP = "SELECT * FROM personne WHERE mail = ? and mdp = ?";
	public static final String MAJ_MDP_PERSONNE = "UPDATE personne SET mdp = ? where idPersonne = ?";
	
	//Invitation
	public static final String TOUTES_LES_INVITATIONS = "SELECT * FROM invitation";
	public static final String INVITATION_PAR_ID = "select * FROM invitation WHERE idInvitation = ?";
	public static final String AJOUT_INVITATION = "INSERT INTO invitation (message, idPersonne_invitant, idPersonne_invite) VALUES (?, ?, ?)";	
	public static final String MAJ_INVITATION = "UPDATE invitation SET acceptation = ? WHERE idInvitation = ?";
	
	//Reseau
	public static String FIND_MY_RESEAU = "SELECT * FROM reseau WHERE idPersonne_invitant = ?";
	public static String NOUVELLE_ENTREE_RESEAU = "INSERT INTO reseau (idPersonne_invitant, idPersonne_invite) value (?, ?)";
	
}
