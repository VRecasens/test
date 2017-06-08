package fr.humanbooster.liaison.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.humanbooster.liaison.service.PersonneService;
import fr.humanbooster.liaison.service.impl.PersonneServiceImpl;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Nous sommedans la couche de coordi et ns faisons 
	// appel a la couche de service en utilisant un objet de type PersonneService
    private static PersonneService ps;   
    
    
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() throws ClassNotFoundException, SQLException {
        super();
        ps = new PersonneServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// L'internaute a demandé l'url 'http://localhost:8081/liaison_jsp/TestServlet'
		// Cette requete de type GET invoque la méthode doGet() de la servlet
		// La méthode doGet() possede 2 arguments : Objet 'resquest' et un objet 'response'
		response.getWriter()// Buffer
				.append("Bienvenue sur Liaison. Voici la liste des personnes : <br>" + ps.getAllPersons());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
