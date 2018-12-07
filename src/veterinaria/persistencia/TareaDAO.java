/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.persistencia;

import Conexion.Conexion;
import entidades.AsignacionTareas;
import entidades.Tarea;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class TareaDAO {

    public static boolean crearTarea(Tarea t) {
        Connection conn = null;
        boolean error = false;
        PreparedStatement stmt = null;
        final String SQL_INSERT = "INSERT INTO tareas("
                + "nombre,idAreasLaborales,idPeriodicidad,hora,activo) "
                + "VALUES(?,?,?,?,?)";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            int index = 1;
            stmt.setString(index++, t.getNombre());
            stmt.setInt(index++, t.getIdAreasLaborales());
            stmt.setInt(index++, t.getIdPeriodicidad());
            stmt.setString(index++, t.getHora());
            stmt.setInt(index++, 1);
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

    public static boolean asignarTarea(AsignacionTareas at) {
        Connection conn = null;
        boolean error = false;
        PreparedStatement stmt = null;
        final String SQL_INSERT = "INSERT INTO asignacionTareas("
                + "idTarea,idPersonal,fechaAsignacion,finalizada) "
                + "VALUES(?,?,?,?)";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            int index = 1;
            stmt.setInt(index++, at.getIdTarea());
            stmt.setInt(index++, at.getIdPersonal());
            stmt.setDate(index++, new Date(at.getFechaAsignacion().getTime()));
            stmt.setInt(index++, 0);
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

    public static Tarea buscar(String idTarea) {
        Tarea tarea = new Tarea();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final String SQL_SELECT = "SELECT * FROM tareas WHERE id=" + idTarea;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                tarea.setId(rs.getInt("id"));
                tarea.setNombre(rs.getString("nombre"));
                tarea.setIdAreasLaborales(rs.getInt("idAreasLaborales"));
                tarea.setIdPeriodicidad(rs.getInt("idPeriodicidad"));
                tarea.setHora(rs.getString("hora"));
                tarea.setActivo(rs.getInt("activo"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return tarea;
    }

     public static AsignacionTareas buscarAsignadas(String idTarea) {
        AsignacionTareas tarea = new AsignacionTareas();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final String SQL_SELECT = "SELECT a.*, t.* FROM asignacionTareas a JOIN tareas t ON a.idTarea = t.id WHERE a.id=" + idTarea;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                tarea.setId(rs.getInt("a.id"));
               // tarea.setNombre(rs.getString("nombre"));
                tarea.setIdTarea(rs.getInt("a.idTarea"));
                tarea.setFinalizada(rs.getInt("a.finalizada"));
                tarea.setObjTarea(new Tarea(rs.getInt("t.id"), rs.getString("t.nombre"),rs.getInt("t.activo")));
               // tarea.setActivo(rs.getInt("activo"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return tarea;
    }
    
    public boolean editarTarea(Tarea t) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean error = false;
        final String SQL_UPDATE = "UPDATE tareas SET hora=?,idPeriodicidad=? WHERE id=?";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++, t.getHora());
            stmt.setInt(index++, t.getIdPeriodicidad());
            stmt.setInt(index, t.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            error = true;
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return error;
    }

    public boolean activarDesactivar(Tarea t) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean error = false;

        final String SQL_UPDATE = "UPDATE tareas SET activo=? WHERE id=?";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setInt(index++, t.getActivo() == 1 ? 0 : 1);
            stmt.setInt(index, t.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            error = true;
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return error;
    }

    public static ArrayList<Tarea> lista(String andQuery) {
        ArrayList<Tarea> tareaLista = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM tareas ";
        if (andQuery != null) {
            SQL_SELECT = SQL_SELECT + andQuery;
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setId(rs.getInt("id"));
                tarea.setNombre(rs.getString("nombre"));
                tarea.setIdAreasLaborales(rs.getInt("idAreasLaborales"));
                tarea.setIdPeriodicidad(rs.getInt("idPeriodicidad"));
                tarea.setActivo(rs.getInt("activo"));

                tareaLista.add(tarea);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tareaLista;
    }

    public boolean terminarTareaAsignada(AsignacionTareas t) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean error = false;
        final String SQL_UPDATE = "UPDATE asignacionTareas SET finalizada=? WHERE id=?";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setInt(index++, 1);
            stmt.setInt(index, t.getId());

            stmt.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            error = true;
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return error;
    }

    public static ArrayList<AsignacionTareas> listaTareasAsignadas(String andQuery) {
        ArrayList<AsignacionTareas> tareaLista = new ArrayList<>();
        String SQL_SELECT = "SELECT a.*, t.nombre as nombreTarea FROM asignacionTareas a JOIN tareas t ON t.id = a.idTarea ";
        if (andQuery != null) {
            SQL_SELECT = SQL_SELECT + andQuery;
        }
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AsignacionTareas tarea = new AsignacionTareas();
                tarea.setId(rs.getInt("a.id"));
                tarea.setIdTarea(rs.getInt("a.idTarea"));
                tarea.setFechaAsignacion(rs.getDate("a.fechaAsignacion"));
                tarea.setIdPersonal(rs.getInt("a.idPersonal"));
                tarea.setFinalizada(rs.getInt("a.finalizada"));
                tarea.setObjTarea(new Tarea(0, rs.getString("nombreTarea")));

                tareaLista.add(tarea);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tareaLista;
    }
}
