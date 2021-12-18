package Formularios;

import Clases.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class FormTablaCamarotes extends javax.swing.JFrame {

    public FormTablaCamarotes() {
        initComponents();
        getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        CargarTabla();
    }

    FormReservaCamarotes form = new FormReservaCamarotes();

    private void CargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) TableCamarotes.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {100, 100, 100};

        for (int i = 0; i < TableCamarotes.getColumnCount(); i++) {
            TableCamarotes.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try {
            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_camarote,tipo_camarote,precio_camarote from camarotes");

            rs = pst.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCamarotes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Camarotes");

        TableCamarotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo Camarote", "Tipo de Camarote", "Precio de Camarote"
            }
        ));
        TableCamarotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCamarotesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableCamarotesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableCamarotes);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione uno haciendo doble clic sobre el");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(240, 240, 240))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableCamarotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCamarotesMouseClicked

        int fila = TableCamarotes.getSelectedRow();
        TableModel model = TableCamarotes.getModel();
        String idcamarote;
        String tipocamarote;
        String preciocamarote;

        idcamarote = model.getValueAt(fila, 0).toString();
        tipocamarote = model.getValueAt(fila, 1).toString();
        preciocamarote = model.getValueAt(fila, 2).toString();
        this.dispose();

        form.TxtIdCamarote.setText(idcamarote);
        form.TxtTipoCamarote.setText(tipocamarote);
        form.TxtPrecioCamarote.setText(preciocamarote);
        form.setVisible(true);
    }//GEN-LAST:event_TableCamarotesMouseClicked

    private void TableCamarotesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCamarotesMousePressed

    }//GEN-LAST:event_TableCamarotesMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCamarotes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
