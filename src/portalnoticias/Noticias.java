/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package portalnoticias;

import Modelos.ConexionDB;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jovie
 */
public class Noticias extends javax.swing.JPanel {

    DefaultTableModel modelo;
    ConexionDB cc = new ConexionDB();
    Connection con = cc.getConneccion();
    private TableRowSorter trsfiltro;

    Main main = new Main();

    String usuario;

    public Noticias() {
        initComponents();
        llenarCombo();
        llenarTabla();
        llenarComboTema();
        jPanel1.setVisible(false);
        LabelID.setVisible(false);
        textID.setVisible(false);
    }

    public void llenarCombo() {
        comboBox.addItem("ID"); //0
        comboBox.addItem("Título"); //1
        comboBox.addItem("Tema"); //2
        comboBox.addItem("SubTema"); //3
        comboBox.addItem("Autor"); //4
        comboBox.setSelectedIndex(0);
    }

    public void llenarTabla() {
        //SELECT * NOTICIASPORTAL_TABLE_VIEW
        try {
            modelo = (DefaultTableModel) notiiciasTable.getModel();

            String sql = "SELECT * FROM NOTICIASPORTAL_TABLE_VIEW";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];

                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error consultando las noticias " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void llenarComboTema() {
        tema.removeAllItems();

        try {
            String sql = "SELECT NOMBRETEMA FROM TEMAS ORDER BY NOMBRETEMA ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tema.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error llenando el combo de Tema " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llenarComboSubTema() {
        String temaitem = String.valueOf(tema.getSelectedItem());
        subtema.removeAllItems();
        try {
            String sql = "SELECT NOMBRESUBTEMA FROM SUBTEMAS WHERE NOMBRETEMA = '" + temaitem + "' ORDER BY NOMBRESUBTEMA ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                subtema.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error llenando el combo de SubTema " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Clear_Table() {
        for (int i = 0; i < notiiciasTable.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public boolean seleccionarFila() {
        btnGuardar.setVisible(true);

        if (notiiciasTable.getSelectedRow() != -1) {
            textID.setText(String.valueOf(notiiciasTable.getValueAt(notiiciasTable.getSelectedRow(), 0)));
            fechaposteo.setText(String.valueOf(notiiciasTable.getValueAt(notiiciasTable.getSelectedRow(), 1)));
            titulo.setText(String.valueOf(notiiciasTable.getValueAt(notiiciasTable.getSelectedRow(), 2)));
            autor.setText(String.valueOf(notiiciasTable.getValueAt(notiiciasTable.getSelectedRow(), 5)));
            tema.setSelectedItem(notiiciasTable.getValueAt(notiiciasTable.getSelectedRow(), 3));
            subtema.setSelectedItem(notiiciasTable.getValueAt(notiiciasTable.getSelectedRow(), 4));

            try {
                String sql = "SELECT DESCRIPCION FROM NOTICIAS WHERE ID_NOTICIA = '" + (String.valueOf(notiiciasTable.getValueAt(notiiciasTable.getSelectedRow(), 0))) + "'";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    descripcion.setText(rs.getString(1));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error llenando el combo de SubTema " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una noticia primero", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void obtenerUser(String str) {
        usuario = str;
        autor.setText(usuario);
    }

    public void limpiar() {
        llenarComboTema();
        textID.setText("");
        fechaposteo.setText("YYYY-MM-DD");
        titulo.setText("");
        autor.setText(usuario);
        descripcion.setText("");
    }

    public void guardar() {
        //EXEC UPDATENOTICIA_PROC(0, to_date('2026-01-14', 'yyyy-mm-dd'), 'PRUEBA1', 'PRUEBAAAAAAAAAAAAAAA123456','INTERNACIONAL','America','joviedo');

        String v_id = textID.getText();
        String v_fechaposteo = fechaposteo.getText();
        String v_titulo = titulo.getText();
        String v_descripcion = descripcion.getText();
        String v_temaitem = String.valueOf(tema.getSelectedItem());
        String v_subtemaitem = String.valueOf(subtema.getSelectedItem());
        String v_autor = autor.getText();

        String sql = "CALL UPDATENOTICIA_PROC(" + v_id + ", to_date('" + v_fechaposteo + "', 'yyyy-mm-dd'), '" + v_titulo + "', '" + v_descripcion + "','" + v_temaitem + "','" + v_subtemaitem + "','" + v_autor + "')";

        try {
            var rs = con.prepareCall(sql);
            rs.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el ingreso de la nueva noticia " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        Container = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notiiciasTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        fieldBuscar = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox<>();
        btnAbrir = new javax.swing.JButton();
        Header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        Container1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        Container2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fechaposteo = new javax.swing.JTextField();
        titulo = new javax.swing.JTextField();
        tema = new javax.swing.JComboBox<>();
        subtema = new javax.swing.JComboBox<>();
        autor = new javax.swing.JTextField();
        LabelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        btnCalificar = new javax.swing.JButton();
        rank1 = new javax.swing.JRadioButton();
        rank2 = new javax.swing.JRadioButton();
        rank3 = new javax.swing.JRadioButton();
        rank4 = new javax.swing.JRadioButton();
        rank5 = new javax.swing.JRadioButton();
        Header1 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(1010, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        notiiciasTable.setAutoCreateRowSorter(true);
        notiiciasTable.setForeground(new java.awt.Color(0, 0, 0));
        notiiciasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha Publicación", "Título", "Tema", "SubTema", "Autor", "# Visitas", "# Ranking", "# Comentarios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        notiiciasTable.setGridColor(new java.awt.Color(255, 255, 255));
        notiiciasTable.setMaximumSize(new java.awt.Dimension(675, 0));
        notiiciasTable.setRowHeight(25);
        notiiciasTable.setSelectionBackground(new java.awt.Color(51, 51, 51));
        notiiciasTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        notiiciasTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        notiiciasTable.getTableHeader().setReorderingAllowed(false);
        notiiciasTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notiiciasTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(notiiciasTable);
        if (notiiciasTable.getColumnModel().getColumnCount() > 0) {
            notiiciasTable.getColumnModel().getColumn(0).setMinWidth(10);
            notiiciasTable.getColumnModel().getColumn(0).setPreferredWidth(25);
            notiiciasTable.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        Container.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, 990, 490));

        jLabel1.setText("Buscar por:");
        Container.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 30));

        fieldBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fieldBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldBuscarMouseClicked(evt);
            }
        });
        fieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBuscarKeyTyped(evt);
            }
        });
        Container.add(fieldBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 290, 30));

        btnAgregar.setText("Nuevo");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAgregarMousePressed(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        Container.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 90, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        Container.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 90, -1));

        jLabel2.setText("Buscar:");
        Container.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 60, 30));

        Container.add(comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 170, 30));

        btnAbrir.setText("Ver");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });
        Container.add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 100, -1));

        add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header.setBackground(new java.awt.Color(51, 51, 51));
        Header.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("> Noticias");
        Header.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        Container1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        Container1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 200, 30));

        Container2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Container2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Fecha de Publicación:");
        Container2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, -1));

        jLabel4.setText("Título:");
        Container2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, -1));

        jLabel5.setText("Tema:");
        Container2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, -1));

        jLabel6.setText("SubTema:");
        Container2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, -1));

        jLabel7.setText("Autor:");
        Container2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, -1));

        jLabel8.setText("Cuerpo de la Noticia:");
        Container2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, -1));

        fechaposteo.setText("YYYY-MM-DD");
        fechaposteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaposteoActionPerformed(evt);
            }
        });
        Container2.add(fechaposteo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 260, -1));
        Container2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 260, -1));

        tema.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                temaItemStateChanged(evt);
            }
        });
        Container2.add(tema, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 170, -1));

        Container2.add(subtema, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 170, -1));

        autor.setEditable(false);
        Container2.add(autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 170, -1));

        LabelID.setText("ID:");
        Container2.add(LabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 30, 20));

        textID.setEditable(false);
        textID.setText("0");
        Container2.add(textID, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 80, -1));

        descripcion.setColumns(20);
        descripcion.setRows(10);
        jScrollPane2.setViewportView(descripcion);

        Container2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 760, 220));

        Container1.add(Container2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 970, 430));

        btnCalificar.setText("Calificar");
        Container1.add(btnCalificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 110, -1));

        buttonGroup2.add(rank1);
        rank1.setText("1");
        rank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rank1ActionPerformed(evt);
            }
        });
        Container1.add(rank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 11, -1, -1));

        buttonGroup2.add(rank2);
        rank2.setText("2");
        Container1.add(rank2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 11, -1, 20));

        buttonGroup2.add(rank3);
        rank3.setText("3");
        Container1.add(rank3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 11, -1, 20));

        buttonGroup2.add(rank4);
        rank4.setText("4");
        Container1.add(rank4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 11, -1, 20));

        buttonGroup2.add(rank5);
        rank5.setText("5");
        Container1.add(rank5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 11, -1, 20));

        jPanel1.add(Container1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header1.setBackground(new java.awt.Color(51, 51, 51));
        Header1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setText("> Noticias > Edición");
        Header1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        jPanel1.add(Header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void fieldBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldBuscarMouseClicked

    }//GEN-LAST:event_fieldBuscarMouseClicked

    private void fieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBuscarKeyTyped
        fieldBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                int columna = 0;
                if (comboBox.getSelectedIndex() == 0) {
                    //comboBox ("ID");      
                    columna = 0;
                }
                if (comboBox.getSelectedIndex() == 1) {
                    //comboBox ("Título");   
                    columna = 2;
                }
                if (comboBox.getSelectedIndex() == 2) {
                    //comboBox ("Tema");    
                    columna = 3;
                }
                if (comboBox.getSelectedIndex() == 3) {
                    //comboBox ("SubTema");  
                    columna = 4;
                }
                if (comboBox.getSelectedIndex() == 4) {
                    //comboBox ("Autor"); 
                    columna = 5;
                }
                trsfiltro.setRowFilter(RowFilter.regexFilter(fieldBuscar.getText(), columna));
            }
        });
        trsfiltro = new TableRowSorter(modelo);
        notiiciasTable.setRowSorter(trsfiltro);

    }//GEN-LAST:event_fieldBuscarKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        limpiar();
        Container.setVisible(false);
        Header.setVisible(false);
        jPanel1.setVisible(true);
        LabelID.setVisible(false);
        textID.setText("0");
        textID.setVisible(false);
        llenarComboTema();
        btnGuardar.setVisible(true);
        btnCalificar.setVisible(false);
        rank1.setVisible(false);
        rank2.setVisible(false);
        rank3.setVisible(false);
        rank4.setVisible(false);
        rank5.setVisible(false);

        fechaposteo.setEditable(true);
        titulo.setEditable(true);
        tema.setEnabled(true);
        subtema.setEnabled(true);
        descripcion.setEditable(true);

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked

    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMousePressed

    }//GEN-LAST:event_btnAgregarMousePressed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        limpiar();
        Container.setVisible(true);
        Header.setVisible(true);
        jPanel1.setVisible(false);
        Clear_Table();
        llenarTabla();
    }//GEN-LAST:event_btnBackActionPerformed

    private void fechaposteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaposteoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaposteoActionPerformed

    private void temaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_temaItemStateChanged
        llenarComboSubTema();
    }//GEN-LAST:event_temaItemStateChanged

    private void notiiciasTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notiiciasTableMouseClicked

    }//GEN-LAST:event_notiiciasTableMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (seleccionarFila()) {
            Container.setVisible(false);
            Header.setVisible(false);
            jPanel1.setVisible(true);
            LabelID.setVisible(true);
            textID.setVisible(true);

            btnCalificar.setVisible(false);
            btnGuardar.setVisible(true);
            fechaposteo.setEditable(true);
            titulo.setEditable(true);
            tema.setEnabled(true);
            subtema.setEnabled(true);
            descripcion.setEditable(true);

            rank1.setVisible(false);
            rank2.setVisible(false);
            rank3.setVisible(false);
            rank4.setVisible(false);
            rank5.setVisible(false);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (seleccionarFila()) {
            Container.setVisible(false);
            Header.setVisible(false);
            jPanel1.setVisible(true);
            LabelID.setVisible(true);
            textID.setVisible(true);

            btnCalificar.setVisible(true);

            fechaposteo.setEditable(false);
            titulo.setEditable(false);
            tema.setEnabled(false);
            subtema.setEnabled(false);
            descripcion.setEditable(false);
            btnGuardar.setVisible(false);

            rank1.setVisible(true);
            rank2.setVisible(true);
            rank3.setVisible(true);
            rank4.setVisible(true);
            rank5.setVisible(true);

        }

    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
        limpiar();
        Container.setVisible(true);
        Header.setVisible(true);
        jPanel1.setVisible(false);
        Clear_Table();
        llenarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void rank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rank1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rank1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Container1;
    private javax.swing.JPanel Container2;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Header1;
    private javax.swing.JLabel LabelID;
    private javax.swing.JTextField autor;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCalificar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JTextField fechaposteo;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable notiiciasTable;
    private javax.swing.JRadioButton rank1;
    private javax.swing.JRadioButton rank2;
    private javax.swing.JRadioButton rank3;
    private javax.swing.JRadioButton rank4;
    private javax.swing.JRadioButton rank5;
    private javax.swing.JComboBox<String> subtema;
    private javax.swing.JComboBox<String> tema;
    private javax.swing.JTextField textID;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JTextField titulo;
    // End of variables declaration//GEN-END:variables
}
