package com.nuestrosparques.token.app.adapter.tracking.response;

import java.util.Date;

public class TrackingResponse {

    private Long id;

    private String nombreFuncion;

    private Integer rut;

    private String tokenSession;

    private String nombreCompletoAgente;

    private Date createdAt;

    private String formattedCreatedAt; // Nuevo campo para almacenar la fecha formateada

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getTokenSession() {
        return tokenSession;
    }

    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getNombreCompletoAgente() {
        return nombreCompletoAgente;
    }

    public void setNombreCompletoAgente(String nombreCompletoAgente) {
        this.nombreCompletoAgente = nombreCompletoAgente;
    }

    public String getFormattedCreatedAt() {
        return formattedCreatedAt;
    }

    public void setFormattedCreatedAt(String formattedCreatedAt) {
        this.formattedCreatedAt = formattedCreatedAt;
    }
}
