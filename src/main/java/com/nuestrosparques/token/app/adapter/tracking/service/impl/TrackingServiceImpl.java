package com.nuestrosparques.token.app.adapter.tracking.service.impl;

//import com.nuestrosparques.token.app.adapter.tracking.dto.TrackingRequest;
//import com.nuestrosparques.token.app.adapter.tracking.service.ContratoService;
import com.nuestrosparques.token.app.adapter.tracking.request.TrackingRequest;
import com.nuestrosparques.token.app.adapter.tracking.response.TrackingResponse;
import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public List<TrackingResponse> getTrackings(String schema) {
        List<TrackingResponse> trackings = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-schema", schema);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String apiUrl = portalPlusApiUrl + "/getTrackings";
        ResponseEntity<List<TrackingResponse>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<TrackingResponse>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            trackings = response.getBody();

            // Aquí recorremos y modificamos el dato.
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            for (TrackingResponse tracking : trackings) {
                if (tracking.getCreatedAt() != null) {
                    String formattedDate = formatter.format(tracking.getCreatedAt());
                    tracking.setFormattedCreatedAt(formattedDate);
                }
            }

        }
        return trackings;
    }

    /*@Override
    public List<TrackingRequest> getContratosPorRutForPay(Integer rut, String schema) {
        List<TrackingRequest> trackings = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-schema", schema);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String apiUrl = trackingsApiUrl + "/contractForPay?rut="+ rut; // Modify this to match your API's endpoint structure
        ResponseEntity<List<TrackingRequest>> response = restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<TrackingRequest>>() {});
        if (response.getStatusCode().is2xxSuccessful()) {
            trackings = response.getBody();
        }
        return trackings;
    }*/

    public static Integer convertStringToInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Error: El formato no es válido. Valor: " + str);
            return null;
        }
    }
}
