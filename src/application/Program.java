package application;

import entities.Vendedor;
import model.DAO.DAOFactory;
import model.DAO.VendedorDAO;

public class Program {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = DAOFactory.criaVendedorDAO();
		
		Vendedor vendedor = vendedorDAO.findById(3);
	
		System.out.println(vendedor);
		
	}
	
}
