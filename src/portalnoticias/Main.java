/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package portalnoticias;

import Modelos.ConexionDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jovie
 */
public class Main extends javax.swing.JFrame {

    String usuario = null;
    String fecha = null;
    public int intentos = 0;
    int xMouse;
    int yMouse;
    
    ConexionDB cc = new ConexionDB();
    Connection con = cc.getConneccion();

    boolean pnPrincipal = true;
    boolean pnNoticias = true;
    boolean pnReportes = true;
    boolean pnConfig = true;
    
 
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        setColor(btnPrincipal, principal);
        pnPrincipal = false;

        Principal p1 = new Principal();
        
        p1.setSize(1010, 620);
        p1.setLocation(0, 0);
        p1.getHome();
        
        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    
    public void refreshHome() {
        setColor(btnPrincipal, principal);
        resetColor(btnNoticias, noticias);
        resetColor(btnReportes, reportes);
        resetColor(btnConfig, config);
        // Abrir sección
        Principal p1 = new Principal();
        p1.setSize(1010, 620);
        p1.setLocation(0, 0);
        p1.getHome();

        pnPrincipal = false;
        pnNoticias = true;
        pnReportes = true;
        pnConfig = true;
        
        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    void setColor(JPanel panel, JLabel label) {
        panel.setBackground(new Color(25, 25, 25));
        Font ff = label.getFont();
        label.setFont(ff.deriveFont(ff.getStyle() | Font.BOLD));
    }

    void resetColor(JPanel panel, JLabel label) {
        panel.setBackground(new Color(51, 51, 51));
        Font ff = label.getFont();
        label.setFont(ff.deriveFont(ff.getStyle() & ~Font.BOLD));
    }

    public void getUser(String str) {
        usuario = str;
        jLabel4.setText(usuario);
        JOptionPane.showMessageDialog(null, "Bienvenido al portal de noticias " + usuario);
    }
    
    public void getPortalHome(String str) {
        usuario = str;
        String sql = "CALL UPDATEPORTALUSUARIO_PROC('" + usuario + "')";
        
        try {
            //Statement st = con.createStatement();
            var rs = con.prepareCall(sql);
            rs.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en consultar la base de datos " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getFecha(String str) {
        fecha = str;
        fechahoy.setText(fecha);
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnPrincipal = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        principal = new javax.swing.JLabel();
        btnNoticias = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        noticias = new javax.swing.JLabel();
        btnReportes = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        reportes = new javax.swing.JLabel();
        btnConfig = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        config = new javax.swing.JLabel();
        fechahoy = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Title = new javax.swing.JPanel();
        ext1 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(37, 37, 37));
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(37, 37, 37));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoMain.png"))); // NOI18N
        menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 160));

        jPanel9.setBackground(new java.awt.Color(255, 221, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(60, 63, 65));
        jLabel2.setText("Usuario:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(60, 63, 65));
        jLabel4.setText("jLabel2");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        menu.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 270, 60));

        btnPrincipal.setBackground(new java.awt.Color(51, 51, 51));
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrincipalMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPrincipalMousePressed(evt);
            }
        });
        btnPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home-outline.png"))); // NOI18N
        btnPrincipal.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        principal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        principal.setForeground(new java.awt.Color(255, 255, 255));
        principal.setText("Principal");
        btnPrincipal.add(principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 30));

        menu.add(btnPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 270, 50));

        btnNoticias.setBackground(new java.awt.Color(51, 51, 51));
        btnNoticias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNoticias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNoticiasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNoticiasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNoticiasMousePressed(evt);
            }
        });
        btnNoticias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/book-open-page-variant.png"))); // NOI18N
        btnNoticias.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        noticias.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        noticias.setForeground(new java.awt.Color(255, 255, 255));
        noticias.setText("Noticias");
        btnNoticias.add(noticias, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 30));

        menu.add(btnNoticias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 270, 50));

        btnReportes.setBackground(new java.awt.Color(51, 51, 51));
        btnReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnReportesMousePressed(evt);
            }
        });
        btnReportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/file-chart.png"))); // NOI18N
        btnReportes.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        reportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reportes.setForeground(new java.awt.Color(255, 255, 255));
        reportes.setText("Reportes");
        btnReportes.add(reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 30));

        menu.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 270, 50));

        btnConfig.setBackground(new java.awt.Color(51, 51, 51));
        btnConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfigMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConfigMousePressed(evt);
            }
        });
        btnConfig.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/config.png"))); // NOI18N
        btnConfig.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        config.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        config.setForeground(new java.awt.Color(255, 255, 255));
        config.setText("Configuracion");
        btnConfig.add(config, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 30));

        menu.add(btnConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 270, 50));

        fechahoy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fechahoy.setForeground(new java.awt.Color(255, 255, 255));
        menu.add(fechahoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 260, 30));

        jPanel1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 720));

        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(37, 37, 37));
        jLabel3.setFont(new java.awt.Font("Corbel", 1, 62)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Portal de Noticias");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 90));

        Title.setBackground(new java.awt.Color(37, 37, 37));
        Title.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TitleMouseDragged(evt);
            }
        });
        Title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TitleMousePressed(evt);
            }
        });
        Title.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ext1.setBackground(new java.awt.Color(37, 37, 37));
        ext1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        ext1.setForeground(new java.awt.Color(255, 255, 255));
        ext1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ext1.setText("X");
        ext1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ext1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ext1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ext1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ext1MouseExited(evt);
            }
        });
        Title.add(ext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 40, 40));

        jPanel2.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 90));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jPanel2.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1010, 620));

        jPanel3.setBackground(new java.awt.Color(0, 32, 242));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1010, 10));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1010, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ext1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ext1MouseClicked
        login login = new login();
        login.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ext1MouseClicked

    private void ext1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ext1MouseEntered
        Font f = ext1.getFont();
        ext1.setForeground(Color.RED);
        ext1.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
    }//GEN-LAST:event_ext1MouseEntered

    private void ext1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ext1MouseExited
        Font f = ext1.getFont();
        ext1.setFont(f.deriveFont(f.getStyle() & ~Font.BOLD));
        ext1.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_ext1MouseExited

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed

    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged

    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnPrincipalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseEntered
        if (pnPrincipal)
            setColor(btnPrincipal, principal);
    }//GEN-LAST:event_btnPrincipalMouseEntered

    private void btnPrincipalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMouseExited
        if (pnPrincipal)
            resetColor(btnPrincipal, principal);
    }//GEN-LAST:event_btnPrincipalMouseExited

    private void btnNoticiasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNoticiasMouseEntered
        //JOptionPane.showMessageDialog(null, btnNoticias.getBackground().getRGB());
        if (pnNoticias)
            setColor(btnNoticias, noticias);
    }//GEN-LAST:event_btnNoticiasMouseEntered

    private void btnNoticiasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNoticiasMouseExited
        if (pnNoticias)
            resetColor(btnNoticias, noticias);
    }//GEN-LAST:event_btnNoticiasMouseExited

    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        if (pnReportes)
            setColor(btnReportes, reportes);
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        if (pnReportes)
            resetColor(btnReportes, reportes);
    }//GEN-LAST:event_btnReportesMouseExited

    private void btnConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseEntered
        if (pnConfig)
            setColor(btnConfig, config);
    }//GEN-LAST:event_btnConfigMouseEntered

    private void btnConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseExited
        if (pnConfig)
            resetColor(btnConfig, config);
    }//GEN-LAST:event_btnConfigMouseExited

    private void btnPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrincipalMousePressed
        refreshHome();
    }//GEN-LAST:event_btnPrincipalMousePressed

    private void btnNoticiasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNoticiasMousePressed
        setColor(btnNoticias, noticias);
        resetColor(btnPrincipal, principal);
        resetColor(btnReportes, reportes);
        resetColor(btnConfig, config);
        
        // Abrir sección
        Noticias p1 = new Noticias();
        p1.setSize(1010, 620);
        p1.setLocation(0, 0);
        pnPrincipal = true;
        pnNoticias = false;
        pnReportes = true;
        pnConfig = true;

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        
        p1.obtenerUser(usuario);
        
    }//GEN-LAST:event_btnNoticiasMousePressed

    private void btnReportesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMousePressed
        setColor(btnReportes, reportes);
        resetColor(btnPrincipal, principal);
        resetColor(btnNoticias, noticias);
        resetColor(btnConfig, config);
        // Abrir sección
        Reportes p1 = new Reportes();
        p1.setSize(1010, 620);
        p1.setLocation(0, 0);
        pnPrincipal = true;
        pnNoticias = true;
        pnReportes = false;
        pnConfig = true;

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        
        p1.obtenerUser(usuario);
    }//GEN-LAST:event_btnReportesMousePressed

    private void btnConfigMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMousePressed
        setColor(btnConfig, config);
        resetColor(btnPrincipal, principal);
        resetColor(btnNoticias, noticias);
        resetColor(btnReportes, reportes);

        // Abrir sección
        Configuracion p1 = new Configuracion();
        p1.setSize(1010, 620);
        p1.setLocation(0, 0);
        pnPrincipal = true;
        pnNoticias = true;
        pnReportes = true;
        pnConfig = false;

        content.removeAll();
        content.add(p1, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        
        p1.obtenerUser(usuario);
        
    }//GEN-LAST:event_btnConfigMousePressed

    private void TitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_TitleMousePressed

    private void TitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_TitleMouseDragged

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Title;
    private javax.swing.JPanel btnConfig;
    private javax.swing.JPanel btnNoticias;
    private javax.swing.JPanel btnPrincipal;
    private javax.swing.JPanel btnReportes;
    private javax.swing.JLabel config;
    private javax.swing.JPanel content;
    private javax.swing.JLabel ext1;
    private javax.swing.JLabel fechahoy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel noticias;
    private javax.swing.JLabel principal;
    private javax.swing.JLabel reportes;
    // End of variables declaration//GEN-END:variables
}
