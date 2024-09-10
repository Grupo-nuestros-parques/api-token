package com.nuestrosparques.token.app.adapter.agenda.response;

import java.io.Serializable;
import java.util.Date;

public class OrigenResponse implements Serializable {

    private String tipVenta;
    private String descripcion;
    private String grupoPp;

    public String getTipVenta() {
        return tipVenta;
    }

    public void setTipVenta(String tipVenta) {
        this.tipVenta = tipVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGrupoPp() {
        return grupoPp;
    }

    public void setGrupoPp(String grupoPp) {
        this.grupoPp = grupoPp;
    }
}
