/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.persistencia;

import Conexion.Conexion;
import entidades.TareaObservaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class TareaObservacionDAO {

    public static boolean crearObservacion(TareaObservaciones t) {
        Connection conn = null;
        boolean error = false;
        PreparedStatement stmt = null;
        final String SQL_INSERT = "INSERT INTO observaciones("
                + "observacion,idTareaAsignada) "
                + "VALUES(?,?)";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            int index = 1;
            stmt.setString(index++, t.getObservacion());
            stmt.setInt(index++, t.getIdTareaAsignada());
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            error = true;
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return error;
    }

    public static ArrayList<TareaObservaciones> buscar(String idTareaASignada) {
        ArrayList<TareaObservaciones> obsLista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final String SQL_SELECT = "SELECT * FROM observaciones WHERE idTareaAsignada=" + idTareaASignada;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                TareaObservaciones obs = new TareaObservaciones();
                obs.setId(rs.getInt("id"));
                obs.setObservacion(rs.getString("observacion"));
                obsLista.add(obs);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return obsLista;
    }

}
