package tablas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Random;

public class Cliente {
	private Connection con;
	
	public Cliente(Connection con) {
		super();
		this.con = con;
	}
	public void registrarCliente(String nombre, String contrasenha, String cedula, String direccion , String fn, String telefono) {
		Random n = new Random();		
		int random = n.nextInt(80000);
		String id = ""+ random;
		PreparedStatement stmt= null; 
		try {
		    stmt= con.prepareStatement("DECLARE\r\n" + 
		      		"BEGIN\r\n" + 
		      		"pkClienteNivelUno.pInsertarCliente('" + id + "','" + nombre + "','"+ contrasenha + "','" + cedula + "','" + direccion + "',TO_DATE('"+ fn + "', 'yyyy/mm/dd')," + telefono + ");\r\n" + 
		      		"END;\r\n" + 
		      		"");
		   stmt.execute();
		   stmt.close();   
		   } catch(SQLException sqle){
			   sqle.printStackTrace();
		   }	
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
