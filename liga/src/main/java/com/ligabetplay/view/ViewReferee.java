package com.ligabetplay.view;

import java.util.Scanner;

import com.ligabetplay.Controller;


public class ViewReferee {
    public static void start() {
        Controller controlador = Controller.getInstance();
        Scanner sc = controlador.sc;
        Validation val = new Validation();

        while (true) {

            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                   MENU ARBITRO                     ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            System.out.println("║  1. Gestionar incidentes o sanciones               ║");
            System.out.println("║  2. Registro de resultados                         ║");
            System.out.println("║  3. Salir del sistema                              ║");
            System.out.println("╚════════════════════════════════════════════════════╝");

            int choice = val.leerNumero("Ingrese el número: ", sc);

            switch (choice) {
                case 1:
                    System.out.println("AUN EN ARREGLOS");

                    break;
                case 2:
                    System.out.println("AUN EN ARREGLOS");
                    break;
                case 3:
                int choose =  val.leerNumero("Estas seguro de salir? \n1. si\n2. no\n", sc);
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
