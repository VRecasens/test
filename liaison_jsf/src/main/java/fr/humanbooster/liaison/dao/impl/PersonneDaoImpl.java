package fr.humanbooster.liaison.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.humanbooster.liaison.business.Personne;
import fr.humanbooster.liaison.dao.CiviliteDao;
import fr.humanbooster.liaison.dao.ConnexionBdd;
import fr.humanbooster.liaison.dao.PersonneDao;
import fr.humanbooster.liaison.dao.Requetes;
import fr.humanbooster.liaison.dao.VilleDao;
import fr.humanbooster.liaison.utils.Dates;

public class PersonneDaoImpl implements PersonneDao {
	private static Connection connection;
	private static CiviliteDao cdao;
	private static VilleDao vdao;

	public PersonneDaoImpl() throws ClassNotFoundException, SQLException {
		connection = ConnexionBdd.getConnection();
		cdao = new CiviliteDaoImpl();
		vdao = new VilleDaoImpl();
	}


	// Create personne
	public boolean createPersonne(Personne personne) throws SQLException {
		boolean isCreated = false;
		
		String query = Requetes.AJOUT_PERSONNE;
		PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		// Set param
		ps.setLong(1, personne.getCivilite().getId());
		ps.setString(2, personne.getNom());
		ps.setString(3, personne.getPrenom());
		ps.setString(4, personne.getEmail());
		ps.setString(5, personne.getMotDePasse());
		
		java.sql.Date sqlDateNaissance = Dates.convertUtilDateToSqlDate(personne.getDateNaissance());
		ps.setDate(6, sqlDateNaissance);
		
		ps.setLong(7, personne.getVille().getId());
		
		// Execute requete
		if(ps.executeUpdate() == 1) {
			ResultSet rs = ps.getGeneratedKeys();
			if(rs != null && rs.next()){
				personne.setId(rs.getInt(1));
			}
			isCreated = true;
			System.out.println("Une personne est crée");
		} else {
			System.out.println("Aucune personne n'est crée");
		}
		
		return isCreated;	
	}

	// Delete personne
	public boolean deletePersonne(Personne personne) throws SQLException {
		
		boolean isDeleted = false;
		new Requetes();
		String query = Requetes.SUPPR_PERSONNE_PAR_ID;
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Set param
		ps.setDouble(1, personne.getId());
		
		// Execute requete
		if(ps.executeUpdate() == 1) {
			isDeleted = true;
			System.out.println("Une personne a éte supprimée");
		} else {
			System.out.println("Aucune personne n'a éte supprimée");
		}
		
		return isDeleted;	
	}

	// Update Personne
	public boolean updateMdpPersonne(Personne personne) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Requetes.MAJ_MDP_PERSONNE);
		ps.setString(1, personne.getMotDePasse());
		ps.setInt(2, personne.getId());
		int check = ps.executeUpdate();
		if(check == 1)
			return true;
		
		else
			return false;
	}

	// All personnes
	public List<Personne> findAll() throws SQLException {
		List<Personne> personnes = new ArrayList<>();
		String query = Requetes.TOUTES_LES_PERSONNES;
		Personne personne;
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);	
		while(rs.next()) {				
			personne = new Personne(	
				rs.getString("nom"), 
				rs.getString("prenom"), 
				rs.getString("mail"), 
				rs.getDate("date_naissance")		
			);
			
			personne.setDateInscription(rs.getDate("date_inscription"));
			personne.setId(rs.getInt("idPersonne"));
			personne.setCivilite(cdao.findCivilityById(rs.getLong("idCivilite")));
			personne.setVille(vdao.findCityById(rs.getInt("idVille")));
			
			personnes.add(personne);
		}
		return personnes;
	}

	// Personne by id
	public Personne getPersonneById(int idPersonne) {
		PreparedStatement pst;
		Personne personne = null;
		String query = Requetes.PERSONNE_PAR_ID;
		try {
			pst = connection.prepareStatement(query);
			pst.setLong(1, idPersonne);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			rs.next();
			
			personne = new Personne(
					cdao.findCivilityById(rs.getInt("idCivilite")),
					rs.getString("nom"), 
					rs.getString("prenom"), 
					rs.getString("mail"),
					rs.getString("mdp"),
					rs.getDate("date_naissance"),
					vdao.findCityById(rs.getInt("idVille"))
			);
			personne.setDateInscription(rs.getDate("date_inscription"));
			personne.setId(rs.getInt("idPersonne"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personne;	
	}


	@Override
	public Personne findPersonneByMail(String email, String mdp) {
		PreparedStatement pst;
		Personne personne = null;
		String query = Requetes.PERSONNE_PAR_MAIL_ET_MDP;
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, mdp);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			rs.next();
			
			personne = new Personne(
					rs.getString("nom"), 
					rs.getString("prenom"), 
					rs.getString("mail"), 
					rs.getDate("date_naissance"));

			personne.setDateInscription(rs.getDate("date_inscription"));
			personne.setId(rs.getInt("idPersonne"));
			personne.setCivilite(cdao.findCivilityById(rs.getInt(9)));
			personne.setVille(vdao.findCityById(rs.getInt(7)));
			
			return personne;
			
		} catch (SQLException e) {
			return null;
		}
	}


	@Override
	public boolean checkPersonneByMail(String email, String mdp) {
		if(findPersonneByMail(email, mdp) != null)
			return true;
		else
			return false;
	}

}
