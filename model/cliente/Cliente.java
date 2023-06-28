package model.cliente;

import java.io.Serializable;

public class Cliente implements Serializable {
    public static final String[] SEXO = {
        "Masculino",
        "Feminino"
    };
    private String cpf;
    private String nome;
    private int sexo;
    private String telefone;

    //método construtor
    public Cliente(String cpf, String nome, int sexo, String telefone){
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;

    }
    public String getCpf(){
        return this.cpf;
    }public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getNome(){
        return this.nome;
    }public void setNome(String nome){
        this.nome = nome;
    }

    public int getSexo(){
        return this.sexo;
    }
    
    public char getSexoChar(){
        return getSexoString().charAt(0);
    }

    public String getSexoString(){
        return SEXO[sexo-1];
    }

    public void setSexo(int Sexo){
        this.sexo = sexo;
    }
    
    public String getTelefone(){
        return this.telefone;
    }public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String toString(){
        return nome;
    }

}
