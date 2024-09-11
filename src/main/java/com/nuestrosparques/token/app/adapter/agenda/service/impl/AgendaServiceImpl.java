package com.nuestrosparques.token.app.adapter.agenda.service.impl;

import com.nuestrosparques.token.app.adapter.agenda.dto.OrigenDTO;
import com.nuestrosparques.token.app.adapter.agenda.mapper.OrigenMapper;
import com.nuestrosparques.token.app.adapter.agenda.response.OrigenResponse;
import com.nuestrosparques.token.app.adapter.agenda.dto.TipoDTO;
import com.nuestrosparques.token.app.adapter.agenda.mapper.TipoMapper;
import com.nuestrosparques.token.app.adapter.agenda.response.TipoResponse;
import com.nuestrosparques.token.app.adapter.agenda.dto.CiudadDTO;
import com.nuestrosparques.token.app.adapter.agenda.mapper.CiudadMapper;
import com.nuestrosparques.token.app.adapter.agenda.response.CiudadResponse;
import com.nuestrosparques.token.app.adapter.agenda.dto.ComunaDTO;
import com.nuestrosparques.token.app.adapter.agenda.mapper.ComunaMapper;
import com.nuestrosparques.token.app.adapter.agenda.response.ComunaResponse;

import com.nuestrosparques.token.app.adapter.agenda.service.AgendaService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AgendaServiceImpl implements AgendaService {

    @Value("${api.agenda.service}")
    private String agendaApiUrl; // This would be your API endpoint

    private final RestTemplate restTemplate;
    private final OrigenMapper origenMapper;
    private final TipoMapper tipoMapper;
    private final CiudadMapper ciudadMapper;
    private final ComunaMapper comunaMapper;

    public AgendaServiceImpl(
            RestTemplate restTemplate,
            OrigenMapper origenMapper,
            TipoMapper tipoMapper,
            CiudadMapper ciudadMapper,
            ComunaMapper comunaMapper
    ) {
        this.restTemplate = restTemplate;
        this.origenMapper = origenMapper;
        this.tipoMapper = tipoMapper;
        this.ciudadMapper = ciudadMapper;
        this.comunaMapper = comunaMapper;
    }

    @Override
    public List<OrigenDTO> getOriginList() {
        List<OrigenResponse> responses = new ArrayList<>();
        List<OrigenDTO> origenDTOS = new ArrayList<>();
        String apiUrl = agendaApiUrl + "/origen";

        ResponseEntity<List<OrigenResponse>> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<OrigenResponse>>() {}
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
            origenDTOS = origenMapper.transformOrigenToDTO(responses);
        }else {
            return Collections.emptyList();
        }
        return origenDTOS;
    }

    @Override
    public List<TipoDTO> getTipoList(String idSub) {
        List<TipoResponse> responses = new ArrayList<>();
        List<TipoDTO> tipoDTOS = new ArrayList<>();
        String apiUrl = agendaApiUrl + "/tipo?idSub=" + idSub;

        ResponseEntity<List<TipoResponse>> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<TipoResponse>>() {}
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
            tipoDTOS = tipoMapper.transformTipoToDTO(responses);
        }else {
            return Collections.emptyList();
        }
        return tipoDTOS;
    }


    @Override
    public List<CiudadDTO> getCiudadesList() {
        List<CiudadResponse> responses = new ArrayList<>();
        List<CiudadDTO> ciudadDTOS = new ArrayList<>();
        String apiUrl = agendaApiUrl + "/ciudades";

        ResponseEntity<List<CiudadResponse>> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<CiudadResponse>>() {}
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
            ciudadDTOS = ciudadMapper.transformCiudadToDTO(responses);
        }else {
            return Collections.emptyList();
        }
        return ciudadDTOS;
    }

    @Override
    public List<ComunaDTO> getComunasList(String idCiudad) {
        List<ComunaResponse> responses = new ArrayList<>();
        List<ComunaDTO> comunaDTOS = new ArrayList<>();
        String apiUrl = agendaApiUrl + "/comunas?idCiudad=" + idCiudad;

        ResponseEntity<List<ComunaResponse>> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<ComunaResponse>>() {}
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            responses = response.getBody();
            comunaDTOS = comunaMapper.transformComunaToDTO(responses);
        }else {
            return Collections.emptyList();
        }
        return comunaDTOS;
    }

    public void registrarContacto(
            String codigoAgente,
            String nombreContacto,
            String apellidoContacto,
            String rutContacto,
            String direccionContacto,
            String telefonoContacto,
            String emailContacto
    ) {
        // URL de la API
        String apiUrl = agendaApiUrl + "/registrarContacto";

        // Configurar encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Crear el cuerpo de la solicitud con parámetros de formulario
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("codigoAgente", codigoAgente);
        body.add("nombreContacto", nombreContacto);
        body.add("apellidoContacto", apellidoContacto);
        body.add("rutContacto", rutContacto);
        body.add("direccionContacto", direccionContacto);
        body.add("telefonoContacto", telefonoContacto);
        body.add("emailContacto", emailContacto);

        // Crear la entidad HTTP con cuerpo y encabezados
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        // Realizar la solicitud POST
        try {
            ResponseEntity<Void> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity, // Enviar los parámetros de formulario como cuerpo de la solicitud
                    Void.class // No se espera respuesta
            );

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Failed to register contact. Status code: " + response.getStatusCode());
            }
        } catch (Exception e) {
            // Manejar excepciones
            e.printStackTrace(); // O usar un framework de logging
            throw new RuntimeException("Exception occurred while making POST request", e);
        }
    }

    public void registrarIntento(
            String codigoAgente,
            String idOrigin,
            String idTypeGrupoPp,
            String idTypeSubGrupoPp,
            String idCity,
            String idComuna,
            String exitoso
    ) {
        // URL de la API
        String apiUrl = agendaApiUrl + "/registrarIntento";

        // Configurar encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Crear el cuerpo de la solicitud con parámetros de formulario
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("codigoAgente", codigoAgente);
        body.add("idOrigin", idOrigin);
        body.add("idTypeGrupoPp", idTypeGrupoPp);
        body.add("idTypeSubGrupoPp", idTypeSubGrupoPp);
        body.add("idCity", idCity);
        body.add("idComuna", idComuna);
        body.add("exitoso", exitoso);

        // Crear la entidad HTTP con cuerpo y encabezados
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        // Realizar la solicitud POST
        try {
            ResponseEntity<Void> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity, // Enviar los parámetros de formulario como cuerpo de la solicitud
                    Void.class // No se espera respuesta
            );

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Failed to register contact. Status code: " + response.getStatusCode());
            }
        } catch (Exception e) {
            // Manejar excepciones
            e.printStackTrace(); // O usar un framework de logging
            throw new RuntimeException("Exception occurred while making POST request", e);
        }
    }

}
