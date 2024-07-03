package com.nuestrosparques.token.app.adapter.mantenedor.response;

import java.sql.Timestamp;

public class AsignacionRolesResponse {

    private Long id;

    private Rut rutAsignador;

    private Rut rutAsignado;

    private Role role;

    private Timestamp fechaAsignacion;

    private Timestamp fechaRevocacion;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rut getRutAsignador() {
        return rutAsignador;
    }

    public void setRutAsignador(Rut rutAsignador) {
        this.rutAsignador = rutAsignador;
    }

    public Rut getRutAsignado() {
        return rutAsignado;
    }

    public void setRutAsignado(Rut rutAsignado) {
        this.rutAsignado = rutAsignado;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Timestamp getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Timestamp fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Timestamp getFechaRevocacion() {
        return fechaRevocacion;
    }

    public void setFechaRevocacion(Timestamp fechaRevocacion) {
        this.fechaRevocacion = fechaRevocacion;
    }
}
