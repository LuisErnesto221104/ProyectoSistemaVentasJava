package vista;

import java.awt.Dimension;
import conexion.Conexion;
import basedatos.TablaProvedores;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Provedor;
import static vista.VistaCapturaProducto.getUpper;

public class VistaCapturaProvedores extends javax.swing.JInternalFrame {

    public VistaCapturaProvedores() {
        initComponents();
        this.setSize(new Dimension(761, 406));
        this.setTitle("Nuevo Provedor");

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_wallpaper = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cajaRazonSocial = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cajaNumeroCasa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cajaRFC = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cajaCalle = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cajaColonia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cajaEstado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cajaCP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cajaTelefono = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cajaCiudad = new javax.swing.JTextField();
        cajaOrientacion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemaDeventas1/src/img/Images/Fondo1.png"))); // NOI18N
        jLabel_wallpaper.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(255, 255, 51));
        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo Provedor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 3, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Razon Social: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 109, -1));

        cajaRazonSocial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaRazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaRazonSocialActionPerformed(evt);
            }
        });
        cajaRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaRazonSocialKeyTyped(evt);
            }
        });
        getContentPane().add(cajaRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 170, 30));

        btnGuardar.setBackground(new java.awt.Color(0, 255, 51));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 303, 90, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Estado:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 110, 20));

        cajaNumeroCasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaNumeroCasaActionPerformed(evt);
            }
        });
        cajaNumeroCasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaNumeroCasaKeyTyped(evt);
            }
        });
        getContentPane().add(cajaNumeroCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 170, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Calle: ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 123, 20));

        cajaRFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaRFCActionPerformed(evt);
            }
        });
        cajaRFC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaRFCKeyTyped(evt);
            }
        });
        getContentPane().add(cajaRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 167, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Numero Casa:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 123, 20));

        cajaCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCalleActionPerformed(evt);
            }
        });
        cajaCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCalleKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 170, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Orientacion:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 123, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Colonia:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 123, 20));

        cajaColonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaColoniaActionPerformed(evt);
            }
        });
        cajaColonia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaColoniaKeyTyped(evt);
            }
        });
        getContentPane().add(cajaColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 170, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("RFC: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 110, 20));

        cajaEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaEstadoActionPerformed(evt);
            }
        });
        cajaEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaEstadoKeyTyped(evt);
            }
        });
        getContentPane().add(cajaEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 172, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Codigo Postal:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 110, 20));

        cajaCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCPActionPerformed(evt);
            }
        });
        cajaCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCPKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 170, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Telefono: ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 110, 20));

        cajaTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaTelefonoActionPerformed(evt);
            }
        });
        cajaTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaTelefonoKeyTyped(evt);
            }
        });
        getContentPane().add(cajaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 170, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Ciudad:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 123, 20));

        cajaCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCiudadActionPerformed(evt);
            }
        });
        cajaCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaCiudadKeyTyped(evt);
            }
        });
        getContentPane().add(cajaCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 175, -1));

        cajaOrientacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Norte", "Sur ", "Este", "Oeste" }));
        cajaOrientacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cajaOrientacionItemStateChanged(evt);
            }
        });
        getContentPane().add(cajaOrientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 170, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Images/FondoGestionVentas.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 778, 370));

        setBounds(0, 0, 790, 418);
    }// </editor-fold>//GEN-END:initComponents

    private void cajaRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaRazonSocialActionPerformed
        String razonsocial = cajaRazonSocial.getText();
        if (razonsocial.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la razon social del provedor");
        } else {
            cajaRazonSocial.setText(getUpper(razonsocial));
            cajaNumeroCasa.requestFocus();
        }
    }//GEN-LAST:event_cajaRazonSocialActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        Provedor provedor = new Provedor();
        TablaProvedores controlProvedor = new TablaProvedores();

        //validar campos
        if (cajaRazonSocial.getText().equals("") || cajaRFC.getText().equals("") || cajaColonia.getText().equals("")
                || cajaCP.getText().equals("") || cajaCalle.getText().equals("") || cajaNumeroCasa.getText().equals("")
                || cajaTelefono.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            cajaRazonSocial.setBackground(Color.red);
            cajaRFC.setBackground(Color.red);
            cajaCP.setBackground(Color.red);
            cajaCalle.setBackground(Color.red);
            cajaColonia.setBackground(Color.red);
            cajaNumeroCasa.setBackground(Color.red);
            cajaOrientacion.setBackground(Color.red);
            cajaTelefono.setBackground(Color.red);

        } else {
            if (!controlProvedor.existeProvedor(cajaRazonSocial.getText().trim())) {
                try {
                    provedor.setRFC(cajaRFC.getText().trim());
                    provedor.setRazonSocial(cajaRazonSocial.getText().trim());
                    provedor.setNumcasa(Integer.parseInt(cajaNumeroCasa.getText().trim()));
                    provedor.setCalle((String) cajaCalle.getText().trim());
                    provedor.setOrientacion(cajaOrientacion.getSelectedItem().toString());
                    provedor.setColonia((String) cajaColonia.getText().trim());
                    provedor.setCiudad(cajaCiudad.getText().trim());
                    provedor.setEstadoo(cajaEstado.getText().trim());
                    provedor.setCP(cajaCP.getText().trim());
                    provedor.setTelefono(cajaTelefono.getText().trim());

                    if (controlProvedor.guardar(provedor)) {
                        JOptionPane.showMessageDialog(null, "Registro Guardado");
                        cajaRazonSocial.setBackground(Color.green);
                        cajaRFC.setBackground(Color.green);
                        cajaNumeroCasa.setBackground(Color.green);
                        cajaCalle.setBackground(Color.green);
                        cajaOrientacion.setBackground(Color.green);
                        cajaColonia.setBackground(Color.green);
                        cajaCiudad.setBackground(Color.green);
                        cajaEstado.setBackground(Color.green);
                        cajaCP.setBackground(Color.green);
                        cajaTelefono.setBackground(Color.green);
                        cajaRFC.requestFocus();

                        this.Limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Guardar");
                    }

                } catch (HeadlessException | NumberFormatException e) {
                    System.out.println("Error en: " + e);
                }

            } else {
                JOptionPane.showMessageDialog(null, "El provedor ya existe en la Base de Datos");
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cajaCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCalleActionPerformed
        String calle = cajaCalle.getText();
        if (calle.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el calle del provor");
        } else {
            cajaCalle.setText(getUpper(calle));
            cajaOrientacion.requestFocus();
        }
    }//GEN-LAST:event_cajaCalleActionPerformed

    private void cajaRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaRFCActionPerformed
        String rfc = cajaRFC.getText();
        if (rfc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el rfc del provor");
        } else {
            cajaRFC.setText(convertirLetrasAMayusculas(rfc));
            cajaRazonSocial.requestFocus();
        }
    }//GEN-LAST:event_cajaRFCActionPerformed

    private void cajaRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaRazonSocialKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaRazonSocialKeyTyped

    private void cajaNumeroCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNumeroCasaActionPerformed
        String numcasa = cajaNumeroCasa.getText();
        if (numcasa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el numero del domicilio del provor");
        } else {
            cajaNumeroCasa.setText(getUpper(numcasa));
            cajaCalle.requestFocus();
        }
    }//GEN-LAST:event_cajaNumeroCasaActionPerformed

    private void cajaNumeroCasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNumeroCasaKeyTyped
        char[] letra = cajaNumeroCasa.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
        if (letra.length > 4) {
            evt.consume();
            cajaCalle.requestFocus();
        } else {

        }
    }//GEN-LAST:event_cajaNumeroCasaKeyTyped

    private void cajaCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCalleKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCalleKeyTyped

    private void cajaOrientacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cajaOrientacionItemStateChanged
        cajaColonia.requestFocus();
    }//GEN-LAST:event_cajaOrientacionItemStateChanged

    private void cajaColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaColoniaActionPerformed
        String colonia = cajaColonia.getText();
        if (colonia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la colonia del provor");
        } else {
            cajaColonia.setText(getUpper(colonia));
            cajaCiudad.requestFocus();
        }
    }//GEN-LAST:event_cajaColoniaActionPerformed

    private void cajaColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaColoniaKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaColoniaKeyTyped

    private void cajaCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCiudadActionPerformed
        String ciudad = cajaCiudad.getText();
        if (ciudad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la ciudad del provor");
        } else {
            cajaCiudad.setText(getUpper(ciudad));
            cajaEstado.requestFocus();
        }
    }//GEN-LAST:event_cajaCiudadActionPerformed

    private void cajaCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCiudadKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCiudadKeyTyped

    private void cajaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaEstadoActionPerformed
        String estado = cajaEstado.getText();
        if (estado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el estado del provor");
        } else {
            cajaEstado.setText(getUpper(estado));
            cajaCP.requestFocus();
        }
    }//GEN-LAST:event_cajaEstadoActionPerformed

    private void cajaCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCPActionPerformed
        String cp = cajaCP.getText();
        if (cp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el codigo postal del provor");
        } else {
            cajaCP.setText(getUpper(cp));
            cajaTelefono.requestFocus();
        }
    }//GEN-LAST:event_cajaCPActionPerformed

    private void cajaCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCPKeyTyped
        char[] letra = cajaCP.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
        if (letra.length > 4) {
            evt.consume();
            cajaTelefono.requestFocus();
        } else {

        }
    }//GEN-LAST:event_cajaCPKeyTyped

    private void cajaTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaTelefonoActionPerformed
        String telefono = cajaTelefono.getText();
        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el telefono del provor");
        } else {
            cajaTelefono.setText(getUpper(telefono));
            btnGuardar.setBackground(new Color(255, 0, 255));
            btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_cajaTelefonoActionPerformed

    private void cajaTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTelefonoKeyTyped
        char[] letra = cajaTelefono.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
        if (letra.length > 9) {
            evt.consume();
            btnGuardar.setBackground(new Color(255, 0, 255));
            btnGuardar.requestFocus();
        } else {

        }
    }//GEN-LAST:event_cajaTelefonoKeyTyped

    private void cajaEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaEstadoKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaEstadoKeyTyped

    private void cajaRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaRFCKeyTyped
        char[] letra = cajaRFC.getText().toCharArray();
        if (letra.length > 12) {
            evt.consume();
            cajaRazonSocial.requestFocus();
        } else {

        }
    }//GEN-LAST:event_cajaRFCKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField cajaCP;
    private javax.swing.JTextField cajaCalle;
    private javax.swing.JTextField cajaCiudad;
    private javax.swing.JTextField cajaColonia;
    private javax.swing.JTextField cajaEstado;
    private javax.swing.JTextField cajaNumeroCasa;
    private javax.swing.JComboBox<String> cajaOrientacion;
    private javax.swing.JTextField cajaRFC;
    private javax.swing.JTextField cajaRazonSocial;
    private javax.swing.JTextField cajaTelefono;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        cajaRFC.setText("");
        cajaRazonSocial.setText("");
        cajaNumeroCasa.setText("");
        cajaCalle.setText("");
        cajaColonia.setText("");
        cajaOrientacion.setSelectedIndex(0);
        cajaCiudad.setText("");
        cajaEstado.setText("");
        cajaCP.setText("");
        cajaTelefono.setText("");
        cajaRFC.requestFocus();

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

    public static String convertirLetrasAMayusculas(String cajaRFC) {
        if (cajaRFC == null || cajaRFC.isEmpty()) {
            return cajaRFC;
        }

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < cajaRFC.length(); i++) {
            char c = cajaRFC.charAt(i);
            if (Character.isLetter(c)) {
                resultado.append(Character.toUpperCase(c));
            } else {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }
}
