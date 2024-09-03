/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectioLan;

import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;


/**
 *
 * @author camper
 */
public class Conexion {
    public Conexion con;
    public Connection establecerConexion() throws SQLException {
    Properties props = new Properties();
    try (InputStream input = getClass().getClassLoader().getResourceAsStream("ConnectioLan/properties.properties")) {
        if (input == null) {
            throw new IllegalStateException("Archivo properties no encontrado");
        }

        props.load(input);

        String url = props.getProperty("Url");
        String user = props.getProperty("User");
        String password = props.getProperty("Password");

        if (url == null || user == null || password == null) {
            throw new IllegalStateException("Una o más propiedades de conexión no están definidas");
        }

        Class.forName("com.mysql.cj.jdbc.Driver");
        return (Connection) DriverManager.getConnection(url, user, password);
    } catch (IOException | ClassNotFoundException | IllegalStateException e) {
        System.err.println("Error en la conexión: " + e);
        JOptionPane.showMessageDialog(null, "Error en la conexión: " + e.toString());
        return null;
    }
}

    public PreparedStatement prepareStatement(String sql, int RETURN_GENERATED_KEYS) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}