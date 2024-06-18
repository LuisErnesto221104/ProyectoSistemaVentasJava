package modelo;

/**
 *
 * @author ediso
 */
public class Categoria {
    
    private int idCategoria;
    private String descripcion;
    
    
    public Categoria(){
        this.idCategoria = 0;
        this.descripcion = "";
    }

    public Categoria(int idCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

     
    
}
