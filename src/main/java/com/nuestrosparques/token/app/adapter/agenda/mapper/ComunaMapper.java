package com.nuestrosparques.token.app.adapter.agenda.mapper;

import com.nuestrosparques.token.app.adapter.agenda.dto.ComunaDTO;
import com.nuestrosparques.token.app.adapter.agenda.response.ComunaResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComunaMapper {

    public List<ComunaDTO> transformComunaToDTO(List<ComunaResponse> comunaResponses) {
        List<ComunaDTO> response =  new ArrayList<>();
        comunaResponses.forEach(resp -> {
            ComunaDTO ciudadDTO = new ComunaDTO();
            ciudadDTO.setA1(resp.getCodigoComuna());
            ciudadDTO.setA2(resp.getCodigoCiudad());
            ciudadDTO.setA3(resp.getComuna());
            ciudadDTO.setA4(resp.getSiglaComuna());
            response.add(ciudadDTO);
        });
        return response;
    }

}
