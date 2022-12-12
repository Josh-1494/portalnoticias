/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package portalnoticias;

import Modelos.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jovie
 */
public class Configuracion extends javax.swing.JPanel {

    DefaultTableModel modelo;
    ConexionDB cc = new ConexionDB();
    Connection con = cc.getConneccion();

    int val = 0;
    String usuario;

    public Configuracion() {
        initComponents();
        principal();
        llenarComboTema();
        llenarComboRol();
        llenarComboUsuario();
        llenarTablaTema();
        llenarTablaSubTema();
        llenarTablaParametros();
        llenarTablaUsuarios();
        textNomTema.setEditable(true);
    }

    public void obtenerUser(String str) {
        usuario = str;
    }

    public void principal() {
        Principal.setVisible(true);
        Temas.setVisible(false);
        SubTemas.setVisible(false);
        Usuario.setVisible(false);
        Agregar.setVisible(false);
        Parametros.setVisible(false);
    }

    public void llenarComboTema() {
        tema.removeAllItems();
        jComboBox1.removeAllItems();

        try {
            String sql = "SELECT NOMBRETEMA FROM TEMAS ORDER BY NOMBRETEMA ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tema.addItem(rs.getString(1));
                jComboBox1.addItem(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            principal();
            JOptionPane.showMessageDialog(null, "Error llenando el combo de Tema " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiarTema() {
        textNomTema.setEditable(true);
        textNomTema.setText("");
        textDescTema.setText("");
    }

    public void limpiarSubTema() {
        textNomSubTema1.setEditable(true);
        jComboBox1.setSelectedIndex(1);
        textNomSubTema1.setText("");
        textDescSubTema.setText("");
    }

    public void limpiarParametros() {
        jComboBox3.setSelectedIndex(1);
        tema.setSelectedIndex(1);
        jSpinner1.setValue(1);
    }

    public void limpiarUsuarios() {
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField2.setText("");
        jRadioButton1.setSelected(true);
        jComboBox2.setSelectedIndex(1);
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
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error llenando el combo de SubTema " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llenarComboRol() {
        jComboBox2.removeAllItems();

        try {
            String sql = "select NOMBRE_ROL from roles ORDER BY NOMBRE_ROL ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                jComboBox2.addItem(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            principal();
            JOptionPane.showMessageDialog(null, "Error llenando el combo de Roles " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llenarComboUsuario() {
        jComboBox3.removeAllItems();

        try {
            String sql = "SELECT ID_USUARIO FROM USUARIOS ORDER BY ID_USUARIO ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                jComboBox3.addItem(rs.getString(1));
            }
            rs.close();
        } catch (SQLException ex) {
            principal();
            JOptionPane.showMessageDialog(null, "Error llenando el combo de Usuario " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void llenarTablaTema() {
        //SELECT * NOTICIASPORTAL_TABLE_VIEW
        Clear_TableTema();
        try {
            modelo = (DefaultTableModel) jTable1.getModel();

            String sql = "SELECT * FROM TEMAS ORDER BY NOMBRETEMA ASC";
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
            rs.close();
        } catch (SQLException ex) {
            principal();
            JOptionPane.showMessageDialog(null, "Error consultando los Temas " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void llenarTablaSubTema() {
        //SELECT * NOTICIASPORTAL_TABLE_VIEW
        Clear_TableSubTema();
        try {
            modelo = (DefaultTableModel) jTable2.getModel();

            String sql = "SELECT * FROM SUBTEMAS ORDER BY NOMBRESUBTEMA ASC";
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
            rs.close();
        } catch (SQLException ex) {
            principal();
            JOptionPane.showMessageDialog(null, "Error consultando los SubTemas " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void llenarTablaParametros() {
        //SELECT * NOTICIASPORTAL_TABLE_VIEW
        Clear_TableParametros();
        try {
            modelo = (DefaultTableModel) jTable4.getModel();

            String sql = "SELECT ID_USUARIO, NOMBRETEMA, NOMBRESUBTEMA, CANTIDAD  FROM PARAMETROS";
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
            rs.close();
        } catch (SQLException ex) {
            principal();
            JOptionPane.showMessageDialog(null, "Error consultando los Parametros " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void llenarTablaUsuarios() {
        Clear_TableUsuarios();
        try {
            modelo = (DefaultTableModel) jTable3.getModel();

            String sql = "SELECT ID_USUARIO,\n"
                    + "  NOMBRE,\n"
                    + "  PRIMERAPELLIDO,\n"
                    + "  SEGUNDOAPELLIDO,\n"
                    + "  CORREO,\n"
                    + "  ID_NOTIFICACION,\n"
                    + "  NOMBRE_ROL\n"
                    + " FROM USUARIOS";
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
            rs.close();
        } catch (SQLException ex) {
            principal();
            JOptionPane.showMessageDialog(null, "Error consultando los Usuarios " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void seleccionarFilaTema() {
        if (jTable1.getSelectedRow() != -1) {
            textNomTema.setEditable(false);
            textNomTema.setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
            textDescTema.setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 1)));
        }
    }

    public void seleccionarFilaSubTema() {
        if (jTable2.getSelectedRow() != -1) {
            textNomSubTema1.setEditable(false);
            jComboBox1.setSelectedItem(jTable2.getValueAt(jTable2.getSelectedRow(), 2));
            textNomSubTema1.setText(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 0)));
            textDescSubTema.setText(String.valueOf(jTable2.getValueAt(jTable2.getSelectedRow(), 1)));
        }
    }

    public void seleccionarFilaParametros() {
        if (jTable4.getSelectedRow() != -1) {
            jComboBox3.setSelectedItem(jTable4.getValueAt(jTable4.getSelectedRow(), 0));
            tema.setSelectedItem(jTable4.getValueAt(jTable4.getSelectedRow(), 1));
            subtema.setSelectedItem(jTable4.getValueAt(jTable4.getSelectedRow(), 2));
            jSpinner1.setValue(jTable4.getValueAt(jTable4.getSelectedRow(), 3));
        }
    }

    public void seleccionarFilaUsuarios() {
        /*
        0- ID_USUARIO
        1- NOMBRE
        2- PRIMERAPELLIDO
        3- SEGUNDOAPELLIDO
        4- CORREO
        5- ID_NOTIFICACION
        6- NOMBRE_ROL
         */
        if (jTable3.getSelectedRow() != -1) {
            jTextField3.setText(String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 0)));
            jTextField4.setText(String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 1)));
            jTextField5.setText(String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 2)));
            jTextField6.setText(String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 3)));
            jTextField2.setText(String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 4)));

            if ("1".equals(String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 5)))) {
                jRadioButton1.setSelected(true);
            }
            if ("2".equals(String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 5)))) {
                jRadioButton2.setSelected(true);
            }
            if ("3".equals(String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 5)))) {
                jRadioButton3.setSelected(true);
            }

            jComboBox2.setSelectedItem((String.valueOf(jTable3.getValueAt(jTable3.getSelectedRow(), 6))));

        }
    }

