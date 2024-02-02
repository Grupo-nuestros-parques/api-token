package com.nuestrosparques.token.app.adapter.fallecidos.service;

import com.nuestrosparques.token.app.adapter.fallecidos.dto.FallecidosDTO;
import com.nuestrosparques.token.app.adapter.fallecidos.response.FallecidosResponse;

import java.util.List;

public interface FallecidosService {

    List<FallecidosResponse> findAll();

    List<FallecidosDTO> getTodosFallecidosPorFechaYParque(String fechaInicio, String fechaFin, Integer parque);

    List<FallecidosDTO> encontrarTodosFallecidos(Integer parque, String nombres, String apellidoPaterno, String apellidoMaterno, String rut);
}
