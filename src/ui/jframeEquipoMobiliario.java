/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import controlador.CTr_Custodio;
import controlador.CTr_EquipoMobiliario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import negocio.Custodio;
import negocio.EquipoMobiliario;
import pagination.EventPagination;
import pagination.style.PaginationItemRenderStyle1;

/**
 *
 * @author David
 */
public class jframeEquipoMobiliario extends javax.swing.JInternalFrame {

    Color Bueno;
    Color Malo;
    private int totalFilas;
    private int filasPorPagina = 10;
    private int totalPaginas;
    private Object[] filasResultantes;

    public jframeEquipoMobiliario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        cargarComboBoxEstado();

        this.jcmbEstatus.setVisible(false);
        this.jlblEstatus.setVisible(false);
        jtxtNombreCus.setEnabled(false);
        this.jLblCus.setVisible(false);

        jcmbEstatus.removeAllItems();
        jcmbEstatus.addItem("Activo");
        jcmbEstatus.addItem("Inactivo");

        this.jcmbBuscar.removeAllItems();
        jcmbBuscar.addItem("Seleccionar");
        jcmbBuscar.addItem("Malos");
        jcmbBuscar.addItem("Buenos");
        jcmbBuscar.addItem("Inactivos");

        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                try {
                    cargarTabla(page);
                    mostrarFilasPaginaActual(page);
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
        });
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        cargarTabla(1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        panelShadow1 = new Components.PanelShadow();
        jlabelTitle1 = new javax.swing.JLabel();
        lblArt = new javax.swing.JLabel();
        jtxtNumArt = new javax.swing.JTextField();
        jlblCant = new javax.swing.JLabel();
        jTxtCantidad = new javax.swing.JTextField();
        jlblEtiqueta = new javax.swing.JLabel();
        jtxtEtiqueta = new javax.swing.JTextField();
        jlblEstado = new javax.swing.JLabel();
        jCmbEstado = new javax.swing.JComboBox<>();
        jtxtObservacion = new javax.swing.JTextField();
        jlblObservación = new javax.swing.JLabel();
        jtxtCod = new javax.swing.JTextField();
        lblCod = new javax.swing.JLabel();
        jlblDescripción = new javax.swing.JLabel();
        jtxtDescripcion = new javax.swing.JTextField();
        jlblCosto = new javax.swing.JLabel();
        jTxtCosto = new javax.swing.JTextField();
        jlblEstatus = new javax.swing.JLabel();
        jcmbEstatus = new javax.swing.JComboBox<>();
        jlabelTitle = new javax.swing.JLabel();
        jlblModelo1 = new javax.swing.JLabel();
        jtxtInss = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jLblCus = new javax.swing.JLabel();
        jtxtNombreCus = new javax.swing.JTextField();
        jlblModelo2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jcmbBuscar = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        pagination1 = new pagination.Pagination();
        jlabelTitle2 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jlabelTitle1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jlabelTitle1.setText("REGISTRAR EQUIPOS MOBILIARIO");

        lblArt.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblArt.setText("N° de articulo");

        jtxtNumArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNumArtActionPerformed(evt);
            }
        });
        jtxtNumArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNumArtKeyTyped(evt);
            }
        });

        jlblCant.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblCant.setText("Cantidad");

        jTxtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCantidadKeyTyped(evt);
            }
        });

        jlblEtiqueta.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblEtiqueta.setText("Etiqueta");

        jlblEstado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblEstado.setText("Estado");

        jCmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlblObservación.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblObservación.setText("Observación");

        lblCod.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblCod.setText("Código");

        jlblDescripción.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblDescripción.setText("Descripción");

        jtxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDescripcionActionPerformed(evt);
            }
        });

        jlblCosto.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblCosto.setText("Costo");

        jTxtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCostoKeyTyped(evt);
            }
        });

        jlblEstatus.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblEstatus.setText("Estatus");

        jcmbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlabelTitle.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle.setText("CUSTODIO");

        jlblModelo1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblModelo1.setText("Inss");

        btnBuscar1.setBackground(new java.awt.Color(16, 21, 64));
        btnBuscar1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnBuscar1.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        jLblCus.setBackground(new java.awt.Color(51, 153, 0));
        jLblCus.setForeground(new java.awt.Color(51, 153, 0));
        jLblCus.setText("Custodio Encontrado");

        jtxtNombreCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreCusActionPerformed(evt);
            }
        });

        jlblModelo2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblModelo2.setText("Nombre");

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

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jlabelTitle1))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblArt)
                        .addGap(13, 13, 13)
                        .addComponent(jtxtNumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblCant)
                        .addGap(22, 22, 22)
                        .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jlblEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jtxtEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jCmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblCod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jtxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jlblObservación))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblEstatus))
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jtxtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jlabelTitle))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jlblModelo1)
                        .addGap(29, 29, 29)
                        .addComponent(jtxtInss, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblModelo2)
                                .addGap(6, 6, 6)
                                .addComponent(jtxtNombreCus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLblCus)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jlabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblCant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jlblObservación)))
                .addGap(4, 4, 4)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jlblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jlblEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTxtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jcmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addComponent(jlabelTitle)
                .addGap(6, 6, 6)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jlblModelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtInss, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jlblModelo2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtNombreCus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLblCus)))
                .addGap(18, 18, 18)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
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

        jcmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcmbBuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbBuscarItemStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(64, 122, 237));

        pagination1.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlabelTitle2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle2.setText("EQUIPO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlabelTitle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelTitle2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtNumArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNumArtActionPerformed

    }//GEN-LAST:event_jtxtNumArtActionPerformed

    private void jtxtNumArtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNumArtKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Por favor solo numeros ",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtxtNumArtKeyTyped

    private void jTxtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCantidadKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Por favor solo numeros ",
                    "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jTxtCantidadKeyTyped

    private void jtxtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDescripcionActionPerformed

    }//GEN-LAST:event_jtxtDescripcionActionPerformed

    private void jTxtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCostoKeyTyped

        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Por favor solo numeros ",
                    "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jTxtCostoKeyTyped

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

        try {

            int val = Integer.parseInt(this.jtxtInss.getText());
            Custodio p = CTr_Custodio.leerRegistro(val);

            if (p != null) {
                this.jtxtNombreCus.setText(p.getNombres());
                this.jLblCus.setVisible(true);
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(null, "No Exite el registro con el numero "
                        + "de carnet: "
                        + String.valueOf(Integer.parseInt(this.jtxtInss.getText())));
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
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void jtxtNombreCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreCusActionPerformed

    }//GEN-LAST:event_jtxtNombreCusActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.Validacion()) {

            try {

                CTr_EquipoMobiliario EquipoService = new CTr_EquipoMobiliario();
                int numArticulo = Integer.parseInt(this.jtxtNumArt.getText());
                boolean existeRegistro = EquipoService.verificarEquipoRegistrado(numArticulo);

                if (!existeRegistro) {
                    int rst = CTr_EquipoMobiliario.agregar(
                            Integer.parseInt(this.jtxtInss.getText()),
                            numArticulo,
                            this.jtxtEtiqueta.getText(),
                            this.jtxtCod.getText(),
                            Integer.parseInt(this.jTxtCantidad.getText()),
                            this.jtxtDescripcion.getText(),
                            Double.parseDouble(this.jTxtCosto.getText()),
                            EquipoService.buscarIDEstado(jCmbEstado.getSelectedItem().toString()),
                            this.jtxtObservacion.getText()
                    );

                    if (rst > 0) {
                        JOptionPane.showMessageDialog(this, "Registro guardado con exito",
                                "Registro", JOptionPane.INFORMATION_MESSAGE);

                        this.cargarTabla(1);
                        limpiar();

                    }//Fin de la instrucción if
                } else {
                    JOptionPane.showMessageDialog(this, "Registro existente",
                            "Registro", JOptionPane.ERROR_MESSAGE);
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

                int val = Integer.parseInt(this.jtxtNumArt.getText());
                EquipoMobiliario p = CTr_EquipoMobiliario.leerRegistro(val);

                if (p != null) {
                    this.jtxtNombreCus.setText(p.getCustodio());
                    this.jtxtInss.setText(Integer.toString(p.getInss()));
                    this.jtxtNumArt.setText(Integer.toString(p.getNumeroArticulo()));
                    this.jtxtCod.setText(p.getCodigo());
                    this.jtxtEtiqueta.setText(p.getEtiqueta());
                    this.jTxtCantidad.setText(Integer.toString(p.getCantidad()));
                    this.jtxtDescripcion.setText(p.getDescripcion());
                    this.jTxtCosto.setText(Double.toString(p.getCosto()));
                    this.jCmbEstado.setSelectedItem(p.getNombreEstado());
                    this.jtxtObservacion.setText(p.getObservacion());

                    this.jcmbEstatus.setVisible(true);
                    this.jlblEstatus.setVisible(true);
                    if (p.getActivo() == 1) {
                        jcmbEstatus.setSelectedItem("Activo");
                    } else if (p.getActivo() == 0) {
                        jcmbEstatus.setSelectedItem("Inactivo");
                    }

                }//Fin de la instrucción if
                else {
                    JOptionPane.showMessageDialog(null, "No Exite el registro con el numero "
                            + "de carnet: "
                            + String.valueOf(Integer.parseInt(this.jtxtNumArt.getText())));
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

                CTr_EquipoMobiliario EquipoService = new CTr_EquipoMobiliario();
                int numArticulo = Integer.parseInt(this.jtxtNumArt.getText());
                boolean existeRegistro = EquipoService.verificarEquipoRegistrado(numArticulo);

                if (existeRegistro) {
                    int rst = CTr_EquipoMobiliario.actualizar(
                            Integer.parseInt(this.jtxtInss.getText()),
                            numArticulo,
                            Integer.parseInt(this.jTxtCantidad.getText()),
                            this.jtxtDescripcion.getText(),
                            Double.parseDouble(this.jTxtCosto.getText()),
                            EquipoService.buscarIDEstado(jCmbEstado.getSelectedItem().toString()),
                            this.jtxtObservacion.getText(),
                            Estatus()
                    );

                    if (rst > 0) {
                        JOptionPane.showMessageDialog(this, "Registro actualizado con exito",
                                "Actualizar Registro", JOptionPane.INFORMATION_MESSAGE);

                        this.cargarTabla(1);
                        limpiar();

                    }//Fin de la instrucción if
                }//Fin actualizar
                else // De lo contrario no existe
                {
                    JOptionPane.showMessageDialog(null, "No Exite es un nuevo registro:"
                            + String.valueOf(numArticulo));
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
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        try {

            CTr_EquipoMobiliario PersonalService = new CTr_EquipoMobiliario();
            int numArt = Integer.parseInt(this.jtxtNumArt.getText());
            boolean existeRegistro = PersonalService.verificarEquipoRegistrado(numArt);

            if (existeRegistro) {
                int rst = CTr_EquipoMobiliario.borrarRegistro(
                        numArt,
                        Estatus()
                );
                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro borrado con exito",
                            "Borrar Registro", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                    this.cargarTabla(1);

                }//Fin de la instrucción if
            }//Fin actualizar
            else // De lo contrario no existe
            {
                JOptionPane.showMessageDialog(null, "No Exite ese registro:"
                        + String.valueOf(numArt));
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
            String etiqueta = (String) jTableData.getValueAt(Fila, 1);
            EquipoMobiliario p = CTr_EquipoMobiliario.leerRegistroTabla(etiqueta);

            if (p != null) {
                this.jtxtNombreCus.setText(p.getCustodio());
                this.jtxtInss.setText(Integer.toString(p.getInss()));
                this.jtxtNumArt.setText(Integer.toString(p.getNumeroArticulo()));
                this.jtxtCod.setText(p.getCodigo());
                this.jtxtEtiqueta.setText(p.getEtiqueta());
                this.jTxtCantidad.setText(Integer.toString(p.getCantidad()));
                this.jtxtDescripcion.setText(p.getDescripcion());
                this.jTxtCosto.setText(Double.toString(p.getCosto()));
                this.jCmbEstado.setSelectedItem(p.getNombreEstado());
                this.jtxtObservacion.setText(p.getObservacion());

                this.jcmbEstatus.setVisible(true);
                this.jlblEstatus.setVisible(true);
                if (p.getActivo() == 1) {
                    jcmbEstatus.setSelectedItem("Activo");
                } else if (p.getActivo() == 0) {
                    jcmbEstatus.setSelectedItem("Inactivo");
                }

            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(null, "No Exite el registro con el numero "
                        + "de carnet: "
                        + String.valueOf(Integer.parseInt(this.jtxtNumArt.getText())));
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

    private void jcmbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbBuscarItemStateChanged
        try {
            this.cargarTabla(1);
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
    }//GEN-LAST:event_jcmbBuscarItemStateChanged

    public void limpiar() {
        this.jtxtInss.setText("");
        this.jtxtNombreCus.setText("");
        this.jtxtEtiqueta.setText("");
        this.jtxtCod.setText("");
        this.jTxtCosto.setText("");
        this.jtxtDescripcion.setText("");
        this.jtxtNumArt.setText("");
        this.jTxtCantidad.setText("");
        this.jtxtObservacion.setText("");
        this.jtxtNombreCus.setText("");
        this.jtxtInss.setText("");
        this.jcmbEstatus.setVisible(false);
        this.jlblEstatus.setVisible(false);
        this.jCmbEstado.setSelectedIndex(0);
        this.jLblCus.setVisible(false);

    }

    public int Estatus() {
        int estado = -1;
        if ("Activo".equals(jcmbEstatus.getSelectedItem().toString())) {
            estado = 1;
        } else if ("Inactivo".equals(jcmbEstatus.getSelectedItem().toString())) {
            estado = 0;
        }
        return estado;
    }

    public boolean Validacion() {

        boolean valido = true;

        if (jtxtNumArt.getText().isEmpty()) {

            return false;
        } else if (jtxtEtiqueta.getText().isEmpty()) {

            return false;

        } else if (jTxtCosto.getText().isEmpty()) {

            return false;
        } else if (jtxtDescripcion.getText().isEmpty()) {

            return false;
        } else if (jTxtCantidad.getText().isEmpty()) {

            return false;
        } else if (jtxtObservacion.getText().isEmpty()) {

            return false;

        } else if (jtxtInss.getText().isEmpty()) {

            return false;
        }
        return valido;
    }

    public boolean ValidacionBusqueda() {
        boolean valido = true;
        if (jtxtNumArt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La caja de texto  Numero de carnet esta vacia.",
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return valido;
    }

    private void cargarComboBoxEstado() throws SQLException {
        try {

            CTr_EquipoMobiliario EstadoService = new CTr_EquipoMobiliario();
            List<String> cargos = EstadoService.obtenerEstados();
            jCmbEstado.removeAllItems();
            jCmbEstado.addItem("Selecionar");
            for (String cargo : cargos) {
                jCmbEstado.addItem(cargo);
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

    private void cargarTabla(int page) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        jTableData.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTableData.getTableHeader().setOpaque(false);
        jTableData.getTableHeader().setBackground(new Color(32, 136, 203));
        jTableData.getTableHeader().setForeground(new Color(255, 255, 255));

        DefaultTableModel modelo = new DefaultTableModel();

        jTableData.setModel(modelo);

        modelo.addColumn("Custodio");
        modelo.addColumn("Etiqueta");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Descripción");
        modelo.addColumn("Estado");
        modelo.addColumn("Observación");

        CTr_EquipoMobiliario obb = new CTr_EquipoMobiliario();
        Object selectedItem = jcmbBuscar.getSelectedItem();

        if (selectedItem != null) {
            switch (selectedItem.toString()) {
                case "Malos" -> {
                    filasResultantes = obb.EquipoMalosList();
                    totalFilas = filasResultantes.length;

                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                    int filaInicial = (page - 1) * filasPorPagina;
                    int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);
                    for (int i = filaInicial; i < filaFinal; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }
                case "Buenos" -> {
                    filasResultantes = obb.EquipoBuenos();
                    totalFilas = filasResultantes.length;

                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                    int filaInicial = (page - 1) * filasPorPagina;
                    int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);
                    for (int i = filaInicial; i < filaFinal; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }
                case "Inactivos" -> {
                    filasResultantes = obb.EquipoInactivos();
                    totalFilas = filasResultantes.length;

                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                    int filaInicial = (page - 1) * filasPorPagina;
                    int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);
                    for (int i = filaInicial; i < filaFinal; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }
                case "Seleccionar" -> {
                    filasResultantes = obb.Listado();
                    totalFilas = filasResultantes.length;

                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                    int filaInicial = (page - 1) * filasPorPagina;
                    int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);
                    for (int i = filaInicial; i < filaFinal; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }
                default -> {
                    filasResultantes = obb.Listado();
                    totalFilas = filasResultantes.length;

                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                    int filaInicial = (page - 1) * filasPorPagina;
                    int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);
                    for (int i = filaInicial; i < filaFinal; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }

                }
            }
        }

        packColumns(jTableData, 6);

        Rectangle rect = jTableData.getCellRect(0, 0, true);
        jTableData.scrollRectToVisible(rect);
        int columnaEstado = jTableData.getColumnModel().getColumnIndex("Estado");

        jTableData.getColumnModel().getColumn(columnaEstado).setCellRenderer(new ActivoCellRenderer());

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

    class ActivoCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // Cambiar color de activo y inactivo
            String Estado = (String) value;
            if (Estado.equals("Bueno")) {
                Bueno = new Color(82, 183, 136);
                cellComponent.setBackground(Bueno); // 
            } else {
                Malo = new Color(255, 51, 51);
                cellComponent.setBackground(Malo);
            }
            return cellComponent;
        }
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
        TableColumnModel columnModel = table.getColumnModel();

        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = columnModel.getColumn(column);
            TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
            Component headerComp = headerRenderer.getTableCellRendererComponent(table, tableColumn.getHeaderValue(), false, false, 0, column);

            int width = headerComp.getPreferredSize().width;

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + margin, width);
            }

            tableColumn.setPreferredWidth(width);

            String columnTitle = tableColumn.getHeaderValue().toString();
            switch (columnTitle) {
                case "Custodio" ->
                    tableColumn.setHeaderValue("Custodio");
                case "N° de articulo" ->
                    tableColumn.setHeaderValue("N° de artículo");
                case "Cantidad" ->
                    tableColumn.setHeaderValue("Cantidad");
                case "Descripcion" ->
                    tableColumn.setHeaderValue("Descripcion");
                case "Estado" ->
                    tableColumn.setHeaderValue("Estado");
                case "Observacion" ->
                    tableColumn.setHeaderValue("Observacion");
                default -> {
                }
            }
        }

        table.getTableHeader().repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> jCmbEstado;
    private javax.swing.JLabel jLblCus;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableData;
    private javax.swing.JTextField jTxtCantidad;
    private javax.swing.JTextField jTxtCosto;
    private javax.swing.JComboBox<String> jcmbBuscar;
    private javax.swing.JComboBox<String> jcmbEstatus;
    private javax.swing.JLabel jlabelTitle;
    private javax.swing.JLabel jlabelTitle1;
    private javax.swing.JLabel jlabelTitle2;
    private javax.swing.JLabel jlblCant;
    private javax.swing.JLabel jlblCosto;
    private javax.swing.JLabel jlblDescripción;
    private javax.swing.JLabel jlblEstado;
    private javax.swing.JLabel jlblEstatus;
    private javax.swing.JLabel jlblEtiqueta;
    private javax.swing.JLabel jlblModelo1;
    private javax.swing.JLabel jlblModelo2;
    private javax.swing.JLabel jlblObservación;
    private javax.swing.JTextField jtxtCod;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtEtiqueta;
    private javax.swing.JTextField jtxtInss;
    private javax.swing.JTextField jtxtNombreCus;
    private javax.swing.JTextField jtxtNumArt;
    private javax.swing.JTextField jtxtObservacion;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblCod;
    private pagination.Pagination pagination1;
    private Components.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
