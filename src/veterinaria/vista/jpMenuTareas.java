/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.vista;

import entidades.AsignacionTareas;
import entidades.Tarea;
import java.util.ArrayList;
import javax.swing.JButton;
import veterinaria.negocio.PersonalNegocio;
import veterinaria.negocio.Tabla;
import veterinaria.negocio.TareaNegocio;
import veterinaria.negocio.TareaObservacionesNegocio;

/**
 *
 * @author felipe
 */
public class jpMenuTareas extends javax.swing.JPanel {

    TareaNegocio tarea = new TareaNegocio();
    Tabla t = new Tabla();
    //  private DefaultTableModel modelTablePersonal;

    /**
     * Creates new form jpMenuTareas
     */
    public jpMenuTareas() {
        initComponents();
        String andQuery = "WHERE finalizada = 0";
        ArrayList<AsignacionTareas> tareasLista = tarea.listaTareasAsignadas(andQuery);
        String titulo[] = {"id", "Tarea", "Personal", "Fecha asignacion", "Finalizada", ""};
        t.verTable(jTableTareas, llenarTabla(tareasLista), titulo);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JLnuevo = new javax.swing.JLabel();
        JLeditar = new javax.swing.JLabel();
        JLActivarDesactivar = new javax.swing.JLabel();
        JLasignar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTareas = new javax.swing.JTable();
        btnFinalizadas = new javax.swing.JButton();
        btnPendiente = new javax.swing.JButton();
        btnTareas = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        JLnuevo.setBackground(new java.awt.Color(204, 204, 204));
        JLnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-add-new-24.png"))); // NOI18N
        JLnuevo.setText("Nuevo");
        JLnuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        JLnuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLnuevoMouseClicked(evt);
            }
        });

        JLeditar.setBackground(new java.awt.Color(204, 204, 204));
        JLeditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-pencil-24.png"))); // NOI18N
        JLeditar.setText("Editar");
        JLeditar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        JLeditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLeditarMouseClicked(evt);
            }
        });

        JLActivarDesactivar.setBackground(new java.awt.Color(204, 204, 204));
        JLActivarDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-natural-user-interface-2-24.png"))); // NOI18N
        JLActivarDesactivar.setText("Activar/Desactivar");
        JLActivarDesactivar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        JLActivarDesactivar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLActivarDesactivarMouseClicked(evt);
            }
        });

        JLasignar.setBackground(new java.awt.Color(204, 204, 204));
        JLasignar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-add-new-24.png"))); // NOI18N
        JLasignar.setText("Asignar tarea");
        JLasignar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        JLasignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JLasignarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLActivarDesactivar, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(JLeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLasignar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(JLnuevo)
                .addGap(18, 18, 18)
                .addComponent(JLeditar)
                .addGap(18, 18, 18)
                .addComponent(JLActivarDesactivar)
                .addGap(18, 18, 18)
                .addComponent(JLasignar)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 330));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tareas"));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jTableTareas.setBackground(new java.awt.Color(255, 255, 255));
        jTableTareas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTareasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTareas);

        btnFinalizadas.setBackground(new java.awt.Color(255, 255, 255));
        btnFinalizadas.setForeground(new java.awt.Color(51, 51, 255));
        btnFinalizadas.setText("Finalizadas");
        btnFinalizadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFinalizadasMouseClicked(evt);
            }
        });

        btnPendiente.setBackground(new java.awt.Color(255, 255, 255));
        btnPendiente.setForeground(new java.awt.Color(51, 51, 255));
        btnPendiente.setText("Pendientes");
        btnPendiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPendienteMouseClicked(evt);
            }
        });
        btnPendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendienteActionPerformed(evt);
            }
        });

        btnTareas.setBackground(new java.awt.Color(255, 255, 255));
        btnTareas.setForeground(new java.awt.Color(51, 51, 255));
        btnTareas.setText("Tareas");
        btnTareas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTareasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnPendiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFinalizadas)
                        .addGap(18, 18, 18)
                        .addComponent(btnTareas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPendiente)
                    .addComponent(btnFinalizadas)
                    .addComponent(btnTareas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 810, 550));

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

    private void JLnuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLnuevoMouseClicked
        tarea.nuevaTarea();
    }//GEN-LAST:event_JLnuevoMouseClicked

    private void JLeditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLeditarMouseClicked
        tarea.editarTarea();
    }//GEN-LAST:event_JLeditarMouseClicked

    private void JLActivarDesactivarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLActivarDesactivarMouseClicked
        tarea.activarDesactivar();
    }//GEN-LAST:event_JLActivarDesactivarMouseClicked

    private void jTableTareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTareasMouseClicked
        int column = jTableTareas.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jTableTareas.getRowHeight();
        if (row < jTableTareas.getRowCount() && row >= 0 && column < jTableTareas.getColumnCount() && column >= 0) {
            Object value = jTableTareas.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                if (boton.getName().equals("Finalizar")) {
                    String idTarea = String.valueOf(jTableTareas.getValueAt(jTableTareas.getSelectedRow(), 0));
                    tarea.terminarTarea(idTarea);
                }
                if (boton.getName().equals("Ver")) {
                    String idTarea = String.valueOf(jTableTareas.getValueAt(jTableTareas.getSelectedRow(), 0));
                    TareaObservacionesNegocio tobs = new TareaObservacionesNegocio();
                    tobs.mostrar(idTarea);
                }
            }
        }
    }//GEN-LAST:event_jTableTareasMouseClicked

    private void btnPendienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPendienteMouseClicked

        //  tarea.menuTareas();

    }//GEN-LAST:event_btnPendienteMouseClicked

    private void JLasignarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JLasignarMouseClicked
        tarea.asignarTarea();

    }//GEN-LAST:event_JLasignarMouseClicked

    private void btnFinalizadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFinalizadasMouseClicked
        String andQuery = "WHERE finalizada = 1";
        ArrayList<AsignacionTareas> tareasLista = tarea.listaTareasAsignadas(andQuery);
        String titulo[] = {"id", "Tarea", "Personal", "Fecha asignacion", "Finalizada", ""};
        t.verTable(jTableTareas, llenarTabla(tareasLista), titulo);
    }//GEN-LAST:event_btnFinalizadasMouseClicked

    private void btnPendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendienteActionPerformed
        String andQuery = "WHERE finalizada = 0";
        ArrayList<AsignacionTareas> tareasLista = tarea.listaTareasAsignadas(andQuery);
        String titulo[] = {"id", "Tarea", "Personal", "Fecha asignacion", "Finalizada", ""};
        t.verTable(jTableTareas, llenarTabla(tareasLista), titulo);
    }//GEN-LAST:event_btnPendienteActionPerformed

    private void btnTareasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTareasMouseClicked
        ArrayList<Tarea> tareas = tarea.lista();
        String titulo[] = {"id", "Nombre", "Area", "Periodicidad", "Activo"};

        t.verTable(jTableTareas, llenarTablaTarea(tareas), titulo);
    }//GEN-LAST:event_btnTareasMouseClicked

    public Object[][] llenarTabla(ArrayList<AsignacionTareas> tareaLista) {
        Object fila[][] = null;
        PersonalNegocio p = new PersonalNegocio();
        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setName("Finalizar");
        JButton btnVer = new JButton("Ver Observaciones");
        btnVer.setName("Ver");
        try {
            fila = new Object[tareaLista.size()][7];
            for (int i = 0; i < tareaLista.size(); i++) {
                fila[i][0] = tareaLista.get(i).getId();
                fila[i][1] = tarea.buscar(String.valueOf(tareaLista.get(i).getIdTarea())).getNombre();
                fila[i][2] = p.buscar(String.valueOf(tareaLista.get(i).getIdPersonal())).getNombre();
                fila[i][3] = tareaLista.get(i).getFechaAsignacion();
                fila[i][4] = tareaLista.get(i).getFinalizada();
                fila[i][5] = tareaLista.get(i).getFinalizada() == 0 ? btnFinalizar : btnVer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fila;
    }

    public Object[][] llenarTablaTarea(ArrayList<Tarea> tarea) {
        Object fila[][] = null;
        try {
            fila = new Object[tarea.size()][7];
            for (int i = 0; i < tarea.size(); i++) {
                fila[i][0] = tarea.get(i).getId();
                fila[i][1] = tarea.get(i).getNombre();
                fila[i][2] = tarea.get(i).getIdAreasLaborales();
                fila[i][3] = tarea.get(i).getIdPeriodicidad();
                fila[i][4] = tarea.get(i).getActivo();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fila;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLActivarDesactivar;
    private javax.swing.JLabel JLasignar;
    private javax.swing.JLabel JLeditar;
    private javax.swing.JLabel JLnuevo;
    private javax.swing.JButton btnFinalizadas;
    private javax.swing.JButton btnPendiente;
    private javax.swing.JButton btnTareas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTareas;
    // End of variables declaration//GEN-END:variables
}
