package tablas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class Tipo {
	private Connection con;
	public Tipo(Connection con) {
		super();
		this.con = con;
	}
	
	public String consultaTipo(String tipo) {
		String retorno="";
		try {
			CallableStatement callSt= null;
	        callSt = con.prepareCall("{?= call pkconsultarsolicitudniveldos.fConsultarSolicitudPorTipo(?)}");
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
