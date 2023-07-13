package repository.emprestimo;

import repository.RepositoryException;

public class EmprestimoJaCadastradoException extends RepositoryException {
   
    public EmprestimoJaCadastradoException() {
        super("Emprestimo já cadastrado");
    }
    
}
