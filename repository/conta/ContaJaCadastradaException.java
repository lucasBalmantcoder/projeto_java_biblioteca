package repository.conta;

import repository.RepositoryException;

public class ContaJaCadastradaException extends RepositoryException {
   
    public ContaJaCadastradaException() {
        super("conta j� cadastrada");
    }
    
}
