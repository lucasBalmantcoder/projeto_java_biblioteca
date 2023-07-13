package repository.emprestimo;

import repository.RepositoryException;

public class EmprestimoNaoCadastradoException extends RepositoryException {
    public EmprestimoNaoCadastradoException() {
        super("Emprestimo não cadastrado");
    }
    
}
