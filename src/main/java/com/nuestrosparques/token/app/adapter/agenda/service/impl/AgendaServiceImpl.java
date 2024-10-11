package com.nuestrosparques.token.app.adapter.agenda.service.impl;

import com.nuestrosparques.token.app.adapter.agenda.dto.OrigenDTO;
import com.nuestrosparques.token.app.adapter.agenda.mapper.OrigenMapper;
import com.nuestrosparques.token.app.adapter.agenda.response.*;
import com.nuestrosparques.token.app.adapter.agenda.dto.TipoDTO;
import com.nuestrosparques.token.app.adapter.agenda.mapper.TipoMapper;
import com.nuestrosparques.token.app.adapter.agenda.dto.CiudadDTO;
import com.nuestrosparques.token.app.adapter.agenda.mapper.CiudadMapper;
import com.nuestrosparques.token.app.adapter.agenda.dto.ComunaDTO;
import com.nuestrosparques.token.app.adapter.agenda.mapper.ComunaMapper;

import com.nuestrosparques.token.app.adapter.agenda.service.AgendaService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
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

    public Integer registrarContacto(
            String codigoAgente,
            String nombreContacto,
            String apellidoPaternoContacto,
            String apellidoMaternoContacto,
            String rutContacto,
            String dvContacto,
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
        body.add("apellidoPaternoContacto", apellidoPaternoContacto);
        body.add("apellidoMaternoContacto", apellidoMaternoContacto);
        body.add("rutContacto", rutContacto);
        body.add("dvContacto", dvContacto);
        body.add("direccionContacto", direccionContacto);
        body.add("telefonoContacto", telefonoContacto);
        body.add("emailContacto", emailContacto);

        // Crear la entidad HTTP con cuerpo y encabezados
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        // Realizar la solicitud POST
        try {
            ResponseEntity<Integer> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity, // Enviar los parámetros de formulario como cuerpo de la solicitud
                    Integer.class // No se espera respuesta
            );

            // Verificar si la respuesta es exitosa
            if (response.getStatusCode() == HttpStatus.OK) {
                // Retornar el valor del cuerpo de la respuesta (Integer)
                return response.getBody();
            } else {
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

    public Page<InformeAgenteResponse> getInformes(int page, int size, Long rut, String nombre, String codigoAgente) {
        String apiUrl = agendaApiUrl + "/contactos/lista-contactos";

        // Construir la URL con los parámetros de consulta
        apiUrl += "?page=" + page + "&size=" + size;
        if (rut != null) {
            apiUrl += "&rut=" + rut;
        }
        if (nombre != null) {
            apiUrl += "&nombre=" + nombre;
        }
        if (codigoAgente != null) { // Agregar el nuevo parámetro
            apiUrl += "&codigoAgente=" + codigoAgente;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<PaginatedResponse<InformeAgenteResponse>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<PaginatedResponse<InformeAgenteResponse>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            PaginatedResponse<InformeAgenteResponse> paginatedResponse = response.getBody();
            return paginatedResponse.toPage();
        } else {
            throw new RuntimeException("La llamada al servicio web (Agenda) falló con el código de estado: " + response.getStatusCodeValue());
        }
    }

    @Override
    public InformeAgenteResponse getContacto(String correlativo, String codigoAgente) {
        String apiUrl = agendaApiUrl + "/contactos/obtener-contacto?correlativo=" + correlativo + "&codigoAgente=" + codigoAgente;

        ResponseEntity<InformeAgenteResponse> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, null, new ParameterizedTypeReference<InformeAgenteResponse>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            // Retorna el cuerpo de la respuesta directamente
            return response.getBody();
        } else {
            // Maneja el fallo aquí
            return null; // O lanza una excepción según sea necesario
        }
    }

    public Integer editarContacto(
            String correlativo,
            String codigoAgente,
            String rutContacto,
            String dvContacto,
            String nombreContacto,
            String apellidoPaternoContacto,
            String apellidoMaternoContacto,
            String direccionContacto,
            String telefonoContacto,
            String emailContacto
    ) {
        // URL de la API
        String apiUrl = agendaApiUrl + "/contactos/editar-contacto";

        // Configurar encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Crear el cuerpo de la solicitud con parámetros de formulario
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("correlativo", correlativo);
        body.add("codigoAgente", codigoAgente);
        body.add("rutContacto", rutContacto);
        body.add("dvContacto", dvContacto);
        body.add("nombreContacto", nombreContacto);
        body.add("apellidoPaternoContacto", apellidoPaternoContacto);
        body.add("apellidoMaternoContacto", apellidoMaternoContacto);
        body.add("direccionContacto", direccionContacto);
        body.add("telefonoContacto", telefonoContacto);
        body.add("emailContacto", emailContacto);

        // Crear la entidad HTTP con cuerpo y encabezados
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        // Realizar la solicitud POST
        try {
            ResponseEntity<Integer> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity, // Enviar los parámetros de formulario como cuerpo de la solicitud
                    Integer.class // No se espera respuesta
            );

            // Verificar si la respuesta es exitosa
            if (response.getStatusCode() == HttpStatus.OK) {
                // Retornar el valor del cuerpo de la respuesta (Integer)
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to register contact. Status code: " + response.getStatusCode());
            }
        } catch (Exception e) {
            // Manejar excepciones
            e.printStackTrace(); // O usar un framework de logging
            throw new RuntimeException("Exception occurred while making POST request", e);
        }
    }

    public Integer agendarEntrevista(
            String informeAgenteId,
            String fechaEntrevista

    ) {
        // URL de la API
        String apiUrl = agendaApiUrl + "/entrevistas/agendarEntrevista";

        // Configurar encabezados
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Crear el cuerpo de la solicitud con parámetros de formulario
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("informeAgenteId", informeAgenteId);
        body.add("fechaEntrevista", fechaEntrevista);

        // Crear la entidad HTTP con cuerpo y encabezados
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        // Realizar la solicitud POST
        try {
            ResponseEntity<Integer> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    entity, // Enviar los parámetros de formulario como cuerpo de la solicitud
                    Integer.class // No se espera respuesta
            );

            // Verificar si la respuesta es exitosa
            if (response.getStatusCode() == HttpStatus.OK) {
                // Retornar el valor del cuerpo de la respuesta (Integer)
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to register contact. Status code: " + response.getStatusCode());
            }
        } catch (Exception e) {
            // Manejar excepciones
            e.printStackTrace(); // O usar un framework de logging
            throw new RuntimeException("Exception occurred while making POST request", e);
        }
    }

    public Page<EntrevistasAgendadasResponse> getEntrevistasAgendadasPageable(int page, int size, Long rut, String nombre, String codigoAgente, Timestamp fechaDesde, Timestamp fechaHasta) {
        String apiUrl = agendaApiUrl + "/entrevistas/listar-entrevistas";

        // Construir la URL con los parámetros de consulta
        apiUrl += "?page=" + page + "&size=" + size;
        if (rut != null) {
            apiUrl += "&rut=" + rut;
        }
        if (nombre != null) {
            apiUrl += "&nombre=" + nombre;
        }
        if (codigoAgente != null) {
            apiUrl += "&codigoAgente=" + codigoAgente;
        }
        // Agregar fechas a la URL
        if (fechaDesde != null) {
            apiUrl += "&fechaDesde=" + fechaDesde.toLocalDateTime().format(DateTimeFormatter.ISO_DATE_TIME);
        }
        if (fechaHasta != null) {
            apiUrl += "&fechaHasta=" + fechaHasta.toLocalDateTime().format(DateTimeFormatter.ISO_DATE_TIME);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<PaginatedResponse<EntrevistasAgendadasResponse>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<PaginatedResponse<EntrevistasAgendadasResponse>>() {}
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            PaginatedResponse<EntrevistasAgendadasResponse> paginatedResponse = response.getBody();
            return paginatedResponse.toPage();
        } else {
            throw new RuntimeException("La llamada al servicio web (Datasource) falló con el código de estado: " + response.getStatusCodeValue());
        }
    }

}
