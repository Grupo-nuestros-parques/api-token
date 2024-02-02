package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.qr.dto.CrematorioFcDTO;
import com.nuestrosparques.token.app.adapter.qr.dto.CrematorioScanDto;
import com.nuestrosparques.token.app.adapter.qr.service.QrService;
import com.nuestrosparques.token.app.request.CrematorioScanRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qr")
public class QrController {

    private final QrService qrService;

    public QrController(QrService qrService) {
        this.qrService = qrService;
    }

    @GetMapping("/fc/{nroFolio}")
    @ResponseBody
    CrematorioFcDTO getDataFolioCrematorio(@PathVariable("nroFolio") Integer nroFolio){
        return qrService.getDataFolioCrematorio(nroFolio);
    }

    @PostMapping("/scan")
    @ResponseBody
    String getDataFolioCrematorio(@RequestBody CrematorioScanRequest crematorioScanRequest){
        return qrService.getDataFolioCrematorioScan(crematorioScanRequest);
    }
}
