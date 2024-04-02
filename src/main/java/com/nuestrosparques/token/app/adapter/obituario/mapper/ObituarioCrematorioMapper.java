package com.nuestrosparques.token.app.adapter.obituario.mapper;

import com.nuestrosparques.token.app.adapter.obituario.dto.ObituarioCrematorioDTO;
import com.nuestrosparques.token.app.adapter.obituario.response.ObituarioCrematorioResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObituarioCrematorioMapper {

    public List<ObituarioCrematorioDTO> transformObituarioCrematorioToDTO(List<ObituarioCrematorioResponse> obituarioCrematorioResponses){
        List<ObituarioCrematorioDTO> response = new ArrayList<>();
        obituarioCrematorioResponses.forEach(resp -> {
            ObituarioCrematorioDTO obituarioCrematorioDTO = new ObituarioCrematorioDTO();
            obituarioCrematorioDTO.setA1(resp.getFolio());
            obituarioCrematorioDTO.setA2(resp.getRutFallecido());
            obituarioCrematorioDTO.setA3(resp.getFechaCrea());
            obituarioCrematorioDTO.setA4(resp.getFechaSistema());
            obituarioCrematorioDTO.setA5(resp.getUsuarioCrea());
            obituarioCrematorioDTO.setA6(resp.getEstadoGestion());
            obituarioCrematorioDTO.setA7(resp.getParqueOrigen());
            obituarioCrematorioDTO.setA8(resp.getParqueDestino());
            obituarioCrematorioDTO.setA9(resp.getFechaCineracion());
            obituarioCrematorioDTO.setA10(resp.getHoraCineracion());
            obituarioCrematorioDTO.setA11(resp.getMinutoCineracion());
            obituarioCrematorioDTO.setA12(resp.getFechaIngresoCinerario());
            obituarioCrematorioDTO.setA13(resp.getHoraIngresoCinerario());
            obituarioCrematorioDTO.setA14(resp.getMinutoIngresoCinerario());
            obituarioCrematorioDTO.setA15(resp.getNombres());
            obituarioCrematorioDTO.setA16(resp.getApellidoPaterno());
            obituarioCrematorioDTO.setA17(resp.getApellidoMaterno());
            obituarioCrematorioDTO.setA18(resp.getFechaDefuncion());
            obituarioCrematorioDTO.setA19(resp.getFechaNacimiento());
            response.add(obituarioCrematorioDTO);
        });
        return response;
    }
}
