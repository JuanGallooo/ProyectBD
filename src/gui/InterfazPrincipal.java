package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.TelefoniaMovil;

@SuppressWarnings("serial")
public class InterfazPrincipal extends JFrame{
	
	private JPanel aux;
	private TelefoniaMovil mundo;
	
	private Principal miPrincipal;
	
	private PanelCCancelacion miPanelCancelacion;
	private PanelCCrear miPanelCrear;
	private PanelCModificacion miPanelModificacion;
	private PanelLogin miPanelLogin;
	private PanelRegistrar miPanelRegistrar;
	private PanelReportarS miPanelReportarS;
	private PanelSolicitudReclamo miPanelSolicitudReclamo;
	private boolean usuario;
	
	public InterfazPrincipal() {
		super();
		setLayout(new BorderLayout());
		usuario=false;
		
		aux = new JPanel();
		aux.setLayout(new BorderLayout());
		
		miPanelLogin= new PanelLogin(this);
		aux.add(miPanelLogin, BorderLayout.CENTER);
		mundo= new TelefoniaMovil();
		
		add(aux,BorderLayout.CENTER);
		pack();
	}
	
	public void cambiarALogin() {
		aux.remove(0);
		miPanelLogin= new PanelLogin(this);
		aux.add(miPanelLogin, BorderLayout.CENTER);
		pack();
	}
	public void cambiarACancelacion() {
		aux.remove(0);
		miPanelCancelacion= new PanelCCancelacion(this);
		aux.add(miPanelCancelacion, BorderLayout.CENTER);
		pack();
	}
	public void cambiarACreacion() {
		aux.remove(0);
		miPanelCrear= new PanelCCrear(this);
		aux.add(miPanelCrear, BorderLayout.CENTER);
		pack();
	}
	public void cambiarAModificacion() {
		aux.remove(0);
		miPanelModificacion= new PanelCModificacion(this);
		aux.add(miPanelModificacion, BorderLayout.CENTER);
		pack();
	}
	public void cambiarARegistrar(boolean cliente) {
		aux.remove(0);
		miPanelRegistrar= new PanelRegistrar(this, cliente);
		aux.add(miPanelRegistrar, BorderLayout.CENTER);
		pack();
	}
	public void cambiarAReportar() {
		aux.remove(0);
		miPanelReportarS= new PanelReportarS(this);
		aux.add(miPanelReportarS, BorderLayout.CENTER);
		pack();
	}
	public void cambiarAReclamo() {
		aux.remove(0);
		miPanelSolicitudReclamo= new PanelSolicitudReclamo(this);
		aux.add(miPanelSolicitudReclamo, BorderLayout.CENTER);
		pack();
	}
	public void cambiarAPrincipal() {
		aux.remove(0);
		miPrincipal= new Principal(this);
		aux.add(miPrincipal, BorderLayout.CENTER);
		pack();
	}

	public void LoginFuncionario(String id) {
		mundo.setIdUsuario(id);
		cambiarAPrincipal();
	}

	public void LoginUsu(String id) {
		mundo.setIdUsuario(id);
		usuario= true;
		cambiarAPrincipal();
	}

	public void registrarFuncionario() {
		cambiarARegistrar(usuario);
	}

	public void registrarUsuario() {
		usuario=true;
		cambiarARegistrar(usuario);
	}

	public void registrar(String nombre, String contra, String cedula, String direc, String fecha, String telefono) {
		if(usuario) {
			mundo.registrarCliente(nombre, contra, cedula, direc, fecha, telefono);
		}
		else {
			mundo.registrarFuncionario(nombre, contra, cedula, direc, fecha, telefono);
		}
		cambiarALogin();
	}

	public void crearSolicitudCreacion(int tipo, String id, String observacion) {
		mundo.crearSolicitudCreacion((tipo+1)+"", id, observacion);
		cambiarAPrincipal();
	}

	public void crearSolicitudModificacion(int tipoAnterior, int tipoNuevo) {
		mundo.crearSolicitudModificacion((tipoAnterior+1)+"", mundo.getIdUsuario(), (tipoNuevo+1)+"");
	}

	public void crearSolicitudCancelacion(int tipo, String observacion) {
		mundo.crearSolicitudCancelacion((tipo+1)+"", mundo.getIdUsuario(), observacion);
	}

	public void crearSolicitudDano(int tipo, String id, String observacion) {
		mundo.crearSolicitudDano((tipo+1)+"", id, observacion);
	}

	public void crearSolicitudReclamo(int tipo, String id, String observacion) {
		mundo.crearSolicitudReclamo((tipo+1)+"", id, observacion);
	}

}
