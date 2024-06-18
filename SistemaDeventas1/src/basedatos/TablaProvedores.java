package basedatos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Provedor;

/**
 *
 * @author ernes
 */
public class TablaProvedores {
    
    public boolean  guardar(Provedor objeto){
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_provedor values(?,?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getRFC());
            consulta.setString(3, objeto.getRazonSocial());
            consulta.setInt(4, objeto.getNumcasa());
            consulta.setString(5, objeto.getCalle());
            consulta.setString(6, objeto.getOrientacion());
            consulta.setString(7, objeto.getColonia());
            consulta.setString(8, objeto.getCiudad());
            consulta.setString(9, objeto.getEstadoo());
            consulta.setString(10, objeto.getCP());
            consulta.setString(11, objeto.getTelefono());
            
            if(consulta.executeUpdate() > 0){
                respuesta = true;
            }
            
            cn.close();
            
            
        } catch (SQLException e) {
            System.out.println("Error al guardar el provedor: " + e);
        }
        return respuesta;
    }
    
    public boolean existeProvedor(String provedor){
        boolean respuesta = false;
        
        String sql = "Select razonsocial from tb_provedor where razonsocial = '" + provedor + "';";
         Statement st;
         
         try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
             while (rs.next()) {
                 respuesta = true;
             }
             
        } catch (SQLException e) {
             System.out.println("Error al consultar el provedor" + e);
        }
         return respuesta;
    }
    
    public boolean actualizar(Provedor objeto, int idProvedor){
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_provedor set rfc = ?, razonsocial = ?, numcasa =?, calle = ?,orientacion = ?, colonia = ?, ciudad = ?, estadoo= ?, cp = ?, telefono =? where idprovedor = '" + idProvedor + "'");
            consulta.setString(1, objeto.getRFC());
            consulta.setString(2, objeto.getRazonSocial());
            consulta.setInt(3, objeto.getNumcasa());
            consulta.setString(4, objeto.getCalle());
            consulta.setString(5, objeto.getOrientacion());
            consulta.setString(6, objeto.getColonia());
            consulta.setString(7, objeto.getCiudad());
            consulta.setString(8, objeto.getEstadoo());
            consulta.setString(9, objeto.getCP());
            consulta.setString(10, objeto.getTelefono());
            
            if(consulta.executeUpdate() > 0){
                respuesta = true;
            }
            cn.close();
            
        } catch (SQLException e) {
            System.out.println("Error al ctualizar el provedor: " + e);
        }
        return  respuesta;
    }
    
    public boolean eliminar(int idprovedor){
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        
        try {
            PreparedStatement consulta = cn.prepareStatement(
            "delete from tb_provedor where idprovedor = '" + idprovedor + "'");
            consulta.executeUpdate();
            
            if(consulta.executeUpdate() > 0){
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar al provedor" + e);
        }
        
        return respuesta;
    }
    
    
    
}
