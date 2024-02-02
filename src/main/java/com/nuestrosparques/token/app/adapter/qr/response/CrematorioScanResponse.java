package com.nuestrosparques.token.app.adapter.qr.response;

import java.io.Serializable;

public class CrematorioScanResponse implements Serializable {

    private String descrionEstado;
    private String cambio;
    private String estado;
    private String respuesta;

    public String getDescrionEstado() {
        return descrionEstado;
    }

    public void setDescrionEstado(String descrionEstado) {
        this.descrionEstado = descrionEstado;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
