package GUI;

public class SeleccionarAsientos extends javax.swing.JFrame {
    private GestionDeEventos gestionDeEventos;
    
    public SeleccionarAsientos() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnGeneral = new javax.swing.JButton();
        btnVip = new javax.swing.JButton();
        btnPlatinum = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        btnEvento = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Selecciona por donde Ubicarte");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        btnGeneral.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnGeneral.setText("General");
        getContentPane().add(btnGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 580, 90));

        btnVip.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        btnVip.setText("VIP");
        getContentPane().add(btnVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 500, 70));

        btnPlatinum.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnPlatinum.setText("Platinum");
        btnPlatinum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatinumActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlatinum, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 420, 50));

        jTextField2.setBackground(new java.awt.Color(51, 102, 255));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("                        Escenario");
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 450, 50));

        btnEvento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEvento.setText("Seleccionar otro Evento");
        btnEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Diseño sin título (3).png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlatinumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatinumActionPerformed
        AsientosPlatinum asientosPlatinum = new AsientosPlatinum();
        asientosPlatinum.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPlatinumActionPerformed

    private void btnEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventoActionPerformed
        GestionDeEventos gestionDeEventos = new GestionDeEventos();
        gestionDeEventos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEventoActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarAsientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionarAsientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnEvento;
    private javax.swing.JButton btnGeneral;
    private javax.swing.JButton btnPlatinum;
    private javax.swing.JButton btnVip;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
