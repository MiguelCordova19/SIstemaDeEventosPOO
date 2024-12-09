package GUI;

import Clases.AsientoPlatinum;
import Clases.AsientoSeleccionado;
import Clases.EventoManager;
import Clases.EventoSeleccionado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class SistemaPago extends javax.swing.JFrame {
    private List<AsientoSeleccionado> asientosSeleccionados;
    private javax.swing.JTextField txtEntradas;
    private javax.swing.JTextField txtPersonas;
    private String claseAsientoSeleccionada;
    private List<AsientoPlatinum> asientosPlatinum;

    
    public SistemaPago() {
        initComponents();
        cargarEventoSeleccionado();
        asientosSeleccionados = new ArrayList<>();
        
        txtEntradas = new javax.swing.JTextField();
        txtPersonas = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
    }

    public void seleccionarAsientoPlatinum() {
        claseAsientoSeleccionada = "Platinum";
        actualizarTabla();
    }
    
    public void seleccionarAsientoVIP() {
        claseAsientoSeleccionada = "VIP";
        actualizarTabla();
    }

    public void seleccionarAsientoGeneral() {
        claseAsientoSeleccionada = "General";
        actualizarTabla();
    }
    
    private void cargarEventoSeleccionado() {
        EventoSeleccionado eventoSeleccionado = EventoManager.getEventoSeleccionado();
        if (eventoSeleccionado != null) {
            txtEvento.setText(eventoSeleccionado.getNombre());
            txtFecha.setText(eventoSeleccionado.getFecha());
            txtTotal.setText(String.format("%.2f", eventoSeleccionado.getPrecio()));
        }
    }
    
    public void agregarAsientoSeleccionado(int numAsiento, double precio) {
        AsientoSeleccionado asiento = new AsientoSeleccionado(numAsiento, precio, claseAsientoSeleccionada);
        asientosSeleccionados.add(asiento);
        actualizarTabla();
    }
    
    private void actualizarTabla() {
        int entradas = asientosSeleccionados.size();
        int personas = asientosSeleccionados.size();
        double total = asientosSeleccionados.stream()
                        .mapToDouble(AsientoSeleccionado::getPrecio)
                        .sum();

        txtEntradas.setText(String.valueOf(entradas));
        txtPersonas.setText(String.valueOf(personas));
        txtTotal.setText(String.format("%.2f", total));

        // Actualizar los datos de la tabla
        ((DefaultTableModel) tblResultado.getModel())
            .setRowCount(0); // Limpiar la tabla
        for (AsientoSeleccionado asiento : asientosSeleccionados) {
            ((DefaultTableModel) tblResultado.getModel())
                .addRow(new Object[] {
                    asiento.getNumAsiento(),
                    1, // Personas por asiento
                    asiento.getPrecio()
                });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtEvento = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boxTerminos = new javax.swing.JCheckBox();
        rbtBcp = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbtBilletera = new javax.swing.JRadioButton();
        jTextField4 = new javax.swing.JTextField();
        rbtTarjetas = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        rbtPago = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultado = new javax.swing.JTable();
        btnPagar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(860, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 270, 30));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 280, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Evento:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¡Escoge tu método de Pago Favorito!");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        boxTerminos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boxTerminos.setForeground(new java.awt.Color(255, 255, 255));
        boxTerminos.setText("He leído y acepto los Términos y condiciones");
        boxTerminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTerminosActionPerformed(evt);
            }
        });
        getContentPane().add(boxTerminos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        buttonGroup1.add(rbtBcp);
        rbtBcp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rbtBcp.setText("Vía BCP");
        getContentPane().add(rbtBcp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logoBCP.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 120, 40));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 500, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Billeteras Moviles.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 120, 40));

        buttonGroup1.add(rbtBilletera);
        rbtBilletera.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rbtBilletera.setText("Yape, Plin, Tunki, Lukita");
        rbtBilletera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtBilleteraActionPerformed(evt);
            }
        });
        getContentPane().add(rbtBilletera, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, 40));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 500, 60));

        buttonGroup1.add(rbtTarjetas);
        rbtTarjetas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rbtTarjetas.setText("Tarjetas de Crédito/Débito");
        getContentPane().add(rbtTarjetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Tarjetas.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 120, 40));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 500, 60));

        buttonGroup1.add(rbtPago);
        rbtPago.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rbtPago.setText("Pago en Efectivo");
        getContentPane().add(rbtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Pago Efectivo.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 120, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, -1, 30));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 340, 100, 40));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 500, 60));

        tblResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Entradas", "Clase", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tblResultado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 280, 130));

        btnPagar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPagar.setText("Pagar");
        getContentPane().add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRegresar.setText("<- Regresar");
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Diseño sin título (3).png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxTerminosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTerminosActionPerformed
        
    }//GEN-LAST:event_boxTerminosActionPerformed

    private void rbtBilleteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBilleteraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtBilleteraActionPerformed

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
            java.util.logging.Logger.getLogger(SistemaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JCheckBox boxTerminos;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JRadioButton rbtBcp;
    private javax.swing.JRadioButton rbtBilletera;
    private javax.swing.JRadioButton rbtPago;
    private javax.swing.JRadioButton rbtTarjetas;
    private javax.swing.JTable tblResultado;
    private javax.swing.JTextField txtEvento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
