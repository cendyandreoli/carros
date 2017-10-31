package com.app.carros.carro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/carro")
@Api(description = "API para acesso e manipulação dos carros")
public class CarroApi{
    @Autowired
    private CarroRepository carroRepository;

    @GetMapping()
    @ApiOperation(value="Buscar lista de carros")
    public Page<Carro> get() {
        return carroRepository.listaDeCarros(new PageRequest(0,5));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar carro por id")
    public Carro getById(@PathVariable UUID id){
        return carroRepository.getById(id);
    }

//    @PutMapping("/{id}")
//    @ApiOperation(value = "Buscar carro por id")
//    public Carro updateCarro(@PathVariable UUID id){
//        Carro carro = carroRepository.getById(id);
//    }

}
