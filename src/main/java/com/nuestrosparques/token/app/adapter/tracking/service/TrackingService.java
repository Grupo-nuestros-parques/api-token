package com.nuestrosparques.token.app.adapter.tracking.service;

import com.nuestrosparques.token.app.adapter.mantenedor.response.AsignacionRolesResponse;
import com.nuestrosparques.token.app.adapter.tracking.response.TrackingResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TrackingService {

    Boolean registerTracking(String nombreFuncion, Integer rut, String tokenSession, String nombreCompletoAgente);
    Page<TrackingResponse> getTrackings(String schema, int page, int size, Integer rut, String fechaInicio, String fechaFin);
    List<TrackingResponse> getListTrackings(String schema, Integer rut, String fechaInicio, String fechaFin);
    void exportToCSV(List<TrackingResponse> listado, String filePath);
}
