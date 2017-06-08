package fr.humanbooster.liaison.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.liaison.business.Civilite;

public interface CiviliteDao {
	// Récupérer liste des civilités
	List<Civilite> findAllCivilities() throws SQLException;

	// Trouver civilite via idCivilite
	Civilite findCivilityById(long idCivilite);
}
