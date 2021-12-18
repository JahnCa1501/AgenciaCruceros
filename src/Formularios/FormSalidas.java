
package Formularios;

import Clases.Conexion;
import Clases.MetodoSalidas;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormSalidas extends javax.swing.JFrame {

   
    public FormSalidas() {
        initComponents();
        getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        CargarTabla();
    }
    
    MetodoSalidas cls = new MetodoSalidas();
    
    private void CargarDatos(){
        cls.setCodigo(Integer.parseInt(TxtCodigo.getText()));
        cls.setSalida(TxtNombre.getText());
    }
    
     private void Limpiar() {
        TxtCodigo.setText("");
        TxtNombre.setText("");
    }

    private void CargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) TableSalidas.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {100, 100, 100, 100};

        for (int i = 0; i < TableSalidas.getColumnCount(); i++) {
            TableSalidas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try {
            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_salida,nombre_salida from salidas");

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

    public void Modificar() {
        try {
            CargarDatos();
            int fila = TableSalidas.getSelectedRow();
            int id = Integer.parseInt(TableSalidas.getValueAt(fila, 0).toString());

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("UPDATE salidas SET nombre_salida=? where id_salida=?");

            pst.setString(1, cls.getSalida());
            pst.setInt(2, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Guardada");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }

    public void Eliminar() {
        try {
            CargarDatos();
            int fila = TableSalidas.getSelectedRow();
            int id = Integer.parseInt(TableSalidas.getValueAt(fila, 0).toString());

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("Delete from salidas where id_salida=?");
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RbNuevo = new javax.swing.JRadioButton();
        RbModificar = new javax.swing.JRadioButton();
        RbEliminar = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSalidas = new javax.swing.JTable();
        TxtCodigo = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        BtnConfirmar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Puertos de Salida");
        setPreferredSize(new java.awt.Dimension(784, 310));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Puertos de Salida");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione la accion a realizar:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Codigo de Salida:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombre de Salida:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Puertos de Salida");

        buttonGroup1.add(RbNuevo);
        RbNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbNuevo.setText("Nuevo Puerto");
        RbNuevo.setContentAreaFilled(false);

        buttonGroup1.add(RbModificar);
        RbModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbModificar.setText("Modificar Puerto");
        RbModificar.setContentAreaFilled(false);

        buttonGroup1.add(RbEliminar);
        RbEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbEliminar.setText("Eliminar Puerto");
        RbEliminar.setContentAreaFilled(false);

        TableSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo de Puerto", "Nombre"
            }
        ));
        TableSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSalidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableSalidas);

        TxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCodigoKeyTyped(evt);
            }
        });

        TxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreKeyTyped(evt);
            }
        });

        BtnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnConfirmar.setText("Confirmar");
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });

        BtnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(RbNuevo)
                .addGap(85, 85, 85)
                .addComponent(RbModificar)
                .addGap(64, 64, 64)
                .addComponent(RbEliminar))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(181, 181, 181))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BtnCancelar)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BtnConfirmar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(299, 299, 299))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(274, 274, 274)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbNuevo)
                    .addComponent(RbModificar)
                    .addComponent(RbEliminar))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnConfirmar)
                            .addComponent(BtnCancelar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        CargarDatos();
        if (RbNuevo.isSelected()){
            cls.insertar();
            Limpiar();
            CargarTabla();
        } else if (RbModificar.isSelected()){
            Modificar();
            Limpiar();
            CargarTabla();
        } else if (RbEliminar.isSelected()){
            Eliminar();
            Limpiar();
            CargarTabla();
        }
    }//GEN-LAST:event_BtnConfirmarActionPerformed

    private void TableSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSalidasMouseClicked
         try {
            int fila = TableSalidas.getSelectedRow();
            int id = Integer.parseInt(TableSalidas.getValueAt(fila, 0).toString());

            PreparedStatement pst;
            ResultSet rs;

            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select nombre_salida from salidas where id_salida=?");

            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                TxtCodigo.setText("" + id);
                TxtNombre.setText(rs.getString("nombre_salida"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_TableSalidasMouseClicked

    private void TxtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodigoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_TxtCodigoKeyTyped

    private void TxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo letras");
        }
    }//GEN-LAST:event_TxtNombreKeyTyped

   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JRadioButton RbEliminar;
    private javax.swing.JRadioButton RbModificar;
    private javax.swing.JRadioButton RbNuevo;
    private javax.swing.JTable TableSalidas;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
