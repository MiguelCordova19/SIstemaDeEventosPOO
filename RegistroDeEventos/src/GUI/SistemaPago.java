package GUI;

import Clases.AsientoPlatinum;
import Clases.AsientoSeleccionado;
import Clases.AsientoVIP;
import Clases.AsientoGeneral;
import Clases.Carrito;
import Clases.EventoManager;
import Clases.EventoSeleccionado;
import Clases.TotalManager;
import Clases.TotalObserver;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class SistemaPago extends javax.swing.JFrame implements TotalObserver{
    private List<AsientoSeleccionado> asientosSeleccionados;
    private javax.swing.JTextField txtEntradas;
    private javax.swing.JTextField txtPersonas;
    private String claseAsientoSeleccionada;
    private List<AsientoPlatinum> asientosPlatinum;
    private List<AsientoVIP> asientosVIP;
    private List<AsientoGeneral> asientosGeneral;
    private TotalManager totalManager;
    
    public SistemaPago() {
        initComponents();
        totalManager = new TotalManager();
        totalManager.registrarObservador(this);
        asientosSeleccionados = new ArrayList<>();
        cargarEventoSeleccionado();
        btnTotal.addActionListener(evt -> actualizarTotal());
        txtTotal.setText("0.00");
        tblResultado.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Entradas", "Clase", "Precio"}
        ));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
    }   

    @Override
    public void actualizarTotal(double total) {
        txtTotal.setText(String.format("%.2f", total));
    }

    private void cargarEventoSeleccionado() {
        EventoSeleccionado eventoSeleccionado = EventoManager.getEventoSeleccionado();
        if (eventoSeleccionado != null) {
            txtEvento.setText(eventoSeleccionado.getNombre());
            txtFecha.setText(eventoSeleccionado.getFecha());

            // Limpiar la lista de asientos seleccionados
            asientosSeleccionados.clear();

            // Cargar asientos de TODOS los eventos en el carrito
            for (String eventoId : Carrito.getInstance().getTodosLosEventos()) {
                List<AsientoSeleccionado> asientosCarrito = Carrito.getInstance().getAsientosSeleccionados(eventoId);
                asientosSeleccionados.addAll(asientosCarrito);
            }

            actualizarTabla(); // Actualiza la tabla con TODOS los asientos del carrito
        }
    }
    
    private boolean validarPago() {
        // Verificar que se haya hecho clic en el botón "Mostrar el Precio Total"
        if (txtTotal.getText().equals("0.00")) {
            JOptionPane.showMessageDialog(this, "Debe mostrar el precio total antes de pagar.");
            return false;
        }

        // Verificar que se haya seleccionado la casilla de términos y condiciones
        if (!boxTerminos.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe aceptar los términos y condiciones antes de pagar.");
            return false;
        }

        // Verificar que se haya seleccionado al menos una opción de pago
        if (!rbtBcp.isSelected() && !rbtBilletera.isSelected() && !rbtTarjetas.isSelected() && !rbtPago.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos una opción de pago.");
            return false;
        }

        return true;
    }
    
    public void agregarAsientoSeleccionado(String numAsiento, double precio, String tipo) {
        int numAsientoInt = Integer.parseInt(numAsiento);
        AsientoSeleccionado asiento = new AsientoSeleccionado(numAsientoInt, precio, tipo);

        // Obtener el ID del evento seleccionado
        String eventoId = txtEvento.getText(); // o cualquier otro identificador único que uses

        // Agregar asiento al carrito
        Carrito.getInstance().agregarAsiento(eventoId, asiento);

        asientosSeleccionados.add(asiento);
        actualizarTabla();
    }
    
    private void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblResultado.getModel();
        limpiarTabla();
        for (AsientoSeleccionado asiento : asientosSeleccionados) {
            modelo.addRow(new Object[]{
                asiento.getNumAsiento(),
                asiento.getClase(),
                asiento.getPrecio(),
                "Eliminar"  // Texto para el botón
            });
        }
    }
    
    private void actualizarTotal() {
        if (asientosSeleccionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay asientos seleccionados", "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtTotal.setText("0.00");
            return;
        }

        double total = 0.0;
        for (AsientoSeleccionado asiento : asientosSeleccionados) {
            total += asiento.getPrecio(); // Aquí asumimos que el precio ya es un double
        }
        txtTotal.setText(String.format("%.2f", total));
    }
    
    private void imprimirTabla() {
        System.out.println("Contenido de la tabla tblResultado:");
        DefaultTableModel model = (DefaultTableModel) tblResultado.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            System.out.println("Fila " + i + ": " +
                    tblResultado.getValueAt(i, 0) + ", " +
                    tblResultado.getValueAt(i, 1) + ", " +
                    tblResultado.getValueAt(i, 2));
        }
    }
    
    private void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) tblResultado.getModel();
        model.setRowCount(0); // Borra todas las filas
    }
    
    private void procesarPagoBcp() {
        // Aquí debes agregar la lógica de procesamiento del pago a través de las billeteras móviles
        // Puedes utilizar alguna API o servicio de pago en línea para procesar el pago
        JOptionPane.showMessageDialog(this, "Pago a través de BCP en proceso...");
        // Agrega aquí el código para procesar el pago
    }
    
    private void procesarPagoBilletera() {
        // Aquí debes agregar la lógica de procesamiento del pago a través de las billeteras móviles
        // Puedes utilizar alguna API o servicio de pago en línea para procesar el pago
        JOptionPane.showMessageDialog(this, "Pago a través de billeteras móviles en proceso...");
        // Agrega aquí el código para procesar el pago
    }
    
    private void procesarPagoTarjetas() {
        // Aquí debes agregar la lógica de procesamiento del pago a través de las billeteras móviles
        // Puedes utilizar alguna API o servicio de pago en línea para procesar el pago
        JOptionPane.showMessageDialog(this, "Pago a través de tarjetas en proceso...");
        // Agrega aquí el código para procesar el pago
    }
    
    private void procesarPagoEfectivo() {
        // Aquí debes agregar la lógica de procesamiento del pago a través de las billeteras móviles
        // Puedes utilizar alguna API o servicio de pago en línea para procesar el pago
        JOptionPane.showMessageDialog(this, "Pago a través de PagoEfectivo en proceso...");
        // Agrega aquí el código para procesar el pago
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
        btnTotal = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
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
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, -1, 30));

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 100, 40));
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 280, 130));

        btnPagar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRegresar.setText("<- Seguir Comprando");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, -1, -1));

        btnTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTotal.setText("Mostrar el Precio Total");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });
        getContentPane().add(btnTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar Asiento");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Diseño sin título (3).png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxTerminosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTerminosActionPerformed
        
    }//GEN-LAST:event_boxTerminosActionPerformed

    private void rbtBilleteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtBilleteraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtBilleteraActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        actualizarTotal();
    }//GEN-LAST:event_btnTotalActionPerformed
   
    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // Aquí deberías llamar al método que actualiza el total
        actualizarTotal();
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();  // Cierra el frame actual

        // Crea y muestra el frame de GestionDeEventos
        GestionDeEventos gestionDeEventos = new GestionDeEventos();
        gestionDeEventos.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (validarPago()) {
            // Verificar específicamente si está seleccionado el radio button de billetera
            if (rbtBilletera.isSelected()) {
                YapePagoFrame yapePagoFrame = new YapePagoFrame(); // Constructor sin parámetros
                yapePagoFrame.setMontoTotal(txtTotal.getText()); // Establecer monto después de crear
                yapePagoFrame.setVisible(true);
                this.dispose(); // Cierra el frame actual de SistemaPago
            } else {
                // Para otras opciones de pago (BCP, Tarjetas, Efectivo)
                if (rbtBcp.isSelected()) {
                    procesarPagoBcp();
                } else if (rbtTarjetas.isSelected()) {
                    procesarPagoTarjetas();
                } else if (rbtPago.isSelected()) {
                    procesarPagoEfectivo();
                }

                // Después de procesar el pago, abrir GestionDeEventos
                GestionDeEventos gestionDeEventos = new GestionDeEventos();
                gestionDeEventos.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tblResultado.getSelectedRow();
    
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, 
                "Necesita seleccionar un asiento si desea eliminar", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener los datos de la fila seleccionada
        DefaultTableModel modelo = (DefaultTableModel) tblResultado.getModel();
        int numAsiento = Integer.parseInt(modelo.getValueAt(filaSeleccionada, 0).toString());
        String clase = modelo.getValueAt(filaSeleccionada, 1).toString();

        // Eliminar el asiento de la lista de asientos seleccionados
        AsientoSeleccionado asientoAEliminar = null;
        for (AsientoSeleccionado asiento : asientosSeleccionados) {
            if (asiento.getNumAsiento() == numAsiento && asiento.getClase().equals(clase)) {
                asientoAEliminar = asiento;
                break;
            }
        }

        if (asientoAEliminar != null) {
            // Eliminar del carrito
            String eventoId = txtEvento.getText();
            Carrito.getInstance().eliminarAsiento(eventoId, asientoAEliminar);

            // Eliminar de la lista local
            asientosSeleccionados.remove(asientoAEliminar);

            // Actualizar la tabla
            actualizarTabla();

            // Actualizar el total
            actualizarTotal();

            JOptionPane.showMessageDialog(this, 
                "Asiento eliminado correctamente", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTotal;
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
