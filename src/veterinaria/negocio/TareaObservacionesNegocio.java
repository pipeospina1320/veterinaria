/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.negocio;

import entidades.TareaObservaciones;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import veterinaria.persistencia.TareaObservacionDAO;

/**
 *
 * @author felipe
 */
public class TareaObservacionesNegocio {

    public boolean insetarObservacion(TareaObservaciones t) {
        return TareaObservacionDAO.crearObservacion(t);
    }

    public void mostrar(String idTareaAsignada) {
        ArrayList<TareaObservaciones> lista = TareaObservacionDAO.buscar(idTareaAsignada);
        String mensaje = "";
        for (int i = 0; i < lista.size(); i++) {
            mensaje = mensaje + (i + 1) + ". " + lista.get(i).getObservacion() + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
