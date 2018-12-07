/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.persistencia;

import Conexion.Conexion;
import entidades.Horarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class HorarioDAO {

    public static boolean crearTurno(Horarios h) {
        Connection conn = null;
        boolean error = false;
        PreparedStatement stmt = null;
        final String SQL_INSERT = "INSERT INTO horarios("
                + "fecha,horaDesde,horaHasta,idPersonal) "
                + "VALUES(?,?,?,?)";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            int index = 1;
            stmt.setDate(index++, new Date(h.getFecha().getTime()));
            stmt.setString(index++, h.getHoraDesde());
            stmt.setString(index++, h.getHoraHasta());
            stmt.setInt(index++, h.getIdPersonal());
            stmt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            error = true;
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return error;
    }

    public static ArrayList<Horarios> lista(String andQuery) {
        ArrayList<Horarios> horariosLista = new ArrayList<>();
        String SQL_SELECT = "SELECT * FROM horarios ";
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
                Horarios horarios = new Horarios();
                horarios.setId(rs.getInt("id"));
                horarios.setFecha(rs.getDate("fecha"));
                horarios.setHoraDesde(rs.getString("horaDesde"));
                horarios.setHoraHasta(rs.getString("horaHasta"));
                horarios.setIdPersonal(rs.getInt("idPersonal"));
                horariosLista.add(horarios);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return horariosLista;
    }

}
