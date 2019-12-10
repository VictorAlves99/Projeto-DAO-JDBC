package model.DAO;

import db.DB;
import model.DAO.impl.VendedorDaoJDBC;

public class DAOFactory {

	public static VendedorDAO criaVendedorDAO() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
	
}
