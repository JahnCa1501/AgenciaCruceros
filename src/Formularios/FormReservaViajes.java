package Formularios;

import Clases.Conexion;
import Clases.MetodoReserva;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FormReservaViajes extends javax.swing.JFrame {

    public FormReservaViajes() {
        initComponents();
        getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        TxtIdViaje.setVisible(false);

        IdReserva();
        TxtIdEmpleado.setText(clsl.IdEmpleado());
    }

    MetodoReserva cls = new MetodoReserva();
    FormLogin clsl = new FormLogin();

    public void CargarDatos() {
        cls.setIdviaje(Integer.parseInt(TxtIdViaje.getText()));
        cls.setNombresalida(TxtSalida.getText());
        cls.setNombredestino(TxtDestino.getText());
        cls.setFechasalida(TxtFechaSalida.getText());
        cls.setFecharetorno(TxtFechaRetorno.getText());
        cls.setIdempleado(TxtIdEmpleado.getText());
        cls.setIdreserva(Integer.parseInt(LblNumReserva.getText()));
        cls.setNombrebuque(TxtBuque.getText());
        cls.setDuracion(Integer.parseInt(LblDuracion.getText()));
        cls.setCostoalojamiento(cls.CalculoCosto());
        
        
        try {
            PreparedStatement pst;
            ResultSet rs;

            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_buque from buques where nombre_buque=?");

            pst.setString(1, TxtBuque.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                cls.setIdbuque(rs.getInt("id_buque"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

        try {
            PreparedStatement pst;
            ResultSet rs;

            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_salida from salidas where nombre_salida=?");

            pst.setString(1, TxtSalida.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                cls.setIdsalida(rs.getInt("id_salida"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

        try {
            PreparedStatement pst;
            ResultSet rs;

            Connection con = Conexion.obtenerConexion();
            pst = con.prepareStatement("Select id_destino from destinos where nombre_destino=?");

            pst.setString(1, TxtDestino.getText());
            rs = pst.executeQuery();

            while (rs.next()) {
                cls.setIddestino(rs.getInt("id_destino"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

    }

    public int IdReserva() {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion.obtenerConexion();

        try {
            PreparedStatement pst = con.prepareStatement("Select Max(id_reserva) from reservas");
            rs = pst.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1) + 1;
                LblNumReserva.setText("" + id);
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
        return id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblNumReserva = new javax.swing.JLabel();
        TxtSalida = new javax.swing.JTextField();
        TxtDestino = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtBuque = new javax.swing.JTextField();
        BtBuscarViaje = new javax.swing.JButton();
        TxtFechaSalida = new javax.swing.JTextField();
        TxtFechaRetorno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        LblDuracion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Destino = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();
        TxtIdViaje = new javax.swing.JTextField();
        BtnConfirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtIdEmpleado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reserva de viaje");

        LblNumReserva.setText("-------");

        TxtSalida.setEditable(false);

        TxtDestino.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Buque:");

        TxtBuque.setEditable(false);

        BtBuscarViaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtBuscarViaje.setText("Buscar Viajes");
        BtBuscarViaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtBuscarViajeMouseClicked(evt);
            }
        });
        BtBuscarViaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtBuscarViajeActionPerformed(evt);
            }
        });

        TxtFechaSalida.setEditable(false);

        TxtFechaRetorno.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Duracion:");

        LblDuracion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Reservas");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ciudad de Origen:");

        Destino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Destino.setText("Destino: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de salida:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha de retorno:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("No. Reserva:");

        BtnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        TxtIdViaje.setEditable(false);

        BtnConfirmar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnConfirmar.setText("Confirmar Reserva");
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("dias");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Identidad empleado:");

        TxtIdEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(TxtIdViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TxtSalida)
                        .addComponent(TxtBuque)
                        .addComponent(TxtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LblNumReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(Destino, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtFechaRetorno, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(TxtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(TxtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(BtBuscarViaje, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(182, 182, 182))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(BtnCancelar))
                                .addComponent(BtnConfirmar))
                            .addGap(236, 236, 236)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LblDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(80, 80, 80))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(TxtIdViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(LblNumReserva)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Destino)
                        .addComponent(TxtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(TxtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtFechaRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtBuque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LblDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(BtBuscarViaje)
                .addGap(31, 31, 31)
                .addComponent(BtnConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnCancelar)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtBuscarViajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtBuscarViajeMouseClicked

    }//GEN-LAST:event_BtBuscarViajeMouseClicked

    private void BtBuscarViajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtBuscarViajeActionPerformed
        FormTablaViajes form = new FormTablaViajes();
        form.toFront();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtBuscarViajeActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        CargarDatos();

        cls.insertar();

        FormFactura form = new FormFactura();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtBuscarViaje;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JLabel Destino;
    public static javax.swing.JLabel LblDuracion;
    private javax.swing.JLabel LblNumReserva;
    public static javax.swing.JTextField TxtBuque;
    public static javax.swing.JTextField TxtDestino;
    public static javax.swing.JTextField TxtFechaRetorno;
    public static javax.swing.JTextField TxtFechaSalida;
    private javax.swing.JLabel TxtIdEmpleado;
    public static javax.swing.JTextField TxtIdViaje;
    public static javax.swing.JTextField TxtSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
