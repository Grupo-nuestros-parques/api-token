package com.nuestrosparques.token.app.adapter.encargados.response;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private String mensaje;
    private String usuarioConsulta;
    private boolean loginValid;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuarioConsulta() {
        return usuarioConsulta;
    }

    public void setUsuarioConsulta(String usuarioConsulta) {
        this.usuarioConsulta = usuarioConsulta;
    }

    public boolean isLoginValid() {
        return loginValid;
    }

    public void setLoginValid(boolean loginValid) {
        this.loginValid = loginValid;
    }
}
