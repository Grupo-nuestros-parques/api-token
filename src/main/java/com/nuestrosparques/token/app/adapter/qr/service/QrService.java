package com.nuestrosparques.token.app.adapter.qr.service;

import com.nuestrosparques.token.app.adapter.qr.dto.CrematorioFcDTO;
import com.nuestrosparques.token.app.adapter.qr.dto.CrematorioScanDto;
import com.nuestrosparques.token.app.request.CrematorioScanRequest;

public interface QrService {

    CrematorioFcDTO getDataFolioCrematorio(Integer nroFolio);
    String getDataFolioCrematorioScan(CrematorioScanRequest crematorioScanRequest);
}
