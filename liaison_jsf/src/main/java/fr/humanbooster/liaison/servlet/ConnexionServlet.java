package fr.humanbooster.liaison.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.liaison.business.Personne;
import fr.humanbooster.liaison.service.PersonneService;
import fr.humanbooster.liaison.service.impl.PersonneServiceImpl;
import fr.humanbooster.liaison.utils.Mailer;

/**
 * Servlet implementation class ConnexionServlet
 */
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static PersonneService ps;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() throws ClassNotFoundException, SQLException {
        super();
        ps = new PersonneServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motDePasse");
		Personne personne = ps.verifierPersonne(email, motDePasse);
		System.out.println(personne);
		
		if(personne!=null){
//			La personne a saisi le bon mail et le bon MDP
//			On va créer un objet de session pour cette personne
//			Pour se faire, on utilise la méthode request.getSession().setAttribute(name, value);
			request.getSession().setAttribute("idPersonne", personne.getId());	
			
//			On redirige vers la page tableauDeBord.jsp
//			On enrichit au préalable l'objet request en ajoutant en attribut, l'objet Personne
			request.setAttribute("personne", personne);
			request.setAttribute("personnes", ps.getAllPersons());

			Mailer mailer = new Mailer();
			mailer.sendSimpleMail("vrecasens@humanbooster.com", "Nouvelle connexion à 'liaison_jsp'", "L'utilisateur "+ email + " s'est connecté");
			
			request.getRequestDispatcher("tableauDeBord.jsp").forward(request, response);
		}
//		doGet(request, response);
	}

}
