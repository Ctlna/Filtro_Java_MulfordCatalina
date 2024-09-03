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
public class HabilidadesModel {
    
    Conexion conexion = new Conexion();
    Scanner scanner = new Scanner(System.in);
       
    public void createHabilidades() {
        System.out.print("Ingrese el ID del ninja: ");
        int idninja = scanner.nextInt();
        System.out.print("Ingrese el nombre de la habilidad del ninja: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripcion de la habilidad: ");
        String aldea = scanner.nextLine();

        String sql = "INSERT INTO habilidades (id_ninja, nombre, descripcion) VALUES (?, ?, ?)";
        
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(2, nombre);
            stmt.setInt(1, idninja);
            stmt.setString(3, aldea);
            
            stmt.executeUpdate();
            System.out.println("La habilidad se ingreso exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error ingresando la habilidad: " + e.getMessage());
        }
    }

    public void edithabilidad() {
        System.out.print("Ingrese el ID de la habilidad ninja que desea editar: ");
        int ninjaId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el id del ninja: ");
        int idn = scanner.nextInt();
        System.out.print("Ingrese el nombre de la habilidad del ninja: ");
        String habilidad = scanner.nextLine();
        System.out.print("Ingrese la descripcion: ");
        String desc = scanner.nextLine();

        String sql = "UPDATE habilidades SET id_ninja = ?, nombre = ?, descripcion = ? WHERE id = ?";
        
        try (Connection conn = conexion.establecerConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idn);
            stmt.setString(2, habilidad);
            stmt.setString(3, desc);
            stmt.setInt(4, ninjaId);
            
            stmt.executeUpdate();
            System.out.println("Se actualizo.");
        } catch (SQLException e) {
            System.err.println("Error actualizando: " + e.getMessage());
        }
    }

    public void deleteHabilidad() {
        System.out.print("Ingrese el ID de la habilidad que desea eliminar: ");
        int ninjaId = scanner.nextInt();

        String sql = "DELETE FROM habilidades WHERE id = ?";
        
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ninjaId);
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("La habilidad fue eliminada.");
            } else {
                System.out.println("No se encontro la habilidad ese ID.");
            }
        } catch (SQLException e) {
            System.err.println("Error eliminando la habilidad: " + e.getMessage());
        }
    }
}