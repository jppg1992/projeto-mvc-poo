package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Fornecedor;
import model.Produto;

 

public class ControllerCadFornecedor {
	public Fornecedor fornecedor = null;
	private FornecedorDAO db = new FornecedorDAO();
	
	public boolean cadastrarFornecedor(JTextField campoNome, JTextField campoCnpj, JTextField campoRazaoSocial, JRadioButton sim, JRadioButton nao) {
		if(verificarCampos(campoNome, campoCnpj, campoRazaoSocial, sim , nao)) {
			fornecedor = new Fornecedor();
			fornecedor.setNome(campoNome.getText());
			fornecedor.setCnpj(Long.parseLong(campoCnpj.getText()));
			fornecedor.setRazaoSocial( campoRazaoSocial.getText()) ;
			if(sim.isSelected() == true)
				fornecedor.setParceria(true);
			else
				fornecedor.setParceria(false);
			
			JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado!");
			db.cadastrarFornecedor(fornecedor);
			
			
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
	
	public void listar(){
		List<Fornecedor> lista = db.listarFornecedores();
		
		for(Fornecedor fornecedor:lista)
			System.out.println(fornecedor);
	}
	
	public boolean verificarCampos(JTextField campoNome, JTextField campoCnpj, JTextField campoRazaoSocial, JRadioButton sim, JRadioButton nao) {
		boolean valido = true;
		
		if(campoNome.getText().matches("[0-9]*") || campoNome.getText().isEmpty()) {
			campoNome.setBackground(new Color(255, 0, 0));
			valido = false;
		}
		else {
			campoNome.setBackground(new Color(128, 255, 128));
		}
		
		try {
			Long.parseLong(campoCnpj.getText());
			campoCnpj.setBackground(new Color(128, 255, 128));
		}catch(Exception e) {
			campoCnpj.setBackground(new Color(255,0,0));
			valido = false;
		}
		
		if(campoRazaoSocial.getText().matches("[0-9]*") || campoRazaoSocial.getText().isEmpty()) {
			campoRazaoSocial.setBackground(new Color(255, 0, 0));
			valido = false;
		}
		else {
			campoRazaoSocial.setBackground(new Color(128, 255, 128));
		}
		
		
		if(!nao.isSelected() && !sim.isSelected())
			valido = false;
		
		return valido;
	}
	
	
	public void carregaTabela(JTable tabela) {
		List<Fornecedor> lista = new ArrayList<Fornecedor> ();
		lista =	db.listarFornecedores();
		
		DefaultTableModel model = (DefaultTableModel)tabela.getModel();
		
		model.setRowCount(lista.size());
		for (int i=0; i< lista.size(); i++) {
			
			
			model.setValueAt(lista.get(i).getNome(), i, 0);
			model.setValueAt(lista.get(i).getCnpj(), i, 1);
			model.setValueAt(lista.get(i).getRazaoSocial(), i, 2);
			if (lista.get(i).isParceria()) {
				model.setValueAt("Sim", i, 3);	
			}else {
				model.setValueAt("Não", i, 3);
			}
			
			
		}
		
	}
}
