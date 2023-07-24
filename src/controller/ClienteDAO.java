package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente; 

public class ClienteDAO {
	private Connection connection;

	public ClienteDAO() {
		connection = ConnectionDB.getConnetion();
	}
	
	public void cadastrarCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente (nome, cpf, rg, vip) VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, cliente.getNome());
			statement.setLong(2, cliente.getCpf());
			statement.setLong(3, cliente.getRg());
			statement.setBoolean(4, cliente.isVip());
			
			statement.execute();
			connection.commit();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente> listarClientes(){
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "SELECT * FROM cliente";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			
			ResultSet resultado;
			
			resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Cliente cliente = new Cliente();
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getLong("cpf"));
				cliente.setRg(resultado.getLong("rg"));
				cliente.setVip(resultado.getBoolean("vip"));
				lista.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
}