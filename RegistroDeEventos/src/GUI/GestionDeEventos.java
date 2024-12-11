package GUI;
        
import Clases.AsientoSeleccionado;
import Clases.Carrito;
import Clases.Evento;
import Clases.EventoManager;
import Clases.EventoSeleccionado;
import HashSet.EventoHashet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import GUI.SistemaPago;


public class GestionDeEventos extends javax.swing.JFrame {
    private EventoHashet gestorEventos;
    private EventoSeleccionado eventoSeleccionado;
    private List<AsientoSeleccionado> asientosSeleccionados;
    
    int xMouse, yMouse;
    public GestionDeEventos() {
        initComponents();
        gestorEventos = new EventoHashet();
        cargarEventosEnComboBox();
        configurarEventos();
        eventoSeleccionado = null; // Inicializar eventoSeleccionado
        asientosSeleccionados = new ArrayList<>();
    }
    
    private void cargarEventosEnComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Evento evento : gestorEventos.getListaEventos()) {
            model.addElement(evento.getNombre());
        }
        cmbEventos.setModel(model);
    }
    
    private void configurarEventos() {
        cmbEventos.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreSeleccionado = (String) cmbEventos.getSelectedItem();
            Evento eventoSeleccionado = gestorEventos.buscarEventoPorNombre(nombreSeleccionado);
            
            if (eventoSeleccionado != null) {
                // Actualizar todos los campos con la información del evento
                jTextArea1.setText(eventoSeleccionado.getDescripcion());
                txtPrecio.setText(String.format("%.2f", eventoSeleccionado.getPrecio()));
                
                // Nuevos campos
                jTextField1.setText(eventoSeleccionado.getAmbiente());
                jTextField2.setText(String.valueOf(eventoSeleccionado.getCapacidad()));
                jTextField3.setText(eventoSeleccionado.getFecha());
                jTextField4.setText(eventoSeleccionado.getLugar());
                jTextField5.setText(eventoSeleccionado.getEstado());
                
                // Hacer los campos de texto no editables
                txtPrecio.setEditable(false);
                jTextField1.setEditable(false);
                jTextField2.setEditable(false);
                jTextField3.setEditable(false);
                jTextField4.setEditable(false);
                jTextField5.setEditable(false);
                jTextArea1.setEditable(false);
            }
        }
    });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        BarraSuperior = new javax.swing.JPanel();
        btnSalir = new javax.swing.JLabel();
        cmbEventos = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnEscoger = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setDoubleBuffered(false);
        bg.setOpaque(false);
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BarraSuperior.setBackground(new java.awt.Color(255, 255, 255));
        BarraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraSuperiorMouseDragged(evt);
            }
        });
        BarraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraSuperiorMousePressed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Cerrar.png"))); // NOI18N
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addComponent(btnSalir)
                .addGap(0, 840, Short.MAX_VALUE))
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addComponent(btnSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bg.add(BarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 40));

        cmbEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEventosActionPerformed(evt);
            }
        });
        bg.add(cmbEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 530, 50));
        bg.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 80, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        txtDescripcion.setViewportView(jTextArea1);

        bg.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 640, -1));

        btnEscoger.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnEscoger.setText("Escoger Asientos");
        btnEscoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscogerActionPerformed(evt);
            }
        });
        bg.add(btnEscoger, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, -1, -1));
        bg.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 110, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ambiente:");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio del Evento:");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione un Evento:");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripción:");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Big John", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COMPRE SU ENTRADA");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 460, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Capacidad:");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, -1, -1));
        bg.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 110, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha:");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));
        bg.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 140, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Lugar:");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, -1, -1));
        bg.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 200, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Estado:");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, -1, -1));
        bg.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 190, 40));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Diseño sin título (3).png"))); // NOI18N
        Background.setText("jLabel1");
        bg.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 880, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_BarraSuperiorMousePressed

    private void BarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_BarraSuperiorMouseDragged

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnEscogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscogerActionPerformed
        if (eventoSeleccionado != null) {
            // Pasar el evento seleccionado al Carrito antes de abrir SeleccionarAsientos
            Carrito G_carrito = Carrito.getInstance();
            G_carrito.agregarEvento(eventoSeleccionado.getNombre());

            SeleccionarAsientos G_seleccionarAsientos = new SeleccionarAsientos();

            // Mostrar información de asientos previamente seleccionados si existen
            List<AsientoSeleccionado> asientosAnteriores = 
                Carrito.getInstance().getAsientosSeleccionados(eventoSeleccionado.getNombre());

            if (!asientosAnteriores.isEmpty()) {
                String mensaje = "Tiene " + asientosAnteriores.size() + " asientos seleccionados previamente para este evento.";
                JOptionPane.showMessageDialog(this, mensaje, "Asientos Previos", JOptionPane.INFORMATION_MESSAGE);
            }

            G_seleccionarAsientos.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un evento antes de continuar.");
        }
    }//GEN-LAST:event_btnEscogerActionPerformed
    
    private void cmbEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEventosActionPerformed
        String nombreSeleccionado = (String) cmbEventos.getSelectedItem();
        Evento eventoSeleccionado = gestorEventos.buscarEventoPorNombre(nombreSeleccionado);

        if (eventoSeleccionado != null) {
            this.eventoSeleccionado = new EventoSeleccionado(); // Actualizar eventoSeleccionado
            this.eventoSeleccionado.setNombre(eventoSeleccionado.getNombre());
            this.eventoSeleccionado.setFecha(eventoSeleccionado.getFecha());
            this.eventoSeleccionado.setPrecio(eventoSeleccionado.getPrecio());
            EventoManager.setEventoSeleccionado(this.eventoSeleccionado);
        }
    }//GEN-LAST:event_cmbEventosActionPerformed

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
            java.util.logging.Logger.getLogger(GestionDeEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionDeEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionDeEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionDeEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionDeEventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnEscoger;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JComboBox<String> cmbEventos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JScrollPane txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