    public void agregarTema() {
        Clear_TableTema();

        String v_Tema = textNomTema.getText();
        String v_Descrip = textDescTema.getText();

        String sql = "CALL INSERT_TEMAS_PROC('" + v_Tema + "', '" + v_Descrip + "')";

        try {
            var rs = con.prepareCall(sql);
            rs.execute();
            rs.close();
            llenarTablaTema();
            limpiarTema();
            JOptionPane.showMessageDialog(null, "Accion Completada", "Completado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            llenarTablaTema();
            limpiarTema();
            JOptionPane.showMessageDialog(null, "Error en el registro del Tema " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarSubTema() {
        Clear_TableSubTema();

        String v_subTema = textNomSubTema1.getText();
        String v_Descrip = textDescSubTema.getText();
        String v_tema = String.valueOf(jComboBox1.getSelectedItem());

        String sql = "CALL INSERT_SUBTEMAS_PROC('" + v_subTema + "', '" + v_Descrip + "', '" + v_tema + "')";

        try {
            var rs = con.prepareCall(sql);
            rs.execute();
            rs.close();
            llenarTablaSubTema();
            limpiarSubTema();
            JOptionPane.showMessageDialog(null, "Accion Completada", "Completado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            llenarTablaSubTema();
            limpiarSubTema();
            JOptionPane.showMessageDialog(null, "Error en el registro del SubTema " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarParametro() {
        Clear_TableParametros();

        String v_Tema = String.valueOf(tema.getSelectedItem());
        String v_SubTema = String.valueOf(subtema.getSelectedItem());
        String v_usuario = String.valueOf(jComboBox3.getSelectedItem());
        String v_cantidad = String.valueOf(jSpinner1.getValue());

        String sql = "CALL INSERT_PARAM_PROC('" + v_Tema + "', '" + v_SubTema + "', '" + v_usuario + "', '" + v_cantidad + "')";

        try {
            var rs = con.prepareCall(sql);
            rs.execute();
            rs.close();
            llenarTablaParametros();
            limpiarParametros();
            JOptionPane.showMessageDialog(null, "Accion Completada", "Completado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            llenarTablaParametros();
            limpiarParametros();
            JOptionPane.showMessageDialog(null, "Error en el registro del parametro " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardar() {
        String pass1 = String.valueOf(jPasswordField1.getPassword());
        String pass2 = String.valueOf(jPasswordField2.getPassword());
        
        if (pass1.equals(pass2)) {
            if (val == 0) {
                nuevo();
            } else {
                modificar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void nuevo() {
        
    }

    public void modificar() {
        
    }

    private void Clear_TableTema() {
        modelo = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    private void Clear_TableSubTema() {
        modelo = (DefaultTableModel) jTable2.getModel();
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    private void Clear_TableParametros() {
        modelo = (DefaultTableModel) jTable4.getModel();
        for (int i = 0; i < jTable4.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    private void Clear_TableUsuarios() {
        modelo = (DefaultTableModel) jTable3.getModel();
        for (int i = 0; i < jTable3.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        Principal = new javax.swing.JPanel();
        Container1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnTemas = new javax.swing.JButton();
        btnSubTemas = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnAgregarr = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Header1 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Temas = new javax.swing.JPanel();
        Container2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        title3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        textNomTema = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        textDescTema = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSubTema = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        Header2 = new javax.swing.JPanel();
        title4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        SubTemas = new javax.swing.JPanel();
        Container6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        title8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        textDescSubTema = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        textNomSubTema1 = new javax.swing.JTextField();
        btnSubTema1 = new javax.swing.JButton();
        btnBack2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        Header6 = new javax.swing.JPanel();
        title9 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        Usuario = new javax.swing.JPanel();
        Container4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnBack3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Header4 = new javax.swing.JPanel();
        title6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        Agregar = new javax.swing.JPanel();
        Container7 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        title12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        btnBack5 = new javax.swing.JButton();
        Header7 = new javax.swing.JPanel();
        title10 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        Parametros = new javax.swing.JPanel();
        Container5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnBack4 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        title11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel18 = new javax.swing.JLabel();
        tema = new javax.swing.JComboBox<>();
        subtema = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        Header5 = new javax.swing.JPanel();
        title7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(1010, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Apartados");
        jPanel2.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTemas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTemas.setText("Temas");
        btnTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemasActionPerformed(evt);
            }
        });
        jPanel3.add(btnTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 300, 30));

        btnSubTemas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSubTemas.setText("SubTemas");
        btnSubTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubTemasActionPerformed(evt);
            }
        });
        jPanel3.add(btnSubTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 300, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 380, 90));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregarr.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregarr.setText("Agregar");
        btnAgregarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarrActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 300, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Parámetros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 300, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 380, 90));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuarios");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 380, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Categoria de Noticias");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 92, 380, 30));

        Container1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 440, 420));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgConfig.png"))); // NOI18N
        Container1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        Principal.add(Container1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header1.setBackground(new java.awt.Color(51, 51, 51));
        Header1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setText("> Configuración del Sistema");
        Header1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        Principal.add(Header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(Principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Temas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tema", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Container2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 430, 420));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgConfig.png"))); // NOI18N
        Container2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title3.setForeground(new java.awt.Color(255, 255, 255));
        title3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title3.setText("Temas");
        jPanel6.add(title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(textNomTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 340, 30));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 380, 90));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(textDescTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 340, 30));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 380, 90));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripción:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 380, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre de Tema:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 92, 380, 30));

