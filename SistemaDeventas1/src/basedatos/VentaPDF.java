package basedatos;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import modelo.Propietario;
import vista.VistaCapturaFacturacion;

public class VentaPDF {

    private int folio;
    private int factura;
    private String fechaActual = "";
    private String nombreArchivoPDFVenta = "";
    private String horaactual;

    public void DatosCliente(int folio) {
        folio = folio;
    }

    public void generarFacturaPDF() {
        try {
            generarFolio();
            Date date = new Date();
            SimpleDateFormat sdfFecha = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm:ss aa");
            sdfHora.setTimeZone(TimeZone.getDefault());
            fechaActual = sdfFecha.format(date);
            horaactual = sdfHora.format(date);
            String fechaNueva = fechaActual.replace("/", "_");

            nombreArchivoPDFVenta = "Venta_" + folio + "_" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

           

            // Información de la empresa
            TablaPropietario tablaPropietario = new TablaPropietario();
            Propietario propietario = tablaPropietario.buscarPorId(1);
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            Paragraph empresa = new Paragraph(propietario.getNombre(), negrita);
            empresa.setAlignment(Element.ALIGN_CENTER);
            doc.add(empresa);

            // Detalles de contacto
            Paragraph contacto = new Paragraph("Teléfono: "+ propietario.getTelefono()+"\nDirección: "+propietario.getDireccion()+"\nRazon Social: "+propietario.getRazonsocial()+"\n", negrita);
            contacto.setAlignment(Element.ALIGN_CENTER);
            doc.add(contacto);

            // Información de la venta
            Paragraph infoVenta = new Paragraph();
            infoVenta.add(Chunk.NEWLINE);
            infoVenta.add("Fecha: " + fechaActual + "    Hora: " + horaactual + "    Factura: " + factura + "\n\n");
            infoVenta.setAlignment(Element.ALIGN_CENTER);
            doc.add(infoVenta);

            // Detalle de los productos
            PdfPTable tablaProducto = new PdfPTable(6);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            float[] ColumnaProducto = new float[]{30f, 50f, 70f, 40f, 40f,50f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_CENTER);

            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Cód. Barras", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Nombre/Descripción", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Unitario", negrita));
            PdfPCell producto5 = new PdfPCell(new Phrase("Subtotal", negrita));
            PdfPCell producto6 = new PdfPCell(new Phrase("Fecha Caducidad", negrita));

            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            producto5.setBorder(0);
            producto6.setBorder(0);

            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto6.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);
            tablaProducto.addCell(producto5);
            tablaProducto.addCell(producto6);

            for (int i = 0; i < VistaCapturaFacturacion.jTable_productos.getRowCount(); i++) {
                String cantidad = VistaCapturaFacturacion.jTable_productos.getValueAt(i, 3).toString();
                String codbarras = VistaCapturaFacturacion.jTable_productos.getValueAt(i, 1).toString();
                String producto = VistaCapturaFacturacion.jTable_productos.getValueAt(i, 2).toString();
                String precio = VistaCapturaFacturacion.jTable_productos.getValueAt(i, 4).toString();
                String total = VistaCapturaFacturacion.jTable_productos.getValueAt(i, 7).toString();
                String fechacad = VistaCapturaFacturacion.jTable_productos.getValueAt(i, 8).toString();

                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(codbarras);
                tablaProducto.addCell(producto);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
                tablaProducto.addCell(fechacad);
            }

            doc.add(tablaProducto);

            // Total a pagar
            Paragraph totalPagar = new Paragraph("Total a pagar: " + VistaCapturaFacturacion.txt_total_pagar_factura.getText(), negrita);
            totalPagar.setAlignment(Element.ALIGN_RIGHT);
            doc.add(totalPagar);

            // Mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por su compra!\nFirma:\n___________________");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            // Datos de contacto
            Paragraph datosContacto = new Paragraph();
            datosContacto.add(Chunk.NEWLINE);
            datosContacto.add("Dudas o aclaraciones al:\nTeléfono: 7157358246\nCorreo: ernestogomez2211@gmail.com");
            datosContacto.setAlignment(Element.ALIGN_CENTER);
            doc.add(datosContacto);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

    private void generarFolio() {
        Random random = new Random();
        factura = 1000 + random.nextInt(9000); // Genera un número aleatorio entre 1000 y 9999
    }
}
