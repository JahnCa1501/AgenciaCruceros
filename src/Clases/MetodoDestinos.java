package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MetodoDestinos extends ClaseDestinos {

    //Conexion
    private String query = "";
    private Connection con = Conexion.obtenerConexion();

    //Metodos
    public void insertar() {
        query = "Insert into destinos(id_destino,nombre_destino)values(?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, getCodigo());
            pst.setString(2, getDestino());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }

}
