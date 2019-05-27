package tablas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Solicitud {
	
	private Connection con;
	
	
	public Solicitud(Connection con) {
		super();
		this.con = con;
	}
	public void crearCreacion(String tipo, String id, String observacion) {
		PreparedStatement stmt= null;   
		try{
			String tipoCodigo="";
			
			if( tipo.equals("Voz")) {
				tipoCodigo= "1";
			}
			else if( tipo.equals("Datos")) {
				tipoCodigo= "2";
			}
			else tipoCodigo="3";
			
		    stmt= con.prepareStatement("DECLARE\r\n" + 
		      		"BEGIN\r\n" + 
		      		"pkregistroniveldos.pSolicitudCreacion('"+id+"','"+tipoCodigo+"','"+observacion+"');\r\n" + 
		      		"END;\r\n" + 
		      		"");
		   stmt.execute();
		   stmt.close();   
		   } catch(SQLException sqle){
			   sqle.printStackTrace();
		   }		
	}
	public void crearModificacion(String tipo, String id, String nuevoTipo) {
		PreparedStatement stmt= null;   
		try{
			String tipoCodigo="";
			
			if( tipo.equals("Voz")) {
				tipoCodigo= "1";
			}
			else if( tipo.equals("Datos")) {
				tipoCodigo= "2";
			}
			else tipoCodigo="3";
			
			String nuevoTipoCodigo="";
			
			if( nuevoTipo.equals("Voz")) {
				nuevoTipoCodigo= "1";
			}
			else if( nuevoTipo.equals("Datos")) {
				nuevoTipoCodigo= "2";
			}
			else nuevoTipoCodigo="3";
			// La observacion de una solicitud de modificion es el nuevo servicio
		    stmt= con.prepareStatement("DECLARE\r\n" + 
		      		"BEGIN\r\n" + 
		      		"pkregistroniveldos.pSolicitudModificacion('"+id+"','"+tipoCodigo+"','"+nuevoTipoCodigo+"');\r\n" + 
		      		"END;\r\n" + 
		      		"");
		   stmt.execute();
		   stmt.close();   
		   } catch(SQLException sqle){
			   sqle.printStackTrace();
		   }		
	}
	public void crearCancelacion(String tipo, String id, String observacion) {
		PreparedStatement stmt= null;   
		try{
			String tipoCodigo="";
			
			if( tipo.equals("Voz")) {
				tipoCodigo= "1";
			}
			else if( tipo.equals("Datos")) {
				tipoCodigo= "2";
			}
			else tipoCodigo="3";
			
		    stmt= con.prepareStatement("DECLARE\r\n" + 
		      		"BEGIN\r\n" + 
		      		"pkregistroniveldos.pSolicitudCancelacion('"+id+"','"+tipoCodigo+"','"+observacion+"');\r\n" + 
		      		"END;\r\n" + 
		      		"");
		   stmt.execute();
		   stmt.close();   
		   } catch(SQLException sqle){
			   sqle.printStackTrace();
		   }		
	}
	public void crearDano(String tipo, String id, String observacion) {
		PreparedStatement stmt= null;   
		try{
			String tipoCodigo="";
			
			if( tipo.equals("Voz")) {
				tipoCodigo= "1";
			}
			else if( tipo.equals("Datos")) {
				tipoCodigo= "2";
			}
			else tipoCodigo="3";
			
		    stmt= con.prepareStatement("DECLARE\r\n" + 
		      		"BEGIN\r\n" + 
		      		"pkregistroniveldos.pSolicitudDaño('"+id+"','"+tipoCodigo+"','"+observacion+"');\r\n" + 
		      		"END;\r\n" + 
		      		"");
		   stmt.execute();
		   stmt.close();   
		   } catch(SQLException sqle){
			   sqle.printStackTrace();
		   }		
	}
	public void crearReclamo(String tipo, String id, String observacion) {
		PreparedStatement stmt= null;   
		try{
			String tipoCodigo="";
			
			if( tipo.equals("Voz")) {
				tipoCodigo= "1";
			}
			else if( tipo.equals("Datos")) {
				tipoCodigo= "2";
			}
			else tipoCodigo="3";
			
		    stmt= con.prepareStatement("DECLARE\r\n" + 
		      		"BEGIN\r\n" + 
		      		"pkregistroniveldos.pSolicitudReclamo('"+id+"','"+tipoCodigo+"','"+observacion+"');\r\n" + 
		      		"END;\r\n" + 
		      		"");
		   stmt.execute();
		   stmt.close();   
		   } catch(SQLException sqle){
			   sqle.printStackTrace();
		   }		
	}
}
