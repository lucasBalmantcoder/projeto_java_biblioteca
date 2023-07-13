package repository.exemplar;

import repository.RepositoryException;

public class ExemplarNaoCadastradoException extends RepositoryException{
    public ExemplarNaoCadastradoException() {
        super("Exemplar não cadastrado");
    } 
    
}
