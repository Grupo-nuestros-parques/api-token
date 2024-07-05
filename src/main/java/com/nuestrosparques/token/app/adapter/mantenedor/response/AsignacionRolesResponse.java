package com.nuestrosparques.token.app.adapter.mantenedor.response;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class AsignacionRolesResponse {

    private Long id;

    private Rut rutAsignador;

    private Rut rutAsignado;

    private Role role;

    private Timestamp fechaAsignacion;

    private Timestamp fechaRevocacion;

    // Agregamos un formateador para las fechas
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


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

    // Modificamos el getter de fechaAsignacion para devolver la fecha formateada
    public String getFechaAsignacion() {
        // Verificamos si fechaAsignacion es null antes de formatear
        return fechaAsignacion != null ? formatter.format(fechaAsignacion) : null;
    }

    public void setFechaAsignacion(Timestamp fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    // Modificamos el getter de fechaRevocacion para devolver la fecha formateada
    public String getFechaRevocacion() {
        // Verificamos si fechaRevocacion es null antes de formatear
        return fechaRevocacion != null ? formatter.format(fechaRevocacion) : null;
    }

    public void setFechaRevocacion(Timestamp fechaRevocacion) {
        this.fechaRevocacion = fechaRevocacion;
    }
}
