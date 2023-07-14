/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import controlador.CTr_EquipoTecnologico;
import controlador.CTr_MarcaEquipo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class jFrameMarca extends javax.swing.JFrame {

    public jFrameMarca() throws SQLException {
        initComponents();
        cargarComboBoxMarca();
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlblMarca = new javax.swing.JLabel();
        jCmbMarca = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 56, 140));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblMarca.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblMarca.setText("Marca");
        jPanel2.add(jlblMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jCmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lenovo", "Dell", " " }));
        jCmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCmbMarcaItemStateChanged(evt);
            }
        });
        jCmbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbMarcaActionPerformed(evt);
            }
        });
        jPanel2.add(jCmbMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 170, -1));

        btnGuardar.setBackground(new java.awt.Color(82, 183, 136));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 80, 40));

        btnBorrar.setBackground(new java.awt.Color(82, 183, 136));
        btnBorrar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 80, 40));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cerrar.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 260));

        setBounds(600, 275, 290, 262);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        JOptionPane.showMessageDialog(this, "Actualiza","Marca",JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
     

    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {

            CTr_MarcaEquipo EquipoService = new CTr_MarcaEquipo();
            String marca = this.jTextField1.getText();
            boolean existeRegistro = EquipoService.verificarMarca(marca);
            if (!existeRegistro) {
                int rst = CTr_MarcaEquipo.agregar(this.jTextField1.getText());
                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro grabado con exito",
                            "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                }//Fin de la instrucción if
                cargarComboBoxMarca();
            } else {
                JOptionPane.showMessageDialog(this, "Registro no grabado ",
                        "Registro existente", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al intentar guardar "
                    + "el \n registro, no se encuentra una librería" + ex.toString(),
                    "Librería no Encontrada", JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla al "
                    + "hacer referencia \n de una instancia" + ex.toString(),
                    "Instancia no Encontrada", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, "Se ha denegado el acceso al  "
                    + "intentar utilizar \n la librería o instancia para guardar" + ex.toString(),
                    "Acceso Ilegal a un Recurso", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                    + "el manejo de la solicitud \n en recurso de Base de Datos" + ex.toString(),
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }//Fin de instrucción catch
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jCmbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbMarcaActionPerformed

    }//GEN-LAST:event_jCmbMarcaActionPerformed

    private void jCmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCmbMarcaItemStateChanged
        Object selectedItem = jCmbMarca.getSelectedItem();
        String marca; // Valor predeterminado en caso de que el selectedItem sea nulo

        if (selectedItem != null) {
            if (!selectedItem.toString().equals("Selecionar")) {
                marca = selectedItem.toString();
                this.jTextField1.setText(marca);

            } else if (selectedItem.toString().equals("Selecionar")) {
                this.jTextField1.setText("");
            }

        }

    }//GEN-LAST:event_jCmbMarcaItemStateChanged

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {

           
            CTr_MarcaEquipo MarcaService = new CTr_MarcaEquipo();
            String marca = this.jTextField1.getText();
            boolean existeRegistro = MarcaService.verificarMarca(marca);

            if (existeRegistro) {
                int rst = CTr_MarcaEquipo.borrarRegistro(
                        marca
                );
                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro borrado con exito",
                            "Borrar Registro", JOptionPane.INFORMATION_MESSAGE);

                }//Fin de la instrucción if
            }//Fin actualizar
            else // De lo contrario no existe
            {
                JOptionPane.showMessageDialog(null, "No Exite ese registro:"
                        + String.valueOf(marca));
            }// Fin

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
                    + "el manejo de la solicitud \n en recurso de Base de Datos",
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }//Fin de instrucción catch
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
         
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jFrameMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new jFrameMarca().setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Se ha producido una falla con "
                            + "el manejo de la solicitud \n en recurso de Base de Datos"
                            + ex.getMessage(),
                            "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void cargarComboBoxMarca() throws SQLException {
        try {

            CTr_EquipoTecnologico MarcaService = new CTr_EquipoTecnologico();
            List<String> Marcas = MarcaService.obtenerMarca();
            jCmbMarca.removeAllItems();
            jCmbMarca.addItem("Selecionar");
            for (String marca : Marcas) {
                jCmbMarca.addItem(marca);
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

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> jCmbMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlblMarca;
    // End of variables declaration//GEN-END:variables
}
