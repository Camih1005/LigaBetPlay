package com.ligabetplay.view;

import java.util.Scanner;

public class Validation {

    public String leerdato(String msg, Scanner es) {
        String dato;
        while (true) {
            dato = "";
            try {
                System.out.print(msg);
                dato = es.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
            if (!dato.isEmpty()) {
                return dato;
            } else {
                System.out.println("El campo no puede ser vacío\n");
                continue;
            }
        }
    }

    public int leerNumero(String msg, Scanner es) {
        String dato;
        while (true) {
            dato = "";
            try {
                System.out.print(msg);
                dato = es.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }

            if (!IsInteger(dato)) {
                System.out.println("El campo no puede ser texto");
                continue;
            }
            if (!dato.isEmpty()) {
                return Integer.parseInt(dato);
            } else {
                System.out.println("El campo no puede ser vacío o ser menor o igual a cero\n");
                continue;
            }
        }
    }

    public static boolean IsInteger(String text) {
        try {
            int v = Integer.parseInt(text);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
