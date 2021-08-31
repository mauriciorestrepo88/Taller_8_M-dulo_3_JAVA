package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBd {
	final String url = "jdbc:mysql://localhost:3325/javaBasico";
	final String dbname = "javaBasico";
	final String driver = "com.mysql.cj.jdbc.Driver";
	final String userdb = "root";
	final String pwdb = "root";
	private Connection connection = null;

	public Connection conectarse() {

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userdb, pwdb);
			this.estadoConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

	public void closeConexion() {
		try {
			connection.close();
			estadoConexion();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}

	private void estadoConexion() {
		try {
			if(!connection.isClosed()) {
				
				System.out.println ("Conexion a la base de datos "+ dbname + " correcta ");
				
			}
			else {
			System.out.println ("Conexion a la base de datos " + dbname + " cerrada ") ;
			}
		}catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		

	}

}
