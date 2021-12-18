
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MetodoCamarotes extends ClaseCamarotes {
    
     //Conexion
    private String query = "";
    private Connection con = Conexion.obtenerConexion();

    //Metodos
    public void insertar() {
        query = "Insert into camarotes(id_camarote,tipo_camarote,precio_camarote)values (?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, getIdcamarote());
            pst.setString(2, getTipo());
            pst.setInt(3, getPrecio());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }
    
}
