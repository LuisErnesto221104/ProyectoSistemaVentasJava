/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basedatos;

import conexion.Conexion;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Propietario;

/**
 *
 * @author ernes
 */
public class TablaPropietario {
    
    public boolean guardar(Propietario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_propietario values(?,?,?,?,?)",
            Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getTelefono());
            consulta.setString(4, objeto.getDireccion());
            consulta.setString(5, objeto.getRazonsocial());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            
            ResultSet rs = consulta.getGeneratedKeys();
            while(rs.next()){
                BigDecimal iDColVar = rs.getBigDecimal(1);
                int idCabeceraRegistrada = iDColVar.intValue();
            }
            
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cabecera de venta: " + e);
        }
        return respuesta;
    }
    
    // Otros métodos de la clase
    
    public Propietario buscarPorId(int id) {
        Propietario propietario = null;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("SELECT * FROM tb_propietario WHERE idPropietario = ?");
            consulta.setInt(1, id);
            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                propietario = new Propietario();
                propietario.setIdPropietario(rs.getInt("idPropietario"));
                propietario.setNombre(rs.getString("nombre"));
                propietario.setTelefono(rs.getString("telefono"));
                propietario.setDireccion(rs.getString("direccion"));
                propietario.setRazonsocial(rs.getString("razonsocial"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar propietario por ID: " + e);
        }
        return propietario;
    }
}

    

