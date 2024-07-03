package com.nuestrosparques.token.app.adapter.mantenedor.service.impl;

import com.nuestrosparques.token.app.adapter.mantenedor.response.PaginatedResponse;
import com.nuestrosparques.token.app.adapter.mantenedor.response.UserRolesResponse;
import com.nuestrosparques.token.app.adapter.mantenedor.service.AsignacionRolesService;
import com.nuestrosparques.token.app.adapter.tracking.request.TrackingRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.nuestrosparques.token.app.adapter.mantenedor.response.AsignacionRolesResponse;

import java.util.Map;

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
    public UserRolesResponse getRolesByRut(
            String schema, Integer rut
    ) {
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
            throw new RuntimeException("La llamada al servicio web (Datasource) falló con el código de estado: " + response.getStatusCodeValue());
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
}
