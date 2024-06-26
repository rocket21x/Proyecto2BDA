package Formularios;

/**
 *
 * @author jesus
 */
public class MenuGUI extends javax.swing.JFrame {

    /**
     * Creates new form MenuGUI
     */
    public MenuGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        btnRegistrarPersona = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        menuItemRegistrarLicencia = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        MenuAsignarPlacas = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        menuRegistrarAuto = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        jMenuModulo = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegistrarPersona.setText("Registrar Persona");
        btnRegistrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPersonaActionPerformed(evt);
            }
        });
        desktopPane.add(btnRegistrarPersona);
        btnRegistrarPersona.setBounds(100, 160, 150, 23);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Licencias");
        fileMenu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        fileMenu.setPreferredSize(new java.awt.Dimension(150, 50));

        menuItemRegistrarLicencia.setMnemonic('o');
        menuItemRegistrarLicencia.setText("Registrar licencia");
        menuItemRegistrarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRegistrarLicenciaActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemRegistrarLicencia);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Placas");
        editMenu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        editMenu.setPreferredSize(new java.awt.Dimension(150, 50));

        MenuAsignarPlacas.setMnemonic('t');
        MenuAsignarPlacas.setText("Asignar Placas");
        MenuAsignarPlacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAsignarPlacasActionPerformed(evt);
            }
        });
        editMenu.add(MenuAsignarPlacas);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Automoviles");
        helpMenu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        helpMenu.setPreferredSize(new java.awt.Dimension(150, 50));

        menuRegistrarAuto.setMnemonic('c');
        menuRegistrarAuto.setText("Registrar Automovil");
        menuRegistrarAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrarAutoActionPerformed(evt);
            }
        });
        helpMenu.add(menuRegistrarAuto);

        menuBar.add(helpMenu);

        menuConsultas.setText("Consultas");
        menuConsultas.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        menuConsultas.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuModulo.setText("Modulo de consultas");
        jMenuModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuModuloActionPerformed(evt);
            }
        });
        menuConsultas.add(jMenuModulo);

        menuBar.add(menuConsultas);

        jMenu4.setText("Reportes");
        jMenu4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));
        menuBar.add(jMenu4);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemRegistrarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRegistrarLicenciaActionPerformed
        // TODO add your handling code here:
        RegistrarLicenciaGUI rl = new RegistrarLicenciaGUI();
        rl.setVisible(true);
    }//GEN-LAST:event_menuItemRegistrarLicenciaActionPerformed

    private void btnRegistrarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPersonaActionPerformed
        RegistrarPersonaGUI rp = new RegistrarPersonaGUI();
        rp.setVisible(true);
    }//GEN-LAST:event_btnRegistrarPersonaActionPerformed

    private void jMenuModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuModuloActionPerformed

    private void MenuAsignarPlacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAsignarPlacasActionPerformed
        AsignarPlacasGUI ap = new AsignarPlacasGUI();
        ap.setVisible(true);
    }//GEN-LAST:event_MenuAsignarPlacasActionPerformed

    private void menuRegistrarAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrarAutoActionPerformed
        AsignarAutomovilGUI ra = new AsignarAutomovilGUI();
        ra.setVisible(true);
    }//GEN-LAST:event_menuRegistrarAutoActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MenuGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuAsignarPlacas;
    private javax.swing.JButton btnRegistrarPersona;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuModulo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConsultas;
    private javax.swing.JMenuItem menuItemRegistrarLicencia;
    private javax.swing.JMenuItem menuRegistrarAuto;
    // End of variables declaration//GEN-END:variables

}
