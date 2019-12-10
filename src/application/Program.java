package application;

import java.util.Date;
import java.util.List;

import entities.Departamento;
import entities.Vendedor;
import model.DAO.DAOFactory;
import model.DAO.VendedorDAO;

public class Program {

	public static void main(String[] args) {
		
		VendedorDAO vendedorDAO = DAOFactory.criaVendedorDAO();
		
		System.out.println("========================================================== Teste 1: FindById vendedor ===========================================================");
		System.out.println();
		
		Vendedor vendedor = vendedorDAO.findById(3);
		System.out.println(vendedor);
		
		System.out.println();
		
		System.out.println("===================================================== Teste 2: FindByDepartamento vendedor ======================================================");
		System.out.println();
		
		Departamento departamento = new Departamento(2,null);
		List<Vendedor> vendedores = vendedorDAO.findByDepartamento(departamento);
		vendedores.forEach(System.out::println);

		System.out.println();
		
		System.out.println("========================================================== Teste 3: FindAll vendedor ===========================================================");
		System.out.println();
		
		vendedores = vendedorDAO.findAll();
		vendedores.forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("=========================================================== Teste 4: Insert vendedor ============================================================");
		System.out.println();
		
		Vendedor novoVend = new Vendedor("Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDAO.insert(novoVend);
		System.out.println("Inserido! Novo id = " + novoVend.getId());
		
		System.out.println();
		System.out.println("=================================================================================================================================================");
		
	}
	
}
