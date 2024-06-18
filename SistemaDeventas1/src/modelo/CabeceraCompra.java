package modelo;

public class CabeceraCompra {
    
    private int idCabeceraCompra;
    private int Folio;
    private int valorPagar;
    private String FechaCompra;
    private String horaCompra;
    
    public CabeceraCompra(){
        this.idCabeceraCompra=0;
        this.Folio = 0;
        this.valorPagar = 0;
        this.FechaCompra = "";
        this.horaCompra = "";
    }

    public CabeceraCompra(int idCabeceraCompra, int Folio, int valorPagar, String FechaCompra, String horaCompra) {
        this.idCabeceraCompra = idCabeceraCompra;
        this.Folio = Folio;
        this.valorPagar = valorPagar;
        this.FechaCompra = FechaCompra;
        this.horaCompra = horaCompra;
    }

    public int getIdCabeceraCompra() {
        return idCabeceraCompra;
    }

    public int getFolio() {
        return Folio;
    }

    public int getValorPagar() {
        return valorPagar;
    }

    public String getFechaCompra() {
        return FechaCompra;
    }

    public void setIdCabeceraCompra(int idCabeceraCompra) {
        this.idCabeceraCompra = idCabeceraCompra;
    }

    public void setFolio(int Folio) {
        this.Folio = Folio;
    }

    public void setValorPagar(int valorPagar) {
        this.valorPagar = valorPagar;
    }

    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public String getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(String horaCompra) {
        this.horaCompra = horaCompra;
    }

    @Override
    public String toString() {
        return "CabeceraCompra{" + "idCabeceraCompra=" + idCabeceraCompra + ", Folio=" + Folio + ", valorPagar=" + valorPagar + ", FechaCompra=" + FechaCompra + ", horaCompra=" + horaCompra + '}';
    }
    

    
    
    
}
