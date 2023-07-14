/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import Components.event.EventMenu;
import controlador.CTr_EquipoTecnologico;
import controlador.CTr_Inventario;
import controlador.CTr_Movimientos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import pagination.EventPagination;
import pagination.style.PaginationItemRenderStyle1;

/**
 *
 * @author David
 */
public final class Home extends javax.swing.JFrame {

    Color panedefault;
    Color paneClick;
    private int totalFilas; // variable para almacenar el total de filas obtenidas
    private int filasPorPagina = 10; // Número de filas a mostrar por página
    private int totalPaginas; // Variable para almacenar el total de páginas
    private Object[] filasResultantes;

    public Home() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.ColoresPaneles();
        this.FechaHoy();
        gaugeChart1.setValueWithAnimation((int) CTr_EquipoTecnologico.porcentajeEquiposBuenos());
        // Es el total de equipos manejados desde base de datos pero el metodo esta la clase de equipo tecnologico
        gaugeChart2.setValueWithAnimation((int) CTr_EquipoTecnologico.porcentajeEquiposMalos());

        // Paginacion
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
        this.cargarTabla(1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSesion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlblConectado = new javax.swing.JLabel();
        jlblIcon = new javax.swing.JLabel();
        lblInformacion1 = new javax.swing.JLabel();
        lblCerrarSesion1 = new javax.swing.JLabel();
        bg = new Components.menu.Menu();
        contraldorInicio = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jlblFecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        contenedor = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new Components.PanelShadow();
        txtBuscar = new javax.swing.JTextField();
        pagination1 = new pagination.Pagination();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        cmbFiltro = new javax.swing.JComboBox<>();
        jlabelTitle2 = new javax.swing.JLabel();
        gaugeChart1 = new Components.chart.GaugeChart();
        gaugeChart2 = new Components.chart.GaugeChart();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelSesion.setBackground(new java.awt.Color(0, 56, 140));
        panelSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        panelSesion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 73));

        jlblSesion.setBackground(new java.awt.Color(255, 255, 255));
        jlblSesion.setForeground(new java.awt.Color(255, 255, 255));
        jlblSesion.setText("Santiago Ríos");
        panelSesion.add(jlblSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 90, -1));

        jlblConectado.setForeground(new java.awt.Color(0, 255, 0));
        jlblConectado.setText("Conectado");
        panelSesion.add(jlblConectado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 60, -1));

        jlblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/elipse.png"))); // NOI18N
        panelSesion.add(jlblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        lblInformacion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/informacion.png"))); // NOI18N
        lblInformacion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInformacion1MouseClicked(evt);
            }
        });
        panelSesion.add(lblInformacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, -1, -1));

        lblCerrarSesion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cerrar-sesion (1).png"))); // NOI18N
        lblCerrarSesion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesion1MouseClicked(evt);
            }
        });
        panelSesion.add(lblCerrarSesion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, -1, -1));
        panelSesion.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 90, 210, 520));

        contraldorInicio.setBackground(new java.awt.Color(0, 56, 140));

        jLblRol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLblRol.setForeground(new java.awt.Color(255, 255, 255));
        jLblRol.setText("Responsable");
        jLblRol.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLblRolFocusGained(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha:");

        jlblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlblFecha.setForeground(new java.awt.Color(255, 255, 255));
        jlblFecha.setText("Fecha");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Logo-Inventory.png"))); // NOI18N

        javax.swing.GroupLayout contraldorInicioLayout = new javax.swing.GroupLayout(contraldorInicio);
        contraldorInicio.setLayout(contraldorInicioLayout);
        contraldorInicioLayout.setHorizontalGroup(
            contraldorInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contraldorInicioLayout.createSequentialGroup()
                .addContainerGap(394, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                .addGroup(contraldorInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contraldorInicioLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contraldorInicioLayout.createSequentialGroup()
                        .addComponent(jLblRol)
                        .addGap(16, 16, 16))))
        );
        contraldorInicioLayout.setVerticalGroup(
            contraldorInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contraldorInicioLayout.createSequentialGroup()
                .addGroup(contraldorInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contraldorInicioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contraldorInicioLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLblRol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contraldorInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jlblFecha))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        pagination1.setOpaque(false);

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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableDataMouseEntered(evt);
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

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Inventario de equipos tecnológicos", "Inventario de equipos mobiliarios", "Movimientos de equipos tecnológicos", "Movimientos de equipos mobiliarios" }));
        cmbFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFiltroItemStateChanged(evt);
            }
        });

        jlabelTitle2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle2.setText("EQUIPO");

        gaugeChart1.setColor2(new java.awt.Color(51, 102, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(97, 97, 97));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TOTAL DE EQUIPOS BUENOS");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(97, 97, 97));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TOTAL DE EQUIPOS MALOS");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelShadow1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(gaugeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(gaugeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                .addGap(38, 38, 38)
                                .addComponent(jlabelTitle2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelShadow1Layout.createSequentialGroup()
                                    .addComponent(jlabelTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(1, 1, 1))
                                .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gaugeChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gaugeChart2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contenedor.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(contenedor))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(contraldorInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contraldorInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(contenedor))
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
        }
        if (this.jLblRol.getText().equals("Instructor")) {
            bg.initMenuIns(eventMenu());
        } else {
            bg.initMenu(eventMenu());
        }

    }//GEN-LAST:event_formWindowOpened

    private void jLblRolFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLblRolFocusGained

    }//GEN-LAST:event_jLblRolFocusGained

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
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
            this.txtBuscar.setText(null);

        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseClicked

    }//GEN-LAST:event_jTableDataMouseClicked

    private void jTableDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableDataMouseEntered

    private void cmbFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFiltroItemStateChanged
        try {
            this.cargarTabla(1);
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
    }//GEN-LAST:event_cmbFiltroItemStateChanged

    private void lblCerrarSesion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesion1MouseClicked
        jfrmLogin obb = new jfrmLogin();
        obb.setVisible(true);
        obb.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.dispose();

    }//GEN-LAST:event_lblCerrarSesion1MouseClicked

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    private void lblInformacion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInformacion1MouseClicked
        JOptionPane.showMessageDialog(this, "¡La gestión del inventario es una danza constante entre"
                + " la optimización de los recursos y la anticipación "
                + "de las necesidades futuras, manteniendo el equilibrio en un mundo en constante cambio.!",
                "Inventory", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_lblInformacion1MouseClicked

    private void FechaHoy() {
        LocalDate fechaActual = LocalDate.now();
        // formato de fecha
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String FechaIngreso = formato.format(fechaActual);
        this.jlblFecha.setText(FechaIngreso);
    }

    private void ColoresPaneles() {

        panedefault = new Color(0, 56, 140);
        this.paneClick = new Color(242, 242, 242);

    }

    int x, y;

    public void BotonEQuipoMobiliario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        contenedor.removeAll();
        contenedor.repaint();
        jframeEquipoMobiliario obb;
        try {
            obb = new jframeEquipoMobiliario();
            this.contenedor.add(obb).setVisible(true);
            obb.setMaximum(true);

        } catch (PropertyVetoException ex) {
            System.out.println(ex.toString());
        }

    }

    private void cargarTabla(int page) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // Diseño de la tabla
        jTableData.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTableData.getTableHeader().setOpaque(false);
        jTableData.getTableHeader().setBackground(new Color(32, 136, 203));
        jTableData.getTableHeader().setForeground(new Color(255, 255, 255));

        DefaultTableModel modelo = new DefaultTableModel();

        Object selectedItem = cmbFiltro.getSelectedItem();
        // data
        if (selectedItem != null) {
            switch (selectedItem.toString()) {
                case "Inventario de equipos tecnológicos" -> {
                    if (txtBuscar.getText().isEmpty()) {
                        modelo.addColumn("N° Inventario");
                        modelo.addColumn("Total de equipos");
                        modelo.addColumn("Fecha de Ingreso");

                        CTr_Inventario obb = new CTr_Inventario();
                        filasResultantes = obb.CantEquipoInventario();
                    } else if (txtBuscar.getText() != null) {
                        modelo.addColumn("N° Inventario");
                        modelo.addColumn("N° de articulo");
                        modelo.addColumn("Descripción");
                        modelo.addColumn("Estado");
                        modelo.addColumn("Fecha de Ingreso");

                        CTr_Inventario obb = new CTr_Inventario();
                        filasResultantes = obb.obtenerDatosEquipoTecnologicosInv(Integer.parseInt(txtBuscar.getText()));
                    }
                    totalFilas = filasResultantes.length;
                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                    int filaInicial = (page - 1) * filasPorPagina;
                    int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);
                    for (int i = filaInicial; i < filaFinal; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }

                case "Inventario de equipos mobiliarios" -> {
                    if (txtBuscar.getText().isEmpty()) {
                        modelo.addColumn("N° Inventario");
                        modelo.addColumn("Total de equipos");
                        modelo.addColumn("Fecha de Ingreso");

                        CTr_Inventario obb = new CTr_Inventario();
                        filasResultantes = obb.CantEquipoMobInventario();
                    } else if (txtBuscar.getText() != null) {
                        modelo.addColumn("N° Inventario");
                        modelo.addColumn("N° de articulo");
                        modelo.addColumn("Descripción");
                        modelo.addColumn("Estado");
                        modelo.addColumn("Fecha Ingreso");

                        CTr_Inventario obb = new CTr_Inventario();
                        filasResultantes = obb.obtenerDatosEquipoMobiliarioInv(Integer.parseInt(txtBuscar.getText()));
                    }
                    //paginacion
                    totalFilas = filasResultantes.length;
                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                    int filaInicial = (page - 1) * filasPorPagina;
                    int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);
                    for (int i = filaInicial; i < filaFinal; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }

                case "Movimientos de equipos tecnológicos" -> {
                    if (txtBuscar.getText().isEmpty()) {
                        modelo.setColumnIdentifiers(new String[]{
                            "N° de Movimiento",
                            "N° de articulo",
                            "Descripción",
                            "Fecha",
                            "Movimiento",
                            "Locacion Nueva",
                            "Laboratorio"
                        });

                        CTr_Movimientos obb = new CTr_Movimientos();
                        filasResultantes = obb.ListarMovimientosTec();
                    } else if (txtBuscar.getText() != null) {
                        modelo.setColumnIdentifiers(new String[]{
                            "N° de Movimiento",
                            "N° de articulo",
                            "Descripción",
                            "Movimiento",
                            "Fecha",
                            "Locacion actual",
                            "Laboratorio"
                        });

                        CTr_Movimientos obb = new CTr_Movimientos();
                        filasResultantes = obb.ListarMovimientosEquipoTec(Integer.parseInt(txtBuscar.getText()));
                    }
                    totalFilas = filasResultantes.length;
                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                    int filaInicial = (page - 1) * filasPorPagina;
                    int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);
                    for (int i = filaInicial; i < filaFinal; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }

                case "Movimientos de equipos mobiliarios" -> {
                    if (txtBuscar.getText().isEmpty()) {
                        modelo.setColumnIdentifiers(new String[]{
                            "N° de Movimiento",
                            "N° de articulo",
                            "Descripción",
                            "Fecha",
                            "Movimiento",
                            "Locacion Nueva",
                            "Laboratorio"
                        });

                        CTr_Movimientos obb = new CTr_Movimientos();
                        filasResultantes = obb.ListarMovimientosMob();
                    } else if (txtBuscar.getText() != null) {
                        modelo.setColumnIdentifiers(new String[]{
                            "N° de Movimiento",
                            "N° de articulo",
                            "Descripción",
                            "Fecha",
                            "Movimiento",
                            "Locacion actual",
                            "Laboratorio"
                        });

                        CTr_Movimientos obb = new CTr_Movimientos();
                        filasResultantes = obb.ListarMovimientosEquipoMob(Integer.parseInt(txtBuscar.getText()));
                    }
                    totalFilas = filasResultantes.length;
                    totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
                    int filaInicial = (page - 1) * filasPorPagina;
                    int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);
                    for (int i = filaInicial; i < filaFinal; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }
                case "Seleccionar" -> {
                    modelo.addColumn("N° Inventario");
                    modelo.addColumn("Total de equipos");
                    modelo.addColumn("Fecha Ingreso");

                    CTr_Inventario obb = new CTr_Inventario();
                    filasResultantes = obb.InventarioAll();
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
        // autosizwe
        jTableData.setModel(modelo);
        packColumns(jTableData, modelo.getColumnCount());

        Rectangle rect = jTableData.getCellRect(0, 0, true);
        jTableData.scrollRectToVisible(rect);

        mostrarFilasPaginaActual(page);
        pagination1.setPagegination(page, totalPaginas);
    }

    private void mostrarFilasPaginaActual(int page) {
        // limpiar el modelo de tabla
        DefaultTableModel modelo = (DefaultTableModel) jTableData.getModel();
        modelo.setRowCount(0);

        // calcular las filas inicial y final de la pagina actual
        int filaInicial = (page - 1) * filasPorPagina;
        int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);

        // Verificar que el numero de filas resultantes sea valido
        if (filasResultantes != null && filaInicial >= 0 && filaInicial < filasResultantes.length && filaFinal <= filasResultantes.length) {
            // agregar las filas correspondientes a la pagina actual al modelo de tabla
            for (int i = filaInicial; i < filaFinal; i++) {
                modelo.addRow((Object[]) filasResultantes[i]);
            }
        }

        // actualizar la visualizacion de la tabla
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
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Home().setVisible(true);
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

    // mandar acciones a los botones
    private EventMenu eventMenu() {
        EventMenu eventMenu = (int index) -> {
            switch (index) {
                case 0 -> {
                    try {
                        contenedor.removeAll();
                        contenedor.repaint();
                        contenedor.add(this.jPanel1);
                        contenedor.validate();
                        contenedor.repaint();
                        gaugeChart1.setValueWithAnimation((int) CTr_EquipoTecnologico.porcentajeEquiposBuenos());
                        gaugeChart2.setValueWithAnimation((int) CTr_EquipoTecnologico.porcentajeEquiposMalos());
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
                }

                case 1 -> {
                    try {
                        BotonEquipo equipo = new BotonEquipo();
                        contenedor.removeAll();
                        contenedor.repaint();
                        try {
                            this.contenedor.add(equipo).setVisible(true);
                            equipo.setMaximum(true);
                            equipo.setMaximum(true);

                        } catch (PropertyVetoException ex) {
                            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                                    + "ha sido vetado",
                                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
                        }
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
                    } catch (IOException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 2 -> {
                    contenedor.removeAll();
                    contenedor.repaint();
                    try {
                        BotonInventario obb = new BotonInventario();
                        this.contenedor.add(obb).setVisible(true);
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
                }
                case 3 -> {
                    contenedor.removeAll();
                    contenedor.repaint();
                    BotonesPersonal obb;
                    try {
                        try {
                            obb = new BotonesPersonal();
                            this.contenedor.add(obb).setVisible(true);

                            if ("Custodio".equals(this.jLblRol.getText())) {
                                obb.pnlResponsable.setVisible(false);
                                obb.pnlCustodio.setVisible(false);

                            }
                            obb.setMaximum(true);
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

                    } catch (PropertyVetoException ex) {
                        JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                                + "ha sido vetado",
                                "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 4 -> {
                    contenedor.removeAll();
                    contenedor.repaint();
                    BotonesMovimientos obb;
                    try {
                        obb = new BotonesMovimientos();
                        this.contenedor.add(obb).setVisible(true);
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
                }
                case 5 -> {
                    contenedor.removeAll();
                    contenedor.repaint();
                    jFrameReporte obb;
                    try {
                        obb = new jFrameReporte();
                        this.contenedor.add(obb).setVisible(true);
                        obb.setMaximum(true);

                    } catch (PropertyVetoException ex) {
                        JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                                + "ha sido vetado",
                                "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
                    }
                }
                case 6 -> {
                    contenedor.removeAll();
                    contenedor.repaint();
                    try {
                        jframeVerifcarEquipos obb = new jframeVerifcarEquipos();
                        this.contenedor.add(obb).setVisible(true);
                        obb.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                                + "ha sido vetado",
                                "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
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
                }
                case 7 -> {
                    contenedor.removeAll();
                    contenedor.repaint();
                    try {
                        JFrameLaboratorios obb = new JFrameLaboratorios();
                        this.contenedor.add(obb).setVisible(true);
                        obb.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                                + "ha sido vetado",
                                "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
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
                }

            }
        };
        return eventMenu;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.menu.Menu bg;
    private javax.swing.JComboBox<String> cmbFiltro;
    protected javax.swing.JDesktopPane contenedor;
    private javax.swing.JPanel contraldorInicio;
    private Components.chart.GaugeChart gaugeChart1;
    private Components.chart.GaugeChart gaugeChart2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static final javax.swing.JLabel jLblRol = new javax.swing.JLabel();
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableData;
    private javax.swing.JLabel jlabelTitle2;
    private javax.swing.JLabel jlblConectado;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblIcon;
    public static final javax.swing.JLabel jlblSesion = new javax.swing.JLabel();
    private javax.swing.JLabel lblCerrarSesion1;
    private javax.swing.JLabel lblInformacion1;
    private pagination.Pagination pagination1;
    private javax.swing.JPanel panelSesion;
    private Components.PanelShadow panelShadow1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
