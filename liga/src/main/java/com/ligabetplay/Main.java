package com.ligabetplay;

import java.util.Scanner;
import com.ligabetplay.model.*;
import com.ligabetplay.view.Validation;
import com.ligabetplay.view.ViewMenuAdmin;

import com.ligabetplay.view.ViewMenuFan;
import com.ligabetplay.view.ViewMenuJournalist;
import com.ligabetplay.view.ViewMenuReferee;
import com.ligabetplay.view.SubViews.ViewCoach;


public class Main {

    public static void main(String[] args) {
        Controller controlador = Controller.getInstance();
        Scanner sc = controlador.sc;
        while (true) {
            System.out.println("Contraseña admin : admin123");
            System.out.println("1. Ingresar como ADMINISTRADOR");
            System.out.println("2. Ingresar como EQUIPO TECNICO");
            System.out.println("3. Ingresar como ARBITRO");
            System.out.println("4. Ingresar como PERIODISTA");
            System.out.println("5. Ingresar como AFICIONADO");

            try (sc) {

                int choice = Validation.leerNumero("Ingrese el número: ", sc);

                Rol[] roles = Rol.values();
                for (Rol rol : roles) {
                    if (choice == rol.getId()) {
                        System.out.println("Rol seleccionado: " + rol);

                        System.out.println("\nIniciar sesión como " + rol + ":");
                        System.out.println("Ingrese la contraseña:");
                        String password = sc.nextLine();
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
                ViewMenuAdmin.start();
                break;
            case EQUIPO_TECNICO:
                ViewCoach.start();
                break;
            case ARBITRO:
                ViewMenuReferee.start();
                break;
            case PERIODISTA:
                ViewMenuJournalist.start();
                break;
            case AFICIONADO:
                ViewMenuFan.start();
                break;
            default:
                System.out.println("Rol no reconocido.");
                break;
        }
    }

    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

