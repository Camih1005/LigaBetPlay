package com.ligabetplay.model;

public class Result {
    private Integer id;
    private SchedulingMatch partido;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;

    public Result() {
    }

    public Result(Integer id, SchedulingMatch partido, int golesEquipoLocal, int golesEquipoVisitante) {
        this.id = id;
        this.partido = partido;
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
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
