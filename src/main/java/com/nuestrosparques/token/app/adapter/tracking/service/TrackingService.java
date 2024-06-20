package com.nuestrosparques.token.app.adapter.tracking.service;

import com.nuestrosparques.token.app.adapter.tracking.response.TrackingResponse;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface TrackingService {

    Boolean registerTracking(String nombreFuncion, Integer rut, String tokenSession, String nombreCompletoAgente);
    //List<ContratoDTO> getContratosPorRutForPay(Integer rut, String schema);
    Page<TrackingResponse> getTrackings(String schema, int page, int size, Integer rut, String fechaInicio, String fechaFin);
}
