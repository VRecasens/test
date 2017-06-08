package fr.humanbooster.liaison.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.humanbooster.liaison.business.Civilite;
import fr.humanbooster.liaison.business.Personne;
import fr.humanbooster.liaison.business.Ville;
import fr.humanbooster.liaison.dao.PersonneDao;
import fr.humanbooster.liaison.dao.impl.PersonneDaoImpl;
import fr.humanbooster.liaison.service.PersonneService;

@ManagedBean(name="personneServiceImpl", eager = true)
public class PersonneServiceImpl implements PersonneService {
	private static PersonneDao pdao;
	
	// Constructeur + initialisation pdao 
	public PersonneServiceImpl() throws ClassNotFoundException, SQLException {
		pdao = new PersonneDaoImpl();
	}

	// Ajout personne
	public Personne ajouterPersonne(Civilite civilite, String nom, String prenom, String email, String motDePasse, Date dateNaissance, Ville ville) {
		Personne personne = new Personne(civilite, nom, prenom, email, motDePasse, dateNaissance, ville);
		try {
			pdao.createPersonne(personne);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  personne;
	}
	
	// Liste des personnes
	public List<Personne> getAllPersons() {
		List<Personne> personnes = new ArrayList<>();
		
		try {
			personnes = pdao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return personnes;		
	}

	@Override
	public Personne verifierPersonne(String email, String mdp) {
		Personne pers = pdao.findPersonneByMail(email, mdp);
		return pers;
	}

	@Override
	public boolean verifPersonne(String email, String mdp) {
		return pdao.checkPersonneByMail(email, mdp);
	}

	@Override
	public Personne findById(int idPersonne) {
		// TODO Auto-generated method stub
		Personne pers = pdao.getPersonneById(idPersonne);
		return pers;
	}

	@Override
	public boolean majMotDePasse(Personne personne, String mdp) throws SQLException {
		// TODO Auto-generated method stub
		personne.setMotDePasse(mdp);
		return pdao.updateMdpPersonne(personne);
	}
}
