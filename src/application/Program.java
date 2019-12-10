package application;

import java.util.Date;

import entities.Departamento;
import entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		Departamento obj = new Departamento(1,"Jorge");
		
		Vendedor vendedor = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		System.out.println(vendedor);
		
	}
	
}
