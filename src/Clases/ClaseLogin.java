package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ClaseLogin {

    public int Login(String user, String pass) {

        int resultado = 0;

        try {
            Connection con = Conexion.obtenerConexion();
            Statement ejecutor = con.createStatement();
            
            //SQL query 
            ResultSet rs = ejecutor.executeQuery("Select * from usuarios where nombre_usuario = '" + user + "' and pass_usuario = '" + pass + "'");

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bienvenido");
                resultado = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
                resultado = 0;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.toString());
        }

        return resultado;

    }

}
