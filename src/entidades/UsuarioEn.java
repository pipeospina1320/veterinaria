/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

public class UsuarioEn {

    private int id;
    private String nombreUsuario;
    private String clave;
    private int idPerfil;

    public UsuarioEn(int id, String nombreUsuario, String clave, int idPerfil) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.idPerfil = idPerfil;
    }

    public UsuarioEn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

}
