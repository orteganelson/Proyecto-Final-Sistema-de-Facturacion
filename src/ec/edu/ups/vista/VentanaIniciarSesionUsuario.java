/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

/**
 *
 * @author paul_
 */
public class VentanaIniciarSesionUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaIniciarSesionUsuario
     */
    public VentanaIniciarSesionUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIniciarSesion = new javax.swing.JLabel();
        lblCorreoU = new javax.swing.JLabel();
        lblContraseniaIniciar = new javax.swing.JLabel();
        btnINICIARSESION = new javax.swing.JButton();
        txtCorreoU = new javax.swing.JTextField();
        txtContraseniaInicia = new javax.swing.JPasswordField();

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblIniciarSesion.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblIniciarSesion.setText("INICIO DE SESION DEL USUARIO");

        lblCorreoU.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCorreoU.setText("CORREO ELECTRÓNICO:");

        lblContraseniaIniciar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblContraseniaIniciar.setText("CONTRASEÑA:");

        btnINICIARSESION.setBackground(new java.awt.Color(204, 255, 255));
        btnINICIARSESION.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        btnINICIARSESION.setForeground(new java.awt.Color(102, 102, 102));
        btnINICIARSESION.setText("INICIAR SESION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lblIniciarSesion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnINICIARSESION))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCorreoU)
                            .addComponent(lblContraseniaIniciar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreoU, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtContraseniaInicia))))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIniciarSesion)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCorreoU)
                    .addComponent(txtCorreoU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseniaIniciar)
                    .addComponent(txtContraseniaInicia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnINICIARSESION)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnINICIARSESION;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContraseniaIniciar;
    private javax.swing.JLabel lblCorreoU;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JPasswordField txtContraseniaInicia;
    private javax.swing.JTextField txtCorreoU;
    // End of variables declaration//GEN-END:variables
}
