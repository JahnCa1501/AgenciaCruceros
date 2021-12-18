
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MetodoBuques extends ClaseBuques{
    
    //Conexion
    private String query = "";
    private Connection con = Conexion.obtenerConexion();

    //Metodos
    public void insertar() {
        query = "Insert into buques(id_buque,nombre_buque,tipo_buque,numero_camarotes,numero_niveles)values(?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, getCodigo());
            pst.setString(2, getNombre());
            pst.setString(3, getTipo());
            pst.setInt(4, getNumcamarotes());
            pst.setInt(5, getNiveles());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }
    
}
