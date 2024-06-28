package com.ligabetplay.model;

import java.util.Date;
import java.util.List;

public class Announcement {
    private Integer id;
    private String titulo;
    private String contenido;
    private Date fechaPublicacion;
    private List <User> destinatarios;

    public Announcement() {
    }

    public Announcement(Integer id, String titulo, String contenido, Date fechaPublicacion, List<User> destinatarios) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
        this.destinatarios = destinatarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public List<User> getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(List<User> destinatarios) {
        this.destinatarios = destinatarios;
    }
}
