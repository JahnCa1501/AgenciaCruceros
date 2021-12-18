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

public class FormTablaViajes extends javax.swing.JFrame {

    public FormTablaViajes() {
        initComponents();
        getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        CargarTabla();
    }

    private void CargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) TableViajes.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {50, 100, 80, 80, 100, 90, 70};

        for (int i = 0; i < TableViajes.getColumnCount(); i++) {
            TableViajes.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try {
            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_viaje,nombre_buque,puerto_salida,puerto_destino,fecha_partida,fecha_retorno,duracion_viaje"
                    + " from viajes");

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

        jScrollPane1 = new javax.swing.JScrollPane();
        TableViajes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TableViajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Buque", "Salida", "Destino", "Fecha Salida", "Fecha Retorno", "Duracion"
            }
        ));
        TableViajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableViajesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableViajesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableViajes);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Viajes Disponibles");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione uno haciendo doble clic sobre el");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(254, 254, 254))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableViajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableViajesMouseClicked

        //Lleva datos de la tabla viajes al FormReserva
        FormReservaViajes form = new FormReservaViajes();
        
        
       
        int fila = TableViajes.getSelectedRow();
        TableModel model = TableViajes.getModel();
        String idviaje;
        String buque;
        String puertosalida;
        String puertodestino;
        String fechasalida;
        String fecharetorno;
        String duracion;


        idviaje = model.getValueAt(fila, 0).toString();
        buque = model.getValueAt(fila, 1).toString();
        puertosalida = model.getValueAt(fila, 2).toString();
        puertodestino = model.getValueAt(fila, 3).toString();
        fechasalida = model.getValueAt(fila, 4).toString();
        fecharetorno = model.getValueAt(fila, 5).toString();
        duracion = model.getValueAt(fila, 6).toString();
        this.dispose();
        
        form.TxtIdViaje.setText(idviaje);
        form.TxtBuque.setText(buque);
        form.TxtSalida.setText(puertosalida);
        form.TxtDestino.setText(puertodestino);
        form.TxtFechaSalida.setText(fechasalida);
        form.TxtFechaRetorno.setText(fecharetorno);
        form.LblDuracion.setText(duracion);
        form.setVisible(true);
  
    }//GEN-LAST:event_TableViajesMouseClicked

    private void TableViajesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableViajesMousePressed

    }//GEN-LAST:event_TableViajesMousePressed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TableViajes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
