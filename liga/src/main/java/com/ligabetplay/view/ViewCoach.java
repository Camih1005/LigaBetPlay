package com.ligabetplay.view;

import java.util.Scanner;

import com.ligabetplay.Controller;
import com.ligabetplay.view.SubViews.ViewPlayer;

public class ViewCoach {


    public static void start(){
        Controller controlador = Controller.getInstance();
        ViewPlayer viewPlayer = new ViewPlayer();
        Validation val = new Validation();
        Scanner sc = controlador.sc;

        while (true) {
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                   MENU EQUIPO TECNICO              ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            System.out.println("║  1. Gestionar jugadores                            ║");
            System.out.println("║  2. Visualizacion de estadisticas                  ║");
            System.out.println("║  3. Gestionar entrenadores                         ║");
            System.out.println("║  4. Generar informes                               ║");            
            System.out.println("║  5. Consultar calendario de partidos               ║");
            System.out.println("║  6. Gestionar lesiones de los jugadores            ║");
            System.out.println("║  7. Gestionar entrenamientos                       ║");
            System.out.println("║  8. Seguimiento de rendimiento de jugadores        ║");
            System.out.println("║  9. Gestionar de equipamiento                      ║");
            System.out.println("║ 10. Gestionar de convocatorias de jugadores        ║");
            System.out.println("║ 11. Salir del sistema                              ║");
            System.out.println("╚════════════════════════════════════════════════════╝");
        
        
            int choice = val.leerNumero("Ingrese el número: ", sc);
        
            switch (choice) {
                case 1:
                    viewPlayer.start();
                    break;
                case 2:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 3:
                System.out.println("AUN EN ARREGLOS");
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
                System.out.println("AUN EN ARREGLOS");
                case 9:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 10:
                System.out.println("AUN EN ARREGLOS");
                    break;
                case 11:
                int choose =  val.leerNumero("Estas seguro de salir? \n1. si\n2. no\n", sc);
                   System.out.println("Elije la opcion: \n");
                    if (choose == 1) {
                        System.out.println("Que tenga un buen dia");
                        return;
                    }else{
                        continue;
                    }
                    
                default:
                    break;
            }
        
        
        }


    }


}
