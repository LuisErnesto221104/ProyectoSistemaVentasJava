package basedatos;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ernes
 */
public class TablaReportes {

    /* ********************************************************************
    * metodoREPORTE CLIENTES
    *********************************************************************** */
    public void ReportesClientes() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
            Image header = Image.getInstance("D:\\Archivos\\Descargas\\SistemaDeventas1\\src\\img\\Images\\reporte.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por Ernesto gerente de el Delfinsito S.A. de C.V. \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Clientes \n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombres");
            tabla.addCell("Curp");
            tabla.addCell("Telefono");
            tabla.addCell("Calle");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select idCliente, concat(nombre, ' ', apellidoPaterno,' ', apellidoMaterno ) as nombres, curp, telefono, calle from tb_cliente");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }
    
    /* ********************************************************************
    REPORTE PRODUCTOS
    *********************************************************************** */
    public void ReportesProductos() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Productos.pdf"));
            Image header = Image.getInstance("D:\\Archivos\\Descargas\\SistemaDeventas1\\src\\img\\Images\\reporte.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por Ernesto gerente de el Delfinsito S.A. de C.V. \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Productos \n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);
            
            float[] columnsWidths = {8,15, 15, 14, 10, 18, 10, 16};

            PdfPTable tabla = new PdfPTable(columnsWidths);
            tabla.addCell("Num");
            tabla.addCell("Cod. Barras");
            tabla.addCell("Nombre");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");
            tabla.addCell("Descripcion");
            tabla.addCell("Por. Iva");
            tabla.addCell("Categoria");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select p.idProducto, p.codbarras,p.nombre, p.cantidad, p.precio, p.descripcion, "
                                + "p.porcentajeIva, c.descripcion as categoria "
                                + "from tb_producto as p, tb_categoria as c "
                                + "where p.idCategoria = c.idCategoria;");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }
    
    /* ********************************************************************
    REPORTE CATEGORIAS 
    *********************************************************************** */
    public void ReportesCategorias() {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Categorias.pdf"));
            Image header = Image.getInstance("D:\\Archivos\\Descargas\\SistemaDeventas1\\src\\img\\Images\\reporte.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            //formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por Ernesto gerente de el Delfinsito S.A. de C.V.  \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Categorias \n\n");

            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);

            PdfPTable tabla = new PdfPTable(2);
            tabla.addCell("Codigo");
            tabla.addCell("Descripcion");

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from tb_categoria");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                    } while (rs.next());
                    documento.add(tabla);
                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }
            documento.close();
            
            JOptionPane.showMessageDialog(null, "Reporte creado");

        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }
    
    /* ********************************************************************
    REPORTE VENTAS
    *********************************************************************** */
    public void ReportesVentas() {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Ventas.pdf"));
        Image header = Image.getInstance("D:\\Archivos\\Descargas\\SistemaDeventas1\\src\\img\\Images\\reporte.png");
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);
        // Formato al texto
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("Reporte creado por Ernesto gerente de el Delfinsito S.A. de C.V. \n\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo.add("Reporte de Ventas \n\n");

        documento.open();
        // Agregamos los datos
        documento.add(header);
        documento.add(parrafo);
        
        float[] columnsWidths = {3, 4, 5};

        PdfPTable tabla = new PdfPTable(columnsWidths);
        tabla.addCell("Num");
        tabla.addCell("Tot. Pagar");
        tabla.addCell("Fecha Venta");

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT idCabeceraVenta AS codigo, "
                    + "valorPagar AS total, "
                    + "fechaVenta AS fecha "
                    + "FROM tb_cabecera_venta");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { 
                tabla.addCell(rs.getString("codigo"));
                tabla.addCell(rs.getString("total"));
                tabla.addCell(rs.getString("fecha"));
            }
            documento.add(tabla);
        } catch (SQLException e) {
            System.out.println("Error 4 en: " + e);
        }
        documento.close();
        
        JOptionPane.showMessageDialog(null, "Reporte Ventas creado");

    } catch (DocumentException e) {
        System.out.println("Error 1 en: " + e);
    } catch (FileNotFoundException ex) {
        System.out.println("Error 2 en: " + ex);
    } catch (IOException ex) {
        System.out.println("Error 3 en: " + ex);
    }
    }
    
    /* ********************************************************************
    REPORTE COMPRAS
    *********************************************************************** */
    public void ReportesCompras() {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Compras.pdf"));
        Image header = Image.getInstance("D:\\Archivos\\Descargas\\SistemaDeventas1\\src\\img\\Images\\reporte.png");
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);
        // Formato al texto
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("Reporte creado por Ernesto gerente de el Delfinsito S.A. de C.V. \n\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo.add("Reporte de Compras \n\n");

        documento.open();
        // Agregamos los datos
        documento.add(header);
        documento.add(parrafo);
        
        float[] columnsWidths = {3, 4, 5};

        PdfPTable tabla = new PdfPTable(columnsWidths);
        tabla.addCell("Num");
        tabla.addCell("Tot. Pagar");
        tabla.addCell("Fecha Venta");

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT idCabeceraCompra AS codigo, "
                    + "valorPagar AS total, "
                    + "fechaCompra AS fecha "
                    + "FROM tb_cabecera_compra");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { 
                tabla.addCell(rs.getString("codigo"));
                tabla.addCell(rs.getString("total"));
                tabla.addCell(rs.getString("fecha"));
            }
            documento.add(tabla);
        } catch (SQLException e) {
            System.out.println("Error 4 en: " + e);
        }
        documento.close();
        
        JOptionPane.showMessageDialog(null, "Reporte Compras creado");

    } catch (DocumentException e) {
        System.out.println("Error 1 en: " + e);
    } catch (FileNotFoundException ex) {
        System.out.println("Error 2 en: " + ex);
    } catch (IOException ex) {
        System.out.println("Error 3 en: " + ex);
    }
    }
    

    /*********************************************************************
    REPORTE PROVEDORES
    *********************************************************************** */
    public void ReportesProvedores() {
    Document documento = new Document();
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Provedores.pdf"));
        Image header = Image.getInstance("D:\\Archivos\\Descargas\\SistemaDeventas1\\src\\img\\Images\\reporte.png");
        header.scaleToFit(650, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);
        // Formato al texto
        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.add("Reporte creado por Ernesto gerente de el Delfinsito S.A. de C.V. \n\n");
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
        parrafo.add("Reporte de Proveedores \n\n");

        documento.open();
        
        documento.add(header);
        documento.add(parrafo);

        PdfPTable tabla = new PdfPTable(4);
        tabla.addCell("RFC");
        tabla.addCell("Razón Social");
        tabla.addCell("Calle");
        tabla.addCell("Teléfono");

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT rfc, razonsocial, calle, telefono FROM tb_provedor");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { // Utilizar while en lugar de if para iterar sobre todos los registros
                tabla.addCell(rs.getString("rfc"));
                tabla.addCell(rs.getString("razonsocial"));
                tabla.addCell(rs.getString("calle"));
                tabla.addCell(rs.getString("telefono"));
            }
            documento.add(tabla);
        } catch (SQLException e) {
            System.out.println("Error 4 en: " + e);
        }
        documento.close();
        
        JOptionPane.showMessageDialog(null, "Reporte creado");

    } catch (DocumentException e) {
        System.out.println("Error 1 en: " + e);
    } catch (FileNotFoundException ex) {
        System.out.println("Error 2 en: " + ex);
    } catch (IOException ex) {
        System.out.println("Error 3 en: " + ex);
    }
}





}
