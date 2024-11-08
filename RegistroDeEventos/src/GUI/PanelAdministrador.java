
package GUI;

import BaseDeDatos.UsuariosCreados;
import Clases.Plataforma;
import Clases.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelAdministrador extends javax.swing.JFrame {

    private Plataforma plataforma;
    
    public PanelAdministrador() {
        this.plataforma = new Plataforma();
        initComponents();
        cargarUsuariosEnTabla();
        llenarTablaConUsuarios();

    }

    private void llenarTablaConUsuarios() {
        Set<Usuario> usuarios = plataforma.obtenerUsuarios();
    
        // Limpiar el modelo de la tabla
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);

        // Verificar si el conjunto de usuarios está vacío
        if (usuarios.isEmpty()) {
            // Mostrar un mensaje o manejar el caso donde no hay usuarios
            System.out.println("No se encontraron usuarios.");
            return;
        }

        // Llenar la tabla con los usuarios
        for (Usuario usuario : usuarios) {
            ((DefaultTableModel) jTable1.getModel()).addRow(new Object[] {
                usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getGenero(), "Nivel Usuario"
            });
        }
    }
    
    private void cargarUsuariosEnTabla(){
        List<Usuario> usuarios = UsuariosCreados.obtenerUsuarios();
        ((DefaultTableModel) jTable1.getModel()).setRowCount(0);
        for (Usuario usuario : usuarios){
            ((DefaultTableModel) jTable1.getModel()).addRow(new Object[]{
                usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getGenero(), "Nivel Usuario"
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnAsignar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Nombre de Usuario", "Correo", "Género", "Rol"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnEliminar.setText("Eliminar Usuario");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAsignar.setText("Asignar Administrador");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(btnActualizar)
                .addGap(41, 41, 41)
                .addComponent(btnAsignar)
                .addGap(50, 50, 50)
                .addComponent(btnEliminar)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAsignar)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios Registrados", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 930, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 930, 430));

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        getContentPane().add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 540, -1, -1));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Panel de Administración");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/abstract-vertical-background-with-a-combination-of-light-blue-and-dark-blue-gradient-colors-free-vector.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 601));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        System.out.println("Contenido del archivo antes de eliminar:");
        imprimirContenidoArchivo();
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String nombreUsuario = (String) jTable1.getValueAt(selectedRow, 1);
            Usuario usuario = new Usuario(
                (String) jTable1.getValueAt(selectedRow, 0),
                nombreUsuario,
                (String) jTable1.getValueAt(selectedRow, 2),
                (String) jTable1.getValueAt(selectedRow, 3),
                "", // La clave no se necesita para eliminar
                (String) jTable1.getValueAt(selectedRow, 4),
                "" // La fecha de nacimiento no se necesita para eliminar
            );
            try {
                plataforma.eliminarUsuario(usuario);
                // Actualizar la tabla
                llenarTablaConUsuarios();
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("Contenido del archivo después de eliminar:");
        imprimirContenidoArchivo();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void imprimirContenidoArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(UsuariosCreados.ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        llenarTablaConUsuarios();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(PanelAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
