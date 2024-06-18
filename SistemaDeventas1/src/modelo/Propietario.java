/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ernes
 */
public class Propietario {
    
    private int idPropietario;
    private String nombre;
    private String telefono;
    private String direccion;
    private String razonsocial;
    
    public Propietario(){
        this.idPropietario = 0;
        this.nombre = "";
        this.telefono = "";
        this.direccion = "";
        this.razonsocial = "";
    }

    public Propietario(int idPropietario, String nombre, String telefono, String direccion, String razonsocial) {
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razonsocial = razonsocial;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    @Override
    public String toString() {
        return "Propietario{" + "idPropietario=" + idPropietario + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", razonsocial=" + razonsocial + '}';
    }
    
    
    
}
