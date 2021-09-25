package com.app.concessionaria.concessionaria;

import com.app.concessionaria.veiculos.Veiculo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.UUID;

@Entity
public class Concessionaria {
    @Id
    private UUID id;
    private String nome;
    private String endereco;
    private Date ano;

    @OneToOne(mappedBy = "concessionaria")
    private Veiculo veiculo;

    public Concessionaria(){};

    public Concessionaria(UUID id, String nome, String endereco, Date ano) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.ano = ano;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public void atualizaConcessionariaExistente(Concessionaria concessionariaNova){
        this.nome = concessionariaNova.getNome();
        this.endereco = concessionariaNova.getEndereco();
        this.ano = concessionariaNova.getAno();
    }
}
