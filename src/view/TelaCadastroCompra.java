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
 
import controller.ControllerCadEmpresa;
import controller.ControllerCadFornecedor;
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

public class TelaCadastroCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableProds;
	private JTable TableForn;

	ControllerCadVendaCompra controller = new ControllerCadVendaCompra();
	ControllerCadProduto controllerProd = new ControllerCadProduto();
	ControllerCadFornecedor controllerForn = new ControllerCadFornecedor();
	ControllerCadEmpresa controllerEmp = new ControllerCadEmpresa();
	private JTextField txtQtdCompra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCompra frame = new TelaCadastroCompra();
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
	public TelaCadastroCompra() {
		setResizable(false);
		setTitle("Cadastro de Compras");
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
		lblCaixa.setBounds(12, 18, 193, 15);
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
		
		txtQtdCompra = new JTextField();
		txtQtdCompra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 try {
					int rowIndex =	tableProds.getSelectedRow();
					controller.calcularTotal(txtQtdCompra, lblTotal, tableProds, rowIndex);
				 }catch(Exception ex) {
					lblTotal.setText("Total: R$ 0,00") ;
				 }
			}
		});
		txtQtdCompra.setBounds(567, 272, 114, 19);
		panel.add(txtQtdCompra);
		txtQtdCompra.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(503, 315, 217, 15);
		panel.add(lblPreco);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 48, 475, 175);
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

		JLabel lblFornecedoresNoCadastro = new JLabel("FORNECEDORES NO CADASTRO");
		lblFornecedoresNoCadastro.setBounds(169, 235, 247, 15);
		panel.add(lblFornecedoresNoCadastro);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(16, 261, 475, 175);
		panel.add(scrollPane_1);

		TableForn = new JTable();
		TableForn.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome",  "CNPJ", "Razão Social","Parceria" }));
		controllerForn.carregaTabela(TableForn);
		scrollPane_1.setViewportView(TableForn);

		
		JButton btnFinalizarCompra = new JButton("FINALIZAR COMPRA");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rowIndexPr = -1;	

				int rowIndexCli = -1;	
				try {
					rowIndexPr = tableProds.getSelectedRow();
					rowIndexCli = TableForn.getSelectedRow();
					if (controller.validarVenda(rowIndexPr, rowIndexCli, txtQtdCompra, rdbtnPrazo, rdbtnAVista) == true) {
						 
						controller.calcularTotal(txtQtdCompra, lblTotal, tableProds, rowIndexPr);
						controller.comprar(rowIndexPr, tableProds, rowIndexCli, TableForn, txtQtdCompra, rdbtnPrazo, rdbtnAVista);
						
						Object[] options = { "Sim", "Não" };
						int resposta = JOptionPane.showOptionDialog(null, "Deseja continuar cadastrando?", "CADASTRO DE VENDA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
						
						if (resposta == 0) {
							dispose();
							TelaCadastroCompra.main(null);
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
		btnFinalizarCompra.setBounds(503, 411, 217, 25);
		panel.add(btnFinalizarCompra);
		
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
		btnBalanco.setBounds(125, 12, 85, 27);
		panel_1.add(btnBalanco);

	}
}
