/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import controlador.CTr_Custodio;
import controlador.CTr_DetalleInvEqTecnologico;
import controlador.CTr_EquipoTecnologico;
import controlador.CTr_Inventario;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import controlador.Ctr_Responsable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import negocio.Custodio;
import negocio.EquipoTecnologico;
import negocio.Inventario;
import negocio.Responsable;
import pagination.EventPagination;
import pagination.style.PaginationItemRenderStyle1;

/**
 *
 * @author David
 */
public class jFrameInvEquipoTec extends javax.swing.JInternalFrame {

    int noInssRes;
    int noInssCus;
    private int totalFilas;
    private int filasPorPagina = 10;
    private int totalPaginas;
    private Object[] filasResultantes;

    public jFrameInvEquipoTec() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        initComponents();
        this.setMaximizable(true);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        btnGuardarEquipo.setVisible(false);
        btnLimpiar.setVisible(false);

        cargarComboBox();

        getNoInventario();

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
        jlabelTitle = new javax.swing.JLabel();
        jlabelTitle2 = new javax.swing.JLabel();
        jlblCarnet1 = new javax.swing.JLabel();
        jtxtCarnet1 = new javax.swing.JTextField();
        lblBuscarResponsable = new javax.swing.JLabel();
        jtxtResponsable = new javax.swing.JTextField();
        jlblcedula = new javax.swing.JLabel();
        jlblEstado = new javax.swing.JLabel();
        jtxtCarnet = new javax.swing.JTextField();
        lblBuscarResponsable2 = new javax.swing.JLabel();
        btnDate2 = new javax.swing.JButton();
        txtDateEntrada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jlblNombres = new javax.swing.JLabel();
        jcmbFacultad = new javax.swing.JComboBox<>();
        jlblApellidos = new javax.swing.JLabel();
        jcmbRencinto = new javax.swing.JComboBox<>();
        jlblTeléfono = new javax.swing.JLabel();
        jcmbDepartamento = new javax.swing.JComboBox<>();
        lblArt = new javax.swing.JLabel();
        jtxtNumArt = new javax.swing.JTextField();
        lblBuscarResponsable1 = new javax.swing.JLabel();
        jlblDescripción = new javax.swing.JLabel();
        jtxtDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnGuardarEquipo = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jtxtNumInventario = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pagination1 = new pagination.Pagination();
        jlabelTitle3 = new javax.swing.JLabel();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txtDateEntrada);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlabelTitle1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jlabelTitle1.setText("INVENTARIO DE EQUIPOS TECNOLÓGICOS");

        jlabelTitle.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle.setText("UBICACIÓN ");

        jlabelTitle2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle2.setText("EQUIPO");

        jlblCarnet1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblCarnet1.setText("Número de inventario");

        jtxtCarnet1.setEnabled(false);
        jtxtCarnet1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCarnet1KeyTyped(evt);
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

        jtxtResponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtResponsableKeyTyped(evt);
            }
        });

        jlblcedula.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblcedula.setText("Responsable");

        jlblEstado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblEstado.setText("Custodio");

        jtxtCarnet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCarnetKeyTyped(evt);
            }
        });

        lblBuscarResponsable2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscando.png"))); // NOI18N
        lblBuscarResponsable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarResponsable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBuscarResponsable2MouseEntered(evt);
            }
        });

        btnDate2.setText("...");
        btnDate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDate2ActionPerformed(evt);
            }
        });

        txtDateEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateEntradaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel3.setText("Fecha de ingreso");

        jlblNombres.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblNombres.setText("Facultad");

        jlblApellidos.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblApellidos.setText("Recinto Universitario\t\t\t ");

        jlblTeléfono.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblTeléfono.setText("Dependencia");

        jcmbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbDepartamentoActionPerformed(evt);
            }
        });

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

        lblBuscarResponsable1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscando.png"))); // NOI18N
        lblBuscarResponsable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarResponsable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBuscarResponsable1MouseEntered(evt);
            }
        });

        jlblDescripción.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblDescripción.setText("Descripción");

        jtxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDescripcionActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(82, 183, 136));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnGuardar.setText("Nuevo ");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarEquipo.setBackground(new java.awt.Color(0, 102, 204));
        btnGuardarEquipo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnGuardarEquipo.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarEquipo.setText("Agregar Equipos");
        btnGuardarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEquipoActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(82, 183, 136));
        btnLimpiar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnLimpiar.setText("Finalizar ");
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
                        .addGap(22, 22, 22)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblCarnet1)
                                .addGap(28, 28, 28)
                                .addComponent(jtxtCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblEstado)
                                .addGap(60, 60, 60)
                                .addComponent(jtxtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblBuscarResponsable2))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jlabelTitle))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(lblArt)
                                .addGap(33, 33, 33)
                                .addComponent(jtxtNumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblBuscarResponsable1))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow1Layout.createSequentialGroup()
                                    .addComponent(jlblcedula)
                                    .addGap(40, 40, 40)
                                    .addComponent(jtxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(lblBuscarResponsable))
                                .addComponent(jlabelTitle1))
                            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow1Layout.createSequentialGroup()
                                    .addComponent(jlblTeléfono)
                                    .addGap(68, 68, 68)
                                    .addComponent(jcmbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow1Layout.createSequentialGroup()
                                    .addComponent(jlblNombres)
                                    .addGap(93, 93, 93)
                                    .addComponent(jcmbFacultad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow1Layout.createSequentialGroup()
                                    .addComponent(jlblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(jcmbRencinto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jlabelTitle2))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarResponsable)
                    .addComponent(jtxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarResponsable2)
                    .addComponent(jtxtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(btnDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jlabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbRencinto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblTeléfono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jlabelTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarResponsable1))
                .addGap(8, 8, 8)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
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

        jtxtNumInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNumInventarioKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(64, 122, 237));

        pagination1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlabelTitle3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle3.setText("Número de inventario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlabelTitle3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNumInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNumInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelTitle3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jtxtCarnet1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCarnet1KeyTyped

    }//GEN-LAST:event_jtxtCarnet1KeyTyped

    private void lblBuscarResponsableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarResponsableMouseClicked
        try {

            String val = JOptionPane.showInputDialog(this, "Ingrese el número"
                    + "de inss", "Responsable", JOptionPane.INFORMATION_MESSAGE);
            noInssRes = Integer.parseInt(val);
            Responsable p = Ctr_Responsable.leerRegistro(noInssRes);

            if (p != null) {
                this.jtxtResponsable.setText(p.getNombres().concat(" ").concat(p.getApellidos()));
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(this, "No Exite el registro con el número "
                        + "de inss: "
                        + String.valueOf(Integer.toString(noInssRes)), "Responsable", JOptionPane.ERROR_MESSAGE);
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

    private void jtxtResponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtResponsableKeyTyped

    }//GEN-LAST:event_jtxtResponsableKeyTyped

    private void jtxtCarnetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCarnetKeyTyped

    }//GEN-LAST:event_jtxtCarnetKeyTyped

    private void lblBuscarResponsable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarResponsable2MouseClicked
        try {

            String val = JOptionPane.showInputDialog(this, "Ingrese el número"
                    + "de inss", "Responsable", JOptionPane.INFORMATION_MESSAGE);
            noInssCus = Integer.parseInt(val);
            Custodio p = CTr_Custodio.leerRegistro(noInssCus);

            if (p != null) {
                this.jtxtCarnet.setText(p.getNombres().concat(" ").concat(p.getApellidos()));
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(this, "No Exite el registro con el número "
                        + "de inss: "
                        + String.valueOf(Integer.toString(noInssCus)), "Custodio", JOptionPane.ERROR_MESSAGE);;
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
    }//GEN-LAST:event_lblBuscarResponsable2MouseClicked

    private void lblBuscarResponsable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarResponsable2MouseEntered

    }//GEN-LAST:event_lblBuscarResponsable2MouseEntered

    private void btnDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDate2ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_btnDate2ActionPerformed

    private void txtDateEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateEntradaActionPerformed

    }//GEN-LAST:event_txtDateEntradaActionPerformed

    private void jcmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbDepartamentoActionPerformed

    }//GEN-LAST:event_jcmbDepartamentoActionPerformed

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

    private void lblBuscarResponsable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarResponsable1MouseClicked

        try {

            String val = JOptionPane.showInputDialog(this, "Ingrese el número "
                    + "de articulo.", "Equipo tecnologico", JOptionPane.INFORMATION_MESSAGE);
            int numArt = Integer.parseInt(val);
            EquipoTecnologico p = CTr_EquipoTecnologico.leerRegistro(numArt);

            if (p != null) {
                this.jtxtNumArt.setText(Integer.toString(p.getNumeroArticulo()));
                this.jtxtDescripcion.setText(p.getDescripcion());

            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(null, "No Exite el registro con el numero "
                        + "de aritculo: "
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
    }//GEN-LAST:event_lblBuscarResponsable1MouseClicked

    private void lblBuscarResponsable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarResponsable1MouseEntered

    }//GEN-LAST:event_lblBuscarResponsable1MouseEntered

    private void jtxtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDescripcionActionPerformed

    }//GEN-LAST:event_jtxtDescripcionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.Validacion()) {
            try {
                int Inventario = Integer.parseInt(this.jtxtCarnet1.getText()) + 1;
                int rst = CTr_Inventario.agregar(Inventario,
                        noInssRes,
                        noInssCus,
                        this.txtDateEntrada.getText());

                int rst2 = CTr_DetalleInvEqTecnologico.agregar(CTr_DetalleInvEqTecnologico.buscarIDEquipo(Integer.parseInt(this.jtxtNumArt.getText())),
                        CTr_DetalleInvEqTecnologico.buscarIDInventario(Inventario));
                if (rst > 0 && rst2 > 0) {

                    JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                            "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Registro no grabado, ya existe",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                this.btnGuardarEquipo.setVisible(true);
                this.btnLimpiar.setVisible(true);
                this.btnGuardar.setVisible(false);
                this.jtxtResponsable.setEnabled(false);
                this.jtxtCarnet.setEnabled(false);
                this.jcmbDepartamento.setEnabled(false);
                this.jcmbFacultad.setEnabled(false);
                this.jcmbRencinto.setEnabled(false);
                this.txtDateEntrada.setEnabled(false);
                this.getNoInventario();
                this.cargarTabla(1);
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

    private void btnGuardarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEquipoActionPerformed
        if (this.ValidacionActualizar()) {
            try {
                int rst = CTr_DetalleInvEqTecnologico.agregar(CTr_DetalleInvEqTecnologico.buscarIDEquipo(Integer.parseInt(this.jtxtNumArt.getText())),
                        CTr_DetalleInvEqTecnologico.buscarIDInventario(Integer.parseInt(this.jtxtCarnet1.getText())));
                if (rst > 0) {

                    JOptionPane.showMessageDialog(this, "Equipo tecnologico inventariado con éxito",
                            "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Error",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                this.btnGuardarEquipo.setVisible(true);
                this.btnGuardar.setVisible(false);
                this.cargarTabla(1);
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
            JOptionPane.showMessageDialog(this, "El numero de articulo esta vacio",
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarEquipoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        try {
            this.getNoInventario();
            this.btnGuardarEquipo.setVisible(false);
            this.btnLimpiar.setVisible(false);
            this.btnGuardar.setVisible(true);
            this.jcmbDepartamento.setEnabled(true);
            this.jcmbFacultad.setEnabled(true);
            this.jcmbRencinto.setEnabled(true);
            this.jtxtResponsable.setEnabled(true);
            this.jtxtCarnet.setEnabled(true);
            this.txtDateEntrada.setEnabled(true);
            this.jtxtCarnet.setText("");
            this.jtxtResponsable.setText("");
            this.jtxtNumArt.setText("");
            this.jtxtDescripcion.setText("");
            this.jcmbFacultad.setSelectedIndex(1);
            this.jcmbRencinto.setSelectedIndex(1);
            this.jcmbDepartamento.setSelectedIndex(1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                    + "el manejo de la solicitud \n en recurso de Base de Datos"
                    + ex.getMessage(),
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseClicked

        try {

            int Fila = jTableData.getSelectedRow();
            int numInventario = (int) jTableData.getValueAt(Fila, 0);
            Inventario p = CTr_Inventario.leerRegistro(numInventario);

            if (p != null) {
                jtxtCarnet1.setText(Integer.toString(p.getNumInventario()));
                jtxtResponsable.setText(p.getResponsable());
                txtDateEntrada.setText(p.getFechaIngreso());
                jtxtCarnet.setText(p.getCustodio());
                jcmbFacultad.setSelectedIndex(1);
                jcmbRencinto.setSelectedIndex(1);
                jcmbDepartamento.setSelectedIndex(1);
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(null, "No Exite el registro con el numero "
                        + "de carnet: "
                        + String.valueOf(Integer.parseInt(this.jtxtCarnet.getText())));
            }
            this.btnGuardarEquipo.setVisible(true);
            this.btnLimpiar.setVisible(true);
            this.btnGuardar.setVisible(false);
            this.jtxtResponsable.setEnabled(false);
            this.jtxtCarnet.setEnabled(false);
            this.jcmbDepartamento.setEnabled(false);
            this.jcmbFacultad.setEnabled(false);
            this.jcmbRencinto.setEnabled(false);
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

    private void jtxtNumInventarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNumInventarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

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
            this.jtxtNumInventario.setText(null);

        }
    }//GEN-LAST:event_jtxtNumInventarioKeyPressed

    private void getNoInventario() throws SQLException {
        try {
            int count = CTr_Inventario.getNoInventario();
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

    private void cargarComboBox() throws SQLException {
        try {

            CTr_Inventario Service = new CTr_Inventario();
            List<String> facultades = Service.obtenerFacultad();
            List<String> departamentos = Service.obtenerDepartamento();
            List<String> recintos = Service.obtenerRecinto();
            jcmbFacultad.addItem("Selecionar");
            jcmbRencinto.addItem("Selecionar");
            jcmbDepartamento.addItem("Selecionar");
            for (String facultad : facultades) {
                jcmbFacultad.addItem(facultad);
            }
            for (String recinto : recintos) {
                jcmbRencinto.addItem(recinto);

            }
            for (String departamento : departamentos) {
                jcmbDepartamento.addItem(departamento);
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
        // Diseño de la tabla
        jTableData.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTableData.getTableHeader().setOpaque(false);
        jTableData.getTableHeader().setBackground(new Color(32, 136, 203));
        jTableData.getTableHeader().setForeground(new Color(255, 255, 255));

        // Crea el modelo de tabla y configura las columnas
        DefaultTableModel modelo = new DefaultTableModel();
        jTableData.setModel(modelo);

        if (jtxtNumInventario.getText().isEmpty()) {
            modelo.addColumn("N° Inventario");
            modelo.addColumn("Total de equipos");
            modelo.addColumn("Fecha Ingreso");

            CTr_Inventario obb = new CTr_Inventario();
            filasResultantes = obb.CantEquipoInventario();
        } else if (jtxtNumInventario.getText() != null) {
            modelo.addColumn("N° Inventario");
            modelo.addColumn("N° de articulo");
            modelo.addColumn("Descripción");
            modelo.addColumn("Estado");
            modelo.addColumn("Fecha Ingreso");

            CTr_Inventario obb = new CTr_Inventario();
            filasResultantes = obb.obtenerDatosEquipoTecnologicosInv(Integer.parseInt(jtxtNumInventario.getText()));
        }

        totalFilas = filasResultantes.length;
        totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
        int filaInicial = (page - 1) * filasPorPagina;
        int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);

        for (int i = filaInicial; i < filaFinal; i++) {
            modelo.addRow((Object[]) filasResultantes[i]);
        }

        // Llenado
        packColumns(jTableData, 6);
        // Obtener celda en la posición (0, 0)
        Rectangle rect = jTableData.getCellRect(0, 0, true);
        jTableData.scrollRectToVisible(rect);

        // Mostrar las filas correspondientes a la página actual
        mostrarFilasPaginaActual(page);
        pagination1.setPagegination(page, totalPaginas);
    }

    private void mostrarFilasPaginaActual(int page) {
        // Limpiar el modelo de tabla
        DefaultTableModel modelo = (DefaultTableModel) jTableData.getModel();
        modelo.setRowCount(0);

        // Calcular las filas inicial y final de la página actual
        int filaInicial = (page - 1) * filasPorPagina;
        int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);

        // Verificar que el número de filas resultantes sea válido
        if (filasResultantes != null && filaInicial >= 0 && filaInicial < filasResultantes.length && filaFinal <= filasResultantes.length) {
            // Agregar las filas correspondientes a la página actual al modelo de tabla
            for (int i = filaInicial; i < filaFinal; i++) {
                modelo.addRow((Object[]) filasResultantes[i]);
            }
        }

        // Actualizar la visualización de la tabla
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

        if (jtxtNumArt.getText().isEmpty()) {

            return false; // si entra alguna condicion devuelve inmediatamente el valor de false
        } else if (jtxtResponsable.getText().isEmpty()) {

            return false;

        } else if (jtxtCarnet.getText().isEmpty()) {

            return false;
        } else if (jtxtDescripcion.getText().isEmpty()) {

            return false;
        } else if (jcmbFacultad.getSelectedItem().equals("Seleccionar")) {

            return false;
        } else if (jtxtNumArt.getText().isEmpty()) {

            return false;
        }
        return valido;
    }

    public boolean ValidacionActualizar() {

        boolean valido = true;

        if (jtxtNumArt.getText().isEmpty()) {

            return false;
        }
        return valido;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDate2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarEquipo;
    private javax.swing.JButton btnLimpiar;
    private Components.datechooser.DateChooser dateChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableData;
    private javax.swing.JComboBox<String> jcmbDepartamento;
    private javax.swing.JComboBox<String> jcmbFacultad;
    private javax.swing.JComboBox<String> jcmbRencinto;
    private javax.swing.JLabel jlabelTitle;
    private javax.swing.JLabel jlabelTitle1;
    private javax.swing.JLabel jlabelTitle2;
    private javax.swing.JLabel jlabelTitle3;
    private javax.swing.JLabel jlblApellidos;
    private javax.swing.JLabel jlblCarnet1;
    private javax.swing.JLabel jlblDescripción;
    private javax.swing.JLabel jlblEstado;
    private javax.swing.JLabel jlblNombres;
    private javax.swing.JLabel jlblTeléfono;
    private javax.swing.JLabel jlblcedula;
    private javax.swing.JTextField jtxtCarnet;
    private javax.swing.JTextField jtxtCarnet1;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtNumArt;
    private javax.swing.JTextField jtxtNumInventario;
    private javax.swing.JTextField jtxtResponsable;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblBuscarResponsable;
    private javax.swing.JLabel lblBuscarResponsable1;
    private javax.swing.JLabel lblBuscarResponsable2;
    private pagination.Pagination pagination1;
    private Components.PanelShadow panelShadow1;
    private javax.swing.JTextField txtDateEntrada;
    // End of variables declaration//GEN-END:variables
}
