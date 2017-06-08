package fr.humanbooster.liaison.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.liaison.business.Ville;

public interface VilleDao {
	// Find city
	Ville findCityById(int i);
	
	// Toutes les villes
	List<Ville> findAllCities() throws SQLException;

}
