package fr.humanbooster.liaison.coordination;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionBean {

	public static HttpSession getSession(){
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
}
