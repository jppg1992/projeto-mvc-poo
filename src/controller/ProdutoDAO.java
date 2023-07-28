package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import model.Produto; 

public class ProdutoDAO {
	private Connection connection;

	public ProdutoDAO() {
		connection = ConnectionDB.getConnetion();
	}
	
	public void cadastrarProduto(Produto produto) {
		String sql = "INSERT INTO produto (nome, codigoBarras, preco,quantidade) VALUES(?, ?, ?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, produto.getNome());
			statement.setInt(2, produto.getCodigoBarras());
			statement.setFloat(3, produto.getPreco());
			statement.setInt(4, produto.getQuantidade());
			
			statement.execute();
			connection.commit();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarProduto(Produto produto) {
		String sql = "UPDATE produto SET nome = ? ,preco = ? ,quantidade = ? WHERE codigoBarras = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, produto.getNome());
			statement.setFloat(2, produto.getPreco());
			statement.setInt(3, produto.getQuantidade());
			statement.setInt(4, produto.getCodigoBarras());
			
			statement.execute();
			connection.commit();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> listarProdutos(){
		List<Produto> lista = new ArrayList<Produto>();
		String sql = "SELECT * FROM produto";
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			
			ResultSet resultado;
			
			resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Produto produto = new Produto();
				produto.setNome(resultado.getString("nome"));
				produto.setCodigoBarras(resultado.getInt("codigoBarras"));
				produto.setQuantidade(resultado.getInt("quantidade"));
				produto.setPreco(resultado.getFloat("preco"));
				 
				lista.add(produto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
}