package fr.humanbooster.liaison.business;

import java.util.Date;

public class Invitation {
	private int id;
	private Personne personneInvitant;
	private Personne personneInvite;
	private String message;
	private static final String MESSAGE_DEFAULT = "Merci de rejoindre mon réseau personnel";
	private Date dateEnvoi;
	private Date dateReponse;
	private boolean estAcceptee;
	
	public Invitation() {
		this.message = MESSAGE_DEFAULT;
	}
	
	public Invitation(
		String message, 
		Personne personneInvitant, 
		Personne personneInvite
	) {
		this.message = message;
		this.estAcceptee = false;
		this.personneInvitant = personneInvitant;
		this.personneInvite = personneInvite;
	}


	// GETTERS & SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Personne getPersonneInvitant() {
		return personneInvitant;
	}
	public Personne getPersonneInvite() {
		return personneInvite;
	}
	public String getMessage() {
		return message;
	}
	public void setPersonneInvitant(Personne personneInvitant) {
		this.personneInvitant = personneInvitant;
	}
	public void setPersonneInvite(Personne personneInvite) {
		this.personneInvite = personneInvite;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(Date envoi) {
		this.dateEnvoi = envoi;
	}
	public Date getDateReponse() {
		return dateReponse;
	}
	public void setDateReponse(Date reponse) {
		this.dateReponse = reponse;
	}
	public boolean isEstAcceptee() {
		return estAcceptee;
	}
	public void setEstAcceptee(boolean estAccepte) {
		this.estAcceptee = estAccepte;
	}
	public static String getMessageDefault() {
		return MESSAGE_DEFAULT;
	}

	// ToString
	public String toString() {
		return "Invitation [id=" + id + ", personneInvitant=" + personneInvitant + ", personneInvite=" + personneInvite
				+ ", message=" + message + ", dateEnvoi=" + dateEnvoi + ", dateReponse=" + dateReponse
				+ ", estAcceptee=" + estAcceptee + "]";
	}
	
	
	
	
	
}
