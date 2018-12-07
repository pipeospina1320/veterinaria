/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.persistencia;

import Conexion.Conexion;
import entidades.UsuarioEn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class UsuarioHelper {

    public static UsuarioEn user;

    public static UsuarioEn buscar(String idUsuario) {
        UsuarioEn usuarioEn = new UsuarioEn();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final String SQL_SELECT = "SELECT * FROM usuarios WHERE id=" + idUsuario;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuarioEn.setId(rs.getInt("id"));
                usuarioEn.setNombreUsuario(rs.getString("nombreUsuario"));
                usuarioEn.setIdPerfil(rs.getInt("idPerfil"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        user = usuarioEn;
        return usuarioEn;
    }

//    public static boolean anadirArchivo(UsuarioEn usuario) {
//        FileWriter flwriter = null;
//        boolean result = false;
//        try {
//            //ademas de la ruta del archivo recibe un parametro de tipo boolean, que le indica que se va agregar mas registros 
//            flwriter = new FileWriter(ruta, true);
//            //Se prepara el buffer de entrada para recibir el archivo
//            //La mayor ventaja de los buffered es con el BufferedReader que nos permite leer una linea completa
//            BufferedWriter bfwriter = new BufferedWriter(flwriter);
//            bfwriter.write(usuario.getDocumento() + "," + usuario.getNombreUsuario() + "," + usuario.getClave() + "," + usuario.getPerfil() + "\n");
//            bfwriter.close();
//            result = true;
//            JOptionPane.showMessageDialog(null, "Archivo modificado satisfactoriamente..");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (flwriter != null) { //Cerrar el archivo si fue abierto
//                try {
//                    flwriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }
}
