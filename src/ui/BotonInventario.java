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
public class BotonInventario extends javax.swing.JInternalFrame {

    Color panedefault;
    Color paneClick;
    Color labelClick;
    Color labeldefault;

    public BotonInventario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        initComponents();

        // Colores de panel
        panedefault = new Color(255, 255, 255);
        this.paneClick = new Color(0, 56, 140);
        labelClick = new Color(255, 255, 255);
        labeldefault = new Color(0, 0, 0);

        this.pnlBotonInv1.setBackground(paneClick);
        this.pnlBotonInv2.setBackground(panedefault);
        this.lab1.setForeground(labelClick);
        this.lab2.setForeground(labeldefault);

        //Quitar bordes
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        contenedor.removeAll();
        contenedor.repaint();
        jFrameInvEquipoTec obb;
        try {
            obb = new jFrameInvEquipoTec();
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

        pnlFondo = new javax.swing.JPanel();
        pnlBotonInv1 = new javax.swing.JPanel();
        lab1 = new javax.swing.JLabel();
        pnlBotonInv2 = new javax.swing.JPanel();
        lab2 = new javax.swing.JLabel();
        contenedor = new javax.swing.JDesktopPane();
        contenedorPnl = new javax.swing.JPanel();

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setPreferredSize(new java.awt.Dimension(850, 50));

        pnlBotonInv1.setBackground(new java.awt.Color(255, 255, 255));
        pnlBotonInv1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBotonInv1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBotonInv1MousePressed(evt);
            }
        });

        lab1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab1.setText("INVENTARIO DE EQUIPOS TECNOLÓGICOS");

        javax.swing.GroupLayout pnlBotonInv1Layout = new javax.swing.GroupLayout(pnlBotonInv1);
        pnlBotonInv1.setLayout(pnlBotonInv1Layout);
        pnlBotonInv1Layout.setHorizontalGroup(
            pnlBotonInv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonInv1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBotonInv1Layout.setVerticalGroup(
            pnlBotonInv1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonInv1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lab1)
                .addContainerGap())
        );

        pnlBotonInv2.setBackground(new java.awt.Color(255, 255, 255));
        pnlBotonInv2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBotonInv2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBotonInv2MousePressed(evt);
            }
        });

        lab2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab2.setText("INVENTARIO DE EQUIPOS MOBILIARIOS");

        javax.swing.GroupLayout pnlBotonInv2Layout = new javax.swing.GroupLayout(pnlBotonInv2);
        pnlBotonInv2.setLayout(pnlBotonInv2Layout);
        pnlBotonInv2Layout.setHorizontalGroup(
            pnlBotonInv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonInv2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBotonInv2Layout.setVerticalGroup(
            pnlBotonInv2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonInv2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab2)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        contenedorPnl.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenedorPnlLayout = new javax.swing.GroupLayout(contenedorPnl);
        contenedorPnl.setLayout(contenedorPnlLayout);
        contenedorPnlLayout.setHorizontalGroup(
            contenedorPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        contenedorPnlLayout.setVerticalGroup(
            contenedorPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        contenedor.setLayer(contenedorPnl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(pnlBotonInv1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(66, 66, 66)
                .addComponent(pnlBotonInv2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(127, 127, 127))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor)
                .addContainerGap())
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBotonInv2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotonInv1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlBotonInv1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBotonInv1MouseClicked

        contenedor.removeAll();
        contenedor.repaint();
        jFrameInvEquipoTec obb;
        try {
            try {
                obb = new jFrameInvEquipoTec();
                this.contenedor.add(obb).setVisible(true);
                obb.setMaximum(true);
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

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlBotonInv1MouseClicked

    private void pnlBotonInv2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBotonInv2MouseClicked
        contenedor.removeAll();
        contenedor.repaint();
        jFrameInvEquipoMob obb;
        try {
            try {
                obb = new jFrameInvEquipoMob();
                this.contenedor.add(obb).setVisible(true);
                obb.setMaximum(true);
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

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlBotonInv2MouseClicked

    private void pnlBotonInv1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBotonInv1MousePressed
        this.pnlBotonInv1.setBackground(paneClick);
        this.pnlBotonInv2.setBackground(panedefault);
        this.lab1.setForeground(labelClick);
        this.lab2.setForeground(labeldefault);
    }//GEN-LAST:event_pnlBotonInv1MousePressed

    private void pnlBotonInv2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBotonInv2MousePressed
        this.pnlBotonInv1.setBackground(panedefault);
        this.pnlBotonInv2.setBackground(paneClick);
        this.lab1.setForeground(labeldefault);
        this.lab2.setForeground(labelClick);
    }//GEN-LAST:event_pnlBotonInv2MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane contenedor;
    private javax.swing.JPanel contenedorPnl;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel lab2;
    private javax.swing.JPanel pnlBotonInv1;
    private javax.swing.JPanel pnlBotonInv2;
    private javax.swing.JPanel pnlFondo;
    // End of variables declaration//GEN-END:variables
}
