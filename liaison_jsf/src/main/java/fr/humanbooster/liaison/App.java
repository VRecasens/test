package fr.humanbooster.liaison;

import java.sql.SQLException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Calendar;


//import fr.humanbooster.liaison.business.Invitation;
//import fr.humanbooster.liaison.business.Personne;
//import fr.humanbooster.liaison.dao.ConnexionBdd;
//import fr.humanbooster.liaison.dao.PersonneDao;
//import fr.humanbooster.liaison.dao.impl.InvitationDaoImpl;
//import fr.humanbooster.liaison.dao.impl.PersonneDaoImpl;

/**
 * Hello world!
 *
 */
public class App {
//	private static Connection connection;
//	private static PersonneDao pdao;
//	private static InvitationDaoImpl idao;
	
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    
//		try {
			
			// DATABASE CONNECTION
//			connection = ConnexionBdd.getConnection();
//			pdao = new PersonneDaoImpl();
//			idao = new InvitationDaoImpl();
			
			// ========================================================
			// Créer une personne
			// ========================================================
//			Calendar c1 = Calendar.getInstance();
//			Calendar c2 = Calendar.getInstance();
//			c1.set(2008, 22, 15);
//			c2.set(1982, 10, 20);
//			Personne p1 = new Personne("Toto", "Nguyen", "toto@live.fr", c1.getTime(), c2.getTime());		
			// pdao.createPersonne(p1);
			
			// ========================================================
			// Supprimer une personne via son id
			// ========================================================
			// Creer une méthode dans l'interface getPersonneById(Long idPersonne)
			// pdao.deletePersonne(p1);
			
			// ========================================================
			// Trouver une personne par id
			// ========================================================
//			System.out.println("\nPersonne portant id = 2 :");
//			System.out.println(pdao.getPersonneById(2L));
			
			// ========================================================
			// Créer une invitation
			// ========================================================			
//			Invitation invitation = new Invitation(Invitation.getMessageDefault(), new Date(), new Date(), true);
//			idao.createInvitation(invitation);
			
    	
    		// ========================================================
			// Créer une personne avec Scanner
			// ========================================================
//    		PersonneService ps = new PersonneServiceImpl();
//    							
//			System.out.println("\nVotre email :");
//			Scanner scanner = new Scanner(System.in);
//			String email = scanner.nextLine();
//			
//			System.out.println("\nVotre nom :");
//			String nom = scanner.nextLine();
//			
//			System.out.println("\nVotre prenom :");
//			String prenom = scanner.nextLine();
//			
//			System.out.println("\nVotre date de naissance :");
//			Date dateNaissance = new Dates().getDateFromString(scanner.nextLine());
//			// Add personne
//			//ps.ajouterPersonne(nom, prenom, email, new Date(), dateNaissance);
//			
//			scanner.close();
			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
        
    }
}
