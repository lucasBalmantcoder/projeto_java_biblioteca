package repository.exemplar;

import repository.RepositoryException;

public class CodigoJaCadastradoException extends RepositoryException{

    CodigoJaCadastradoException() {
        super("Codigo de livro já cadastrado");
    }
    
}
