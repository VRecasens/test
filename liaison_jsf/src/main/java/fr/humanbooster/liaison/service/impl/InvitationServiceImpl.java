package fr.humanbooster.liaison.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.humanbooster.liaison.business.Invitation;
import fr.humanbooster.liaison.business.Personne;
import fr.humanbooster.liaison.dao.InvitationDao;
import fr.humanbooster.liaison.dao.impl.InvitationDaoImpl;
import fr.humanbooster.liaison.service.InvitationService;
//import fr.humanbooster.liaison.utils.Mailer;
@ManagedBean(name="invitationServiceImpl", eager = true)
public class InvitationServiceImpl implements InvitationService {
	private static InvitationDao idao;
	// Constructeur + initialisation idao 
	public InvitationServiceImpl() throws ClassNotFoundException, SQLException {
		//InvitationServiceImpl.idao = new InvitationDaoImpl(connection);
		idao = new InvitationDaoImpl();
	}
	
	// Add invitation
	public Invitation ajouterInvitation(String message, Personne personneInvitante, Personne personneInvitee) throws SQLException {
		Invitation invitation = new Invitation(message, personneInvitante, personneInvitee);
		idao.createInvitation(invitation);
		
		//On envoie un mail à la personne invité grâce à la classe 'Mailer'
//		Mailer mailer = new Mailer();
//		mailer.sendSimpleMail("ylaurent@humanbooster.com", "Test du mailer", "Prout!");
//		mailer.sendJoinedMail("vrecasens@humanbooster.com");
		return invitation;
	}

	@Override
	public Invitation recupererInvitation(int idPersonne) {
		// TODO Auto-generated method stub
		return null;
	}

	// Get all invitations
	public List<Invitation> getAllInvitations() {
		List<Invitation> invitations = new ArrayList<>();		
		invitations = idao.findAll();		
		return invitations;
	}

	@Override
	public void effacerInvitation(int id) {
		// TODO Auto-generated method stub	
	}

	@Override
	public boolean repondreInvitation(Invitation invitation) {
		// TODO Auto-generated method stub
		idao.updateInvitation(invitation);
		return false;
	}

	@Override
	public Invitation ajouterInvitation(Invitation invit) throws SQLException {
		return this.ajouterInvitation(invit.getMessage(), invit.getPersonneInvitant(), invit.getPersonneInvite());
	}

}
