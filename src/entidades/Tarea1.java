/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author felipe
 */
public class Tarea1 {

    private int id;
    private String nombre;
    private int idAreasLaborales;
    private Date fechaInicioTarea;
    private Date fechaFinTarea;
    private Date fechaAsignacion;
    private Date fechaFinalizacion;
    private String hora;
    private int activo;
    private int finalizada;
    private int idPersonal;

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

    public Date getFechaInicioTarea() {
        return fechaInicioTarea;
    }

    public void setFechaInicioTarea(Date fechaInicioTarea) {
        this.fechaInicioTarea = fechaInicioTarea;
    }

    public Date getFechaFinTarea() {
        return fechaFinTarea;
    }

    public void setFechaFinTarea(Date fechaFinTarea) {
        this.fechaFinTarea = fechaFinTarea;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
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

    public int getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(int finalizada) {
        this.finalizada = finalizada;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

}
