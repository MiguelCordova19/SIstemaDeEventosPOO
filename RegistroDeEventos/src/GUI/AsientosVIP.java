package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class AsientosVIP extends javax.swing.JFrame {
    private SistemaPago sistemaPago;

    public AsientosVIP() {
        initComponents();
        sistemaPago = new SistemaPago();
        configurarRestriccionesEntrada();
        configurarSeleccionAsientos();
    }
    private int[] validarEntradaAsientos() {
        String entradaAsientos = txtCantidadAsientos.getText().trim();
        int asientosSeleccionados = cmbAsientos.getSelectedIndex();

        // Verificar que se haya seleccionado una cantidad
        if (asientosSeleccionados == 0) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione la cantidad de asientos.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Si se seleccionaron 12 asientos, no es necesario validar la entrada
        if (asientosSeleccionados == cmbAsientos.getItemCount() - 1) {
            int[] asientos = new int[12];
            for (int i = 0; i < 12; i++) {
                asientos[i] = i + 1;
            }
            return asientos;
        }

        // Validar formato de entrada para otros casos
        if (!entradaAsientos.matches("^\\d+(,\\d+)*$")) {
            JOptionPane.showMessageDialog(this, "Formato de asientos inválido. Use números separados por comas.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Dividir y validar números de asientos
        String[] asientosStr = entradaAsientos.split(",");
        int[] asientos = new int[asientosStr.length];

        // Verificar cantidad de asientos - CORRECCIÓN AQUÍ
        if (asientosStr.length != asientosSeleccionados) {
            JOptionPane.showMessageDialog(this, "La cantidad de asientos no coincide con su selección.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        // Validar que cada asiento esté entre 1 y 12
        for (int i = 0; i < asientosStr.length; i++) {
            int numAsiento = Integer.parseInt(asientosStr[i]);
            if (numAsiento < 1 || numAsiento > 12) {
                JOptionPane.showMessageDialog(this, "Solo se permiten asientos del 1 al 12.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            asientos[i] = numAsiento;
        }

        return asientos;
    }
    
    private void configurarRestriccionesEntrada() {
        ((AbstractDocument) txtCantidadAsientos.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[0-9,]*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9,]*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    
    private void configurarSeleccionAsientos() {
        // Listener para el combo box de asientos
        cmbAsientos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int asientosSeleccionados = cmbAsientos.getSelectedIndex();

                // Si se seleccionan 18 asientos (último índice)
                if (asientosSeleccionados == cmbAsientos.getItemCount() - 1) {
                    // Deshabilitar el campo de texto y llenar con todos los asientos
                    txtCantidadAsientos.setText("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18");
                    txtCantidadAsientos.setEditable(false);
                } else {
                    // Habilitar el campo de texto para otros casos
                    txtCantidadAsientos.setText("");
                    txtCantidadAsientos.setEditable(true);
                }
            }
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Silla1 = new javax.swing.JLabel();
        Silla2 = new javax.swing.JLabel();
        Silla3 = new javax.swing.JLabel();
        Silla4 = new javax.swing.JLabel();
        Silla5 = new javax.swing.JLabel();
        Silla6 = new javax.swing.JLabel();
        Silla7 = new javax.swing.JLabel();
        Silla8 = new javax.swing.JLabel();
        Silla9 = new javax.swing.JLabel();
        Silla10 = new javax.swing.JLabel();
        Silla11 = new javax.swing.JLabel();
        Silla12 = new javax.swing.JLabel();
        Silla13 = new javax.swing.JLabel();
        Silla14 = new javax.swing.JLabel();
        Silla15 = new javax.swing.JLabel();
        Silla16 = new javax.swing.JLabel();
        Silla17 = new javax.swing.JLabel();
        Silla18 = new javax.swing.JLabel();
        Asiento1 = new javax.swing.JLabel();
        Asiento2 = new javax.swing.JLabel();
        Asiento3 = new javax.swing.JLabel();
        Asiento4 = new javax.swing.JLabel();
        Asiento5 = new javax.swing.JLabel();
        Asiento6 = new javax.swing.JLabel();
        Asiento7 = new javax.swing.JLabel();
        Asiento8 = new javax.swing.JLabel();
        Asiento9 = new javax.swing.JLabel();
        Asiento10 = new javax.swing.JLabel();
        Asiento11 = new javax.swing.JLabel();
        Asiento12 = new javax.swing.JLabel();
        Asiento13 = new javax.swing.JLabel();
        Asiento14 = new javax.swing.JLabel();
        Asiento15 = new javax.swing.JLabel();
        Asiento16 = new javax.swing.JLabel();
        Asiento17 = new javax.swing.JLabel();
        Asiento18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbAsientos = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        txtCantidadAsientos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnNextPagar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        btnNiveles = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Asientos VIP");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        Silla1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 70, 70));

        Silla2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 70));

        Silla3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 70, 70));

        Silla4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 70, 70));

        Silla5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 70));

        Silla6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 70, 70));

        Silla7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 70, 70));

        Silla8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 70, 70));

        Silla9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 70, 70));

        Silla10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 70, 70));

        Silla11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, 70));

        Silla12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 70, 70));

        Silla13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 70, 70));

        Silla14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 70, 70));

        Silla15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 70, 70));

        Silla16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 70, 70));

        Silla17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla17, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 70, 70));

        Silla18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Asientos (1).png"))); // NOI18N
        getContentPane().add(Silla18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 70, 70));

        Asiento1.setText("Asiento 2");
        getContentPane().add(Asiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 60, 30));

        Asiento2.setText("  Asiento 18");
        getContentPane().add(Asiento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 70, 30));

        Asiento3.setText("Asiento 1");
        getContentPane().add(Asiento3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 166, 60, 20));

        Asiento4.setText("Asiento 3");
        getContentPane().add(Asiento4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 60, 30));

        Asiento5.setText("Asiento 4");
        getContentPane().add(Asiento5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 60, 30));

        Asiento6.setText("Asiento 5");
        getContentPane().add(Asiento6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 60, 30));

        Asiento7.setText("Asiento 6");
        getContentPane().add(Asiento7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 60, 30));

        Asiento8.setText("Asiento 7");
        getContentPane().add(Asiento8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 60, 30));

        Asiento9.setText("Asiento 8");
        getContentPane().add(Asiento9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 60, 30));

        Asiento10.setText("Asiento 9");
        getContentPane().add(Asiento10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 160, 60, 30));

        Asiento11.setText("  Asiento 10");
        getContentPane().add(Asiento11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 70, 30));

        Asiento12.setText("  Asiento 11");
        getContentPane().add(Asiento12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 70, 30));

        Asiento13.setText("  Asiento 12");
        getContentPane().add(Asiento13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 70, 30));

        Asiento14.setText("  Asiento 13");
        getContentPane().add(Asiento14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 70, 30));

        Asiento15.setText("  Asiento 14");
        getContentPane().add(Asiento15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 70, 30));

        Asiento16.setText("  Asiento 15");
        getContentPane().add(Asiento16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 70, 30));

        Asiento17.setText("  Asiento 16");
        getContentPane().add(Asiento17, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 70, 30));

        Asiento18.setText("  Asiento 17");
        getContentPane().add(Asiento18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 70, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¿Cuantos asientos reservara?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        cmbAsientos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la cantidad...", "Un Asiento", "Dos Asientos", "Tres Asientos", "Cuatro Asientos", "Cinco Asientos", "Seis Asientos", "Siete Asientos", "Ocho Asientos", "Nueve Asientos", "Diez Asientos", "Once Asientos", "Doce Asientos", "Trece Asientos", "Catorce Asientos", "Quince Asientos", "Dieciseis Asientos", "Dieciocho Asientos" }));
        getContentPane().add(cmbAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 170, 30));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 730, 210));
        getContentPane().add(txtCantidadAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 170, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Escriba los Asientos que desee reservar:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        btnNextPagar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNextPagar.setText("Ir a Pagar");
        btnNextPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextPagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnNextPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, 40));

        btnAnular.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnular, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, 40));

        btnNiveles.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNiveles.setText("Seleccionar Otros Niveles");
        btnNiveles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNivelesActionPerformed(evt);
            }
        });
        getContentPane().add(btnNiveles, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, -1, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Diseño sin título (3).png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextPagarActionPerformed
        int[] asientos = validarEntradaAsientos();
        if (asientos != null) {
            for (int numAsiento : asientos) {
                String numAsientoStr = String.valueOf(numAsiento);
                sistemaPago.agregarAsientoSeleccionado(numAsientoStr, 150.0, "VIP");
            }
            sistemaPago.setVisible(true);
            this.dispose();
        } else {
            // Maneja el caso en que validarEntradaAsientos() devuelve null
            JOptionPane.showMessageDialog(this, "No se han seleccionado asientos válidos.");
        }
    }//GEN-LAST:event_btnNextPagarActionPerformed

    private void btnNivelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNivelesActionPerformed
        SeleccionarAsientos seleccionarAsientos = new SeleccionarAsientos();
        seleccionarAsientos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNivelesActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        SeleccionarAsientos seleccionarAsientos = new SeleccionarAsientos();
        seleccionarAsientos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAnularActionPerformed

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
            java.util.logging.Logger.getLogger(AsientosVIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsientosVIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsientosVIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsientosVIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsientosVIP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Asiento1;
    private javax.swing.JLabel Asiento10;
    private javax.swing.JLabel Asiento11;
    private javax.swing.JLabel Asiento12;
    private javax.swing.JLabel Asiento13;
    private javax.swing.JLabel Asiento14;
    private javax.swing.JLabel Asiento15;
    private javax.swing.JLabel Asiento16;
    private javax.swing.JLabel Asiento17;
    private javax.swing.JLabel Asiento18;
    private javax.swing.JLabel Asiento2;
    private javax.swing.JLabel Asiento3;
    private javax.swing.JLabel Asiento4;
    private javax.swing.JLabel Asiento5;
    private javax.swing.JLabel Asiento6;
    private javax.swing.JLabel Asiento7;
    private javax.swing.JLabel Asiento8;
    private javax.swing.JLabel Asiento9;
    private javax.swing.JLabel Silla1;
    private javax.swing.JLabel Silla10;
    private javax.swing.JLabel Silla11;
    private javax.swing.JLabel Silla12;
    private javax.swing.JLabel Silla13;
    private javax.swing.JLabel Silla14;
    private javax.swing.JLabel Silla15;
    private javax.swing.JLabel Silla16;
    private javax.swing.JLabel Silla17;
    private javax.swing.JLabel Silla18;
    private javax.swing.JLabel Silla2;
    private javax.swing.JLabel Silla3;
    private javax.swing.JLabel Silla4;
    private javax.swing.JLabel Silla5;
    private javax.swing.JLabel Silla6;
    private javax.swing.JLabel Silla7;
    private javax.swing.JLabel Silla8;
    private javax.swing.JLabel Silla9;
    private javax.swing.JLabel background;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnNextPagar;
    private javax.swing.JButton btnNiveles;
    private javax.swing.JComboBox<String> cmbAsientos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txtCantidadAsientos;
    // End of variables declaration//GEN-END:variables
}
