/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.negocio;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felipe
 */
public class Tabla {

//https://www.youtube.com/watch?v=jPfKFm2Yfow
    public void verTable(JTable table, Object[][] contenido, String[] titulos) {

        table.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel model = new DefaultTableModel(contenido, titulos) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.fireTableDataChanged();
        table.setModel(model);
        table.setRowHeight(30);
    }
}
