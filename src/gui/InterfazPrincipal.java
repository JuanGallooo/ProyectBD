package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import modelo.TelefoniaMovil;

public class InterfazPrincipal extends JFrame{
	
	private JPanel aux;
	private TelefoniaMovil mundo;
	
	private PanelUsuario miPrincipal;
	private PanelFuncionario miPanelFuncionario;
	
	private PanelCCancelacion miPanelCancelacion;
	private PanelCCrear miPanelCrear;
	private PanelCModificacion miPanelModificacion;
	private PanelLogin miPanelLogin;
	private PanelRegistrar miPanelRegistrar;
	private PanelReportarS miPanelReportarS;
	private PanelSolicitudReclamo miPanelSolicitudReclamo;
	private boolean usuario;
	
	
	public static void main(String[] args) {
		InterfazPrincipal principal = new InterfazPrincipal();
		principal.setVisible(true);
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
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
	public void cambiarAFuncionario() {
		aux.remove(0);
		 DefaultTableModel nuevo= mundo.solicitudesFuncionario();
		miPanelFuncionario= new PanelFuncionario(this,nuevo);
		aux.add(miPanelFuncionario, BorderLayout.CENTER);
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
		miPrincipal= new PanelUsuario(this);
		aux.add(miPrincipal, BorderLayout.CENTER);
		pack();
	}

	public void LoginFuncionario(String id,String contrasena) {
		mundo.setIdUsuario(id);
		if( mundo.comprobarContrasenaFuncionario(contrasena)) {
		cambiarAFuncionario();
		pack();
		}
		else {
			JOptionPane.showMessageDialog(this, "Contraseña invalida", "Contraseña", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void LoginUsu(String id,String contrasena) {
		mundo.setIdUsuario(id);
		if( mundo.comprobarContrasenaCliente(contrasena)) {			
		usuario= true;
		cambiarAPrincipal();
		pack();
		}
		else {
			JOptionPane.showMessageDialog(this, "Contraseña invalida", "Contraseña", JOptionPane.ERROR_MESSAGE);
		}
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
		cambiarAPrincipal();
	}

	public void crearSolicitudCancelacion(int tipo, String observacion) {
		mundo.crearSolicitudCancelacion((tipo+1)+"", mundo.getIdUsuario(), observacion);
		cambiarAPrincipal();
	}

	public void crearSolicitudDano(int tipo, String id, String observacion) {
		mundo.crearSolicitudDano((tipo+1)+"", id, observacion);
		cambiarAPrincipal();
	}

	public void crearSolicitudReclamo(int tipo, String id, String observacion) {
		mundo.crearSolicitudReclamo((tipo+1)+"", id, observacion);
		cambiarAPrincipal();
	}

	public void consultaPorFuncionario() {
		String funcionario = JOptionPane.showInputDialog(this, "Ingrese el id del funcionario que desea hacer la consulta?");
		String respuesta= mundo.consultaFuncionario(funcionario);
		JOptionPane.showMessageDialog(this, respuesta, "Respuesta a la consulta", JOptionPane.INFORMATION_MESSAGE);
	}

	public void consultaPorTipo() {
		String tipo = JOptionPane.showInputDialog(this, "Ingrese el id del tipo que desea hacer la consulta?");
		String respuesta= mundo.consultaTipo(tipo);
		JOptionPane.showMessageDialog(this, respuesta, "Respuesta a la consulta", JOptionPane.INFORMATION_MESSAGE);
	}

	public void consultaPorCliente() {
		String cliente = JOptionPane.showInputDialog(this, "Ingrese el id del cliente que desea hacer la consulta?");
		String respuesta= mundo.consultaCliente(cliente);
		JOptionPane.showMessageDialog(this, respuesta, "Respuesta a la consulta", JOptionPane.INFORMATION_MESSAGE);
	}

	public void consultaPorEstado() {
		String estado = JOptionPane.showInputDialog(this, "Ingrese el id del estado que desea hacer la consulta?");
		String respuesta= mundo.consultaEstado(estado);
		JOptionPane.showMessageDialog(this, respuesta, "Respuesta a la consulta", JOptionPane.INFORMATION_MESSAGE);
	}


	public void antenderSolicitud() {
		String solicitud = JOptionPane.showInputDialog(this, "Ingrese el numero de la solicitud que desea atender ?");
		mundo.atenderSolicitud(mundo.getIdUsuario(), solicitud);
		cambiarAFuncionario();
	}

	public void antenderSolicitudReclamo() {
		String solicitud = JOptionPane.showInputDialog(this, "Ingrese el numero de la solicitud que desea atender ?");
		String respuesta = JOptionPane.showInputDialog(this, "Indique la respuesta a dicha solicitud ?");
		mundo.atenderSolicitudDR(mundo.getIdUsuario(), solicitud, respuesta);
		cambiarAFuncionario();
	}
}
