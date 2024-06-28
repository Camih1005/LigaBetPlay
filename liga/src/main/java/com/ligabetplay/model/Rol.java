package com.ligabetplay.model;

public enum Rol {
    ADMINISTRADOR(1),
    EQUIPO_TECNICO(2),
    ARBITRO(3),
    PERIODISTA(4),
    AFICIONADO(5);

    private final int id;

    Rol(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}