package com.ligabetplay.view;

import java.util.Scanner;
import com.ligabetplay.Controller;
import com.ligabetplay.view.SubViews.ViewPlayer;
import com.ligabetplay.view.SubViews.ViewSchedulingMatch;
import com.ligabetplay.view.SubViews.ViewStadium;
import com.ligabetplay.view.SubViews.ViewTeam;

public class ViewAdmin {

    public static void start() {
       
        ViewTeam viewTeam = new ViewTeam();
        ViewPlayer viewPlayer = new ViewPlayer();
        ViewStadium viewStadium = new ViewStadium();
        Controller controlador = Controller.getInstance();
        Scanner sc = controlador.sc;
        Validation val = new Validation();

        while (true) {
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                   MENU ADMINISTRADOR               ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            System.out.println("║  1. Gestionar equipos                              ║");
            System.out.println("║  2. Gestionar jugadores                            ║");
            System.out.println("║  3. Programación de partidos                       ║");
            System.out.println("║  4. Registrar resultados de partidos               ║");
            System.out.println("║  5. Gestionar noticias y comunicados               ║");
            System.out.println("║  6. Gestionar entrenadores                         ║");
            System.out.println("║  7. Gestionar árbitros                             ║");
            System.out.println("║  8. Gestionar estadios                             ║");
            System.out.println("║  9. Gestionar patrocinios                          ║");
            System.out.println("║ 10. Generar informes                               ║");
            System.out.println("║ 11. Generar incidentes o sanciones                 ║");
            System.out.println("║ 12. Gestionar medios de comunicación               ║");
            System.out.println("║ 13. Gestionar transferencias de jugadores          ║");
            System.out.println("║ 14. Gestionar equipamientos                        ║");
            System.out.println("║ 15. Gestionar premios y reconocimientos            ║");
            System.out.println("║ 16. Gestionar usuarios y roles                     ║");
            System.out.println("║ 17. Gestionar relaciones públicas                  ║");
            System.out.println("║ 18. Salir del sistema                              ║");
            System.out.println("╚════════════════════════════════════════════════════╝");

            int choice = val.leerNumero("Ingrese el número: ", sc);

            switch (choice) {
                case 1:
                    viewTeam.start();
                    break;
                case 2:
                    viewPlayer.start();
                    break;
                case 3:
                ViewSchedulingMatch.start();
                    break;
                case 4:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 5:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 6:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 7:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 8:
                viewStadium.start();
             
                case 9:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 10:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 11:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 12:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 13:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 14:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 15:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 16:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 17:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 18:
                   int choose =  val.leerNumero("Estas seguro de salir? \n1. si\n2. no\n", sc);
                   System.out.println("Elije la opcion: \n");
                    if (choose == 1) {
                        System.out.println("Que tenga un buen dia");
                        return;
                    }else{
                        continue;
                    }
      
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
            
        }
    }
}
