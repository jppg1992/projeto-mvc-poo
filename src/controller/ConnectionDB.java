package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	private static String url = "jdbc:postgresql://localhost:5432/projeto_poo";
	private static String password = "postgres";
	private static String user = "postgres";
	private static Connection connection = null;
	
	public ConnectionDB() {
		conectar();
	}
	
	static {
		conectar();
	}
	
	private static void conectar() {
		try {
			if(connection == null) {
				DriverManager.registerDriver(new org.postgresql.Driver());
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conexão aberta!");
			}	
			
		}catch (Exception e) {
			System.out.println("Erro ao conectar ao banco!");
			e.printStackTrace();
		}	
	}
	
	public static Connection getConnetion() {
		return connection;
	}
}