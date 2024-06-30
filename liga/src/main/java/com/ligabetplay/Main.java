package com.ligabetplay;


import java.util.Scanner;
import com.ligabetplay.model.*;
import com.ligabetplay.view.ViewAdmin;
import com.ligabetplay.view.SubViews.ViewCoach;




public class Main {

    public static void main(String[] args) {
        Controller controlador = Controller.getInstance();

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

                 
                    Rol[] roles = Rol.values();
                    for (Rol rol : roles) {
                        if (choice == rol.getId()) {
                            System.out.println("Rol seleccionado: " + rol);
                          
                            System.out.println("\nIniciar sesión como " + rol + ":");
                            System.out.println("Ingrese la contraseña:");
                            String password = scanner.nextLine();
                            if (validarCredenciales(rol, password)) {
                                System.out.println("Inicio de sesión exitoso como " + rol);
                                mostrarMenu(rol);
                            } else {
                                System.out.println("Contraseña incorrecta. Intenta nuevamente.");
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

    private static boolean validarCredenciales(Rol rol, String password) {
        return password.equals(Controller.getInstance().credenciales.get(rol));
    }

    private static void mostrarMenu(Rol rol) {
        switch (rol) {
            case ADMINISTRADOR:
            ViewAdmin.start();
                break;
            case EQUIPO_TECNICO:
            ViewCoach.start();
            System.out.println("AUN EN ARREGLOS");
                break;
            case ARBITRO:
            System.out.println("AUN EN ARREGLOS");
                break;
            case PERIODISTA:
            System.out.println("AUN EN ARREGLOS");
                break;
            case AFICIONADO:
            System.out.println("AUN EN ARREGLOS");
                break;
            default:
            System.out.println("Rol no reconocido.");
                break;
        }
    }


}
