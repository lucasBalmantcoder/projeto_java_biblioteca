package repository.livro;

import repository.RepositoryException;

public class LivroJaCadastradoException extends RepositoryException {
    public LivroJaCadastradoException() {
        super("Livro já cadastrado");
    }
    
}
