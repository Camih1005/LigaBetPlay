package com.ligabetplay;




import java.util.List;
import java.util.Scanner;

import com.ligabetplay.model.*;


public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Ingresar como ADMINISTRADOR");
            System.out.println("2. Ingresar como EQUIPO TECNICO");
            System.out.println("3. Ingresar como ARBITRO");
            System.out.println("4. Ingresar como PERIODISTA");
            System.out.println("5. Ingresar como AFICIONADO");
            System.out.println("\nIngresa un numero: \n");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                List<Permiso> permisos = AddPermis.agg();
             Rol rol = Rol.ARBITRO;
                AddPermis.addPermisoToRol(rol, permisos);
            }
            else{
                System.out.println("Ingreso mal el numero");
            }
        }
    }
    }