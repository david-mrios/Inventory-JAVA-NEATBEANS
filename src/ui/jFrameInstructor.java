/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import controlador.CTr_Custodio;
import controlador.CTr_Instructor;
import controlador.Ctr_Responsable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import negocio.Instructor;
import pagination.EventPagination;
import pagination.style.PaginationItemRenderStyle1;

/**
 *
 * @author David
 */
public class jFrameInstructor extends javax.swing.JInternalFrame {

    Color Bueno;
    Color Malo;
    private int totalFilas;
    private int filasPorPagina = 10;
    private int totalPaginas;
    private Object[] filasResultantes;

    public jFrameInstructor() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        this.jcmbEstado.setVisible(false);
        this.jlblEstado.setVisible(false);
        jcmbEstado.removeAllItems();
        jcmbEstado.addItem("Activo");
        jcmbEstado.addItem("Inactivo");

        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                try {
                    cargarTabla(page);
                    mostrarFilasPaginaActual(page);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error al intentar guardar "
                            + "el \n registro, no se encuentra una librería", "Librería no Encontrada", JOptionPane.ERROR_MESSAGE);
                } catch (InstantiationException ex) {
                    JOptionPane.showMessageDialog(null, "Se ha producido una falla al "
                            + "hacer referencia \n de una instancia",
                            "Instancia no Encontrada", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalAccessException ex) {
                    JOptionPane.showMessageDialog(null, "Se ha denegado el acceso al "
                            + "intentar utilizar \n la librería o instancia para guardar", "Acceso Ilegal a un Recurso", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Se ha producido una falla con "
                            + "el manejo de la solicitud \n en recurso de Base de Datos"
                            + ex.getMessage(),
                            "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        try {
            cargarTabla(1);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar guardar "
                    + "el \n registro, no se encuentra una librería", "Librería no Encontrada",
                    JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido una falla al "
                    + "hacer referencia \n de una instancia",
                    "Instancia no Encontrada", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Se ha denegado el acceso al "
                    + "intentar utilizar \n la librería o instancia para guardar",
                    "Acceso Ilegal a un Recurso", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido una falla con "
                    + "el manejo de la solicitud \n en recurso de Base de Datos"
                    + ex.getMessage(),
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new Components.PanelShadow();
        jlblCardheader = new javax.swing.JLabel();
        jlblNombres = new javax.swing.JLabel();
        jtxtNombres = new javax.swing.JTextField();
        jtxtCarnet = new javax.swing.JTextField();
        jlblCarnet1 = new javax.swing.JLabel();
        jlblApellidos = new javax.swing.JLabel();
        jtxtApellidos = new javax.swing.JTextField();
        jlblTeléfono = new javax.swing.JLabel();
        jtxtnumTelefono = new javax.swing.JTextField();
        jlblcedula = new javax.swing.JLabel();
        jFormattedTextCedula = new javax.swing.JFormattedTextField();
        jlblEstado = new javax.swing.JLabel();
        jcmbEstado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jlabelTitle1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        pnlPaginar = new javax.swing.JPanel();
        pagination1 = new pagination.Pagination();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jlblCardheader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Card_Header (2).png"))); // NOI18N

        jlblNombres.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jlblNombres.setText("Nombres");

        jtxtCarnet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCarnetKeyTyped(evt);
            }
        });

        jlblCarnet1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jlblCarnet1.setText("N° de carnet");

        jlblApellidos.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jlblApellidos.setText("Apellidos");

        jlblTeléfono.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jlblTeléfono.setText("Teléfono");

        jtxtnumTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtnumTelefonoKeyTyped(evt);
            }
        });

        jlblcedula.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jlblcedula.setText("Cédula");

        try {
            jFormattedTextCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-####*")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jlblEstado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jlblEstado.setText("Estado");

        jcmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setBackground(new java.awt.Color(82, 183, 136));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(82, 183, 136));
        btnBuscar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(82, 183, 136));
        btnActualizar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(82, 183, 136));
        btnLimpiar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnBorrar.setBackground(new java.awt.Color(82, 183, 136));
        btnBorrar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jlabelTitle1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jlabelTitle1.setText("REGISTRO DE INSTRUCTOR");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jlabelTitle1))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblCarnet1)
                                .addGap(21, 21, 21)
                                .addComponent(jtxtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblNombres)
                                .addGap(11, 11, 11)
                                .addComponent(jtxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblApellidos)
                                .addGap(11, 11, 11)
                                .addComponent(jtxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblTeléfono)
                                .addGap(14, 14, 14)
                                .addComponent(jtxtnumTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblcedula)
                                .addGap(25, 25, 25)
                                .addComponent(jFormattedTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblEstado)
                                .addGap(27, 27, 27)
                                .addComponent(jcmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jlblCardheader, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jlabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlblCardheader, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblNombres)
                            .addComponent(jtxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblTeléfono)
                            .addComponent(jtxtnumTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableData.setFocusable(false);
        jTableData.setRowHeight(25);
        jTableData.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTableData.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableData.setShowHorizontalLines(true);
        jTableData.getTableHeader().setReorderingAllowed(false);
        jTableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableData);
        jTableData.getTableHeader().setPreferredSize(new java.awt.Dimension(jTableData.getColumnModel().getTotalColumnWidth(), 56));

        javax.swing.table.JTableHeader header = jTableData.getTableHeader();
        header.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(220,220,220))); // Establecer solo el borde inferior
        header.setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                component.setBackground(java.awt.Color.WHITE); // Establecer el color de fondo en blanco
                component.setFont(component.getFont().deriveFont(java.awt.Font.BOLD));

                return component;
            }
        });

        pnlPaginar.setBackground(new java.awt.Color(64, 122, 237));

        pagination1.setOpaque(false);

        javax.swing.GroupLayout pnlPaginarLayout = new javax.swing.GroupLayout(pnlPaginar);
        pnlPaginar.setLayout(pnlPaginarLayout);
        pnlPaginarLayout.setHorizontalGroup(
            pnlPaginarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaginarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPaginarLayout.setVerticalGroup(
            pnlPaginarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaginarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addComponent(pnlPaginar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlPaginar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCarnetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCarnetKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Por favor solo numeros ",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtxtCarnetKeyTyped

    private void jtxtnumTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtnumTelefonoKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Por favor solo numeros ",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtxtnumTelefonoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.Validacion()) {
            try {
                int carnet = Integer.parseInt(this.jtxtCarnet.getText());
                boolean existeResponsable = Ctr_Responsable.verificarCarnetRegistrado(carnet);
                boolean existeCustodio = CTr_Custodio.verificarInssRegistrado(carnet);
                boolean existeInstructor = CTr_Instructor.verificarCarnetRegistrado(carnet);

                if (existeResponsable) {

                    JOptionPane.showMessageDialog(this, "Este registro ya existe como Reponsable",
                            "Registro no grabado", JOptionPane.ERROR_MESSAGE);

                } else if (existeCustodio) {
                    JOptionPane.showMessageDialog(this, "Este registro ya existe como Custodio",
                            "Registro no grabado", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (!existeInstructor) {
                        int rst = CTr_Instructor.agregar(
                                Integer.parseInt(this.jtxtCarnet.getText()),
                                this.jtxtNombres.getText(),
                                this.jtxtApellidos.getText(),
                                Integer.parseInt(this.jtxtnumTelefono.getText()),
                                this.jFormattedTextCedula.getText());

                        limpiarRregistro();
                        this.cargarTabla(1);

                        if (rst > 0) {
                            JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                                    "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Registro no grabado, ya existe",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
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

        } else {
            JOptionPane.showMessageDialog(this, "Alguna caja de texto esta vacia",
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (ValidacionBusqueda() == true) {
            try {

                int val = Integer.parseInt(this.jtxtCarnet.getText());
                Instructor p = CTr_Instructor.leerRegistro(val);

                if (p != null) {
                    this.jtxtNombres.setText(p.getNombres());
                    this.jtxtApellidos.setText(p.getApellidos());
                    this.jtxtnumTelefono.setText(Integer.toString(p.getTelefono()));
                    this.jFormattedTextCedula.setText(p.getCedula());
                    this.jcmbEstado.setVisible(true);
                    this.jlblEstado.setVisible(true);
                    if (p.getActivo() == 1) {
                        jcmbEstado.setSelectedItem("Activo");
                    } else if (p.getActivo() == 0) {
                        jcmbEstado.setSelectedItem("Inactivo");
                    }

                }//Fin de la instrucción if
                else {
                    JOptionPane.showMessageDialog(this, "No Exite el registro con el número "
                            + "de carnet: "
                            + String.valueOf(Integer.parseInt(this.jtxtCarnet.getText())), "Instructor", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "La caja de texto  Numero de carnet esta vacia.",
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (this.Validacion()) {
            try {

                int carnet = Integer.parseInt(this.jtxtCarnet.getText());
                boolean existeRegistro = CTr_Instructor.verificarCarnetRegistrado(carnet);

                if (existeRegistro) {
                    int rst = CTr_Instructor.actualizar(carnet,
                            this.jtxtNombres.getText(),
                            this.jtxtApellidos.getText(),
                            Integer.parseInt(this.jtxtnumTelefono.getText()),
                            this.jFormattedTextCedula.getText(),
                            Estado()
                    );
                    if (rst > 0) {
                        JOptionPane.showMessageDialog(this, "Registro actualizado con exito",
                                "Actualizar Registro", JOptionPane.INFORMATION_MESSAGE);
                        limpiarRregistro();
                        cargarTabla(1);

                    }//Fin de la instrucción if
                }//Fin actualizar
                else // De lo contrario no existe
                {
                    JOptionPane.showMessageDialog(null, "No Exite es un nuevo registro:"
                            + String.valueOf(carnet));
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
                        + "el manejo de la solicitud \n en recurso de Base de Datos" + ex.toString(),
                        "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
            }//Fin de instrucción catch

        } else {
            JOptionPane.showMessageDialog(this, "Alguna caja de texto esta vacia",
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarRregistro();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        try {

            int carnet = Integer.parseInt(this.jtxtCarnet.getText());
            boolean existeRegistro = CTr_Instructor.verificarCarnetRegistrado(carnet);

            if (existeRegistro) {
                int rst = CTr_Instructor.borrarRegistro(
                        carnet,
                        Estado()
                );
                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro borrado con exito",
                            "Borrar Registro", JOptionPane.INFORMATION_MESSAGE);
                    limpiarRregistro();
                    cargarTabla(1);

                }//Fin de la instrucción if
            }//Fin actualizar
            else // De lo contrario no existe
            {
                JOptionPane.showMessageDialog(null, "No Exite ese registro:"
                        + String.valueOf(carnet));
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

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseClicked
        try {

            int Fila = jTableData.getSelectedRow();
            int inss = (int) jTableData.getValueAt(Fila, 0);
            Instructor p = CTr_Instructor.leerRegistro(inss);

            if (p != null) {
                this.jtxtCarnet.setText(Integer.toString(p.getNoCarnet()));
                this.jtxtNombres.setText(p.getNombres());
                this.jtxtApellidos.setText(p.getApellidos());
                this.jtxtnumTelefono.setText(Integer.toString(p.getTelefono()));
                this.jFormattedTextCedula.setText(p.getCedula());
                this.jcmbEstado.setVisible(true);
                this.jlblEstado.setVisible(true);
                if (p.getActivo() == 1) {
                    jcmbEstado.setSelectedItem("Activo");
                } else if (p.getActivo() == 0) {
                    jcmbEstado.setSelectedItem("Inactivo");
                }

            }//Fin de la instrucción if
            else {
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
    }//GEN-LAST:event_jTableDataMouseClicked
    public void limpiarRregistro() {
        this.jtxtNombres.setText("");
        this.jtxtApellidos.setText("");
        this.jtxtnumTelefono.setText("");
        this.jFormattedTextCedula.setText("");
        this.jtxtCarnet.setText("");
        this.jcmbEstado.setVisible(false);
        this.jlblEstado.setVisible(false);
    }

    public int Estado() {
        int estado = -1;
        if ("Activo".equals(jcmbEstado.getSelectedItem().toString())) {
            estado = 1;
        } else if ("Inactivo".equals(jcmbEstado.getSelectedItem().toString())) {
            estado = 0;
        }
        return estado;
    }

    public boolean ValidacionBusqueda() {
        boolean valido = true;
        if (jtxtCarnet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La caja de texto  Numero de carnet esta vacia.",
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return valido;
    }

    private void cargarTabla(int page) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        jTableData.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTableData.getTableHeader().setOpaque(false);
        jTableData.getTableHeader().setBackground(new Color(32, 136, 203));
        jTableData.getTableHeader().setForeground(new Color(255, 255, 255));

        DefaultTableModel modelo = new DefaultTableModel();
        jTableData.setModel(modelo);

        modelo.addColumn("no Carnet");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Cédula");

        CTr_Instructor obb = new CTr_Instructor();
        filasResultantes = obb.Listado();
        totalFilas = filasResultantes.length;
        totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
        int filaInicial = (page - 1) * filasPorPagina;
        int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);

        for (int i = filaInicial; i < filaFinal; i++) {
            modelo.addRow((Object[]) filasResultantes[i]);
        }

        packColumns(jTableData, 6);

        Rectangle rect = jTableData.getCellRect(0, 0, true);
        jTableData.scrollRectToVisible(rect);

        mostrarFilasPaginaActual(page);
        pagination1.setPagegination(page, totalPaginas);

    }

    private void mostrarFilasPaginaActual(int page) {

        DefaultTableModel modelo = (DefaultTableModel) jTableData.getModel();
        modelo.setRowCount(0);

        int filaInicial = (page - 1) * filasPorPagina;
        int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);

        if (filasResultantes != null && filaInicial >= 0 && filaInicial < filasResultantes.length && filaFinal <= filasResultantes.length) {

            for (int i = filaInicial; i < filaFinal; i++) {
                modelo.addRow((Object[]) filasResultantes[i]);
            }
        }

        jTableData.repaint();
    }

    /**
     * Ajusta automáticamente el ancho de las columnas al contenido horizontal
     * en una tabla.
     *
     * @param table La tabla a la que se le ajustarán las columnas.
     * @param margin El margen adicional que se agregará al ancho calculado de
     * cada columna.
     */
    private void packColumns(JTable table, int margin) {
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int width = margin; // Establecer un margen inicial

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + margin, width);
            }

            tableColumn.setPreferredWidth(width);
        }
    }

    public boolean Validacion() {

        boolean valido = true;

        if (jtxtCarnet.getText().isEmpty()) {

            return false; // si entra alguna condicion devuelve inmediatamente el valor de false
        } else if (jtxtNombres.getText().isEmpty()) {

            return false;

        } else if (jtxtApellidos.getText().isEmpty()) {

            return false;
        } else if (jtxtnumTelefono.getText().isEmpty()) {

            return false;
        } else if (jFormattedTextCedula.getText().isEmpty()) {

            return false;
        } else if (jcmbEstado.getSelectedItem().equals("Seleccionar")) {

            return false;
        }
        return valido;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JFormattedTextField jFormattedTextCedula;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableData;
    private javax.swing.JComboBox<String> jcmbEstado;
    private javax.swing.JLabel jlabelTitle1;
    private javax.swing.JLabel jlblApellidos;
    private javax.swing.JLabel jlblCardheader;
    private javax.swing.JLabel jlblCarnet1;
    private javax.swing.JLabel jlblEstado;
    private javax.swing.JLabel jlblNombres;
    private javax.swing.JLabel jlblTeléfono;
    private javax.swing.JLabel jlblcedula;
    private javax.swing.JTextField jtxtApellidos;
    private javax.swing.JTextField jtxtCarnet;
    private javax.swing.JTextField jtxtNombres;
    private javax.swing.JTextField jtxtnumTelefono;
    private pagination.Pagination pagination1;
    private Components.PanelShadow panelShadow1;
    private javax.swing.JPanel pnlPaginar;
    // End of variables declaration//GEN-END:variables
}
