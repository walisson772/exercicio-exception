package model.entities;

import model.exception.DomainException;

public class Conta {

    private Integer numero;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta() {
    }

    public Conta(Integer numero, String titular, Double saldo, Double limiteSaque){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public void deposito(Double valor) {
        saldo += valor;
    }

    public void sacar(Double valor) throws DomainException {
        if (valor > limiteSaque){
            throw new DomainException("Erro de retirada: O valor excede o limite de retirada");
        }
        else if (valor > saldo){
            throw new DomainException("Erro de retirada: Saldo insuficiente");
        }
        else {
            saldo -= valor;
        }
    }

    public String toString() {
        return "Novo saldo: " + getSaldo();
    }
}