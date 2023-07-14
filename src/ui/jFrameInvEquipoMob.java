/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import controlador.CTr_Custodio;
import controlador.CTr_DetalleInvEqMobiliario;
import controlador.CTr_DetalleInvEqTecnologico;
import controlador.CTr_EquipoMobiliario;
import controlador.CTr_Inventario;
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
import negocio.Custodio;
import negocio.EquipoMobiliario;
import negocio.Inventario;
import negocio.Responsable;
import pagination.EventPagination;
import pagination.style.PaginationItemRenderStyle1;

/**
 *
 * @author David
 */
public class jFrameInvEquipoMob extends javax.swing.JInternalFrame {

    int noInssRes = 0;
    int noInssCus = 0;

    private int totalFilas;
    private int filasPorPagina = 10;
    private int totalPaginas;
    private Object[] filasResultantes;

    public jFrameInvEquipoMob() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        initComponents();

        this.setMaximizable(true);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        btnGuardarEquipo.setVisible(false);
        btnLimpiar.setVisible(false);

        getNoInventario();
        cargarComboBox();

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
        txtDateEntrada = new javax.swing.JTextField();
        btnDate2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jlblEstado = new javax.swing.JLabel();
        jtxtCustodio = new javax.swing.JTextField();
        lblBuscarCustodio = new javax.swing.JLabel();
        lblBuscarResponsable = new javax.swing.JLabel();
        jtxtResponsable = new javax.swing.JTextField();
        jlblcedula = new javax.swing.JLabel();
        jlblCarnet1 = new javax.swing.JLabel();
        jtxtCarnet1 = new javax.swing.JTextField();
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
        jtxtNumInventario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        pagination1 = new pagination.Pagination();
        jlabelTitle3 = new javax.swing.JLabel();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txtDateEntrada);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jlabelTitle1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jlabelTitle1.setText("INVENTARIO DE EQUIPOS MOBILIARIOS");

        jlabelTitle.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle.setText("UBICACIÓN ");

        jlabelTitle2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle2.setText("EQUIPO");

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

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel3.setText("Fecha de ingreso");

        jlblEstado.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblEstado.setText("Custodio");

        jtxtCustodio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCustodioKeyTyped(evt);
            }
        });

        lblBuscarCustodio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscando.png"))); // NOI18N
        lblBuscarCustodio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarCustodioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBuscarCustodioMouseEntered(evt);
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

        jlblCarnet1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblCarnet1.setText("Número de inventario");

        jtxtCarnet1.setEnabled(false);
        jtxtCarnet1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCarnet1KeyTyped(evt);
            }
        });

        jlblNombres.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblNombres.setText("Facultad");

        jlblApellidos.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblApellidos.setText("Recinto Universitario\t\t\t ");

        jlblTeléfono.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblTeléfono.setText("Dependencia");

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
        btnGuardar.setText("Nuevo");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarEquipo.setBackground(new java.awt.Color(0, 102, 255));
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
        btnLimpiar.setText("Finalizar");
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
                        .addGap(48, 48, 48)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblCarnet1)
                                .addGap(28, 28, 28)
                                .addComponent(jtxtCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblcedula)
                                .addGap(40, 40, 40)
                                .addComponent(jtxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblBuscarResponsable))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlabelTitle1)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jlabelTitle))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblNombres)
                                .addGap(93, 93, 93)
                                .addComponent(jcmbFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jcmbRencinto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblTeléfono)
                                .addGap(68, 68, 68)
                                .addComponent(jcmbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblEstado)
                                .addGap(60, 60, 60)
                                .addComponent(jtxtCustodio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblBuscarCustodio))))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jlabelTitle2))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(lblArt)
                                .addGap(3, 3, 3)
                                .addComponent(jtxtNumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblBuscarResponsable1))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelShadow1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnGuardarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(10, 10, 10)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCarnet1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarResponsable))
                .addGap(8, 8, 8)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCustodio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarCustodio))
                .addGap(8, 8, 8)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3))
                    .addComponent(txtDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jlabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbRencinto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblTeléfono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jcmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jtxtNumInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNumInventarioKeyPressed(evt);
            }
        });

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

        jlabelTitle3.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle3.setText("Número de inventario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlabelTitle3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNumInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNumInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelTitle3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void txtDateEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateEntradaActionPerformed

    }//GEN-LAST:event_txtDateEntradaActionPerformed

    private void btnDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDate2ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_btnDate2ActionPerformed

    private void jtxtCustodioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCustodioKeyTyped

    }//GEN-LAST:event_jtxtCustodioKeyTyped

    private void lblBuscarCustodioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarCustodioMouseClicked
        try {

            String val = JOptionPane.showInputDialog(this, "Ingrese el número"
                    + "de inss", "Responsable", JOptionPane.ERROR_MESSAGE);
            noInssCus = Integer.parseInt(val);
            Custodio p = CTr_Custodio.leerRegistro(noInssCus);

            if (p != null) {
                this.jtxtCustodio.setText(p.getNombres().concat(" ").concat(p.getApellidos()));
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
    }//GEN-LAST:event_lblBuscarCustodioMouseClicked

    private void lblBuscarCustodioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarCustodioMouseEntered

    }//GEN-LAST:event_lblBuscarCustodioMouseEntered

    private void lblBuscarResponsableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarResponsableMouseClicked
        try {

            String val = JOptionPane.showInputDialog(this, "Ingrese el número"
                    + "de inss", "Responsable", JOptionPane.ERROR_MESSAGE);
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

    private void jtxtCarnet1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCarnet1KeyTyped

    }//GEN-LAST:event_jtxtCarnet1KeyTyped

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
            EquipoMobiliario p = CTr_EquipoMobiliario.leerRegistro(numArt);

            if (p != null) {
                this.jtxtNumArt.setText(Integer.toString(p.getNumeroArticulo()));
                this.jtxtDescripcion.setText(p.getDescripcion());

            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(this, "No Exite el registro con el número "
                        + "de articulo: "
                        + String.valueOf(Integer.toString(numArt)), "Equipo", JOptionPane.ERROR_MESSAGE);

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
        // TODO add your handling code here:
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

                int rst2 = CTr_DetalleInvEqMobiliario.agregar(
                        CTr_DetalleInvEqMobiliario.buscarIDEquipo(Integer.parseInt(this.jtxtNumArt.getText())), CTr_DetalleInvEqMobiliario.buscarIDInventario(Inventario));
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
                this.jtxtCustodio.setEnabled(false);
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
                int rst = CTr_DetalleInvEqMobiliario.agregar(
                        CTr_DetalleInvEqMobiliario.buscarIDEquipo(Integer.parseInt(this.jtxtNumArt.getText())), CTr_DetalleInvEqTecnologico.buscarIDInventario(Integer.parseInt(this.jtxtCarnet1.getText())));
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
            this.btnGuardar.setVisible(false);
            this.jcmbDepartamento.setEnabled(true);
            this.jcmbFacultad.setEnabled(true);
            this.jcmbRencinto.setEnabled(true);
            this.jtxtResponsable.setEnabled(true);
            this.txtDateEntrada.setEnabled(true);
            this.jtxtCustodio.setEnabled(true);
            this.jtxtCustodio.setText("");
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
                this.txtDateEntrada.setText(p.getFechaIngreso());
                jtxtCustodio.setText(p.getCustodio());
                jcmbFacultad.setSelectedIndex(1);
                jcmbRencinto.setSelectedIndex(1);
                jcmbDepartamento.setSelectedIndex(1);
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(null, "No Exite el registro con el numero "
                        + "de carnet: "
                        + String.valueOf(Integer.parseInt(this.jtxtCustodio.getText())));
            }
            this.btnGuardarEquipo.setVisible(true);
            this.btnLimpiar.setVisible(true);
            this.btnGuardar.setVisible(false);
            this.jtxtResponsable.setEnabled(false);
            this.jtxtCustodio.setEnabled(false);
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
            filasResultantes = obb.CantEquipoMobInventario();
        } else if (jtxtNumInventario.getText() != null) {
            modelo.addColumn("N° Inventario");
            modelo.addColumn("N° de articulo");
            modelo.addColumn("Descripción");
            modelo.addColumn("Estado");
            modelo.addColumn("Fecha Ingreso");

            CTr_Inventario obb = new CTr_Inventario();
            filasResultantes = obb.obtenerDatosEquipoMobiliarioInv(Integer.parseInt(jtxtNumInventario.getText()));
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

        if (jtxtNumArt.getText().isEmpty()) {

            return false; // si entra alguna condicion devuelve inmediatamente el valor de false
        } else if (jtxtResponsable.getText().isEmpty()) {

            return false;

        } else if (jtxtCustodio.getText().isEmpty()) {

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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JTextField jtxtCarnet1;
    private javax.swing.JTextField jtxtCustodio;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtNumArt;
    private javax.swing.JTextField jtxtNumInventario;
    private javax.swing.JTextField jtxtResponsable;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblBuscarCustodio;
    private javax.swing.JLabel lblBuscarResponsable;
    private javax.swing.JLabel lblBuscarResponsable1;
    private pagination.Pagination pagination1;
    private Components.PanelShadow panelShadow1;
    private javax.swing.JTextField txtDateEntrada;
    // End of variables declaration//GEN-END:variables
}
