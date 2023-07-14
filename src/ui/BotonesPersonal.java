/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author David
 */
public class BotonesPersonal extends javax.swing.JInternalFrame {

    Color panedefault;
    Color paneClick;
    Color labelClick;
    Color labeldefault;

    public BotonesPersonal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        initComponents();

        // Quitar bordes
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        //Colores de panel
        panedefault = new Color(255, 255, 255);
        this.paneClick = new Color(0, 56, 140);
        labelClick = new Color(255, 255, 255);
        labeldefault = new Color(0, 0, 0);

        this.pnlinstructor.setBackground(paneClick);
        this.pnlCustodio.setBackground(panedefault);
        this.pnlResponsable.setBackground(panedefault);
        this.pnlUsuario.setBackground(panedefault);

        this.lab1.setForeground(labelClick);
        this.lab2.setForeground(labeldefault);
        this.lab3.setForeground(labeldefault);
        this.lab4.setForeground(labeldefault);

        contenedor.removeAll();
        contenedor.repaint();
        jFrameInstructor obb;
        try {

            obb = new jFrameInstructor();
            this.contenedor.add(obb).setVisible(true);
            obb.setMaximum(true);

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlinstructor = new javax.swing.JPanel();
        lab1 = new javax.swing.JLabel();
        pnlResponsable = new javax.swing.JPanel();
        lab3 = new javax.swing.JLabel();
        pnlCustodio = new javax.swing.JPanel();
        lab2 = new javax.swing.JLabel();
        contenedor = new javax.swing.JDesktopPane();
        contenedorPNL = new javax.swing.JPanel();
        pnlUsuario = new javax.swing.JPanel();
        lab4 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pnlinstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlinstructorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlinstructorMousePressed(evt);
            }
        });

        lab1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab1.setText("INSTRUCTOR");

        javax.swing.GroupLayout pnlinstructorLayout = new javax.swing.GroupLayout(pnlinstructor);
        pnlinstructor.setLayout(pnlinstructorLayout);
        pnlinstructorLayout.setHorizontalGroup(
            pnlinstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlinstructorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlinstructorLayout.setVerticalGroup(
            pnlinstructorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlinstructorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnlResponsable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlResponsableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlResponsableMousePressed(evt);
            }
        });

        lab3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab3.setText("RESPONSABLE");

        javax.swing.GroupLayout pnlResponsableLayout = new javax.swing.GroupLayout(pnlResponsable);
        pnlResponsable.setLayout(pnlResponsableLayout);
        pnlResponsableLayout.setHorizontalGroup(
            pnlResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResponsableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlResponsableLayout.setVerticalGroup(
            pnlResponsableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResponsableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab3)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pnlCustodio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCustodioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlCustodioMousePressed(evt);
            }
        });

        lab2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab2.setText("CUSTODIO");

        javax.swing.GroupLayout pnlCustodioLayout = new javax.swing.GroupLayout(pnlCustodio);
        pnlCustodio.setLayout(pnlCustodioLayout);
        pnlCustodioLayout.setHorizontalGroup(
            pnlCustodioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustodioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCustodioLayout.setVerticalGroup(
            pnlCustodioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustodioLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(lab2)
                .addContainerGap())
        );

        contenedorPNL.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenedorPNLLayout = new javax.swing.GroupLayout(contenedorPNL);
        contenedorPNL.setLayout(contenedorPNLLayout);
        contenedorPNLLayout.setHorizontalGroup(
            contenedorPNLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 799, Short.MAX_VALUE)
        );
        contenedorPNLLayout.setVerticalGroup(
            contenedorPNLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        contenedor.setLayer(contenedorPNL, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPNL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlUsuarioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlUsuarioMousePressed(evt);
            }
        });

        lab4.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab4.setText("CUENTAS DE USUARIO");

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab4)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(contenedor)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlinstructor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlCustodio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlResponsable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pnlCustodio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pnlinstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(contenedor)
                .addContainerGap())
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

    private void pnlinstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlinstructorMouseClicked
        contenedor.removeAll();
        contenedor.repaint();

        jFrameInstructor obb;
        try {
            obb = new jFrameInstructor();
            this.contenedor.add(obb).setVisible(true);
            obb.setMaximum(true);

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al intentar guardar "
                    + "el \n registro, no se encuentra una librería", "Librería no Encontrada",
                    JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla al "
                    + "hacer referencia \n de una instancia",
                    "Instancia no Encontrada", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, "Se ha denegado el acceso al "
                    + "intentar utilizar \n la librería o instancia para guardar",
                    "Acceso Ilegal a un Recurso", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                    + "el manejo de la solicitud \n en recurso de Base de Datos"
                    + ex.getMessage(),
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlinstructorMouseClicked

    private void pnlCustodioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCustodioMouseClicked
        contenedor.removeAll();
        contenedor.repaint();
        jFrameCustodio obb;
        try {
            obb = new jFrameCustodio();
            this.contenedor.add(obb).setVisible(true);
            obb.setMaximum(true);

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al intentar guardar "
                    + "el \n registro, no se encuentra una librería", "Librería"
                    + " no Encontrada", JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla al "
                    + "hacer referencia \n de una instancia",
                    "Instancia no Encontrada", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, "Se ha denegado el acceso al "
                    + "intentar utilizar \n la librería o instancia para guardar",
                    "Acceso Ilegal a un Recurso", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                    + "el manejo de la solicitud \n en recurso de Base de Datos"
                    + ex.getMessage(),
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlCustodioMouseClicked

    private void pnlResponsableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlResponsableMouseClicked
        contenedor.removeAll();
        contenedor.repaint();
        jFrameResponsable obb;
        try {
            try {
                obb = new jFrameResponsable();
                this.contenedor.add(obb).setVisible(true);
                obb.setMaximum(true);

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

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlResponsableMouseClicked

    private void pnlUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUsuarioMouseClicked

        contenedor.removeAll();
        contenedor.repaint();
        jframeCuentaUsuario obb;
        try {
            obb = new jframeCuentaUsuario();
            this.contenedor.add(obb).setVisible(true);
            obb.setMaximum(true);

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlUsuarioMouseClicked

    private void pnlinstructorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlinstructorMousePressed
        this.pnlinstructor.setBackground(paneClick);
        this.pnlCustodio.setBackground(panedefault);
        this.pnlResponsable.setBackground(panedefault);
        this.pnlUsuario.setBackground(panedefault);

        this.lab1.setForeground(labelClick);
        this.lab2.setForeground(labeldefault);
        this.lab3.setForeground(labeldefault);
        this.lab4.setForeground(labeldefault);
    }//GEN-LAST:event_pnlinstructorMousePressed

    private void pnlCustodioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCustodioMousePressed
        this.pnlinstructor.setBackground(panedefault);
        this.pnlCustodio.setBackground(paneClick);
        this.pnlResponsable.setBackground(panedefault);
        this.pnlUsuario.setBackground(panedefault);

        this.lab1.setForeground(labeldefault);
        this.lab2.setForeground(labelClick);
        this.lab3.setForeground(labeldefault);
        this.lab4.setForeground(labeldefault);
    }//GEN-LAST:event_pnlCustodioMousePressed

    private void pnlResponsableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlResponsableMousePressed
        this.pnlinstructor.setBackground(panedefault);
        this.pnlCustodio.setBackground(panedefault);
        this.pnlResponsable.setBackground(paneClick);
        this.pnlUsuario.setBackground(panedefault);

        this.lab1.setForeground(labeldefault);
        this.lab2.setForeground(labeldefault);
        this.lab3.setForeground(labelClick);
        this.lab4.setForeground(labeldefault);
    }//GEN-LAST:event_pnlResponsableMousePressed

    private void pnlUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUsuarioMousePressed
        this.pnlinstructor.setBackground(panedefault);
        this.pnlCustodio.setBackground(panedefault);
        this.pnlResponsable.setBackground(panedefault);
        this.pnlUsuario.setBackground(paneClick);

        this.lab1.setForeground(labeldefault);
        this.lab2.setForeground(labeldefault);
        this.lab3.setForeground(labeldefault);
        this.lab4.setForeground(labelClick);
    }//GEN-LAST:event_pnlUsuarioMousePressed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane contenedor;
    private javax.swing.JPanel contenedorPNL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel lab2;
    private javax.swing.JLabel lab3;
    private javax.swing.JLabel lab4;
    protected javax.swing.JPanel pnlCustodio;
    protected javax.swing.JPanel pnlResponsable;
    private javax.swing.JPanel pnlUsuario;
    private javax.swing.JPanel pnlinstructor;
    // End of variables declaration//GEN-END:variables
}
