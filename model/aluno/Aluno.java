package model.aluno;

import java.io.Serializable;

public class Aluno implements Serializable {
  
  private String nome;
  private String cpf;
  private String matricula;
  private String endereco;
  private Double contato; 
  //private boolean bloqueado; vou fazer um m�todo para retorna se
  // ele est� ou n�o bloqueado
}

public Aluno(String nome, String cpf, String matricula, String endereco,
double contato) {
    this.nome = nome;
    this.cpf = cpf;
    this.matricula = matricula;
    this.endereco = endereco;
    this.contato = contato;
}
