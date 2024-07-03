package com.ligabetplay.model;

import java.util.List;

public class Result {
    private Integer id;
    private SchedulingMatch partido;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private List<Goal> lstGoles;
    private List<Card> lstTarjetas;
    private List<Incident> lstIncidentes;
    
    public Result() {
    }

   

    public Result(Integer id, SchedulingMatch partido, int golesEquipoLocal, int golesEquipoVisitante,
            List<Goal> lstGoles, List<Card> lstTarjetas, List<Incident> lstIncidentes) {
        this.id = id;
        this.partido = partido;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
        this.lstGoles = lstGoles;
        this.lstTarjetas = lstTarjetas;
        this.lstIncidentes = lstIncidentes;
    }

    public List<Goal> getLstGoles() {
        return lstGoles;
    }

    public void setLstGoles(Goal goal) {
        this.lstGoles.add(goal);
    }

    public List<Card> getLstTarjetas() {
        return lstTarjetas;
    }

    public void setLstTarjetas(List<Card> lstTarjetas) {
        this.lstTarjetas = lstTarjetas;
    }

    public List<Incident> getLstIncidentes() {
        return lstIncidentes;
    }

    public void setLstIncidentes(List<Incident> lstIncidentes) {
        this.lstIncidentes = lstIncidentes;
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

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    

    

}
