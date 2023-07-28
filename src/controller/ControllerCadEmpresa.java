package controller;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;

import javax.swing.JTextField;

import model.Cliente;
import model.Empresa;
import model.Fornecedor;
import model.Produto;

public class ControllerCadEmpresa {

	private ProdutoDAO dbProd = new ProdutoDAO();
	private ClienteDAO dbCli = new ClienteDAO();
	private FornecedorDAO dbForn = new FornecedorDAO();
	
	
	private EmpresaDAO db = new EmpresaDAO();
	public Empresa empresa = this.carregaEmpresa();

	public boolean cadastrarEmpresa(JTextField campoNome, JTextField campoCnpj, JTextField campoRazaoSocial) {
		if (verificarCampos(campoNome, campoCnpj, campoRazaoSocial)) {
			empresa = new Empresa();
			empresa.setNome(campoNome.getText());
			empresa.setCnpj(Long.parseLong(campoCnpj.getText()));
			empresa.setRazaoSocial(campoRazaoSocial.getText());
			empresa.setCaixa(0);
			empresa.setDividas(0);
			empresa.setReceitas(0);
			JOptionPane.showMessageDialog(null, "Empresa Cadastrada!");
			db.cadastrarEmpresa(empresa);

			campoNome.setText("");
			campoCnpj.setText("");
			campoRazaoSocial.setText("");
			return true;
		}

		else {
			JOptionPane.showMessageDialog(null, "Erro de preenchimento!");
			return false;
		}
	}

	public List<Empresa> listar() {
		List<Empresa> lista = db.listarEmpresas();

		return lista;
	}

	public boolean empresaCadastrada() {
		List<Empresa> lista = db.listarEmpresas();

		if (lista.size() > 0) {
			return true;
		}
		return false;
	}

	public boolean verificarCampos(JTextField campoNome, JTextField campoCnpj, JTextField campoRazaoSocial) {
		boolean valido = true;

		if (campoNome.getText().matches("[0-9]*") || campoNome.getText().isEmpty()) {
			campoNome.setBackground(new Color(255, 0, 0));
			valido = false;
		} else {
			campoNome.setBackground(new Color(128, 255, 128));
		}

		try {
			Long.parseLong(campoCnpj.getText());
			campoCnpj.setBackground(new Color(128, 255, 128));
		} catch (Exception e) {
			campoCnpj.setBackground(new Color(255, 0, 0));
			valido = false;
		}

		if (campoRazaoSocial.getText().matches("[0-9]*") || campoRazaoSocial.getText().isEmpty()) {
			campoRazaoSocial.setBackground(new Color(255, 0, 0));
			valido = false;
		} else {
			campoRazaoSocial.setBackground(new Color(128, 255, 128));
		}

		return valido;
	}

	public Empresa carregaEmpresa() {
		List<Empresa> empresas = this.listar();
		if (empresas.size() > 0) {
			Empresa emp = empresas.get(0);
			this.carregaProdutos(emp);
			this.carregaClientes(emp);
			this.carregaFornecedores(emp);
		
			return emp;
		} else
			return null;

	}

	public void carregaProdutos(Empresa emp) {
		if (emp != null) {
			List<Produto> produtos = dbProd.listarProdutos();

			for (Produto p : produtos) { 
				emp.getProdutos().add(p);
			}
		}
	}
	
	public void carregaClientes(Empresa emp) {
		if (emp != null) {
			List<Cliente> clientes = dbCli.listarClientes();

			for (Cliente c : clientes) { 
				emp.getClientes().add(c);
			}
		}
	}
	
	public void carregaFornecedores(Empresa emp) {
		if (emp != null) {
			List<Fornecedor> fornecedores = dbForn.listarFornecedores();

			for (Fornecedor f : fornecedores) { 
				emp.getFornecedores().add(f);
			}
		}
	}
}
