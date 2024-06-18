package vista;

import conexion.Conexion;
import basedatos.TablaCliente;
import basedatos.TablaUsuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import modelo.Cliente;
import modelo.Usuario;

/**
 *
 * @author Ernesto y Emmanuel
 */
public class VistaGestionarUsuario extends javax.swing.JInternalFrame {

    private int idUsuario = 0;

    public VistaGestionarUsuario() {
        initComponents();
        this.setSize(new Dimension(1200, 500));
        this.setTitle("Gestionar Usuarios");
        //Cargar tabla
        this.CargarTablaUsuarios();

        //insertar imagen en nuestro JLabel
        ImageIcon wallpaper = new ImageIcon("D:\\Archivos\\Descargas\\SistemaDeventas1\\src\\img\\Images\\FondoGestionVentas.png");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(1180, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cajaNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cajaPassword = new javax.swing.JTextField();
        cajaApellidoPaterno = new javax.swing.JTextField();
        cajaTelefono = new javax.swing.JTextField();
        cajaUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cajaApellidoMaterno = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar Usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable_usuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1000, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1020, 270));

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 90, -1));

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
        jPanel3.add(cajaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Password:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Apellido Materno:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Telefono:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Usuario:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 90, -1));

        cajaPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(cajaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 170, -1));

        cajaApellidoPaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaApellidoPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaApellidoPaternoActionPerformed(evt);
            }
        });
        cajaApellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaApellidoPaternoKeyTyped(evt);
            }
        });
        jPanel3.add(cajaApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 170, -1));

        cajaTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cajaTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaTelefonoKeyTyped(evt);
            }
        });
        jPanel3.add(cajaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 170, -1));

        cajaUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(cajaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Apellido Paterno:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 130, -1));

        cajaApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaApellidoMaternoActionPerformed(evt);
            }
        });
        cajaApellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaApellidoMaternoKeyTyped(evt);
            }
        });
        jPanel3.add(cajaApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 1020, 100));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemaDeventas1/src/img/Images/FondoGestionVentas.png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        Usuario usuario = new Usuario();
        TablaUsuario controlUsuario = new TablaUsuario();

        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Usuario!");
        } else {
            if (cajaNombre.getText().isEmpty() || cajaApellidoPaterno.getText().isEmpty() || cajaApellidoMaterno.getText().isEmpty() || cajaUsuario.getText().isEmpty()
                    || cajaPassword.getText().isEmpty() || cajaTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Completa todos los campos!");

            } else {
                usuario.setNombre(cajaNombre.getText().trim());
                usuario.setApellidoPaterno(cajaApellidoPaterno.getText().trim());
                usuario.setApellidoMaterno(cajaApellidoMaterno.getText().trim());
                usuario.setUsuario(cajaUsuario.getText().trim());
                usuario.setPassword(cajaPassword.getText().trim());
                usuario.setTelefono(cajaTelefono.getText().trim());
                
                if(controlUsuario.actualizar(usuario, idUsuario)){
                    JOptionPane.showMessageDialog(null, "¡Actualizacion Exitosa!");
                    this.Limpiar();
                    this.CargarTablaUsuarios();
                    idUsuario = 0;
                    
                }else{
                    JOptionPane.showMessageDialog(null, "¡Error al Actualizar usuario!");
                }
            }
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed

        TablaUsuario controlUsuario = new TablaUsuario();
        if (idUsuario == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un usuario!");
        } else {
            if (!controlUsuario.eliminar(idUsuario)) {
                JOptionPane.showMessageDialog(null, "¡Usuario Eliminado!");
                this.CargarTablaUsuarios();
                this.Limpiar();
                idUsuario = 0;
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar usuario!");
                this.Limpiar();
            }
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void cajaApellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaApellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaApellidoPaternoActionPerformed

    private void cajaApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaApellidoMaternoActionPerformed

    private void cajaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaNombreActionPerformed

    private void cajaNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaNombreKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaNombreKeyTyped

    private void cajaApellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaApellidoPaternoKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaApellidoPaternoKeyTyped

    private void cajaApellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaApellidoMaternoKeyTyped
        char caracter = evt.getKeyChar();
        if (!(Character.isLetter(caracter) || caracter == KeyEvent.VK_SPACE || caracter == KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaApellidoMaternoKeyTyped

    private void cajaTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaTelefonoKeyTyped
        char[] letra = cajaTelefono.getText().toCharArray();
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
        if (letra.length > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_cajaTelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cajaApellidoMaterno;
    private javax.swing.JTextField cajaApellidoPaterno;
    private javax.swing.JTextField cajaNombre;
    private javax.swing.JTextField cajaPassword;
    private javax.swing.JTextField cajaTelefono;
    private javax.swing.JTextField cajaUsuario;
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_usuarios;
    // End of variables declaration//GEN-END:variables

    /*
     * *****************************************************
     * metodo para limpiar
     * *****************************************************
     */
    private void Limpiar() {
        cajaNombre.setText("");
        cajaPassword.setText("");
        cajaApellidoPaterno.setText("");
        cajaApellidoMaterno.setText("");
        cajaTelefono.setText("");
        cajaUsuario.setText("");
    }


    /*
     * *****************************************************
     * metodo para mostrar todos los clientes registrados
     * *****************************************************
     */
    private void CargarTablaUsuarios() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from tb_usuario";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            VistaGestionarUsuario.jTable_usuarios = new JTable(model);
            VistaGestionarUsuario.jScrollPane1.setViewportView(VistaGestionarUsuario.jTable_usuarios);

            model.addColumn("N°");//ID
            model.addColumn("nombre");
            model.addColumn("apellidoPaterno");
            model.addColumn("apellidoMaterno");
            model.addColumn("usuario");
            model.addColumn("password");
            model.addColumn("telefono");

            while (rs.next()) {
                Object fila[] = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla usuarios: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_usuarios.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idUsuario = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosUsuarioSeleccionado(idUsuario);//metodo
                }
            }
        });
    }


    /*
     * **************************************************
     * Metodo que envia datos seleccionados
     * **************************************************
     */
    private void EnviarDatosUsuarioSeleccionado(int idUsuario) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_usuario where idUsuario = '" + idUsuario + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cajaNombre.setText(rs.getString("nombre"));
                cajaApellidoPaterno.setText(rs.getString("apellidoPaterno"));
                cajaApellidoMaterno.setText(rs.getString("apellidoMaterno"));
                cajaUsuario.setText(rs.getString("usuario"));
                cajaPassword.setText(rs.getString("password"));
                cajaTelefono.setText(rs.getString("telefono"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar usuario: " + e);
        }
    }

}