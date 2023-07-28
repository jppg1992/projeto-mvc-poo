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
		String sql = "INSERT INTO empresa (nome, cnpj, razaoSocial,caixa,receitas,dividas) VALUES(?,?,?,?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, empresa.getNome());
			statement.setLong(2, empresa.getCnpj());
			statement.setString(3, empresa.getRazaoSocial()); 
			statement.setFloat(4, empresa.getCaixa());
			statement.setFloat(5, empresa.getReceitas());
			statement.setFloat(6, empresa.getDividas());
		
			statement.execute();
			connection.commit();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizarrEmpresa(Empresa empresa) {
		String sql = "update empresa set caixa = ?, receitas = ?, dividas = ? ";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			 
			statement.setFloat(1, empresa.getCaixa());
			statement.setFloat(2, empresa.getReceitas());
			statement.setFloat(3, empresa.getDividas());
		
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
				empresa.setCaixa(resultado.getFloat("caixa"));
				empresa.setReceitas(resultado.getFloat("receitas"));
				empresa.setDividas(resultado.getFloat("dividas"));
				lista.add(empresa);	
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
}