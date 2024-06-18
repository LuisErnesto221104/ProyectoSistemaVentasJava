package vista;

import basedatos.CompraPDF;
import basedatos.TablaProducto;
import basedatos.TablaRegistrarCompra;
import conexion.Conexion;
import basedatos.TablaRegistrarVenta;
import basedatos.VentaPDF;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.CabeceraCompra;
import modelo.CabeceraVenta;
import modelo.DetalleCompra;
import modelo.DetalleVenta;
import modelo.Producto;
import modelo.ProveedorDAO;

public class vistaCapturaStock extends javax.swing.JInternalFrame {

    //Modelo de los datos
    private DefaultTableModel modeloDatosProductos;
    //lista para el detalle de venta de los productos
    ArrayList<DetalleCompra> listaProductos = new ArrayList<>();
    private DetalleCompra producto;
    
    private int folio = 0;//id del cliente sleccionado
    
    private String codbarras="";
    private Date fechacaducidad;

    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBDD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIva = 0;

    private int cantidad = 0;//cantidad de productos a comprar
    private double subtotal = 0.0;//cantidad por precio
    private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    //variables para calculos globales
    private double subtotalGeneral = 0.0;
    private double descuentoGeneral = 0.0;
    private double ivaGeneral = 0.0;
    private double totalPagarGeneral = 0.0;
    //fin de variables de calculos globales

    private int auxIdDetalle = 1;//id del detalle de venta
    
    private String razoncocial;

