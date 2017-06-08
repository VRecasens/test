package fr.humanbooster.liaison.coordination;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import fr.humanbooster.liaison.business.Invitation;
import fr.humanbooster.liaison.business.Personne;
import fr.humanbooster.liaison.service.InvitationService;
import fr.humanbooster.liaison.service.PersonneService;

@ManagedBean(name = "invitationBean")
@RequestScoped
public class InvitationBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Personne> listPersonne;

	@ManagedProperty("#{personneServiceImpl}")
	private PersonneService personneService;

	@ManagedProperty("#{invitationServiceImpl}")
	private InvitationService invitationService;

	// Les données transmisent à la vue vont alimenter un objet Invitation
	private Invitation invitation;
	private Personne personne;
	private int idPersonneInvite;

	@PostConstruct
	public void init() {
		invitation = new Invitation();
		personne = new Personne();
		
		listPersonne = personneService.getAllPersons();

		// try {
		// personneService = new PersonneServiceImpl();
		// invitationService= new InvitationServiceImpl();
		// } catch (SQLException | ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public int getIdPersonneInvite() {
		return idPersonneInvite;
	}

	public void setIdPersonneInvite(int idPersonneInvite) {
		this.idPersonneInvite = idPersonneInvite;
	}

	public List<Personne> getListPersonne() {
		return listPersonne;
	}

	public void setListPersonne(List<Personne> listPersonne) {
		this.listPersonne = listPersonne;
	}

	public Invitation getInvitation() {
		return invitation;
	}

	public void setInvitation(Invitation invitation) {
		this.invitation = invitation;
	}
	
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public void setPersonneService(PersonneService personneService) {
		this.personneService = personneService;
	}

	public void setInvitationService(InvitationService invitationService) {
		this.invitationService = invitationService;
	}

	public String envoyer() {
		//On récupère  la valeur de la liste déroulante grâce à cette valeur et on l'ajoute à l'invitation
		Personne personneInvite = personneService.findById(idPersonneInvite);
		invitation.setPersonneInvite(personneInvite);
		
		HttpSession session = SessionBean.getSession();
		
		if(session.getAttribute("idPersonne") != null){
			invitation.setPersonneInvitant(personneService.findById(Integer.parseInt(session.getAttribute("idPersonne").toString())));
			try {
				invitationService.ajouterInvitation(invitation);
				//on redirige vers une page .xhtml
				return "invitationEnvoyer";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "invitation";
			}
		}
		else{
			System.out.println("session down");
			return "sessionExpire";
		}
	}

}
