package application;

import java.util.List;
import java.util.Scanner;

import entities.Departamento;
import model.DAO.DAOFactory;
import model.DAO.DepartamentoDAO;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartamentoDAO departamentoDAO = DAOFactory.criaDepartamentoDAO();
		
		System.out.println("========================================================== Teste 1: FindById departamento ===========================================================");
		System.out.println();
		
		Departamento departamento = departamentoDAO.findById(3);
		System.out.println(departamento);
		
		System.out.println();
		
		System.out.println("========================================================== Teste 2: FindAll departamento ===========================================================");
		System.out.println();
		
		List<Departamento> departamentos = departamentoDAO.findAll();
		departamentos.forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("=========================================================== Teste 3: Insert departamento ============================================================");
		System.out.println();
		
		Departamento novoDep = new Departamento("Musicas");
		departamentoDAO.insert(novoDep);
		System.out.println("Inserido! Novo id = " + novoDep.getId());
		
		System.out.println();
		
		System.out.println("=========================================================== Teste 4: Update departamento ============================================================");
		System.out.println();
		
		departamento = departamentoDAO.findById(1);
		departamento.setNome("Jogos Digitais");
		departamentoDAO.update(departamento);
		System.out.println("Atualizado!");
		
		System.out.println();
		
		System.out.println("=========================================================== Teste 5: Delete departamento ============================================================");
		System.out.println();

		System.out.print("Escolha o id que você deseja excluir: ");
		int id = sc.nextInt();
		departamentoDAO.deleteById(id);
		System.out.println("Deletado!");
		
		System.out.println();
		System.out.println("=================================================================================================================================================");
		
		sc.close();
	}
	
}
