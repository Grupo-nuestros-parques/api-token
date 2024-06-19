package com.nuestrosparques.token.app.adapter.tracking.service;

import com.nuestrosparques.token.app.adapter.tracking.request.TrackingRequest;
import com.nuestrosparques.token.app.adapter.tracking.response.TrackingResponse;

import java.util.List;

public interface TrackingService {

    Boolean registerTracking(String nombreFuncion, Integer rut, String tokenSession, String nombreCompletoAgente);
    //List<ContratoDTO> getContratosPorRutForPay(Integer rut, String schema);
    List<TrackingResponse> getTrackings(String schema);
}
