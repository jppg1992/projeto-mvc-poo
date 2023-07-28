package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerCadCliente;
import model.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable; 
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoRg;
	private JTable table;

	ControllerCadCliente controller = new ControllerCadCliente();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setResizable(false);
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
		
		campoCpf = new JTextField();
		campoCpf.setText("");
		campoCpf.setBounds(290, 8, 175, 21);
		panel.add(campoCpf);
		campoCpf.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(12, 48, 58, 17);
		panel.add(lblRg);
		
		campoRg = new JTextField();
		campoRg.setText("");
		campoRg.setBounds(60, 44, 125, 21);
		panel.add(campoRg);
		campoRg.setColumns(10);
		
		JLabel lblVip = new JLabel("VIP:");
		lblVip.setBounds(255, 48, 75, 17);
		panel.add(lblVip);
		
		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(290, 46, 50, 25);
		panel.add(rdbtnSim);
		
		JRadioButton rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setBounds(350, 46, 75, 25);
		panel.add(rdbtnNao);
		
		ButtonGroup grupo = new ButtonGroup();
		
		grupo.add(rdbtnNao);
		grupo.add(rdbtnSim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 115, 546, 214);
		panel.add(scrollPane);
		
		String[] header = { "Id","Nome","CPF","RG","VIP" };
		
	 
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "CPF", "RG", "VIP"
			}
		));
		
		controller.carregaTabela(table);
		scrollPane.setViewportView(table);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(450, 85, 101, 27);
		
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastrarCliente(campoNome, campoRg, campoCpf, rdbtnSim, rdbtnNao);
				
				Object[] options = { "Sim", "Não" };
			int resposta = JOptionPane.showOptionDialog(null, "Deseja continuar cadastrando?", "CADASTRO DE CLIENTE", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
			
			if (resposta == 0) {
				dispose();
				TelaCadastroCliente.main(null);
			}else {
				dispose();
				TelaMenuPrincipal.main(null);
			}
			
			}
		});
		
		panel.add(btnInserir);
		
		
	}
}
