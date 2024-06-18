/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ernes
 */
public class ProveedorDAO {
    public String obtenerDireccionProveedor(String razonSocial) {
    String direccion = "";
    String numero = "";
    String sql = "SELECT calle FROM tb_provedor WHERE razonsocial = ?";
    
    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, razonSocial);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            direccion = rs.getString("calle");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return direccion;
}
    
    public String obtenerCiudadProveedor(String razonSocial) {
    String ciudad = "";
    String sql = "SELECT ciudad FROM tb_provedor WHERE razonsocial = ?";
    
    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, razonSocial);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            ciudad = rs.getString("ciudad");
           
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ciudad;
    }
    
    public String obtenerEstadoProveedor(String razonSocial) {
    String estado = "";
    String sql = "SELECT estadoo FROM tb_provedor WHERE razonsocial = ?";
    
    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, razonSocial);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            estado = rs.getString("estadoo");
           
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return estado;
    }


    public String obtenerTelefonoProveedor(String razonSocial) {
        String telefono = "";
        String sql = "SELECT telefono FROM tb_provedor WHERE razonsocial = ?";
        
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, razonSocial);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                telefono = rs.getString("telefono");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return telefono;
    }
    
}
