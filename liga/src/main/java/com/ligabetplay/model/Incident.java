package com.ligabetplay.model;

public class Incident {
    private Integer id;
    private SchedulingMatch partido;
    private String descripcion;
    private int minuto;

    public Incident() {
    }

    public Incident(Integer id, SchedulingMatch partido, String descripcion, int minuto) {
        this.id = id;
        this.partido = partido;
        this.descripcion = descripcion;
        this.minuto = minuto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SchedulingMatch getPartido() {
        return partido;
    }

    public void setPartido(SchedulingMatch partido) {
        this.partido = partido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}
