package model.conta;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Conta implements Serializable{
    private String numero;
    private Cliente titular;
    private double saldo;
    private Extrato extrato;

    public Conta(Cliente titular, String numero){
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
        this.extrato = new Extrato();
    }

    public Conta(Cliente titular){
        this(titular, null);
    }

    public void depositar(double valor){
        depositar(valor, "Depósitos");
    }

    protected void depositar(double valor, String hitorico) {
        double saldo_anterior = saldo;
        this.saldo += valor;
        this.extrato.addItem(new ItemExtrato(LocalDateTime.now(), 
                                            saldo_anterior, hitorico,
                                            valor, 'C', this.saldo));
        
    }
    public void sacar(double valor) throws Saldo_insuficiente_Exception{
        if(valor <= this.getDisponivel_para_saque()){
            double saldo_anterior = this.saldo;
            this.saldo -= valor;
            this.extrato.addItem(new ItemExtrato(LocalDateTime.now(),saldo_anterior,
                                                    "Saque", valor, 'D', this.saldo));
          
        }else{
            throw new Saldo_insuficiente_Exception(this, valor);
        }
    }

    public void transferir_para(Conta Destino, double valor) throws
    Saldo_insuficiente_Exception{
        if(valor <= this.getDisponivel_para_saque()) {
            double saldo_anterior = this.saldo;
            this.saldo -= valor;
            this.extrato.addItem(new ItemExtrato(LocalDateTime.now(),
                                        saldo_anterior,
                                     "Transferência da conta" + destino.getnumero(),
                                     valor,
                                      'C', destino.saldo));
        }else{
            throw new Saldo_insuficiente_Exception(this, valor);
        }
    }

    public abstract String getTipo();

    public Extrato getExtrato(){
        return extrato;
    }public void setExtrato(Extrato extrato){
        this.extrato = extrato;
    }

    public String getNumero(){
        return this.numero;
    }public void setNumero(String numero){
        return this.numero = numero;
    }

    public CLiente getTitular(){
        this.titular = titular;
    }public void setTitular(Cliente titular){
        this.titular = titular;
    }

    public double getSaldo(){
        return this.saldo = saldo;
    }public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public double getSaldoDisponivelParaSaque() {
        this.saldo = saldo;
    }

    public String toString(){
        return String.format("Número: %s\nTitular: %s\n Saldo: %.2f",
         this.numero,
         this.titular.getCpf() + " - " + this.titular.getNome(),
         this.saldo);
    }
}