package com.nuestrosparques.token.app.adapter.agenda.dto;

import java.io.Serializable;

public class ProductoInteresDTO implements Serializable {

    private String correlativo;
    private String email;
    private String codigoAgente;
    private String nombreContacto;
    private String apellidoPaternoContacto;
    private String apellidoMaternoContacto;
    private String rutContacto;
    private String dvContacto;
    private String direccionContacto;
    private String telefonoContacto;
    private String comentariosContacto;


    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoAgente() {
        return codigoAgente;
    }

    public void setCodigoAgente(String codigoAgente) {
        this.codigoAgente = codigoAgente;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidoPaternoContacto() {
        return apellidoPaternoContacto;
    }

    public void setApellidoPaternoContacto(String apellidoPaternoContacto) {
        this.apellidoPaternoContacto = apellidoPaternoContacto;
    }

    public String getApellidoMaternoContacto() {
        return apellidoMaternoContacto;
    }

    public void setApellidoMaternoContacto(String apellidoMaternoContacto) {
        this.apellidoMaternoContacto = apellidoMaternoContacto;
    }

    public String getRutContacto() {
        return rutContacto;
    }

    public void setRutContacto(String rutContacto) {
        this.rutContacto = rutContacto;
    }

    public String getDvContacto() {
        return dvContacto;
    }

    public void setDvContacto(String dvContacto) {
        this.dvContacto = dvContacto;
    }

    public String getDireccionContacto() {
        return direccionContacto;
    }

    public void setDireccionContacto(String direccionContacto) {
        this.direccionContacto = direccionContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getComentariosContacto() {
        return comentariosContacto;
    }

    public void setComentariosContacto(String comentariosContacto) {
        this.comentariosContacto = comentariosContacto;
    }
}

