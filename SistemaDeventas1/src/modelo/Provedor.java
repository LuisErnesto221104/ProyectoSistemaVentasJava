package modelo;

import java.util.Date;

public class Provedor {
    
    private String RFC;
    private String RazonSocial;
    private int numcasa;
    private String Calle;
    private String orientacion;
    private String colonia;
    private String ciudad;
    private String estadoo;
    private String CP;
    private String Telefono;

    
    public Provedor(){
        this.RFC = "";
        this.RazonSocial = "";
        this.numcasa = 0;
        this.Calle = "";
        this.orientacion = "";
        this.colonia="";
        this.ciudad = "";
        this.estadoo = "";
        this.CP = "";
        this.Telefono = "";
        
    }
    
    public Provedor(String RFC, String RazonSocial, int numcasa, String Calle, String orientacion, String colonia, String ciudad, String estadoo, String CP, String Telefono) {
        this.RFC = RFC;
        this.RazonSocial = RazonSocial;
        this.numcasa = numcasa;
        this.Calle = Calle;
        this.orientacion = orientacion;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estadoo = estadoo;
        this.CP = CP;
        this.Telefono = Telefono;
    }

    public String getRFC() {
        return RFC;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public int getNumcasa() {
        return numcasa;
    }

    public String getCalle() {
        return Calle;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getEstadoo() {
        return estadoo;
    }

    public String getCP() {
        return CP;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public void setNumcasa(int numcasa) {
        this.numcasa = numcasa;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setEstadoo(String estadoo) {
        this.estadoo = estadoo;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }  
}
