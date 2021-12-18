package Formularios;

import Clases.Conexion;
import Clases.MetodoDestinos;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormDestinos extends javax.swing.JFrame {

    public FormDestinos() {
        initComponents();
        getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        CargarTabla();
    }

    MetodoDestinos cls = new MetodoDestinos();

    //Collects Data
    private void CargarDatos() {
        cls.setCodigo(Integer.parseInt(TxtCodigo.getText()));
        cls.setDestino(TxtNombre.getText());
    }

    //Cleans TextFields
    private void Limpiar() {
        TxtCodigo.setText("");
        TxtNombre.setText("");
    }

    //Selects data from database and shows it on Table
    private void CargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) TableDestinos.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {100, 100, 100, 100};

        for (int i = 0; i < TableDestinos.getColumnCount(); i++) {
            TableDestinos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try {
            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_destino,nombre_destino from destinos");

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
            int fila = TableDestinos.getSelectedRow();
            int id = Integer.parseInt(TableDestinos.getValueAt(fila, 0).toString());

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("UPDATE destinos SET nombre_destino=? where id_destino=?");

            pst.setString(1, cls.getDestino());
            pst.setInt(2, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Guardada");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }

    //Delete
    public void Eliminar() {
        try {
            CargarDatos();
            int fila = TableDestinos.getSelectedRow();
            int id = Integer.parseInt(TableDestinos.getValueAt(fila, 0).toString());

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("Delete from destinos where id_destino=?");
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        RbNuevo = new javax.swing.JRadioButton();
        RbModificar = new javax.swing.JRadioButton();
        RbEliminar = new javax.swing.JRadioButton();
        TxtCodigo = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDestinos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BtnConfirmar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Puertos de Destino");
        setPreferredSize(new java.awt.Dimension(784, 310));
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Puertos de Destino");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Seleccione la accion a realizar:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Codigo de Destino:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Nombre de Destino:");

        buttonGroup1.add(RbNuevo);
        RbNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbNuevo.setText("Nuevo Destino");
        RbNuevo.setContentAreaFilled(false);

        buttonGroup1.add(RbModificar);
        RbModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbModificar.setText("Modificar Destino");
        RbModificar.setContentAreaFilled(false);

        buttonGroup1.add(RbEliminar);
        RbEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbEliminar.setText("Eliminar Destino");
        RbEliminar.setContentAreaFilled(false);

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

        TableDestinos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo de Destino", "Nombre de Destino"
            }
        ));
        TableDestinos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDestinosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDestinos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Destinos");

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
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(RbNuevo)
                        .addGap(80, 80, 80)
                        .addComponent(RbModificar)
                        .addGap(76, 76, 76)
                        .addComponent(RbEliminar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(155, 155, 155)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(BtnConfirmar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtCodigo)
                                    .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(305, 305, 305))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(247, 247, 247))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbNuevo)
                    .addComponent(RbModificar)
                    .addComponent(RbEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnConfirmar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    //Sends request based on Action selected in RadioButton(Insert, Delete or Update)
    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        CargarDatos();
        if (RbNuevo.isSelected()) {
            cls.insertar();
            Limpiar();
            CargarTabla();
        } else if (RbModificar.isSelected()) {
            Modificar();
            Limpiar();
            CargarTabla();
        } else if (RbEliminar.isSelected()) {
            Eliminar();
            Limpiar();
            CargarTabla();
        }
    }//GEN-LAST:event_BtnConfirmarActionPerformed

    //Sends data from Table to TextField
    private void TableDestinosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDestinosMouseClicked
        try {
            int fila = TableDestinos.getSelectedRow();
            int id = Integer.parseInt(TableDestinos.getValueAt(fila, 0).toString());

            PreparedStatement pst;
            ResultSet rs;

            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select nombre_destino from destinos where id_destino=?");

            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                TxtCodigo.setText("" + id);
                TxtNombre.setText(rs.getString("nombre_destino"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_TableDestinosMouseClicked

    //Validations on TextFields
    private void TxtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodigoKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_TxtCodigoKeyTyped

    private void TxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreKeyTyped
         char validar = evt.getKeyChar();
        
        if(Character.isDigit(validar)){
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
    private javax.swing.JTable TableDestinos;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
