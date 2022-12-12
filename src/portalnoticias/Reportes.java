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
public class Reportes extends javax.swing.JPanel {

    DefaultTableModel modelo;
    ConexionDB cc = new ConexionDB();
    Connection con = cc.getConneccion();

    private TableRowSorter trsfiltro;

    Main main = new Main();

    String usuario;

    public Reportes() {
        initComponents();
        principal.setVisible(true);
        reporte1.setVisible(false);
        reporte2.setVisible(false);
        reporte3.setVisible(false);
        reporte4.setVisible(false);
        Clear_Table();
    }

    private void Clear_Table() {
        modelo = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }

        modelo = (DefaultTableModel) jTable2.getModel();
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }

        modelo = (DefaultTableModel) jTable3.getModel();
        for (int i = 0; i < jTable3.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }

        modelo = (DefaultTableModel) jTable4.getModel();
        for (int i = 0; i < jTable4.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void obtenerUser(String str) {
        usuario = str;
    }

    public void principal() {
        principal.setVisible(true);
        reporte1.setVisible(false);
        reporte2.setVisible(false);
        reporte3.setVisible(false);
        reporte4.setVisible(false);
    }

    public void reporte4() {
        try {
            modelo = (DefaultTableModel) jTable4.getModel();

            String sql = "SELECT * FROM REPORTE4_VIEW";
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
            JOptionPane.showMessageDialog(null, "rror generando el Reporte " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void reporte2() {
        try {
            modelo = (DefaultTableModel) jTable2.getModel();

            String sql = "SELECT ID_NOTICIA, FECHAVISITA, ID_USUARIO FROM VISITAS";
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
            JOptionPane.showMessageDialog(null, "Error generando el Reporte " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void reporte3() {
        try {
            modelo = (DefaultTableModel) jTable3.getModel();

            String sql = "SELECT ID_NOTICIA, FECHARANKING, RANKING, ID_USUARIO FROM HISTORIALRANKING";
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
            JOptionPane.showMessageDialog(null, "Error generando el Reporte " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void reporte1() {
        try {
            modelo = (DefaultTableModel) jTable1.getModel();

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
            JOptionPane.showMessageDialog(null, "Error generando el Reporte " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

        principal = new javax.swing.JPanel();
        Container1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        btnReporte1 = new javax.swing.JButton();
        btnReporte2 = new javax.swing.JButton();
        btnReporte3 = new javax.swing.JButton();
        btnReporte4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Header1 = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        reporte1 = new javax.swing.JPanel();
        Container2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        title3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();
        Header2 = new javax.swing.JPanel();
        title4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        reporte2 = new javax.swing.JPanel();
        Container3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        title5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBack2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        idNoticia1 = new javax.swing.JTextField();
        Header3 = new javax.swing.JPanel();
        title6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        reporte3 = new javax.swing.JPanel();
        Container4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        title7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBack3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        idNoticia2 = new javax.swing.JTextField();
        Header4 = new javax.swing.JPanel();
        title8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        reporte4 = new javax.swing.JPanel();
        Container5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        title9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBack4 = new javax.swing.JButton();
        Header5 = new javax.swing.JPanel();
        title10 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(1010, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        title2.setText("Selección de Reportes");
        jPanel2.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        btnReporte1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReporte1.setText("Estadisticas de Noticias");
        btnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 260, 40));

        btnReporte2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReporte2.setText("Vistas por Noticia");
        btnReporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 260, 40));

        btnReporte3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReporte3.setText("Ranking por Noticia");
        btnReporte3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 260, 40));

        btnReporte4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReporte4.setText("Top 20 Noticias con mejor Ranking");
        btnReporte4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 260, 40));

        Container1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 440, 420));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgReporte.png"))); // NOI18N
        Container1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        principal.add(Container1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header1.setBackground(new java.awt.Color(51, 51, 51));
        Header1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setText("> Generacion de Reportes");
        Header1.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        principal.add(Header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        reporte1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Publicación", "Titulo", "Tema", "SubTema", "Autor", "# Visitas", "Calificación", "# Comentarios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(10);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(35);
        }

        Container2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 860, 410));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title3.setForeground(new java.awt.Color(255, 255, 255));
        title3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title3.setText("Estadisticas Generales de Noticias");
        jPanel4.add(title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));

        Container2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 860, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgReporte.png"))); // NOI18N
        Container2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        btnBack1.setText("Regresar");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        Container2.add(btnBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        reporte1.add(Container2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header2.setBackground(new java.awt.Color(51, 51, 51));
        Header2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title4.setForeground(new java.awt.Color(255, 255, 255));
        title4.setText("> Generacion de Reportes ");
        Header2.add(title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        reporte1.add(Header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(reporte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        reporte2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Noticia", "Fecha y Hora", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        Container3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 850, 410));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title5.setForeground(new java.awt.Color(255, 255, 255));
        title5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title5.setText("Detalle de Vistas Por Noticia");
        jPanel5.add(title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 40));

        Container3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 850, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgReporte.png"))); // NOI18N
        Container3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        btnBack2.setText("Regresar");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });
        Container3.add(btnBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setText("Noticia ID:");
        Container3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 60, 30));

        idNoticia1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        idNoticia1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idNoticia1KeyTyped(evt);
            }
        });
        Container3.add(idNoticia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 100, 30));

        reporte2.add(Container3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header3.setBackground(new java.awt.Color(51, 51, 51));
        Header3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title6.setForeground(new java.awt.Color(255, 255, 255));
        title6.setText("> Generacion de Reportes ");
        Header3.add(title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        reporte2.add(Header3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(reporte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        reporte3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setAutoCreateRowSorter(true);
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Noticia", "Fecha Ranking", "Ranking", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        Container4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 860, 410));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title7.setForeground(new java.awt.Color(255, 255, 255));
        title7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title7.setText("Detalle de Calificaciones/Ranking Por Noticia");
        jPanel6.add(title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));

        Container4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 860, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgReporte.png"))); // NOI18N
        Container4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        btnBack3.setText("Regresar");
        btnBack3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack3ActionPerformed(evt);
            }
        });
        Container4.add(btnBack3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setText("Noticia ID:");
        Container4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 60, 30));

        idNoticia2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        idNoticia2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idNoticia2KeyTyped(evt);
            }
        });
        Container4.add(idNoticia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 100, 30));

        reporte3.add(Container4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header4.setBackground(new java.awt.Color(51, 51, 51));
        Header4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title8.setForeground(new java.awt.Color(255, 255, 255));
        title8.setText("> Generacion de Reportes ");
        Header4.add(title8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        reporte3.add(Header4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(reporte3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        reporte4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setAutoCreateRowSorter(true);
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Noticia", "Título", "Autor", "Promedio Ranking", "Fecha de Publicación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(0).setMinWidth(15);
            jTable4.getColumnModel().getColumn(0).setPreferredWidth(65);
            jTable4.getColumnModel().getColumn(0).setMaxWidth(85);
        }

        Container5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 860, 410));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title9.setForeground(new java.awt.Color(255, 255, 255));
        title9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title9.setText("Top 20 Noticias con mejor Ranking");
        jPanel7.add(title9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 40));

        Container5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 860, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imgReporte.png"))); // NOI18N
        Container5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        btnBack4.setText("Regresar");
        btnBack4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack4ActionPerformed(evt);
            }
        });
        Container5.add(btnBack4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        reporte4.add(Container5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));

        Header5.setBackground(new java.awt.Color(51, 51, 51));
        Header5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title10.setForeground(new java.awt.Color(255, 255, 255));
        title10.setText("> Generacion de Reportes ");
        Header5.add(title10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 710, 60));
        Header5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        reporte4.add(Header5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        add(reporte4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte1ActionPerformed
        principal.setVisible(false);
        reporte1.setVisible(true);
        reporte2.setVisible(false);
        reporte3.setVisible(false);
        reporte4.setVisible(false);
        Clear_Table();
        reporte1();
    }//GEN-LAST:event_btnReporte1ActionPerformed

    private void btnReporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte2ActionPerformed
        principal.setVisible(false);
        reporte1.setVisible(false);
        reporte2.setVisible(true);
        reporte3.setVisible(false);
        reporte4.setVisible(false);
        Clear_Table();
        reporte2();
    }//GEN-LAST:event_btnReporte2ActionPerformed

    private void btnReporte3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte3ActionPerformed
        principal.setVisible(false);
        reporte1.setVisible(false);
        reporte2.setVisible(false);
        reporte3.setVisible(true);
        reporte4.setVisible(false);
        Clear_Table();
        reporte3();
    }//GEN-LAST:event_btnReporte3ActionPerformed

    private void btnReporte4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte4ActionPerformed
        principal.setVisible(false);
        reporte1.setVisible(false);
        reporte2.setVisible(false);
        reporte3.setVisible(false);
        reporte4.setVisible(true);
        Clear_Table();
        reporte4();
    }//GEN-LAST:event_btnReporte4ActionPerformed

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

    private void idNoticia1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idNoticia1KeyTyped
        idNoticia1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                trsfiltro.setRowFilter(RowFilter.regexFilter(idNoticia1.getText(), 0));
            }
        });
        trsfiltro = new TableRowSorter(modelo);
        jTable2.setRowSorter(trsfiltro);

    }//GEN-LAST:event_idNoticia1KeyTyped

    private void idNoticia2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idNoticia2KeyTyped
        idNoticia2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                trsfiltro.setRowFilter(RowFilter.regexFilter(idNoticia2.getText(), 0));
            }
        });
        trsfiltro = new TableRowSorter(modelo);
        jTable3.setRowSorter(trsfiltro);
    }//GEN-LAST:event_idNoticia2KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container1;
    private javax.swing.JPanel Container2;
    private javax.swing.JPanel Container3;
    private javax.swing.JPanel Container4;
    private javax.swing.JPanel Container5;
    private javax.swing.JPanel Header1;
    private javax.swing.JPanel Header2;
    private javax.swing.JPanel Header3;
    private javax.swing.JPanel Header4;
    private javax.swing.JPanel Header5;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnBack3;
    private javax.swing.JButton btnBack4;
    private javax.swing.JButton btnReporte1;
    private javax.swing.JButton btnReporte2;
    private javax.swing.JButton btnReporte3;
    private javax.swing.JButton btnReporte4;
    private javax.swing.JTextField idNoticia1;
    private javax.swing.JTextField idNoticia2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JPanel principal;
    private javax.swing.JPanel reporte1;
    private javax.swing.JPanel reporte2;
    private javax.swing.JPanel reporte3;
    private javax.swing.JPanel reporte4;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title10;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JLabel title5;
    private javax.swing.JLabel title6;
    private javax.swing.JLabel title7;
    private javax.swing.JLabel title8;
    private javax.swing.JLabel title9;
    // End of variables declaration//GEN-END:variables
}
