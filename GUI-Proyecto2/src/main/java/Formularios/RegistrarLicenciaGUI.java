package Formularios;

import Control.ControlLicencia;

import DTOss.Persona;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.ConexionBD;

/**
 * El
 *
 * @author jesus
 */
public class RegistrarLicenciaGUI extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarLicenciaGUI
     */
    public RegistrarLicenciaGUI() {
        initComponents();
         setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Evitar cierre con el botón "X"
        setResizable(false); // Desactivar la capacidad de cambiar el tamaño del JFrame
        
    }

    public void Registro() {
        String RFC = this.tfRFC.getText();
        int vigencia = this.cbVigencia.getSelectedIndex();
        String tipo = (String) this.cbTipo.getSelectedItem();

        // Obtiene el texto del JTextArea
        String montoText = this.taCosto.getText();
        if (montoText.trim().isEmpty()) {
            // Mostrar advertencia
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el monto antes de registrar la licencia.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método sin realizar el registro
        }

        // Intenta convertir el texto en un BigDecimal
        BigDecimal monto = null;
        try {
            monto = new BigDecimal(montoText);
        } catch (NumberFormatException e) {
            // Si el texto no se puede convertir, muestra un mensaje de error
            System.err.println("Error: el monto ingresado no es válido");
            return; // Sale del método para evitar más procesamiento
        }
        if (montoText.trim().isEmpty()) {
            // Mostrar advertencia
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el monto antes de registrar la licencia.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método sin realizar el registro
        }

        ControlLicencia cl = new ControlLicencia();

        boolean exiterfc = cl.ValidarLicencia(RFC);

        if (exiterfc) {
            
            cl.RegistrarLicencia(RFC, vigencia, tipo, monto);
            System.out.println("Licencia Registrada");
            JOptionPane.showMessageDialog(this, "La licencia ha sido registrada correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } else {
            System.out.println("Licencia NO REGISTRADA");
        }

    }

    private void limpiarCampos() {
        // Limpiar los campos estableciendo su texto en blanco o en sus valores predeterminados
        tfRFC.setText("");
        cbVigencia.setSelectedIndex(0); // Establecer la primera opción seleccionada
        cbTipo.setSelectedIndex(0); // Establecer la primera opción seleccionada
        taCosto.setText("");
    }
    public void mostrarDatosLicencia() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Número de Licencia");
        modelo.addColumn("Vigencia");
        modelo.addColumn("Monto");
        modelo.addColumn("Tipo");
        modelo.addColumn("RFC");

        String sql = "SELECT * FROM Licencia";

        try (Connection connection = ConexionBD.obtenerConexion();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Object[] fila = new Object[5];
                fila[0] = resultSet.getInt("numero_Licencia");
                fila[1] = resultSet.getInt("Vigencia");
                fila[2] = resultSet.getBigDecimal("Monto");
                fila[3] = resultSet.getString("Tipo");
                fila[4] = resultSet.getString("RFC");
                modelo.addRow(fila);
            }

            jTableLicencia.setModel(modelo); // jTableLicencia es el nombre de tu JTable

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la tabla Licencia: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void calcularCosto() {
        int vigenciaIndex = this.cbVigencia.getSelectedIndex();
        String tipo = (String) this.cbTipo.getSelectedItem();

        int costo = 0;
        int costoNormal = 0;
        int costoDiscapacitado = 0;

        switch (vigenciaIndex) {
            case 0: // 1 Año
                costoNormal = 600;
                costoDiscapacitado = 200;
                break;
            case 1: // 2 Años
                costoNormal = 900;
                costoDiscapacitado = 500;
                break;
            case 2: // 3 Años
                costoNormal = 1100;
                costoDiscapacitado = 700;
                break;
            default:
                break;
        }

        if (tipo.equals("Normal")) {
            costo = costoNormal;
        } else if (tipo.equals("Discapacitado")) {
            costo = costoDiscapacitado;
        }

        // Mostrar el costo en el JTextArea taCosto
        taCosto.setText(String.valueOf(costo));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfRFC = new javax.swing.JTextField();
        cbVigencia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        taCosto = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLicencia = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Registrar Licencia");
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N

        jLabel1.setText("Datos del cliente");
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        tfRFC.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tfRFC.setText("RFC");

        cbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cbVigencia.setName(""); // NOI18N
        cbVigencia.setToolTipText("");

        jLabel2.setText("Tipo");
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel4.setText("Vigencia");
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Discapacitado" }));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        taCosto.setColumns(20);
        taCosto.setRows(3);
        taCosto.setAutoscrolls(false);
        taCosto.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        taCosto.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(taCosto);

        jLabel5.setText("Costo");
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N

        btnCancelar.setText("Volver");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jTableLicencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Num.Licencia", "Vigencia", "Monto", "Tipo", "RFC"
            }
        ));
        jScrollPane2.setViewportView(jTableLicencia);

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setText("Actualizar Tabla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(cbVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel3)))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfRFC, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(13, 13, 13)
                                .addComponent(cbVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(cbTipo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        Registro();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        calcularCosto();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mostrarDatosLicencia();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbVigencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableLicencia;
    private javax.swing.JTextArea taCosto;
    private javax.swing.JTextField tfRFC;
    // End of variables declaration//GEN-END:variables
}
