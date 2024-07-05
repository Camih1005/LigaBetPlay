package com.ligabetplay.model;

public class Referee extends Person {
    private String experiencia;

    public Referee() {
        super();
    }

    public Referee(String experiencia) {
        this.experiencia = experiencia;
    }

    public Referee(int id, String nombre, String experiencia) {
        super(id, nombre);
        this.experiencia = experiencia;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    
}