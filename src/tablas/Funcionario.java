package tablas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class Funcionario {
	private Connection con;
	public Funcionario(Connection con) {
		super();
		this.con = con;
	}
	public String consultaFuncionario(String funcionario) {
		String retorno="";
		try {
			CallableStatement callSt= null;
	        callSt = con.prepareCall("{?= call pkconsultarsolicitudniveldos.fConsultarSolicitudPorFuncionario(?)}");
	        callSt.registerOutParameter(1,Types.VARCHAR);
	        callSt.setString(2, funcionario);
	        callSt.execute();
	        retorno = callSt.getString(1);
		} catch (Exception e) {
			retorno= "Error : "+ e.getMessage();
		}
		return retorno;
	}
}
