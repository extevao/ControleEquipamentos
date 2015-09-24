package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConnection(){
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection("jdbc:mysql://localhost/base", "root", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
			//teste
		}
	}
}
