package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Producto {
    
    //Atributos
    private int idProducto;
    private String CodBarras; 
    private String nombre;
    
    private String marca;
    private String contenido;
    private String unidadMedida;
    
    
    private int cantidad;
    private String presentacion;
    private double precio;
    private String descripcion;
    private int porcentajeIva;
    private int idCategoria;
    private Date fechacaducidad;
    
    //Contructor
    public Producto(){
        this.idProducto = 0;
        this.CodBarras = "";
        this.nombre = "";
        this.marca = "";
        
        this.contenido = "";
        this.unidadMedida = "";
        this.cantidad = 0;
        this.presentacion = "";
        this.precio = 0.0;
        this.descripcion = "";
        this.porcentajeIva = 0;
        this.idCategoria = 0;
        
        // Generar la fecha de caducidad aleatoria dentro del próximo año
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_YEAR, new Random().nextInt(365) + 1); // Agrega de 1 a 365 días aleatorios
        this.fechacaducidad = calendar.getTime();
    }
    //Contructor sobrecargado
    public Producto(int idProducto, String CodBarras, String nombre, String marca, String contenido, String unidadMedida, int cantidad,String presentacion, double precio, String descripcion, int porcentajeIva, int idCategoria, Date fechacaducidad) {
        this.idProducto = idProducto;
        this.CodBarras = CodBarras;
        this.nombre = nombre;
        this.marca = marca;
        
        this.contenido = contenido;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.presentacion = presentacion;
        this.precio = precio;
        this.descripcion = descripcion;
        this.porcentajeIva = porcentajeIva;
        this.idCategoria = idCategoria;
        this.fechacaducidad = fechacaducidad;
        
    }
    
    //Set and get

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

        
    public String getCodBarras() {
        return CodBarras;
    }

    public void setCodBarras(String codBarras) {
        this.CodBarras = codBarras;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public String getunidaddMedida() {
        return unidadMedida;
    }

    public void setunidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(int porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public Date getFechacaducidad() {
        return fechacaducidad;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    



    public String getPresentacion() {
        return presentacion;
    }

   

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

  
     public void generarFechaCaducidadAleatoria() {
        Calendar fechaActual = Calendar.getInstance();
        Random random = new Random();
        int dias = random.nextInt(365); // Genera un número aleatorio entre 0 y 365
        fechaActual.add(Calendar.DAY_OF_YEAR, dias);
        this.fechacaducidad = fechaActual.getTime();
    }

   

    
    
    
    
    
}
