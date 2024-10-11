package com.nuestrosparques.token.app.adapter.agenda.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class EntrevistasAgendadasResponse implements Serializable {

    private Long id; // de la primera tabla
    private InformeAgenteResponse informeAgente; // nuevo campo de tipo InformeAgente
    private LocalDateTime fechaEntrevista;
    private String estadoEntrevista; // de la primera tabla
    private LocalDateTime fechaCreacion; // de la primera tabla
    private LocalDateTime fechaActualizacion; // de la primera tabla

    // Getters y Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InformeAgenteResponse getInformeAgente() {
        return informeAgente;
    }

    public void setInformeAgente(InformeAgenteResponse informeAgente) {
        this.informeAgente = informeAgente;
    }

    public LocalDateTime getFechaEntrevista() {
        return fechaEntrevista;
    }

    public void setFechaEntrevista(LocalDateTime fechaEntrevista) {
        this.fechaEntrevista = fechaEntrevista;
    }

    public String getEstadoEntrevista() {
        return estadoEntrevista;
    }

    public void setEstadoEntrevista(String estadoEntrevista) {
        this.estadoEntrevista = estadoEntrevista;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}

