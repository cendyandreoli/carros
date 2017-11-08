package com.app.concessionaria.concessionaria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/concessionaria")
@Api(description = "API para acesso e manipulação das concessionarias")
public class ConcessionariaAPI {
    @Autowired
    private ConcessionariaRepository concessionariaRepository;

    @GetMapping()
    @ApiOperation("Busca lista de concessionárias")
    public Page<Concessionaria> get(){
        return concessionariaRepository.concessionarias(new PageRequest(0, 10));
    }

    @GetMapping("/{id}")
    @ApiOperation("Busca Concessionária pela id")
    public Concessionaria getById(@PathVariable("id") UUID id){
        return concessionariaRepository.getById(id);
    }

    @PostMapping()
    @ApiOperation("Salva uma nova concessionária")
    public Concessionaria save(@RequestBody Concessionaria concessionaria){
        concessionaria.setId(UUID.randomUUID());
        return concessionariaRepository.save(concessionaria);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza uma concessionária existente")
    public Concessionaria atualiza(@RequestBody Concessionaria novaConcessionaria, @PathVariable("id") UUID id){
        Concessionaria concessionaria = concessionariaRepository.findOne(id);
        concessionaria.atualizaConcessionariaExistente(novaConcessionaria);
        return concessionariaRepository.save(concessionaria);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Remove uma concessionária pela ID")
    public void remove(@PathVariable("id") UUID id, Concessionaria concessionaria){
        concessionariaRepository.delete(id);
    }


}
