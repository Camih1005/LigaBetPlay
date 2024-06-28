package com.ligabetplay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.ligabetplay.model.*;
import com.ligabetplay.view.viewTeam;

public class Main {

  
    private static final Map<Rol, String> credenciales = new HashMap<>();

 

    static {
        // Credenciales predefinidas para cada rol (en un sistema real, estas credenciales deberían ser gestionadas de manera segura)
        credenciales.put(Rol.ADMINISTRADOR, "admin123");
        credenciales.put(Rol.EQUIPO_TECNICO, "tecnico123");
        credenciales.put(Rol.ARBITRO, "arbitro123");
        credenciales.put(Rol.PERIODISTA, "periodista123");
        credenciales.put(Rol.AFICIONADO, "aficionado123");
    }

    public static void main(String[] args) {

        viewTeam vt = new viewTeam();

        vt.gestionEquipo();

        int saveNum;
        while (true) {
            System.out.println("1. Ingresar como ADMINISTRADOR");
            System.out.println("2. Ingresar como EQUIPO TECNICO");
            System.out.println("3. Ingresar como ARBITRO");
            System.out.println("4. Ingresar como PERIODISTA");
            System.out.println("5. Ingresar como AFICIONADO");
            System.out.println("\nIngresa un número:");

            try (Scanner scanner = new Scanner(System.in)) {
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    System.out.println("Elegiste el número: " + choice);
                    scanner.nextLine();

                    List<Permiso> permisos = AddPermis.agg();
                    Rol[] roles = Rol.values();
                    for (Rol rol : roles) {
                        if (choice == rol.getId()) {
                            saveNum = choice;
                            System.out.println("Rol seleccionado: " + rol);
                            AddPermis.addPermisoToRol(rol, permisos);
                            
                            //  inicio de sesión
                            System.out.println("\nIniciar sesión como " + rol + ":");
                            System.out.println("Ingrese la contraseña:");

                            String password = scanner.nextLine();
                            if (validarCredenciales(rol, password)) {
                                System.out.println("Inicio de sesión exitoso como " + rol);
                                //redirigir a la funcionalidad correspondiente al rol
                                // menu dependiendo del rol
                            } else {
                                System.out.println("Contraseña incorrecta. Intenta nuevamente.");
                                return;
                            }
                            return;
                        }
                    }
                    System.out.println("Rol seleccionado no válido.");
                } else {
                    System.out.println("Número ingresado incorrecto");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("Intento fallido");
        }
    }

    // Método para validar las credenciales ingresadas
    private static boolean validarCredenciales(Rol rol, String password) {
        return password.equals(credenciales.get(rol));
    }
}
