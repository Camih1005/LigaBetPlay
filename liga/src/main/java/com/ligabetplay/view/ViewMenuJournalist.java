package com.ligabetplay.view;

import java.util.Scanner;

import com.ligabetplay.Controller;

public class ViewMenuJournalist {

    public static void start() {
        Controller controlador = Controller.getInstance();
        Scanner sc = controlador.sc;
        while (true) {
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                   MENU PERIODISTA                  ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            System.out.println("║  1. Visualización de Estadísticas                  ║");
            System.out.println("║  2. Gestiónar de Noticias y Comunicados            ║");
            System.out.println("║  3. Consultar calendario de partidos               ║");
            System.out.println("║  4. Gestionar medios de comunicacion               ║");
            System.out.println("║  5. Gestionar relaciones públicas                  ║");
            System.out.println("║  6. Salir del sistema                              ║");
            System.out.println("╚════════════════════════════════════════════════════╝");

            int choice = Validation.leerNumero("Ingrese el número: ", sc);

            switch (choice) {
                case 1:
                System.out.println("AUN EN ARREGLOS");
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
                int choose =  Validation.leerNumero("Estas seguro de salir? \n1. si\n2. no\n", sc);
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
