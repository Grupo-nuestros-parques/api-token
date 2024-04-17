package com.nuestrosparques.token.app.adapter.contrato.service;

import com.nuestrosparques.token.app.adapter.contrato.dto.ContratoDTO;

import java.util.List;

public interface ContratoService {

    List<ContratoDTO> getContratosPorRut(Integer rut, String schema);
}
