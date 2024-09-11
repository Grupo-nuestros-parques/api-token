package com.nuestrosparques.token.app.adapter.agenda.mapper;

import com.nuestrosparques.token.app.adapter.agenda.dto.CiudadDTO;
import com.nuestrosparques.token.app.adapter.agenda.response.CiudadResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CiudadMapper {

    public List<CiudadDTO> transformCiudadToDTO(List<CiudadResponse> ciudadResponses) {
        List<CiudadDTO> response =  new ArrayList<>();
        ciudadResponses.forEach(resp -> {
            CiudadDTO obituarioDTO = new CiudadDTO();
            obituarioDTO.setA1(resp.getCodigoCiudad());
            obituarioDTO.setA2(resp.getCapital());
            obituarioDTO.setA3(resp.getSiglaCiudad());

            response.add(obituarioDTO);
        });
        return response;
    }

}
