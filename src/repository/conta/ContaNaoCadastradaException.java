package repository.conta;

import repository.RepositoryException;

public class ContaNaoCadastradaException extends RepositoryException {
    public ContaNaoCadastradaException() {
        super("Conta n�o cadasTrada");
    }
    
}
