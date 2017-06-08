package fr.humanbooster.liaison.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.liaison.business.Civilite;
import fr.humanbooster.liaison.dao.CiviliteDao;
import fr.humanbooster.liaison.dao.ConnexionBdd;
import fr.humanbooster.liaison.dao.Requetes;

public class CiviliteDaoImpl implements CiviliteDao {
	private static Connection connection;	

	public CiviliteDaoImpl() throws ClassNotFoundException, SQLException {
		connection = ConnexionBdd.getConnection();
	}
	
	// Récupérer liste des civilités
	public List<Civilite> findAllCivilities() throws SQLException {
		List<Civilite> civilites = new ArrayList<>();
		String query = Requetes.TOUTES_LES_CIVILITES;
		Civilite civilite;
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);	
		while(rs.next()) {				
			civilite = new Civilite(
				rs.getString("nom")				
			);
			civilite.setId(rs.getLong("idCivilite"));
			civilites.add(civilite);
		}
		return civilites;
	}

	// find Civility by id
	public Civilite findCivilityById(long idCivilite) {
		PreparedStatement pst;
		Civilite civilite = null;
		String query = Requetes.CIVILITE_PAR_ID;
		try {
			pst = connection.prepareStatement(query);
			pst.setLong(1, idCivilite);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			rs.next();
			
			civilite = new Civilite(
				rs.getString("nom")
			);
			
			civilite.setId(rs.getLong("idCivilite"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return civilite;
	}

	

}
