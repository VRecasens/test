package fr.humanbooster.liaison.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.liaison.business.Civilite;
import fr.humanbooster.liaison.dao.CiviliteDao;
import fr.humanbooster.liaison.dao.impl.CiviliteDaoImpl;
import fr.humanbooster.liaison.service.CiviliteService;

public class CiviliteServiceImpl implements CiviliteService {
	private static CiviliteDao cdao;
	
	public CiviliteServiceImpl() throws ClassNotFoundException, SQLException {
		cdao = new CiviliteDaoImpl();		
	}
	
	// Récupérer liste des civilités
	public List<Civilite> findAllCivilities() throws SQLException {	
		return cdao.findAllCivilities() ;
	}

}
