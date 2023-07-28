package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Produto;

 

public class ControllerCadProduto {
	public Produto produto = null;
	private ProdutoDAO db = new ProdutoDAO();
	
	public boolean cadastrarProduto(JTextField campoNome, JTextField campoBarras, JTextField campoPreco, JTextField campoQuantidade) {
		if(verificarCampos(campoNome, campoBarras, campoPreco, campoQuantidade)) {
			produto = new Produto();
			produto.setNome(campoNome.getText());
			produto.setCodigoBarras(Integer.parseInt(campoBarras.getText()));
			produto.setPreco(Float.parseFloat(campoPreco.getText()));
			produto.setQuantidade(Integer.parseInt(campoQuantidade.getText()));
			
			JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
			db.cadastrarProduto(produto);
			
			return true;
			

		}
		
		else {
			JOptionPane.showMessageDialog(null, "Erro de preenchimento!");
			return false;
		}
	}
	
	public void listar(){
		List<Produto> lista = db.listarProdutos();
		
		for(Produto produto:lista)
			System.out.println(produto);
	}
	
	public boolean verificarCampos(JTextField campoNome, JTextField campoBarras, JTextField campoPreco, JTextField campoQuantidade) {
		boolean valido = true;
		
		if(campoNome.getText().matches("[0-9]*") || campoNome.getText().isEmpty()) {
			campoNome.setBackground(new Color(255, 0, 0));
			valido = false;
		}
		else {
			campoNome.setBackground(new Color(128, 255, 128));
		}
		
		try {
			Integer.parseInt(campoBarras.getText());
			campoBarras.setBackground(new Color(128, 255, 128));
		}catch(Exception e) {
			campoBarras.setBackground(new Color(255,0,0));
			valido = false;
		}
		
		try {
			Float.parseFloat(campoPreco.getText());
			campoPreco.setBackground(new Color(128, 255, 128));
		}catch(Exception e) {
			campoPreco.setBackground(new Color(255,0,0));
			valido = false;
		}
		
		try {
			Integer.parseInt(campoQuantidade.getText());
			campoQuantidade.setBackground(new Color(128, 255, 128));
		}catch(Exception e) {
			campoQuantidade.setBackground(new Color(255,0,0));
			valido = false;
		}
		
		return valido;
	}



	public void carregaTabela(JTable tabela) {
		List<Produto> lista = new ArrayList<Produto> ();
		lista =	db.listarProdutos();
		
		DefaultTableModel model = (DefaultTableModel)tabela.getModel();
		
		model.setRowCount(lista.size());
		for (int i=0; i< lista.size(); i++) {
			model.setValueAt(lista.get(i).getNome(), i, 0);
			model.setValueAt(lista.get(i).getCodigoBarras(), i, 1);
			model.setValueAt(lista.get(i).getPreco(), i, 2);
			model.setValueAt(lista.get(i).getQuantidade(), i, 3);
			
		}
		
	}
	
}