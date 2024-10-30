/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author User
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        jPanel1 = new javax.swing.JPanel();
        Cerrar = new javax.swing.JLabel();
        InicioSesion = new javax.swing.JLabel();
        InicioSesionSombra = new javax.swing.JLabel();
        Logotipo = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        background2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cerrar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Cerrar)
                .addGap(0, 850, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Cerrar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 40));

        InicioSesion.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        InicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        InicioSesion.setText("Inicio de Sesión");
        getContentPane().add(InicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 320, 70));

        InicioSesionSombra.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        InicioSesionSombra.setText("Inicio de Sesión");
        getContentPane().add(InicioSesionSombra, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, -1, -1));

        Logotipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Diseño sin título (1).png"))); // NOI18N
        getContentPane().add(Logotipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 120, 110));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/OC3WJK0.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 590));

        background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Diseño sin título.png"))); // NOI18N
        background2.setText("jLabel1");
        getContentPane().add(background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 430, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cerrar;
    private javax.swing.JLabel InicioSesion;
    private javax.swing.JLabel InicioSesionSombra;
    private javax.swing.JLabel Logotipo;
    private javax.swing.JLabel background;
    private javax.swing.JLabel background2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
