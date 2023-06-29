package br.com.fiap.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection conect() {
		
		try {
			//retorna uma conexão
			return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL","root","root");
		} catch (SQLException e) {
			//se ocorrer erros ele trata e informa o motivo.
			System.out.println("ERROR");
			throw new RuntimeException(e);
		}
		
	}
	
	
}
