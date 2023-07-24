package model;

import java.util.ArrayList;
import java.util.List;

public class Executavel {

	public static void main(String[] args) {
		List<Cliente> ListaClientes = new ArrayList<Cliente>();
		List<Fornecedor> ListaFornecedores = new ArrayList<Fornecedor>();
		List<Produto> ListaProdutos = new ArrayList<Produto>();
		
		Cliente cliente1 = new Cliente (123, 321, "João", false);
		ListaClientes.add(cliente1);
		ListaClientes.add(new Cliente(456, 654, "maria", true));
		ListaClientes.add(new Cliente(456, 654, "bia", true));
		
		ListaFornecedores.add(new Fornecedor(78468344, "fornecedor", "emp ltda", false));
		ListaFornecedores.add(new Fornecedor(78468345, "fornecedora", "fornecedor inc", true));
		
		ListaProdutos.add(new Produto("Cama", 800f));
		ListaProdutos.add(new Produto("Mesa", 900f));
		ListaProdutos.add(new Produto("Sofá", 980f));
		ListaProdutos.add(new Produto("Geladeira", 1980f));
		
		Empresa empresa = new Empresa(8745, "POO Produtos importados", "PPI LTDA", ListaProdutos, ListaClientes, ListaFornecedores);
		System.out.println(empresa.getReceitas());
		empresa.vender(ListaProdutos.get(2), ListaClientes.get(0), Empresa.AVISTA);
		System.out.println(empresa.getReceitas());
		empresa.balanco();
		
	}

}
