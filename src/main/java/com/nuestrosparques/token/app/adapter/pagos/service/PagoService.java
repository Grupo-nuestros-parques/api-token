package com.nuestrosparques.token.app.adapter.pagos.service;

import com.nuestrosparques.token.app.adapter.pagos.dto.PagosDTO;

import java.util.List;

public interface PagoService {

    List<PagosDTO> getUltimosPagosPorContrato(String base, String serie, String numero, String schema);
}
