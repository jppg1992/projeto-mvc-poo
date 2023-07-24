package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField; 

import controller.ControllerCadEmpresa;

import javax.swing.JButton; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dialog.ModalExclusionType;

public class TelaCadastroEmpresa  extends JFrame{

	 
	private JTextField campoNome;
	private JTextField campoRazaoSocial;
	private JTextField campoCnpj;
	
	ControllerCadEmpresa controller = new ControllerCadEmpresa();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEmpresa window = new TelaCadastroEmpresa();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 
	/**
	 * Create the application.
	 */
	public TelaCadastroEmpresa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 
		 setResizable(false);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Dados Empresa");
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 50, 375, 175);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(8, 25, 58, 17);
		panel.add(lblNome);
		
		campoNome = new JTextField();
		campoNome.setText("");
		campoNome.setBounds(95, 20, 250, 21);
		panel.add(campoNome);
		campoNome.setColumns(10);
		
		JLabel lblRazaoSocial = new JLabel("Razão Social:");
		lblRazaoSocial.setBounds(8, 50, 101, 17);
		panel.add(lblRazaoSocial);
		
		campoRazaoSocial = new JTextField();
		campoRazaoSocial.setText("");
		campoRazaoSocial.setColumns(10);
		campoRazaoSocial.setBounds(95, 45, 250, 21);
		panel.add(campoRazaoSocial);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(8, 75, 58, 17);
		panel.add(lblCnpj);
		
		campoCnpj = new JTextField();
		campoCnpj.setText("");
		campoCnpj.setBounds(95, 70, 125, 21);
		panel.add(campoCnpj);
		campoCnpj.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(95, 100, 125, 27);
		panel.add(btnSalvar);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.cadastrarEmpresa(campoNome, campoCnpj, campoRazaoSocial);
			}
		});
	}
}
