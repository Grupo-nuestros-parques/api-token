package com.nuestrosparques.token.app.adapter.boleta.service;

import com.nuestrosparques.token.app.adapter.boleta.dto.DteDto;
import com.nuestrosparques.token.app.adapter.boleta.response.BoletaResponse;

public interface BoletaService {

    DteDto getDte(Integer folio, Integer tipoDocumento, Integer rutEmrpesa);
    BoletaResponse getBoletaByRut(Integer rut);
}
