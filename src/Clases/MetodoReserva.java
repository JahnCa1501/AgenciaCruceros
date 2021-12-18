package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MetodoReserva extends ClaseReserva {

    //Conexion
    private String query = "";
    private Connection con = Conexion.obtenerConexion();

    //Metodos
    public void insertar() {

        query = "Insert into reservas(id_reserva,id_camarote,id_buque,id_viaje,id_cliente,id_empleado"
                + ",id_destino,id_salida,fecha_salida,fecha_regreso)values(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, getIdreserva());
            pst.setInt(2, getIdcamarote());
            pst.setInt(3, getIdbuque());
            pst.setInt(4, getIdviaje());
            pst.setString(5, getIdcliente());
            pst.setString(6, getIdempleado());
            pst.setInt(7, getIddestino());
            pst.setInt(8, getIdsalida());
            pst.setString(9, getFechasalida());
            pst.setString(10, getFecharetorno());
            // pst.setDouble(11, getCostoalojamiento());

            pst.executeQuery();

            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }

    //Polimorfismo
    @Override
    public double CalculoCosto() {
        return getNumeropersonas() * getDuracion() * getPreciocamarote();
    }

    @Override
    public double Subtotal() {
        return CalculoCosto();
    }

    public double ImpuestoSV() {
        return Subtotal() * 0.07;
    }

    public double ImpuestoPortuario() {
        return Subtotal() * 0.05;
    }

    public double Propinas() {
        return Subtotal() * 0.1;
    }

    public double Total() {
        return Subtotal() + Propinas() + ImpuestoPortuario() + ImpuestoSV() - Descuento();
    }

    public double Descuento() {
        if (getEdad() >= 60) {
            return Total() * 0.25;
        } else {
            return 0;
        }
    }

}
