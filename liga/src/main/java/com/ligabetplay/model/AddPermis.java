package com.ligabetplay.model;

import java.util.ArrayList;
import java.util.List;

public class AddPermis {
    private static List<Permiso> listaPermisos = new ArrayList<>();

    public static List<Permiso> agg() {
        listaPermisos.add(new Permiso(1, "Gestión de Equipos"));
        listaPermisos.add(new Permiso(2, "Gestión de Jugadores"));
        listaPermisos.add(new Permiso(3, "Programación de Partidos"));
        
        return listaPermisos;
    }

    public static void addPermisoToRol(Rol rol, List<Permiso> permisos) {
        System.out.println("Asignando permisos al rol " + rol + " (ID: " + rol.getId() + "):");
        for (Permiso permiso : permisos) {
            System.out.println("- " + permiso.getDescripcion());
        }

        // Asignar permisos basados en el rol.
        switch (rol) {
            case ADMINISTRADOR:
                // Asignar permisos específicos a ADMINISTRADOR
                System.out.println("permiso = " + rol.getId());
                break;
            case EQUIPO_TECNICO:
            System.out.println("permiso = " + rol.getId());
                break;
           
            default:
                break;
        }
    }
}
