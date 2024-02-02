package com.nuestrosparques.token.app.adapter.uf.response;

import java.io.Serializable;
import java.util.Date;

public class Uf implements Serializable {
    private Date date;

    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
