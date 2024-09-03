/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import com.sun.jdi.connect.spi.Connection;
import ConnectioLan.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class MisionNinjaView {
    
    Conexion conexion = new Conexion();
    Scanner scanner = new Scanner(System.in);
    
    public void misionesCompletas() {
        String sql = "select *\n" +
                    "from mision\n" +
                    "where fechafin is not null";
        try (Connection conn = conexion.establecerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                boolean hasResults = false; 
                while (rs.next()) {
                    hasResults = true;
                    System.out.println("Ninaj ID: " + rs.getInt("id_ninja"));
                    System.out.println("Mision ID: " + rs.getInt("id_mision"));
                    System.out.println("Fecha de inico: " + rs.getString("fechaInicio"));
                    System.out.println("Fecha de fin: " + rs.getDouble("fechafin"));
                    
                    System.out.println(); 
                }
                if (!hasResults) {
                    System.out.println("No se encontraron misiones completadas.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error encontrando las misiones completadas: " + e.getMessage());
        }
    }
    
}
