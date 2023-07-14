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
public class BotonesMovimientos extends javax.swing.JInternalFrame {

    Color panedefault;
    Color paneClick;

    Color labelClick;
    Color labeldefault;

    public BotonesMovimientos() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
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

        this.pnlMov1.setBackground(paneClick);
        this.pnlMov2.setBackground(panedefault);
        this.lab1.setForeground(labelClick);
        this.lab2.setForeground(labeldefault);

        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        jFrameMovimientoEquipoTec obb;
        try {
            obb = new jFrameMovimientoEquipoTec();
            this.jDesktopPane1.add(obb).setVisible(true);
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
        pnlMov1 = new javax.swing.JPanel();
        lab1 = new javax.swing.JLabel();
        pnlMov2 = new javax.swing.JPanel();
        lab2 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 50));

        pnlMov1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMov1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMov1MousePressed(evt);
            }
        });

        lab1.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab1.setText("MOVIMIENTOS DE EQUIPOS TECNOLÓGICOS");

        javax.swing.GroupLayout pnlMov1Layout = new javax.swing.GroupLayout(pnlMov1);
        pnlMov1.setLayout(pnlMov1Layout);
        pnlMov1Layout.setHorizontalGroup(
            pnlMov1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMov1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lab1)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlMov1Layout.setVerticalGroup(
            pnlMov1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMov1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lab1)
                .addContainerGap())
        );

        pnlMov2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMov2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlMov2MousePressed(evt);
            }
        });

        lab2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lab2.setText("MOVIMIENTOS DE EQUIPOS MOBILIARIO");

        javax.swing.GroupLayout pnlMov2Layout = new javax.swing.GroupLayout(pnlMov2);
        pnlMov2.setLayout(pnlMov2Layout);
        pnlMov2Layout.setHorizontalGroup(
            pnlMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMov2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab2)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlMov2Layout.setVerticalGroup(
            pnlMov2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMov2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab2)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(pnlMov1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMov2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMov2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMov1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlMov1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMov1MouseClicked
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        jFrameMovimientoEquipoTec obb;
        try {
            obb = new jFrameMovimientoEquipoTec();
            this.jDesktopPane1.add(obb).setVisible(true);
            obb.setMaximum(true);

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_pnlMov1MouseClicked

    private void pnlMov2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMov2MouseClicked
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        jFrameMovimientoEquipoMob obb;
        try {
            obb = new jFrameMovimientoEquipoMob();
            this.jDesktopPane1.add(obb).setVisible(true);
            obb.setMaximum(true);

        } catch (PropertyVetoException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al intentar guardar "
                    + "el \n registro, no se encuentra una librería", "Librería "
                    + "no Encontrada", JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_pnlMov2MouseClicked

    private void pnlMov1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMov1MousePressed
        this.pnlMov1.setBackground(paneClick);
        this.pnlMov2.setBackground(panedefault);
        this.lab1.setForeground(labelClick);
        this.lab2.setForeground(labeldefault);
    }//GEN-LAST:event_pnlMov1MousePressed

    private void pnlMov2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMov2MousePressed
        this.pnlMov1.setBackground(panedefault);
        this.pnlMov2.setBackground(paneClick);
        this.lab1.setForeground(labeldefault);
        this.lab2.setForeground(labelClick);
    }//GEN-LAST:event_pnlMov2MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel lab2;
    private javax.swing.JPanel pnlMov1;
    private javax.swing.JPanel pnlMov2;
    // End of variables declaration//GEN-END:variables
}
