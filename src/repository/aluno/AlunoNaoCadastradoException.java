package repository.aluno;

import repository.RepositoryException;

public class AlunoNaoCadastradoException extends RepositoryException{
    public AlunoNaoCadastradoException() {
        super("Aluno n�o cadastrado");
    } 
    
}
