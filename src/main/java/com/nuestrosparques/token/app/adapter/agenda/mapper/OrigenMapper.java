package com.nuestrosparques.token.app.adapter.agenda.mapper;

import com.nuestrosparques.token.app.adapter.agenda.dto.OrigenDTO;
import com.nuestrosparques.token.app.adapter.agenda.response.OrigenResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrigenMapper {

    public List<OrigenDTO> transformOrigenToDTO(List<OrigenResponse> origenResponses) {
        List<OrigenDTO> response =  new ArrayList<>();
        origenResponses.forEach(resp -> {
            OrigenDTO obituarioDTO = new OrigenDTO();
            obituarioDTO.setA1(resp.getTipVenta());
            obituarioDTO.setA2(resp.getDescripcion());
            obituarioDTO.setA3(resp.getGrupoPp());

            response.add(obituarioDTO);
        });
        return response;
    }


}
