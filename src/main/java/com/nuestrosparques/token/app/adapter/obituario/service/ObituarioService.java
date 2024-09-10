package com.nuestrosparques.token.app.adapter.obituario.service;

import com.nuestrosparques.token.app.adapter.obituario.dto.ObituarioCrematorioDTO;
import com.nuestrosparques.token.app.adapter.obituario.dto.ObituarioDTO;

import java.util.List;

public interface ObituarioService {

    List<ObituarioDTO> obtenerTodosObituariosPorFechaYParque(String fechaInicio, String fechaFin, Integer parque);
    List<ObituarioCrematorioDTO> encontrarTodosObiturariosCinerario(String fechaInicio, String fechaFin);
}