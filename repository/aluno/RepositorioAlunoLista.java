package repository;


import repository.aluno.AlunoNaoCadastradoException;
//import local
import repository.aluno.RepositorioAluno;
import model.aluno.Aluno;
//import java
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RepositorioAlunoLista implements RepositorioAluno,
Serializable{

    List<Aluno> alunos;

    public RepositorioAlunoLista() {
        this.alunos = new ArrayList<Aluno>();
    
    }

    @Override
    public void inserir_aluno(Aluno aluno) throws 
    CPFJaCadastradoException {
        try {
            buscar_aluno(aluno.getCpf());
            throw new CPFJaCadastradoException();
        }catch (AlunoNaoCadastradoException ex) {
            alunos.add(aluno);
        }


    }

    @Override 
    public void alterar_aluno(Aluno aluno) throws AlunoNaoCadastradoException {
        //não há necessidade de atualizar o objeto
        buscar_aluno(aluno.getCpf());
    }

    @Override
    public void deletar_aluno(Aluno aluno) throws AlunoNaoCadastradoException {
        if(!alunos.remove(aluno)) { 
        //se for direrente de "alunos" remova aluno
            throw new AlunoNaoCadastradoException();
        }
    }

    @Override
    public Aluno buscar_aluno(String cpf) throws 
    AlunoNaoCadastradoException {
        
        for(Aluno aluno : alunos) { 
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        throw new AlunoNaoCadastradoException();

    }

    @Override
    public List<Aluno> getAll() { 
        return new ArrayList<>(alunos);
    }


    
}