        Container2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 440, 420));

        btnSubTema.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSubTema.setText("Agregar");
        btnSubTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubTemaActionPerformed(evt);
            }
        });
        Container2.add(btnSubTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 140, 30));

        btnBack1.setText("Regresar");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        Container2.add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnLimpiar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        Container2.add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 140, 30));

        Temas.add(Container2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header2.setBackground(new java.awt.Color(51, 51, 51));
        Header2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title4.setForeground(new java.awt.Color(255, 255, 255));
        title4.setText("> Configuración del Sistema > Noticias - Temas");
        Header2.add(title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        Temas.add(Header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(Temas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SubTemas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SubTema", "Descripción", "Tema"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        Container6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 430, 420));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgConfig.png"))); // NOI18N
        Container6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title8.setForeground(new java.awt.Color(255, 255, 255));
        title8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title8.setText("SubTemas");
        jPanel10.add(title8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 340, 30));

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 380, 50));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel12.add(textDescSubTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 340, 30));

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 380, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Descripción:");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 380, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tema:");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 380, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nombre de SubTema:");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 380, 30));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel13.add(textNomSubTema1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 340, 30));

        jPanel9.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 380, 50));

        Container6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 440, 420));

        btnSubTema1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSubTema1.setText("Agregar");
        btnSubTema1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubTema1ActionPerformed(evt);
            }
        });
        Container6.add(btnSubTema1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 140, 30));

        btnBack2.setText("Regresar");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });
        Container6.add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnLimpiar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimpiar2.setText("Limpiar");
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });
        Container6.add(btnLimpiar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 140, 30));

        SubTemas.add(Container6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header6.setBackground(new java.awt.Color(51, 51, 51));
        Header6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title9.setForeground(new java.awt.Color(255, 255, 255));
        title9.setText("> Configuración del Sistema > Noticias - SubTemas");
        Header6.add(title9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header6.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        SubTemas.add(Header6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(SubTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Usuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "Nombre", "Primer Apellido", "Segundo Apellido", "Correo", "Tipo Notificación", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        Container4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 940, 470));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgConfig.png"))); // NOI18N
        Container4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        btnBack3.setText("Regresar");
        btnBack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack3ActionPerformed(evt);
            }
        });
        Container4.add(btnBack3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Container4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 100, -1));

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Container4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 100, -1));

        Usuario.add(Container4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header4.setBackground(new java.awt.Color(51, 51, 51));
        Header4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title6.setForeground(new java.awt.Color(255, 255, 255));
        title6.setText("> Configuración del Sistema > Usuarios - Edición");
        Header4.add(title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        Usuario.add(Header4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Agregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Guardar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 393, 220, 30));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title12.setForeground(new java.awt.Color(255, 255, 255));
        title12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title12.setText("Datos de Usuario");
        jPanel17.add(title12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 50));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 50));

        jLabel7.setText("Usuario:");
        jPanel16.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 20));

        jLabel19.setText("Nombre:");
        jPanel16.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 150, 20));

        jLabel20.setText("Primer Apellido:");
        jPanel16.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 150, 20));

        jLabel21.setText("Segundo Apellido:");
        jPanel16.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 20));

        jLabel22.setText("Correo:");
        jPanel16.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 150, 20));

        jLabel23.setText("Notificación de Correo:");
        jPanel16.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, -1));

        jLabel24.setText("Rol:");
        jPanel16.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, 20));

        jLabel25.setText("Contraseña:");
        jPanel16.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 120, 20));

        jLabel26.setText("Repetir Contraseña:");
        jPanel16.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 120, 20));
        jPanel16.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 210, -1));
        jPanel16.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 210, -1));
        jPanel16.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 210, -1));
        jPanel16.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 210, -1));
        jPanel16.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 210, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("No desea recibir notificaciones");
        jPanel16.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Tema y SubTema");
        jPanel16.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Por Autor");
        jPanel16.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        jPanel16.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 210, -1));
        jPanel16.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 180, -1));
        jPanel16.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 180, -1));

        Container7.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 720, 450));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgConfig.png"))); // NOI18N
        Container7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        btnBack5.setText("Regresar");
        btnBack5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack5ActionPerformed(evt);
            }
        });
        Container7.add(btnBack5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        Agregar.add(Container7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header7.setBackground(new java.awt.Color(51, 51, 51));
        Header7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title10.setForeground(new java.awt.Color(255, 255, 255));
        title10.setText("> Configuración del Sistema > Usuarios - Edición");
        Header7.add(title10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header7.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        Agregar.add(Header7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Parametros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setAutoCreateRowSorter(true);
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Tema", "SubTema", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        Container5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 67, 440, 420));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgConfig.png"))); // NOI18N
        Container5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, -1, -1));

        btnBack4.setText("Regresar");
        btnBack4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack4ActionPerformed(evt);
            }
        });
        Container5.add(btnBack4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title11.setForeground(new java.awt.Color(255, 255, 255));
        title11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title11.setText("Parámetros de Usuario");
        jPanel15.add(title11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Catidad de Noticias:");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 180, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Usuario:");
        jPanel14.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tema:");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 180, 30));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 16, 1));
        jPanel14.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 242, 90, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("SubTema:");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 180, 30));

        tema.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                temaItemStateChanged(evt);
            }
        });
        jPanel14.add(tema, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 220, 30));

        jPanel14.add(subtema, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 220, 30));

        jPanel14.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 220, 30));

        Container5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 440, 420));

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        Container5.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 140, 30));

        btnSubmit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSubmit.setText("Guardar");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        Container5.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 140, 30));

        Parametros.add(Container5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header5.setBackground(new java.awt.Color(51, 51, 51));
        Header5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title7.setForeground(new java.awt.Color(255, 255, 255));
        title7.setText("> Configuración del Sistema > Usuarios - Parámetros");
        Header5.add(title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        Parametros.add(Header5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(Parametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemasActionPerformed
        llenarTablaTema();
        Principal.setVisible(false);
        Temas.setVisible(true);
        SubTemas.setVisible(false);
        Usuario.setVisible(false);
        Agregar.setVisible(false);
        Parametros.setVisible(false);

    }//GEN-LAST:event_btnTemasActionPerformed

    private void btnAgregarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarrActionPerformed

        Principal.setVisible(false);
        Temas.setVisible(false);
        SubTemas.setVisible(false);
        Usuario.setVisible(true);
        Agregar.setVisible(false);
        Parametros.setVisible(false);
    }//GEN-LAST:event_btnAgregarrActionPerformed

    private void temaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_temaItemStateChanged
        llenarComboSubTema();
    }//GEN-LAST:event_temaItemStateChanged

    private void btnSubTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubTemasActionPerformed
        limpiarSubTema();
        llenarTablaSubTema();
        Principal.setVisible(false);
        Temas.setVisible(false);
        SubTemas.setVisible(true);
        Usuario.setVisible(false);
        Agregar.setVisible(false);
        Parametros.setVisible(false);
    }//GEN-LAST:event_btnSubTemasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiarParametros();
        llenarTablaParametros();
        Principal.setVisible(false);
        Temas.setVisible(false);
        SubTemas.setVisible(false);
        Usuario.setVisible(false);
        Agregar.setVisible(false);
        Parametros.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        principal();
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        principal();
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void btnBack3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack3ActionPerformed
        principal();
    }//GEN-LAST:event_btnBack3ActionPerformed

    private void btnBack4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack4ActionPerformed
        principal();
    }//GEN-LAST:event_btnBack4ActionPerformed

    private void btnBack5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack5ActionPerformed
        seleccionarFilaUsuarios();
        Principal.setVisible(false);
        Temas.setVisible(false);
        SubTemas.setVisible(false);
        Usuario.setVisible(true);
        Agregar.setVisible(false);
        Parametros.setVisible(false);
    }//GEN-LAST:event_btnBack5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarUsuarios();
        jTextField3.setEnabled(true);
        Principal.setVisible(false);
        Temas.setVisible(false);
        SubTemas.setVisible(false);
        Usuario.setVisible(false);
        Agregar.setVisible(true);
        Parametros.setVisible(false);
        val = 1;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField3.setEnabled(false);
        Principal.setVisible(false);
        Temas.setVisible(false);
        SubTemas.setVisible(false);
        Usuario.setVisible(false);
        Agregar.setVisible(true);
        Parametros.setVisible(false);
        val = 0;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        limpiarTema();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        limpiarSubTema();

    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        limpiarParametros();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        seleccionarFilaTema();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnSubTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubTemaActionPerformed
        agregarTema();

    }//GEN-LAST:event_btnSubTemaActionPerformed

    private void btnSubTema1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubTema1ActionPerformed
        agregarSubTema();

    }//GEN-LAST:event_btnSubTema1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        seleccionarFilaSubTema();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        seleccionarFilaParametros();
    }//GEN-LAST:event_jTable4MouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        agregarParametro();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        seleccionarFilaUsuarios();
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agregar;
    private javax.swing.JPanel Container1;
    private javax.swing.JPanel Container2;
    private javax.swing.JPanel Container4;
    private javax.swing.JPanel Container5;
    private javax.swing.JPanel Container6;
    private javax.swing.JPanel Container7;
    private javax.swing.JPanel Header1;
    private javax.swing.JPanel Header2;
    private javax.swing.JPanel Header4;
    private javax.swing.JPanel Header5;
    private javax.swing.JPanel Header6;
    private javax.swing.JPanel Header7;
    private javax.swing.JPanel Parametros;
    private javax.swing.JPanel Principal;
    private javax.swing.JPanel SubTemas;
    private javax.swing.JPanel Temas;
    private javax.swing.JPanel Usuario;
    private javax.swing.JButton btnAgregarr;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnBack3;
    private javax.swing.JButton btnBack4;
    private javax.swing.JButton btnBack5;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnSubTema;
    private javax.swing.JButton btnSubTema1;
    private javax.swing.JButton btnSubTemas;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnTemas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JComboBox<String> subtema;
    private javax.swing.JComboBox<String> tema;
    private javax.swing.JTextField textDescSubTema;
    private javax.swing.JTextField textDescTema;
    private javax.swing.JTextField textNomSubTema1;
    private javax.swing.JTextField textNomTema;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title10;
    private javax.swing.JLabel title11;
    private javax.swing.JLabel title12;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JLabel title6;
    private javax.swing.JLabel title7;
    private javax.swing.JLabel title8;
    private javax.swing.JLabel title9;
    // End of variables declaration//GEN-END:variables
}
