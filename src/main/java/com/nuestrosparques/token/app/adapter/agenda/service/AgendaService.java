package com.nuestrosparques.token.app.adapter.agenda.service;

import com.nuestrosparques.token.app.adapter.agenda.dto.CiudadDTO;
import com.nuestrosparques.token.app.adapter.agenda.dto.OrigenDTO;
import com.nuestrosparques.token.app.adapter.agenda.dto.TipoDTO;
import com.nuestrosparques.token.app.adapter.agenda.dto.ComunaDTO;

import java.util.List;

public interface AgendaService {
    List<OrigenDTO> getOriginList();
    List<TipoDTO> getTipoList(String idSub);
    List<CiudadDTO> getCiudadesList();
    List<ComunaDTO> getComunasList(String idCiudad);
    Integer registrarContacto(
            String codigoAgente,
            String nombreContacto,
            String apellidoPaternoContacto,
            String apellidoMaternoContacto,
            String rutContacto,
            String dvContacto,
            String direccionContacto,
            String telefonoContacto,
            String emailContacto
    );

    void registrarIntento(
            String codigoAgente,
            String idOrigin,
            String idTypeGrupoPp,
            String idTypeSubGrupoPp,
            String idCity,
            String idComuna,
            String exitoso
    );
}