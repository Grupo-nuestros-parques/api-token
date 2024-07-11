package com.nuestrosparques.token.app.adapter.tracking.service.impl;

import com.nuestrosparques.token.app.adapter.mantenedor.response.AsignacionRolesResponse;
import com.nuestrosparques.token.app.adapter.tracking.request.TrackingRequest;
import com.nuestrosparques.token.app.adapter.tracking.response.PaginatedResponse;
import com.nuestrosparques.token.app.adapter.tracking.response.TrackingResponse;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TrackingServiceImpl implements TrackingService {

    @Value("${api.portalplus.service}")
    private String portalPlusApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;

    public TrackingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean registerTracking(String nombreFuncion, Integer rut, String tokenSession, String nombreCompletoAgente) {
        String apiUrl = portalPlusApiUrl + "/register-tracking";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        TrackingRequest trackingRequest = createTrackingRequest(nombreFuncion, rut, tokenSession, nombreCompletoAgente);

        HttpEntity<TrackingRequest> requestEntity = new HttpEntity<>(trackingRequest, headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Boolean.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody(); // Esto devolverá el valor booleano del cuerpo de la respuesta
        } else {
            // Manejar el fallo aquí
            return Boolean.FALSE; // o lanzar una excepción
        }
    }

    private TrackingRequest createTrackingRequest(String nombreFuncion, Integer rut, String tokenSession, String nombreCompletoAgente) {
        TrackingRequest trackingRequest = new TrackingRequest();
        trackingRequest.setNombreFuncion(nombreFuncion);
        trackingRequest.setRut(rut);
        trackingRequest.setTokenSession(tokenSession);
        trackingRequest.setNombreCompletoAgente(nombreCompletoAgente);
        return trackingRequest;
    }

    @Override
    public Page<TrackingResponse> getTrackings(String schema, int page, int size, Integer rut, String fechaInicio, String fechaFin) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-schema", schema);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String apiUrl = portalPlusApiUrl + "/getTrackings";

        // Construir la URL con los parámetros de consulta
        apiUrl += "?page=" + page + "&size=" + size;
        if (rut != null) {
            apiUrl += "&rut=" + rut;
        }
        if (fechaInicio != null) {
            try {
                apiUrl += "&fechaInicio=" + formatDateToISO(fechaInicio);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if (fechaFin != null) {
            try {
                apiUrl += "&fechaFin=" + formatDateToISO(fechaFin);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        ResponseEntity<PaginatedResponse<TrackingResponse>> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<PaginatedResponse<TrackingResponse>>() { }
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            PaginatedResponse<TrackingResponse> paginatedResponse = response.getBody();
            if (paginatedResponse != null) {
                // Formatear las fechas antes de devolver la respuesta paginada
                formatTrackingDates(paginatedResponse.getContent());
            }
            return paginatedResponse.toPage();
        } else {
            throw new RuntimeException("La llamada al servicio web (Datasource) falló con el código de estado: " + response.getStatusCodeValue());
        }
    }


    @Override
    public List<TrackingResponse> getListTrackings(String schema, Integer rut, String fechaInicio, String fechaFin) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String apiUrl = portalPlusApiUrl + "/getTrackingsList";

        apiUrl += "?";

        if (rut != null) {
            apiUrl += "rut=" + rut;
        }
        if (fechaInicio != null) {
            apiUrl += "&fechaInicio=" + fechaInicio;
        }
        if (fechaFin != null) {
            apiUrl += "&fechaFin=" + fechaFin;
        }

        ResponseEntity<List<TrackingResponse>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<List<TrackingResponse>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            List<TrackingResponse> listedResponse = response.getBody();
            return listedResponse;
        } else {
            throw new RuntimeException("La llamada al servicio web (Por) falló con el código de estado: " + response.getStatusCodeValue());
        }
    }

    @Override
    public void exportToCSV(List<TrackingResponse> listado, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Escribir el encabezado del CSV
            String[] header = { "ID", "Rut", "Nombre", "Función", "Token de Session", "Fecha Asignacion" };
            writer.writeNext(header);

            // Escribir datos de cada objeto AsignacionRolesResponse en el CSV
            for (TrackingResponse tracking : listado) {
                String[] data = {
                        tracking.getId() != null ? tracking.getId().toString() : "",
                        tracking.getRut() != null ? tracking.getRut().toString() : "",
                        tracking.getNombreCompletoAgente() != null ? tracking.getNombreCompletoAgente().toString() : "",
                        tracking.getNombreFuncion() != null ? tracking.getNombreFuncion().toString() : "",
                        tracking.getTokenSession() != null ? tracking.getTokenSession().toString() : "",
                        tracking.getCreatedAt() != null ? tracking.getCreatedAt().toString() : ""
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo CSV", e);
        }
    }

    private String formatDateToISO(String dateString) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return dateString;
    }

    // Método para formatear las fechas en los objetos TrackingResponse
    private void formatTrackingDates(List<TrackingResponse> trackings) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        for (TrackingResponse tracking : trackings) {
            if (tracking.getCreatedAt() != null) {
                String formattedDate = formatter.format(tracking.getCreatedAt());
                tracking.setFormattedCreatedAt(formattedDate);
            }
        }
    }

}
