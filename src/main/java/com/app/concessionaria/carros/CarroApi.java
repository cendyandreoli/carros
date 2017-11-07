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
    public Carro getById(@PathVariable("id") UUID id){
        return carroRepository.getById(id);
    }

    @PostMapping()
    @ApiOperation(value="Salvar um novo carro")
    public Carro save(@RequestBody Carro carro){
        carro.setId(UUID.randomUUID());
        carroRepository.save(carro);
        return carro;
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualizar carro")
    public Carro atualiza(@RequestBody Carro carroAtualizado, @PathVariable("id") UUID id){
        Carro carro = carroRepository.findOne(id);
        carro.atualizaCarroExistente(carroAtualizado);
        carroRepository.save(carro);
        return carro;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta carro")
    public void deleta(@PathVariable("id") UUID id, Carro carro){
        carroRepository.delete(id);
    }

}
