package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.uf.dto.UfDTO;
import com.nuestrosparques.token.app.adapter.uf.service.UfService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uf")
public class UfController {

    private final UfService ufService;

    public UfController(UfService ufService) {
        this.ufService = ufService;
    }

    @GetMapping
    @ResponseBody
    UfDTO getUfValue(){
        return ufService.getUfValue();
    }
}
