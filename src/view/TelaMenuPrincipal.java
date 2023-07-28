package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
 
import controller.ControllerMenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaMenuPrincipal {

	private JFrame frame;

	ControllerMenuPrincipal controller = new ControllerMenuPrincipal();
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
		frame.setBounds(100, 100, 519, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Gestão da Empresa");
		
		 
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 323);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnEmpresa = new JButton("EMPRESA");
		btnEmpresa.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	frame.dispose();
		        	TelaCadastroEmpresa.main(null);
		        }
		    });
		btnEmpresa.setBounds(10, 8, 150, 125);
		 
		panel.add(btnEmpresa);
		
		JButton btnFornecedor = new JButton("FORNECEDORES");
		btnFornecedor.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		
	        		frame.dispose();
		        	TelaCadastroFornecedor.main(null);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
   	        }
	    });
		btnFornecedor.setBounds(172, 8, 150, 125);
		panel.add(btnFornecedor);
		
		JButton btnClientes = new JButton("CLIENTES");
		btnClientes.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        frame.dispose();
	      	TelaCadastroCliente.main(null);
	        }
	    });
		btnClientes.setBounds(338, 8, 150, 125);
		panel.add(btnClientes);
		
		JButton btnProdutos = new JButton("PRODUTOS");
		btnProdutos.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		
	        		frame.dispose();
		        	TelaCadastroProduto.main(null);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
   	        }
	    });
		btnProdutos.setBounds(10, 158, 150, 125);
		panel.add(btnProdutos);
		
		JButton btnComprar = new JButton("COMPRAR");
		btnComprar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		
	        		
	        		frame.dispose();
		        	TelaCadastroCompra.main(null);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
   	        }
	    });
		btnComprar.setBounds(172, 158, 150, 125);
		panel.add(btnComprar);
		
		JButton btnVender = new JButton("VENDER");
		btnVender.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		
	        		
	        		frame.dispose();
		        	TelaCadastroVenda.main(null);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
   	        }
	    });
		btnVender.setBounds(338, 158, 150, 125);
		panel.add(btnVender);
		
		 
	
		controller.habilitaBotao(btnEmpresa, btnFornecedor, btnClientes, btnProdutos, btnVender,btnComprar);
		
	}
}
