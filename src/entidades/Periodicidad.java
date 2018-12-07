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
public class Periodicidad {

    private int id;
    private String periodicidad;

    public Periodicidad(int id, String periodicidad) {
        this.id = id;
        this.periodicidad = periodicidad;
    }

    @Override
    public String toString() {
        return periodicidad;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

}
