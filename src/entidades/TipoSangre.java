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
public class TipoSangre {

    private int id;
    private String tipo;
    private String rh;

    public TipoSangre(int id, String tipo, String rh) {
        this.id = id;
        this.tipo = tipo;
        this.rh = rh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    @Override
    public String toString() {
        return tipo+rh;
    }
}
