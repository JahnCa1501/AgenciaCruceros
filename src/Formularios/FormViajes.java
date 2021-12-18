package Formularios;

import Clases.Conexion;
import Clases.MetodoViajes;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormViajes extends javax.swing.JFrame {

    int contador = 0;

    public FormViajes() {
        initComponents();
        getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        CargarTabla();

        try {
            Connection con = Conexion.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from buques");

            while (rs.next()) {
                this.CmbBuque.addItem(rs.getString("nombre_buque"));
            }
            contador++;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            Connection con = Conexion.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from salidas");

            while (rs.next()) {
                this.CmbSalida.addItem(rs.getString("nombre_salida"));
            }
            contador++;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {
            Connection con = Conexion.obtenerConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from destinos");

            while (rs.next()) {
                this.CmbDestino.addItem(rs.getString("nombre_destino"));
            }
            contador++;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    MetodoViajes cls = new MetodoViajes();

    private void CargarDatos() {
        cls.setId(Integer.parseInt(TxtId.getText()));
        cls.setBuque(String.valueOf(CmbBuque.getSelectedItem()));
        cls.setPuertosalida(String.valueOf(CmbSalida.getSelectedItem()));
        cls.setPuertodestino(String.valueOf(CmbDestino.getSelectedItem()));
        cls.setDuracion(TxtDuracion.getText());

    }

    private void CalcularDias(JDateChooser DatePartida, JDateChooser DateRetorno) {

        if (DatePartida.getDate() != null && DateRetorno.getDate() != null) {
            Calendar inicio = DatePartida.getCalendar();
            Calendar retorno = DateRetorno.getCalendar();

            int dias = -1;

            while (inicio.before(retorno) || inicio.equals(retorno)) {
                dias++;
                inicio.add(Calendar.DATE, 1);
            }
            TxtDuracion.setText(dias + "");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione las fechas", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Limpiar() {
        TxtId.setText("");
        CmbBuque.setSelectedItem("Seleccione una opcion");
        CmbSalida.setSelectedItem("Seleccione una opcion");
        CmbDestino.setSelectedItem("Seleccione una opcion");
        DatePartida.setCalendar(null);
        DateRetorno.setCalendar(null);
        TxtDuracion.setText("");
    }

    private void CargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) TableViajes.getModel();
        modeloTabla.setRowCount(0);

        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;

        int[] anchos = {50, 100, 80, 80, 100, 100, 50};

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

    public void Modificar() {
        try {
            CargarDatos();
            int fila = TableViajes.getSelectedRow();
            int id = Integer.parseInt(TableViajes.getValueAt(fila, 0).toString());

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("UPDATE viajes SET nombre_buque=?,puerto_salida=?,puerto_destino=?,fecha_partida=?,"
                    + "fecha_retorno=?,duracion_viaje=? where id_viaje=?");

            pst.setString(1, cls.getBuque());
            pst.setString(2, cls.getPuertosalida());
            pst.setString(3, cls.getPuertodestino());
            pst.setString(4, cls.getFechasalida());
            pst.setString(5, cls.getFecharetorno());
            pst.setString(6, cls.getDuracion());
            pst.setInt(7, cls.getId());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modificacion Guardada");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }

    public void Eliminar() {
        try {
            CargarDatos();
            int fila = TableViajes.getSelectedRow();
            int id = Integer.parseInt(TableViajes.getValueAt(fila, 0).toString());

            Connection con = Conexion.obtenerConexion();
            PreparedStatement pst = con.prepareStatement("Delete from viajes where id_viaje=?");
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
        jLabel7 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        BtnConfirmar = new javax.swing.JButton();
        RbNuevo = new javax.swing.JRadioButton();
        RbModificar = new javax.swing.JRadioButton();
        RbEliminar = new javax.swing.JRadioButton();
        CmbBuque = new javax.swing.JComboBox<>();
        CmbSalida = new javax.swing.JComboBox<>();
        CmbDestino = new javax.swing.JComboBox<>();
        DatePartida = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableViajes = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        DateRetorno = new com.toedter.calendar.JDateChooser();
        TxtDuracion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Viajes Disponibles");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Viajes Disponibles");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Seleccione la accion a realizar:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Buque:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Puerto de Salida:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Puerto de Destino:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Duracion del viaje:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de partida:");

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

        buttonGroup1.add(RbNuevo);
        RbNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbNuevo.setText("Nuevo Viaje");
        RbNuevo.setContentAreaFilled(false);

        buttonGroup1.add(RbModificar);
        RbModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbModificar.setText("Modificar Viaje");
        RbModificar.setContentAreaFilled(false);

        buttonGroup1.add(RbEliminar);
        RbEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RbEliminar.setText("Eliminar Viaje");
        RbEliminar.setContentAreaFilled(false);

        CmbBuque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        CmbSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        CmbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion" }));

        DatePartida.setDateFormatString("yyy M d");
        DatePartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatePartidaMouseClicked(evt);
            }
        });

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
                {null, null, null, null, null, null, null},
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
                "ID", "Buque", "Salida", "Destino", "Fecha de Partida", "Fecha Retorno", "Duracion"
            }
        ));
        TableViajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableViajesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TableViajesMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableViajesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableViajes);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Viajes Disponibles");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("ID Viaje:");

        TxtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtIdKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Fecha de retorno:");

        DateRetorno.setDateFormatString("yyy M d");

        TxtDuracion.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CmbDestino, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DatePartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CmbBuque, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CmbSalida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtId)
                                .addComponent(DateRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TxtDuracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(BtnCancelar)
                        .addGap(32, 32, 32)
                        .addComponent(BtnConfirmar)))
                .addGap(29, 29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(205, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(268, 268, 268))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RbNuevo)
                                .addGap(128, 128, 128)
                                .addComponent(RbModificar)
                                .addGap(128, 128, 128)
                                .addComponent(RbEliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel2))
                                .addGap(181, 181, 181)))
                        .addGap(182, 182, 182))))
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
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CmbBuque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CmbSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(CmbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(DatePartida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateRetorno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TxtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCancelar)
                            .addComponent(BtnConfirmar))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        CalcularDias(DatePartida, DateRetorno);
        CargarDatos();

        Calendar cal;
        int d, m, a, de, ds;

        cal = DatePartida.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        de = d;
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        cls.setFechasalida(String.valueOf(new Date(a, m, d)));

        cal = DateRetorno.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        ds = d;
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        cls.setFecharetorno(String.valueOf(new Date(a, m, d)));

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

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void TableViajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableViajesMouseClicked
        try {
            int fila = TableViajes.getSelectedRow();
            int id = Integer.parseInt(TableViajes.getValueAt(fila, 0).toString());
            int columna = 0;

            PreparedStatement pst;
            ResultSet rs;

            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select nombre_buque,puerto_salida,puerto_destino,fecha_partida,fecha_retorno,duracion_viaje"
                    + " from viajes where id_viaje=?");

            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                TxtId.setText("" + id);
                CmbBuque.setSelectedItem(String.valueOf(TableViajes.getModel().getValueAt(fila, 1)));
                CmbSalida.setSelectedItem(String.valueOf(TableViajes.getModel().getValueAt(fila, 2)));
                CmbDestino.setSelectedItem(String.valueOf(TableViajes.getModel().getValueAt(fila, 3)));
                TxtDuracion.setText(rs.getString("duracion_viaje"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_TableViajesMouseClicked

    private void TableViajesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableViajesMousePressed

    }//GEN-LAST:event_TableViajesMousePressed

    private void TableViajesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableViajesMouseEntered

    }//GEN-LAST:event_TableViajesMouseEntered

    private void TxtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIdKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
        }
    }//GEN-LAST:event_TxtIdKeyTyped

    private void DatePartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatePartidaMouseClicked

    }//GEN-LAST:event_DatePartidaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JComboBox<String> CmbBuque;
    private javax.swing.JComboBox<String> CmbDestino;
    private javax.swing.JComboBox<String> CmbSalida;
    private com.toedter.calendar.JDateChooser DatePartida;
    private com.toedter.calendar.JDateChooser DateRetorno;
    private javax.swing.JRadioButton RbEliminar;
    private javax.swing.JRadioButton RbModificar;
    private javax.swing.JRadioButton RbNuevo;
    private javax.swing.JTable TableViajes;
    private javax.swing.JTextField TxtDuracion;
    private javax.swing.JTextField TxtId;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
