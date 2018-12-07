package veterinaria.persistencia;

import Conexion.Conexion;
import entidades.Personal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PersonalDAO {

    public static boolean crearPersona(Personal p) {
        Connection conn = null;
        boolean error = false;
        PreparedStatement stmt = null;
        final String SQL_INSERT = "INSERT INTO personal("
                + "idTipoDocumento,idCiudadNacimiento,idTipoSangre,idNacionalidad,idAreaLaboral,idCargo,idTipoContrato,numeroDocumento,nombreCompleto,"
                + "fechaNacimiento,direccion,telefono,celular,email,fechaContratacion,profesion,activo,motivo) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            int index = 1;
            stmt.setInt(index++, p.getIdTipoDocumento());
            stmt.setString(index++, p.getIdCiudadNacimiento());
            stmt.setInt(index++, p.getIdTipoSangre());
            stmt.setInt(index++, p.getIdNacionalidad());
            stmt.setInt(index++, p.getIdArea());
            stmt.setInt(index++, p.getIdCargo());
            stmt.setInt(index++, p.getIdtipoContrato());
            stmt.setString(index++, p.getDocumento());
            stmt.setString(index++, p.getNombre());
            stmt.setDate(index++, new Date(p.getFechaNacimiento().getTime()));
            stmt.setString(index++, p.getDireccion());
            stmt.setString(index++, p.getTelefonoFijo());
            stmt.setString(index++, p.getTelefonoCelular());
            stmt.setString(index++, p.getCorreo());
            stmt.setDate(index++, new Date(p.getFechaContrato().getTime()));
            stmt.setString(index++, p.getProfesion());
            stmt.setInt(index++, 1);
            stmt.setString(index++, "Activo");

            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            error = true;
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return error;
    }

    public static boolean modificarPersonal(Personal p) {
        Connection conn = null;
        boolean error = false;
        PreparedStatement stmt = null;
        final String SQL_UPDATE = "UPDATE personal SET idAreaLaboral=?, idCargo=?, idTipoContrato=?, direccion=?, telefono=?, celular=?, email=?, fechaContratacion=?, profesion=? WHERE id=?";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            int index = 1;
            stmt.setInt(index++, p.getIdArea());
            stmt.setInt(index++, p.getIdCargo());
            stmt.setInt(index++, p.getIdtipoContrato());
            stmt.setString(index++, p.getDireccion());
            stmt.setString(index++, p.getTelefonoFijo());
            stmt.setString(index++, p.getTelefonoCelular());
            stmt.setString(index++, p.getCorreo());
            stmt.setDate(index++, new Date(p.getFechaContrato().getTime()));
            stmt.setString(index++, p.getProfesion());
            stmt.setInt(index++, p.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            JOptionPane.showMessageDialog(null, ex.getMessage());
            error = true;
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return error;
    }

    public static boolean activarDesactivarPersonal(int activo, String motivo, int id) {
        Connection conn = null;
        boolean error = false;
        PreparedStatement stmt = null;
        final String SQL_INSERT = "UPDATE personal SET "
                + "activo=? ,motivo=? WHERE id=?";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            int index = 1;
            stmt.setInt(index++, activo);
            stmt.setString(index++, motivo);
            stmt.setInt(index++, id);
            stmt.executeUpdate();
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            JOptionPane.showMessageDialog(null, ex.getMessage());
            error = true;
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return error;
    }

    public static ArrayList<Personal> lista() {
        ArrayList<Personal> personasLista = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM personal";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Personal personal = new Personal();
                personal.setNombre(rs.getString("nombreCompleto"));
                personal.setTelefonoFijo(rs.getString("telefono"));
                personal.setTelefonoCelular(rs.getString("celular"));
                personal.setDocumento(rs.getString("numeroDocumento"));
                personal.setActivo(rs.getInt("activo"));
                personasLista.add(personal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return personasLista;
    }

    public static Personal buscar(String idPersonal) {
        Personal personal = new Personal();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final String SQL_SELECT = "SELECT * FROM personal WHERE id=" + idPersonal;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                personal.setId(rs.getInt("id"));
                personal.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                personal.setIdCiudadNacimiento(rs.getString("idCiudadNacimiento"));
                personal.setIdTipoSangre(rs.getInt("idTipoSangre"));
                personal.setIdNacionalidad(rs.getInt("idNacionalidad"));
                personal.setIdArea(rs.getInt("idAreaLaboral"));
                personal.setIdCargo(rs.getInt("idCargo"));
                personal.setIdtipoContrato(rs.getInt("idTipoContrato"));
                personal.setDocumento(rs.getString("numeroDocumento"));
                personal.setNombre(rs.getString("nombreCompleto"));
                personal.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                personal.setDireccion(rs.getString("direccion"));
                personal.setTelefonoFijo(rs.getString("telefono"));
                personal.setTelefonoCelular(rs.getString("celular"));
                personal.setCorreo(rs.getString("email"));
                personal.setFechaContrato(rs.getDate("fechaContratacion"));
                personal.setProfesion(rs.getString("Profesion"));
                personal.setActivo(rs.getInt("Activo"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return personal;
    }

    public static Personal buscarCedula(String cedula) {
        Personal personal = new Personal();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final String SQL_SELECT = "SELECT * FROM personal WHERE numeroDocumento=" + cedula;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                personal.setId(rs.getInt("id"));
                personal.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                personal.setIdCiudadNacimiento(rs.getString("idCiudadNacimiento"));
                personal.setIdTipoSangre(rs.getInt("idTipoSangre"));
                personal.setIdNacionalidad(rs.getInt("idNacionalidad"));
                personal.setIdArea(rs.getInt("idAreaLaboral"));
                personal.setIdCargo(rs.getInt("idCargo"));
                personal.setIdtipoContrato(rs.getInt("idTipoContrato"));
                personal.setDocumento(rs.getString("numeroDocumento"));
                personal.setNombre(rs.getString("nombreCompleto"));
                personal.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                personal.setDireccion(rs.getString("direccion"));
                personal.setTelefonoFijo(rs.getString("telefono"));
                personal.setTelefonoCelular(rs.getString("celular"));
                personal.setCorreo(rs.getString("email"));
                personal.setFechaContrato(rs.getDate("fechaContratacion"));
                personal.setProfesion(rs.getString("Profesion"));
                personal.setActivo(rs.getInt("Activo"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return personal;
    }
}
