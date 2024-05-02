package com.nuestrosparques.token.app.adapter.pagos.mapper;

import com.nuestrosparques.token.app.adapter.pagos.dto.CuponesDTO;
import com.nuestrosparques.token.app.adapter.pagos.response.CuponesResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CuponesMapper {

    public List<CuponesDTO> transformCuponesToDTO(List<CuponesResponse> cuponesResponses){
        List<CuponesDTO> cupones = new ArrayList<>();
        cuponesResponses.forEach(resp ->{
            CuponesDTO cuponesDTO = new CuponesDTO();
            cuponesDTO.setA1(resp.getBase());
            cuponesDTO.setA2(resp.getSerie());
            cuponesDTO.setA3(resp.getNumero());
            cuponesDTO.setA4(resp.getNroCupon());
            cuponesDTO.setA5(resp.getRut());
            cuponesDTO.setA6(resp.getNroCuota());
            cuponesDTO.setA7(resp.getFechaVenc());
            cuponesDTO.setA8(resp.getEstadoPagoCupon());
            cuponesDTO.setA9(resp.getTipoMov());
            cuponesDTO.setA10(resp.getMontoCuotaPeso());
            cuponesDTO.setA11(resp.getDv());
            cuponesDTO.setA12(resp.getTipoMoneda());
            cuponesDTO.setA13(resp.getPiePactado());
            cupones.add(cuponesDTO);
        });

        return cupones;
    }
}
