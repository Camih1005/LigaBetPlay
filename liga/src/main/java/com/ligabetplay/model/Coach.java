package com.ligabetplay.model;

public class Coach extends Person {
    private int idFederacion;

    public Coach(){
        super();
    }

    public Coach(int idFederacion) {
        this.idFederacion = idFederacion;
    }

    public Coach(String id, String nombre, int idFederacion) {
        super(id, nombre);
        this.idFederacion = idFederacion;
    }

    public int getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(int idFederacion) {
        this.idFederacion = idFederacion;
    }
    
}