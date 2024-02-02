package com.nuestrosparques.token.app.request;

import java.io.Serializable;

public class CrematorioScanRequest implements Serializable {

    private Integer folio;
    private Integer cliente;
    private String userc;

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public String getUserc() {
        return userc;
    }

    public void setUserc(String userc) {
        this.userc = userc;
    }
}
