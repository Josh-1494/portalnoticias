/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package portalnoticias;

import Modelos.ConexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jovie
 */
public class Principal extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    
    ConexionDB cc = new ConexionDB();
    Connection con = cc.getConneccion();
    
    public Principal() {
        initComponents();
    }

    public void getHome() {
        String sql = "SELECT * FROM PORTALUSUARIO_VIEW";
        try {
            Statement st = con.createStatement();
            //ResultSet rs = st.executeQuery(sql);

            int i = 1;
            ResultSet re = st.executeQuery(sql);
            while(re.next()){
                if (i == 1){
                   titulo1.setText(re.getString(2)); 
                   fecha1.setText(re.getString(3));
                   subtema1.setText(re.getString(4));
                   desc1.setText(re.getString(1));
                }
                if (i == 2){
                   titulo2.setText(re.getString(2)); 
                   fecha2.setText(re.getString(3));
                   subtema2.setText(re.getString(4));
                   desc2.setText(re.getString(1));
                }
                if (i == 3){
                   titulo3.setText(re.getString(2)); 
                   fecha3.setText(re.getString(3));
                   subtema3.setText(re.getString(4));
                   desc3.setText(re.getString(1));
                }
                if (i == 4){
                   titulo4.setText(re.getString(2)); 
                   fecha4.setText(re.getString(3));
                   subtema4.setText(re.getString(4));
                   desc4.setText(re.getString(1));
                }
                if (i == 5){
                   titulo5.setText(re.getString(2)); 
                   fecha5.setText(re.getString(3));
                   subtema5.setText(re.getString(4));
                   desc5.setText(re.getString(1));
                }
                if (i == 6){
                   titulo6.setText(re.getString(2)); 
                   fecha6.setText(re.getString(3));
                   subtema6.setText(re.getString(4));
                   desc6.setText(re.getString(1));
                }
                if (i == 7){
                   titulo7.setText(re.getString(2)); 
                   fecha7.setText(re.getString(3));
                   subtema7.setText(re.getString(4));
                   desc7.setText(re.getString(1));
                }
                if (i == 8){
                   titulo8.setText(re.getString(2)); 
                   fecha8.setText(re.getString(3));
                   subtema8.setText(re.getString(4));
                   desc8.setText(re.getString(1));
                }
                if (i == 9){
                   titulo9.setText(re.getString(2)); 
                   fecha9.setText(re.getString(3));
                   subtema9.setText(re.getString(4));
                   desc9.setText(re.getString(1));
                }
                if (i == 10){
                   titulo10.setText(re.getString(2)); 
                   fecha10.setText(re.getString(3));
                   subtema10.setText(re.getString(4));
                   desc10.setText(re.getString(1));
                }if (i == 11){
                   titulo11.setText(re.getString(2)); 
                   fecha11.setText(re.getString(3));
                   subtema11.setText(re.getString(4));
                   desc11.setText(re.getString(1));
                }if (i == 12){
                   titulo12.setText(re.getString(2)); 
                   fecha12.setText(re.getString(3));
                   subtema12.setText(re.getString(4));
                   desc12.setText(re.getString(1));
                }
                if (i == 13){
                   titulo13.setText(re.getString(2)); 
                   fecha13.setText(re.getString(3));
                   subtema13.setText(re.getString(4));
                   desc13.setText(re.getString(1));
                }
                if (i == 14){
                  titulo14.setText(re.getString(2)); 
                   fecha14.setText(re.getString(3));
                   subtema14.setText(re.getString(4));
                   desc14.setText(re.getString(1));
                }
                if (i == 15){
                   titulo15.setText(re.getString(2)); 
                   fecha15.setText(re.getString(3));
                   subtema15.setText(re.getString(4));
                   desc15.setText(re.getString(1));
                }
                if (i == 16){
                   titulo16.setText(re.getString(2)); 
                   fecha16.setText(re.getString(3));
                   subtema16.setText(re.getString(4));
                   desc16.setText(re.getString(1));
                }
                
                i++;
            }
            re.close();
            getHomeClean();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en consultar la base de datos " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void getHomeClean(){
        if (desc1.getText().isEmpty()){
            noticia1.setVisible(false);
        }
        if (desc2.getText().isEmpty()){
            noticia2.setVisible(false);
        }
        if (desc3.getText().isEmpty()){
            noticia3.setVisible(false);
        }
        if (desc4.getText().isEmpty()){
            noticia4.setVisible(false);
        }
        if (desc5.getText().isEmpty()){
            noticia5.setVisible(false);
        }
        if (desc6.getText().isEmpty()){
            noticia6.setVisible(false);
        }
        if (desc7.getText().isEmpty()){
            noticia7.setVisible(false);
        }
        if (desc8.getText().isEmpty()){
            noticia8.setVisible(false);
        }
        if (desc9.getText().isEmpty()){
            noticia9.setVisible(false);
        }
        if (desc10.getText().isEmpty()){
            noticia10.setVisible(false);
        }
        if (desc11.getText().isEmpty()){
            noticia11.setVisible(false);
        }
        if (desc12.getText().isEmpty()){
            noticia12.setVisible(false);
        }
        if (desc13.getText().isEmpty()){
            noticia13.setVisible(false);
        }
        if (desc14.getText().isEmpty()){
            noticia14.setVisible(false);
        }
        if (desc15.getText().isEmpty()){
            noticia15.setVisible(false);
        }
        if (desc16.getText().isEmpty()){
            noticia16.setVisible(false);
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

        Header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        Container = new javax.swing.JPanel();
        noticia1 = new javax.swing.JPanel();
        titulo1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fecha1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        subtema1 = new javax.swing.JLabel();
        desc1 = new javax.swing.JTextArea();
        noticia2 = new javax.swing.JPanel();
        titulo2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fecha2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        subtema2 = new javax.swing.JLabel();
        desc2 = new javax.swing.JTextArea();
        noticia3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        titulo3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        fecha3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        subtema3 = new javax.swing.JLabel();
        desc3 = new javax.swing.JTextArea();
        noticia4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        titulo4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        fecha4 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        subtema4 = new javax.swing.JLabel();
        desc4 = new javax.swing.JTextArea();
        noticia5 = new javax.swing.JPanel();
        titulo5 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        fecha5 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        subtema5 = new javax.swing.JLabel();
        desc5 = new javax.swing.JTextArea();
        noticia6 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        titulo6 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        fecha6 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        subtema6 = new javax.swing.JLabel();
        desc6 = new javax.swing.JTextArea();
        noticia7 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        titulo7 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        fecha7 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        subtema7 = new javax.swing.JLabel();
        desc7 = new javax.swing.JTextArea();
        noticia8 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        titulo8 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        fecha8 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        subtema8 = new javax.swing.JLabel();
        desc8 = new javax.swing.JTextArea();
        noticia9 = new javax.swing.JPanel();
        titulo9 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        fecha9 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        subtema9 = new javax.swing.JLabel();
        desc9 = new javax.swing.JTextArea();
        noticia10 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        titulo10 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        fecha10 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        subtema10 = new javax.swing.JLabel();
        desc10 = new javax.swing.JTextArea();
        noticia11 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        titulo11 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        fecha11 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        subtema11 = new javax.swing.JLabel();
        desc11 = new javax.swing.JTextArea();
        noticia12 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        titulo12 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        fecha12 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        subtema12 = new javax.swing.JLabel();
        desc12 = new javax.swing.JTextArea();
        noticia13 = new javax.swing.JPanel();
        titulo13 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        fecha13 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        subtema13 = new javax.swing.JLabel();
        desc13 = new javax.swing.JTextArea();
        noticia14 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        titulo14 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        fecha14 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        subtema14 = new javax.swing.JLabel();
        desc14 = new javax.swing.JTextArea();
        noticia15 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        titulo15 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        fecha15 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        subtema15 = new javax.swing.JLabel();
        desc15 = new javax.swing.JTextArea();
        noticia16 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        titulo16 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        fecha16 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        subtema16 = new javax.swing.JLabel();
        desc16 = new javax.swing.JTextArea();

        setMinimumSize(new java.awt.Dimension(1010, 620));
        setPreferredSize(new java.awt.Dimension(1010, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(51, 51, 51));
        Header.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("> Página Principal");
        Header.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 60));
        Header.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));

        add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(160, 120));
        jScrollPane2.setViewportView(Container);

        Container.setPreferredSize(new java.awt.Dimension(1010, 780));

        noticia1.setBackground(new java.awt.Color(51, 51, 51));
        noticia1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia1.setForeground(new java.awt.Color(0, 0, 0));

        titulo1.setForeground(new java.awt.Color(204, 204, 204));
        titulo1.setText("jLabel2");

        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Título:");

        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Fecha:");

        fecha1.setForeground(new java.awt.Color(204, 204, 204));
        fecha1.setText("jLabel2");

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("SubTema:");

        subtema1.setForeground(new java.awt.Color(204, 204, 204));
        subtema1.setText("jLabel2");

        desc1.setEditable(false);
        desc1.setBackground(new java.awt.Color(255, 255, 255));
        desc1.setColumns(20);
        desc1.setLineWrap(true);
        desc1.setRows(5);
        desc1.setAutoscrolls(false);
        desc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc1.setFocusable(false);

        javax.swing.GroupLayout noticia1Layout = new javax.swing.GroupLayout(noticia1);
        noticia1.setLayout(noticia1Layout);
        noticia1Layout.setHorizontalGroup(
            noticia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc1)
                    .addGroup(noticia1Layout.createSequentialGroup()
                        .addGroup(noticia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia1Layout.setVerticalGroup(
            noticia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema1)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        noticia2.setBackground(new java.awt.Color(51, 51, 51));
        noticia2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia2.setForeground(new java.awt.Color(0, 0, 0));

        titulo2.setForeground(new java.awt.Color(204, 204, 204));
        titulo2.setText("jLabel2");

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Título:");

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Fecha:");

        fecha2.setForeground(new java.awt.Color(204, 204, 204));
        fecha2.setText("jLabel2");

        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("SubTema:");

        subtema2.setForeground(new java.awt.Color(204, 204, 204));
        subtema2.setText("jLabel2");

        desc2.setEditable(false);
        desc2.setBackground(new java.awt.Color(255, 255, 255));
        desc2.setColumns(20);
        desc2.setLineWrap(true);
        desc2.setRows(5);
        desc2.setAutoscrolls(false);
        desc2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc2.setFocusable(false);

        javax.swing.GroupLayout noticia2Layout = new javax.swing.GroupLayout(noticia2);
        noticia2.setLayout(noticia2Layout);
        noticia2Layout.setHorizontalGroup(
            noticia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc2)
                    .addGroup(noticia2Layout.createSequentialGroup()
                        .addGroup(noticia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia2Layout.setVerticalGroup(
            noticia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(titulo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema2)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        noticia3.setBackground(new java.awt.Color(51, 51, 51));
        noticia3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Título:");

        titulo3.setForeground(new java.awt.Color(204, 204, 204));
        titulo3.setText("jLabel2");

        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Fecha:");

        fecha3.setForeground(new java.awt.Color(204, 204, 204));
        fecha3.setText("jLabel2");

        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("SubTema:");

        subtema3.setForeground(new java.awt.Color(204, 204, 204));
        subtema3.setText("jLabel2");

        desc3.setEditable(false);
        desc3.setBackground(new java.awt.Color(255, 255, 255));
        desc3.setColumns(20);
        desc3.setLineWrap(true);
        desc3.setRows(5);
        desc3.setAutoscrolls(false);
        desc3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc3.setFocusable(false);

        javax.swing.GroupLayout noticia3Layout = new javax.swing.GroupLayout(noticia3);
        noticia3.setLayout(noticia3Layout);
        noticia3Layout.setHorizontalGroup(
            noticia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc3)
                    .addGroup(noticia3Layout.createSequentialGroup()
                        .addGroup(noticia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia3Layout.setVerticalGroup(
            noticia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo3)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha3)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema3)
                    .addComponent(jLabel20))
                .addContainerGap())
        );

        noticia4.setBackground(new java.awt.Color(51, 51, 51));
        noticia4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("Título:");

        titulo4.setForeground(new java.awt.Color(204, 204, 204));
        titulo4.setText("jLabel2");

        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("Fecha:");

        fecha4.setForeground(new java.awt.Color(204, 204, 204));
        fecha4.setText("jLabel2");

        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("SubTema:");

        subtema4.setForeground(new java.awt.Color(204, 204, 204));
        subtema4.setText("jLabel2");

        desc4.setEditable(false);
        desc4.setBackground(new java.awt.Color(255, 255, 255));
        desc4.setColumns(20);
        desc4.setLineWrap(true);
        desc4.setRows(5);
        desc4.setAutoscrolls(false);
        desc4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc4.setFocusable(false);

        javax.swing.GroupLayout noticia4Layout = new javax.swing.GroupLayout(noticia4);
        noticia4.setLayout(noticia4Layout);
        noticia4Layout.setHorizontalGroup(
            noticia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc4)
                    .addGroup(noticia4Layout.createSequentialGroup()
                        .addGroup(noticia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia4Layout.setVerticalGroup(
            noticia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc4, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo4)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha4)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema4)
                    .addComponent(jLabel27))
                .addContainerGap())
        );

        noticia5.setBackground(new java.awt.Color(51, 51, 51));
        noticia5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia5.setForeground(new java.awt.Color(0, 0, 0));

        titulo5.setForeground(new java.awt.Color(204, 204, 204));
        titulo5.setText("jLabel2");

        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setText("Título:");

        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setText("Fecha:");

        fecha5.setForeground(new java.awt.Color(204, 204, 204));
        fecha5.setText("jLabel2");

        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setText("SubTema:");

        subtema5.setForeground(new java.awt.Color(204, 204, 204));
        subtema5.setText("jLabel2");

        desc5.setEditable(false);
        desc5.setBackground(new java.awt.Color(255, 255, 255));
        desc5.setColumns(20);
        desc5.setLineWrap(true);
        desc5.setRows(5);
        desc5.setAutoscrolls(false);
        desc5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc5.setFocusable(false);

        javax.swing.GroupLayout noticia5Layout = new javax.swing.GroupLayout(noticia5);
        noticia5.setLayout(noticia5Layout);
        noticia5Layout.setHorizontalGroup(
            noticia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc5)
                    .addGroup(noticia5Layout.createSequentialGroup()
                        .addGroup(noticia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia5Layout.setVerticalGroup(
            noticia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc5, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo5)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha5)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema5)
                    .addComponent(jLabel34))
                .addContainerGap())
        );

        noticia6.setBackground(new java.awt.Color(51, 51, 51));
        noticia6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia6.setForeground(new java.awt.Color(0, 0, 0));

        jLabel37.setForeground(new java.awt.Color(204, 204, 204));
        jLabel37.setText("Título:");

        titulo6.setForeground(new java.awt.Color(204, 204, 204));
        titulo6.setText("jLabel2");

        jLabel39.setForeground(new java.awt.Color(204, 204, 204));
        jLabel39.setText("Fecha:");

        fecha6.setForeground(new java.awt.Color(204, 204, 204));
        fecha6.setText("jLabel2");

        jLabel41.setForeground(new java.awt.Color(204, 204, 204));
        jLabel41.setText("SubTema:");

        subtema6.setForeground(new java.awt.Color(204, 204, 204));
        subtema6.setText("jLabel2");

        desc6.setEditable(false);
        desc6.setBackground(new java.awt.Color(255, 255, 255));
        desc6.setColumns(20);
        desc6.setLineWrap(true);
        desc6.setRows(5);
        desc6.setAutoscrolls(false);
        desc6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc6.setFocusable(false);

        javax.swing.GroupLayout noticia6Layout = new javax.swing.GroupLayout(noticia6);
        noticia6.setLayout(noticia6Layout);
        noticia6Layout.setHorizontalGroup(
            noticia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc6)
                    .addGroup(noticia6Layout.createSequentialGroup()
                        .addGroup(noticia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia6Layout.setVerticalGroup(
            noticia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc6, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo6)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha6)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema6)
                    .addComponent(jLabel41))
                .addContainerGap())
        );

        noticia7.setBackground(new java.awt.Color(51, 51, 51));
        noticia7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel44.setForeground(new java.awt.Color(204, 204, 204));
        jLabel44.setText("Título:");

        titulo7.setForeground(new java.awt.Color(204, 204, 204));
        titulo7.setText("jLabel2");

        jLabel46.setForeground(new java.awt.Color(204, 204, 204));
        jLabel46.setText("Fecha:");

        fecha7.setForeground(new java.awt.Color(204, 204, 204));
        fecha7.setText("jLabel2");

        jLabel48.setForeground(new java.awt.Color(204, 204, 204));
        jLabel48.setText("SubTema:");

        subtema7.setForeground(new java.awt.Color(204, 204, 204));
        subtema7.setText("jLabel2");

        desc7.setEditable(false);
        desc7.setBackground(new java.awt.Color(255, 255, 255));
        desc7.setColumns(20);
        desc7.setLineWrap(true);
        desc7.setRows(5);
        desc7.setAutoscrolls(false);
        desc7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc7.setFocusable(false);

        javax.swing.GroupLayout noticia7Layout = new javax.swing.GroupLayout(noticia7);
        noticia7.setLayout(noticia7Layout);
        noticia7Layout.setHorizontalGroup(
            noticia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc7)
                    .addGroup(noticia7Layout.createSequentialGroup()
                        .addGroup(noticia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia7Layout.setVerticalGroup(
            noticia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc7, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo7)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha7)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema7)
                    .addComponent(jLabel48))
                .addContainerGap())
        );

        noticia8.setBackground(new java.awt.Color(51, 51, 51));
        noticia8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia8.setForeground(new java.awt.Color(0, 0, 0));

        jLabel51.setForeground(new java.awt.Color(204, 204, 204));
        jLabel51.setText("Título:");

        titulo8.setForeground(new java.awt.Color(204, 204, 204));
        titulo8.setText("jLabel2");

        jLabel53.setForeground(new java.awt.Color(204, 204, 204));
        jLabel53.setText("Fecha:");

        fecha8.setForeground(new java.awt.Color(204, 204, 204));
        fecha8.setText("jLabel2");

        jLabel55.setForeground(new java.awt.Color(204, 204, 204));
        jLabel55.setText("SubTema:");

        subtema8.setForeground(new java.awt.Color(204, 204, 204));
        subtema8.setText("jLabel2");

        desc8.setEditable(false);
        desc8.setBackground(new java.awt.Color(255, 255, 255));
        desc8.setColumns(20);
        desc8.setLineWrap(true);
        desc8.setRows(5);
        desc8.setAutoscrolls(false);
        desc8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc8.setFocusable(false);

        javax.swing.GroupLayout noticia8Layout = new javax.swing.GroupLayout(noticia8);
        noticia8.setLayout(noticia8Layout);
        noticia8Layout.setHorizontalGroup(
            noticia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc8)
                    .addGroup(noticia8Layout.createSequentialGroup()
                        .addGroup(noticia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia8Layout.setVerticalGroup(
            noticia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc8, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo8)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha8)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema8)
                    .addComponent(jLabel55))
                .addContainerGap())
        );

        noticia9.setBackground(new java.awt.Color(51, 51, 51));
        noticia9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia9.setForeground(new java.awt.Color(0, 0, 0));

        titulo9.setForeground(new java.awt.Color(204, 204, 204));
        titulo9.setText("jLabel2");

        jLabel59.setForeground(new java.awt.Color(204, 204, 204));
        jLabel59.setText("Título:");

        jLabel60.setForeground(new java.awt.Color(204, 204, 204));
        jLabel60.setText("Fecha:");

        fecha9.setForeground(new java.awt.Color(204, 204, 204));
        fecha9.setText("jLabel2");

        jLabel62.setForeground(new java.awt.Color(204, 204, 204));
        jLabel62.setText("SubTema:");

        subtema9.setForeground(new java.awt.Color(204, 204, 204));
        subtema9.setText("jLabel2");

        desc9.setEditable(false);
        desc9.setBackground(new java.awt.Color(255, 255, 255));
        desc9.setColumns(20);
        desc9.setLineWrap(true);
        desc9.setRows(5);
        desc9.setAutoscrolls(false);
        desc9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc9.setFocusable(false);

        javax.swing.GroupLayout noticia9Layout = new javax.swing.GroupLayout(noticia9);
        noticia9.setLayout(noticia9Layout);
        noticia9Layout.setHorizontalGroup(
            noticia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc9)
                    .addGroup(noticia9Layout.createSequentialGroup()
                        .addGroup(noticia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia9Layout.setVerticalGroup(
            noticia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc9, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo9)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha9)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema9)
                    .addComponent(jLabel62))
                .addContainerGap())
        );

        noticia10.setBackground(new java.awt.Color(51, 51, 51));
        noticia10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia10.setForeground(new java.awt.Color(0, 0, 0));

        jLabel65.setForeground(new java.awt.Color(204, 204, 204));
        jLabel65.setText("Título:");

        titulo10.setForeground(new java.awt.Color(204, 204, 204));
        titulo10.setText("jLabel2");

        jLabel67.setForeground(new java.awt.Color(204, 204, 204));
        jLabel67.setText("Fecha:");

        fecha10.setForeground(new java.awt.Color(204, 204, 204));
        fecha10.setText("jLabel2");

        jLabel69.setForeground(new java.awt.Color(204, 204, 204));
        jLabel69.setText("SubTema:");

        subtema10.setForeground(new java.awt.Color(204, 204, 204));
        subtema10.setText("jLabel2");

        desc10.setEditable(false);
        desc10.setBackground(new java.awt.Color(255, 255, 255));
        desc10.setColumns(20);
        desc10.setLineWrap(true);
        desc10.setRows(5);
        desc10.setAutoscrolls(false);
        desc10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc10.setFocusable(false);

        javax.swing.GroupLayout noticia10Layout = new javax.swing.GroupLayout(noticia10);
        noticia10.setLayout(noticia10Layout);
        noticia10Layout.setHorizontalGroup(
            noticia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc10)
                    .addGroup(noticia10Layout.createSequentialGroup()
                        .addGroup(noticia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia10Layout.setVerticalGroup(
            noticia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc10, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo10)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha10)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema10)
                    .addComponent(jLabel69))
                .addContainerGap())
        );

        noticia11.setBackground(new java.awt.Color(51, 51, 51));
        noticia11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia11.setForeground(new java.awt.Color(0, 0, 0));

        jLabel72.setForeground(new java.awt.Color(204, 204, 204));
        jLabel72.setText("Título:");

        titulo11.setForeground(new java.awt.Color(204, 204, 204));
        titulo11.setText("jLabel2");

        jLabel74.setForeground(new java.awt.Color(204, 204, 204));
        jLabel74.setText("Fecha:");

        fecha11.setForeground(new java.awt.Color(204, 204, 204));
        fecha11.setText("jLabel2");

        jLabel76.setForeground(new java.awt.Color(204, 204, 204));
        jLabel76.setText("SubTema:");

        subtema11.setForeground(new java.awt.Color(204, 204, 204));
        subtema11.setText("jLabel2");

        desc11.setEditable(false);
        desc11.setBackground(new java.awt.Color(255, 255, 255));
        desc11.setColumns(20);
        desc11.setLineWrap(true);
        desc11.setRows(5);
        desc11.setAutoscrolls(false);
        desc11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc11.setFocusable(false);

        javax.swing.GroupLayout noticia11Layout = new javax.swing.GroupLayout(noticia11);
        noticia11.setLayout(noticia11Layout);
        noticia11Layout.setHorizontalGroup(
            noticia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc11)
                    .addGroup(noticia11Layout.createSequentialGroup()
                        .addGroup(noticia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia11Layout.setVerticalGroup(
            noticia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc11, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo11)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha11)
                    .addComponent(jLabel74))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema11)
                    .addComponent(jLabel76))
                .addContainerGap())
        );

        noticia12.setBackground(new java.awt.Color(51, 51, 51));
        noticia12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia12.setForeground(new java.awt.Color(0, 0, 0));

        jLabel79.setForeground(new java.awt.Color(204, 204, 204));
        jLabel79.setText("Título:");

        titulo12.setForeground(new java.awt.Color(204, 204, 204));
        titulo12.setText("jLabel2");

        jLabel81.setForeground(new java.awt.Color(204, 204, 204));
        jLabel81.setText("Fecha:");

        fecha12.setForeground(new java.awt.Color(204, 204, 204));
        fecha12.setText("jLabel2");

        jLabel83.setForeground(new java.awt.Color(204, 204, 204));
        jLabel83.setText("SubTema:");

        subtema12.setForeground(new java.awt.Color(204, 204, 204));
        subtema12.setText("jLabel2");

        desc12.setEditable(false);
        desc12.setBackground(new java.awt.Color(255, 255, 255));
        desc12.setColumns(20);
        desc12.setLineWrap(true);
        desc12.setRows(5);
        desc12.setAutoscrolls(false);
        desc12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc12.setFocusable(false);

        javax.swing.GroupLayout noticia12Layout = new javax.swing.GroupLayout(noticia12);
        noticia12.setLayout(noticia12Layout);
        noticia12Layout.setHorizontalGroup(
            noticia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc12)
                    .addGroup(noticia12Layout.createSequentialGroup()
                        .addGroup(noticia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia12Layout.setVerticalGroup(
            noticia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc12, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo12)
                    .addComponent(jLabel79))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha12)
                    .addComponent(jLabel81))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema12)
                    .addComponent(jLabel83))
                .addContainerGap())
        );

        noticia13.setBackground(new java.awt.Color(51, 51, 51));
        noticia13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia13.setForeground(new java.awt.Color(0, 0, 0));

        titulo13.setForeground(new java.awt.Color(204, 204, 204));
        titulo13.setText("jLabel2");

        jLabel87.setForeground(new java.awt.Color(204, 204, 204));
        jLabel87.setText("Título:");

        jLabel88.setForeground(new java.awt.Color(204, 204, 204));
        jLabel88.setText("Fecha:");

        fecha13.setForeground(new java.awt.Color(204, 204, 204));
        fecha13.setText("jLabel2");

        jLabel90.setForeground(new java.awt.Color(204, 204, 204));
        jLabel90.setText("SubTema:");

        subtema13.setForeground(new java.awt.Color(204, 204, 204));
        subtema13.setText("jLabel2");

        desc13.setEditable(false);
        desc13.setBackground(new java.awt.Color(255, 255, 255));
        desc13.setColumns(20);
        desc13.setLineWrap(true);
        desc13.setRows(5);
        desc13.setAutoscrolls(false);
        desc13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc13.setFocusable(false);

        javax.swing.GroupLayout noticia13Layout = new javax.swing.GroupLayout(noticia13);
        noticia13.setLayout(noticia13Layout);
        noticia13Layout.setHorizontalGroup(
            noticia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc13)
                    .addGroup(noticia13Layout.createSequentialGroup()
                        .addGroup(noticia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(noticia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia13Layout.setVerticalGroup(
            noticia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc13, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo13)
                    .addComponent(jLabel87))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha13)
                    .addComponent(jLabel88))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema13)
                    .addComponent(jLabel90))
                .addContainerGap())
        );

        noticia14.setBackground(new java.awt.Color(51, 51, 51));
        noticia14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia14.setForeground(new java.awt.Color(0, 0, 0));

        jLabel93.setForeground(new java.awt.Color(204, 204, 204));
        jLabel93.setText("Título:");

        titulo14.setForeground(new java.awt.Color(204, 204, 204));
        titulo14.setText("jLabel2");

        jLabel95.setForeground(new java.awt.Color(204, 204, 204));
        jLabel95.setText("Fecha:");

        fecha14.setForeground(new java.awt.Color(204, 204, 204));
        fecha14.setText("jLabel2");

        jLabel97.setForeground(new java.awt.Color(204, 204, 204));
        jLabel97.setText("SubTema:");

        subtema14.setForeground(new java.awt.Color(204, 204, 204));
        subtema14.setText("jLabel2");

        desc14.setEditable(false);
        desc14.setBackground(new java.awt.Color(255, 255, 255));
        desc14.setColumns(20);
        desc14.setLineWrap(true);
        desc14.setRows(5);
        desc14.setAutoscrolls(false);
        desc14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc14.setFocusable(false);

        javax.swing.GroupLayout noticia14Layout = new javax.swing.GroupLayout(noticia14);
        noticia14.setLayout(noticia14Layout);
        noticia14Layout.setHorizontalGroup(
            noticia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc14)
                    .addGroup(noticia14Layout.createSequentialGroup()
                        .addGroup(noticia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subtema14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia14Layout.setVerticalGroup(
            noticia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc14, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo14)
                    .addComponent(jLabel93))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha14)
                    .addComponent(jLabel95))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema14)
                    .addComponent(jLabel97))
                .addContainerGap())
        );

        noticia15.setBackground(new java.awt.Color(51, 51, 51));
        noticia15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia15.setForeground(new java.awt.Color(0, 0, 0));

        jLabel100.setForeground(new java.awt.Color(204, 204, 204));
        jLabel100.setText("Título:");

        titulo15.setForeground(new java.awt.Color(204, 204, 204));
        titulo15.setText("jLabel2");

        jLabel102.setForeground(new java.awt.Color(204, 204, 204));
        jLabel102.setText("Fecha:");

        fecha15.setForeground(new java.awt.Color(204, 204, 204));
        fecha15.setText("jLabel2");

        jLabel104.setForeground(new java.awt.Color(204, 204, 204));
        jLabel104.setText("SubTema:");

        subtema15.setForeground(new java.awt.Color(204, 204, 204));
        subtema15.setText("jLabel2");

        desc15.setEditable(false);
        desc15.setBackground(new java.awt.Color(255, 255, 255));
        desc15.setColumns(20);
        desc15.setLineWrap(true);
        desc15.setRows(5);
        desc15.setAutoscrolls(false);
        desc15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc15.setFocusable(false);

        javax.swing.GroupLayout noticia15Layout = new javax.swing.GroupLayout(noticia15);
        noticia15.setLayout(noticia15Layout);
        noticia15Layout.setHorizontalGroup(
            noticia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc15)
                    .addGroup(noticia15Layout.createSequentialGroup()
                        .addGroup(noticia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subtema15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fecha15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia15Layout.setVerticalGroup(
            noticia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc15, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo15)
                    .addComponent(jLabel100))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha15)
                    .addComponent(jLabel102))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema15)
                    .addComponent(jLabel104))
                .addContainerGap())
        );

        noticia16.setBackground(new java.awt.Color(51, 51, 51));
        noticia16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        noticia16.setForeground(new java.awt.Color(0, 0, 0));

        jLabel107.setForeground(new java.awt.Color(204, 204, 204));
        jLabel107.setText("Título:");

        titulo16.setForeground(new java.awt.Color(204, 204, 204));
        titulo16.setText("jLabel2");

        jLabel109.setForeground(new java.awt.Color(204, 204, 204));
        jLabel109.setText("Fecha:");

        fecha16.setForeground(new java.awt.Color(204, 204, 204));
        fecha16.setText("jLabel2");

        jLabel111.setForeground(new java.awt.Color(204, 204, 204));
        jLabel111.setText("SubTema:");

        subtema16.setForeground(new java.awt.Color(204, 204, 204));
        subtema16.setText("jLabel2");

        desc16.setEditable(false);
        desc16.setBackground(new java.awt.Color(255, 255, 255));
        desc16.setColumns(20);
        desc16.setLineWrap(true);
        desc16.setRows(5);
        desc16.setAutoscrolls(false);
        desc16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        desc16.setFocusable(false);

        javax.swing.GroupLayout noticia16Layout = new javax.swing.GroupLayout(noticia16);
        noticia16.setLayout(noticia16Layout);
        noticia16Layout.setHorizontalGroup(
            noticia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(noticia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc16)
                    .addGroup(noticia16Layout.createSequentialGroup()
                        .addGroup(noticia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(noticia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subtema16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fecha16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        noticia16Layout.setVerticalGroup(
            noticia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticia16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc16, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo16)
                    .addComponent(jLabel107))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha16)
                    .addComponent(jLabel109))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(noticia16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtema16)
                    .addComponent(jLabel111))
                .addContainerGap())
        );

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noticia13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noticia1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainerLayout.createSequentialGroup()
                                .addComponent(noticia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noticia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noticia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(ContainerLayout.createSequentialGroup()
                                .addComponent(noticia14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noticia15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noticia16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noticia5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noticia9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContainerLayout.createSequentialGroup()
                                .addComponent(noticia10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noticia11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noticia12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ContainerLayout.createSequentialGroup()
                                .addComponent(noticia6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noticia7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(noticia8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noticia3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noticia7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noticia11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noticia15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noticia16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(Container);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Header;
    private javax.swing.JTextArea desc1;
    private javax.swing.JTextArea desc10;
    private javax.swing.JTextArea desc11;
    private javax.swing.JTextArea desc12;
    private javax.swing.JTextArea desc13;
    private javax.swing.JTextArea desc14;
    private javax.swing.JTextArea desc15;
    private javax.swing.JTextArea desc16;
    private javax.swing.JTextArea desc2;
    private javax.swing.JTextArea desc3;
    private javax.swing.JTextArea desc4;
    private javax.swing.JTextArea desc5;
    private javax.swing.JTextArea desc6;
    private javax.swing.JTextArea desc7;
    private javax.swing.JTextArea desc8;
    private javax.swing.JTextArea desc9;
    private javax.swing.JLabel fecha1;
    private javax.swing.JLabel fecha10;
    private javax.swing.JLabel fecha11;
    private javax.swing.JLabel fecha12;
    private javax.swing.JLabel fecha13;
    private javax.swing.JLabel fecha14;
    private javax.swing.JLabel fecha15;
    private javax.swing.JLabel fecha16;
    private javax.swing.JLabel fecha2;
    private javax.swing.JLabel fecha3;
    private javax.swing.JLabel fecha4;
    private javax.swing.JLabel fecha5;
    private javax.swing.JLabel fecha6;
    private javax.swing.JLabel fecha7;
    private javax.swing.JLabel fecha8;
    private javax.swing.JLabel fecha9;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel noticia1;
    private javax.swing.JPanel noticia10;
    private javax.swing.JPanel noticia11;
    private javax.swing.JPanel noticia12;
    private javax.swing.JPanel noticia13;
    private javax.swing.JPanel noticia14;
    private javax.swing.JPanel noticia15;
    private javax.swing.JPanel noticia16;
    private javax.swing.JPanel noticia2;
    private javax.swing.JPanel noticia3;
    private javax.swing.JPanel noticia4;
    private javax.swing.JPanel noticia5;
    private javax.swing.JPanel noticia6;
    private javax.swing.JPanel noticia7;
    private javax.swing.JPanel noticia8;
    private javax.swing.JPanel noticia9;
    private javax.swing.JLabel subtema1;
    private javax.swing.JLabel subtema10;
    private javax.swing.JLabel subtema11;
    private javax.swing.JLabel subtema12;
    private javax.swing.JLabel subtema13;
    private javax.swing.JLabel subtema14;
    private javax.swing.JLabel subtema15;
    private javax.swing.JLabel subtema16;
    private javax.swing.JLabel subtema2;
    private javax.swing.JLabel subtema3;
    private javax.swing.JLabel subtema4;
    private javax.swing.JLabel subtema5;
    private javax.swing.JLabel subtema6;
    private javax.swing.JLabel subtema7;
    private javax.swing.JLabel subtema8;
    private javax.swing.JLabel subtema9;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel titulo10;
    private javax.swing.JLabel titulo11;
    private javax.swing.JLabel titulo12;
    private javax.swing.JLabel titulo13;
    private javax.swing.JLabel titulo14;
    private javax.swing.JLabel titulo15;
    private javax.swing.JLabel titulo16;
    private javax.swing.JLabel titulo2;
    private javax.swing.JLabel titulo3;
    private javax.swing.JLabel titulo4;
    private javax.swing.JLabel titulo5;
    private javax.swing.JLabel titulo6;
    private javax.swing.JLabel titulo7;
    private javax.swing.JLabel titulo8;
    private javax.swing.JLabel titulo9;
    // End of variables declaration//GEN-END:variables
}
