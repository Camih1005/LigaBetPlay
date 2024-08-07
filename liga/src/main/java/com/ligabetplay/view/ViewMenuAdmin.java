package com.ligabetplay.view;

import java.util.Scanner;


import com.ligabetplay.Controller;
import com.ligabetplay.view.SubViews.ViewReferee;
import com.ligabetplay.view.SubViews.ViewResults;
import com.ligabetplay.view.SubViews.ViewInjury;
import com.ligabetplay.view.SubViews.ViewNewsAndCommunication;
import com.ligabetplay.view.SubViews.ViewPlayer;
import com.ligabetplay.view.SubViews.ViewSchedulingMatch;
import com.ligabetplay.view.SubViews.ViewStadium;
import com.ligabetplay.view.SubViews.ViewTeam;
import com.ligabetplay.view.SubViews.VistaCoach;

public class ViewMenuAdmin {

    public static void start() {
       
        ViewTeam viewTeam = new ViewTeam();
        ViewPlayer viewPlayer = new ViewPlayer();
        ViewStadium viewStadium = new ViewStadium();
        Controller controlador = Controller.getInstance();
        ViewSchedulingMatch viewSchedulingMatch = new ViewSchedulingMatch();
        VistaCoach gestionCoach = new VistaCoach();
        ViewNewsAndCommunication viewNews = new ViewNewsAndCommunication();
        ViewReferee viewMenuReferee = new ViewReferee(); 
        ViewResults viewResults = new ViewResults();
        ViewInjury viewInjury = new ViewInjury();
        
        Scanner sc = controlador.sc;

        System.out.println("Solo las opciones con asterisco se escuentran disponibles, En manteminiento");
        while (true) {
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                   MENU ADMINISTRADOR               ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            System.out.println("║  1. Gestionar equipos *                            ║");
            System.out.println("║  2. Gestionar jugadores *                          ║");
            System.out.println("║  3. Programación de partidos *                     ║");
            System.out.println("║  4. Registrar resultados de partidos  *            ║");
            System.out.println("║  5. Gestionar noticias y comunicados *             ║");
            System.out.println("║  6. Gestionar entrenadores *                       ║");
            System.out.println("║  7. Gestionar árbitros   *                         ║");
            System.out.println("║  8. Gestionar estadios *                           ║");
            System.out.println("║  9. Gestionar patrocinios                          ║");
            System.out.println("║ 10. Generar informes                               ║");
            System.out.println("║ 11. Generar incidentes o sanciones   *             ║");
            System.out.println("║ 12. Gestionar medios de comunicación               ║");
            System.out.println("║ 13. Gestionar transferencias de jugadores          ║");
            System.out.println("║ 14. Gestionar equipamientos                        ║");
            System.out.println("║ 15. Gestionar premios y reconocimientos            ║");
            System.out.println("║ 16. Gestionar usuarios y roles                     ║");
            System.out.println("║ 17. Gestionar relaciones públicas                  ║");
            System.out.println("║ 18. Salir del sistema *                            ║");
            System.out.println("╚════════════════════════════════════════════════════╝");

            int choice = Validation.leerNumero("Ingrese el número: ", sc);

            switch (choice) {
                case 1:
                    viewTeam.start();
                    break;
                case 2:
                    viewPlayer.start();
                    break;
                case 3:
                    viewSchedulingMatch.start();
                    break;
                case 4:
                    viewResults.registrarResultados();
                    break;
                case 5:
                    viewNews.start();
                    break;
                case 6:
                    gestionCoach.start();
                    break;
                case 7:
                    viewMenuReferee.start();
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
                viewInjury.start();
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
                   int choose =  Validation.leerNumero("¿Desea programar otro partido? (s/n): ", sc);
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
            System.out.print("Presione Enter para continuar...");
            sc.nextLine();
            
        }
    }
}
