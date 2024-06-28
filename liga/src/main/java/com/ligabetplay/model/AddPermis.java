package com.ligabetplay.model;

import java.util.ArrayList;
import java.util.List;
public class AddPermis {
    static List<Permiso> listaPermisos = new ArrayList<>();
    public static List<Permiso> agg() {
        
        listaPermisos.add(new Permiso(1, "Permiso de administración"));
        listaPermisos.add(new Permiso(2, "Permiso de lectura"));
        listaPermisos.add(new Permiso(3, "Permiso de edición"));
        return listaPermisos;
    }

    public static void addPermisoToRol(Rol rol, List<Permiso> permisos) {
        System.out.println("Asignando permisos al rol " + rol + " (ID: " + rol.getId() + "):");
      
        for (Permiso permiso : permisos) {
            System.out.println("- " + permiso.getDescripcion());
        }
        
        switch (rol.getId()) {
            case 1:
                System.out.println("El usuario " + rol + " Tipo de permiso numero");
                break;

            case 2:
            System.out.println("El usuario " + rol + " Tipo de permiso numero");   
            break;

            case 3:

            System.out.println("El usuario " + rol + " Tipo de permiso numero");

            break;
            default:
                break;
        }

    }
}