package com.ligabetplay.model;

import java.util.Date;

public class Injury {
    private Integer id;
    private Player jugador;
    private String lesion;
    private String gravedad;
    private Date fechaInicion;
    private Date fechaFinalizacion;
    
    public Injury() {
    }

    public Injury(Integer id, Player jugador, String lesion, String gravedad, Date fechaInicion,
            Date fechaFinalizacion) {
        this.id = id;
        this.jugador = jugador;
        this.lesion = lesion;
        this.gravedad = gravedad;
        this.fechaInicion = fechaInicion;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getJugador() {
        return jugador;
    }

    public void setJugador(Player jugador) {
        this.jugador = jugador;
    }

    public String getLesion() {
        return lesion;
    }

    public void setLesion(String lesion) {
        this.lesion = lesion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public Date getFechaInicion() {
        return fechaInicion;
    }

    public void setFechaInicion(Date fechaInicion) {
        this.fechaInicion = fechaInicion;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}


