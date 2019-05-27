package gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Esteban Gallo
 */
public class Principal extends javax.swing.JPanel {

	private InterfazPrincipal principal;
    /**
     * Creates new form Principal
     */
    public Principal(InterfazPrincipal p) {
        initComponents();
        principal=p;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        labelCrear = new javax.swing.JLabel();
        labelConsultar = new javax.swing.JLabel();
        btnConsultaF = new javax.swing.JButton();
        btnConsultaE = new javax.swing.JButton();
        btnConsultaT = new javax.swing.JButton();
        btnConsultaC = new javax.swing.JButton();
        comboTiposCrear = new JComboBox<String>();
        btnCrear = new javax.swing.JButton();

        labelCrear.setText("Crear Solicitud :");

        labelConsultar.setText("Consulta a solicitudes :");

        btnConsultaF.setText("Consulta por Funcionario");
        btnConsultaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaFActionPerformed(evt);
            }
        });

        btnConsultaE.setText("Consulta por Estado");
        btnConsultaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaEActionPerformed(evt);
            }
        });

        btnConsultaT.setText("Consulta por Tipo");
        btnConsultaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaTActionPerformed(evt);
            }
        });

        btnConsultaC.setText("Consulta por Cliente");
        btnConsultaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCActionPerformed(evt);
            }
        });

        comboTiposCrear.setModel(new DefaultComboBoxModel(new String[] { "Creaci�n", "Modificaci�n", "Cancelaci�n", "Da�o", "Reclamo" }));

        btnCrear.setText("Crear Solicitud");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultaF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultaE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultaT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboTiposCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelConsultar)
                            .addComponent(labelCrear))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(labelCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTiposCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultaF)
                .addGap(18, 18, 18)
                .addComponent(btnConsultaE)
                .addGap(18, 18, 18)
                .addComponent(btnConsultaT)
                .addGap(18, 18, 18)
                .addComponent(btnConsultaC)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void btnConsultaEActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	principal.consultaPorEstado();
    }                                            

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    	int seleccionado= comboTiposCrear.getSelectedIndex();
    	if(seleccionado==0) {
    	 principal.cambiarACreacion();	
    	}else if (seleccionado==1) {
    	 principal.cambiarAModificacion();
    	}else if (seleccionado == 2) {
         principal.cambiarACancelacion();
		}else if (seleccionado == 3) {
		 principal.cambiarAReportar();
		}else if (seleccionado == 4) {
		 principal.cambiarAReclamo();
		}
    }                                        

    private void btnConsultaFActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	principal.consultaPorFuncionario();
    }                                            

    private void btnConsultaTActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	principal.consultaPorTipo();
    }                                            

    private void btnConsultaCActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	principal.consultaPorCliente();
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnConsultaC;
    private javax.swing.JButton btnConsultaE;
    private javax.swing.JButton btnConsultaF;
    private javax.swing.JButton btnConsultaT;
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox<String> comboTiposCrear;
    private javax.swing.JLabel labelConsultar;
    private javax.swing.JLabel labelCrear;
    // End of variables declaration                   
}
