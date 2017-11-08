package com.app.concessionaria.veiculos;

import com.app.concessionaria.concessionaria.Concessionaria;
import com.app.concessionaria.concessionaria.ConcessionariaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/veiculo")
@Api(description = "API para acesso e manipulação dos veiculos")
public class VeiculoApi {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ConcessionariaRepository concessionariaRepository;

    @GetMapping()
    @ApiOperation(value="Buscar lista de veiculos")
    public Page<Veiculo> get() {
        return veiculoRepository.listaDeCarros(new PageRequest(0,5));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar carro por id")
    public Veiculo getById(@PathVariable("id") UUID id){
        return veiculoRepository.getById(id);
    }

    @PostMapping()
    @ApiOperation(value="Salvar um novo veiculo")
    public ResponseEntity<?> save(@RequestBody Veiculo veiculo){
        if(veiculo.getConcessionaria() != null){
            List<Concessionaria> concessionrias = (List<Concessionaria>) concessionariaRepository.findAll();
            if(concessionrias.size()<0){

            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não tem concessionaria então não tem ID, demente");
            }
        }
        veiculo.setId(UUID.randomUUID());
        veiculoRepository.save(veiculo);
        return new ResponseEntity<Veiculo>(veiculo, null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualizar carro")
    public Veiculo atualiza(@RequestBody Veiculo veiculoAtualizado, @PathVariable("id") UUID id){
        Veiculo veiculo = veiculoRepository.findOne(id);
        Concessionaria concessionaria = concessionariaRepository.findOne(veiculoAtualizado.getConcessionaria().getId());
        veiculo.setConcessionaria(concessionaria);
        veiculo.atualizaCarroExistente(veiculoAtualizado);
        veiculoRepository.save(veiculo);
        return veiculo;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta veiculo")
    public void deleta(@PathVariable("id") UUID id, Veiculo veiculo){
        veiculoRepository.delete(id);
    }

}
