package Conexion;

import java.sql.*;

/**
 *
 * @author felipe
 */
public class Conexion {

    // Librería de MySQL
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    private static String database = "bdfelix";
    // Host
    private static String hostname = "localhost";
    // Puerto
    private static String port = "3306";
    // Nombre de usuario
    private static String username = "root";
    // Clave de usuario
    private static String password = "";

    private static Driver driver = null;
    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private static String JDBC_URL = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    public static synchronized Connection getConnection() throws SQLException {
        if (driver == null) {
            try {
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            } catch (Exception e) {
                System.out.println("Fallo en cargar el driver");
                e.printStackTrace();
            }
        }
        return DriverManager.getConnection(JDBC_URL, username, password);
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void close(PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
            conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

//    public Connection conectarMySQL() {
//        Connection conn = null;
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//
//        return conn;
//    }


}
