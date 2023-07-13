package repository.emprestimo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.emprestimo.*;
import pattern.idGeneratorStrategy;//foi implementada
import repository.SequencialContaIdGeneratorStrategy;


public class RepositorioEmprestimoLista implements RepositorioConta, Serializable { //est? com erro devido a Classe conta n?o existir
    List<Emprestimo> emprestimos;
    idGeneratorStrategy idGenerator;

    public RepositorioEmprestimoLista() { 
        emprestimos = new ArrayList<>();
        index = new SequencialContaIdGeneratorStrategy();


    }

        

    @Override //corrigido
    public Emprestimo inserir_novo_Emprestimo(Emprestimo emprestimo) throws EmprestimoNaoCadastradoException {
        if(emprestimo.getNumero() == null) {

            conta.setNumero(idGenerator.nextId());

        }
        try {
            while (buscar_conta(conta.getNumero()) != null) {
                conta.setNumero(idGenerator.nextId());
            }
        }catch (EmprestimoNaoCadastradoException ex) { 
            contas.add(conta);
        }
        return conta;
    }

    @Override //corrigido
    public void deletar_conta(Conta conta) throws EmprestimoNaoCadastradoException {
        if(!conta.remove(conta)) {
            throw new EmprestimoNaoCadastradoException();
        }

        
    }

    @Override 
    public void alterar_conta(Conta conta) throws EmprestimoJaCadastradoException { 

        //não existe necessidade de alterar essas contas

    }

    @Override
    public Conta buscar_conta(String numero) throws EmprestimoNaoCadastradoException { 
        for(Conta conta : contas) {
            if (conta.getNumero().equals(numero)) { 
                return conta;
            }

        }throw new EmprestimoNaoCadastradoException();
    }
     

    @Override
    public List<Conta> getAll(){
        return new ArrayList<>();
    }

    @Override //impossivel fazer essa chamada no momento
    public List<Conta> getAll(String cpf) {
        List<Conta> lista = new ArrayList<>();
        for(Conta conta : contas) {
            if(conta.getMatricula().getCpf().equals(cpf)) {
                lista.add(conta);

            }
        }return lista;
    }
}