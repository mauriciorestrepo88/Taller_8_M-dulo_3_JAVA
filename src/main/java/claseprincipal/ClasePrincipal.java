package claseprincipal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.Query;
import com.mysql.cj.xdevapi.PreparableStatement;

import conexionbd.ConexionBd;
import interfaceselect.SeleccionarElemento;
import operaciones.OperacionesData;

public class ClasePrincipal {

	public static void main(String[] args) throws SQLException {

		ConexionBd connet = new ConexionBd();
		Connection conbd = connet.conectarse();

		//insertarData(conbd);
		//actualizarData(conbd);
		//eliminarData(conbd);
		//consultarInfo(conbd);
		
		
		try {
			conbd.close();
			
		}catch (SQLException er) {
			System.out.println("Error" + er);
		}

	}

	public static void insertarData(Connection conbd) {

		OperacionesData op = new OperacionesData("342639", "Camilo", "cc@gmail.com", "2346", "SFDR43");
		String insertdata = "insert into miTabla(cedulacliente,nombrecliente,emailcliente,telcliente,passcliente) "
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement dts = conbd.prepareStatement(insertdata);
			dts.setString(1, op.getCedulacliente());
			dts.setString(2, op.getNombrecliente());
			dts.setString(3, op.getEmailcliente());
			dts.setString(4, op.getTelcliente());
			dts.setString(5, op.getPasscliente());
			int count = dts.executeUpdate();
			System.out.println("El número de registros insertados es: " + count);
			dts.close();

		} catch (Exception datos) {

		}

	}

	public static void actualizarData(Connection conbd) {
		OperacionesData ac = new OperacionesData("987654", "TT@hotmail.com");
		String actuadata = "update  miTabla set emailcliente = ? where cedulacliente = ?";

		try {
			PreparedStatement dts = conbd.prepareStatement(actuadata);
			dts.setString(1, ac.getEmailcliente());
			dts.setString(2, ac.getCedulacliente());
			int countact = dts.executeUpdate();
			System.out.println("El número de registros actualizados es: " + countact);
			dts.close();

		} catch (Exception datos) {

		}

	}

	public static void eliminarData(Connection conbd) {

		OperacionesData el = new OperacionesData("342639");
		String elimidata = "delete from miTabla where cedulacliente = ?";

		try {
			PreparedStatement dts = conbd.prepareStatement(elimidata);
			dts.setString(1, el.getCedulacliente());
			int countelim = dts.executeUpdate();
			System.out.println("El número de registros eliminados es: " + countelim);
			dts.close();

		} catch (Exception datos) {

		}

	}

	private static void consultarInfo(Connection conbd) throws SQLException {

		OperacionesData el = new OperacionesData("342639");
		String consuldata = "select *  from miTabla where cedulacliente = ?";
		SeleccionarElemento lambda = (p) -> p.setString(1, el.getCedulacliente());
		PreparedStatement stm = prepareStatement(conbd, consuldata, lambda);
		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			System.out.println(
					"El nombre es: " + rs.getString("nombrecliente" ) + ";" + " El email es: " + rs.getString("emailcliente"));
		}

		try {
			conbd.close();
		} catch (SQLException err) {
			System.out.println("Error" + err);

		}

	}

	// Implemetación de la expresión Lambda

	public static PreparedStatement prepareStatement(Connection conbd, String sql, SeleccionarElemento setter) {

		PreparedStatement dts = null;
		try {
			dts = conbd.prepareStatement(sql);
			setter.setValues(dts); // Llamando método interfaz funcional

		} catch (Exception e) {

		}

		return dts;
	}
}
