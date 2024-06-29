package com.ligabetplay.view;

import java.util.Scanner;

import com.ligabetplay.Controller;

public class ViewAdmin {

    public static void start() {

        Validation val = new Validation();
        Controller controlador = Controller.getInstance();
        Scanner sc = controlador.sc;

        while (true) {
            System.out.println("1. Gestionar equipos");
            System.out.println("2. Gestionar estadios");
            System.out.println("3. Gestionar entrenadores");
            System.out.println("4. Gestionar boleteria");

            int choice = val.leerNumero("ingrese el numero: ",sc);






            
        }

    }

}
