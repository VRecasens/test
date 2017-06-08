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

/**
 * Servlet implementation class MAJMotDePasseServlet
 */
public class MAJMotDePasseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static PersonneService ps;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MAJMotDePasseServlet() {
        super();
        try {
			ps = new PersonneServiceImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("majMdp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean check = false;
		Personne personne = ps.findById(Integer.valueOf(request.getSession().getAttribute("idPersonne").toString()));
		String oldMotDePasse = personne.getMotDePasse();
		while(!check){
			check = true;
			String oldMdp = request.getParameter("oldMdp").toString();		
			String majMdp = request.getParameter("majMdp").toString();
			String majMdpCheck = request.getParameter("majMdpCheck").toString();
			
			if(oldMdp.equals(oldMotDePasse)){
				if(majMdpCheck.equals(majMdp)){
					try {
						check = ps.majMotDePasse(personne, majMdp);
						personne.setMotDePasse(majMdp);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else{
				System.out.println("Erreur dans les saisies. Recommencer");
				check = false;
			}
		}
		request.setAttribute("personne", personne);
		request.setAttribute("personnes", ps.getAllPersons());
		request.getRequestDispatcher("tableauDeBord.jsp").forward(request, response);
	}

}
