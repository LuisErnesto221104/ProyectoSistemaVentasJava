package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class DetalleCompra {
    
    private int idDetalleCompra;
    private int idCabeceraCompra;
    private int idProducto;
    private String nombre;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;
    private double descuento;
    private double iva;
    private double totalPagar;
    private String codbarras;
    private Date fechacaducidad;

    
    public DetalleCompra(int auxIdDetalle, int par, int idProducto1, String nombre1, int parseInt, double precioUnitario1, double subtotal, double descuento1, double iva1, double totalPagar1,String codbarras1, int par1, Date fechacad) {
        this.idDetalleCompra = 0;
        this.idCabeceraCompra = 0;
        this.idProducto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.precioUnitario = 0.0;
        this.subTotal = 0.0;
        this.descuento = 0.0;
        this.iva = 0.0;
        this.totalPagar = 0.0;
        this.codbarras="";
        // Generar la fecha de caducidad aleatoria dentro del próximo año
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_YEAR, new Random().nextInt(365) + 1); // Agrega de 1 a 365 días aleatorios
        this.fechacaducidad = calendar.getTime();
    }

    public DetalleCompra(int idDetalleCompra, int idCabeceraCompra, int idProducto, String nombre, int cantidad, double precioUnitario, double subTotal, double descuento, double iva, double totalPagar, String codbarras, Date fechacaducidad) {
        this.idDetalleCompra = idDetalleCompra;
        this.idCabeceraCompra = idCabeceraCompra;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.iva = iva;
        this.totalPagar = totalPagar;
        this.codbarras = codbarras;
        this.fechacaducidad = fechacaducidad;
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public int getIdCabeceraCompra() {
        return idCabeceraCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getIva() {
        return iva;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public String getCodbarras() {
        return codbarras;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public void setIdCabeceraCompra(int idCabeceraCompra) {
        this.idCabeceraCompra = idCabeceraCompra;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public void setCodbarras(String codbarras) {
        this.codbarras = codbarras;
    }

    public Date getFechacaducidad() {
        return fechacaducidad;
    }

    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    
    
    @Override
    public String toString() {
        return "DetalleCompra{" + "idDetalleCompra=" + idDetalleCompra + ", idCabeceraCompra=" + idCabeceraCompra + ", idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subTotal=" + subTotal + ", descuento=" + descuento + ", iva=" + iva + ", totalPagar=" + totalPagar + ", codbarras=" + codbarras + '}';
    }
    
    
    
    
}
