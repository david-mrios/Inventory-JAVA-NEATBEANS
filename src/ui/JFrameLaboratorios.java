/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ui;

import controlador.CTr_EncargadoLab;
import controlador.CTr_Instructor;
import controlador.CTr_Laboratorio;
import controlador.CTr_Movimientos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import negocio.Instructor;
import negocio.Laboratorio;
import pagination.EventPagination;
import pagination.style.PaginationItemRenderStyle1;

/**
 *
 * @author David
 */
public class JFrameLaboratorios extends javax.swing.JInternalFrame {

    int noCarnet = 0;
    private int totalFilas; // variable para almacenar el total de filas obtenidas
    private int filasPorPagina = 10; // numero de filas a mostrar por pagina
    private int totalPaginas; // variable para almacenar el total de paginas
    private Object[] filasResultantes;

    public JFrameLaboratorios() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        initComponents();
        //Quitar bordes
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        pagination1.addEventPagination(new EventPagination() {
            @Override
            public void pageChanged(int page) {
                try {
                    cargarTabla(page);
                    mostrarFilasPaginaActual(page);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                    Logger.getLogger(jFrameCustodio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        pagination1.setPaginationItemRender(new PaginationItemRenderStyle1());
        cargarTabla(1);
        cargarComboBoxLab();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new Components.datechooser.DateChooser();
        dateChooser2 = new Components.datechooser.DateChooser();
        Fondo = new javax.swing.JPanel();
        pnlLab = new javax.swing.JPanel();
        btnBorrar = new javax.swing.JButton();
        lblNumLab = new javax.swing.JLabel();
        txtNumlab = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jlblEstado1 = new javax.swing.JLabel();
        cmbLab = new javax.swing.JComboBox<>();
        pnlHorarios = new javax.swing.JPanel();
        lblLab = new javax.swing.JLabel();
        lblInstructor = new javax.swing.JLabel();
        txtInstructor = new javax.swing.JTextField();
        lblDate1 = new javax.swing.JLabel();
        jlblDate2 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        btnGuardarH = new javax.swing.JButton();
        btnGuardarL = new javax.swing.JButton();
        txtDateEntrada = new javax.swing.JTextField();
        txtDateSalida = new javax.swing.JTextField();
        btnDate1 = new javax.swing.JButton();
        btnDate2 = new javax.swing.JButton();
        lblBuscarResponsable = new javax.swing.JLabel();
        cmbLaboratorio = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        pnlPaginar = new javax.swing.JPanel();
        pagination1 = new pagination.Pagination();

        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setTextRefernce(txtDateEntrada);

        dateChooser2.setDateFormat("yyyy-MM-dd");
        dateChooser2.setTextRefernce(txtDateSalida);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));

        pnlLab.setBackground(new java.awt.Color(255, 255, 255));
        pnlLab.setBorder(javax.swing.BorderFactory.createTitledBorder("Laboratorio"));

        btnBorrar.setBackground(new java.awt.Color(82, 183, 136));
        btnBorrar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        lblNumLab.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        lblNumLab.setText("Laboratorio");

        btnGuardar.setBackground(new java.awt.Color(82, 183, 136));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jlblEstado1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jlblEstado1.setText("Laboratorio");

        cmbLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLab.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLabItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlLabLayout = new javax.swing.GroupLayout(pnlLab);
        pnlLab.setLayout(pnlLabLayout);
        pnlLabLayout.setHorizontalGroup(
            pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLabLayout.createSequentialGroup()
                        .addComponent(lblNumLab)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumlab))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jlblEstado1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbLab, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
            .addGroup(pnlLabLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLabLayout.setVerticalGroup(
            pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLabLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumLab)
                    .addComponent(txtNumlab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLab, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pnlHorarios.setBackground(new java.awt.Color(255, 255, 255));
        pnlHorarios.setBorder(javax.swing.BorderFactory.createTitledBorder("Horarios"));
        pnlHorarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLab.setText("Laboratorio");
        pnlHorarios.add(lblLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 26, -1, 30));

        lblInstructor.setText("Instructor");
        pnlHorarios.add(lblInstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        pnlHorarios.add(txtInstructor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 190, -1));

        lblDate1.setText("Fecha entrada");
        pnlHorarios.add(lblDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 84, -1));

        jlblDate2.setText("Fecha Salida");
        pnlHorarios.add(jlblDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 74, -1));

        btnLimpiar.setBackground(new java.awt.Color(82, 183, 136));
        btnLimpiar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        pnlHorarios.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 78, 31));

        btnGuardarH.setBackground(new java.awt.Color(82, 183, 136));
        btnGuardarH.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnGuardarH.setText("Guardar");
        btnGuardarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarHActionPerformed(evt);
            }
        });
        pnlHorarios.add(btnGuardarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 78, 31));

        btnGuardarL.setBackground(new java.awt.Color(82, 183, 136));
        btnGuardarL.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 10)); // NOI18N
        btnGuardarL.setText("Actualizar");
        btnGuardarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarLActionPerformed(evt);
            }
        });
        pnlHorarios.add(btnGuardarL, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 78, 31));
        pnlHorarios.add(txtDateEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 95, -1));
        pnlHorarios.add(txtDateSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 95, -1));

        btnDate1.setText("...");
        btnDate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDate1ActionPerformed(evt);
            }
        });
        pnlHorarios.add(btnDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 30, -1));

        btnDate2.setText("...");
        btnDate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDate2ActionPerformed(evt);
            }
        });
        pnlHorarios.add(btnDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 30, -1));

        lblBuscarResponsable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscando.png"))); // NOI18N
        lblBuscarResponsable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBuscarResponsableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBuscarResponsableMouseEntered(evt);
            }
        });
        pnlHorarios.add(lblBuscarResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        cmbLaboratorio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLaboratorioItemStateChanged(evt);
            }
        });
        pnlHorarios.add(cmbLaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 170, -1));

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

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPaginar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
                .addContainerGap())
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPaginar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(pnlLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.Validacion()) {
            try {
                int rst = CTr_Laboratorio.agregar(txtNumlab.getText());

                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro grabado con éxito",
                            "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
                }
                cargarComboBoxLab();

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

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        try {
            int rst = CTr_Laboratorio.borrarRegistro(
                    this.txtNumlab.getText()
            );
            if (rst > 0) {
                JOptionPane.showMessageDialog(this, "Registro borrado con exito",
                        "Borrar Registro", JOptionPane.INFORMATION_MESSAGE);

            }//Fin de la instrucción if 
            cargarComboBoxLab();

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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.clean();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarHActionPerformed
        if (this.ValidacionHorario()) {
            try {

                int rst = CTr_EncargadoLab.agregar(
                        CTr_Movimientos.buscarIDLab(this.cmbLaboratorio.getSelectedItem().toString()),
                        noCarnet,
                        this.txtDateEntrada.getText(),
                        this.txtDateSalida.getText()
                );

                if (rst > 0) {
                    JOptionPane.showMessageDialog(this, "Registro guardado con exito",
                            "Registro", JOptionPane.INFORMATION_MESSAGE);

                }//Fin de la instrucción if
                this.cargarTabla(1);
                this.clean();

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

    }//GEN-LAST:event_btnGuardarHActionPerformed

    private void btnGuardarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarLActionPerformed
        try {
            int Fila = jTableData.getSelectedRow();
            noCarnet = (int) jTableData.getValueAt(Fila, 2);
            int rst = CTr_EncargadoLab.actualizar(
                    CTr_Movimientos.buscarIDLab(this.cmbLaboratorio.getSelectedItem().toString()),
                    noCarnet,
                    this.txtDateEntrada.getText(),
                    this.txtDateSalida.getText()
            );

            if (rst > 0) {
                JOptionPane.showMessageDialog(this, "Registro guardado con exito",
                        "Registro", JOptionPane.INFORMATION_MESSAGE);

            }//Fin de la instrucción if

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
    }//GEN-LAST:event_btnGuardarLActionPerformed

    private void cmbLabItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLabItemStateChanged

        Object selectedItem = cmbLab.getSelectedItem();
        String marca;

        if (selectedItem != null) {
            if (!selectedItem.toString().equals("Seleccionar")) {
                marca = selectedItem.toString();
                this.txtNumlab.setText(marca);

            } else if (selectedItem.toString().equals("Seleccionar")) {
                this.txtNumlab.setText("");
            }

        }

    }//GEN-LAST:event_cmbLabItemStateChanged

    private void btnDate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDate1ActionPerformed
        dateChooser2.showPopup();
    }//GEN-LAST:event_btnDate1ActionPerformed

    private void btnDate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDate2ActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_btnDate2ActionPerformed

    private void lblBuscarResponsableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBuscarResponsableMouseClicked
        try {

            String val = JOptionPane.showInputDialog(this, "Ingrese el numero"
                    + "de carnet", "Instructor", JOptionPane.INFORMATION_MESSAGE);
            noCarnet = Integer.parseInt(val);
            Instructor p = CTr_Instructor.leerRegistro(noCarnet);

            if (p != null) {
                this.txtInstructor.setText(p.getNombres().concat(" ").concat(p.getApellidos()));
            }//Fin de la instrucción if
            else {
                JOptionPane.showMessageDialog(null, "No Exite el registro con el numero "
                        + "de carnet: "
                        + String.valueOf(noCarnet));
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

    private void cmbLaboratorioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLaboratorioItemStateChanged

    }//GEN-LAST:event_cmbLaboratorioItemStateChanged

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseClicked
        try {

            int Fila = jTableData.getSelectedRow();
            String lab = (String) jTableData.getValueAt(Fila, 0);
            Laboratorio p = CTr_Laboratorio.EncargadosView(lab);

            if (p != null) {
                cmbLaboratorio.setSelectedItem(p.getNumeroLab());
                txtInstructor.setText(p.getInstructor());
                txtDateEntrada.setText(p.getFechaEntrada());
                txtDateSalida.setText(p.getFechaSalida());

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

    private void cargarComboBoxLab() throws SQLException {
        try {

            CTr_Laboratorio Service = new CTr_Laboratorio();
            List<String> cargos = Service.getLaboratorios();
            cmbLab.removeAllItems();
            cmbLaboratorio.removeAllItems();
            cmbLab.addItem("Seleccionar");
            cmbLaboratorio.addItem("Seleccionar");
            for (String cargo : cargos) {
                cmbLab.addItem(cargo);
                cmbLaboratorio.addItem(cargo);
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

        modelo.addColumn("Laboratorio");
        modelo.addColumn("Instructor");
        modelo.addColumn("N° carnet");
        modelo.addColumn("Fecha Entrada");
        modelo.addColumn("Fecha Salida");

        // Llenado
        CTr_Laboratorio obb = new CTr_Laboratorio();
        filasResultantes = obb.EncargadosListar();
        totalFilas = filasResultantes.length;
        filasPorPagina = 15;
        totalPaginas = (int) Math.ceil((double) totalFilas / filasPorPagina);
        int filaInicial = (page - 1) * filasPorPagina;
        int filaFinal = Math.min(filaInicial + filasPorPagina, totalFilas);

        for (int i = filaInicial; i < filaFinal; i++) {
            modelo.addRow((Object[]) filasResultantes[i]);
        }

        packColumns(jTableData, 6);
        // Obtener celda en la posición 
        Rectangle rect = jTableData.getCellRect(0, 0, true);
        jTableData.scrollRectToVisible(rect);

        // Mostrar las filas correspondientes a la página actual
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

        // verificar que el número de filas resultantes sea valido
        if (filasResultantes != null && filaInicial >= 0 && filaInicial < filasResultantes.length && filaFinal <= filasResultantes.length) {
            // Agregar las filas correspondientes a la pagina actual al modelo de tabla
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

        if (txtNumlab.getText().isEmpty()) {

            return false;
        }
        return valido;
    }

    public boolean ValidacionHorario() {

        boolean valido = true;

        if (cmbLaboratorio.getSelectedItem().equals("Seleccionar")) {

            return false;
        } else if (txtInstructor.getText().isEmpty()) {

            return false;

        }
        return valido;
    }

    public void clean() {
        cmbLaboratorio.setSelectedIndex(0);
        txtInstructor.setText(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnDate1;
    private javax.swing.JButton btnDate2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarH;
    private javax.swing.JButton btnGuardarL;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbLab;
    private javax.swing.JComboBox<String> cmbLaboratorio;
    private Components.datechooser.DateChooser dateChooser1;
    private Components.datechooser.DateChooser dateChooser2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableData;
    private javax.swing.JLabel jlblDate2;
    private javax.swing.JLabel jlblEstado1;
    private javax.swing.JLabel lblBuscarResponsable;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblInstructor;
    private javax.swing.JLabel lblLab;
    private javax.swing.JLabel lblNumLab;
    private pagination.Pagination pagination1;
    private javax.swing.JPanel pnlHorarios;
    private javax.swing.JPanel pnlLab;
    private javax.swing.JPanel pnlPaginar;
    private javax.swing.JTextField txtDateEntrada;
    private javax.swing.JTextField txtDateSalida;
    private javax.swing.JTextField txtInstructor;
    private javax.swing.JTextField txtNumlab;
    // End of variables declaration//GEN-END:variables
}
