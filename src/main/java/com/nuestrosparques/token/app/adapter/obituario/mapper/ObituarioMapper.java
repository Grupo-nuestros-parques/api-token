package com.nuestrosparques.token.app.adapter.obituario.mapper;

import com.nuestrosparques.token.app.adapter.obituario.dto.ObituarioDTO;
import com.nuestrosparques.token.app.adapter.obituario.response.ObituarioResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObituarioMapper {

    public List<ObituarioDTO> transformObituarioToDTO(List<ObituarioResponse> obituarioResponses) {
        List<ObituarioDTO> response =  new ArrayList<>();
        obituarioResponses.forEach(resp -> {
            ObituarioDTO obituarioDTO = new ObituarioDTO();
            obituarioDTO.setA11(resp.getArea());
            obituarioDTO.setA20(resp.getFechaSepultacion());
            obituarioDTO.setA2(resp.getHora());
            obituarioDTO.setA5(resp.getMinutos());
            obituarioDTO.setA3(resp.getNombreFallecido());
            obituarioDTO.setA4(resp.getApellidoPaternoFallecido() + " " + resp.getApellidoMaternoFallecido());
            obituarioDTO.setA7(resp.getRutFallecido());
            obituarioDTO.setA8(resp.getDvFallecido());
            obituarioDTO.setA10(resp.getSector());
            obituarioDTO.setA14(resp.getSepultura());
            obituarioDTO.setA15(resp.getCodigoParque());
            obituarioDTO.setA9(resp.getLugarInicioCeremonia());
            obituarioDTO.setA12(resp.getCapillaVelatoria());
            obituarioDTO.setA13(resp.getDireccionCapilla());
            obituarioDTO.setA19(resp.getFechaDefuncion());
            obituarioDTO.setA18(resp.getFechaNacimiento());
            obituarioDTO.setA16(resp.getLatitud());
            obituarioDTO.setA17(resp.getLongitud());
            response.add(obituarioDTO);
        });
        return response;
    }
}
