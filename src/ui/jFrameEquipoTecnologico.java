/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import controlador.CTr_Custodio;
import controlador.CTr_EquipoTecnologico;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import negocio.Custodio;
import negocio.EquipoTecnologico;
import pagination.EventPagination;
import pagination.style.PaginationItemRenderStyle1;

/**
 *
 * @author David
 */
public class jFrameEquipoTecnologico extends javax.swing.JInternalFrame {

    Color Bueno;
    Color Malo;
    private int totalFilas;
    private int filasPorPagina = 10;
    private int totalPaginas;
    private Object[] filasResultantes;

    public jFrameEquipoTecnologico() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, IOException {

        initComponents();
        //Quitar bordes
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        cargarComboBoxEstado();
        cargarComboBoxMarca();

        lblActualizar.setVisible(false);

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

        jPanel1 = new javax.swing.JPanel();
        panelShadow1 = new Components.PanelShadow();
        lblArt = new javax.swing.JLabel();
        jtxtNumArt = new javax.swing.JTextField();
        jlblCant = new javax.swing.JLabel();
        jTxtCantidad = new javax.swing.JTextField();
        jlblEtiqueta = new javax.swing.JLabel();
        jlblEstado = new javax.swing.JLabel();
        jCmbEstado = new javax.swing.JComboBox<>();
        lblCod = new javax.swing.JLabel();
        jlblDescripción = new javax.swing.JLabel();
        jtxtDescripcion = new javax.swing.JTextField();
        jtxtObservacion = new javax.swing.JTextField();
        jlblObservación = new javax.swing.JLabel();
        jlblCosto = new javax.swing.JLabel();
        jTxtCosto = new javax.swing.JTextField();
        jlblMarca = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        jCmbMarca = new javax.swing.JComboBox<>();
        jlblSerie = new javax.swing.JLabel();
        jtxtSerie = new javax.swing.JTextField();
        jlblEstatus = new javax.swing.JLabel();
        jcmbEstatus = new javax.swing.JComboBox<>();
        jlblModelo = new javax.swing.JLabel();
        jtxtModelo = new javax.swing.JTextField();
        jlabelTitle1 = new javax.swing.JLabel();
        lblActualizar = new javax.swing.JLabel();
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
        jtxtEtiqueta = new javax.swing.JTextField();
        jtxtCod = new javax.swing.JTextField();
        pnlPaginar = new javax.swing.JPanel();
        pagination1 = new pagination.Pagination();
        jcmbBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jlabelTitle2 = new javax.swing.JLabel();

        setResizable(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblArt.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblArt.setText("N° Articulo");

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

        lblCod.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblCod.setText("Código");

        jlblDescripción.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblDescripción.setText("Descripción");

        jtxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDescripcionActionPerformed(evt);
            }
        });

        jlblObservación.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblObservación.setText("Observación");

        jlblCosto.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblCosto.setText("Costo");

        jTxtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCostoKeyTyped(evt);
            }
        });

        jlblMarca.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblMarca.setText("Marca");

        btnGuardar1.setBackground(new java.awt.Color(82, 183, 136));
        btnGuardar1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnGuardar1.setText("+");
        btnGuardar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardar1MouseExited(evt);
            }
        });
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        jCmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lenovo", "Dell", " " }));
        jCmbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbMarcaActionPerformed(evt);
            }
        });

        jlblSerie.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblSerie.setText("Serie");

        jlblEstatus.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblEstatus.setText("Estatus");

        jcmbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlblModelo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblModelo.setText("Modelo");

        jlabelTitle1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jlabelTitle1.setText("REGISTRAR EQUIPOS TECNOLÓGICOS");

        lblActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/actualizar-flecha.png"))); // NOI18N
        lblActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblActualizarMouseClicked(evt);
            }
        });

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
        btnGuardar.setText("Guardar");
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
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jlabelTitle1))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jlblSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jtxtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jlblEstatus))
                            .addComponent(jcmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblModelo2)
                                    .addComponent(jlblModelo1))
                                .addGap(142, 142, 142)
                                .addComponent(jlabelTitle))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblModelo)
                                .addGap(18, 18, 18)
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelShadow1Layout.createSequentialGroup()
                                        .addComponent(jtxtInss, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelShadow1Layout.createSequentialGroup()
                                        .addComponent(jtxtNombreCus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLblCus))
                                    .addComponent(jtxtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblDescripción)
                                .addGap(6, 6, 6)
                                .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jTxtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jCmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblActualizar))))
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jtxtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jlblObservación))))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlblEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtCod, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(jtxtEtiqueta)))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(lblArt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtNumArt)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                                .addComponent(jlblCant)
                                .addGap(10, 10, 10)
                                .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jlabelTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtNumArt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblCant, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlblObservación))
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblDescripción, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblActualizar)))
                    .addComponent(jtxtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jlblEstatus)
                        .addGap(4, 4, 4)
                        .addComponent(jcmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblModelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtInss, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCus)
                    .addComponent(jtxtNombreCus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblModelo2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlPaginar.setBackground(new java.awt.Color(64, 122, 237));

        pagination1.setOpaque(false);

        javax.swing.GroupLayout pnlPaginarLayout = new javax.swing.GroupLayout(pnlPaginar);
        pnlPaginar.setLayout(pnlPaginarLayout);
        pnlPaginarLayout.setHorizontalGroup(
            pnlPaginarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaginarLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnlPaginarLayout.setVerticalGroup(
            pnlPaginarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaginarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagination1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcmbBuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbBuscarItemStateChanged(evt);
            }
        });

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

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
        jTableData.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jTableData.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableData.setShowHorizontalLines(true);
        jTableData.getTableHeader().setReorderingAllowed(false);
        jTableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableData);
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

        jlabelTitle2.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jlabelTitle2.setText("EQUIPO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlPaginar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlabelTitle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabelTitle2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlPaginar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

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
        // TODO add your handling code here:
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

    private void jCmbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbMarcaActionPerformed

    }//GEN-LAST:event_jCmbMarcaActionPerformed

    private void btnGuardar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardar1MouseExited

    }//GEN-LAST:event_btnGuardar1MouseExited

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        try {
            jFrameMarca obb = new jFrameMarca();
            obb.setVisible(true);
            this.repaint();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                    + "el manejo de la solicitud \n en recurso de Base de Datos"
                    + ex.getMessage(),
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
        try {
            this.cargarComboBoxMarca();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Se ha producido una falla con "
                    + "el manejo de la solicitud \n en recurso de Base de Datos"
                    + ex.getMessage(),
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }
        lblActualizar.setVisible(true);
        this.btnGuardar1.setVisible(false);
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

        try {

            int val = Integer.parseInt(this.jtxtInss.getText());
            Custodio p = CTr_Custodio.leerRegistro(val);

            if (p != null) {
                this.jtxtNombreCus.setText(p.getNombres());
                this.jLblCus.setVisible(true);
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(this, "No Exite el registro con el número "
                        + "de inss: "
                        + String.valueOf(Integer.parseInt(this.jtxtInss.getText())), "Custodio", JOptionPane.ERROR_MESSAGE);
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

    private void jcmbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbBuscarItemStateChanged
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
    }//GEN-LAST:event_jcmbBuscarItemStateChanged

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseClicked
        try {

            int Fila = jTableData.getSelectedRow();
            String etiqueta = (String) jTableData.getValueAt(Fila, 1).toString();
            EquipoTecnologico p = CTr_EquipoTecnologico.leerRegistroTabla(etiqueta);

            if (p != null) {
                this.jtxtNombreCus.setText(p.getCustodio());
                this.jtxtInss.setText(Integer.toString(p.getInss()));
                this.jtxtNumArt.setText(Integer.toString(p.getNumeroArticulo()));
                this.jtxtCod.setText(p.getCodigo());
                this.jtxtEtiqueta.setText(p.getEtiqueta());
                this.jTxtCantidad.setText(Integer.toString(p.getCantidad()));
                this.jtxtDescripcion.setText(p.getDescripcion());
                this.jTxtCosto.setText(Double.toString(p.getCosto()));
                this.jtxtModelo.setText(p.getModelo());
                this.jCmbMarca.setSelectedItem(p.getNombreMarca());
                this.jtxtSerie.setText(p.getSerie());
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

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void lblActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblActualizarMouseClicked

        try {
            this.btnGuardar1.setVisible(true);
            this.cargarComboBoxMarca();
            this.lblActualizar.setVisible(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: El cambio de propiedad "
                    + "ha sido vetado",
                    "Error de Propiedad", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lblActualizarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.Validacion()) {
            CTr_EquipoTecnologico cmbService = new CTr_EquipoTecnologico();

            try {
                CTr_EquipoTecnologico EquipoService = new CTr_EquipoTecnologico();
                int numArticulo = Integer.parseInt(this.jtxtNumArt.getText());
                boolean existeRegistro = EquipoService.verificarEquipoRegistrado(numArticulo);

                if (!existeRegistro) {

                    int rst = CTr_EquipoTecnologico.agregar(
                            Integer.parseInt(this.jtxtInss.getText()),
                            Integer.parseInt(this.jtxtNumArt.getText()),
                            this.jtxtCod.getText(),
                            this.jtxtEtiqueta.getText(),
                            Integer.parseInt(this.jTxtCantidad.getText()),
                            this.jtxtDescripcion.getText(),
                            this.jtxtModelo.getText(),
                            cmbService.buscarIDMarca(jCmbMarca.getSelectedItem().toString()),
                            this.jtxtSerie.getText(),
                            Double.parseDouble(this.jTxtCosto.getText()),
                            cmbService.buscarIDEstado(jCmbEstado.getSelectedItem().toString()),
                            this.jtxtObservacion.getText()
                    );

                    limpiar();
                    this.cargarTabla(1);

                    if (rst > 0) {
                        JOptionPane.showMessageDialog(this, "Registro grabado con exito",
                                "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);

                    }//Fin de la instrucción if
                } else {
                    JOptionPane.showMessageDialog(this, "El registro" + " "
                            + String.valueOf(Integer.parseInt(this.jtxtNumArt.getText())) + " "
                            + "ya existe"
                            + "\nIntentelo de Nuevo", "Error", JOptionPane.ERROR_MESSAGE);

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
                EquipoTecnologico p = CTr_EquipoTecnologico.leerRegistro(val);

                if (p != null) {
                    this.jtxtNombreCus.setText(p.getCustodio());
                    this.jtxtInss.setText(Integer.toString(p.getInss()));
                    this.jtxtNumArt.setText(Integer.toString(p.getNumeroArticulo()));
                    this.jtxtCod.setText(p.getCodigo());
                    this.jtxtEtiqueta.setText(p.getEtiqueta());
                    this.jTxtCantidad.setText(Integer.toString(p.getCantidad()));
                    this.jtxtDescripcion.setText(p.getDescripcion());
                    this.jTxtCosto.setText(Double.toString(p.getCosto()));
                    this.jtxtModelo.setText(p.getModelo());
                    this.jCmbMarca.setSelectedItem(p.getNombreMarca());
                    this.jtxtSerie.setText(p.getSerie());
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
                    JOptionPane.showMessageDialog(this, "No Exite el registro con el número "
                            + "de articulo: "
                            + String.valueOf(Integer.parseInt(this.jtxtNumArt.getText())), "Equipo", JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        try {

            CTr_EquipoTecnologico EquipoService = new CTr_EquipoTecnologico();
            int numArticulo = Integer.parseInt(this.jtxtNumArt.getText());
            boolean existeRegistro = EquipoService.verificarEquipoRegistrado(numArticulo);

            if (existeRegistro) {
                int rst = CTr_EquipoTecnologico.actualizar(Integer.parseInt(this.jtxtInss.getText()), numArticulo,
                        Integer.parseInt(this.jTxtCantidad.getText()),
                        this.jtxtDescripcion.getText(),
                        this.jtxtModelo.getText(),
                        EquipoService.buscarIDMarca(jCmbMarca.getSelectedItem().toString()),
                        this.jtxtSerie.getText(),
                        Double.parseDouble(this.jTxtCosto.getText()),
                        EquipoService.buscarIDEstado(jCmbEstado.getSelectedItem().toString()),
                        this.jtxtObservacion.getText(),
                        Estatus()
                );
                this.cargarTabla(1);
                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro actualizado con exito",
                            "Actualizar Registro", JOptionPane.INFORMATION_MESSAGE);
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
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        try {

            CTr_EquipoTecnologico PersonalService = new CTr_EquipoTecnologico();
            int numArt = Integer.parseInt(this.jtxtNumArt.getText());
            boolean existeRegistro = PersonalService.verificarEquipoRegistrado(numArt);

            if (existeRegistro) {
                int rst = CTr_EquipoTecnologico.borrarRegistro(
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

    private void cargarComboBoxEstado() throws SQLException {
        try {

            CTr_EquipoTecnologico EstadoService = new CTr_EquipoTecnologico();
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

    private void cargarComboBoxMarca() throws SQLException {
        try {

            CTr_EquipoTecnologico MarcaService = new CTr_EquipoTecnologico();
            List<String> Marcas = MarcaService.obtenerMarca();
            jCmbMarca.removeAllItems();
            jCmbMarca.addItem("Seleccionar");
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
        } else if (jtxtSerie.getText().isEmpty()) {

            return false;
        } else if (jTxtCantidad.getText().isEmpty()) {

            return false;
        } else if (jtxtModelo.getText().isEmpty()) {

            return false;
        } else if (jtxtObservacion.getText().isEmpty()) {

            return false;

        } else if (jtxtInss.getText().isEmpty()) {

            return false;
        } else if (jCmbMarca.getSelectedItem().toString().equals("Seleccionar")) {

            return false;
        }
        return valido;
    }

    public void limpiar() {
        this.jtxtInss.setText("");
        this.jtxtNombreCus.setText("");
        this.jtxtEtiqueta.setText("");
        this.jtxtCod.setText("");
        this.jTxtCosto.setText("");
        this.jtxtDescripcion.setText("");
        this.jtxtNumArt.setText("");
        this.jtxtSerie.setText("");
        this.jTxtCantidad.setText("");
        this.jtxtModelo.setText("");
        this.jtxtObservacion.setText("");
        this.jtxtNombreCus.setText("");
        this.jtxtInss.setText("");
        this.jcmbEstatus.setVisible(false);
        this.jlblEstatus.setVisible(false);
        this.jCmbEstado.setSelectedIndex(0);
        this.jCmbMarca.setSelectedIndex(0);
        this.jLblCus.setVisible(false);
    }

    public int Estatus() {
        int estado = -1;
        if ("Activo".equals(jcmbEstatus.getSelectedItem().toString())) {
            estado = 1;
            this.jcmbEstatus.setVisible(false);
        } else if ("Inactivo".equals(jcmbEstatus.getSelectedItem().toString())) {
            estado = 0;
        }
        return estado;
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

    private void cargarTabla(int page) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        // Diseño de la tabla
        jTableData.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTableData.getTableHeader().setOpaque(false);
        jTableData.getTableHeader().setBackground(new Color(32, 136, 203));
        jTableData.getTableHeader().setForeground(new Color(255, 255, 255));

        // crea el modelo de tabla y configura las columnas
        DefaultTableModel modelo = new DefaultTableModel();

        jTableData.setModel(modelo);

        modelo.addColumn("Custodio");
        modelo.addColumn("Etiqueta");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Descripción");
        modelo.addColumn("Marca");
        modelo.addColumn("Estado");
        modelo.addColumn("Observación");
        // Llenado 
        CTr_EquipoTecnologico obb = new CTr_EquipoTecnologico();
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
            totalFilas = filasResultantes.length;
        }

        packColumns(jTableData, 7);

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
                cellComponent.setBackground(Bueno);
                cellComponent.setForeground(new Color(255, 255, 255));// 
            } else {
                Malo = new Color(255, 51, 51);
                cellComponent.setBackground(Malo);
                cellComponent.setForeground(new Color(255, 255, 255));
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

            // Establecer el título de la columna según su contenido
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
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> jCmbEstado;
    private javax.swing.JComboBox<String> jCmbMarca;
    private javax.swing.JLabel jLblCus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JLabel jlblMarca;
    private javax.swing.JLabel jlblModelo;
    private javax.swing.JLabel jlblModelo1;
    private javax.swing.JLabel jlblModelo2;
    private javax.swing.JLabel jlblObservación;
    private javax.swing.JLabel jlblSerie;
    private javax.swing.JTextField jtxtCod;
    private javax.swing.JTextField jtxtDescripcion;
    private javax.swing.JTextField jtxtEtiqueta;
    private javax.swing.JTextField jtxtInss;
    private javax.swing.JTextField jtxtModelo;
    private javax.swing.JTextField jtxtNombreCus;
    private javax.swing.JTextField jtxtNumArt;
    private javax.swing.JTextField jtxtObservacion;
    private javax.swing.JTextField jtxtSerie;
    private javax.swing.JLabel lblActualizar;
    private javax.swing.JLabel lblArt;
    private javax.swing.JLabel lblCod;
    private pagination.Pagination pagination1;
    private Components.PanelShadow panelShadow1;
    private javax.swing.JPanel pnlPaginar;
    // End of variables declaration//GEN-END:variables
}
