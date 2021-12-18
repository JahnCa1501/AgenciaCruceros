
package Clases;


public class ClaseEmpleados {
    
    //Atributos
    private String identidad;
    private String nombre;
    private String direccion;
    private String cargo;
    private String sexo;
    private static int nivel;
    
    //Encapsulamiento
    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public static int getNivel() {
        return nivel;
    }

    public static void setNivel(int nivel) {
        ClaseEmpleados.nivel = nivel;
    }
    
 
}
