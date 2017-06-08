package fr.humanbooster.liaison.dao;

import java.sql.SQLException;
import java.util.List;
import fr.humanbooster.liaison.business.Personne;

public interface PersonneDao {
	
	// On fournit les méthodes CRUD
	public boolean createPersonne(Personne personne) throws SQLException;	
	public boolean deletePersonne(Personne personne) throws SQLException;
	public boolean updateMdpPersonne(Personne personne) throws SQLException;
	public Personne getPersonneById(int l);
	
	public List<Personne> findAll() throws SQLException;
	public Personne findPersonneByMail(String email, String mdp);
	public boolean checkPersonneByMail(String email, String mdp);
	
	
}
