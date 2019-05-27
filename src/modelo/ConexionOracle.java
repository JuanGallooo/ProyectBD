package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {
	private Connection con;
	
	public ConexionOracle() {
		inicializarConnection();
	}
	
	public void inicializarConnection() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@200.3.193.24:1522/ESTUD","P09551_1_14","P09551_1_14_20191");
		} catch (SQLException e) {
			System.out.println("No se pudo establecer la conexion");
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return con;
	}
}
