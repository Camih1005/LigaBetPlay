package com.ligabetplay.model;

import java.util.ArrayList;
import java.util.List;

public enum Rol {
    ADMINISTRADOR(1),
    EQUIPO_TECNICO(2),
    ARBITRO(3),
    PERIODISTA(4),
    AFICIONADO(5),
   

    private final int id;
    private final List<Permiso> permisos;

    Rol(int id) {
        this.id = id;
        this.permisos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void addPermiso(Permiso permiso) {
        permisos.add(permiso);
    }
}
