package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MetodoClientes extends ClaseClientes {

    //Conexion
    private String query = "";
    private Connection con = Conexion.obtenerConexion();

    //Metodos
    public void insertar() {
        query = "Insert into clientes(id_cliente,nombre_cliente,edad_cliente,pais_cliente,direccion_cliente,telefono_cliente,email_cliente)"
                + "values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, getNumero_identidad());
            pst.setString(2, getNombre());
            pst.setInt(3, getEdad());
            pst.setString(4, getPais());
            pst.setString(5, getDireccion());
            pst.setInt(6, getTelefono());
            pst.setString(7, getCorreo());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }

}
