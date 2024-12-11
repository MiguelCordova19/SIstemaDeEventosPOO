
package GUI;

import BaseDeDatos.UsuarioDAO;
import BaseDeDatos.UsuariosCreados;
import Clases.DateHandler;
import Clases.Usuario;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class CrearCuenta extends javax.swing.JFrame {

    private DateHandler dateHandler;
    
    public CrearCuenta() {
        try {
            initComponents();
            UsuarioDAO.crearTablaUsuarios();
            initValidaciones();
            setupDateHandler(); // Añadir esta llamada
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error al inicializar la ventana: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setupDateHandler() {
        txtNombre.setDocument(new SoloLetras());
        txtApellido.setDocument(new SoloLetras());
        buttonGroup1.clearSelection();
        txtVerificado.setEditable(false);
        txtUsuario.addFocusListener(new UsernameAvailabilityListener());
    }

    private void initValidaciones() {
        // Validación de nombre y apellidos (solo letras)
        txtNombre.setDocument(new SoloLetras());
        txtApellido.setDocument(new SoloLetras());

        // Validación de selección de género
        buttonGroup1.clearSelection();

        // Validación de fecha de nacimiento
        cmbMes.setEnabled(false);
        cmdDia.setEnabled(false);
        cmbYear.addItemListener(new YearSelectedListener());

        // Validación de disponibilidad de nombre de usuario
        txtVerificado.setEditable(false);
        txtUsuario.addFocusListener(new UsernameAvailabilityListener());
    }
    
    private class SoloLetras extends PlainDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str != null && !str.matches("[a-zA-Z\\s]")) {
                return;
            }
            super.insertString(offs, str, a);
        }
    }
    
    private class UsernameAvailabilityListener implements FocusListener {
        @Override
        public void focusLost(FocusEvent e) {
            btnVerificarActionPerformed(null);
        }

        @Override
        public void focusGained(FocusEvent e) {
        }
    }
    
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z\\s]+");
    }

    private boolean isValidEmail(String email) {
        return true;
    }
    
    private String getSelectedGender() {
        if (rbtMasculino.isSelected()) {
            return "Masculino";
        } else if (rbtFemenino.isSelected()) {
            return "Femenino";
        } else {
            return "";
        }
    }
    
    private void updateDayOptions(int year, String month) {
        cmdDia.removeAllItems();
        cmdDia.addItem("Día");

        int maxDays;
        switch (month) {
            case "Enero":
            case "Marzo":
            case "Mayo":
            case "Julio":
            case "Agosto":
            case "Octubre":
            case "Diciembre":
                maxDays = 31;
                break;
            case "Abril":
            case "Junio":
            case "Septiembre":
            case "Noviembre":
                maxDays = 30;
                break;
            case "Febrero":
                if (isLeapYear(year)) {
                    maxDays = 29;
                } else {
                    maxDays = 28;
                }
                break;
            default:
                maxDays = 31;
                break;
        }

        for (int i = 1; i <= maxDays; i++) {
            cmdDia.addItem(String.valueOf(i));
        }
        
        cmbMes.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED && !cmbYear.getSelectedItem().equals("Año")) {
                String selectedYear = (String) cmbYear.getSelectedItem();
                String selectedMonth = (String) cmbMes.getSelectedItem();
                updateDayOptions(Integer.parseInt(selectedYear), selectedMonth);
                cmdDia.setEnabled(true);
            }
        }
    });
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
        
    private class YearSelectedListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                Object selectedItem = cmbYear.getSelectedItem();
                if (selectedItem instanceof String) {
                    String yearStr = (String) selectedItem;
                    // Solo actualizar si no es "Año"
                    if (!yearStr.equals("Año")) {
                        try {
                            int selectedYear = Integer.parseInt(yearStr);
                            String selectedMonth = (String) cmbMes.getSelectedItem();
                            updateDayOptions(selectedYear, selectedMonth);
                            cmbMes.setEnabled(true);
                            cmdDia.setEnabled(true);
                        } catch (NumberFormatException ex) {
                            // Manejar el error silenciosamente
                            cmbMes.setEnabled(false);
                            cmdDia.setEnabled(false);
                        }
                    } else {
                        // Si se selecciona "Año", deshabilitar los otros combobox
                        cmbMes.setEnabled(false);
                        cmdDia.setEnabled(false);
                    }
                }
            }
        }
    }
    
    private void resetForm() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtUsuario.setText("");
        txtCorreo.setText("");
        txtClave.setText("");
        txtConfirmarClave.setText("");
        buttonGroup1.clearSelection();
        txtVerificado.setText("");
        cmbMes.setEnabled(false);
        cmdDia.setEnabled(false);
        cmbYear.setSelectedItem("Año");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtUsuario = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cmbMes = new javax.swing.JComboBox<>();
        cmbYear = new javax.swing.JComboBox<>();
        cmdDia = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rbtMasculino = new javax.swing.JRadioButton();
        rbtFemenino = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnVerificar = new javax.swing.JButton();
        txtVerificado = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();
        txtConfirmarClave = new javax.swing.JPasswordField();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 230, 30));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 240, 30));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 270, 30));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 340, 30));

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        getContentPane().add(cmbMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, 30));

        cmbYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990" }));
        cmbYear.setToolTipText("");
        getContentPane().add(cmbYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, 30));

        cmdDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Día" }));
        getContentPane().add(cmdDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, -1, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha de Nacimiento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellido:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Correo Electronico:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre De Usuario:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¡Y empieza a participar de Eventos hoy mismo!");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crea tu Cuenta");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Género:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        buttonGroup1.add(rbtMasculino);
        rbtMasculino.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rbtMasculino.setForeground(new java.awt.Color(255, 255, 255));
        rbtMasculino.setText("Masculino");
        getContentPane().add(rbtMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, 50));

        buttonGroup1.add(rbtFemenino);
        rbtFemenino.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rbtFemenino.setForeground(new java.awt.Color(255, 255, 255));
        rbtFemenino.setText("Femenino");
        getContentPane().add(rbtFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, -1, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Contraseña:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Confirmar Contraseña:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        btnVerificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerificar.setText("Verificar Disponibilidad");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, 30));
        getContentPane().add(txtVerificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 160, 30));

        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        btnCrear.setText("Crear Cuenta");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 220, 30));
        getContentPane().add(txtConfirmarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 240, 30));

        Background.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Background.setForeground(new java.awt.Color(255, 255, 255));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Items/Diseño sin título (3).png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // Validar campos obligatorios
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || 
            txtUsuario.getText().isEmpty() || txtCorreo.getText().isEmpty() || 
            String.valueOf(txtClave.getPassword()).isEmpty() ||
            String.valueOf(txtConfirmarClave.getPassword()).isEmpty() ||
            getSelectedGender().isEmpty() ||
            cmbYear.getSelectedItem().equals("Año") ||
            cmbMes.getSelectedItem().equals("Mes") ||
            cmdDia.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos obligatorios.");
            return;
        }

        // Validar contraseña
        if (!String.valueOf(txtClave.getPassword()).equals(String.valueOf(txtConfirmarClave.getPassword()))) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

        // Construir fecha de nacimiento
        String fechaNacimiento = String.format("%s/%s/%s", 
                cmdDia.getSelectedItem(),
                cmbMes.getSelectedItem(),
                cmbYear.getSelectedItem());
        try {
        // Crear nuevo objeto Usuario con los datos del formulario
        Usuario nuevoUsuario = new Usuario(
            txtNombre.getText(),
            txtApellido.getText(),
            txtUsuario.getText(),
            txtCorreo.getText(),
            String.valueOf(txtClave.getPassword()),
            getSelectedGender(),
            fechaNacimiento
        );

        // Intentar registrar el usuario en la base de datos
        if (nuevoUsuario.registrar()) {
            JOptionPane.showMessageDialog(this, "¡Cuenta creada exitosamente!");
            this.dispose();
            java.awt.EventQueue.invokeLater(() -> {
                new Login().setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(this, 
                "No se pudo crear la cuenta. El nombre de usuario podría estar en uso.",
                "Error al crear cuenta",
                JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error al crear la cuenta: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        String username = txtUsuario.getText();
        if (UsuariosCreados.isUsernameAvailable(username)) {
            txtVerificado.setText("Disponible");
        } else {
            txtVerificado.setText("No disponible");
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnVerificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JComboBox<String> cmdDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbtFemenino;
    private javax.swing.JRadioButton rbtMasculino;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtConfirmarClave;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtVerificado;
    // End of variables declaration//GEN-END:variables
}
