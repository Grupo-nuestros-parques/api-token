package com.nuestrosparques.token.app.adapter.pagos.mapper;

import com.nuestrosparques.token.app.adapter.pagos.dto.RezagosDTO;
import com.nuestrosparques.token.app.adapter.pagos.response.RezagosResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RezagosMapper {

    public List<RezagosDTO> transformRezagosToDTO(List<RezagosResponse> rezagosResponses){
        List<RezagosDTO> rezagos = new ArrayList<>();
        rezagosResponses.forEach(resp ->{
            RezagosDTO rezagosDTO = new RezagosDTO();
            rezagosDTO.setFolio(resp.getFolio());
            rezagosDTO.setFechaPago(resp.getFechaPago());
            rezagosDTO.setTipoMov(resp.getTipoMov());
            rezagosDTO.setMonto(resp.getMonto());
            rezagosDTO.setCuotasPag(resp.getCuotasPag());
            rezagosDTO.setValorUf(resp.getValorUf());
            rezagosDTO.setRut(resp.getRut());
            rezagosDTO.setDescripcionTipoMovimiento(resp.getDescripcionTipoMovimiento());
            rezagosDTO.setNombre(resp.getNombre());
            rezagosDTO.setApPaterno(resp.getApPaterno());
            rezagos.add(rezagosDTO);
        });

        return rezagos;
    }
}
