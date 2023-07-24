package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Empresa; 

public class EmpresaDAO {
	private Connection connection;

	public EmpresaDAO() {
		connection = ConnectionDB.getConnetion();
	}
	
	public void cadastrarEmpresa(Empresa empresa) {
		String sql = "INSERT INTO empresa (nome, cnpj, razaoSocial) VALUES(?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, empresa.getNome());
			statement.setLong(2, empresa.getCnpj());
			statement.setString(3, empresa.getRazaoSocial()); 
			statement.execute();
			connection.commit();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Empresa> listarEmpresas(){
		List<Empresa> lista = new ArrayList<Empresa>();
		String sql = "SELECT * FROM empresa";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			
			ResultSet resultado;
			
			resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Empresa empresa = new Empresa();
				empresa.setNome(resultado.getString("nome"));
				empresa.setCnpj(resultado.getLong("cnpj"));
				empresa.setRazaoSocial(resultado.getString("razaoSocial"));
				 
				lista.add(empresa);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
}