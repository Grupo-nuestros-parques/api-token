package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.portalplus.dto.LoginPortalPlusDTO;
import com.nuestrosparques.token.app.adapter.portalplus.request.UpdateProfile;
import com.nuestrosparques.token.app.adapter.portalplus.service.ValidLoginPortalPlusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nuestrosparques.token.app.adapter.tracking.service.TrackingService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/portal-plus")
public class LoginPortalPlusController {

    private final ValidLoginPortalPlusService validLoginPortalPlusService;
    private TrackingService trackingService;

    public LoginPortalPlusController(
            ValidLoginPortalPlusService validLoginPortalPlusService,
            TrackingService trackingService
    ) {
        this.validLoginPortalPlusService = validLoginPortalPlusService;
        this.trackingService = trackingService;
    }

    @GetMapping("/rut/{rut}")
    @ResponseBody
    LoginPortalPlusDTO getDataFolioCrematorio(
            @PathVariable("rut") Integer rut,
            @RequestParam(value = "password") String password
    ){
        LoginPortalPlusDTO loginPortalPlusDTO = validLoginPortalPlusService.validateLogin(rut, password);
        trackingService.registerTracking(
                "Inicio de sessión",
                rut,
                loginPortalPlusDTO.getTokenSession(),
                loginPortalPlusDTO.getAgentes().getNombre() + " " +loginPortalPlusDTO.getAgentes().getApellidoPaterno()
        );
        return loginPortalPlusDTO;
    }

    @GetMapping("/rut/{rut}/email")
    @ResponseBody
    LoginPortalPlusDTO guardarCorreoAgente(
            @PathVariable(value = "rut") Integer rut,
            @RequestParam(value = "email") String email
    ){
        return validLoginPortalPlusService.guardarCorreoAgente(rut, email);
    }

    @PostMapping(value = "/send/email")
    public Integer sendEmail(
            @RequestParam String correo
    ) {
        validLoginPortalPlusService.sendEmail(correo);
        return 1;
    }

    @GetMapping(value = "/restore/verify/{token}")
    public ResponseEntity<Integer> restoreVerifyPassword(@PathVariable("token") String token) {
        return new ResponseEntity<Integer>(validLoginPortalPlusService.restoreVerifyPassword(token), HttpStatus.OK);
    }


    @PostMapping(value = "/restore/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> restorePassword(@PathVariable("token") String token, @RequestBody String clave ) {
        return new ResponseEntity<Integer>(validLoginPortalPlusService.restorePassword(token, clave), HttpStatus.OK);
    }

    @PostMapping(value = "/agent/update-profile")
    public ResponseEntity<UpdateProfile> updateProfile(
            @RequestBody UpdateProfile updateProfile,
            @RequestParam("rutAgente") String rutAgente,
            @RequestParam("tokenSession") String tokenSession,
            @RequestParam("nombreCompletoAgente") String nombreCompletoAgente
    ) {
        trackingService.registerTracking(
                "Actualizar foto de perfil",
                Integer.valueOf(rutAgente),
                tokenSession,
                nombreCompletoAgente
        );
        return new ResponseEntity<UpdateProfile>(validLoginPortalPlusService.updateProfile(updateProfile), HttpStatus.OK);
    }
}
