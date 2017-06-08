package fr.humanbooster.liaison.service;

import java.sql.SQLException;
import java.util.List;
import fr.humanbooster.liaison.business.Ville;

public interface VilleService {

	List<Ville> findAllCities() throws SQLException;

}
