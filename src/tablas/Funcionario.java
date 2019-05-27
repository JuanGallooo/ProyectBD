package tablas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Random;

import javax.swing.JOptionPane;

public class Funcionario {
	private Connection con;
	public Funcionario(Connection con) {
		super();
		this.con = con;
	}//
	

	
	public void registrarFuncionario(String nombre, String contrasenha, String cedula, String direccion , String fn, String telefono) {
		Random n = new Random();		
		int random = n.nextInt(80000);
		String id = ""+ random;
		PreparedStatement stmt= null; 
		try {
		    stmt= con.prepareStatement("DECLARE\r\n" + 
		      		"BEGIN\r\n" + 
		      		"pkFuncionarioNivelUno.pInsertarFuncionario('" + id + "','" + nombre + "','"+ contrasenha + "','" + cedula + "','" + direccion + "',TO_DATE('"+ fn + "', 'yyyy/mm/dd')," + telefono + ");\r\n" + 
		      		"END;\r\n" + 
		      		"");
		   stmt.execute();
		   stmt.close();   
		   } catch(SQLException sqle){
			   JOptionPane.showMessageDialog(null, "Error en registrar funcionario", "Error", JOptionPane.ERROR_MESSAGE);
		   }
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
			retorno= "Error en consultar funcionario : "+ e.getMessage();
		}
		return retorno;
	}
	public void atenderSolicitud(String funcionario, String numSolicitud) {
		PreparedStatement stmt= null; 
		try {
		    stmt= con.prepareStatement("DECLARE\r\n" + 
		      		"BEGIN\r\n" + 
		      		"pkatencionniveldos.patendersolicitud('"+funcionario+"','"+numSolicitud+"');\r\n" + 
		      		"END;\r\n" + 
		      		"");
		   stmt.execute();
		   stmt.close();   
		   } catch(SQLException sqle){
			   JOptionPane.showMessageDialog(null, "Error en Atender la solicitud: " + numSolicitud, "Error", JOptionPane.ERROR_MESSAGE);
		   }	
    }
	
	public void atenderSolicitudDR(String funcionario, String numSolicitud, String respuesta) {
		PreparedStatement stmt= null;   
		try{
			String resCodigo="5";
			
			if( respuesta.compareToIgnoreCase("Anulada") == 0) {
				resCodigo= "6";
			}
			
		    stmt= con.prepareStatement("DECLARE\r\n" + 
		      		"BEGIN\r\n" + 
		      		"pkatencionniveldos.patendersolicituddr('"+funcionario+"','"+numSolicitud+"','"+resCodigo+"');\r\n" + 
		      		"END;\r\n" + 
		      		"");
		   stmt.execute();
		   stmt.close();   
		   } catch(SQLException sqle){
			   JOptionPane.showMessageDialog(null, "Error en Atender la solicitud: " + numSolicitud, "Error", JOptionPane.ERROR_MESSAGE);
		   }	
	}
}
