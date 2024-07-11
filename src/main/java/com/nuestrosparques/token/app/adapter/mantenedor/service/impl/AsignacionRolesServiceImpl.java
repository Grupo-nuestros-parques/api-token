package com.nuestrosparques.token.app.adapter.mantenedor.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuestrosparques.token.app.adapter.mantenedor.response.PaginatedResponse;
import com.nuestrosparques.token.app.adapter.mantenedor.response.UserRolesResponse;
import com.nuestrosparques.token.app.adapter.mantenedor.service.AsignacionRolesService;
import com.nuestrosparques.token.app.adapter.tracking.request.TrackingRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import com.nuestrosparques.token.app.adapter.mantenedor.response.AsignacionRolesResponse;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class AsignacionRolesServiceImpl implements AsignacionRolesService {


    @Value("${api.portalplus.service}")
    private String portalPlusApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;

    public AsignacionRolesServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Page<AsignacionRolesResponse> getRolesAsignados(
            int page, int size, Integer rutAsignador, Integer rutAsignado, Long idRol,
            String fechaAsignacionDesde, String fechaAsignacionHasta,
            String fechaRevocacionDesde, String fechaRevocacionHasta
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String apiUrl = portalPlusApiUrl + "/mantenedor/roles-asignados";

        apiUrl += "?page=" + page + "&size=" + size;

        if (rutAsignador != null) {
            apiUrl += "&rutAsignador=" + rutAsignador;
        }
        if (rutAsignado != null) {
            apiUrl += "&rutAsignado=" + rutAsignado;
        }
        if (idRol != null) {
            apiUrl += "&idRol=" + idRol;
        }
        if (fechaAsignacionDesde != null) {
            apiUrl += "&fechaAsignacionDesde=" + fechaAsignacionDesde;
        }
        if (fechaAsignacionHasta != null) {
            apiUrl += "&fechaAsignacionHasta=" + fechaAsignacionHasta;
        }
        if (fechaRevocacionDesde != null) {
            apiUrl += "&fechaRevocacionDesde=" + fechaRevocacionDesde;
        }
        if (fechaRevocacionHasta != null) {
            apiUrl += "&fechaRevocacionHasta=" + fechaRevocacionHasta;
        }

        ResponseEntity<PaginatedResponse<AsignacionRolesResponse>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<PaginatedResponse<AsignacionRolesResponse>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            PaginatedResponse<AsignacionRolesResponse> paginatedResponse = response.getBody();
            return paginatedResponse.toPage();
        } else {
            throw new RuntimeException("La llamada al servicio web (Datasource) falló con el código de estado: " + response.getStatusCodeValue());
        }
    }

    @Override
    public List<AsignacionRolesResponse> getRolesAsignadosListado(
            Integer rutAsignador, Integer rutAsignado, Long idRol,
            String fechaAsignacionDesde, String fechaAsignacionHasta,
            String fechaRevocacionDesde, String fechaRevocacionHasta
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String apiUrl = portalPlusApiUrl + "/mantenedor/roles-asignados-listado";

        apiUrl += "?";

        if (rutAsignador != null) {
            apiUrl += "&rutAsignador=" + rutAsignador;
        }
        if (rutAsignado != null) {
            apiUrl += "&rutAsignado=" + rutAsignado;
        }
        if (idRol != null) {
            apiUrl += "&idRol=" + idRol;
        }
        if (fechaAsignacionDesde != null) {
            apiUrl += "&fechaAsignacionDesde=" + fechaAsignacionDesde;
        }
        if (fechaAsignacionHasta != null) {
            apiUrl += "&fechaAsignacionHasta=" + fechaAsignacionHasta;
        }
        if (fechaRevocacionDesde != null) {
            apiUrl += "&fechaRevocacionDesde=" + fechaRevocacionDesde;
        }
        if (fechaRevocacionHasta != null) {
            apiUrl += "&fechaRevocacionHasta=" + fechaRevocacionHasta;
        }

        ResponseEntity<List<AsignacionRolesResponse>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<List<AsignacionRolesResponse>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            List<AsignacionRolesResponse> listedResponse = response.getBody();
            return listedResponse;
        } else {
            throw new RuntimeException("La llamada al servicio web (Por) falló con el código de estado: " + response.getStatusCodeValue());
        }
    }

    @Override
    public void exportToCSV(List<AsignacionRolesResponse> listado, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            // Escribir el encabezado del CSV
            String[] header = { "ID", "Rut", "Nombre", "Rol", "Fecha Asignacion", "Fecha Revocacion" };
            writer.writeNext(header);

            // Escribir datos de cada objeto AsignacionRolesResponse en el CSV
            for (AsignacionRolesResponse asignacion : listado) {
                String[] data = {
                        asignacion.getId().toString(),
                        asignacion.getRutAsignado().getRut(),
                        asignacion.getRutAsignado().getNombre(),
                        asignacion.getRole().getNombre(),
                        asignacion.getFechaAsignacion(),
                        (asignacion.getFechaRevocacion() != null && !asignacion.getFechaRevocacion().isEmpty()) ? asignacion.getFechaRevocacion() : "Rol Vigente"
                };
                writer.writeNext(data);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo CSV", e);
        }
    }


    @Override
    public UserRolesResponse getRolesByRut(
            String schema, Integer rut
    ) {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("x-schema", schema);
            headers.setContentType(MediaType.APPLICATION_JSON);

            String apiUrl = portalPlusApiUrl + "/mantenedor/get-roles-by-rut?";
            apiUrl += "rut=" + rut;

            ResponseEntity<UserRolesResponse> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    new ParameterizedTypeReference<UserRolesResponse>() {}
            );

            if (response.getStatusCode().is2xxSuccessful()) {
                UserRolesResponse userRolesResponse = response.getBody();
                return userRolesResponse;
            } else {
                throw new RuntimeException("La llamada al servicio web (PortalPlusBE) falló con el código de estado: " + response.getStatusCodeValue());
            }

        } catch (HttpClientErrorException ex) {
            // Handle 4xx errors
            if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                // Extract the error message from the response body
                String errorMessage = ex.getResponseBodyAsString();
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, extractErrorMessage(errorMessage));
            } else {
                throw new ResponseStatusException(ex.getStatusCode(), ex.getResponseBodyAsString(), ex);
            }
        } catch (HttpServerErrorException ex) {
            // Handle 5xx errors
            // Extract the error message from the response body
            String errorMessage = ex.getResponseBodyAsString();
            throw new ResponseStatusException(ex.getStatusCode(), errorMessage, ex);
        }
    }

    @Override
    public Boolean setRolesByRut(
            Map<String, Object> data
    ) {
        HttpHeaders headers = new HttpHeaders();
        //headers.add("x-schema", schema);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String apiUrl = portalPlusApiUrl + "/mantenedor/save-rol-by-rut";

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(data, headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Boolean.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Boolean result = response.getBody();
            return result;
        } else {
            return false;
            //throw new RuntimeException("La llamada al servicio web (Datasource) falló con el código de estado: " + response.getStatusCodeValue());
        }
    }

    private String extractErrorMessage(String errorResponse) {
        try {
            // Parse the JSON response to extract the message
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(errorResponse);
            return jsonNode.get("code").asText();
        } catch (IOException e) {
            return "Error parsing error response";
        }
    }
}
