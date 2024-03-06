package com.nuestrosparques.token.app.adapter.portalplus.request;

import java.io.Serializable;

public class UpdateProfile implements Serializable {

    private String documentFile;
    private Integer rut;
    private String email;

    public String getDocumentFile() {
        return documentFile;
    }

    public void setDocumentFile(String documentFile) {
        this.documentFile = documentFile;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
