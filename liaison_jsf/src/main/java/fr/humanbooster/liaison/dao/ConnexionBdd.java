package fr.humanbooster.liaison.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBdd {

	 public static Connection getConnection() throws SQLException, ClassNotFoundException {
         Class.forName("com.mysql.jdbc.Driver");
         //System.out.println("Creation connexion");
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/liaison","root","");
         return connection ;
 }

}
