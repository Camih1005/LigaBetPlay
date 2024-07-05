package com.ligabetplay.model;

import java.util.ArrayList;
import java.util.List;

public class Player extends Person{
    private int edad;
    private String posicion;
    private String nacionalidad;
    private int numeroCamiseta;
    private Team equipo;
    private List<Injury> lstLesiones;
    private List<Performance> lstRendimientos;
    
    public Player() {
        super();
        lstLesiones = new ArrayList<Injury>();
        lstRendimientos = new ArrayList<Performance>();
    }

    public Player(int id, String nombre, int edad, String posicion, String nacionalidad, int numeroCamiseta,
            Team equipo, List<Injury> lstLesiones, List<Performance> lstRendimientos) {
        super(id, nombre);
        this.edad = edad;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.numeroCamiseta = numeroCamiseta;
        this.equipo = equipo;
        this.lstLesiones = lstLesiones;
        this.lstRendimientos = lstRendimientos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public Team getEquipo() {
        return equipo;
    }

    public void setEquipo(Team equipo) {
        this.equipo = equipo;
    }

    public List<Injury> getLstLesiones() {
        return lstLesiones;
    }

    public void setLstLesiones(Injury injury) {
        this.lstLesiones.add(injury);
    }

    public List<Performance> getLstRendimientos() {
        return lstRendimientos;
    }

    public void setLstRendimientos(Performance performance) {
        this.lstRendimientos.add(performance);
    }

    @Override
    public String toString() {
        return "Player [equipo=" + equipo + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getPosicion()="
                + getPosicion() + ", getNumeroCamiseta()=" + getNumeroCamiseta() + "]";
    }
}
