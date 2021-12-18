package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MetodoViajes extends ClaseViajes {

    //Conexion
    private String query = "";
    private Connection con = Conexion.obtenerConexion();

    //Metodos
    public void insertar() {
        query = "Insert into viajes(id_viaje,nombre_buque,puerto_salida,puerto_destino,fecha_partida,fecha_retorno,duracion_viaje)"
                + "values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, getId());
            pst.setString(2, getBuque());
            pst.setString(3, getPuertosalida());
            pst.setString(4, getPuertodestino());
            pst.setString(5, getFechasalida());
            pst.setString(6, getFecharetorno());
            pst.setString(7, getDuracion());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }

}
