package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

import javax.swing.table.DefaultTableModel;

import tablas.Cliente;
import tablas.Estado;
import tablas.Funcionario;
import tablas.Solicitud;
import tablas.Tipo;

public class TelefoniaMovil {
	private Solicitud tbsolicitud;
	private Funcionario tbFuncionario;
	private Estado tbEstado;
	private Tipo tbTipo;
	private Cliente tbCliente;
	private Connection con;
	private ConexionOracle oracle;
	private String idUsuario;
	
	public TelefoniaMovil() {
		super();
		oracle= new ConexionOracle();
		con= oracle.getConnection();
		tbsolicitud= new Solicitud(con);
		tbFuncionario= new Funcionario(con);
		tbEstado= new Estado(con);
		tbTipo= new Tipo(con);
		tbCliente= new Cliente(con);
	}
	public String consultaFuncionario(String funcionario) {
		return tbFuncionario.consultaFuncionario(funcionario);
	}
	public String consultaEstado(String estado) {
		return tbEstado.consultaEstado(estado);
	}
	public String consultaTipo(String tipo) {
		return tbTipo.consultaTipo(tipo);
	}
	public String consultaCliente(String cliente) {
		return tbCliente.consultaCliente(cliente);
	}
	public void crearSolicitudCreacion(String tipo, String id, String observacion) {
		tbsolicitud.crearCreacion(tipo,id,observacion);
	}
	public void crearSolicitudCancelacion(String tipo, String id, String observacion) {
		tbsolicitud.crearCancelacion(tipo, id, observacion);
	}
	public void crearSolicitudModificacion(String tipo, String id, String observacion) {
		tbsolicitud.crearModificacion(tipo, id, observacion);
	}
	public void crearSolicitudReclamo(String tipo, String id, String observacion) {
		tbsolicitud.crearReclamo(tipo, id, observacion);
	}
	public void crearSolicitudDano(String tipo, String id, String observacion) {
		tbsolicitud.crearDano(tipo, id, observacion);;
	}
	public void atenderSolicitud(String funcionario,String numSolicitud) {
		tbFuncionario.atenderSolicitud(funcionario, numSolicitud);
	}
	public void atenderSolicitudDR(String funcionario,String numSolicitud, String respuesta) {
		tbFuncionario.atenderSolicitudDR(funcionario, numSolicitud, respuesta);
	}
	public void registrarCliente(String nombre, String contrasenha, String cedula, String direccion , String fn, String telefono) {
		tbCliente.registrarCliente(nombre, contrasenha, cedula, direccion, fn, telefono);
	}
	public void registrarFuncionario(String nombre, String contrasenha, String cedula, String direccion , String fn, String telefono) {
		tbFuncionario.registrarFuncionario(nombre, contrasenha, cedula, direccion, fn, telefono);
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public DefaultTableModel solicitudesFuncionario() {
		DefaultTableModel tabla= new DefaultTableModel();
	       try{
	       tabla.addColumn("FECHA_ASIGNACION");
	       tabla.addColumn("FUNCIONARIO_ID");
	       tabla.addColumn("NUMSOLICITUD");
	       tabla.addColumn("NUMSOLICITUD");
	       tabla.addColumn("OBSERVACION");
	       tabla.addColumn("PRODUCTO_CODIGO");
	       tabla.addColumn("CLIENTE_ID");
	       CallableStatement cts=con.prepareCall("Select * from asignación inner join solicitud on (asignación.solicitud_numsolicitud=solicitud.numsolicitud) where asignación.funcionario_id ="+idUsuario);
	       ResultSet r=cts.executeQuery();
	       while (r.next()){
	       Object dato[]=new  Object[7];
	       for (int i=0; i<7; i++){
	           dato[i]=r.getString(i+1);
	       }
	       tabla.addRow(dato);
	       }
	       }
	       catch(Exception e){
	    	   e.printStackTrace();
	       }
		return tabla;
	}
}
