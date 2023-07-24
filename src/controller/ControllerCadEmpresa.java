package controller;

import java.awt.Color; 
import java.util.List;

import javax.swing.JOptionPane;
 
import javax.swing.JTextField;

import model.Empresa;

 
public class ControllerCadEmpresa {
	public Empresa empresa = null;
	private EmpresaDAO db = new EmpresaDAO();
	
	public boolean cadastrarEmpresa(JTextField campoNome, JTextField campoCnpj, JTextField campoRazaoSocial) {
		if(verificarCampos(campoNome, campoCnpj, campoRazaoSocial)) {
		empresa = new Empresa();
		empresa.setNome(campoNome.getText());
		empresa.setCnpj(Long.parseLong(campoCnpj.getText()));
		empresa.setRazaoSocial( campoRazaoSocial.getText());
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
	
	public void listar(){
		List<Empresa> lista = db.listarEmpresas();
		
		for(Empresa empresa:lista)
			System.out.println(empresa);
	}
	
	public boolean empresaCadastrada(){
		List<Empresa> lista = db.listarEmpresas();
		
		 if (lista.size() > 0) {
			 return true;
		 }
		 return false;
	}

	
	public boolean verificarCampos(JTextField campoNome, JTextField campoCnpj, JTextField campoRazaoSocial) {
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
		
		return valido;
	}
}
