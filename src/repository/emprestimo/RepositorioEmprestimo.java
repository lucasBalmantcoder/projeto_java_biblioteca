package repository.emprestimo;

import java.util.List;

import model.emprestimo.*;

public interface RepositorioEmprestimo {

    //Conta inserir_conta(Conta conta) throws ContaNaoCadastradaException;
    Emprestimo inserir_novo_emprestimo() throws EmprestimoNaoCadastradoException;

    //void alterar_conta(Conta conta) throws ContaJaCadastradaException;
    void alterar_emprestimo(Emprestimo emprestimo) throws EmprestimoJaCadastradoException;
    //void deletar_conta(Conta conta) throws ContaNaoCadastradaException;
    void deletar_emprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradoException;
    // Conta buscar_conta(Conta conta) throws ContaNaoCadastradaException;
    Emprestimo buscar_emprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradoException;

    List<Emprestimo> getAll();

    

}
