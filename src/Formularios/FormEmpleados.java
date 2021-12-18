package Formularios;

import Clases.Conexion;
import Clases.MetodoEmpleados;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormEmpleados extends javax.swing.JFrame {

    public FormEmpleados() {
        initComponents();
        getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        CargarTabla();
    }

    MetodoEmpleados cls = new MetodoEmpleados();

    //Collects Data
    private void CargarDatos() {
        cls.setIdentidad(TxtIdentidad.getText());
        cls.setNombre(TxtNombre.getText());
        cls.setDireccion(TxtDireccion.getText());

        if (CmbCargo.getSelectedItem() == "Administrador") {
            cls.setCargo("Administrador");
        } else if (CmbCargo.getSelectedItem() == "Agente de venta") {
            cls.setCargo("Agente de venta");
        }

        if (CmbSexo.getSelectedItem() == "Masculino") {
            cls.setSexo("Masculino");
        } else if (CmbSexo.getSelectedItem() == "Femenino") {
            cls.setSexo("Femenino");
        }
    }

    //Cleans TextFields
    private void Limpiar() {
        TxtIdentidad.setText("");
        TxtNombre.setText("");
        TxtDireccion.setText("");
        CmbCargo.setSelectedItem("Seleccione:");
        CmbSexo.setSelectedItem("Seleccione:");
    }

    //Selects data from database and shows it on Table
    private void CargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) TableEmpleados.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {100, 150, 100, 100, 100};

        for (int i = 0; i < TableEmpleados.getColumnCount(); i++) {
            TableEmpleados.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try {
            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_empleado,nombre_empleado,cargo_empleado,direccion_empleado,sexo_empleado from empleados");

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

    //Update
    public void Modificar() {
        try {
            CargarDatos();
            int fila = TableEmpleados.getSelectedRow();
            String id = TableEmpleados.getValueAt(fila, 0).toString();

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("UPDATE empleados SET nombre_empleado=?,cargo_empleado=?,"
                    + "direccion_empleado=?,sexo_empleado=? where id_empleado=?");

            pst.setString(1, cls.getNombre());
            pst.setString(2, cls.getCargo());
            pst.setString(3, cls.getDireccion());
            pst.setString(4, cls.getSexo());
            pst.setString(5, id);

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
            int fila = TableEmpleados.getSelectedRow();
            String id = TableEmpleados.getValueAt(fila, 0).toString();

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("Delete from empleados where id_empleado=?");
            pst.setString(1, id);
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
        RbEliminar = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RbNuevo = new javax.swing.JRadioButton();
        RbModificar = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableEmpleados = new javax.swing.JTable();
        TxtIdentidad = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        TxtDireccion = new javax.swing.JTextField();
        CmbCargo = new javax.swing.JComboBox<>();
        CmbSexo = new javax.swing.JComboBox<>();
        BtnCancelar = new javax.swing.JButton();
        BtnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empleados");
        setResizable(false);

        buttonGroup1.add(RbEliminar);
        RbEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbEliminar.setText("Eliminar Usuario");
        RbEliminar.setContentAreaFilled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Empleados:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione la accion a realizar:");

        buttonGroup1.add(RbNuevo);
        RbNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbNuevo.setText("Nuevo Usuario");
        RbNuevo.setContentAreaFilled(false);

        buttonGroup1.add(RbModificar);
        RbModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbModificar.setText("Modificar Usuario");
        RbModificar.setContentAreaFilled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Identidad Empleado:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombre del Empleado:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cargo del Empleado:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Sexo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Registros de Empleados:");

        TableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Identidad", "Nombre", "Cargo", "Direccion", "Sexo"
            }
        ));
        TableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableEmpleados);

        TxtIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtIdentidadKeyTyped(evt);
            }
        });

        TxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreKeyTyped(evt);
            }
        });

        CmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "Administrador", "Agente de venta" }));
        CmbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbCargoActionPerformed(evt);
            }
        });

        CmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "Masculino", "Femenino" }));
        CmbSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbSexoActionPerformed(evt);
            }
        });

        BtnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnConfirmar.setText("Confirmar");
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(BtnCancelar)
                        .addGap(68, 68, 68)
                        .addComponent(BtnConfirmar)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(22, 22, 22))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CmbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtIdentidad)
                                .addComponent(TxtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TxtDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(198, 198, 198))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(235, 235, 235)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(RbNuevo)
                                    .addGap(110, 110, 110)
                                    .addComponent(RbModificar)
                                    .addGap(113, 113, 113)
                                    .addComponent(RbEliminar))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(198, 198, 198))))
                        .addGap(150, 150, 150))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbNuevo)
                    .addComponent(RbModificar)
                    .addComponent(RbEliminar))
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(CmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCancelar)
                            .addComponent(BtnConfirmar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(28, 28, 28))
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
    private void TableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableEmpleadosMouseClicked
        try {
            int fila = TableEmpleados.getSelectedRow();
            String id = TableEmpleados.getValueAt(fila, 0).toString();

            PreparedStatement pst;
            ResultSet rs;

            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select nombre_empleado,direccion_empleado,cargo_empleado,sexo_empleado from empleados where id_empleado=?");

            pst.setString(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                TxtIdentidad.setText(id);
                TxtNombre.setText(rs.getString("nombre_empleado"));
                TxtDireccion.setText(rs.getString("direccion_empleado"));
                CmbCargo.setSelectedItem(String.valueOf(TableEmpleados.getModel().getValueAt(fila, 2)));
                CmbSexo.setSelectedItem(String.valueOf(TableEmpleados.getModel().getValueAt(fila, 4)));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_TableEmpleadosMouseClicked

    private void CmbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbCargoActionPerformed
        if (CmbCargo.getSelectedItem() == "Administrador") {

        }
    }//GEN-LAST:event_CmbCargoActionPerformed

    private void CmbSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbSexoActionPerformed

    }//GEN-LAST:event_CmbSexoActionPerformed

    //Validations on TextFields
    private void TxtIdentidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdentidadKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_TxtIdentidadKeyTyped

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
    private javax.swing.JComboBox<String> CmbCargo;
    private javax.swing.JComboBox<String> CmbSexo;
    private javax.swing.JRadioButton RbEliminar;
    private javax.swing.JRadioButton RbModificar;
    private javax.swing.JRadioButton RbNuevo;
    private javax.swing.JTable TableEmpleados;
    private javax.swing.JTextField TxtDireccion;
    private javax.swing.JTextField TxtIdentidad;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
