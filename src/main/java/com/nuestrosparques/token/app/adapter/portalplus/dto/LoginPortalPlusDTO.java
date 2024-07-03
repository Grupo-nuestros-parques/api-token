package com.nuestrosparques.token.app.adapter.portalplus.dto;

import java.io.Serializable;
import java.util.List;

public class LoginPortalPlusDTO implements Serializable {

    private boolean trabajadorExiste;
    private AgenteResponse agentes;
    private boolean primerLogin;
    private String schema;
    private String tokenSession;
    private List<String> roles;


    public boolean isTrabajadorExiste() {
        return trabajadorExiste;
    }

    public void setTrabajadorExiste(boolean trabajadorExiste) {
        this.trabajadorExiste = trabajadorExiste;
    }

    public AgenteResponse getAgentes() {
        return agentes;
    }

    public void setAgentes(AgenteResponse agentes) {
        this.agentes = agentes;
    }

    public boolean isPrimerLogin() {
        return primerLogin;
    }

    public void setPrimerLogin(boolean primerLogin) {
        this.primerLogin = primerLogin;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTokenSession() {
        return tokenSession;
    }

    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
