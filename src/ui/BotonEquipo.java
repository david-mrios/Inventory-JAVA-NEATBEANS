/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import java.awt.Color;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author David
 */
public class BotonEquipo extends javax.swing.JInternalFrame {

    Color panedefault;
    Color paneClick;
    Color labelClick;
    Color labeldefault;

    public BotonEquipo() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {
        initComponents();

        // Quitar bordes
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        // Colores de paneles
        panedefault = new Color(255, 255, 255);
        this.paneClick = new Color(0, 56, 140);
        labelClick = new Color(255, 255, 255);
        labeldefault = new Color(0, 0, 0);

        this.pnlBotonEqtec.setBackground(paneClick);
        this.lab1.setForeground(labelClick);
        this.lab2.setForeground(labeldefault);
        this.pnlBotonEqMob.setBackground(panedefault);

        contenedor.removeAll();
        contenedor.repaint();
        jFrameEquipoTecnologico obb;
        try {
            obb = new jFrameEquipoTecnologico();
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
        pnlBotonEqtec = new javax.swing.JPanel();
        lab1 = new javax.swing.JLabel();
        pnlBotonEqMob = new javax.swing.JPanel();
        lab2 = new javax.swing.JLabel();
        contenedor = new javax.swing.JDesktopPane();
        contenedorEquipo = new javax.swing.JPanel();

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));
        pnlFondo.setPreferredSize(new java.awt.Dimension(850, 50));

        pnlBotonEqtec.setBackground(new java.awt.Color(255, 255, 255));
        pnlBotonEqtec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBotonEqtecMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBotonEqtecMousePressed(evt);
            }
        });

        lab1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab1.setText(" REGISTRO DE EQUIPOS TECNOLÓGICOS ");

        javax.swing.GroupLayout pnlBotonEqtecLayout = new javax.swing.GroupLayout(pnlBotonEqtec);
        pnlBotonEqtec.setLayout(pnlBotonEqtecLayout);
        pnlBotonEqtecLayout.setHorizontalGroup(
            pnlBotonEqtecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonEqtecLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBotonEqtecLayout.setVerticalGroup(
            pnlBotonEqtecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonEqtecLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lab1)
                .addContainerGap())
        );

        pnlBotonEqMob.setBackground(new java.awt.Color(255, 255, 255));
        pnlBotonEqMob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBotonEqMobMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBotonEqMobMousePressed(evt);
            }
        });

        lab2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab2.setText("REGISTRO DE EQUIPOS MOBILIARIOS");

        javax.swing.GroupLayout pnlBotonEqMobLayout = new javax.swing.GroupLayout(pnlBotonEqMob);
        pnlBotonEqMob.setLayout(pnlBotonEqMobLayout);
        pnlBotonEqMobLayout.setHorizontalGroup(
            pnlBotonEqMobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonEqMobLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBotonEqMobLayout.setVerticalGroup(
            pnlBotonEqMobLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonEqMobLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab2)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        contenedorEquipo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenedorEquipoLayout = new javax.swing.GroupLayout(contenedorEquipo);
        contenedorEquipo.setLayout(contenedorEquipoLayout);
        contenedorEquipoLayout.setHorizontalGroup(
            contenedorEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contenedorEquipoLayout.setVerticalGroup(
            contenedorEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        contenedor.setLayer(contenedorEquipo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(pnlBotonEqtec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlBotonEqMob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(137, 137, 137))
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
                    .addComponent(pnlBotonEqMob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotonEqtec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlBotonEqtecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBotonEqtecMouseClicked
        contenedor.removeAll();
        contenedor.repaint();
        jFrameEquipoTecnologico obb;
        try {
            try {
                obb = new jFrameEquipoTecnologico();
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
            } catch (IOException ex) {
                Logger.getLogger(BotonEquipo.class.getName()).log(Level.SEVERE, null, ex);
            }//Fin de instrucción catch

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pnlBotonEqtecMouseClicked

    private void pnlBotonEqMobMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBotonEqMobMouseClicked
        contenedor.removeAll();
        contenedor.repaint();
        jframeEquipoMobiliario obb;
        try {
            try {
                obb = new jframeEquipoMobiliario();
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
    }//GEN-LAST:event_pnlBotonEqMobMouseClicked

    private void pnlBotonEqtecMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBotonEqtecMousePressed
        this.pnlBotonEqtec.setBackground(paneClick);
        this.pnlBotonEqMob.setBackground(panedefault);
        this.lab1.setForeground(labelClick);
        this.lab2.setForeground(labeldefault);
    }//GEN-LAST:event_pnlBotonEqtecMousePressed

    private void pnlBotonEqMobMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBotonEqMobMousePressed
        this.pnlBotonEqtec.setBackground(panedefault);
        this.pnlBotonEqMob.setBackground(paneClick);
        this.lab1.setForeground(labeldefault);
        this.lab2.setForeground(labelClick);
    }//GEN-LAST:event_pnlBotonEqMobMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane contenedor;
    private javax.swing.JPanel contenedorEquipo;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel lab2;
    private javax.swing.JPanel pnlBotonEqMob;
    private javax.swing.JPanel pnlBotonEqtec;
    private javax.swing.JPanel pnlFondo;
    // End of variables declaration//GEN-END:variables
}
