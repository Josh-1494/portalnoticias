/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package portalnoticias;

/**
 *
 * @author jovie
 */
public class Configuracion extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public Configuracion() {
        initComponents();
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
        Container = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1010, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        title.setText("> Configuración del sistema");
        Header.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, -1, 320, 60));

        add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 560));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
