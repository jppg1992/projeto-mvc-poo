package controller;

import javax.swing.JButton;

public class ControllerMenuPrincipal {
	ControllerCadEmpresa controllerCadEmp = new ControllerCadEmpresa();
	public void habilitaBotao(JButton btnCriarEmpresa,JButton btnCadastrarFornecedores,JButton btnCadastrarClientes,JButton btnCadastrarProdutos,JButton btnVenderProdutos, JButton btnComprarProdutos) {
		if(controllerCadEmp.empresa == null) {
			btnCadastrarFornecedores.setEnabled(false);
			btnCadastrarClientes.setEnabled(false);
			btnCadastrarProdutos.setEnabled(false);
			btnVenderProdutos.setEnabled(false);
			btnComprarProdutos.setEnabled(false);
			
		}
		else {
			 
			
			if(controllerCadEmp.empresa.getClientes().size() == 0 || controllerCadEmp.empresa.getFornecedores().size() == 0 || controllerCadEmp.empresa.getProdutos().size() == 0) {
				btnCriarEmpresa.setEnabled(false);
				btnCadastrarFornecedores.setEnabled(true);
				btnCadastrarClientes.setEnabled(true);
				btnCadastrarProdutos.setEnabled(true);
				btnVenderProdutos.setEnabled(false);
				btnComprarProdutos.setEnabled(false);
				
			}
			else {
				btnCriarEmpresa.setEnabled(false);
				btnCadastrarFornecedores.setEnabled(true);
				btnCadastrarClientes.setEnabled(true);
				btnCadastrarProdutos.setEnabled(true);
				btnVenderProdutos.setEnabled(true);
				btnComprarProdutos.setEnabled(true);

			}
		}
	}

}
