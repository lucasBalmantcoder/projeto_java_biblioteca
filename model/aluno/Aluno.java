package model.aluno;

import java.io.Serializable;

public class Aluno implements Serializable {
  
  private String nome;
  private String cpf;
  private String matricula;
  private String endereco;
  private Double contato; 
  //private boolean bloqueado; vou fazer um método para retorna se
  // ele está ou não bloqueado


public Aluno(String nome, String cpf, String matricula, String endereco,
double contato) {
    this.nome = nome;
    this.cpf = cpf;
    this.matricula = matricula;
    this.endereco = endereco;
    this.contato = contato;
}


  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getMatricula() {
    return this.matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public Double getContato() {
    return this.contato;
  }

  public void setContato(Double contato) {
    this.contato = contato;
  }

  public String toString() {
    return nome;
  }

}