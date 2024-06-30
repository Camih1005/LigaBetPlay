package com.ligabetplay.model;
import com.ligabetplay.Interface.TipoTarjeta;

public class Card {
    private Integer id;
    private Player jugador;
    private SchedulingMatch partido;
    private TipoTarjeta tipo;
    private Integer minuto;

    public Card() {
    }

    public Card(Integer id, Player jugador, SchedulingMatch partido, TipoTarjeta tipo, Integer minuto) {
        this.id = id;
        this.jugador = jugador;
        this.partido = partido;
        this.tipo = tipo;
        this.minuto = minuto;
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

    public SchedulingMatch getPartido() {
        return partido;
    }

    public void setPartido(SchedulingMatch partido) {
        this.partido = partido;
    }

    public TipoTarjeta getTipo() {
        return tipo;
    }

    public void setTipo(TipoTarjeta tipo) {
        this.tipo = tipo;
    }

    public Integer getMinuto() {
        return minuto;
    }

    public void setMinuto(Integer minuto) {
        this.minuto = minuto;
    }    
}


