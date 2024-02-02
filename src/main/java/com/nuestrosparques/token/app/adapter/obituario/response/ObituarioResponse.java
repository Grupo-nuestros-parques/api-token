package com.nuestrosparques.token.app.adapter.obituario.response;

import java.io.Serializable;
import java.util.Date;

public class ObituarioResponse implements Serializable {

    private Integer base;
    private String hora;
    private String nombreFallecido;
    private String apellidoPaternoFallecido;
    private String apellidoMaternoFallecido;
    private String minutos;
    private String velatorio;
    private String rutFallecido;
    private String dvFallecido;
    private String lugarInicioCeremonia;
    private String sector;
    private String area;
    private String capillaVelatoria;
    private String direccionCapilla;
    private String sepultura;
    private Integer codigoParque;
    private String latitud;
    private String longitud;
    private Date fechaNacimiento;
    private Date fechaDefuncion;
    private Date fechaSepultacion;

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombreFallecido() {
        return nombreFallecido;
    }

    public void setNombreFallecido(String nombreFallecido) {
        this.nombreFallecido = nombreFallecido;
    }

    public String getApellidoPaternoFallecido() {
        return apellidoPaternoFallecido;
    }

    public void setApellidoPaternoFallecido(String apellidoPaternoFallecido) {
        this.apellidoPaternoFallecido = apellidoPaternoFallecido;
    }

    public String getApellidoMaternoFallecido() {
        return apellidoMaternoFallecido;
    }

    public void setApellidoMaternoFallecido(String apellidoMaternoFallecido) {
        this.apellidoMaternoFallecido = apellidoMaternoFallecido;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public String getVelatorio() {
        return velatorio;
    }

    public void setVelatorio(String velatorio) {
        this.velatorio = velatorio;
    }

    public String getRutFallecido() {
        return rutFallecido;
    }

    public void setRutFallecido(String rutFallecido) {
        this.rutFallecido = rutFallecido;
    }

    public String getDvFallecido() {
        return dvFallecido;
    }

    public void setDvFallecido(String dvFallecido) {
        this.dvFallecido = dvFallecido;
    }

    public String getLugarInicioCeremonia() {
        return lugarInicioCeremonia;
    }

    public void setLugarInicioCeremonia(String lugarInicioCeremonia) {
        this.lugarInicioCeremonia = lugarInicioCeremonia;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCapillaVelatoria() {
        return capillaVelatoria;
    }

    public void setCapillaVelatoria(String capillaVelatoria) {
        this.capillaVelatoria = capillaVelatoria;
    }

    public String getDireccionCapilla() {
        return direccionCapilla;
    }

    public void setDireccionCapilla(String direccionCapilla) {
        this.direccionCapilla = direccionCapilla;
    }

    public String getSepultura() {
        return sepultura;
    }

    public void setSepultura(String sepultura) {
        this.sepultura = sepultura;
    }

    public Integer getCodigoParque() {
        return codigoParque;
    }

    public void setCodigoParque(Integer codigoParque) {
        this.codigoParque = codigoParque;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(Date fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public Date getFechaSepultacion() {
        return fechaSepultacion;
    }

    public void setFechaSepultacion(Date fechaSepultacion) {
        this.fechaSepultacion = fechaSepultacion;
    }
}
