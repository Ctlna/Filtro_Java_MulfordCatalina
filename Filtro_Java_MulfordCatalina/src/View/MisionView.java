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
public class MisionView {
     
        Conexion conexion = new Conexion();
        Scanner scanner = new Scanner(System.in);
       
    public void misionesDisponibleNinja() {
        System.out.print("Cual es el ID del ninja de quien se buscaran las misiones: ");
        int id = scanner.nextInt(); 
        scanner.nextLine();
        
        String sql = "SELECT m.*\n" +
                    "FROM mision m \n" +
                    "left join misionNinja mN on mN.id_mision = m.id \n" +
                    "right join ninja n on n.id = mN.id_ninja\n" +
                    "where n.id = ? \n" +
                    "and mN.id_mision is null\n" +
                    "and n.rango >= m.rango";
        try (Connection conn = conexion.establecerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                boolean hasResults = false; 
                while (rs.next()) {
                    hasResults = true;
                    System.out.println("Mision ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("descripcion"));
                    System.out.println("Rango: " + rs.getDouble("rango"));
                    System.out.println("Recompensa: " + rs.getString("recompensa"));
                    
                    System.out.println(); // Print a blank line for better readability
                }
                if (!hasResults) {
                    System.out.println("No se encontraron misiones.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error encontrando las misiones: " + e.getMessage());
        }
    }
    
    public void obtenermisionporid() {
        System.out.print("Cual es el ID del ninja de quien se buscaran las misiones: ");
        int id = scanner.nextInt(); 
        scanner.nextLine();

        String sql = "SELECT m.* \n" +
                    "FROM mision m \n" +
                    "left join misionNinja mN on mN.id_mision = m.id \n" +
                    "right join ninja n on n.id = mN.id_ninja\n" +
                    "where mN.id_mision is not null\n" +
                    "and mN.id_ninja is not null\n" +
                    "and n.id = ?";
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Mision ID: " + rs.getInt("id"));
                    System.out.println("Descripcion: " + rs.getString("descripcion"));
                    System.out.println("Rango: " + rs.getDouble("rango"));
                    System.out.println("Recompensa: " + rs.getString("recompensa"));
                    
                } else {
                    System.out.println("El ID del ninja no fue encontrado: " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
