package entidades;

import java.util.Date;

public class Personal {

    private int id;
    private String documento;
    private int idTipoDocumento;
    private String nombre;
    private Date fechaNacimiento;
    private String idCiudadNacimiento;
    private int idNacionalidad;
    private int idTipoSangre;
    private String direccion;
    private String telefonoFijo;
    private String telefonoCelular;
    private String correo;
    private String profesion;
    private int idArea;
    private int idCargo;
    private Date fechaContrato;
    private int idtipoContrato;
    private int activo;
    private String motivo;

//    public Personal(String documento, int tipoDocumento) {
//        this.documento = documento;
//        this.idTipoDocumento = tipoDocumento;
//    }
    public Personal(int id, String documento, String nombre) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
    }

    public Personal() {
    }

    @Override
    public String toString() {
        return nombre + " " + documento; //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdCiudadNacimiento() {
        return idCiudadNacimiento;
    }

    public void setIdCiudadNacimiento(String idCiudadNacimiento) {
        this.idCiudadNacimiento = idCiudadNacimiento;
    }

    public int getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public int getIdTipoSangre() {
        return idTipoSangre;
    }

    public void setIdTipoSangre(int idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public int getIdtipoContrato() {
        return idtipoContrato;
    }

    public void setIdtipoContrato(int idtipoContrato) {
        this.idtipoContrato = idtipoContrato;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
