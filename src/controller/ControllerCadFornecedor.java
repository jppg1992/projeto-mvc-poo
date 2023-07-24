package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Fornecedor;

 

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
}
