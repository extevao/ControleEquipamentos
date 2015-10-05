package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public abstract class ConnectionFactory {
	protected PreparedStatement stmtp = null;
	protected ResultSet rs = null;
	protected Connection connection = null;

	
	protected Connection getConnection() throws SQLException {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/controle", "root", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}	

}