    public vistaCapturaStock() {
        initComponents();
        
        this.setSize(new Dimension(800, 600));
        this.setTitle("Resurtido");

        //Cargar lo Clientes en la vista - cargar productos
        this.CargarComboProductos();
        this.CargarProvedores();
        this.inicializarTablaProducto();
        ConfigurarTablaProductos();

        txt_efectivo.setEnabled(false);
        btnCambio.setEnabled(false);

        txt_subtotal.setText("0.0");
        txt_iva.setText("0.0");
        txt_descuento.setText("0.0");
        txt_total_pagar.setText("0.0");

        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("D:\\Archivos\\Descargas\\SistemaDeventas1\\src\\img\\Images\\Fondo1.png");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
    }

    
    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel();
        //añadir columnas
        modeloDatosProductos.addColumn("N");
        modeloDatosProductos.addColumn("Codigo Barras");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Iva");
        modeloDatosProductos.addColumn("Total Pagar");
        modeloDatosProductos.addColumn("Fecha Caducidad");
        modeloDatosProductos.addColumn("Accion");
        //agregar los datos del modelo a la tabla
        vistaCapturaStock.jTable_productos.setModel(modeloDatosProductos);
    }
    
    private void ConfigurarTablaProductos() {
    TableColumnModel columnModel = jTable_productos.getColumnModel();
    
    columnModel.getColumn(0).setPreferredWidth(40); 
    columnModel.getColumn(1).setPreferredWidth(150); 
    columnModel.getColumn(2).setPreferredWidth(150); 
    columnModel.getColumn(3).setPreferredWidth(100); 
    columnModel.getColumn(4).setPreferredWidth(100); 
    columnModel.getColumn(5).setPreferredWidth(110); 
    columnModel.getColumn(6).setPreferredWidth(55); 
    columnModel.getColumn(7).setPreferredWidth(120);
    columnModel.getColumn(8).setPreferredWidth(200);
    }

    //metodo para presentar la informacion de la tabla Compra
    private void listaTablaProductos() {
        this.modeloDatosProductos.setRowCount(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getNombre(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCantidad(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getCodbarras(),i , 1);
           
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getIva(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt(listaProductos.get(i).getFechacaducidad(), i, 8);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 9);
        }
        txt_efectivo.requestFocus();
        jTable_productos.setModel(modeloDatosProductos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cajaProducto = new javax.swing.JComboBox<>();
        cajaCantidadStock = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_descuento = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        txt_total_pagar = new javax.swing.JTextField();
        txt_efectivo = new javax.swing.JTextField();
        txt_cambio = new javax.swing.JTextField();
        btnCambio = new javax.swing.JButton();
        jButton_RegistrarVenta = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cajaStockActual = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cajaProvedor = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Facturación");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        cajaProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        cajaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaProductoActionPerformed(evt);
            }
        });
        getContentPane().add(cajaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 170, -1));

        cajaCantidadStock.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaCantidadStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCantidadStockActionPerformed(evt);
            }
        });
        cajaCantidadStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCantidadStockKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCantidadStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 60, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 760, 210));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Iva:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total a pagar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Efectivo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Cambio:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txt_subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_subtotal.setEnabled(false);
        jPanel2.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 120, -1));

        txt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_descuento.setEnabled(false);
        jPanel2.add(txt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 120, -1));

        txt_iva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_iva.setEnabled(false);
        jPanel2.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 120, -1));

        txt_total_pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_total_pagar.setEnabled(false);
        jPanel2.add(txt_total_pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        txt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_efectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_efectivoActionPerformed(evt);
            }
        });
        txt_efectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_efectivoKeyTyped(evt);
            }
        });
        jPanel2.add(txt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, -1));

        txt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_cambio.setEnabled(false);
        jPanel2.add(txt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 120, -1));

        btnCambio.setBackground(new java.awt.Color(153, 255, 102));
        btnCambio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCambio.setText("Calcular Cambio");
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });
        jPanel2.add(btnCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 130, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 380, 210));

        jButton_RegistrarVenta.setBackground(new java.awt.Color(204, 255, 102));
        jButton_RegistrarVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_RegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        jButton_RegistrarVenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistrarVenta.setLabel("Actualizar Stock");
        jButton_RegistrarVenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 170, 100));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Provedor:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Actualizar Stock:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 150, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Stock Actual:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 120, -1));
        getContentPane().add(cajaStockActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 80, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Producto:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, -1));

        cajaProvedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaProvedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione provedor:", "Item 2", "Item 3", "Item 4" }));
        cajaProvedor.setName(""); // NOI18N
        cajaProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaProvedorActionPerformed(evt);
            }
        });
        getContentPane().add(cajaProvedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemaDeventas1/src/img/Images/FondoGestionVentas.png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        if (!txt_efectivo.getText().isEmpty()) {
            //validamos que el usuario no ingrese otros caracteres no numericos 
            boolean validacion = validarDouble(txt_efectivo.getText());
            if (validacion == true) {
                //validar que el efectivo sea mayor a cero
                double efc = Double.parseDouble(txt_efectivo.getText().trim());
                double top = Double.parseDouble(txt_total_pagar.getText().trim());

                if (efc < top) {
                    JOptionPane.showMessageDialog(null, "El Dinero en efectivo no es suficiente");
                } else {
                    double cambio = (efc - top);
                    double cambi = (double) Math.round(cambio * 100d) / 100;
                    String camb = String.valueOf(cambi);
                    txt_cambio.setText(camb);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se admiten caracteres no numericos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese dinero en efectivo para calcular cambio");
        }
    }//GEN-LAST:event_btnCambioActionPerformed
    int idArrayList = 0;
    
    
    private void jTable_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_productosMouseClicked
        int fila_point = jTable_productos.rowAtPoint(evt.getPoint());
        int columna_point = 0;
        if (fila_point > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(fila_point, columna_point);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?");
        
        switch (opcion) {
            case 0: 
                listaProductos.remove(idArrayList - 1);
                this.CalcularTotalPagar();
                this.listaTablaProductos();
                break;
            case 1: 
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jTable_productosMouseClicked

    private void jButton_RegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarVentaActionPerformed
        
       
        CabeceraCompra cabeceraCompra = new CabeceraCompra();
        TablaRegistrarCompra controlVenta = new TablaRegistrarCompra();
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        String direccionProveedor = proveedorDAO.obtenerDireccionProveedor(razoncocial);
        String telefonoProveedor = proveedorDAO.obtenerTelefonoProveedor(razoncocial);
        String ciudadprovedor = proveedorDAO.obtenerCiudadProveedor(razoncocial);
        String estadoProvedor = proveedorDAO.obtenerEstadoProveedor(razoncocial);
        

        String fechaActual = "";
        String horaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
        horaActual = new SimpleDateFormat("hh:mm:ss aa").format(date);

        if (listaProductos.size() > 0) {

            this.generarIdCliente();

            
            cabeceraCompra.setIdCabeceraCompra(0);
            cabeceraCompra.setFolio(folio);
            cabeceraCompra.setValorPagar((int) Double.parseDouble(txt_total_pagar.getText()));
            cabeceraCompra.setFechaCompra(fechaActual);
            cabeceraCompra.setHoraCompra(horaActual);

            if (controlVenta.guardar(cabeceraCompra)) {

                
                CompraPDF pdf = new CompraPDF();
                pdf.DatosCliente(folio);
                pdf.DatosProvedor(razoncocial, telefonoProveedor, direccionProveedor, ciudadprovedor, estadoProvedor);
                pdf.generarFacturaPDF();
                
                
                
              for (DetalleCompra elemento : listaProductos) {
                DetalleCompra detalleCompra = new DetalleCompra(auxIdDetalle, 0, elemento.getIdProducto(), elemento.getNombre(), elemento.getCantidad(), elemento.getPrecioUnitario(), elemento.getSubTotal(), elemento.getDescuento(), elemento.getIva(), elemento.getTotalPagar(), elemento.getCodbarras(), elemento.getFechacaducidad());
                if (controlVenta.guardarDetalle(detalleCompra)) {
                
                int cantidad = elemento.getCantidad();
                 if (cantidad > 0) {
            actualizarStockProducto(elemento.getIdProducto(), cantidad);
        } else {
            System.err.println("Cantidad a actualizar no válida: " + cantidad);
        }
    } else {
        JOptionPane.showMessageDialog(null, "¡Error al guardar detalle de venta!");
    }
}
                

                txt_subtotal.setText("0.0");
                txt_iva.setText("0.0");
                txt_descuento.setText("0.0");
                txt_total_pagar.setText("0.0");
                
                cajaProducto.setEnabled(false);
                cajaProvedor.setEnabled(false);
                cajaStockActual.setEnabled(false);
                cajaCantidadStock.setEnabled(false);

                
                listaProductos.clear();
                listaTablaProductos();
                
                cajaProducto.setSelectedItem("Seleccione producto:");
                cajaProvedor.setSelectedItem("Seleccione provedor:");
                cajaStockActual.setText("");
                cajaCantidadStock.setText("");
                this.CargarComboProductos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la compra");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe agregar productos a la venta");
        }
    }//GEN-LAST:event_jButton_RegistrarVentaActionPerformed

    private void txt_efectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_efectivoActionPerformed
      String efectivo = txt_efectivo.getText();
        if (efectivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el efectivo con el que se va a pagar");
        }else{
            btnCambio.setBackground(new Color(255, 0, 255));
            btnCambio.requestFocus();
        }
    }//GEN-LAST:event_txt_efectivoActionPerformed

    private void txt_efectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivoKeyTyped
        char[] letra = txt_efectivo.getText().toCharArray();
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_efectivoKeyTyped

    private void cajaCantidadStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCantidadStockActionPerformed
        String efectivo = cajaCantidadStock.getText();
        if (efectivo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione el producto y provedor");
        }else{
            String combo = this.cajaProducto.getSelectedItem().toString();
            String combo1 = this.cajaProvedor.getSelectedItem().toString();
        
        if (combo.equalsIgnoreCase("Seleccione producto:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        }
        if(combo1.equalsIgnoreCase("Seleccione Provedor:")){
             JOptionPane.showMessageDialog(null, "Seleccione un provedor");
        } 
        else {
            
            if (!cajaCantidadStock.getText().isEmpty()) {
                
                boolean validacion = validar(cajaCantidadStock.getText());
                if (validacion == true) {
                    
                    if (Integer.parseInt(cajaCantidadStock.getText()) > 0) {
                        cantidad = Integer.parseInt(cajaCantidadStock.getText());
                        JOptionPane.showMessageDialog(null, "Recuerda que para cada compra se debe agregar el mimso provedor");
                        razoncocial = cajaProvedor.getSelectedItem().toString();
                        //ejecutar metodo para obtener datos del producto
                        this.DatosDelProducto();
                        
                            subtotal = precioUnitario * cantidad;
                            totalPagar = subtotal + iva + descuento;

                            //redondear decimales
                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            iva = (double) Math.round(iva * 100) / 100;
                            descuento = (double) Math.round(descuento * 100) / 100;
                            totalPagar = (double) Math.round(totalPagar * 100) / 100;

                            
                            producto = new DetalleCompra(auxIdDetalle,
                                    1, //idCabecera
                                    idProducto,
                                    nombre,
                                    Integer.parseInt(cajaCantidadStock.getText()),
                                    precioUnitario,
                                    subtotal,
                                    descuento,
                                    iva,
                                    totalPagar,
                                    codbarras,
                                    fechacaducidad
                            );
                            
                            listaProductos.add(producto);
                            JOptionPane.showMessageDialog(null, "Producto Agregado");
                            auxIdDetalle++;
                            cajaCantidadStock.setText("");
                            this.CargarComboProductos();
                            this.CargarProvedores();
                            this.CalcularTotalPagar();
                            txt_efectivo.setEnabled(true);
                            btnCambio.setEnabled(true);

                        
                    } else {
                        JOptionPane.showMessageDialog(null, "La cantidad no puede ser cero (0), ni negativa");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "En la cantidad no se admiten caracteres no numericos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa la cantidad de productos");
            }
        }
        //llamar al metodo
        this.listaTablaProductos();
        }
    }//GEN-LAST:event_cajaCantidadStockActionPerformed

    private void cajaCantidadStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCantidadStockKeyTyped
        char[] letra = txt_efectivo.getText().toCharArray();
        if(!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCantidadStockKeyTyped

    private void cajaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaProductoActionPerformed
        this.MostrarStock();
    }//GEN-LAST:event_cajaProductoActionPerformed

    private void cajaProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaProvedorActionPerformed
         
    }//GEN-LAST:event_cajaProvedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambio;
    private javax.swing.JTextField cajaCantidadStock;
    private javax.swing.JComboBox<String> cajaProducto;
    private javax.swing.JComboBox<String> cajaProvedor;
    private javax.swing.JTextField cajaStockActual;
    private javax.swing.JButton jButton_RegistrarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_cambio;
    private javax.swing.JTextField txt_descuento;
    private javax.swing.JTextField txt_efectivo;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total_pagar;
    // End of variables declaration//GEN-END:variables


  

    /*
    Metodo para cargar los productos en el jComboBox
     */
    private void CargarComboProductos() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_producto";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            cajaProducto.removeAllItems();
            cajaProducto.addItem("Seleccione producto:");
            while (rs.next()) {
                cajaProducto.addItem(rs.getString("nombre"));
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("¡Error al cargar productos, !" + e);
        }
    }

    //Metodo para cargar los provedores
    private void CargarProvedores(){
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_provedor";
        Statement st;
        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            cajaProvedor.removeAllItems();
            cajaProvedor.addItem("Seleccione provedor:");
            while (rs.next()) {
                cajaProvedor.addItem(rs.getString("razonsocial"));
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar los provedores en: " + e);
        }
    }

    
    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validar(String valor) {
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para validar que el usuario no ingrese caracteres no numericos
     */
    private boolean validarDouble(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
        Metodo para mostrar los datos del producto seleccionado
     */
    private void DatosDelProducto() {
        try {
            String sql = "select * from tb_producto where nombre = '" + this.cajaProducto.getSelectedItem() + "'";
            Connection cn = Conexion.conectar();
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                codbarras = rs.getString("codbarras");
                fechacaducidad = rs.getDate("fechacaducidad");
                cantidadProductoBBDD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio");
                porcentajeIva = rs.getInt("porcentajeIva");
                this.CalcularIva(precioUnitario, porcentajeIva);//calcula y retorna el iva
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto, " + e);
        }
    }

    /*
        Metodo para calcular iva
     */
    private double CalcularIva(double precio, int porcentajeIva) {
        int p_iva = porcentajeIva;

        switch (p_iva) {
            case 0:
                iva = 0.0;
                break;
            case 12:
                iva = (precio * cantidad) * 0.12;
                break;
            case 14:
                iva = (precio * cantidad) * 0.14;
                break;
            default:
                break;
        }

        return iva;
    }

    /*
    Metodo para calcular el total a pagar de todos los productos agregados
     */
    private void CalcularTotalPagar() {
        subtotalGeneral = 0;
        descuentoGeneral = 0;
        ivaGeneral = 0;
        totalPagarGeneral = 0;

        for (DetalleCompra elemento : listaProductos) {
            subtotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            ivaGeneral += elemento.getIva();
            totalPagarGeneral += elemento.getTotalPagar();
        }
        //redondear decimales
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;
        ivaGeneral = (double) Math.round(ivaGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        //enviar datos a la vista
        txt_subtotal.setText(String.valueOf(subtotalGeneral));
        txt_iva.setText(String.valueOf(ivaGeneral));
        txt_descuento.setText(String.valueOf(descuentoGeneral));
        txt_total_pagar.setText(String.valueOf(totalPagarGeneral));
    }
    
    private void generarIdCliente() {
        Random random = new Random();
        folio = 1000 + random.nextInt(9000); // Genera un número aleatorio entre 1000 y 9999
    }

    public int ObtenerIdProducto() {
        String sql = "select idProducto from tb_producto where nombre = '" + cajaProducto.getSelectedItem() + "'";
        Conexion con = new Conexion();
        Connection cn = con.conectar();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el id del producto: " + e);
        }
        return idProducto;
    }
    
    private void actualizarStockProducto(int idProducto, int cantidadVendida) {
    if (cantidadVendida <= 0) {
        System.err.println("Cantidad vendida no puede ser negativa o cero: " + cantidadVendida);
        return;
    }

    Connection cn = Conexion.conectar();
    String sql = "UPDATE tb_producto SET cantidad = cantidad + " + cantidadVendida + " WHERE idProducto = " + idProducto;
    try {
        Statement st = cn.createStatement();
        st.executeUpdate(sql);
        cn.close();
    } catch (SQLException e) {
        System.err.println("Error al actualizar el stock del producto: " + e);
    }
}

    
    
    
     //metodo para mostrar stock del producto seleccionado
    private void MostrarStock() {
        try {

            Connection cn = Conexion.conectar();
            String sql = "select * from tb_producto where nombre = '" + this.cajaProducto.getSelectedItem() + "'";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                idProducto = rs.getInt("idProducto");
                cantidad = rs.getInt("cantidad");
                cajaStockActual.setText(String.valueOf(cantidad));
            } else {
                cajaStockActual.setText("");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener stock del producto en: " + e);
        }
    }
}
