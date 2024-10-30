package GUI;
        
import Clases.Evento;
import Clases.GestorEventos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class GestionDeEventos extends javax.swing.JFrame {
    private GestorEventos gestorEventos;
    
    int xMouse, yMouse;
    public GestionDeEventos() {
        initComponents();
        gestorEventos = new GestorEventos();
        cargarEventosEnComboBox();
        configurarEventos();
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
                    txtDescripcion.setText(eventoSeleccionado.getDescripcion());
                    txtPrecio.setText(String.format("%.2f", eventoSeleccionado.obtenerPrecio()));
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
        txtDescripcion = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnEscoger = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        bg.add(cmbEventos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 420, 60));
        bg.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 490, 60));
        bg.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 490, 60));

        btnEscoger.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btnEscoger.setText("Escoger Asientos");
        btnEscoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscogerActionPerformed(evt);
            }
        });
        bg.add(btnEscoger, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Precio del Evento:");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seleccione un Evento:");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripción:");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Big John", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Seleccion de evento");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 460, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Diseño sin título (3).png"))); // NOI18N
        jLabel1.setText("jLabel1");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 880, 550));

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
        SeleccionarAsientos pf = new SeleccionarAsientos();
        pf.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEscogerActionPerformed
    
    private void cmbEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEventosActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
