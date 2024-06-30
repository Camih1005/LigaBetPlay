package com.ligabetplay.model;

import java.time.format.DateTimeFormatter;

public class SchedulingMatch {
    private Team equipoLocal;
    private Team equipoVisitante;
    private DateTimeFormatter fecha;
    private Stadium estadio;

    public SchedulingMatch() {

    }

    public SchedulingMatch(Team equipoLocal, Team equipoVisitante, DateTimeFormatter fecha, Stadium estadio) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.estadio = estadio;
    }

    public Team getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Team equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Team getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Team equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public DateTimeFormatter getFecha() {
        return fecha;
    }

    public void setFecha(DateTimeFormatter fecha) {
        this.fecha = fecha;
    }

    public Stadium getEstadio() {
        return estadio;
    }

    public void setEstadio(Stadium estadio) {
        this.estadio = estadio;
    }

}
