package fr.humanbooster.liaison.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fr.humanbooster.liaison.business.Civilite;
import fr.humanbooster.liaison.business.Personne;
import fr.humanbooster.liaison.business.Ville;

public interface PersonneService {
	public Personne ajouterPersonne(Civilite civilite, String nom, String prenom, String email, String motDePasse, Date dateNaissance, Ville ville);
	public List<Personne> getAllPersons();
	public Personne verifierPersonne(String email, String mdp);
	public boolean verifPersonne(String email, String mdp);
	public Personne findById(int idPersonne);
	public boolean majMotDePasse(Personne personne, String mdp) throws SQLException;
}
