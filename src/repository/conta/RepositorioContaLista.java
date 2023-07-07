package repository.conta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.conta.Conta; //foi implementada
import pattern.idGeneratorStrategy;//foi implementada


public class RepositorioContaLista implements RepositorioConta, Serializable { //está com erro devido a Classe conta não existir
    List<Conta> contas;
    idGeneratorStrategy idGenerator;

    public RepositorioContaLista() { 
        contas = new ArrayList<>();
        idGenerator = new SequencialContaIdGeneratorStrategy();


    }

        /*

    @Override //corrigido
    public Conta inserir_conta(Conta conta) throws ContaNaoCadastradaException {
        if(conta.getNumero() == null) {

            conta.setNumero(idGenerator.nextId());

        }
        try {
            while (buscar_conta(conta.getNumero()) != null) {
                conta.setNumero(idGenerator.nextId());
            }
        }catch (ContaNaoCadastradaException ex) { 
            contas.add(conta);
        }
        return conta;
    }

    @Override //corrigido
    public void deletar_conta(Conta conta) throws ContaNaoCadastradaException {
        if(!conta.remove(conta)) {
            throw new ContaNaoCadastradaException();
        }

        
    }

    @Override 
    public void alterar_conta(Conta conta) throws ContaJaCadastradaException { 

        //não existe necessidade de alterar essas contas

    }

    @Override
    public Conta buscar_conta(String numero) throws ContaNaoCadastradaException { 
        for(Conta conta : contas) {
            if (conta.getNumero().equals(numero)) { 
                return conta;
            }

        }throw new ContaNaoCadastradaException();
    }
     */

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