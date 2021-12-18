
package Clases;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    static Connection conn;
    
    //Metodos
    public static Connection obtenerConexion(){
     
        String url = "jdbc:sqlserver://localhost:1433;databaseName=AgenciaCruceros";
        
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        } catch(Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Error de conexion");
            
        }
        
        try { 
            //User to connect to mysql database
            conn = DriverManager.getConnection(url, "sa", "Administrador");
           // JOptionPane.showMessageDialog(null, "Conexion con exito");
                    
        } catch (Exception ex) {
            
           // JOptionPane.showMessageDialog(null, "Error de conexion");
            
        }
        
        return conn;
        
    }


    
}
