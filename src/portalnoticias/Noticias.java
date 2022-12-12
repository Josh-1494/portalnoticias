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
        jPanel2.setVisible(false);
        LabelID.setVisible(false);
        textID.setVisible(false);
        jPanel6.setVisible(false);
        jPanel4.setVisible(false);
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
            rs.close();
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
            rs.close();
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
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error llenando el combo de SubTema " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Clear_Table() {
        modelo = (DefaultTableModel) notiiciasTable.getModel();
        for (int i = 0; i < notiiciasTable.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }
    
    private void Clear_Table2() {
        modelo = (DefaultTableModel) cometaioTable.getModel();
        for (int i = 0; i < cometaioTable.getRowCount(); i++) {
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
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error llenando el combo de SubTema " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una noticia primero", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public void seleccionarFilaComentario() {
        if (cometaioTable.getSelectedRow() != -1) {
            usComentario.setText(String.valueOf(cometaioTable.getValueAt(cometaioTable.getSelectedRow(), 0)));
            fechaPostComenta.setText(String.valueOf(cometaioTable.getValueAt(cometaioTable.getSelectedRow(), 1)));
            ComentarioCompleto.setText(String.valueOf(cometaioTable.getValueAt(cometaioTable.getSelectedRow(), 2)));
        }
    }

    public void obtenerUser(String str) {
        usuario = str;
        autor.setText(usuario);
        comentarioUsuario.setText(usuario);
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
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el ingreso de la nueva noticia " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void agregarVisitas() {
        String v_id = textID.getText();
        String v_usuario = autor.getText();

        String sql = "CALL UPDATE_VISTAS_PROC('" + v_id + "', '" + v_usuario + "')";

        try {
            var rs = con.prepareCall(sql);
            rs.execute();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro de la Visita " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarRanking() {
        String ranking = "1";
        String v_id = textID.getText();
        String v_usuario = autor.getText();

        if (calificarVal()) {

            if (rank1.isSelected()) {
                ranking = "1";
            }
            if (rank2.isSelected()) {
                ranking = "2";
            }
            if (rank3.isSelected()) {
                ranking = "3";
            }
            if (rank4.isSelected()) {
                ranking = "4";
            }
            if (rank5.isSelected()) {
                ranking = "5";
            }

            String sql = "CALL UPDATE_HISTORIALRANKING_PROC( '" + ranking + "', '" + v_id + "', '" + v_usuario + "')";

            try {
                var rs = con.prepareCall(sql);
                rs.execute();
                rs.close();
                JOptionPane.showMessageDialog(null, "Calificacion Completada, Gracias.", "Calificacion Completada", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en el registro de la Calificación " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean calificarVal() {
        if (rank1.isSelected() || rank2.isSelected() || rank3.isSelected() || rank4.isSelected() || rank5.isSelected()) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un numero del Ranking", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void llenarEnvioPane() {
        textID1.setText(textID.getText());
        fechaposteo1.setText(fechaposteo.getText());
        titulo1.setText(titulo.getText());
        descripcion1.setText(descripcion.getText());
        tema1.setText(String.valueOf(tema.getSelectedItem()));
        //subTema1.setText(String.valueOf(subtema.getSelectedItem()));
        autor1.setText(autor.getText());
    }

    public void enviarCorreo() {
        String conCo = "0";
        String v_destinatario = destinatario.getText();
        conCo = conCopia.getText();
        String v_idNoticia = textID.getText();
        String v_usuario = autor.getText();

        if (!v_destinatario.isBlank()) {

            if (conCo.length() < 5) {
                conCo = "0";
            }

            String sql = "CALL UPDATE_HISTORIALENVIOS_PROC( '" + v_destinatario + "', '" + conCo + "', '" + v_usuario + "', '" + v_idNoticia + "')";

            try {
                var rs = con.prepareCall(sql);
                rs.execute();
                rs.close();
                JOptionPane.showMessageDialog(null, "Correo enviado.", "Envio Completado", JOptionPane.INFORMATION_MESSAGE);
                destinatario.setText("");
                conCopia.setText("");
                jPanel1.setVisible(true);
                jPanel2.setVisible(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en el renvio de la noticia." + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe especificar un Destinatario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarComentario() {
        String v_idNoticia = textID.getText();
        String v_usuario = comentarioUsuario.getText();
        String comentario = jTextArea2.getText();

        if (comentario.length() > 0) {

            String sql = "CALL UPDATE_COMENTARIO_PROC( '" + comentario + "', '" + v_usuario + "', '" + v_idNoticia + "')";

            try {
                var rs = con.prepareCall(sql);
                rs.execute();
                rs.close();
                JOptionPane.showMessageDialog(null, "Comentario agregado.", "Completado", JOptionPane.INFORMATION_MESSAGE);
                jTextArea2.setText("");
                jPanel6.setVisible(false);
                jPanel4.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en el renvio de la noticia." + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe escribir un comentario primero", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void limpiarComentarios() {
        llenarComboTema();
        usComentario.setText("");
        fechaPostComenta.setText("YYYY-MM-DD");
        ComentarioCompleto.setText("");
    }
    
    public void llenarTablaComentarios() {
        //SELECT * NOTICIASPORTAL_TABLE_VIEW
        String v_idNoticia = textID.getText();
        
        try {
            modelo = (DefaultTableModel) cometaioTable.getModel();

            String sql = "SELECT \n" +
                        "  ID_USUARIO,\n" +
                        "  FECHACOMENTARIO,\n" +
                        "  DESCRIPCION\n" +
                        "FROM COMENTARIOS \n" +
                        "WHERE ID_NOTICIA = " + v_idNoticia + " ORDER BY FECHACOMENTARIO DESC";
            
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
            JOptionPane.showMessageDialog(null, "Error consultando los comentarios " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        jPanel2 = new javax.swing.JPanel();
        Container3 = new javax.swing.JPanel();
        btnBack1 = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();
        Container4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        fechaposteo1 = new javax.swing.JTextField();
        titulo1 = new javax.swing.JTextField();
        autor1 = new javax.swing.JTextField();
        LabelID1 = new javax.swing.JLabel();
        textID1 = new javax.swing.JTextField();
        tema1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcion1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        destinatario = new javax.swing.JTextField();
        conCopia = new javax.swing.JTextField();
        Header2 = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
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
        btnEnviar = new javax.swing.JButton();
        btnComentarios = new javax.swing.JButton();
        title4 = new javax.swing.JLabel();
        Header1 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
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
        jPanel4 = new javax.swing.JPanel();
        Container5 = new javax.swing.JPanel();
        btnBack2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        cometaioTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        usComentario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        fechaPostComenta = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ComentarioCompleto = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        title5 = new javax.swing.JLabel();
        btnComentario = new javax.swing.JToggleButton();
        Header3 = new javax.swing.JPanel();
        title3 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        comentarioUsuario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        title6 = new javax.swing.JLabel();
        Header4 = new javax.swing.JPanel();
        title7 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setPreferredSize(new java.awt.Dimension(1010, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack1.setText("Regresar");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        Container3.add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnGuardar1.setText("Enviar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        Container3.add(btnGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 200, 30));

        Container4.setBackground(new java.awt.Color(255, 255, 255));
        Container4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Container4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Fecha de Publicación:");
        Container4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, -1));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Título:");
        Container4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, -1));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tema:");
        Container4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, -1));

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Autor:");
        Container4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, -1));

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Cuerpo de la Noticia:");
        Container4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, -1));

        fechaposteo1.setEditable(false);
        fechaposteo1.setText("YYYY-MM-DD");
        fechaposteo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaposteo1ActionPerformed(evt);
            }
        });
        Container4.add(fechaposteo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 260, -1));

        titulo1.setEditable(false);
        Container4.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 260, -1));

        autor1.setEditable(false);
        Container4.add(autor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 170, -1));

        LabelID1.setForeground(new java.awt.Color(0, 0, 0));
        LabelID1.setText("ID:");
        Container4.add(LabelID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 20));

        textID1.setEditable(false);
        textID1.setText("0");
        Container4.add(textID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 80, -1));

        tema1.setEditable(false);
        Container4.add(tema1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 170, -1));

        descripcion1.setEditable(false);
        descripcion1.setColumns(20);
        descripcion1.setRows(10);
        jScrollPane3.setViewportView(descripcion1);

        Container4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 760, 70));

        Container3.add(Container4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 970, 270));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setText("Destinatario:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 20));

        jLabel16.setText("Cc:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 20));
        jPanel3.add(destinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 320, -1));
        jPanel3.add(conCopia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 320, -1));

        Container3.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 970, 110));

        jPanel2.add(Container3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header2.setBackground(new java.awt.Color(51, 51, 51));
        Header2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setText("> Noticias > Detalle de la Noticia > Compartir");
        Header2.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        jPanel2.add(Header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        btnCalificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalificarActionPerformed(evt);
            }
        });
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

        btnEnviar.setText("Compartir");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        Container1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 120, 30));

        btnComentarios.setText("Ver Comentarios");
        btnComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentariosActionPerformed(evt);
            }
        });
        Container1.add(btnComentarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 120, 30));

        title4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title4.setForeground(new java.awt.Color(255, 255, 255));
        title4.setText("Detalles");
        Container1.add(title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 280, 30));

        jPanel1.add(Container1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header1.setBackground(new java.awt.Color(51, 51, 51));
        Header1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setText("> Noticias > Detalle de la Noticia");
        Header1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        jPanel1.add(Header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack2.setText("Regresar");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });
        Container5.add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        cometaioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Fecha Posteo", "Comentario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cometaioTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cometaioTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(cometaioTable);
        if (cometaioTable.getColumnModel().getColumnCount() > 0) {
            cometaioTable.getColumnModel().getColumn(0).setPreferredWidth(17);
            cometaioTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            cometaioTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        }

        Container5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 540, 440));

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Usuario:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 20));

        usComentario.setEditable(false);
        jPanel5.add(usComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 220, -1));

        jLabel17.setText("Fecha Posteo:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 20));

        fechaPostComenta.setEditable(false);
        jPanel5.add(fechaPostComenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 220, -1));

        jLabel18.setText("Comentario:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, -1));

        ComentarioCompleto.setEditable(false);
        ComentarioCompleto.setColumns(20);
        ComentarioCompleto.setRows(10);
        jScrollPane5.setViewportView(ComentarioCompleto);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 380, 200));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title5.setBackground(new java.awt.Color(51, 51, 51));
        title5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title5.setForeground(new java.awt.Color(255, 255, 255));
        title5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title5.setText("Comentario Completo");
        jPanel7.add(title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 40));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, 40));

        Container5.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 420, 440));

        btnComentario.setText("Agregar Comentario");
        btnComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentarioActionPerformed(evt);
            }
        });
        Container5.add(btnComentario, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, -1, -1));

        jPanel4.add(Container5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header3.setBackground(new java.awt.Color(51, 51, 51));
        Header3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title3.setForeground(new java.awt.Color(255, 255, 255));
        title3.setText("> Noticias > Detalle de la Noticia > Comentarios");
        Header3.add(title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        jPanel4.add(Header3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Usuario:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 60, 20));

        comentarioUsuario.setEditable(false);
        comentarioUsuario.setEnabled(false);
        jPanel6.add(comentarioUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 190, -1));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Comentario:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 100, -1));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(10);
        jScrollPane6.setViewportView(jTextArea2);

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 380, 170));

        title6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title6.setForeground(new java.awt.Color(255, 255, 255));
        title6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title6.setText("Agregar Comentario");
        jPanel6.add(title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 450, 40));

        Header4.setBackground(new java.awt.Color(51, 51, 51));
        Header4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title7.setForeground(new java.awt.Color(255, 255, 255));
        title7.setText("> Noticias > Detalle de la Noticia > Agregar Comentario");
        Header4.add(title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        jPanel6.add(Header4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton1.setText("Agregar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, -1));

        jToggleButton2.setText("Cancelar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 450, 420));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 620));
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
        btnEnviar.setVisible(false);
        btnComentarios.setVisible(false);
        rank1.setVisible(false);
        rank2.setVisible(false);
        rank3.setVisible(false);
        rank4.setVisible(false);
        rank5.setVisible(false);
        title4.setText("Agregar Noticia");

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
            title4.setText("Modificar Noticia");
            btnCalificar.setVisible(false);
            btnGuardar.setVisible(true);
            btnEnviar.setVisible(false);
            btnComentarios.setVisible(false);

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
            title4.setText("Información Detallada");
            btnCalificar.setVisible(true);

            fechaposteo.setEditable(false);
            titulo.setEditable(false);
            tema.setEnabled(false);
            subtema.setEnabled(false);
            descripcion.setEditable(false);
            btnGuardar.setVisible(false);
            btnEnviar.setVisible(true);
            btnComentarios.setVisible(true);

            rank1.setVisible(true);
            rank2.setVisible(true);
            rank3.setVisible(true);
            rank4.setVisible(true);
            rank5.setVisible(true);

            agregarVisitas();

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

    private void btnCalificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificarActionPerformed
        agregarRanking();
        Clear_Table();
        llenarTabla();
    }//GEN-LAST:event_btnCalificarActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        enviarCorreo();

    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void fechaposteo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaposteo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaposteo1ActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        llenarEnvioPane();
        Clear_Table();
        llenarTabla();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        jPanel1.setVisible(true);
        jPanel4.setVisible(false);
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void btnComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentariosActionPerformed
        jPanel1.setVisible(false);
        jPanel4.setVisible(true);
        limpiarComentarios();
        Clear_Table2();
        llenarTablaComentarios();
        Clear_Table();
        llenarTabla();
    }//GEN-LAST:event_btnComentariosActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        jPanel6.setVisible(false);
        jPanel4.setVisible(true);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void btnComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentarioActionPerformed
        jPanel6.setVisible(true);
        jPanel4.setVisible(false);
    }//GEN-LAST:event_btnComentarioActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        Clear_Table2();
        agregarComentario();
        limpiarComentarios();
        llenarTablaComentarios();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void cometaioTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cometaioTableMouseClicked
        seleccionarFilaComentario();
    }//GEN-LAST:event_cometaioTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ComentarioCompleto;
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Container1;
    private javax.swing.JPanel Container2;
    private javax.swing.JPanel Container3;
    private javax.swing.JPanel Container4;
    private javax.swing.JPanel Container5;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Header1;
    private javax.swing.JPanel Header2;
    private javax.swing.JPanel Header3;
    private javax.swing.JPanel Header4;
    private javax.swing.JLabel LabelID;
    private javax.swing.JLabel LabelID1;
    private javax.swing.JTextField autor;
    private javax.swing.JTextField autor1;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnCalificar;
    private javax.swing.JToggleButton btnComentario;
    private javax.swing.JButton btnComentarios;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JTextField comentarioUsuario;
    private javax.swing.JTable cometaioTable;
    private javax.swing.JTextField conCopia;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JTextArea descripcion1;
    private javax.swing.JTextField destinatario;
    private javax.swing.JTextField fechaPostComenta;
    private javax.swing.JTextField fechaposteo;
    private javax.swing.JTextField fechaposteo1;
    private javax.swing.JTextField fieldBuscar;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTable notiiciasTable;
    private javax.swing.JRadioButton rank1;
    private javax.swing.JRadioButton rank2;
    private javax.swing.JRadioButton rank3;
    private javax.swing.JRadioButton rank4;
    private javax.swing.JRadioButton rank5;
    private javax.swing.JComboBox<String> subtema;
    private javax.swing.JComboBox<String> tema;
    private javax.swing.JTextField tema1;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textID1;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JLabel title5;
    private javax.swing.JLabel title6;
    private javax.swing.JLabel title7;
    private javax.swing.JTextField titulo;
    private javax.swing.JTextField titulo1;
    private javax.swing.JTextField usComentario;
    // End of variables declaration//GEN-END:variables
}
