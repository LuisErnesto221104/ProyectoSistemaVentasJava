package basedatos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Producto;


public class TablaProducto {
     /**
     * **************************************************
     * metodo para guardar un nuevo producto
     * **************************************************
     */
    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO tb_producto VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getCodBarras());
            consulta.setString(3, objeto.getNombre());
            consulta.setString(4, objeto.getMarca());
            consulta.setString(5, objeto.getContenido());
            consulta.setString(6, objeto.getunidaddMedida());
            consulta.setInt(7, objeto.getCantidad());
            consulta.setDouble(8, objeto.getPrecio());
            consulta.setString(9, objeto.getDescripcion());
            consulta.setInt(10, objeto.getPorcentajeIva());
            consulta.setInt(11, objeto.getIdCategoria());
            consulta.setString(12, objeto.getPresentacion());
            
            
            java.util.Date utilDate = objeto.getFechacaducidad();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            consulta.setDate(13, sqlDate); 
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar producto: " + e);
        }
        
        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si el producto ya esta registrado en la BBDD
     * ********************************************************************
     */
    public boolean existeProducto(String producto) {
        boolean respuesta = false;
        String sql = "select nombre from tb_producto where nombre = '" + producto + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar producto: " + e);
        }
        return respuesta;
    }
    
     /**
     * **************************************************
     * metodo para actualizar un producto
     * **************************************************
     */
    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_producto set codbarras = ?,  nombre=?,marca =?, contenido = ?, unidadMedida = ?, cantidad = ?, precio = ?, descripcion= ?, porcentajeIva = ?, idCategoria = ?, presentacion =  ? where idProducto ='" + idProducto + "'");
            consulta.setString(1, objeto.getCodBarras());
            consulta.setString(2, objeto.getNombre());
            
            consulta.setString(3, objeto.getMarca() );
            
            consulta.setString(4, objeto.getContenido());
            consulta.setString(5, objeto.getunidaddMedida());
            consulta.setInt(6, objeto.getCantidad());
            consulta.setDouble(7, objeto.getPrecio());
            consulta.setString(8, objeto.getDescripcion());
            consulta.setInt(9, objeto.getPorcentajeIva());
            consulta.setInt(10, objeto.getIdCategoria());
            consulta.setString(11, objeto.getPresentacion());
            
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }
        return respuesta;
    }
    
    
    /**
     * **************************************************
     * metodo para eliminar un producto
     * **************************************************
     */
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_producto where idProducto ='" + idProducto + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
        }
        return respuesta;
    }
    
    /**
     * **************************************************
     * metodo para actualizar stock un producto
     * **************************************************
     */
    
     public boolean actualizarStock(Producto object, int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set cantidad=? where idProducto ='" + idProducto + "'");
            consulta.setInt(1, object.getCantidad());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar stock del producto: " + e);
        }
        return respuesta;
    }
}
