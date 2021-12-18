package Formularios;

import Clases.ClaseEmpleados;


public class FormPrincipal extends javax.swing.JFrame {

    public FormPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        Nivel();
    }
    
    ClaseEmpleados cls = new ClaseEmpleados();
    
    public void Nivel(){
        if(cls.getNivel() == 2){
            MenuArchivo.setVisible(false);
            MenuConfiguracion.setVisible(false);
            ContentCamarotesN.setVisible(true);
        } else if (cls.getNivel() == 1){
            ContentCamarotesN.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        MenuInicio = new javax.swing.JMenu();
        MenuReserva = new javax.swing.JMenu();
        ContentClientes = new javax.swing.JMenuItem();
        ContentReserva = new javax.swing.JMenuItem();
        ContentCamarotesN = new javax.swing.JMenuItem();
        MenuArchivo = new javax.swing.JMenu();
        ContentCamarotes = new javax.swing.JMenuItem();
        ContentBuques = new javax.swing.JMenuItem();
        ContentDestinos = new javax.swing.JMenuItem();
        ContentSalidas = new javax.swing.JMenuItem();
        ContentViajes = new javax.swing.JMenuItem();
        MenuConfiguracion = new javax.swing.JMenu();
        ContentUsuarios = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(61, 153, 246));
        desktopPane.setToolTipText("Agencia de Cruceros");
        desktopPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        desktopPane.setName("Agencia de Cruceros"); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Crucero-removebg-preview.png"))); // NOI18N
        desktopPane.add(jLabel1);
        jLabel1.setBounds(280, 150, 640, 390);

        menuBar.setToolTipText("Agencia de Cruceros");
        menuBar.setName("Agencia de Cruceros"); // NOI18N

        MenuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ddebb9c351b2c807a285f0d90381672e-icono-de-casa-negro.png"))); // NOI18N
        MenuInicio.setMnemonic('f');
        MenuInicio.setText("Inicio");
        MenuInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuInicioMouseClicked(evt);
            }
        });
        menuBar.add(MenuInicio);

        MenuReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/71b38075981ba4678e841e2b7b0318fa-dibujos-animados-de-papel-l-aacute-piz-by-vexels-2.png"))); // NOI18N
        MenuReserva.setMnemonic('h');
        MenuReserva.setText("Reservas");
        MenuReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        ContentClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContentClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cliente-removebg-preview (2).png"))); // NOI18N
        ContentClientes.setText("Clientes");
        ContentClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContentClientesActionPerformed(evt);
            }
        });
        MenuReserva.add(ContentClientes);

        ContentReserva.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContentReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reservas (1).png"))); // NOI18N
        ContentReserva.setMnemonic('c');
        ContentReserva.setText("Crear Reserva");
        ContentReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContentReservaActionPerformed(evt);
            }
        });
        MenuReserva.add(ContentReserva);

        ContentCamarotesN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContentCamarotesN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Camarote-removebg-preview (1).png"))); // NOI18N
        ContentCamarotesN.setText("Camarotes");
        ContentCamarotesN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContentCamarotesNActionPerformed(evt);
            }
        });
        MenuReserva.add(ContentCamarotesN);

        menuBar.add(MenuReserva);

        MenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/gratis-png-directorio-carpeta-de-archivos-archivo-de-computadora-carpeta-de-dibujos-animados-pintados-a-mano-removebg-preview.png"))); // NOI18N
        MenuArchivo.setMnemonic('e');
        MenuArchivo.setText("Archivo");
        MenuArchivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        ContentCamarotes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContentCamarotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Camarote-removebg-preview (1).png"))); // NOI18N
        ContentCamarotes.setMnemonic('t');
        ContentCamarotes.setText("Camarotes");
        ContentCamarotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContentCamarotesActionPerformed(evt);
            }
        });
        MenuArchivo.add(ContentCamarotes);

        ContentBuques.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContentBuques.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Crucero (1).png"))); // NOI18N
        ContentBuques.setText("Buques");
        ContentBuques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContentBuquesActionPerformed(evt);
            }
        });
        MenuArchivo.add(ContentBuques);

        ContentDestinos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContentDestinos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Itinerario (1).png"))); // NOI18N
        ContentDestinos.setText("Destinos");
        ContentDestinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContentDestinosActionPerformed(evt);
            }
        });
        MenuArchivo.add(ContentDestinos);

        ContentSalidas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContentSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Puerto-removebg-preview (1).png"))); // NOI18N
        ContentSalidas.setText("Salidas");
        ContentSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContentSalidasActionPerformed(evt);
            }
        });
        MenuArchivo.add(ContentSalidas);

        ContentViajes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContentViajes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reservas (1).png"))); // NOI18N
        ContentViajes.setText("Viajes ");
        ContentViajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContentViajesActionPerformed(evt);
            }
        });
        MenuArchivo.add(ContentViajes);

        menuBar.add(MenuArchivo);

        MenuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pngtree-vector-settings-icon-png-image_312584-removebg-preview.png"))); // NOI18N
        MenuConfiguracion.setText("Configuraciones");
        MenuConfiguracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        ContentUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ContentUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Usuario-removebg-preview (1).png"))); // NOI18N
        ContentUsuarios.setText("Usuarios");
        ContentUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContentUsuariosActionPerformed(evt);
            }
        });
        MenuConfiguracion.add(ContentUsuarios);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cliente-removebg-preview (2).png"))); // NOI18N
        jMenuItem1.setText("Empleados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuConfiguracion.add(jMenuItem1);

        menuBar.add(MenuConfiguracion);

        MenuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/png-transparent-computer-icons-login-icon-design-exit-miscellaneous-angle-rectangle-thumbnail-removebg-preview.png"))); // NOI18N
        MenuSalir.setText("Salir");
        MenuSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSalirMouseClicked(evt);
            }
        });
        menuBar.add(MenuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    //MAIN MENU OF NAVIGATION
    private void ContentReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContentReservaActionPerformed
        FormReservaClientes form = new FormReservaClientes();
        form.setVisible(true);
    }//GEN-LAST:event_ContentReservaActionPerformed

    private void ContentClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContentClientesActionPerformed
        FormClientes form = new FormClientes();
        form.setVisible(true);
    }//GEN-LAST:event_ContentClientesActionPerformed

    private void MenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_MenuSalirMouseClicked

    private void MenuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuInicioMouseClicked

    }//GEN-LAST:event_MenuInicioMouseClicked

    private void ContentCamarotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContentCamarotesActionPerformed
        FormCamarotes form = new FormCamarotes();
        form.setVisible(true);
    }//GEN-LAST:event_ContentCamarotesActionPerformed

    private void ContentBuquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContentBuquesActionPerformed
        FormBuques form = new FormBuques();
        form.setVisible(true);
    }//GEN-LAST:event_ContentBuquesActionPerformed

    private void ContentDestinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContentDestinosActionPerformed
        FormDestinos form = new FormDestinos();
        form.setVisible(true);
    }//GEN-LAST:event_ContentDestinosActionPerformed

    private void ContentSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContentSalidasActionPerformed
        FormSalidas form = new FormSalidas();
        form.setVisible(true);
    }//GEN-LAST:event_ContentSalidasActionPerformed

    private void ContentUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContentUsuariosActionPerformed
        FormUsuarios form = new FormUsuarios();
        form.setVisible(true);
    }//GEN-LAST:event_ContentUsuariosActionPerformed

    private void ContentViajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContentViajesActionPerformed
        FormViajes form = new FormViajes();
        form.setVisible(true);
    }//GEN-LAST:event_ContentViajesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FormEmpleados form = new FormEmpleados();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ContentCamarotesNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContentCamarotesNActionPerformed
        FormTablaCamarotes form = new FormTablaCamarotes();
        form.setVisible(true);
    }//GEN-LAST:event_ContentCamarotesNActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ContentBuques;
    private javax.swing.JMenuItem ContentCamarotes;
    private javax.swing.JMenuItem ContentCamarotesN;
    private javax.swing.JMenuItem ContentClientes;
    private javax.swing.JMenuItem ContentDestinos;
    private javax.swing.JMenuItem ContentReserva;
    private javax.swing.JMenuItem ContentSalidas;
    private javax.swing.JMenuItem ContentUsuarios;
    private javax.swing.JMenuItem ContentViajes;
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenu MenuConfiguracion;
    private javax.swing.JMenu MenuInicio;
    private javax.swing.JMenu MenuReserva;
    private javax.swing.JMenu MenuSalir;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
