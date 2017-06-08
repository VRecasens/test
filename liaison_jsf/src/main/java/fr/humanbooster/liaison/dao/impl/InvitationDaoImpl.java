package fr.humanbooster.liaison.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.humanbooster.liaison.business.Invitation;
import fr.humanbooster.liaison.dao.ConnexionBdd;
import fr.humanbooster.liaison.dao.InvitationDao;
import fr.humanbooster.liaison.dao.PersonneDao;
import fr.humanbooster.liaison.dao.Requetes;
import fr.humanbooster.liaison.utils.Dates;


public class InvitationDaoImpl implements InvitationDao {
	private static Connection connection;	
	private static PersonneDao pdao;

	
	public InvitationDaoImpl() throws ClassNotFoundException, SQLException {
		pdao = new PersonneDaoImpl();
		connection = ConnexionBdd.getConnection();
	}

	/**
	 * Create invitation
	 */
	public Invitation createInvitation(Invitation invitation) throws SQLException {
		
		String query = Requetes.AJOUT_INVITATION;
		PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		// Set params
		ps.setString(1, invitation.getMessage());
		
		// On navigue de l'objet Invitation à Personne
		ps.setInt(2, invitation.getPersonneInvitant().getId());
		
		// On navigue de l'objet Invitation à Personne
		ps.setInt(3, invitation.getPersonneInvite().getId());
		
		// Execute requete
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		invitation.setId(rs.getInt(1));
		invitation.setDateEnvoi(new Date());
		
		return invitation;
	}

	
	/**
	 * Get All invitations
	 */
	public List<Invitation> findAll() {
		List<Invitation> invitations = new ArrayList<>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(Requetes.TOUTES_LES_INVITATIONS);
			
			while(rs.next()) {
				Invitation invitation = new Invitation(
					rs.getString("message"), 
					pdao.getPersonneById(rs.getInt("idPersonne_invitant")), 
					pdao.getPersonneById(rs.getInt("idPersonne_invite"))					
				);
				invitation.setDateEnvoi(Dates.convertSqlDateToUtilDate(rs.getDate("date_envoi")));
				invitation.setDateReponse(Dates.convertSqlDateToUtilDate(rs.getDate("date_reponse")));
				invitation.setEstAcceptee(rs.getBoolean("acceptation"));
				invitation.setId(rs.getInt("idInvitation"));
				
				invitations.add(invitation);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invitations;
	}

	
	/**
	 * Update Invitation
	 */
	public void updateInvitation(Invitation invitation) {
		try {
			PreparedStatement pst = connection.prepareStatement(Requetes.MAJ_INVITATION);
			pst.setBoolean(1, invitation.isEstAcceptee());
			pst.setInt(2, invitation.getId());
			
			if(pst.executeUpdate() == 1) {
				System.out.println("\nMise à jour invitation avec succès");
				if(invitation.isEstAcceptee() == true){
					PreparedStatement pst2 = connection.prepareStatement(Requetes.NOUVELLE_ENTREE_RESEAU);
					pst2.setInt(1, invitation.getPersonneInvitant().getId());
					pst2.setInt(2, invitation.getPersonneInvite().getId());
					pst2.executeQuery();
				}
			}			
		} catch (SQLException e) {
			System.out.println("\nEchec mise à jour invitation");
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public Invitation findInvitationById(Long idInvitation) {
		PreparedStatement pst;
		Invitation invitation = null;
		String query = Requetes.INVITATION_PAR_ID;
		try {
			pst = connection.prepareStatement(query);
			pst.setLong(1, idInvitation);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			rs.next();
			
			invitation = new Invitation(
				rs.getString("message"), 
				pdao.getPersonneById(rs.getInt("idPersonne_invitant")), 
				pdao.getPersonneById(rs.getInt("idPersonne_invite"))					
			);
			invitation.setDateEnvoi(Dates.convertSqlDateToUtilDate(rs.getDate("date_envoi")));
			invitation.setDateReponse(Dates.convertSqlDateToUtilDate(rs.getDate("date_reponse")));
			invitation.setEstAcceptee(rs.getBoolean("acceptation"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return invitation;
	}


	
	
	
}
