/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filtro_java_mulfordcatalina;

import Model.MisionModel;
import ConnectioLan.Conexion;
import Model.HabilidadesModel;
import Model.MisionNinjaModel;
import Model.NinjaModel;
import View.MisionNinjaView;
import View.MisionView;
import View.NinjaView;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Conexion conexion = new Conexion();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Que deseas hacer:");
        System.out.println("1. Ver los ninjas y sus habilidades");
        System.out.println("2. Ver las misiones disponibles para un ninja");
        System.out.println("3. Ver las misiones completadas por un ninja");
        System.out.println("4. Ver todas las misiones completadas");
        System.out.println("5. Crear ninja");
        System.out.println("6. Editar ninja");
        System.out.println("7. Eliminar ninja");
        System.out.println("8. Crear habilidad ninja");
        System.out.println("9. Editar habilidad ninja");
        System.out.println("10. Eliminar habilidad ninja");
        System.out.println("11. Asignar mision");
        System.out.println("0. Salir");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        while (choice !=0){
            switch (choice) {
            case 1:
                NinjaView Event = new NinjaView();
                Event.todosNinjasHabil();
                break;
            case 2:
                MisionView Ticket = new MisionView();
                Ticket.misionesDisponibleNinja();
                break;
            case 3:
                MisionView x = new MisionView();
                x.obtenermisionporid();
                break;
            case 4:
                MisionNinjaView act = new MisionNinjaView();
                act.misionesCompletas();
                break;
            case 5:
                NinjaModel come = new NinjaModel();
                come.createNinja();
                break;
            case 6:
                NinjaModel coe = new NinjaModel();
                coe.editNinja();
                break;
            case 7:
                NinjaModel com = new NinjaModel();
                com.deleteNinja();
                break;
            case 8:
                HabilidadesModel acount = new HabilidadesModel();
                acount.createHabilidades();
                break;
            case 9:
                HabilidadesModel aount = new HabilidadesModel();
                aount.edithabilidad();
                break;
            case 10:
                HabilidadesModel acont = new HabilidadesModel();
                acont.deleteHabilidad();
                break;
            case 11:
                MisionNinjaModel aco = new MisionNinjaModel();
                aco.asignarMision();
                break;
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                break;
        }
        }
    }
        
    
}
