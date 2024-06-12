package com.nuestrosparques.token.app.adapter.pagos.service;

import com.nuestrosparques.token.app.adapter.pagos.dto.CuponesDTO;
import com.nuestrosparques.token.app.adapter.pagos.dto.PagosDTO;
import com.nuestrosparques.token.app.adapter.pagos.dto.RezagosDTO;

import java.util.List;

public interface PagoService {

    List<PagosDTO> getUltimosPagosPorContrato(String base, String serie, String numero, String schema);
    List<CuponesDTO> getCuponesPendientesPorRut(String rut, Integer limitE, Integer limitF, String schema);
    List<CuponesDTO> getCuponesFuturosPorRut(String rut, Integer limitE, Integer limitF, String schema);
    List<RezagosDTO> getRezagosPorRut(String rut, String schema);
}
