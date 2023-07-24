package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerCadCliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable; 
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class TelaCadastroCliente2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoRazaoSocial;
	private JTextField campoCnpj;
	private JTable table;

	ControllerCadCliente controller = new ControllerCadCliente();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente2 frame = new TelaCadastroCliente2();
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
	public TelaCadastroCliente2() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 594, 376);
		
		setTitle("Cadastro de Clientes");
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
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(255, 8, 175, 17);
		panel.add(lblCpf);
		
		campoRazaoSocial = new JTextField();
		campoRazaoSocial.setText("");
		campoRazaoSocial.setBounds(335, 8, 175, 21);
		panel.add(campoRazaoSocial);
		campoRazaoSocial.setColumns(10);
		
		JLabel lblRg = new JLabel("CNPJ:");
		lblRg.setBounds(12, 48, 58, 17);
		panel.add(lblRg);
		
		campoCnpj = new JTextField();
		campoCnpj.setText("");
		campoCnpj.setBounds(60, 50, 125, 21);
		panel.add(campoCnpj);
		campoCnpj.setColumns(10);
		
		JLabel lblParceiro = new JLabel("Parceiro:");
		lblParceiro.setBounds(255, 48, 58, 17);
		panel.add(lblParceiro);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(339, 46, 50, 25);
		panel.add(rdbtnSim);
		
		JRadioButton rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setBounds(423, 46, 50, 25);
		panel.add(rdbtnNao);
		
		ButtonGroup grupo = new ButtonGroup();
		
		grupo.add(rdbtnNao);
		grupo.add(rdbtnSim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 546, 214);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(400, 85, 101, 27);
		
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastrarCliente(campoNome, campoCnpj, campoRazaoSocial, rdbtnSim, rdbtnNao);
			}
		});
		
		panel.add(btnInserir);
		
		
	}
}
