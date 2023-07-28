package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerCadCliente;
import controller.ControllerCadProduto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable; 
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoBarras;

	ControllerCadProduto controller = new ControllerCadProduto();
	private JTextField campoPreco;
	private JTextField campoQtd;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 594, 376);
		
		setTitle("Cadastro de Produtos");
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 570, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 8, 58, 17);
		panel.add(lblNome);
		
		campoNome = new JTextField();
		campoNome.setText("");
		campoNome.setBounds(60, 8, 175, 21);
		panel.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblBarras = new JLabel("Cód. Barras:");
		lblBarras.setBounds(255, 8, 175, 17);
		panel.add(lblBarras);
		
		campoBarras = new JTextField();
		campoBarras.setText("");
		campoBarras.setBounds(350, 8, 175, 21);
		panel.add(campoBarras);
		campoBarras.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setBounds(12, 48, 58, 17);
		panel.add(lblPreco);
		
		 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 546, 214);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descrição", "Cód. Barras", "Preço", "Qtd."
			}
		));
		
		controller.carregaTabela(table);
		
		scrollPane.setViewportView(table);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(450, 85, 101, 27);
		
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastrarProduto(campoNome, campoBarras, campoPreco, campoQtd);
				
				Object[] options = { "Sim", "Não" };
				int resposta = JOptionPane.showOptionDialog(null, "Deseja continuar cadastrando?", "CADASTRO DE PRODUTO", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				
				if (resposta == 0) {
					dispose();
					TelaCadastroProduto.main(null);
				}else {
					dispose();
					TelaMenuPrincipal.main(null);
				}
			}
		});
		
		panel.add(btnInserir);
		
		campoPreco = new JTextField();
		campoPreco.setBounds(60, 47, 100, 19);
		panel.add(campoPreco);
		campoPreco.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(260, 49, 100, 15);
		panel.add(lblQuantidade);
		
		campoQtd = new JTextField();
		campoQtd.setBounds(350, 47, 100, 19);
		panel.add(campoQtd);
		campoQtd.setColumns(10);
		
		
	}
}
