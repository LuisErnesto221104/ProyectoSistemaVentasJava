package vista;

import basedatos.TablaProvedores;
import conexion.Conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Provedor;
import static vista.VistaCapturaProvedores.getUpper;
import static vista.VistaGestionarProducto.jTable_productos;

/**
 *
 * @author ernes
 */
public class VistaGestionarProvedor extends javax.swing.JInternalFrame {

    private int idProvedor;

    public VistaGestionarProvedor() {
        initComponents();
        this.setSize(new Dimension(1200, 550));
        this.setTitle("Gestionar Provedores");
        this.CargarTablaProvedores();

        // ImageIcon wallpaper = new ImageIcon("D:\\Archivos\\Descargas\\SistemaDeventas1\\src\\img\\Images\\Fondo1.png");
        //Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(1200, 600, WIDTH));
        //jLabel_wallpaper.setIcon(icono);
        // this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_provedor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cajaRazonSocial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cajaColonia = new javax.swing.JTextField();
        cajaEstado = new javax.swing.JTextField();
        cajaCiudad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cajaRFC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cajaNumeroCasa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cajaCalle = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cajaOrientacion = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cajaCP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cajaTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 0));
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar Provedores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 235, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.CardLayout());

        jTable_provedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "RFC", "RazonSocial", "NumCasa", "Tipo", "orientacion", "colonia", "ciudad", "estado", "cp", "telefono"
            }
        ));
        jScrollPane1.setViewportView(jTable_provedor);

        jPanel1.add(jScrollPane1, "card2");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1030, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 90, 130, 76));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Razon Social: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 110, 20));

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
        jPanel3.add(cajaRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Colonia");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Estado:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 90, -1));

        cajaColonia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel3.add(cajaColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 180, -1));

        cajaEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel3.add(cajaEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 180, -1));

        cajaCiudad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel3.add(cajaCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 170, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("RFC: ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, -1));

        cajaRFC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel3.add(cajaRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Numero Casa:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 110, -1));

        cajaNumeroCasa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel3.add(cajaNumeroCasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 170, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Calle");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 90, -1));

        cajaCalle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel3.add(cajaCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 180, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Orientacion");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 120, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Ciudad:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 90, -1));

        cajaOrientacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la Orientacion", "Norte", "Sur ", "Este ", "Oeste ", " " }));
        jPanel3.add(cajaOrientacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Codigo Postal: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 110, 20));

        cajaCP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel3.add(cajaCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 180, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Telefono");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 90, -1));

        cajaTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel3.add(cajaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 180, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 386, 1030, 130));

        jLabel10.setBackground(new java.awt.Color(255, 255, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemaDeventas1/src/img/Images/FondoGestionVentas.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed

        Provedor provedores = new Provedor();
        TablaProvedores controlProvedor = new TablaProvedores();

        //validar campos
        if (cajaRazonSocial.getText().isEmpty() || cajaColonia.getText().isEmpty() || cajaEstado.getText().isEmpty()
                || cajaRFC.getText().isEmpty() || cajaNumeroCasa.getText().isEmpty()
                || cajaCalle.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            try {
                provedores.setRazonSocial(cajaRazonSocial.getText().trim());
                provedores.setRFC(cajaRFC.getText().trim());
                provedores.setNumcasa(Integer.parseInt(cajaNumeroCasa.getText().trim()));
                provedores.setCalle(cajaCalle.getText().trim());
                provedores.setColonia(cajaColonia.getText());
                provedores.setOrientacion((String) cajaOrientacion.getSelectedItem());
                provedores.setCiudad(cajaCiudad.getText().trim());
                provedores.setEstadoo(cajaEstado.getText().trim());
                provedores.setCP(cajaCP.getText().trim());
                provedores.setTelefono(cajaTelefono.getText().trim());

                if (controlProvedor.actualizar(provedores, idProvedor)) {
                    JOptionPane.showMessageDialog(null, "¡Datos del provedor actualizados!");
                    this.CargarTablaProvedores();
                    this.Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al actualizar!");
                }

            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error en: " + e);
            }

        }

    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        TablaProvedores controlProvedores = new TablaProvedores();
        if (idProvedor == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Provedor!");
        } else {
            if (!controlProvedores.eliminar(idProvedor)) {
                JOptionPane.showMessageDialog(null, "¡provedor Eliminado!");
                this.CargarTablaProvedores();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar provedor!");
            }
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void cajaCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCPActionPerformed
        String cp = cajaCP.getText();
        if (cp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el codigo postal del provor");
        } else {
            cajaCP.setText(getUpper(cp));
        }
    }//GEN-LAST:event_cajaCPActionPerformed

    private void cajaTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaTelefonoActionPerformed
        String telefono = cajaTelefono.getText();
        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el telefono del provor");
        } else {
            cajaTelefono.setText(getUpper(telefono));
        }
    }//GEN-LAST:event_cajaTelefonoActionPerformed

    private void cajaRFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaRFCActionPerformed
        String rfc = cajaRFC.getText();
        if (rfc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el rfc del provor");
        } else {
            cajaRFC.setText(convertirLetrasAMayusculas(rfc));
            cajaRazonSocial.requestFocus();
        }
    }//GEN-LAST:event_cajaRFCActionPerformed

    private void cajaRFCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaRFCKeyTyped
        char[] letra = cajaRFC.getText().toCharArray();
        if (letra.length > 12) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaRFCKeyTyped

    private void cajaRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaRazonSocialKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaRazonSocialKeyTyped

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

    private void cajaColoniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaColoniaKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaColoniaKeyTyped

    private void cajaCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCiudadKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCiudadKeyTyped

    private void cajaEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaEstadoKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaEstadoKeyTyped

    private void cajaCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaCPKeyTyped
        char[] letra = cajaCP.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
        if (letra.length > 4) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaCPKeyTyped

    private void cajaTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTelefonoKeyTyped
        char[] letra = cajaTelefono.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
        if (letra.length > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaTelefonoKeyTyped

    private void cajaRazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaRazonSocialActionPerformed
        String razonsocial = cajaRazonSocial.getText();
        if (razonsocial.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la razon social del provedor");
        } else {
            cajaRazonSocial.setText(getUpper(razonsocial));
        }
    }//GEN-LAST:event_cajaRazonSocialActionPerformed

    private void cajaNumeroCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNumeroCasaActionPerformed
        String numcasa = cajaNumeroCasa.getText();
        if (numcasa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el numero del domicilio del provor");
        } else {
            cajaNumeroCasa.setText(getUpper(numcasa));
        }
    }//GEN-LAST:event_cajaNumeroCasaActionPerformed

    private void cajaCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCalleActionPerformed
        String calle = cajaCalle.getText();
        if (calle.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el calle del provor");
        } else {
            cajaCalle.setText(getUpper(calle));
        }
    }//GEN-LAST:event_cajaCalleActionPerformed

    private void cajaColoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaColoniaActionPerformed
        String colonia = cajaColonia.getText();
        if (colonia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la colonia del provor");
        } else {
            cajaColonia.setText(getUpper(colonia));
        }
    }//GEN-LAST:event_cajaColoniaActionPerformed

    private void cajaCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCiudadActionPerformed
        String ciudad = cajaCiudad.getText();
        if (ciudad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la ciudad del provor");
        } else {
            cajaCiudad.setText(getUpper(ciudad));
        }
    }//GEN-LAST:event_cajaCiudadActionPerformed

    private void cajaEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaEstadoActionPerformed
        String estado = cajaEstado.getText();
        if (estado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el estado del provor");
        } else {
            cajaEstado.setText(getUpper(estado));
        }
    }//GEN-LAST:event_cajaEstadoActionPerformed

    private void EnviarDatosProvedorSeleccionado(int idProvedor) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_provedor where idprovedor = '" + idProvedor + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cajaRFC.setText(rs.getString("rfc"));
                cajaRazonSocial.setText(rs.getString("razonsocial"));
                cajaNumeroCasa.setText(rs.getString("numcasa"));
                cajaCalle.setText(rs.getString("calle"));
                cajaOrientacion.setSelectedItem(rs.getString("orientacion"));
                cajaColonia.setText(rs.getString("colonia"));
                cajaCiudad.setText(rs.getString("ciudad"));
                cajaEstado.setText(rs.getString("estadoo"));
                cajaCP.setText(rs.getString("cp"));
                cajaTelefono.setText(rs.getString("telefono"));
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar provedor: " + e);
        }
    }

    private void CargarTablaProvedores() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select idprovedor, rfc, razonsocial, numcasa, calle, orientacion, colonia, ciudad, estadoo, cp, telefono from tb_provedor";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            VistaGestionarProvedor.jTable_provedor = new JTable(model);
            VistaGestionarProvedor.jScrollPane1.setViewportView(VistaGestionarProvedor.jTable_provedor);

            model.addColumn("N°");//ID
            model.addColumn("rfc");
            model.addColumn("razonsocial");
            model.addColumn("numcasa");
            model.addColumn("calle");
            model.addColumn("orientacion");
            model.addColumn("colonia");
            model.addColumn("ciudad");
            model.addColumn("estado");
            model.addColumn("cp");
            model.addColumn("telefono");
            //model.addColumn("estado");

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("idprovedor"),
                    rs.getString("rfc"),
                    rs.getString("razonsocial"),
                    rs.getInt("numcasa"),
                    rs.getString("calle"),
                    rs.getString("orientacion"),
                    rs.getString("colonia"),
                    rs.getString("ciudad"),
                    rs.getString("estadoo"),
                    rs.getString("cp"),
                    rs.getString("telefono"),};
                model.addRow(fila);
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla provedores: " + e);
        }
        jTable_provedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_provedor.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idProvedor = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProvedorSeleccionado(idProvedor);//metodo
                }
            }
        });
    }

    private void Limpiar() {
        cajaRFC.setText("");
        cajaRazonSocial.setText("");
        cajaNumeroCasa.setText("");
        cajaCalle.setText("");
        cajaCiudad.setText("");
        cajaCP.setText("");
        cajaColonia.setText("");
        cajaEstado.setText("");
        cajaOrientacion.setSelectedIndex(0);
        cajaTelefono.setText("");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_provedor;
    // End of variables declaration//GEN-END:variables
}
