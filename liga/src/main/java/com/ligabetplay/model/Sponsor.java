package com.ligabetplay.model;

import java.util.Date;

public class Sponsor {
    private Integer id;
    private String nombre;
    private String tipoPatrocinio;
    private Double monto;
    private Date fechaInicio;
    private Date fechaFin;

    public Sponsor() {
    }

    public Sponsor(Integer id, String nombre, String tipoPatrocinio, Double monto, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.tipoPatrocinio = tipoPatrocinio;
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoPatrocinio() {
        return tipoPatrocinio;
    }

    public void setTipoPatrocinio(String tipoPatrocinio) {
        this.tipoPatrocinio = tipoPatrocinio;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
