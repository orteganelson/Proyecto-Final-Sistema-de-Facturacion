/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

/**
 *
 * @author Anahi
 */
public class VentanaInventarioBodega extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInventarioBodega
     */
    public VentanaInventarioBodega() {
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

        lblStockBodega = new javax.swing.JLabel();
        lblCodigoB = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaStockBodega = new javax.swing.JTable();
        btnConsultar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();

        lblStockBodega.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        lblStockBodega.setText("Stock Bodega");

        lblCodigoB.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblCodigoB.setText("Código de Bodega:");

        tablaStockBodega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Código", "Nombre", "Precio", "Descripcion", "Bodega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaStockBodega);

        btnConsultar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnConsultar.setText("Consultar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStockBodega)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCodigoB)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStockBodega)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoB)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnConsultar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigoB;
    private javax.swing.JLabel lblStockBodega;
    private javax.swing.JTable tablaStockBodega;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
