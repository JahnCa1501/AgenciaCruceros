
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class MetodoEmpleados extends ClaseEmpleados {
    
     //Conexion
    private String query = "";
    private Connection con = Conexion.obtenerConexion();

    //Metodos
    public void insertar() {
        query = "Insert into empleados(id_empleado,nombre_empleado,cargo_empleado,direccion_empleado,sexo_empleado)values(?,?,?,?,?)";

        try {
            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, getIdentidad());
            pst.setString(2, getNombre());
            pst.setString(3, getCargo());
            pst.setString(4, getDireccion());
            pst.setString(5, getSexo());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }
    
    
}
