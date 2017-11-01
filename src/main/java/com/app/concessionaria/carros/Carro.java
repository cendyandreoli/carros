package com.app.concessionaria.carros;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Carro {
    @Id
    private UUID id;
    private String placa;
    private String modelo;
    private String marca;
    private Date ano;
    private int motor;

    public Carro(){

    }

    public Carro(UUID id, String placa, String modelo, String marca, Date ano, int motor) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.motor = motor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public void atualizaCarroExistente(Carro novoCarro){
        this.placa = novoCarro.getPlaca();
        this.modelo = novoCarro.getModelo();
        this.marca = novoCarro.getMarca();
        this.ano = novoCarro.getAno();
        this.motor = novoCarro.getMotor();
    }
}
