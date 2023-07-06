package repository.conta;

import java.util.List;

import model.conta.Conta;

public interface RepositorioConta {

    Conta inserir_conta(Conta conta) throws ContaNaoCadastradaException;

    void alterar_conta(Conta conta) throws ContaJaCadastradaException;

    void deletar_conta(Conta conta) throws ContaNaoCadastradaException;

    Conta buscar_conta(Conta conta) throws ContaNaoCadastradaException;

    List<Conta> getAll();

    List<Conta> getAll(String cpf);

}
