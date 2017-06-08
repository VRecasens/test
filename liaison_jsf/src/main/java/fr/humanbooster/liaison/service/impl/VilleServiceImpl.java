package fr.humanbooster.liaison.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.liaison.business.Ville;
import fr.humanbooster.liaison.dao.VilleDao;
import fr.humanbooster.liaison.dao.impl.VilleDaoImpl;
import fr.humanbooster.liaison.service.VilleService;

public class VilleServiceImpl implements VilleService {
	private static VilleDao vdao;
	
	// Constructor
	public VilleServiceImpl() throws ClassNotFoundException, SQLException {
		vdao = new VilleDaoImpl();		
	}
	
	// Find all cities
	public List<Ville> findAllCities() throws SQLException {
		return vdao.findAllCities();
	}

}
