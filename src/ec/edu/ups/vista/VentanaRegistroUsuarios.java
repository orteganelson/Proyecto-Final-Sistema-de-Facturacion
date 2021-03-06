/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author paul_
 */
public class VentanaRegistroUsuarios extends javax.swing.JInternalFrame {
    private ControladorUsuario controladorUsuario;
    /**
     * Creates new form VentanaRegistroUsuarios
     */
    public VentanaRegistroUsuarios(ControladorUsuario controladorUsuario) {
        initComponents();
        this.controladorUsuario = controladorUsuario;
    }
    public void limpiar() {
        txtApellidoUsuario.setText("");
        txtCedula.setText("");
        txtCorreoUsuario.setText("");
        txtNombreUsuario.setText("");
        txtContraseniaUsuario.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRegistro = new javax.swing.JPanel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblApellidoUsuario = new javax.swing.JLabel();
        lblCorreoUsuario = new javax.swing.JLabel();
        lblContraseniaUsuario = new javax.swing.JLabel();
        lblTituloRegistrarUsuario = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtApellidoUsuario = new javax.swing.JTextField();
        txtCorreoUsuario = new javax.swing.JTextField();
        txtContraseniaUsuario = new javax.swing.JTextField();
        btnGuardarUsuario = new javax.swing.JButton();
        btnCancelarUsuario = new javax.swing.JButton();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();

        setClosable(true);

        lblNombreUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNombreUsuario.setText("NOMBRE:");

        lblApellidoUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblApellidoUsuario.setText("APELLIDO:");

        lblCorreoUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCorreoUsuario.setText("CORREO ELECTRÓNICO:");

        lblContraseniaUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblContraseniaUsuario.setText("CONTRASEÑA:");

        lblTituloRegistrarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTituloRegistrarUsuario.setText("REGISTRO DE USUARIO");

        btnGuardarUsuario.setBackground(new java.awt.Color(204, 255, 255));
        btnGuardarUsuario.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnGuardarUsuario.setForeground(new java.awt.Color(102, 102, 102));
        btnGuardarUsuario.setText("GUARDAR");
        btnGuardarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarUsuarioActionPerformed(evt);
            }
        });

        btnCancelarUsuario.setBackground(new java.awt.Color(204, 255, 255));
        btnCancelarUsuario.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnCancelarUsuario.setForeground(new java.awt.Color(102, 102, 102));
        btnCancelarUsuario.setText("CANCELAR");
        btnCancelarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarUsuarioActionPerformed(evt);
            }
        });

        lblCedula.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCedula.setText("CÉDULA:");

        javax.swing.GroupLayout panelRegistroLayout = new javax.swing.GroupLayout(panelRegistro);
        panelRegistro.setLayout(panelRegistroLayout);
        panelRegistroLayout.setHorizontalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRegistroLayout.createSequentialGroup()
                                .addComponent(lblNombreUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistroLayout.createSequentialGroup()
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellidoUsuario)
                                    .addComponent(lblCorreoUsuario)
                                    .addComponent(lblContraseniaUsuario)
                                    .addGroup(panelRegistroLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btnGuardarUsuario))
                                    .addComponent(lblCedula))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCancelarUsuario)
                                    .addComponent(txtContraseniaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(txtCorreoUsuario)
                                    .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCedula)))))
                    .addGroup(panelRegistroLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(lblTituloRegistrarUsuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRegistroLayout.setVerticalGroup(
            panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloRegistrarUsuario)
                .addGap(34, 34, 34)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreUsuario)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoUsuario)
                    .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCorreoUsuario)
                    .addComponent(txtCorreoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseniaUsuario)
                    .addComponent(txtContraseniaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(panelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarUsuario)
                    .addComponent(btnGuardarUsuario))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarUsuarioActionPerformed
        this.dispose();
        limpiar();
    }//GEN-LAST:event_btnCancelarUsuarioActionPerformed

    private void btnGuardarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarUsuarioActionPerformed
        String nombre = txtNombreUsuario.getText();
        String apellido = txtApellidoUsuario.getText();
        String cedula = txtCedula.getText();
        String correo = txtCorreoUsuario.getText();
        String password = txtContraseniaUsuario.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || correo.isEmpty()
                || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llenar todos los campos");

        } else if (cedula.length() > 10) {
            JOptionPane.showMessageDialog(this, "La cédula no puede contener más de 10 dígitos");
        } else if (password.length() > 8) {
            JOptionPane.showMessageDialog(this, "La contraseña no puede contener más de 8 caracteres");
        } else {
            controladorUsuario.registrarUsuario(nombre, apellido, cedula, correo, password);
            JOptionPane.showMessageDialog(this, "Usuario creado con exito");
            limpiar();
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnGuardarUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarUsuario;
    private javax.swing.JButton btnGuardarUsuario;
    private javax.swing.JLabel lblApellidoUsuario;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContraseniaUsuario;
    private javax.swing.JLabel lblCorreoUsuario;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblTituloRegistrarUsuario;
    private javax.swing.JPanel panelRegistro;
    private javax.swing.JTextField txtApellidoUsuario;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContraseniaUsuario;
    private javax.swing.JTextField txtCorreoUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
