/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import ConnectioLan.Conexion;
import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
/**
 *
 * @author camper
 */
public class MisionModel {
    
    Conexion conexion = new Conexion();
    Scanner scanner = new Scanner(System.in);
    
    
    public void createMision() {
        System.out.print("Ingrese la descripción de la mision: ");
        String descri = scanner.nextLine();
        System.out.print("Ingrese el rango de la mision: ");
        int rango = scanner.nextInt();
        System.out.print("Ingrese la recompensa de la mision: ");
        int recom = scanner.nextInt();

        String sql = "INSERT INTO mision (descripcion, rango, recompensa) VALUES (?, ?, ?)";
        
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descri);
            stmt.setInt(2, rango);
            stmt.setInt(5, recom);
            
            stmt.executeUpdate();
            System.out.println("La misión se creo exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error creando la mision: " + e.getMessage());
        }
    }

    public void editMision() {
        System.out.print("Ingrese el ID de la mision que desea editar: ");
        int misionId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese la descripción de la mision: ");
        String descri = scanner.nextLine();
        System.out.print("Ingrese el rango de la mision: ");
        int rango = scanner.nextInt();
        System.out.print("Ingrese la recompensa de la mision: ");
        int recom = scanner.nextInt();

        String sql = "UPDATE mision SET descripcion = ?, rango = ?, recompensa = ? WHERE id = ?";
        
        try (Connection conn = conexion.establecerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, descri);
            stmt.setInt(2, rango);
            stmt.setInt(3, recom);
            stmt.setInt(4, misionId);
            
            stmt.executeUpdate();
            System.out.println("Mision fue actualizada.");
        } catch (SQLException e) {
            System.err.println("Error actualizando mision: " + e.getMessage());
        }
    }

    public void deleteMision() {
        System.out.print("Ingrese el ID de la mision que desea eliminar: ");
        int eventId = scanner.nextInt();

        String sql = "DELETE FROM mision WHERE id = ?";
        
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eventId);
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("La mision fue eliminada.");
            } else {
                System.out.println("No se encontro la mision con ese ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error eliminando la mision: " + e.getMessage());
        }
    }
}
