package fr.humanbooster.liaison.service;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.liaison.business.Civilite;

public interface CiviliteService {
	// Récupérer liste des civilités
	List<Civilite> findAllCivilities() throws SQLException;
}
