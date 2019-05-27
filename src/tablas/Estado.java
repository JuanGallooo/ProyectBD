package tablas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class Estado {
	public Estado(Connection con) {
		super();
		this.con = con;
	}
	private Connection con;
	public String consultaEstado(String estado) {
		String retorno="";
		try {
			CallableStatement callSt= null;
	        callSt = con.prepareCall("{?= call pkconsultarsolicitudniveldos.fConsultarSolicitudPorEstado(?)}");
	        callSt.registerOutParameter(1,Types.VARCHAR);
	        callSt.setString(2, estado);
	        callSt.execute();
	        retorno = callSt.getString(1);
		} catch (Exception e) {
			retorno= "Error : "+ e.getMessage();
		}
		return retorno;
	}
}
