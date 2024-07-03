package com.ligabetplay.model;

public class Referee extends Person {
    private String experiencia;


    public Referee() {
        super();
    }

    public Referee(int id, String nombre, String Experiencia) {
        super(id, nombre);
        experiencia = Experiencia;
    }
    
    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

}
