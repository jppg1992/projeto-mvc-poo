package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;

 

public class FornecedorDAO {
	private Connection connection;

	public FornecedorDAO() {
		connection = ConnectionDB.getConnetion();
	}
	
	public void cadastrarFornecedor(Fornecedor fornecedor) {
		String sql = "INSERT INTO fornecedor (nome, cnpj, razaoSocial, parceria) VALUES(?, ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, fornecedor.getNome());
			statement.setLong(2, fornecedor.getCnpj());
			statement.setString(3, fornecedor.getRazaoSocial());
			statement.setBoolean(4, fornecedor.isParceria());
			
			statement.execute();
			connection.commit();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Fornecedor> listarFornecedores(){
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		String sql = "SELECT * FROM fornecedor";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			
			ResultSet resultado;
			
			resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setNome(resultado.getString("nome"));
				fornecedor.setCnpj(resultado.getLong("cnpj"));
				fornecedor.setRazaoSocial(resultado.getString("razaoSocial"));
				fornecedor.setParceria(resultado.getBoolean("parceria"));
				lista.add(fornecedor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
}