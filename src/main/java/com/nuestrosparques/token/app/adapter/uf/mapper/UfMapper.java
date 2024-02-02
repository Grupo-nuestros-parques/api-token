package com.nuestrosparques.token.app.adapter.uf.mapper;

import com.nuestrosparques.token.app.adapter.uf.dto.UfDTO;
import com.nuestrosparques.token.app.adapter.uf.response.UfResponse;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UfMapper {

    public UfDTO transformUfResponseToUfDTO(UfResponse ufResponse){
        UfDTO ufDTO = new UfDTO();
        ufDTO.setA2(ufResponse.getMsg());
        ufDTO.setA1(ufResponse.getStatus());
        ufDTO.setA4(ufResponse.getUf().getDate());
        ufDTO.setA3(ufResponse.getUf().getValue());
        return ufDTO;
    }

    public UfDTO transformUfResponseToErrorUf(){
        UfDTO ufDTO = new UfDTO();
        ufDTO.setA2("Servicio no encontrado");
        ufDTO.setA1(4);
        ufDTO.setA4(new Date());
        ufDTO.setA3(0.0);
        return ufDTO;
    }
}
