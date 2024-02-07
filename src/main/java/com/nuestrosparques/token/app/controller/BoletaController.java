package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.boleta.dto.DteDto;
import com.nuestrosparques.token.app.adapter.boleta.response.BoletaResponse;
import com.nuestrosparques.token.app.adapter.boleta.service.BoletaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boleta")
public class BoletaController {

    private final BoletaService boletaService;

    public BoletaController(BoletaService boletaService) {
        this.boletaService = boletaService;
    }

    @GetMapping("/rut/{rut}")
    @ResponseBody
    List<BoletaResponse> getDataFolioCrematorio(@PathVariable("rut") Integer rut){
        return boletaService.getBoletaByRut(rut);
    }

    @GetMapping("/dte")
    @ResponseBody
    DteDto getDte(
            @RequestParam("folio") Integer folio,
            @RequestParam("tipoDocumento") Integer tipoDocumento,
            @RequestParam("rutEmpresa") Integer rutEmrpesa
    ){
        return boletaService.getDte(folio, tipoDocumento, rutEmrpesa);
    }
}
