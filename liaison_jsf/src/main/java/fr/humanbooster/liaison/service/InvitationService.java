package fr.humanbooster.liaison.service;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.liaison.business.Invitation;
import fr.humanbooster.liaison.business.Personne;

public interface InvitationService {
	// Add invitation
	Invitation ajouterInvitation(
		String message,
		Personne personneInvitante, 
		Personne personneInvitee
	) throws SQLException;

	// Get invitation via ipPersonne
    Invitation recupererInvitation(int idPersonne);
   
    // Toutes les invitations
    List<Invitation> getAllInvitations();

    
    // Effacer une invitation via son idInvitation
    void effacerInvitation(int id);
    
    // boolean
    boolean repondreInvitation(Invitation invitation);
    public Invitation ajouterInvitation(Invitation invit) throws SQLException;
}
