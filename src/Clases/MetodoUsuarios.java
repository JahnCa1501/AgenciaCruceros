
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MetodoUsuarios extends ClaseUsuarios {
    
    //Conexion
    private String query = "";
    private Connection con = Conexion.obtenerConexion();

    //Metodos
    public void insertar() {
        query = "Insert into usuarios(id_empleado,nombre_usuario,pass_usuario,nivel_usuario)values(?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, getIdentidad());
            pst.setString(2, getNombre());
            pst.setString(3, getPin());
            pst.setInt(4, getNivel());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }
    
}
