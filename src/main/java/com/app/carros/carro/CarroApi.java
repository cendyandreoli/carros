package com.app.carros.carro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarroApi {
    @RequestMapping(path = "", method = RequestMethod.GET)
    public String carro(){
        return "Teste";
    }
}
