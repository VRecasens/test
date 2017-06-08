package fr.humanbooster.liaison.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.liaison.business.Invitation;

public interface InvitationDao {
	// Add invitation
	Invitation createInvitation(Invitation invitation) throws SQLException;
	// Get all invitations
	List<Invitation> findAll();
	// Get invitation by id
	Invitation findInvitationById(Long idInvitation);
	// Update invitation
	void updateInvitation(Invitation invitation);
}
