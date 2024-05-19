package com.nuestrosparques.token.app.adapter.contrato.service;

import com.nuestrosparques.token.app.adapter.contrato.dto.ContratoDTO;

import java.util.List;

public interface ContratoService {

    List<ContratoDTO> getContratosPorRutForContract(Integer rut, String schema);
    List<ContratoDTO> getContratosPorRutForPay(Integer rut, String schema);
}
