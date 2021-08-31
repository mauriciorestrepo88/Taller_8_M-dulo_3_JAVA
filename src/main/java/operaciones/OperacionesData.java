package operaciones;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class OperacionesData {

	private String cedulacliente;
	private String nombrecliente;
	private String emailcliente;
	private String telcliente;
	private String passcliente;

	public OperacionesData(String cedulacliente, String nombrecliente, String emailcliente, String telcliente,
			String passcliente) {
		this.cedulacliente = cedulacliente;
		this.nombrecliente = nombrecliente;
		this.emailcliente = emailcliente;
		this.telcliente = telcliente;
		this.passcliente = passcliente;

	}

	public OperacionesData(String cedulacliente, String emailcliente) {
		this.cedulacliente = cedulacliente;
		this.emailcliente = emailcliente;
	}

	public OperacionesData(String cedulacliente) {
		this.cedulacliente = cedulacliente;

	}

	public String getCedulacliente() {
		return cedulacliente;
	}

	public void setCedulacliente(String cedulacliente) {
		this.cedulacliente = cedulacliente;
	}

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getEmailcliente() {
		return emailcliente;
	}

	public void setEmailcliente(String emailcliente) {
		this.emailcliente = emailcliente;
	}

	public String getTelcliente() {
		return telcliente;
	}

	public void setTelcliente(String telcliente) {
		this.telcliente = telcliente;
	}

	public String getPasscliente() {
		Base64.Encoder encoder = Base64.getEncoder();
		String passencriptado = encoder.encodeToString(passcliente.getBytes(StandardCharsets.UTF_8));
		return passencriptado;
	}

	public void setPasscliente(String passcliente) {
		this.passcliente = passcliente;

	}

}
