package com.nuestrosparques.token.app.adapter.boleta.mapper;

import com.nuestrosparques.token.app.adapter.boleta.dto.DteDto;
import org.springframework.stereotype.Component;

@Component
public class BoletaMapper {

    public DteDto transformDteToResponse(String data){
        DteDto dteDto = new DteDto();
        dteDto.setA1(data);
        return dteDto;
    }
}
