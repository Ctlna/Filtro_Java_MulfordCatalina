/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class NinjaModel {
    
    Conexion conexion = new Conexion();
    Scanner scanner = new Scanner(System.in);
       
    public void createNinja() {
        System.out.print("Ingrese el nombre del ninja: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el rango del ninja: ");
        int rango = scanner.nextInt();
        System.out.print("Ingrese la aldea del ninja: ");
        String aldea = scanner.nextLine();

        String sql = "INSERT INTO ninja (nombre, rango, aldea) VALUES (?, ?, ?)";
        
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setInt(2, rango);
            stmt.setString(3, aldea);
            
            stmt.executeUpdate();
            System.out.println("El ninja se ingreso exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error ingresando al ninja: " + e.getMessage());
        }
    }

    public void editNinja() {
        System.out.print("Ingrese el ID del ninja que desea editar: ");
        int ninjaId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el nombre del ninja: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el rango del ninja: ");
        int rango = scanner.nextInt();
        System.out.print("Ingrese la aldea del ninja: ");
        String aldea = scanner.nextLine();

        String sql = "UPDATE ninja SET nombre = ?, rango = ?, aldea = ? WHERE id = ?";
        
        try (Connection conn = conexion.establecerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setInt(2, rango);
            stmt.setString(3, aldea);
            stmt.setInt(4, ninjaId);
            
            stmt.executeUpdate();
            System.out.println("Ninja fue actualizado.");
        } catch (SQLException e) {
            System.err.println("Error actualizando al ninja: " + e.getMessage());
        }
    }

    public void deleteNinja() {
        System.out.print("Ingrese el ID de la mision que desea eliminar: ");
        int ninjaId = scanner.nextInt();

        String sql = "DELETE FROM ninja WHERE id = ?";
        
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ninjaId);
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("El ninja fue eliminado.");
            } else {
                System.out.println("No se encontro al ninja con ese ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error eliminando al ninja: " + e.getMessage());
        }
    }
}
