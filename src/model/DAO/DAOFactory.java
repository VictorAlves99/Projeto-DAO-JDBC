package model.DAO;

import model.DAO.impl.VendedorDaoJDBC;

public class DAOFactory {

	public static VendedorDAO criaVendedorDAO() {
		return new VendedorDaoJDBC();
	}
	
}
