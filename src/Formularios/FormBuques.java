package Formularios;

import Clases.Conexion;
import Clases.MetodoBuques;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormBuques extends javax.swing.JFrame {

    public FormBuques() {
        initComponents();
        getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        CargarTabla();
    }

    MetodoBuques cls = new MetodoBuques();
    

    //Number Validation
    public static boolean ValidarNumeros(String datos) {
        return datos.matches("[0-9]*");
    }
    

    //Letters validation
    public static boolean ValidarLetras(String datos) {
        return datos.matches("[a-zA-Z]*");
    }

    //Collects data
    private void CargarDatos() {
        cls.setCodigo(Integer.parseInt(TxtCodigo.getText()));
        cls.setNombre(TxtNombre.getText());

        if (CmbTipo.getSelectedItem() == "Familiar") {
            cls.setTipo("Familiar");
        } else if (CmbTipo.getSelectedItem() == "Parejas") {
            cls.setTipo("Parejas");
        }

        cls.setNumcamarotes(Integer.parseInt(TxtCamarotes.getText()));
        cls.setNiveles(Integer.parseInt(TxtNiveles.getText()));
    }

    //Clean Form
    private void Limpiar() {
        TxtCodigo.setText("");
        TxtNombre.setText("");
        TxtNiveles.setText("");
        TxtCamarotes.setText("");
        CmbTipo.setSelectedItem("Seleccione:");
    }

    //Shows data on JTable
    private void CargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) TableBuques.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {100, 100, 100, 100, 100};

        for (int i = 0; i < TableBuques.getColumnCount(); i++) {
            TableBuques.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        try {
            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_buque,nombre_buque,tipo_buque,numero_camarotes,numero_niveles from buques");

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

    //Edits data
    public void Modificar() {
        try {
            CargarDatos();
            int fila = TableBuques.getSelectedRow();
            int id = Integer.parseInt(TableBuques.getValueAt(fila, 0).toString());

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("UPDATE buques SET nombre_buque=?,tipo_buque=?,numero_camarotes=?,numero_niveles=? where id_buque=?");

            pst.setString(1, cls.getNombre());
            pst.setString(2, cls.getTipo());
            pst.setInt(3, cls.getNumcamarotes());
            pst.setInt(4, cls.getNiveles());
            pst.setInt(5, id);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Guardada");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }
    
    //Delete data
    public void Eliminar() {
        try {
            CargarDatos();
            int fila = TableBuques.getSelectedRow();
            int id = Integer.parseInt(TableBuques.getValueAt(fila, 0).toString());

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("Delete from buques where id_buque=?");
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
        jLabel6 = new javax.swing.JLabel();
        RbNuevo = new javax.swing.JRadioButton();
        RbModificar = new javax.swing.JRadioButton();
        RbEliminar = new javax.swing.JRadioButton();
        TxtCodigo = new javax.swing.JTextField();
        CmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableBuques = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        BtnConfirmar = new javax.swing.JButton();
        BtnCancelar = new javax.swing.JButton();
        TxtCamarotes = new javax.swing.JTextField();
        TxtNiveles = new javax.swing.JTextField();
        TxtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buques");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Buques");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione la accion a realizar:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Codigo de Buque:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tipo de Buque:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Numero de Camarotes:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Niveles del Buque:");

        buttonGroup1.add(RbNuevo);
        RbNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbNuevo.setText("Nuevo Buque");
        RbNuevo.setContentAreaFilled(false);

        buttonGroup1.add(RbModificar);
        RbModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbModificar.setText("Modificar Buque");
        RbModificar.setContentAreaFilled(false);

        buttonGroup1.add(RbEliminar);
        RbEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbEliminar.setText("Eliminar Buque");
        RbEliminar.setContentAreaFilled(false);

        TxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCodigoKeyTyped(evt);
            }
        });

        CmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "Familiar", "Parejas" }));

        TableBuques.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo de Buque", "Nombre", "Tipo de Buque", "Numero de Camarotes", "Niveles de Buque"
            }
        ));
        TableBuques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableBuquesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableBuques);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Buques Registrados");

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

        TxtCamarotes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCamarotesKeyTyped(evt);
            }
        });

        TxtNiveles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNivelesKeyTyped(evt);
            }
        });

        TxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtNombreKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nombre de Buque:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(RbNuevo)
                                .addGap(96, 96, 96)
                                .addComponent(RbModificar)
                                .addGap(77, 77, 77)
                                .addComponent(RbEliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(290, 290, 290)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel2))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtCamarotes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtNiveles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BtnCancelar)
                                .addGap(18, 18, 18)
                                .addComponent(BtnConfirmar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel8))
                                    .addGap(45, 45, 45)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TxtNombre)
                                        .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(185, 185, 185))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbNuevo)
                    .addComponent(RbModificar)
                    .addComponent(RbEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(CmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(TxtCamarotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtNiveles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnConfirmar)
                            .addComponent(BtnCancelar))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    //Sends request based on RadioButton selected(Delete, Edit or Insert)
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

    //Gets Data from JTable to the JTextField
    private void TableBuquesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableBuquesMouseClicked
        try {
            int fila = TableBuques.getSelectedRow();
            int id = Integer.parseInt(TableBuques.getValueAt(fila, 0).toString());
            int columna = 0;

            PreparedStatement pst;
            ResultSet rs;

            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select nombre_buque,tipo_buque,numero_camarotes,numero_niveles from buques where id_buque=?");

            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                TxtCodigo.setText("" + id);
                TxtNombre.setText(rs.getString("nombre_buque"));
                CmbTipo.setSelectedItem(String.valueOf(TableBuques.getModel().getValueAt(fila, 2)));
                TxtCamarotes.setText(rs.getString("numero_camarotes"));
                TxtNiveles.setText(rs.getString("numero_niveles"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_TableBuquesMouseClicked
 
    //Validations on JTextField
    private void TxtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodigoKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isLetter(validar)){
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

    private void TxtCamarotesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCamarotesKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_TxtCamarotesKeyTyped

    private void TxtNivelesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNivelesKeyTyped
        char validar = evt.getKeyChar();
        
        if(Character.isLetter(validar)){
            evt.consume();
            
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_TxtNivelesKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JComboBox<String> CmbTipo;
    private javax.swing.JRadioButton RbEliminar;
    private javax.swing.JRadioButton RbModificar;
    private javax.swing.JRadioButton RbNuevo;
    private javax.swing.JTable TableBuques;
    private javax.swing.JTextField TxtCamarotes;
    private javax.swing.JTextField TxtCodigo;
    private javax.swing.JTextField TxtNiveles;
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
