package com.nuestrosparques.token.app.adapter.qr.mapper;

import com.nuestrosparques.token.app.adapter.qr.dto.CrematorioFcDTO;
import com.nuestrosparques.token.app.adapter.qr.dto.CrematorioScanDto;
import com.nuestrosparques.token.app.adapter.qr.response.CrematorioResponse;
import com.nuestrosparques.token.app.adapter.qr.response.CrematorioScanResponse;
import org.springframework.stereotype.Component;

@Component
public class QrMapper {

    public CrematorioFcDTO transformResponseToCrematorioFcDTO(CrematorioResponse crematorioResponse) {
        CrematorioFcDTO crematorioFcDTO = new CrematorioFcDTO();
        crematorioFcDTO.setA1(crematorioResponse.getDescription());
        crematorioFcDTO.setA2(crematorioResponse.getCtto());
        crematorioFcDTO.setA3(crematorioResponse.getEstado());
        crematorioFcDTO.setA4(crematorioResponse.getLabels());
        return crematorioFcDTO;
    }

    public CrematorioScanDto transformResponseToCrematorioScanDTO(CrematorioScanResponse crematorioScanResponse){
        CrematorioScanDto crematorioScanDto = new CrematorioScanDto();
        crematorioScanDto.setA1(crematorioScanResponse.getDescrionEstado());
        crematorioScanDto.setA2(crematorioScanResponse.getCambio());
        crematorioScanDto.setA3(crematorioScanResponse.getEstado());
        crematorioScanDto.setA4(crematorioScanResponse.getRespuesta());
        return crematorioScanDto;
    }
}
