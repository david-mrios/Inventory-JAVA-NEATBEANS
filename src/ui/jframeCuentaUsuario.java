/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import controlador.CTr_Custodio;
import controlador.CTr_Instructor;
import controlador.CTr_usuario_c;
import controlador.CTr_usuario_i;
import controlador.CTr_usuario_r;
import controlador.Ctr_Responsable;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import negocio.usuario_c;
import negocio.usuario_i;
import negocio.usuario_r;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class jframeCuentaUsuario extends javax.swing.JInternalFrame {

    public jframeCuentaUsuario() {

        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new Components.PanelShadow();
        jlblCardHeader = new javax.swing.JLabel();
        jtxtCarnet = new javax.swing.JTextField();
        jlblCarnet = new javax.swing.JLabel();
        jlblcontraseña = new javax.swing.JLabel();
        jtxtContrasenia = new javax.swing.JTextField();
        jbtnGuardar1 = new javax.swing.JButton();
        jbtnGuardar = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jbtnGuardar2 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlblCardHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Card_Header (2).png"))); // NOI18N

        jlblCarnet.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblCarnet.setText("Identificador");

        jlblcontraseña.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblcontraseña.setText("Contraseña");

        jbtnGuardar1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jbtnGuardar1.setText("Guardar");
        jbtnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardar1ActionPerformed(evt);
            }
        });

        jbtnGuardar.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jbtnGuardar.setText("Actualizar");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jbtnBuscar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/2703065_search_find_icon (1).png"))); // NOI18N
        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jbtnGuardar2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        jbtnGuardar2.setText("Limpiar");
        jbtnGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jlblCardHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jbtnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jbtnBuscar)
                                .addGap(16, 16, 16)
                                .addComponent(jbtnGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelShadow1Layout.createSequentialGroup()
                                        .addComponent(jlblCarnet)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtxtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelShadow1Layout.createSequentialGroup()
                                        .addComponent(jlblcontraseña)
                                        .addGap(47, 47, 47)
                                        .addComponent(jtxtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlblCardHeader)
                .addGap(47, 47, 47)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnGuardar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnGuardar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardar1ActionPerformed
        if (this.Validacion()) {
            try {

                int carnet = Integer.parseInt(this.jtxtCarnet.getText());
                boolean existeResponsable = Ctr_Responsable.verificarCarnetRegistrado(carnet);
                boolean existeCustodio = CTr_Custodio.verificarInssRegistrado(carnet);
                boolean existeInstructor = CTr_Instructor.verificarCarnetRegistrado(carnet);

                if (existeResponsable) {

                    int rst = CTr_usuario_r.agregar(
                            this.jtxtContrasenia.getText(),
                            Integer.parseInt(this.jtxtCarnet.getText()));

                    if (rst > 0) {
                        JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                                "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Registro no grabado, ya existe",
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else if (existeInstructor) {

                    int rst = CTr_usuario_i.agregar(
                            this.jtxtContrasenia.getText(),
                            Integer.parseInt(this.jtxtCarnet.getText()));

                    if (rst > 0) {
                        JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                                "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Registro no grabado, ya existe",
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else if (existeCustodio) {

                    int rst = CTr_usuario_c.agregar(
                            this.jtxtContrasenia.getText(),
                            Integer.parseInt(this.jtxtCarnet.getText()));

                    if (rst > 0) {
                        JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                                "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Registro no grabado, ya existe",
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Registro no existe",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                this.limpiarRregistro();

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al intentar guardar "
                        + "el \n registro, no se encuentra una librería",
                        "Librería no Encontrada", JOptionPane.ERROR_MESSAGE);
            } catch (InstantiationException ex) {
                JOptionPane.showMessageDialog(this, "Se ha producido una falla al "
                        + "hacer referencia \n de una instancia",
                        "Instancia no Encontrada", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, "Se ha denegado el acceso al  "
                        + "intentar utilizar \n la librería o instancia para guardar",
                        "Acceso Ilegal a un Recurso", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                        + "el manejo de la solicitud \n en recurso de Base de Datos" + ex.toString(),
                        "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
            }//Fin de instrucción catch
        } else {
            JOptionPane.showMessageDialog(this, "Alguna caja de texto esta vacia",
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbtnGuardar1ActionPerformed

    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed

        try {

            int carnet = Integer.parseInt(this.jtxtCarnet.getText());
            boolean existeResponsable = Ctr_Responsable.verificarCarnetRegistrado(carnet);
            boolean existeCustodio = CTr_Custodio.verificarInssRegistrado(carnet);
            boolean existeInstructor = CTr_Instructor.verificarCarnetRegistrado(carnet);

            if (existeResponsable) {

                int rst = CTr_usuario_r.actualizar(
                        this.jtxtContrasenia.getText(),
                        Integer.parseInt(this.jtxtCarnet.getText()));

                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                            "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Registro no grabado, ya existe",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }

            } else if (existeInstructor) {

                int rst = CTr_usuario_i.actualizar(
                        this.jtxtContrasenia.getText(),
                        Integer.parseInt(this.jtxtCarnet.getText()));

                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                            "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Registro no grabado, ya existe",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }

            } else if (existeCustodio) {

                int rst = CTr_usuario_c.actualizar(
                        this.jtxtContrasenia.getText(),
                        Integer.parseInt(this.jtxtCarnet.getText()));

                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                            "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Registro no grabado, ya existe",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Registro no existe",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al intentar guardar "
                    + "el \n registro, no se encuentra una librería",
                    "Librería no Encontrada", JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla al "
                    + "hacer referencia \n de una instancia",
                    "Instancia no Encontrada", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, "Se ha denegado el acceso al  "
                    + "intentar utilizar \n la librería o instancia para guardar",
                    "Acceso Ilegal a un Recurso", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                    + "el manejo de la solicitud \n en recurso de Base de Datos" + ex.toString(),
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }//Fin de instrucción catch
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        if (this.ValidacionBuscar()) {
            try {

                int val = Integer.parseInt(this.jtxtCarnet.getText());
                usuario_c p = CTr_usuario_c.leerRegistro(val);
                usuario_r p2 = CTr_usuario_r.leerRegistro(val);
                usuario_i p3 = CTr_usuario_i.leerRegistro(val);

                if (p != null) {
                    this.jtxtCarnet.setText(Integer.toString(p.getInss()));
                    this.jtxtContrasenia.setText(p.getContrasenia());

                } else if (p2 != null) {

                    this.jtxtCarnet.setText(Integer.toString(p2.getInss()));
                    this.jtxtContrasenia.setText(p2.getContrasenia());

                } else if (p3 != null) {

                    this.jtxtCarnet.setText(Integer.toString(p3.getNoCarnet()));
                    this.jtxtContrasenia.setText(p3.getContrasenia());

                } else {
                    JOptionPane.showMessageDialog(null, "No Exite el registro con el numero "
                            + "de carnet: "
                            + String.valueOf(Integer.parseInt(this.jtxtCarnet.getText())));
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al intentar guardar "
                        + "el \n registro, no se encuentra una librería", "Librería no Encontrada", JOptionPane.ERROR_MESSAGE);
            } catch (InstantiationException ex) {
                JOptionPane.showMessageDialog(this, "Se ha producido una falla al "
                        + "hacer referencia \n de una instancia",
                        "Instancia no Encontrada", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalAccessException ex) {
                JOptionPane.showMessageDialog(this, "Se ha denegado el acceso al "
                        + "intentar utilizar \n la librería o instancia para guardar", "Acceso Ilegal a un Recurso", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                        + "el manejo de la solicitud \n en recurso de Base de Datos"
                        + ex.getMessage(),
                        "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Alguna caja de texto esta vacia",
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardar2ActionPerformed
        this.limpiarRregistro();
    }//GEN-LAST:event_jbtnGuardar2ActionPerformed
    public void limpiarRregistro() {
        this.jtxtContrasenia.setText("");
        this.jtxtCarnet.setText("");
    }

    public boolean Validacion() {

        boolean valido = true;

        if (jtxtCarnet.getText().isEmpty()) {

            return false;
        }
        if (jtxtContrasenia.getText().isEmpty()) {

            return false;
        }
        return valido;
    }

    public boolean ValidacionBuscar() {

        boolean valido = true;

        if (jtxtCarnet.getText().isEmpty()) {

            return false;
        }
        return valido;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnGuardar1;
    private javax.swing.JButton jbtnGuardar2;
    private javax.swing.JLabel jlblCardHeader;
    private javax.swing.JLabel jlblCarnet;
    private javax.swing.JLabel jlblcontraseña;
    private javax.swing.JTextField jtxtCarnet;
    private javax.swing.JTextField jtxtContrasenia;
    private Components.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
