package fr.humanbooster.liaison.coordination;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import fr.humanbooster.liaison.business.Personne;
import fr.humanbooster.liaison.service.PersonneService;
import fr.humanbooster.liaison.service.impl.PersonneServiceImpl;

@ManagedBean(name="majMdpBean")
@RequestScoped
public class MajMdpBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private PersonneService personneService;
	private String oldMdp;
	private String newMdp;
	private String checkNewMdp;
	
	public MajMdpBean() {
		try {
			personneService = new PersonneServiceImpl();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getOldMdp() {
		return oldMdp;
	}

	public void setOldMdp(String oldMdp) {
		this.oldMdp = oldMdp;
	}

	public String getNewMdp() {
		return newMdp;
	}

	public void setNewMdp(String newMdp) {
		this.newMdp = newMdp;
	}

	public String getCheckNewMdp() {
		return checkNewMdp;
	}

	public void setCheckNewMdp(String checkNewMdp) {
		this.checkNewMdp = checkNewMdp;
	}

	public void setPersonneService(PersonneService personneService) {
		this.personneService = personneService;
	}
	
	public String accessMajMdp(){
		return "majMdp";
	}
	
	public String validationMdp(){
		HttpSession session = SessionBean.getSession();
		Personne p = personneService.findById(Integer.parseInt(session.getAttribute("idPersonne").toString()));
		if(p.getMotDePasse().equals(oldMdp)){
			if(checkNewMdp.equals(newMdp)){
				try {
					personneService.majMotDePasse(p, newMdp);
					return "majSuccess";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "majMdp";
	}

}
