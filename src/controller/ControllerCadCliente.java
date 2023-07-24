package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Cliente;

 

public class ControllerCadCliente {
	public Cliente cliente = null;
	private ClienteDAO db = new ClienteDAO();
	
	public boolean cadastrarCliente(JTextField campoNome, JTextField campoCPF, JTextField campoRG, JRadioButton sim, JRadioButton nao) {
		if(verificarCampos(campoNome, campoCPF, campoRG, sim , nao)) {
			cliente = new Cliente();
			cliente.setNome(campoNome.getText());
			cliente.setCpf(Long.parseLong(campoCPF.getText()));
			cliente.setRg(Long.parseLong(campoRG.getText()));
			if(sim.isSelected() == true)
				cliente.setVip(true);
			else
				cliente.setVip(false);
			
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
			db.cadastrarCliente(cliente);
			
			return true;
			

		}
		
		else {
			JOptionPane.showMessageDialog(null, "Erro de preenchimento!");
			return false;
		}
	}
	
	public void listar(){
		List<Cliente> lista = db.listarClientes();
		
		for(Cliente cliente:lista)
			System.out.println(cliente);
	}
	
	public boolean verificarCampos(JTextField campoNome, JTextField campoCPF, JTextField campoRG, JRadioButton sim, JRadioButton nao) {
		boolean valido = true;
		
		if(campoNome.getText().matches("[0-9]*") || campoNome.getText().isEmpty()) {
			campoNome.setBackground(new Color(255, 0, 0));
			valido = false;
		}
		else {
			campoNome.setBackground(new Color(128, 255, 128));
		}
		
		try {
			Long.parseLong(campoCPF.getText());
			campoCPF.setBackground(new Color(128, 255, 128));
		}catch(Exception e) {
			campoCPF.setBackground(new Color(255,0,0));
			valido = false;
		}
		
		try {
			Long.parseLong(campoRG.getText());
			campoRG.setBackground(new Color(128, 255, 128));
		}catch(Exception e) {
			campoRG.setBackground(new Color(255,0,0));
			valido = false;
		}
		
		if(!nao.isSelected() && !sim.isSelected())
			valido = false;
		
		return valido;
	}
}
