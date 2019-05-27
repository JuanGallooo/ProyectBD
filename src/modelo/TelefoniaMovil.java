package modelo;

import java.sql.Connection;

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
}
