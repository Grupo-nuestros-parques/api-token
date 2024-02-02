package com.nuestrosparques.token.app.controller;

import com.nuestrosparques.token.app.adapter.encargados.dto.LoginDTO;
import com.nuestrosparques.token.app.adapter.encargados.service.EncargadosService;
import com.nuestrosparques.token.app.request.LoginRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class EncargadosController {

    private final EncargadosService encargadosService;

    public EncargadosController(EncargadosService encargadosService) {
        this.encargadosService = encargadosService;
    }

    @PostMapping
    @ResponseBody
    LoginDTO validLogin(@RequestBody LoginRequest loginRequest){
        return encargadosService.validateLogin(loginRequest);
    }
}
