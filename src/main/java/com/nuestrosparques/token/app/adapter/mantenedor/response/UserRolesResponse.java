package com.nuestrosparques.token.app.adapter.mantenedor.response;

import java.sql.Timestamp;
import java.util.List;

public class UserRolesResponse {

    private Rut rut;

    private String nombre;

    private List<Role> role;

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}