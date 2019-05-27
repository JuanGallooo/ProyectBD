package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.TelefoniaMovil;

@SuppressWarnings("serial")
public class InterfazPrincipal extends JFrame{
	
	private JPanel aux;
	private TelefoniaMovil mundo;
	
	private PanelCCancelacion miPanelCancelacion;
	private PanelCCrear miPanelCrear;
	private PanelCModificacion miPanelModificacion;
	private PanelLogin miPanelLogin;
	private PanelRegistrar miPanelRegistrar;
	private PanelReportarS miPanelReportarS;
	private PanelSolicitudReclamo miPanelSolicitudReclamo;
	
	public InterfazPrincipal() {
		super();
		setLayout(new BorderLayout());
		
		aux = new JPanel();
		aux.setLayout(new BorderLayout());
		
		miPanelLogin= new PanelLogin(this);
		aux.add(miPanelLogin, BorderLayout.CENTER);
		
		add(aux,BorderLayout.CENTER);
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
	
	
	

}
