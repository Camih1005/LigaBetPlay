package com.ligabetplay.model;

public class Activity {
    private Integer id;
    private String descripcion;
    private double duracion;

    public Activity() {
    }

    public Activity(Integer id, String descripcion, double duracion) {
        this.id = id;
        this.descripcion = descripcion;
        this.duracion = duracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}
