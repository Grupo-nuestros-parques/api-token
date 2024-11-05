package com.nuestrosparques.token.app.adapter.agenda.request;

public class ActualizarEntrevistaRequest {
    private String informeAgenteId;
    private String FechaEntrevista;

    public String getInformeAgenteId() {
        return informeAgenteId;
    }

    public void setInformeAgenteId(String informeAgenteId) {
        this.informeAgenteId = informeAgenteId;
    }

    public String getFechaEntrevista() {
        return FechaEntrevista;
    }

    public void setFechaEntrevista(String FechaEntrevista) {
        this.FechaEntrevista = FechaEntrevista;
    }
}
