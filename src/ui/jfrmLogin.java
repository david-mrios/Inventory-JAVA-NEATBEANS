/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import controlador.CTr_usuario_c;
import controlador.CTr_usuario_i;
import controlador.CTr_usuario_r;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import negocio.usuario_c;
import negocio.usuario_i;
import negocio.usuario_r;

/**
 *
 * @author David
 */
public class jfrmLogin extends javax.swing.JFrame {

    public jfrmLogin() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelShadow1 = new Components.PanelShadow();
        jlblCardheader = new javax.swing.JLabel();
        jlblBienvenida = new javax.swing.JLabel();
        jlblBienvenida2 = new javax.swing.JLabel();
        jlblUser = new javax.swing.JLabel();
        jtxtUsuario = new javax.swing.JTextField();
        jlblContraseña = new javax.swing.JLabel();
        jbtnIniciarSesión = new javax.swing.JButton();
        jtxtContrasenia = new javax.swing.JPasswordField();
        btnContra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlblCardheader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Card_Header (2).png"))); // NOI18N

        jlblBienvenida.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jlblBienvenida.setText("¡BIENVENIDO A INVENTORY!");

        jlblBienvenida2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblBienvenida2.setText("Inicia sesión por favor");

        jlblUser.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        jlblUser.setText("Correo");

        jlblContraseña.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        jlblContraseña.setText("Contraseña");

        jbtnIniciarSesión.setBackground(new java.awt.Color(0, 51, 153));
        jbtnIniciarSesión.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        jbtnIniciarSesión.setForeground(new java.awt.Color(240, 240, 240));
        jbtnIniciarSesión.setText("Iniciar sesión");
        jbtnIniciarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIniciarSesiónActionPerformed(evt);
            }
        });

        jtxtContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtContraseniaActionPerformed(evt);
            }
        });

        btnContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ojo.png"))); // NOI18N
        btnContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContraMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnContraMousePressed(evt);
            }
        });
        btnContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jbtnIniciarSesión))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblContraseña)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jtxtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnContra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlblUser))))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelShadow1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlblCardheader)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(jlblBienvenida2))
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jlblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(jlblUser)
                .addGap(49, 49, 49)
                .addComponent(jlblContraseña)
                .addGap(14, 14, 14)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnContra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnIniciarSesión, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelShadow1Layout.createSequentialGroup()
                    .addGap(0, 19, Short.MAX_VALUE)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlblCardheader)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jlblBienvenida2))
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jlblBienvenida)))
                    .addGap(68, 68, 68)
                    .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 205, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {

            FileInputStream fis = new FileInputStream(System.getProperty(
                    "user.dir") + "\\src\\servicios\\config.txt");
            Properties p = new Properties(System.getProperties());
            p.load(fis);
            System.setProperties(p);
        } catch (java.io.FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo de Configuración"
                    + " de acceso a datos \n no encontrado, revisar configuración",
                    "Configuración de acceso", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }//Fin de la instrucción catch
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error en lectura de datos "
                    + "de inicio de configuración   \n",
                    "Error al leer configuración",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }//Fin catch) 

    }//GEN-LAST:event_formWindowOpened

    private void jbtnIniciarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIniciarSesiónActionPerformed
        if (this.Validacion()) {
            try {

                int correo = Integer.parseInt(this.jtxtUsuario.getText());
                String contrasenia = this.jtxtContrasenia.getText();

                usuario_c c = CTr_usuario_c.VerificarRegistro(contrasenia, correo);
                usuario_r r = CTr_usuario_r.VerificarRegistro(contrasenia, correo);
                usuario_i i = CTr_usuario_i.VerificarRegistro(contrasenia, correo);

                if (c != null) {

                    Home obb = new Home();
                    obb.setVisible(true);
                    obb.jlblSesion.setText(c.getNombre());
                    Home.jLblRol.setText("Custodio");

                    this.dispose();
                    obb.repaint();
                } else if (r != null) {
                    Home obb = new Home();
                    obb.setVisible(true);
                    obb.jlblSesion.setText(r.getNombre());
                    Home.jLblRol.setText("Responsable");

                    this.dispose();

                } else if (i != null) {
                    Home obb = new Home();
                    obb.setVisible(true);
                    obb.jlblSesion.setText(i.getNombre());
                    obb.jLblRol.setText("Instructor");

                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Error al intentar ingresar "
                            + ",el registro  no se encuentra en la base de datos",
                            "Usuario no Encontrado", JOptionPane.ERROR_MESSAGE);
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
            }
            //Fin de instrucción catch
        } else {

            JOptionPane.showMessageDialog(this, "Alguna caja de texto esta vacia",
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnIniciarSesiónActionPerformed

    private void btnContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContraActionPerformed


    }//GEN-LAST:event_btnContraActionPerformed

    private void jtxtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtContraseniaActionPerformed

    }//GEN-LAST:event_jtxtContraseniaActionPerformed

    private void btnContraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContraMousePressed
        jtxtContrasenia.setEchoChar((char) 0); // Mostrar la contraseña 
    }//GEN-LAST:event_btnContraMousePressed

    private void btnContraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContraMouseExited
        jtxtContrasenia.setEchoChar('*'); // Ocultar la contraseña 
    }//GEN-LAST:event_btnContraMouseExited

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
            java.util.logging.Logger.getLogger(jfrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new jfrmLogin().setVisible(true);

        });
        try {

            FileInputStream fis = new FileInputStream(System.getProperty(
                    "user.dir") + "\\src\\servicios\\config.txt");
            Properties p = new Properties(System.getProperties());
            p.load(fis);
            System.setProperties(p);
        } catch (java.io.FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo de Configuración"
                    + " de acceso a datos \n no encontrado, revisar configuración",
                    "Configuración de acceso", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }//Fin de la instrucción catch
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error en lectura de datos "
                    + "de inicio de configuración   \n",
                    "Error al leer configuración",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }//Fin catch) 

    }

    public boolean Validacion() {

        boolean valido = true;
        char[] contraChar = jtxtContrasenia.getPassword();
        // Convertir el arreglo de caracteres en una cadena de texto
        String contrasenia = new String(contraChar);

        if (jtxtUsuario.getText().isEmpty()) {

            return false;
        } else if (contrasenia.isEmpty()) {

            return false;

        }
        return valido;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContra;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtnIniciarSesión;
    private javax.swing.JLabel jlblBienvenida;
    private javax.swing.JLabel jlblBienvenida2;
    private javax.swing.JLabel jlblCardheader;
    private javax.swing.JLabel jlblContraseña;
    private javax.swing.JLabel jlblUser;
    private javax.swing.JPasswordField jtxtContrasenia;
    private javax.swing.JTextField jtxtUsuario;
    private Components.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
