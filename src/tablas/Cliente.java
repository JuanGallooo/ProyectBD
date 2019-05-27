package tablas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class Cliente {
	private Connection con;
	
	public Cliente(Connection con) {
		super();
		this.con = con;
	}

	public String consultaCliente(String tipo) {
		String retorno="";
		try {
			CallableStatement callSt= null;
	        callSt = con.prepareCall("{?= call pkconsultarsolicitudniveldos.fConsultarSolicitudPorCliente(?)}");
	        callSt.registerOutParameter(1,Types.VARCHAR);
	        callSt.setString(2, tipo);
	        callSt.execute();
	        retorno = callSt.getString(1);
		} catch (Exception e) {
			retorno= "Error : "+ e.getMessage();
		}
		return retorno;
	}
}
