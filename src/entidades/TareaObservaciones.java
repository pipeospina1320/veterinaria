/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author felipe
 */
public class TareaObservaciones {

    private int id;
    private String observacion;
    private int idTareaAsignada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdTareaAsignada() {
        return idTareaAsignada;
    }

    public void setIdTareaAsignada(int idTareaAsignada) {
        this.idTareaAsignada = idTareaAsignada;
    }

}
