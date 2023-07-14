/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.CTr_Custodio;
import controlador.CTr_Inventario;
import controlador.CTr_Movimientos;
import controlador.Ctr_Responsable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import negocio.Custodio;
import negocio.Responsable;

/**
 *
 * @author David
 */
public class jFrameReporte extends javax.swing.JInternalFrame {

    int noInssRes = 0;
    int noInssCus = 0;

    private int totalFilas;
    private Object[] filasResultantes;

    public jFrameReporte() {
        try {
            initComponents();

            this.setMaximizable(true);
            this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
            BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
            bi.setNorthPane(null);

            cargarComboBox();

            this.lblNuevo.setVisible(false);

            cargarTabla();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser2 = new Components.datechooser.DateChooser();
        pnlFondo = new javax.swing.JPanel();
        lblTitituloReporte = new javax.swing.JLabel();
        panelShadow1 = new Components.PanelShadow();
        cmbReporte = new javax.swing.JComboBox<>();
        lbltpReporte = new javax.swing.JLabel();
        panelShadow4 = new Components.PanelShadow();
        lblfecha = new javax.swing.JLabel();
        txtDateEntrada = new javax.swing.JTextField();
        btnDate = new javax.swing.JButton();
        panelShadow2 = new Components.PanelShadow();
        lblUbicacion = new javax.swing.JLabel();
        lblFacultad = new javax.swing.JLabel();
        jcmbFacultad = new javax.swing.JComboBox<>();
        lblRecinto = new javax.swing.JLabel();
        jcmbRencinto = new javax.swing.JComboBox<>();
        lblDependencia = new javax.swing.JLabel();
        jcmbDepartamento = new javax.swing.JComboBox<>();
        panelShadow3 = new Components.PanelShadow();
        lblCus = new javax.swing.JLabel();
        lblRes = new javax.swing.JLabel();
        jtxtResponsable = new javax.swing.JTextField();
        lblBuscarResponsable = new javax.swing.JLabel();
        txtCus = new javax.swing.JTextField();
        lblBuscarCustodio = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        panelShadow5 = new Components.PanelShadow();
        lblExportar = new javax.swing.JLabel();
        lblNuevo = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        lblInventario = new javax.swing.JLabel();

        dateChooser2.setTextRefernce(txtDateEntrada);

        pnlFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblTitituloReporte.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblTitituloReporte.setText("REPORTE");

        cmbReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inventario de equipos tecnológicos", "Inventario de equipos mobiliarios", "Movimientos de equipos tecnológicos", "Movimientos de equipos mobiliarios" }));
        cmbReporte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbReporteItemStateChanged(evt);
            }
        });

        lbltpReporte.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lbltpReporte.setText("TIPO DE REPORTE");

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(lbltpReporte))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cmbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbltpReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        lblfecha.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblfecha.setText("FECHA DE CREACIÓN");

        txtDateEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateEntradaActionPerformed(evt);
            }
        });

        btnDate.setText("...");
        btnDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow4Layout = new javax.swing.GroupLayout(panelShadow4);
        panelShadow4.setLayout(panelShadow4Layout);
        panelShadow4Layout.setHorizontalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow4Layout.createSequentialGroup()
                        .addComponent(txtDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblfecha))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        panelShadow4Layout.setVerticalGroup(
            panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDateEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        lblUbicacion.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblUbicacion.setText("UBICACIÓN");

        lblFacultad.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblFacultad.setText("Facultad");

        lblRecinto.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblRecinto.setText("Recinto Universitario\t\t\t ");

        lblDependencia.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblDependencia.setText("Dependencia");

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRecinto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDependencia)
                            .addComponent(lblFacultad))
                        .addGap(18, 18, 18)
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcmbDepartamento, 0, 220, Short.MAX_VALUE)
                            .addComponent(jcmbRencinto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcmbFacultad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lblUbicacion)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecinto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbRencinto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lblCus.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblCus.setText("CUSTODIO");

        lblRes.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        lblRes.setText("RESPONSABLE");

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

        txtCus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCusKeyTyped(evt);
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

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelShadow3Layout.createSequentialGroup()
                                .addComponent(txtCus)
                                .addGap(10, 10, 10)
                                .addComponent(lblBuscarCustodio))
                            .addGroup(panelShadow3Layout.createSequentialGroup()
                                .addComponent(jtxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblBuscarResponsable))))
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblCus))
                    .addGroup(panelShadow3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblRes)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblRes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarResponsable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCus, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscarCustodio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        panelShadow5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exportar.png"))); // NOI18N
        lblExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExportarMouseClicked(evt);
            }
        });
        panelShadow5.add(lblExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        lblNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/nuevoBtn.png"))); // NOI18N
        lblNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNuevoMouseClicked(evt);
            }
        });
        panelShadow5.add(lblNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarKeyPressed(evt);
            }
        });

        lblInventario.setText("Número de inventario");

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitituloReporte)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelShadow5, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelShadow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblInventario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)))
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelShadow3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                        .addGap(12, 12, 12)))
                .addGap(15, 15, 15))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitituloReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelShadow3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelShadow2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelShadow4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInventario))
                        .addGap(18, 18, 18)
                        .addComponent(panelShadow5, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                        .addGap(68, 68, 68))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateEntradaActionPerformed

    }//GEN-LAST:event_txtDateEntradaActionPerformed

    private void btnDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateActionPerformed
        dateChooser2.showPopup();
    }//GEN-LAST:event_btnDateActionPerformed

    private void jtxtResponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtResponsableKeyTyped

    }//GEN-LAST:event_jtxtResponsableKeyTyped

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

    private void txtCusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCusKeyTyped

    }//GEN-LAST:event_txtCusKeyTyped

    private void lblBuscarCustodioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarCustodioMouseClicked
        try {

            String val = JOptionPane.showInputDialog(this, "Ingrese el número"
                    + "de inss", "Custodio", JOptionPane.INFORMATION_MESSAGE);
            noInssCus = Integer.parseInt(val);
            Custodio p = CTr_Custodio.leerRegistro(noInssCus);

            if (p != null) {
                this.txtCus.setText(p.getNombres().concat(" ").concat(p.getApellidos()));
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(this, "No Exite el registro con el número "
                        + "de inss: "
                        + String.valueOf(Integer.toString(noInssRes)), "Custodio", JOptionPane.ERROR_MESSAGE);
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

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseClicked

    }//GEN-LAST:event_jTableDataMouseClicked

    private void cmbReporteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbReporteItemStateChanged
        Object selectedItem = cmbReporte.getSelectedItem();
        String reporte;

        if (selectedItem != null) {

            reporte = selectedItem.toString();
            if (reporte.equals("Inventario de equipos tecnológicos")
                    || reporte.equals("Inventario de equipos mobiliarios")) {
                this.lblInventario.setText("Número de inventario");
            } else {
                this.lblInventario.setText("Número de articulo");
            }

        }

        try {
            this.cargarTabla();
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

    }//GEN-LAST:event_cmbReporteItemStateChanged

    private void lblExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExportarMouseClicked
        if (this.Validacion()) {

            try {
                exportPDF();
                this.lblNuevo.setVisible(true);
                this.lblExportar.setVisible(false);

            } catch (BadElementException | IOException ex) {
                ex.printStackTrace();
            }
        } else {

            JOptionPane.showMessageDialog(this, "Alguna caja de texto esta vacia",
                    "Error al Procesar Datos", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_lblExportarMouseClicked

    private void lblNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNuevoMouseClicked
        this.jcmbDepartamento.setSelectedIndex(0);
        this.jcmbFacultad.setSelectedIndex(0);
        this.jcmbRencinto.setSelectedIndex(0);
        this.jtxtResponsable.setText(null);
        this.txtCus.setText(null);
        this.lblExportar.setVisible(true);
        this.lblNuevo.setVisible(false);

    }//GEN-LAST:event_lblNuevoMouseClicked

    private void buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                cargarTabla();

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
            this.buscar.setText(null);

        }
    }//GEN-LAST:event_buscarKeyPressed

    private void cargarTabla() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        jTableData.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
        jTableData.getTableHeader().setOpaque(false);
        jTableData.getTableHeader().setBackground(new Color(32, 136, 203));
        jTableData.getTableHeader().setForeground(new Color(255, 255, 255));

        DefaultTableModel modelo = new DefaultTableModel();
        jTableData.setModel(modelo);
        Object selectedItem = cmbReporte.getSelectedItem();

        if (selectedItem != null) {
            switch (selectedItem.toString()) {
                case "Inventario de equipos tecnológicos" -> {
                    if (buscar.getText().isEmpty()) {
                        modelo.addColumn("N° Inventario");
                        modelo.addColumn("Total de equipos");
                        modelo.addColumn("Fecha de Ingreso");

                        CTr_Inventario obb = new CTr_Inventario();
                        filasResultantes = obb.CantEquipoInventario();
                    } else if (buscar.getText() != null) {
                        modelo.addColumn("N° Inventario");
                        modelo.addColumn("N° de articulo");
                        modelo.addColumn("Descripción");
                        modelo.addColumn("Estado");
                        modelo.addColumn("Fecha de Ingreso");

                        CTr_Inventario obb = new CTr_Inventario();
                        filasResultantes = obb.obtenerDatosEquipoTecnologicosInv(Integer.parseInt(buscar.getText()));
                    }
                    totalFilas = filasResultantes.length;
                    for (int i = 0; i < totalFilas; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }

                case "Inventario de equipos mobiliarios" -> {
                    if (buscar.getText().isEmpty()) {
                        modelo.addColumn("N° Inventario");
                        modelo.addColumn("Total de equipos");
                        modelo.addColumn("Fecha de Ingreso");

                        CTr_Inventario obb = new CTr_Inventario();
                        filasResultantes = obb.CantEquipoMobInventario();
                    } else if (buscar.getText() != null) {
                        modelo.addColumn("N° Inventario");
                        modelo.addColumn("N° de articulo");
                        modelo.addColumn("Descripción");
                        modelo.addColumn("Estado");
                        modelo.addColumn("Fecha Ingreso");

                        CTr_Inventario obb = new CTr_Inventario();
                        filasResultantes = obb.obtenerDatosEquipoMobiliarioInv(Integer.parseInt(buscar.getText()));
                    }
                    totalFilas = filasResultantes.length;
                    for (int i = 0; i < totalFilas; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }

                case "Movimientos de equipos tecnológicos" -> {
                    if (buscar.getText().isEmpty()) {
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
                    } else if (buscar.getText() != null) {
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
                        filasResultantes = obb.ListarMovimientosEquipoTec(Integer.parseInt(buscar.getText()));
                    }
                    totalFilas = filasResultantes.length;
                    for (int i = 0; i < totalFilas; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }
                }

                case "Movimientos de equipos mobiliarios" -> {
                    if (buscar.getText().isEmpty()) {
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
                        filasResultantes = obb.ListarMovimientosMob();
                    } else if (buscar.getText() != null) {
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
                        filasResultantes = obb.ListarMovimientosEquipoMob(Integer.parseInt(buscar.getText()));
                    }
                    totalFilas = filasResultantes.length;
                    for (int i = 0; i < totalFilas; i++) {
                        modelo.addRow((Object[]) filasResultantes[i]);
                    }

                }
            }

        }

        packColumns(jTableData, 6);

        Rectangle rect = jTableData.getCellRect(0, 0, true);
        jTableData.scrollRectToVisible(rect);
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

    public void exportPDF() throws BadElementException, IOException {
        //Creaccion del pdf
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF", "pdf");
        fileChooser.setFileFilter(filter);

        //ubicacion
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();

            if (!filePath.toLowerCase().endsWith(".pdf")) {
                filePath += ".pdf";
            }

            try {
                // poner en horizontal
                Document document = new Document();
                document.setPageSize(PageSize.A4.rotate());
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();

                // logo
                String logoPath = "src/icons/Logo.png";
                Image logo = Image.getInstance(logoPath);
                logo.scaleAbsolute(260, 143);
                logo.setAlignment(Element.ALIGN_CENTER);
                document.add(logo);

                // contenido del pdf
                Font font = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);

                Paragraph centeredParagraph = new Paragraph();
                centeredParagraph.setAlignment(Element.ALIGN_CENTER);
                // una forma de agregar contenido
                Chunk chunk = new Chunk("LEVANTAMIENTO FÍSICO DE MOBILIARIO, EQUIPO DE OFICINA, LABORATORIO Y EQUIPO RODANTE", font);
                centeredParagraph.add(chunk);
                // segunda forma de agregar contenido
                Paragraph centeredParagraph1 = new Paragraph("Recinto Universitario: "
                        + jcmbRencinto.getSelectedItem().toString() + "                                                        "
                        + "           "
                        + "Custodio de los bienes: " + this.txtCus.getText());
                centeredParagraph1.setAlignment(Element.ALIGN_LEFT);

                Paragraph centeredParagraph2 = new Paragraph("Dependencia: "
                        + jcmbDepartamento.getSelectedItem().toString() + "                                                        "
                        + "                          "
                        + "Responsable de los bienes: " + this.jtxtResponsable.getText());
                centeredParagraph2.setAlignment(Element.ALIGN_LEFT);

                Paragraph centeredParagraph3 = new Paragraph("Facultad: "
                        + jcmbFacultad.getSelectedItem().toString() + "                                                        "
                        + "                                   "
                        + "    Fecha: " + txtDateEntrada.getText());
                centeredParagraph3.setAlignment(Element.ALIGN_LEFT);

                Paragraph centeredParagraph4 = new Paragraph("TIPO DE REPORTE: "
                        + cmbReporte.getSelectedItem().toString().toUpperCase(), font);
                centeredParagraph4.setAlignment(Element.ALIGN_CENTER);

                Home obb = new Home();
                obb.repaint();
                Paragraph centeredParagraph5 = new Paragraph("Creado por el " + obb.jLblRol.getText() + ": "
                        + obb.jlblSesion.getText(), font);
                centeredParagraph5.setAlignment(Element.ALIGN_LEFT);

                // agregar
                document.add(centeredParagraph);
                document.add(new Chunk("\n"));
                document.add(centeredParagraph1);
                document.add(new Chunk("\n"));
                document.add(centeredParagraph2);
                document.add(new Chunk("\n"));
                document.add(centeredParagraph3);
                document.add(new Chunk("\n"));
                document.add(centeredParagraph5);
                document.add(new Chunk("\n"));
                document.add(centeredParagraph4);

                // crea una tabla en el documento pdf
                PdfPTable table = new PdfPTable(jTableData.getColumnCount());
                // configura el diseño de la tabla
                table.setHeaderRows(1);
                table.setWidthPercentage(100);
                table.setSpacingBefore(10f);
                table.setSpacingAfter(10f);

                // agrega los encabezados de columna a la tabla
                for (int i = 0; i < jTableData.getColumnCount(); i++) {
                    PdfPCell headerCell = new PdfPCell(new Phrase(jTableData.getColumnName(i)));
                    headerCell.setBackgroundColor(new BaseColor(32, 136, 203));
                    headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(headerCell);
                }

                // agrega los datos de la tabla al pdf
                for (int row = 0; row < jTableData.getRowCount(); row++) {
                    for (int column = 0; column < jTableData.getColumnCount(); column++) {
                        table.addCell(jTableData.getValueAt(row, column).toString());
                    }
                }
                // agregar tabla
                document.add(table);

                document.close();

                JOptionPane.showMessageDialog(this, "El reporte se ha creado con exito \n"
                        + "El archivo PDF se ha generado correctamente en: " + filePath,
                        "Reporte", JOptionPane.INFORMATION_MESSAGE);

            } catch (DocumentException | FileNotFoundException ex) {
                ex.printStackTrace();
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

            // abrir el pdf
            File pdfFile = new File(filePath);
            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro el PDF", "PDF no encontrado",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void cargarComboBox() throws SQLException {
        try {

            CTr_Inventario Service = new CTr_Inventario();
            List<String> facultades = Service.obtenerFacultad();
            List<String> departamentos = Service.obtenerDepartamento();
            List<String> recintos = Service.obtenerRecinto();
            jcmbFacultad.addItem("Seleccionar");
            jcmbRencinto.addItem("Seleccionar");
            jcmbDepartamento.addItem("Selcecionar");
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

    public boolean Validacion() {

        boolean valido = true;

        if (jcmbFacultad.getSelectedItem().toString().equals("Seleccionar")) {

            return false;
        } else if (jcmbRencinto.getSelectedItem().toString().equals("Seleccionar")) {

            return false;

        } else if (jcmbDepartamento.getSelectedItem().toString().equals("Seleccionar")) {

            return false;
        } else if (jtxtResponsable.getText().isEmpty()) {

            return false;
        } else if (txtCus.getText().isEmpty()) {

            return false;
        }
        return valido;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDate;
    private javax.swing.JTextField buscar;
    private javax.swing.JComboBox<String> cmbReporte;
    private Components.datechooser.DateChooser dateChooser2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableData;
    private javax.swing.JComboBox<String> jcmbDepartamento;
    private javax.swing.JComboBox<String> jcmbFacultad;
    private javax.swing.JComboBox<String> jcmbRencinto;
    private javax.swing.JTextField jtxtResponsable;
    private javax.swing.JLabel lblBuscarCustodio;
    private javax.swing.JLabel lblBuscarResponsable;
    private javax.swing.JLabel lblCus;
    private javax.swing.JLabel lblDependencia;
    private javax.swing.JLabel lblExportar;
    private javax.swing.JLabel lblFacultad;
    private javax.swing.JLabel lblInventario;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JLabel lblRecinto;
    private javax.swing.JLabel lblRes;
    private javax.swing.JLabel lblTitituloReporte;
    private javax.swing.JLabel lblUbicacion;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lbltpReporte;
    private Components.PanelShadow panelShadow1;
    private Components.PanelShadow panelShadow2;
    private Components.PanelShadow panelShadow3;
    private Components.PanelShadow panelShadow4;
    private Components.PanelShadow panelShadow5;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTextField txtCus;
    private javax.swing.JTextField txtDateEntrada;
    // End of variables declaration//GEN-END:variables
}
