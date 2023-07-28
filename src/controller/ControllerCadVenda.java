package controller;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Empresa;

public class ControllerCadVenda {
	
	public void carregaDadosProduto(JLabel lblPreco,JTable table, int index) {
		
		lblPreco.setText("Preço: R$"+table.getModel().getValueAt(index, 2));
		
	}
	
	public boolean validarQtd(JTextField txtQtd) {
		boolean valido = true;

		 
		try {
			Integer.parseInt(txtQtd.getText());
			txtQtd.setBackground(new Color(128, 255, 128));
		} catch (Exception e) {
			txtQtd.setBackground(new Color(255, 0, 0));
			valido = false;
		}
		
		return valido;
	}
	
	public void calcularTotal(JTextField txtQtd,JLabel lblTotal,JTable table, int index) {
		
	float preco	= (float) table.getModel().getValueAt(index, 2);
	int qtd = 0;
	try {
	 qtd = Integer.parseInt(txtQtd.getText());
	}catch (Exception e) {
	 System.out.println(e.getMessage());
	} 	
	float total = (preco * qtd);
	lblTotal.setText("TOTAL: R$"+total);
	
	}
	
	public void carregarBalanco(Empresa emp,JLabel lblReceitas, JLabel lblDesp,JLabel lblCaixa) {
		lblReceitas.setText("Receitas: R$"+emp.getReceitas());
		lblDesp.setText("Receitas: R$"+emp.getDividas());
		lblCaixa.setText("Caixa: R$"+emp.getCaixa());
		
	}
	
	public boolean validarVenda (int indexPr,int indexCli,JTextField txtQtd,JRadioButton rbtnPrazo,JRadioButton rbtnAvista  ) {
		boolean valido = false;
		if(indexPr >= 0)
			valido = true;
		
		if(indexCli >= 0)
			valido = true;
		try {
			Integer.parseInt(txtQtd.getText());
			txtQtd.setBackground(new Color(128, 255, 128));
			valido = true;
		}catch(Exception e) {
			txtQtd.setBackground(new Color(255,0,0));
			valido = false;
		}
		
		if (rbtnPrazo.isSelected()||rbtnAvista.isSelected())
			valido = true;
		
		return valido;
	}
}