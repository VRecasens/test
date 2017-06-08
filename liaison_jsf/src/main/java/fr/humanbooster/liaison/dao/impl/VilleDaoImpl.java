package fr.humanbooster.liaison.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.liaison.business.Ville;
import fr.humanbooster.liaison.dao.ConnexionBdd;
import fr.humanbooster.liaison.dao.Requetes;
import fr.humanbooster.liaison.dao.VilleDao;

public class VilleDaoImpl implements VilleDao {
	private static Connection connection;

	public VilleDaoImpl() throws ClassNotFoundException, SQLException {
		connection = ConnexionBdd.getConnection();
	}
	
	// Find ville by id
	public Ville findCityById(int idVille) {
		PreparedStatement pst;
		Ville ville = null;
		String query = Requetes.VILLE_PAR_ID;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, idVille);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			rs.next();
			
			ville = new Ville(
					rs.getString("nom")
			);
			ville.setId(rs.getInt("idVille"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ville;
	}

	// Find All Cities
	public List<Ville> findAllCities() throws SQLException {
		List<Ville> villes = new ArrayList<>();
		String query = Requetes.TOUTES_LES_VILLES;
		Ville ville;
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery(query);	
		while(rs.next()) {				
			ville = new Ville(
				rs.getString("nom")				
			);
			ville.setId(rs.getInt("idVille"));
			villes.add(ville);
		}
		return villes;
	}
	
}
