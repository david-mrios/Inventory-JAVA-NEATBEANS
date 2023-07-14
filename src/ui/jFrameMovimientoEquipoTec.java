/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import controlador.CTr_DetalleInvEqTecnologico;
import controlador.CTr_DetalleMovEqTec;
import controlador.CTr_EquipoTecnologico;
import controlador.CTr_Laboratorio;
import controlador.CTr_Movimientos;
import controlador.Ctr_Responsable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import negocio.EquipoTecnologico;
import negocio.Movimiento;
import negocio.Responsable;
import pagination.EventPagination;
import pagination.style.PaginationItemRenderStyle1;

/**
 *
 * @author David
 */
public class jFrameMovimientoEquipoTec extends javax.swing.JInternalFrame {

    int noInss;
    private int totalFilas;
    private int filasPorPagina = 10;
    private int totalPaginas;
    private Object[] filasResultantes;

    public jFrameMovimientoEquipoTec() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        cargarComboBoxEstado();

        cargarComboBoxLab();

        this.lblLocacionNew.setVisible(false);
        this.lblLocacionNow.setVisible(true);
        this.txtLocacionNew.setVisible(false);
        this.jComboBox1.setVisible(true);
        noMovimiento();

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

        dateChooser1 = new Components.datechooser.DateChooser();
        jPanel2 = new javax.swing.JPanel();
        panelShadow1 = new Components.PanelShadow();
        jlabelTitle1 = new javax.swing.JLabel();
        jtxtCarnet1 = new javax.swing.JTextField();
        jlblCarnet1 = new javax.swing.JLabel();
        jlblCarnet2 = new javax.swing.JLabel();
        jtxtResponsable = new javax.swing.JTextField();
        lblBuscarResponsable = new javax.swing.JLabel();
        jlblEstado = new javax.swing.JLabel();
        jcmbMovimiento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDateEntrada = new javax.swing.JTextField();
        btnDate2 = new javax.swing.JButton();
        jlabelTitle = new javax.swing.JLabel();
        lblArt = new javax.swing.JLabel();
        jtxtNumArt = new javax.swing.JTextField();
        lblBuscarEquipo = new javax.swing.JLabel();
        jlblDescripción = new javax.swing.JLabel();
        jtxtDescripcion = new javax.swing.JTextField();
        lblLocacionNow = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblLocacionNew = new javax.swing.JLabel();
        txtLocacionNew = new javax.swing.JTextField();
        lblObservacion = new javax.swing.JLabel();
        txtObservacion = new javax.swing.JTextField();
        btnGuardar1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        pagination1 = new pagination.Pagination();
        jtxtArt = new javax.swing.JTextField();
        jlabelTitle2 = new javax.swing.JLabel();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txtDateEntrada);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlabelTitle1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jlabelTitle1.setText("MOVIMIENTOS DE EQUIPOS TECNOLÓGICOS");

        jtxtCarnet1.setEnabled(false);
        jtxtCarnet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCarnet1ActionPerformed(evt);
            }
        });
        jtxtCarnet1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCarnet1KeyTyped(evt);
            }
        });

        jlblCarnet1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblCarnet1.setText("Número de movimiento");

        jlblCarnet2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblCarnet2.setText("Responsable");

        jtxtResponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtResponsableKeyTyped(evt);
            }
        });

        lblBuscarResponsable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscando.png"))); // NOI18N
        lblBuscarResponsable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarResponsableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBuscarResponsableMouseEntered(evt);
            }
        });

        jlblEstado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblEstado.setText("Tipo de movimiento");

        jcmbMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcmbMovimiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbMovimientoItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel3.setText("Fecha de ingreso");

        txtDateEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateEntradaActionPerformed(evt);
            }
        });

        btnDate2.setText("...");
        btnDate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDate2ActionPerformed(evt);
            }
        });

        jlabelTitle.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle.setText("INFORMACIÓN DEL EQUIPO");

        lblArt.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblArt.setText("N°  de articulo");

        lblBuscarEquipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscando.png"))); // NOI18N
        lblBuscarEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarEquipoMouseClicked(evt);
            }
        });

        jlblDescripción.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblDescripción.setText("Descripción");

        jtxtDescripcion.setEnabled(false);

        lblLocacionNow.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblLocacionNow.setText("Ubicación Actual");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblLocacionNew.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblLocacionNew.setText("Ubicación Nueva");

        lblObservacion.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblObservacion.setText("Observación");

        txtObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObservacionKeyTyped(evt);
            }
        });

        btnGuardar1.setBackground(new java.awt.Color(82, 183, 136));
        btnGuardar1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnGuardar1.setText("GUARDAR");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
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

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jlabelTitle1))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jtxtCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblCarnet2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jtxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblBuscarResponsable))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jcmbMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(lblLocacionNow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(lblLocacionNew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtLocacionNew, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(lblObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jlabelTitle)
                                .addGroup(panelShadow1Layout.createSequentialGroup()
                                    .addComponent(lblArt)
                                    .addGap(30, 30, 30)
                                    .addComponent(jtxtNumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(lblBuscarEquipo))))))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jlabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblCarnet2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarResponsable))
                .addGap(8, 8, 8)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(txtDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jlabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarEquipo))
                .addGap(8, 8, 8)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLocacionNow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLocacionNew, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocacionNew, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableData.setFocusable(false);
        jTableData.setRowHeight(25);
        jTableData.setSelectionBackground(new java.awt.Color(51, 102, 255));
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

        jPanel3.setBackground(new java.awt.Color(64, 122, 237));

        pagination1.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtxtArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtArtKeyPressed(evt);
            }
        });

        jlabelTitle2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle2.setText("NÚMERO DE ARTICULO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlabelTitle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtArt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabelTitle2)
                            .addComponent(jtxtArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtCarnet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCarnet1ActionPerformed

    }//GEN-LAST:event_jtxtCarnet1ActionPerformed

    private void jtxtCarnet1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCarnet1KeyTyped

    }//GEN-LAST:event_jtxtCarnet1KeyTyped

    private void jtxtResponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtResponsableKeyTyped

    }//GEN-LAST:event_jtxtResponsableKeyTyped

    private void lblBuscarResponsableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarResponsableMouseClicked
        try {
            String val = JOptionPane.showInputDialog(this, "Ingrese el número"
                    + "de inss", "Responsable", JOptionPane.INFORMATION_MESSAGE);
            noInss = Integer.parseInt(val);
            Responsable p = Ctr_Responsable.leerRegistro(noInss);

            if (p != null) {
                this.jtxtResponsable.setText(p.getNombres().concat(" ").concat(p.getApellidos()));
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(this, "No Exite el registro con el número "
                        + "de inss: "
                        + String.valueOf(Integer.toString(noInss)), "Responsable", JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_lblBuscarResponsableMouseClicked

    private void lblBuscarResponsableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarResponsableMouseEntered

    }//GEN-LAST:event_lblBuscarResponsableMouseEntered

    private void jcmbMovimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbMovimientoItemStateChanged

        Object Movimiento = this.jcmbMovimiento.getSelectedItem();
        if (Movimiento != null) {
            switch (Movimiento.toString()) {
                case "Traslado" -> {
                    this.lblLocacionNew.setVisible(true);
                    this.lblLocacionNow.setVisible(true);
                    this.txtLocacionNew.setVisible(true);
                    this.jComboBox1.setVisible(true);
                    this.lblLocacionNow.setText("Ubicacion actual");
                }
                case "Mantenimiento" -> {
                    this.lblLocacionNow.setVisible(true);
                    this.jComboBox1.setVisible(true);
                    this.lblLocacionNew.setVisible(false);
                    this.txtLocacionNew.setVisible(false);
                    this.lblLocacionNow.setText("Ubicacion actual");
                }
                case "Asignacion" -> {
                    this.lblLocacionNew.setVisible(false);
                    this.txtLocacionNew.setVisible(false);
                    this.lblLocacionNow.setVisible(true);
                    this.jComboBox1.setVisible(true);
                    this.lblLocacionNow.setText("Ubicacion");

                }
                case "Seleccionar" -> {
                    this.lblLocacionNew.setVisible(false);
                    this.lblLocacionNow.setVisible(true);
                    this.txtLocacionNew.setVisible(false);
                    this.jComboBox1.setVisible(true);
                    this.lblLocacionNow.setText("Ubicacion actual");
                }
                default -> {

                }
            }

        }
    }//GEN-LAST:event_jcmbMovimientoItemStateChanged

    private void txtDateEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateEntradaActionPerformed

    private void btnDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDate2ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_btnDate2ActionPerformed

    private void lblBuscarEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarEquipoMouseClicked
        try {

            String val = JOptionPane.showInputDialog(this, "Ingrese el número "
                    + "de articulo.", "Equipo tecnologico", JOptionPane.INFORMATION_MESSAGE);
            int numArt = Integer.parseInt(val);
            EquipoTecnologico p = CTr_EquipoTecnologico.leerRegistro(numArt);

            if (p != null) {
                this.jtxtNumArt.setText(Integer.toString(p.getNumeroArticulo()));
                this.jtxtDescripcion.setText(p.getDescripcion());
                Movimiento p2 = CTr_Movimientos.leerEquipoTecnologico(numArt);
                if (p2 != null) {
                    this.jComboBox1.setSelectedItem(p2.getNumeroLab());
                }
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(null, "No Exite el registro con el numero "
                        + "de articulo: "
                        + String.valueOf(Integer.toString(numArt)));
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
    }//GEN-LAST:event_lblBuscarEquipoMouseClicked

    private void txtObservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservacionKeyTyped

    }//GEN-LAST:event_txtObservacionKeyTyped

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        if (this.Validacion()) {
            try {

                int rst = CTr_Movimientos.agregar(Integer.parseInt(this.jtxtCarnet1.getText()) + 1,
                        noInss,
                        CTr_Movimientos.buscarIDLab(this.jComboBox1.getSelectedItem().toString()),
                        CTr_Movimientos.buscarIDtpMov(this.jcmbMovimiento.getSelectedItem().toString()),
                        this.txtLocacionNew.getText(),
                        this.txtObservacion.getText(), this.txtDateEntrada.getText()
                );
                int rst2 = CTr_DetalleMovEqTec.agregar(Integer.parseInt(this.jtxtCarnet1.getText()) + 1,
                        CTr_DetalleInvEqTecnologico.buscarIDEquipo(Integer.parseInt(this.jtxtNumArt.getText())));
                if (rst > 0 && rst2 > 0) {

                    JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                            "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Registro no grabado, ya existe",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                this.cargarTabla(1);
                this.Limpiar();
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
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        try {
            this.Limpiar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                    + "el manejo de la solicitud \n en recurso de Base de Datos" + ex.toString(),
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseClicked

        try {

            int Fila = jTableData.getSelectedRow();
            int numInventario = (int) jTableData.getValueAt(Fila, 0);
            Movimiento p = CTr_Movimientos.leerRegistro(numInventario);

            if (p != null) {
                jtxtCarnet1.setText(Integer.toString(p.getNoMovimiento()));
                jtxtResponsable.setText(p.getResponsable());
                jcmbMovimiento.setSelectedItem(p.getTipoMovimiento());
                jtxtNumArt.setText(Integer.toString(p.getNumArtEquipo()));
                jtxtDescripcion.setText(p.getDescripcion());
                jComboBox1.setSelectedItem(p.getNumeroLab());
                txtLocacionNew.setText(p.getLocacionNueva());
                txtObservacion.setText(p.getObservacion());
                txtDateEntrada.setText(p.getFechaIngreso());
                txtLocacionNew.setVisible(true);
                lblLocacionNew.setVisible(true);

            }//Fin de la instrucción if

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

    private void jtxtArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtArtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
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
            this.jtxtArt.setText(null);

        }
    }//GEN-LAST:event_jtxtArtKeyPressed

    private void cargarComboBoxEstado() throws SQLException {
        try {

            CTr_Movimientos EstadoService = new CTr_Movimientos();
            List<String> cargos = EstadoService.obtenerEstados();
            jcmbMovimiento.removeAllItems();
            jcmbMovimiento.addItem("Seleccionar");
            for (String cargo : cargos) {
                jcmbMovimiento.addItem(cargo);
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

    private void noMovimiento() throws SQLException {
        try {
            int count = CTr_Movimientos.noMovimiento();
            jtxtCarnet1.setText(Integer.toString(count));

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

        if (jtxtArt.getText().isEmpty()) {
            modelo.setColumnIdentifiers(new String[]{
                "N° de Movimiento",
                "N° de articulo",
                "Descripción",
                "Fecha",
                "Movimiento",
                "Locación Nueva",
                "Laboratorio"
            });

            CTr_Movimientos obb = new CTr_Movimientos();
            filasResultantes = obb.ListarMovimientosTec();
        } else if (jtxtArt.getText() != null) {
            modelo.setColumnIdentifiers(new String[]{
                "N° de Movimiento",
                "N° de articulo",
                "Descripción",
                "Movimiento",
                "Fecha",
                "Locación actual",
                "Laboratorio"
            });

            CTr_Movimientos obb = new CTr_Movimientos();
            filasResultantes = obb.ListarMovimientosEquipoTec(Integer.parseInt(jtxtArt.getText()));
        }

        jTableData.setModel(modelo);

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
            int preferredWidth = 0;

            // Encabezado
            TableCellRenderer headerRenderer = tableColumn.getHeaderRenderer();
            if (headerRenderer == null) {
                headerRenderer = table.getTableHeader().getDefaultRenderer();
            }
            Object headerValue = tableColumn.getHeaderValue();
            Component headerComp = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, 0, column);
            preferredWidth = Math.max(preferredWidth, headerComp.getPreferredSize().width);

            // Celdas
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component cellComp = table.prepareRenderer(cellRenderer, row, column);
                preferredWidth = Math.max(preferredWidth, cellComp.getPreferredSize().width);
            }

            preferredWidth += 2 * margin;
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }

    private void Limpiar() throws SQLException {

        jtxtResponsable.setText("");
        jtxtNumArt.setText("");
        jtxtDescripcion.setText("");
        jComboBox1.setSelectedItem("Seleccionar");
        txtLocacionNew.setVisible(false);
        txtObservacion.setText("");
        jcmbMovimiento.setSelectedItem("Seleccionar");
        this.noMovimiento();
    }

    private void cargarComboBoxLab() throws SQLException {
        try {

            CTr_Laboratorio Service = new CTr_Laboratorio();
            List<String> cargos = Service.getLaboratorios();
            jComboBox1.removeAllItems();
            jComboBox1.addItem("Seleccionar");
            for (String cargo : cargos) {
                jComboBox1.addItem(cargo);
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

    public boolean Validacion() {

        boolean valido = true;

        if (jtxtNumArt.getText().isEmpty()) {

            return false; // si entra alguna condicion devuelve inmediatamente el valor de false
        } else if (jtxtResponsable.getText().isEmpty()) {

            return false;

        } else if (jcmbMovimiento.getSelectedItem().equals("Seleccionar")) {

            return false;
        } else if (jtxtNumArt.getText().isEmpty()) {

            return false;
        } else if (jComboBox1.getSelectedItem().equals("Seleccionar")) {

            return false;
        }
        return valido;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDate2;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnLimpiar;
    private Components.datechooser.DateChooser dateChooser1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableData;
    private javax.swing.JComboBox<String> jcmbMovimiento;
    private javax.swing.JLabel jlabelTitle;
    private javax.swing.JLabel jlabelTitle1;
    private javax.swing.JLabel jlabelTitle2;
    private javax.swing.JLabel jlblCarnet1;
    private javax.swing.JLabel jlblCarnet2;
    private javax.swing.JLabel jlblDescripción;
    private javax.swing.JLabel jlblEstado;
    private javax.swing.JTextField jtxtArt;
    private javax.swing.JTextField jtxtCarnet1;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtNumArt;
    private javax.swing.JTextField jtxtResponsable;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblBuscarEquipo;
    private javax.swing.JLabel lblBuscarResponsable;
    private javax.swing.JLabel lblLocacionNew;
    private javax.swing.JLabel lblLocacionNow;
    private javax.swing.JLabel lblObservacion;
    private pagination.Pagination pagination1;
    private Components.PanelShadow panelShadow1;
    private javax.swing.JTextField txtDateEntrada;
    private javax.swing.JTextField txtLocacionNew;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
