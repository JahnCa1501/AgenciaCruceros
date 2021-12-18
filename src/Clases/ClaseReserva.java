
package Clases;


public class ClaseReserva {
    
    //Atributos
    private int idreserva;
    private static int idcamarote;
    private static String tipocamarote;
    private static int preciocamarote;
    private static int numeropersonas;
    private int idbuque;
    private static String nombrebuque;
    private int idviaje;
    private static String idcliente;
    private static String nombrecliente;
    private static int edad;
    private static String idempleado;
    private int iddestino;
    private static String nombredestino;
    private int idsalida;
    private static String nombresalida;
    private static String fechasalida;
    private static String fecharetorno;
    private static int duracion;
    private double costoalojamiento;
    
    //Encapsulamiento 
    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdcamarote() {
        return idcamarote;
    }

    public void setIdcamarote(int idcamarote) {
        this.idcamarote = idcamarote;
    }

    public int getIdbuque() {
        return idbuque;
    }

    public void setIdbuque(int idbuque) {
        this.idbuque = idbuque;
    }

    public int getIdviaje() {
        return idviaje;
    }

    public void setIdviaje(int idviaje) {
        this.idviaje = idviaje;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public int getIddestino() {
        return iddestino;
    }

    public void setIddestino(int iddestino) {
        this.iddestino = iddestino;
    }

    public int getIdsalida() {
        return idsalida;
    }

    public void setIdsalida(int idsalida) {
        this.idsalida = idsalida;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getFecharetorno() {
        return fecharetorno;
    }

    public void setFecharetorno(String fecharetorno) {
        this.fecharetorno = fecharetorno;
    }

    public double getCostoalojamiento() {
        return costoalojamiento;
    }

    public void setCostoalojamiento(double costoalojamiento) {
        this.costoalojamiento = costoalojamiento;
    }

    public String getTipocamarote() {
        return tipocamarote;
    }

    public void setTipocamarote(String tipocamarote) {
        this.tipocamarote = tipocamarote;
    }

    public String getNombrebuque() {
        return nombrebuque;
    }

    public void setNombrebuque(String nombrebuque) {
        this.nombrebuque = nombrebuque;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getNombredestino() {
        return nombredestino;
    }

    public void setNombredestino(String nombredestino) {
        this.nombredestino = nombredestino;
    }

    public String getNombresalida() {
        return nombresalida;
    }

    public void setNombresalida(String nombresalida) {
        this.nombresalida = nombresalida;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPreciocamarote() {
        return preciocamarote;
    }

    public void setPreciocamarote(int preciocamarote) {
        this.preciocamarote = preciocamarote;
    }

    public int getNumeropersonas() {
        return numeropersonas;
    }

    public void setNumeropersonas(int numeropersonas) {
        this.numeropersonas = numeropersonas;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    
    //Metodo de polimorfismo
    public double CalculoCosto(){
        return 0;
    }
    
     public double Subtotal(){
        return 0;
    }
    
}
