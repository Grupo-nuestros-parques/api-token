package com.nuestrosparques.token.app.adapter.agenda.mapper;

import com.nuestrosparques.token.app.adapter.agenda.dto.TipoDTO;
import com.nuestrosparques.token.app.adapter.agenda.response.TipoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TipoMapper {

    public List<TipoDTO> transformTipoToDTO(List<TipoResponse> tipoResponses) {
        List<TipoDTO> response =  new ArrayList<>();
        tipoResponses.forEach(resp -> {
            TipoDTO tipoDTO = new TipoDTO();
            tipoDTO.setA1(resp.getGrupoPp());
            tipoDTO.setA2(resp.getDescripcionGrupo());
            tipoDTO.setA3(resp.getSubGrupoPp());

            response.add(tipoDTO);
        });
        return response;
    }


}
