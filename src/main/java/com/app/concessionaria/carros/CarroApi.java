package com.app.concessionaria.carros;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/carro")
@Api(description = "API para acesso e manipulação dos concessionaria")
public class CarroApi{
    @Autowired
    private CarroRepository carroRepository;

    @GetMapping()
    @ApiOperation(value="Buscar lista de concessionaria")
    public Page<Carro> get() {
        return carroRepository.listaDeCarros(new PageRequest(0,5));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar carros por id")
    public Carro getById(@PathVariable("id") UUID id){
        return carroRepository.getById(id);
    }

    @PostMapping()
    @ApiOperation(value="Salvar um novo carros")
    public Carro save(@RequestBody Carro carro){
        carroRepository.save(carro);
        return carro;
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualizar carros")
    public Carro atualiza(@RequestBody Carro carroAtualizado, @PathVariable("id") UUID id){
        Carro carro = carroRepository.findOne(id);
        carro.atualizaCarroExistente(carroAtualizado);
        carroRepository.save(carro);
        return carro;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta carros")
    public void deleta(@PathVariable("id") UUID id, Carro carro){
        carroRepository.delete(id);
    }

}
