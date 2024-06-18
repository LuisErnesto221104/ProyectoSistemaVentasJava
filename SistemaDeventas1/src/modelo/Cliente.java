package modelo;

/**
 *
 * @author ediso
 */
public class Cliente {

    //Atributos
    private int idCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String Curp;
    private String telefono;
    private String Tipotarjeta;
    private String Numtarjeta;
    private int numCasa;
    private String calle;
    private String colonia;
    

    //Constructor
    public Cliente() {
        this.idCliente = 0;
        this.nombre = "";
        this.apellidoPaterno = "";
        this.apellidoMaterno="";
        this.Curp = "";
        this.telefono = "";
        this.Tipotarjeta = "";
        this.Numtarjeta = "";
        this.numCasa = 0;
        this.calle = "";
        this.colonia = "";
        
    }

    //Constructor sobrecargado
    public Cliente(int idCliente, String nombre, String apellidoPaterno,String apellidoMaterno, String curp, String telefono,String tipoTarjeta, 
            String numTarjeta, int numcasa,  String calle, String colonia) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.Curp = curp;
        this.telefono = telefono;
        this.Tipotarjeta = tipoTarjeta;
        this.Numtarjeta = numTarjeta;
        this.numCasa = numcasa;
        this.calle = calle;
        this.colonia = colonia;
    }

    //metodos set and get
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String curp) {
        this.Curp = curp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipotarjeta() {
        return Tipotarjeta;
    }

    public String getNumtarjeta() {
        return Numtarjeta;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public String getColonia() {
        return colonia;
    }

    public void setTipotarjeta(String Tipotarjeta) {
        this.Tipotarjeta = Tipotarjeta;
    }

    public void setNumtarjeta(String Numtarjeta) {
        this.Numtarjeta = Numtarjeta;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
    

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

 

}
