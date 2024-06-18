package basedatos;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;

public class TablaCliente {

    /**
     * **************************************************
     * metodo para guardar un nuevo cliente
     * **************************************************
     */
    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cliente values(?,?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellidoPaterno());
            consulta.setString(4, objeto.getApellidoMaterno());
            consulta.setString(5, objeto.getCurp());
            consulta.setString(6, objeto.getTelefono());
            consulta.setString(7, objeto.getTipotarjeta());
            consulta.setString(8, objeto.getNumtarjeta());
            consulta.setInt(9, objeto.getNumCasa());
            consulta.setString(10, objeto.getCalle());
            consulta.setString(11, objeto.getColonia());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * ********************************************************************
     * metodo para consultar si el producto ya esta registrado en la BBDD
     * ********************************************************************
     */
    public boolean existeCliente(String curp) {
        boolean respuesta = false;
        String sql = "select curp from tb_cliente where curp = '" + curp + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para actualizar un cliente
     * **************************************************
     */
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_cliente set nombre=?, apellidoPaterno = ?, apellidoMaterno = ?, curp = ?, telefono= ?, tipoTarjeta = ?, numTarjeta = ?, numCasa = ?,  calle = ?, colonia = ? where idCliente ='" + idCliente + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellidoPaterno());
            consulta.setString(3, objeto.getApellidoMaterno());
            consulta.setString(4, objeto.getCurp());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getTipotarjeta());
            consulta.setString(7, objeto.getNumtarjeta());
            consulta.setInt(8, objeto.getNumCasa());
            consulta.setString(9, objeto.getCalle());
            consulta.setString(10, objeto.getColonia());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }
        return respuesta;
    }

    /**
     * **************************************************
     * metodo para eliminar un cliente
     * **************************************************
     */
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_cliente where idCliente ='" + idCliente + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }
        return respuesta;
    }

}
