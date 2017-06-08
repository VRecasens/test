package fr.humanbooster.liaison.coordination;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.humanbooster.liaison.business.Personne;
import fr.humanbooster.liaison.service.PersonneService;
import fr.humanbooster.liaison.service.impl.PersonneServiceImpl;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean  implements Serializable{
	private static final long serialVersionUID = 1L;

	private PersonneService personneService;
	private Personne personne = null;
	private String email;
	private String motDePasse;

	public LoginBean(){
		try {
			personneService = new PersonneServiceImpl();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public String validConnexion(){
		boolean check = personneService.verifPersonne(getEmail(), getMotDePasse());
		if(check){
			personne = personneService.verifierPersonne(getEmail(), getMotDePasse());
			HttpSession session = SessionBean.getSession();
			session.setAttribute("idPersonne", personne.getId());
			return "invitation";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_WARN, "Login ou mot de passe incorrect","Veuillez saisir des identifiants valides"));
			return "login";
		}
	}
	
	public String logoutConnexion(){
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "logout";
	}
	
	public String accueil(){
		logoutConnexion();
		return "login";
	}
	
	public String tdb(){
		return "invitation";
	}

}
