package vista;

import conexion.Conexion;
import basedatos.TablaProducto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author ediso
 */
public class VistaCapturaProducto extends javax.swing.JInternalFrame {

    int obtenerIdCategoriaCombo = 0;

    public VistaCapturaProducto() {
        initComponents();
        this.setSize(new Dimension(661, 406));
        this.setTitle("Nuevo Producto");

        this.CargarComboCategorias();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        cajaCantidad = new javax.swing.JTextField();
        cajaPrecio = new javax.swing.JTextField();
        cajaDescripcion = new javax.swing.JTextField();
        cajaIva = new javax.swing.JComboBox<>();
        cajaCategoria = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cajaCodigoBarras = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cajaMarca = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cajaContenido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cajaUnidadMedida = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cajaPresentacion = new javax.swing.JComboBox<>();
        jLabel_wallpaper = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        setBackground(new java.awt.Color(255, 255, 204));
        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Unidad Medida: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Presentacion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 110, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripcion:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("IVA:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categorias:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, -1));

        cajaNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaNombreActionPerformed(evt);
            }
        });
        cajaNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaNombreKeyTyped(evt);
            }
        });
        getContentPane().add(cajaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, 30));

        cajaCantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCantidadActionPerformed(evt);
            }
        });
        cajaCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 91, 200, 30));

        cajaPrecio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPrecioActionPerformed(evt);
            }
        });
        cajaPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaPrecioKeyTyped(evt);
            }
        });
        getContentPane().add(cajaPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 200, 30));

        cajaDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaDescripcionActionPerformed(evt);
            }
        });
        cajaDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaDescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(cajaDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 510, 30));

        cajaIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cajaIva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione iva:", "No grava iva", "12%", "14%" }));
        cajaIva.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cajaIvaItemStateChanged(evt);
            }
        });
        getContentPane().add(cajaIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 200, 30));

        cajaCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cajaCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:", "Item 2", "Item 3", "Item 4" }));
        cajaCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cajaCategoriaItemStateChanged(evt);
            }
        });
        cajaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(cajaCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 170, 30));

        btnGuardar.setBackground(new java.awt.Color(153, 255, 153));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 90, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Codigo Barras:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 110, 20));

        cajaCodigoBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCodigoBarrasActionPerformed(evt);
            }
        });
        cajaCodigoBarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCodigoBarrasKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 170, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Contenido: ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, 20));

        cajaMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaMarcaActionPerformed(evt);
            }
        });
        cajaMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaMarcaKeyTyped(evt);
            }
        });
        getContentPane().add(cajaMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Marca: ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, 20));

        cajaContenido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaContenidoActionPerformed(evt);
            }
        });
        cajaContenido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaContenidoKeyTyped(evt);
            }
        });
        getContentPane().add(cajaContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 170, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Cantidad:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 90, -1));

        cajaUnidadMedida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cajaUnidadMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione alguna medida", "Mililitros", "Litros", "Miligramos", "Kilogramos", "Piezas", "Hojas", "Milimetros", "Centimetros", "Metros", "Capsulas" }));
        cajaUnidadMedida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cajaUnidadMedidaItemStateChanged(evt);
            }
        });
        cajaUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaUnidadMedidaActionPerformed(evt);
            }
        });
        cajaUnidadMedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaUnidadMedidaKeyTyped(evt);
            }
        });
        getContentPane().add(cajaUnidadMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 200, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Precio:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 90, 20));

        cajaPresentacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cajaPresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione alguna presentacion", "Lata", "Botella de plastico", "Botella de vidrio", "Frasco de vidrio", "Frasco de plastico", "Caja de carton", "Bolsa", "Bulto", "Cilindro", "Paquete", "Envases flexibles", "Plastico", "Capsulas", "Barra", "Sobre", "Garrafa", "Rollo", "Bote", "Bolsa de nahilo", "Bolsa de carton" }));
        cajaPresentacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cajaPresentacionItemStateChanged(evt);
            }
        });
        cajaPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaPresentacionActionPerformed(evt);
            }
        });
        getContentPane().add(cajaPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 200, 30));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemaDeventas1/src/img/Images/Fondo1.png"))); // NOI18N
        jLabel_wallpaper.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        Producto producto = new Producto();
        TablaProducto controlProducto = new TablaProducto();
        String iva = "";
        String categoria = "";
        iva = cajaIva.getSelectedItem().toString().trim();
        categoria = cajaCategoria.getSelectedItem().toString().trim();

        //validar campos
        if (cajaNombre.getText().equals("") || cajaCantidad.getText().equals("") || cajaPrecio.getText().equals("")
                || cajaCodigoBarras.getText().equals("") || cajaContenido.getText().equals("") || cajaMarca.getText().equals("")
                || cajaDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            cajaNombre.setBackground(Color.red);
            cajaCantidad.setBackground(Color.red);
            cajaPrecio.setBackground(Color.red);
            cajaCodigoBarras.setBackground(Color.red);
            cajaContenido.setBackground(Color.red);
            cajaMarca.setBackground(Color.red);
            cajaDescripcion.setBackground(Color.red);
            cajaPresentacion.setBackground(Color.red);
            cajaCategoria.setBackground(Color.red);
            cajaIva.setBackground(Color.red);
        } else {
            //consulta para ver si el producto ya existe
            if (!controlProducto.existeProducto(cajaNombre.getText().trim())) {
                if (iva.equalsIgnoreCase("Seleccione iva:")) {
                    JOptionPane.showMessageDialog(null, "Seleccione iva.");
                } else {
                    if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                        JOptionPane.showMessageDialog(null, "Seleccione categoria");
                    } else {
                        try {
                            producto.setCodBarras(cajaCodigoBarras.getText().trim());
                            producto.setNombre(cajaNombre.getText().trim());
                            producto.setMarca(cajaMarca.getText().trim());
                            producto.setContenido(cajaContenido.getText().trim());
                            producto.setPresentacion((String) cajaPresentacion.getSelectedItem());
                            producto.setunidadMedida((String) cajaUnidadMedida.getSelectedItem());
                            producto.setCantidad(Integer.parseInt(cajaCantidad.getText().trim()));
                            producto.generarFechaCaducidadAleatoria();
                            String precioTXT = "";
                            double Precio = 0.0;
                            precioTXT = cajaPrecio.getText().trim();
                            boolean aux = false;
                            /*
                            *Si el usuario ingresa , (coma) como punto decimal,
                            lo transformamos a punto (.)
                             */
                            for (int i = 0; i < precioTXT.length(); i++) {
                                if (precioTXT.charAt(i) == ',') {
                                    String precioNuevo = precioTXT.replace(",", ".");
                                    Precio = Double.parseDouble(precioNuevo);
                                    aux = true;
                                }
                            }
                            //evaluar la condicion
                            if (aux == true) {
                                producto.setPrecio(Precio);
                            } else {
                                Precio = Double.parseDouble(precioTXT);
                                producto.setPrecio(Precio);
                            }

                            producto.setDescripcion(cajaDescripcion.getText().trim());

                            //Porcentaje IVA
                            if (iva.equalsIgnoreCase("No grava iva")) {
                                producto.setPorcentajeIva(0);
                            } else if (iva.equalsIgnoreCase("12%")) {
                                producto.setPorcentajeIva(12);
                            } else if (iva.equalsIgnoreCase("14%")) {
                                producto.setPorcentajeIva(14);
                            }

                            //idcategoria - cargar metodo que obtiene el id de categoria
                            this.IdCategoria();
                            producto.setIdCategoria(obtenerIdCategoriaCombo);

                            if (controlProducto.guardar(producto)) {
                                JOptionPane.showMessageDialog(null, "Registro Guardado");
                                cajaNombre.setBackground(Color.green);
                                cajaCantidad.setBackground(Color.green);
                                cajaPrecio.setBackground(Color.green);
                                cajaDescripcion.setBackground(Color.green);
                                cajaCodigoBarras.setBackground(Color.green);
                                cajaContenido.setBackground(Color.green);
                                cajaMarca.setBackground(Color.green);
                                cajaCategoria.setBackground(Color.green);
                                cajaIva.setBackground(Color.green);
                                cajaUnidadMedida.setBackground(Color.green);
                                cajaPresentacion.setBackground(Color.green);

                                this.CargarComboCategorias();
                                this.cajaIva.setSelectedItem("Seleccione iva:");
                                this.Limpiar();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al Guardar");
                            }

                        } catch (HeadlessException | NumberFormatException e) {
                            System.out.println("Error en: " + e);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El producto ya existe en la Base de Datos");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cajaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNombreActionPerformed
        String nombre = cajaNombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el nombre del producto");
        } else {
            cajaNombre.setText(getUpper(nombre));
            cajaMarca.requestFocus();
        }
    }//GEN-LAST:event_cajaNombreActionPerformed

    private void cajaCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCantidadActionPerformed
        String cantidad = cajaCantidad.getText();
        if (cantidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la cantidad del producto");
        } else {
            cajaPresentacion.requestFocus();
        }
    }//GEN-LAST:event_cajaCantidadActionPerformed


    private void cajaCodigoBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCodigoBarrasActionPerformed
        String cod = cajaCodigoBarras.getText();
        if (cod.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el codigo de barras del producto");
        } else {
            cajaNombre.requestFocus();
        }
    }//GEN-LAST:event_cajaCodigoBarrasActionPerformed

    private void cajaContenidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaContenidoActionPerformed
        String contenido = cajaContenido.getText();
        if (contenido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el contenido del producto");
        } else {
            cajaContenido.setText(getUpper(contenido));
            cajaUnidadMedida.requestFocus();
        }
    }//GEN-LAST:event_cajaContenidoActionPerformed

    private void cajaCodigoBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCodigoBarrasKeyTyped
        char[] letra = cajaCodigoBarras.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
        if (letra.length > 12) {
            evt.consume();
            cajaNombre.requestFocus();
        }

    }//GEN-LAST:event_cajaCodigoBarrasKeyTyped

    private void cajaNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNombreKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaNombreKeyTyped

    private void cajaMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaMarcaActionPerformed
        String marca = cajaMarca.getText();
        if (marca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la marca del producto");
        } else {
            cajaMarca.setText(getUpper(marca));
            cajaCategoria.requestFocus();
        }
    }//GEN-LAST:event_cajaMarcaActionPerformed

    private void cajaMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaMarcaKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaMarcaKeyTyped

    private void cajaContenidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaContenidoKeyTyped
        char[] letra = cajaContenido.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaContenidoKeyTyped

    private void cajaUnidadMedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaUnidadMedidaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaUnidadMedidaKeyTyped

    private void cajaUnidadMedidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cajaUnidadMedidaItemStateChanged
        cajaCantidad.requestFocus();
    }//GEN-LAST:event_cajaUnidadMedidaItemStateChanged

    private void cajaUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaUnidadMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaUnidadMedidaActionPerformed

    private void cajaCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCantidadKeyTyped
        char[] letra = cajaContenido.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCantidadKeyTyped

    private void cajaPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaPrecioKeyTyped
        char[] letra = cajaPrecio.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaPrecioKeyTyped

    private void cajaPresentacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cajaPresentacionItemStateChanged
        cajaPrecio.requestFocus();
    }//GEN-LAST:event_cajaPresentacionItemStateChanged

    private void cajaPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPrecioActionPerformed
        String precio = cajaPrecio.getText();
        if (precio.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el precio de la venta del producto");
        } else {
            cajaIva.requestFocus();
        }
    }//GEN-LAST:event_cajaPrecioActionPerformed

    private void cajaDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaDescripcionActionPerformed
        String descripcion = cajaDescripcion.getText();
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la descripcion de la venta del producto");
        } else {
            cajaDescripcion.setText(getUpper(descripcion));
            btnGuardar.setBackground(new Color(255, 0, 255));
            btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_cajaDescripcionActionPerformed

    private void cajaDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaDescripcionKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }

    }//GEN-LAST:event_cajaDescripcionKeyTyped

    private void cajaIvaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cajaIvaItemStateChanged
        cajaDescripcion.requestFocus();
    }//GEN-LAST:event_cajaIvaItemStateChanged

    private void cajaCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cajaCategoriaItemStateChanged
        cajaContenido.requestFocus();
    }//GEN-LAST:event_cajaCategoriaItemStateChanged

    private void cajaPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaPresentacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaPresentacionActionPerformed

    private void cajaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCategoriaActionPerformed

    }//GEN-LAST:event_cajaCategoriaActionPerformed

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField cajaCantidad;
    private javax.swing.JComboBox<String> cajaCategoria;
    private javax.swing.JTextField cajaCodigoBarras;
    private javax.swing.JTextField cajaContenido;
    private javax.swing.JTextField cajaDescripcion;
    private javax.swing.JComboBox<String> cajaIva;
    private javax.swing.JTextField cajaMarca;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaPrecio;
    private javax.swing.JComboBox<String> cajaPresentacion;
    private javax.swing.JComboBox<String> cajaUnidadMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables
     /**
     *
     * Metodo para limpiar campos
     */
    private void Limpiar() {
        cajaNombre.setText("");
        cajaCantidad.setText("");
        cajaPrecio.setText("");
        cajaDescripcion.setText("");
        cajaCodigoBarras.setText("");
        cajaContenido.setText("");
        cajaMarca.setText("");
        cajaUnidadMedida.setSelectedIndex(0);
        cajaIva.setSelectedIndex(0);
        cajaCategoria.setSelectedIndex(0);
        cajaPresentacion.setSelectedIndex(0);
        btnGuardar.setBackground(Color.GREEN);

    }

    /**
     *
     * Metodo para cargar las categorias
     */
    private void CargarComboCategorias() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            cajaCategoria.removeAllItems();
            cajaCategoria.addItem("Seleccione categoria:");
            while (rs.next()) {
                cajaCategoria.addItem(rs.getString("descripcion"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar categorias");
        }
    }

    /**
     *
     * Metodo para obtener id categoria
     */
    private int IdCategoria() {
        String sql = "select * from tb_categoria where descripcion = '" + this.cajaCategoria.getSelectedItem() + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIdCategoriaCombo = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obener id categoria");
        }
        return obtenerIdCategoriaCombo;
    }

    public void setFocus() {
        cajaCodigoBarras.requestFocus();
    }

    public static String getUpper(String mgg) {
        String[] substring = mgg.split(" ");
        int i = 0;
        for (String item : substring) {
            if (item.length() > 2) {
                StringBuilder sb = new StringBuilder(item.trim().toLowerCase());
                sb.setCharAt(0, Character.toUpperCase(item.charAt(0)));
                substring[i] = sb.toString();
            }
            i++;
        }
        String cadenafinal = String.join(" ", substring);
        return cadenafinal;
    }
}
