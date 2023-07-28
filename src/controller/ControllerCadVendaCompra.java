package controller;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Cliente;
import model.Empresa;
import model.Fornecedor;
import model.Produto;

public class ControllerCadVendaCompra {

	public void carregaDadosProduto(JLabel lblPreco, JTable table, int index) {

		lblPreco.setText("Preço: R$" + table.getModel().getValueAt(index, 2));

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

	public void calcularTotal(JTextField txtQtd, JLabel lblTotal, JTable table, int index) {

		float preco = (float) table.getModel().getValueAt(index, 2);
		int qtd = 0;
		try {
			qtd = Integer.parseInt(txtQtd.getText());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		float total = (preco * qtd);
		lblTotal.setText("TOTAL: R$" + total);

	}

	public void carregarBalanco(Empresa emp, JLabel lblReceitas, JLabel lblDesp, JLabel lblCaixa) {
		lblReceitas.setText("Receitas: R$" + emp.getReceitas());
		lblDesp.setText("Receitas: R$" + emp.getDividas());
		lblCaixa.setText("Caixa: R$" + emp.getCaixa());

	}

	public boolean validarVenda(int indexPr, int indexCli, JTextField txtQtd, JRadioButton rbtnPrazo,
			JRadioButton rbtnAvista) {
		boolean valido = false;
		if (indexPr >= 0)
			valido = true;

		if (indexCli >= 0)
			valido = true;
		try {
			Integer.parseInt(txtQtd.getText());
			txtQtd.setBackground(new Color(128, 255, 128));
			valido = true;
		} catch (Exception e) {
			txtQtd.setBackground(new Color(255, 0, 0));
			valido = false;
		}

		if (rbtnPrazo.isSelected() || rbtnAvista.isSelected())
			valido = true;

		return valido;
	}

	public boolean vender(int indexPr, JTable tableProd, int indexCli, JTable tableCli, JTextField txtQtd,
			JRadioButton rbtnPrazo, JRadioButton rbtnAvista) {

		try {
			ControllerCadEmpresa controllerEmp = new ControllerCadEmpresa();

			long cpf = (long) tableCli.getValueAt(indexCli, 1);
			int barras = (int) tableProd.getValueAt(indexPr, 1);

			Produto prod = null;
			for (Produto p : controllerEmp.empresa.getProdutos()) {
				if (p.getCodigoBarras() == barras) {
					prod = p;
				}
			}

			Cliente cli = null;
			for (Cliente c : controllerEmp.empresa.getClientes()) {
				if (c.getCpf() == cpf) {
					cli = c;
				}
			}

			int qtd = Integer.parseInt(txtQtd.getText());

			int PGTO = 0;
			if (rbtnPrazo.isSelected())
				PGTO = Empresa.APRAZO;
			else
				PGTO = Empresa.AVISTA;

			float valorRec =0;
			if (prod != null && cli != null)
				 valorRec = controllerEmp.empresa.vender(prod, cli, PGTO, qtd);
				
			controllerEmp.empresa.receber(valorRec);
			controllerEmp.atualizaEmpresa(controllerEmp.empresa.getCaixa(),controllerEmp.empresa.getReceitas(), controllerEmp.empresa.getDividas());
			JOptionPane.showMessageDialog(null, "Venda Finalizada Com Sucesso");
			return true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir Venda, msg:" + ex.getMessage());
			return false;
		}
	}
	
	public boolean comprar(int indexPr, JTable tableProd, int indexCli, JTable tableForn, JTextField txtQtd,
			JRadioButton rbtnPrazo, JRadioButton rbtnAvista) {

		try {
			ControllerCadEmpresa controllerEmp = new ControllerCadEmpresa();

			long cnpj = (long) tableForn.getValueAt(indexCli, 1);
			int barras = (int) tableProd.getValueAt(indexPr, 1);

			Produto prod = null;
			for (Produto p : controllerEmp.empresa.getProdutos()) {
				if (p.getCodigoBarras() == barras) {
					prod = p;
				}
			}

			Fornecedor forn = null;
			for (Fornecedor f : controllerEmp.empresa.getFornecedores()) {
				if (f.getCnpj() == cnpj) {
					forn = f;
				}
			}

			int qtd = Integer.parseInt(txtQtd.getText());

			int PGTO = 0;
			if (rbtnPrazo.isSelected())
				PGTO = Empresa.APRAZO;
			else
				PGTO = Empresa.AVISTA;

			float valorRec =0;
			if (prod != null && forn != null)
				 valorRec = controllerEmp.empresa.comprar(prod, forn, PGTO, qtd);
				
			controllerEmp.empresa.pagar(valorRec);
			controllerEmp.atualizaEmpresa(controllerEmp.empresa.getCaixa(),controllerEmp.empresa.getReceitas(), controllerEmp.empresa.getDividas());
			JOptionPane.showMessageDialog(null, "Compra Finalizada Com Sucesso");
			return true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir Compra, msg:" + ex.getMessage());
			return false;
		}
	}
	public boolean balanco() {

		try {
			ControllerCadEmpresa controllerEmp = new ControllerCadEmpresa();
			controllerEmp.empresa.balanco();
			controllerEmp.atualizaEmpresa(controllerEmp.empresa.getCaixa(),controllerEmp.empresa.getReceitas(), controllerEmp.empresa.getDividas());
			JOptionPane.showMessageDialog(null, "Balanço Finalizado Com Sucesso");
			return true;
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir Balanço, msg:" + exp.getMessage());
			return false;
		}
	}
}