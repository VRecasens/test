package fr.humanbooster.liaison.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.liaison.business.Invitation;
import fr.humanbooster.liaison.business.Personne;
import fr.humanbooster.liaison.service.InvitationService;
import fr.humanbooster.liaison.service.PersonneService;
import fr.humanbooster.liaison.service.impl.InvitationServiceImpl;
import fr.humanbooster.liaison.service.impl.PersonneServiceImpl;

/**
 * Servlet implementation class InvitationServlet
 */
public class InvitationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static PersonneService ps;
	private static InvitationService is;
	
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public InvitationServlet() throws ClassNotFoundException, SQLException {
        super();
        ps = new PersonneServiceImpl();
        is = new InvitationServiceImpl();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Déclarer une variable session
//		HttpSession session = request.getSession(true);
		
		// mémoriser l'id invite dans la session pour traitement message d'invitation(voir doGet())
		Personne personneInvitee = ps.findById(Integer.valueOf(request.getParameter("personneInvitee").toString()));
		System.out.println(personneInvitee);
		
		Personne personneInvitante = ps.findById(Integer.valueOf(request.getSession().getAttribute("idPersonne").toString()));
		System.out.println(personneInvitante);
		
		try {
			Invitation invit = is.ajouterInvitation("Veux-tu être mon ami?", personneInvitante, personneInvitee);
			System.out.println(invit);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("personne", personneInvitante);
		request.setAttribute("personnes", ps.getAllPersons());
		request.getRequestDispatcher("tableauDeBord.jsp").forward(request, response);
		//doGet(request, response);
	}

}
