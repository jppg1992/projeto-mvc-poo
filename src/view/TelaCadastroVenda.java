package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerCadCliente;
import controller.ControllerCadEmpresa;
import controller.ControllerCadProduto;
import controller.ControllerCadVendaCompra;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TelaCadastroVenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableProds;
	private JTable TableCli;

	ControllerCadVendaCompra controller = new ControllerCadVendaCompra();
	ControllerCadProduto controllerProd = new ControllerCadProduto();
	ControllerCadCliente controllerCli = new ControllerCadCliente();
	ControllerCadEmpresa controllerEmp = new ControllerCadEmpresa();
	private JTextField txtQtdvenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVenda frame = new TelaCadastroVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroVenda() {
		setResizable(false);
		setTitle("Cadastro de Vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 490);

		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 732, 448);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ITENS NO CADASTRO");
		lblNewLabel.setBounds(169, 30, 168, 15);
		panel.add(lblNewLabel);
		lblNewLabel.setLabelFor(tableProds);

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(503, 48, 217, 175);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblCaixa = new JLabel("Caixa");
		lblCaixa.setBounds(12, 9, 152, 15);
		panel_1.add(lblCaixa);

		JLabel lblReceitas = new JLabel("Receitas");
		lblReceitas.setBounds(12, 69, 193, 15);
		panel_1.add(lblReceitas);

		JLabel lblDvidas = new JLabel("Despesas");
		lblDvidas.setBounds(12, 128, 193, 15);
		panel_1.add(lblDvidas);

		JLabel lblPagamento = new JLabel("Pagto.:");
		lblPagamento.setBounds(503, 235, 64, 15);
		panel.add(lblPagamento);

		JRadioButton rdbtnPrazo = new JRadioButton("PRAZO");
		rdbtnPrazo.setBounds(643, 231, 77, 23);
		panel.add(rdbtnPrazo);

		JRadioButton rdbtnAVista = new JRadioButton("A VISTA");
		rdbtnAVista.setBounds(560, 231, 79, 23);
		panel.add(rdbtnAVista);

		ButtonGroup grupo = new ButtonGroup();

		grupo.add(rdbtnAVista);
		grupo.add(rdbtnPrazo);
		
		JLabel lblQtd = new JLabel("Qtd.:");
		lblQtd.setBounds(503, 274, 57, 15);
		panel.add(lblQtd);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(503, 355, 217, 15);
		panel.add(lblTotal);
		
		txtQtdvenda = new JTextField();
		txtQtdvenda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 try {
					int rowIndex =	tableProds.getSelectedRow();
					controller.calcularTotal(txtQtdvenda, lblTotal, tableProds, rowIndex);
				 }catch(Exception ex) {
					lblTotal.setText("Total: R$ 0,00") ;
				 }
			}
		});
		txtQtdvenda.setBounds(567, 272, 114, 19);
		panel.add(txtQtdvenda);
		txtQtdvenda.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(503, 315, 217, 15);
		panel.add(lblPreco);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 51, 475, 175);
		panel.add(scrollPane);

		tableProds = new JTable();
		tableProds.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int rowIndex =	tableProds.getSelectedRow();
			controller.carregaDadosProduto(lblPreco, tableProds, rowIndex);
			}
		});
		tableProds.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Descrição", "Cód. Barras", "Preço", "Qtd." }));
		controllerProd.carregaTabela(tableProds);
		 
		
		scrollPane.setViewportView(tableProds);

		JLabel lblClientesNoCadastro = new JLabel("CLIENTES NO CADASTRO");
		lblClientesNoCadastro.setBounds(169, 240, 168, 15);
		panel.add(lblClientesNoCadastro);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(16, 261, 475, 175);
		panel.add(scrollPane_1);

		TableCli = new JTable();
		TableCli.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "RG", "VIP" }));
		controllerCli.carregaTabela(TableCli);
		scrollPane_1.setViewportView(TableCli);

		
		JButton btnFinalizarVenda = new JButton("FINALIZAR VENDA");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rowIndexPr = -1;	

				int rowIndexCli = -1;	
				try {
					rowIndexPr = tableProds.getSelectedRow();
					rowIndexCli = TableCli.getSelectedRow();
					if (controller.validarVenda(rowIndexPr, rowIndexCli, txtQtdvenda, rdbtnPrazo, rdbtnAVista) == true) {
						 
						controller.calcularTotal(txtQtdvenda, lblTotal, tableProds, rowIndexPr);
						controller.vender(rowIndexPr, tableProds, rowIndexCli, TableCli, txtQtdvenda, rdbtnPrazo, rdbtnAVista);
						
						Object[] options = { "Sim", "Não" };
						int resposta = JOptionPane.showOptionDialog(null, "Deseja continuar cadastrando?", "CADASTRO DE VENDA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
						
						if (resposta == 0) {
							dispose();
							TelaCadastroVenda.main(null);
						}else {
							dispose();
							TelaMenuPrincipal.main(null);
						}
					}else {
						JOptionPane.showMessageDialog(null, "Preencher e selecionar todos campos necessários !!!!");
					}
				}	
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Preencher e selecionar todos campos necessários !!!!");
					System.out.println(ex.getMessage());
				}
				
			}
		});
		btnFinalizarVenda.setBounds(503, 392, 217, 25);
		panel.add(btnFinalizarVenda);
		
		controller.carregarBalanco(controllerEmp.empresa, lblReceitas, lblDvidas, lblCaixa);
		
		JButton btnBalanco = new JButton("Balanço");
		btnBalanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controller.balanco()) {
					dispose();
					TelaCadastroVenda.main(null);
				}
			}
		});	
		btnBalanco.setBounds(125, 6, 83, 21);
		panel_1.add(btnBalanco);

	}
}
