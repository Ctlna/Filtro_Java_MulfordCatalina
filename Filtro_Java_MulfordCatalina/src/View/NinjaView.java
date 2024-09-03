/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

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
public class NinjaView {
    
        Conexion conexion = new Conexion();
        Scanner scanner = new Scanner(System.in);
        
    public void todosNinjasHabil() throws SQLException{
        String sql = "select n.nombre as Ninja, h.nombre as Habilidad \n" +
                    "from ninja n \n" +
                    "left join habilidades h on n.id = h.id_ninja;";
        try (Connection conn = conexion.establecerConexion(); 
                PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String ninja = rs.getString("Ninja");
                String habi = rs.getString("Habilidad");
                
                System.out.println("Nombre: " + ninja);
                System.out.println("Habilidad: " + habi);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());}
    }
}
