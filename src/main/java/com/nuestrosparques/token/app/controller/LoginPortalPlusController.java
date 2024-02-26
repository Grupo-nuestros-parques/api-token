package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.portalplus.dto.LoginPortalPlusDTO;
import com.nuestrosparques.token.app.adapter.portalplus.service.ValidLoginPortalPlusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portal-plus")
public class LoginPortalPlusController {

    private final ValidLoginPortalPlusService validLoginPortalPlusService;

    public LoginPortalPlusController(ValidLoginPortalPlusService validLoginPortalPlusService) {
        this.validLoginPortalPlusService = validLoginPortalPlusService;
    }

    @GetMapping("/rut/{rut}")
    @ResponseBody
    LoginPortalPlusDTO getDataFolioCrematorio(@PathVariable("rut") Integer rut){
        return validLoginPortalPlusService.validateLogin(rut);
    }
}
