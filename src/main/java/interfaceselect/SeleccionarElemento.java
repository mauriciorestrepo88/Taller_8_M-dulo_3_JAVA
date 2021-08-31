package interfaceselect;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface SeleccionarElemento {
	
	public void setValues(PreparedStatement pm) throws SQLException;
		
	

}
