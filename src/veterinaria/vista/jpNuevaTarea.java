/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.vista;

import Conexion.Conexion;
import entidades.AreasLaborales;
import entidades.Periodicidad;
import entidades.Personal;
import entidades.Tarea;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import veterinaria.negocio.TareaNegocio;

/**
 *
 * @author felipe
 */
public class jpNuevaTarea extends javax.swing.JPanel {

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    boolean editar;
    Tarea tarea = new Tarea();

    /**
     * Creates new form jpNuevaTarea
     */
    public jpNuevaTarea() {
        initComponents();
        llenarAreaLaboral();
        llenarPeriodicidad();
    }

    public jpNuevaTarea(Tarea t) {
        initComponents();
        llenarAreaLaboral();
        llenarPeriodicidad();
        this.editar = true;
        tarea.setId(t.getId());

        txtNombre.setText(t.getNombre());
        txtNombre.setEnabled(false);

        cbxArea.setSelectedIndex(t.getIdAreasLaborales());
        cbxPeriodicidad.setSelectedIndex(t.getIdPeriodicidad());
        cbxArea.setEnabled(false);

//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss");
//        Date hora = sdf.parse(t.getHora());
//        jSpinner1.setValue(hora);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jblDocumento1 = new javax.swing.JLabel();
        cbxArea = new javax.swing.JComboBox<>();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        jSpinner1 = new javax.swing.JSpinner(sm);
        jblDocumento4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        chkRequiereHora = new javax.swing.JCheckBox();
        jblDocumento5 = new javax.swing.JLabel();
        cbxPeriodicidad = new javax.swing.JComboBox<>();
        jblDocumento6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNombrePropertyChange(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jblDocumento1.setBackground(new java.awt.Color(51, 51, 255));
        jblDocumento1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jblDocumento1.setForeground(new java.awt.Color(51, 51, 255));
        jblDocumento1.setText("Nombre:");

        cbxArea.setBackground(new java.awt.Color(255, 255, 255));
        cbxArea.setForeground(new java.awt.Color(0, 0, 0));
        cbxArea.setBorder(null);
        cbxArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAreaActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "HH:mm:ss");
        jSpinner1.setEditor(de);
        jSpinner1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jblDocumento4.setBackground(new java.awt.Color(51, 51, 255));
        jblDocumento4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jblDocumento4.setForeground(new java.awt.Color(51, 51, 255));
        jblDocumento4.setText("Hora realizacion de la tarea:");

        btnGuardar.setBackground(new java.awt.Color(51, 51, 255));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        chkRequiereHora.setBackground(new java.awt.Color(255, 255, 255));
        chkRequiereHora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        chkRequiereHora.setForeground(new java.awt.Color(51, 51, 255));
        chkRequiereHora.setText("Requiere hora de realizacion");
        chkRequiereHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRequiereHoraActionPerformed(evt);
            }
        });

        jblDocumento5.setBackground(new java.awt.Color(51, 51, 255));
        jblDocumento5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jblDocumento5.setForeground(new java.awt.Color(51, 51, 255));
        jblDocumento5.setText("Area:");

        cbxPeriodicidad.setBackground(new java.awt.Color(255, 255, 255));
        cbxPeriodicidad.setForeground(new java.awt.Color(0, 0, 0));
        cbxPeriodicidad.setBorder(null);
        cbxPeriodicidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPeriodicidadActionPerformed(evt);
            }
        });

        jblDocumento6.setBackground(new java.awt.Color(51, 51, 255));
        jblDocumento6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jblDocumento6.setForeground(new java.awt.Color(51, 51, 255));
        jblDocumento6.setText("Periodicidad:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkRequiereHora)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jblDocumento4, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jblDocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jblDocumento6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                    .addComponent(jblDocumento5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(145, 145, 145))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(cbxPeriodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblDocumento1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblDocumento5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPeriodicidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jblDocumento6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jblDocumento4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(chkRequiereHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombrePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNombrePropertyChange

    }//GEN-LAST:event_txtNombrePropertyChange

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased

    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

    }//GEN-LAST:event_txtNombreKeyTyped

    private void cbxAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAreaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        boolean error = false;
        // nombre
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio", "Error", JOptionPane.WARNING_MESSAGE);
            error = true;
        } else {
            tarea.setNombre(txtNombre.getText());
        }

        // Area
        if (cbxArea.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "El campo area no puede esta vacio", "Error", JOptionPane.WARNING_MESSAGE);
            error = true;
            return;
        } else {
            tarea.setIdAreasLaborales(cbxArea.getSelectedIndex());
        }

        // Periodicidad
        if (cbxPeriodicidad.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "El campo periodicidad no puede esta vacio", "Error", JOptionPane.WARNING_MESSAGE);
            error = true;
            return;
        } else {
            tarea.setIdPeriodicidad(cbxPeriodicidad.getSelectedIndex());
        }

        // valida si se necesita la hora
        if (chkRequiereHora.isSelected()) {
            SimpleDateFormat fhora = new SimpleDateFormat("HH:mm");
            String strhora = fhora.format(jSpinner1.getValue());
            tarea.setHora(strhora);
        }

        if (error == false) {
            TareaNegocio t = new TareaNegocio();
            if (editar) {
                t.editarTarea(tarea);
            } else {
                t.crearTarea(tarea);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void llenarAreaLaboral() {
        String SQL_SELECT = "SELECT id,nombre FROM areasLaborales";
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT);
            cbxArea.removeAllItems();
            cbxArea.addItem(new AreasLaborales(0, "Areas laborales"));
            while (rs.next()) {
                cbxArea.addItem(new AreasLaborales(rs.getInt("id"), rs.getString("nombre")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(conn);
        }
    }

    private void llenarPeriodicidad() {
        String SQL_SELECT = "SELECT id,periodicidad FROM periodicidad";
        try {
            conn = Conexion.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_SELECT);
            cbxPeriodicidad.removeAllItems();
            cbxPeriodicidad.addItem(new Periodicidad(0, "Periodicidad"));
            while (rs.next()) {
                cbxPeriodicidad.addItem(new Periodicidad(rs.getInt("id"), rs.getString("periodicidad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(conn);
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        TareaNegocio pn = new TareaNegocio();
        pn.menuTareas();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void chkRequiereHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRequiereHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkRequiereHoraActionPerformed

    private void cbxPeriodicidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPeriodicidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPeriodicidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<AreasLaborales> cbxArea;
    private javax.swing.JComboBox<Periodicidad> cbxPeriodicidad;
    private javax.swing.JCheckBox chkRequiereHora;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel jblDocumento1;
    private javax.swing.JLabel jblDocumento4;
    private javax.swing.JLabel jblDocumento5;
    private javax.swing.JLabel jblDocumento6;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
