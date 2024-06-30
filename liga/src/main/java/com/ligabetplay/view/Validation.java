package com.ligabetplay.view;

import java.util.Scanner;

public class Validation{

      public String leerdato(String msg, Scanner es) {
        String dato;
        while (true) {
            dato = "";
            try {
                System.out.print(msg);
                dato =es.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
            if (dato != "") {
                return dato;
            } else {
                System.out.println("El campo no puede ser vacio\n");
                continue;
            }
        }
    }

    public  Integer leerNumero(String msg, Scanner es) {
        String dato;
        while (true) {
             dato = "";
            try {
                System.out.print(msg);
                dato = es.nextLine();
            } catch (Exception e) {
                System.out.println(e);                
            }


            if(IsInteger(dato)==false){
                System.out.println("El campo no puede ser texto");
                continue;
            }
            if (dato !="") {
                return Integer.parseInt(dato);
            } else {
                System.out.println("El campo no puede ser vacio o ser menor o igual a cero\n");
                continue;
            }
        }
    }

    public static boolean IsInteger(String text) {
        try {
            int v=0;
            v=Integer.parseInt(text);
          return true;
        } catch (NumberFormatException ex) {
           return false;
        }
    }

}
