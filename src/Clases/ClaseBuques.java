
package Clases;


public class ClaseBuques {
    
    //Atributos
    private int codigo;
    private String nombre;
    private String tipo;
    private int numcamarotes;
    private int niveles;
    
    //Encapsulamiento
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumcamarotes() {
        return numcamarotes;
    }

    public void setNumcamarotes(int numcamarotes) {
        this.numcamarotes = numcamarotes;
    }

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

}
