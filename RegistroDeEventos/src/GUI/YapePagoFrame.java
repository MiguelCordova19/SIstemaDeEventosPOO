
package GUI;

import ConexionDB.SQLConexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class YapePagoFrame extends javax.swing.JFrame {

    public YapePagoFrame() {
        initComponents();
         // Agregar un DocumentListener para validar que txtOperacion tenga solo 8 dígitos
            txtOperacion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> validarOperacion());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> validarOperacion());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(() -> validarOperacion());
            }

            private void validarOperacion() {
                String texto = txtOperacion.getText();
                // Eliminar cualquier carácter que no sea un número
                String textoSoloNumeros = texto.replaceAll("[^0-9]", "");

                // Limitar a 8 dígitos
                if (textoSoloNumeros.length() > 8) {
                    textoSoloNumeros = textoSoloNumeros.substring(0, 8);
                }

                // Cambiar el texto solo si es diferente
                if (!texto.equals(textoSoloNumeros)) {
                    txtOperacion.setText(textoSoloNumeros);
                }
            }
        });

        // Configurar el botón Confirmar
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar que se haya ingresado un número de operación de 8 dígitos
                if (txtOperacion.getText().length() == 8) {
                    // Obtener los datos de la compra
                    int idUsuario = 6; // Obtener el id_usuario del usuario que inició sesión
                    double montoTotal = Double.parseDouble(txtMonto.getText());
                    String metodoPago = "Yape";
                    String estadoCompra = "Completada";

                    // Registrar la compra en la base de datos
                    SQLConexion.insertCompra(idUsuario, montoTotal, metodoPago, estadoCompra);

                    JOptionPane.showMessageDialog(null, "Pago exitoso realizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // Regresar a GestionDeEventos
                    GestionDeEventos gestionDeEventos = new GestionDeEventos();
                    gestionDeEventos.setVisible(true);

                    dispose(); // Cerrar el frame actual de Yape
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número de operación de 8 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void setMontoTotal(String total) {
        txtMonto.setText(total);
        txtMonto.setEditable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yape = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtOperacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        yape.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Yape.png"))); // NOI18N
        getContentPane().add(yape, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 310, 310));

        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnConfirmar.setText("Confirmar Pago");
        getContentPane().add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese el N° de Operacion:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, 40));
        getContentPane().add(txtOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 200, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Una vez haya pagado, colocar el N° de Operación para validar el pago");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Monto a Yapear");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 140, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Diseño sin título (3).png"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 540));

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
            java.util.logging.Logger.getLogger(YapePagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YapePagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YapePagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YapePagoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YapePagoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtOperacion;
    private javax.swing.JLabel yape;
    // End of variables declaration//GEN-END:variables
}
