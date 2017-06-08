package fr.humanbooster.liaison.business;

public class Civilite {
	private Long id;
	private String nom;

	public Civilite(String nom) {
		this.nom = nom;
	}

	// GETTERS & SETTERS
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// ToString
	public String toString() {
		return "Civilite [nom=" + nom + "]";
	}
	
	
}
