package Formularios;

import Clases.Conexion;
import Clases.MetodoUsuarios;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormUsuarios extends javax.swing.JFrame {

    int contador = 0;

    public FormUsuarios() {
        initComponents();
        getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        CargarTabla();

        try {
            Connection con = Conexion.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from empleados");

            while (rs.next()) {
                this.CmbIdentidad.addItem(rs.getString("id_empleado"));
            }
            contador++;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    MetodoUsuarios cls = new MetodoUsuarios();

    private void CargarDatos() {
        cls.setIdentidad(String.valueOf(CmbIdentidad.getSelectedItem()));
        cls.setNombre(TxtNombre.getText());
        cls.setPin(TxtPin.getText());
        cls.setNivel((Integer) SpNivel.getValue());
    }

    private void Limpiar() {
        TxtNombre.setText("");
        TxtPin.setText("");
        CmbIdentidad.setSelectedItem("Seleccione:");
    }

    private void CargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) TableUsuarios.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {100, 100, 100, 100};

        for (int i = 0; i < TableUsuarios.getColumnCount(); i++) {
            TableUsuarios.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try {
            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_empleado,nombre_usuario,pass_usuario,nivel_usuario from usuarios");

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
            int fila = TableUsuarios.getSelectedRow();
            String id = TableUsuarios.getValueAt(fila, 0).toString();

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("UPDATE usuarios SET nombre_usuario=?,pass_usuario=?,nivel_usuario=? where id_empleado=?");

            pst.setString(1, cls.getNombre());
            pst.setString(2, cls.getPin());
            pst.setInt(3, cls.getNivel());
            pst.setString(4, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Guardada");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }

    public void Eliminar() {
        try {
            CargarDatos();
            int fila = TableUsuarios.getSelectedRow();
            String id = TableUsuarios.getValueAt(fila, 0).toString();

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("Delete from usuarios where id_empleado=?");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        RbNuevo = new javax.swing.JRadioButton();
        RbModificar = new javax.swing.JRadioButton();
        RbEliminar = new javax.swing.JRadioButton();
        TxtNombre = new javax.swing.JTextField();
        TxtPin = new javax.swing.JTextField();
        SpNivel = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableUsuarios = new javax.swing.JTable();
        BtnCancelar = new javax.swing.JButton();
        BtnConfirmar = new javax.swing.JButton();
        CmbIdentidad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Usuarios");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione la accion a realizar:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Identidad Empleado:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Clave de usuario:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Usuarios Registrados");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Nombre de Usuario:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nivel de Usuario:");

        buttonGroup1.add(RbNuevo);
        RbNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbNuevo.setText("Nuevo Usuario");
        RbNuevo.setContentAreaFilled(false);

        buttonGroup1.add(RbModificar);
        RbModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbModificar.setText("Modificar Usuario");
        RbModificar.setContentAreaFilled(false);

        buttonGroup1.add(RbEliminar);
        RbEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbEliminar.setText("Eliminar Usuario");
        RbEliminar.setContentAreaFilled(false);

        TxtPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPinActionPerformed(evt);
            }
        });

        SpNivel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 2, 1));

        TableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Identidad", "Usuario", "Pin ", "Nivel"
            }
        ));
        TableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableUsuarios);

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

        CmbIdentidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:" }));
        CmbIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbIdentidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnCancelar)
                        .addComponent(jLabel7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(SpNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnConfirmar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtPin, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(CmbIdentidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RbNuevo)
                                .addGap(62, 62, 62)
                                .addComponent(RbModificar)
                                .addGap(70, 70, 70)
                                .addComponent(RbEliminar)))))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(195, 195, 195))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbNuevo)
                    .addComponent(RbModificar)
                    .addComponent(RbEliminar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CmbIdentidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TxtPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(SpNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCancelar)
                            .addComponent(BtnConfirmar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void CmbIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbIdentidadActionPerformed

    }//GEN-LAST:event_CmbIdentidadActionPerformed

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        CargarDatos();
        if (RbNuevo.isSelected()) {
            if (TxtPin.getText().length() >= 8) {
                cls.insertar();
                Limpiar();
                CargarTabla();
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña debe tener minimo 8 caracteres");
            }
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

    private void TableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUsuariosMouseClicked
        try {
            int fila = TableUsuarios.getSelectedRow();
            String id = TableUsuarios.getValueAt(fila, 0).toString();

            PreparedStatement pst;
            ResultSet rs;

            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select nombre_usuario,pass_usuario,nivel_usuario from usuarios where id_empleado=?");

            pst.setString(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                CmbIdentidad.setSelectedItem(String.valueOf(TableUsuarios.getModel().getValueAt(fila, 0)));
                TxtNombre.setText(rs.getString("nombre_usuario"));
                TxtPin.setText(rs.getString("pass_usuario"));
                SpNivel.setValue(rs.getInt(3));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_TableUsuariosMouseClicked

    private void TxtPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPinActionPerformed

    }//GEN-LAST:event_TxtPinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JComboBox<String> CmbIdentidad;
    private javax.swing.JRadioButton RbEliminar;
    private javax.swing.JRadioButton RbModificar;
    private javax.swing.JRadioButton RbNuevo;
    private javax.swing.JSpinner SpNivel;
    private javax.swing.JTable TableUsuarios;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JTextField TxtPin;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
