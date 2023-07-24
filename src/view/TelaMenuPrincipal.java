package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControllerCadEmpresa;

 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaMenuPrincipal {

	private JFrame frame;

	ControllerCadEmpresa controller = new ControllerCadEmpresa();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuPrincipal window = new TelaMenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Gestão da Empresa");
		
		TelaCadastroEmpresa telaEmpresa = new TelaCadastroEmpresa();
		TelaCadastroFornecedor telaFornecedor = new TelaCadastroFornecedor();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 300);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnEmpresa = new JButton("EMPRESA");
		btnEmpresa.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	telaEmpresa.setVisible(true);
		        }
		    });
		btnEmpresa.setBounds(10, 8, 135, 111);
		if (controller.empresaCadastrada()) {
			btnEmpresa.setEnabled(false);
		}else {
			btnEmpresa.setEnabled(true);
		}
		
		panel.add(btnEmpresa);
		
		JButton btnFornecedor = new JButton("FORNECEDORES");
		btnFornecedor.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		
	        		telaFornecedor.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
   	        }
	    });
		btnFornecedor.setBounds(172, 8, 135, 111);
		panel.add(btnFornecedor);
		
	}
}
