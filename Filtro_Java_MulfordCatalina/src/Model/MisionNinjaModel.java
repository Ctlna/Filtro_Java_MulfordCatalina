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
public class MisionNinjaModel {
    
    Conexion conexion = new Conexion();
    Scanner scanner = new Scanner(System.in);
       
    public void asignarMision() {
        System.out.print("Ingrese el ID del ninja: ");
        int ninja = scanner.nextInt();
        System.out.print("Ingrese el ID de la mision: ");
        int mision = scanner.nextInt();
        System.out.print("Ingrese fecha de inicio(AAAA-MM-DD): ");
        int inicio = scanner.nextInt();
        System.out.print("Ingrese fecha de fin(AAAA-MM-DD): ");
        int fin = scanner.nextInt();

        String sql = "INSERT INTO misionNinja (id_ninja, id_mision, fechaInicio, fechafin) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ninja);
            stmt.setInt(2, mision);
            stmt.setInt(3, inicio);
            stmt.setInt(4, fin);
            
            stmt.executeUpdate();
            System.out.println("La mision se asigno exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error asignando la mision: " + e.getMessage());
        }
    }

}
