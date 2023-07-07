package model.conta;

//import local
import model.historico.Historico;
import model.aluno.Aluno;

//import java
import java.io.Serializable;
public abstract class Conta implements Serializable {

private String numero;
private Aluno matricula;
private Historico historico;


    public Conta(String numero, Aluno matricula, Historico historico) {
        this.numero = numero;
        this.matricula = matricula;
        this.historico = new Historico();
    }



    //MÉTODOS GETTERS E SEETERS//

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aluno getMatricula() {
        return this.matricula;
    }

    public void setMatricula(Aluno matricula) {
        this.matricula = matricula;
    }

    public Historico getHistorico() {
        return this.historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    



    
}
