package com.nuestrosparques.token.app.adapter.agenda.response;

import java.io.Serializable;

public class TipoResponse implements Serializable {

    private String grupoPp;
    private String descripcionGrupo;
    private String subGrupoPp;

    public String getGrupoPp() {
        return grupoPp;
    }

    public void setGrupoPp(String grupoPp) {
        this.grupoPp = grupoPp;
    }

    public String getDescripcionGrupo() {
        return descripcionGrupo;
    }

    public void setDescripcionGrupo(String descripcionGrupo) {
        this.descripcionGrupo = descripcionGrupo;
    }

    public String getSubGrupoPp() {
        return subGrupoPp;
    }

    public void setSubGrupoPp(String subGrupoPp) {
        this.subGrupoPp = subGrupoPp;
    }
}
