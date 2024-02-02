package com.nuestrosparques.token.app.adapter.qr.response;

import java.io.Serializable;

public class CrematorioResponse implements Serializable {

    private String description;
    private String ctto;
    private String estado;
    private String labels;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCtto() {
        return ctto;
    }

    public void setCtto(String ctto) {
        this.ctto = ctto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
}
