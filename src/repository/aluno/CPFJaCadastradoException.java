package repository.aluno;

import repository.RepositoryException;

public class CPFJaCadastradoException extends RepositoryException{

    CPFJaCadastradoException() {
        super("Cpf j� cadastrado");
    }
    
}
