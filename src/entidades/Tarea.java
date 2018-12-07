/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author felipe
 */
public class Tarea {

    private int id;
    private String nombre;
    private int idAreasLaborales;
    private int idPeriodicidad;
    private String hora;
    private int activo;

    public Tarea() {
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Tarea(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Tarea(int id, String nombre, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdAreasLaborales() {
        return idAreasLaborales;
    }

    public void setIdAreasLaborales(int idAreasLaborales) {
        this.idAreasLaborales = idAreasLaborales;
    }

    public int getIdPeriodicidad() {
        return idPeriodicidad;
    }

    public void setIdPeriodicidad(int idPeriodicidad) {
        this.idPeriodicidad = idPeriodicidad;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

}
