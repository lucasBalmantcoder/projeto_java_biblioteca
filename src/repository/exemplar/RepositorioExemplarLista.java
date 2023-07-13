package repository.exemplar;

//import local
import model.exemplar.*;
import pattern.idGeneratorStrategy;
import repository.SequencialContaIdGeneratorStrategy;
//import repository.exemplar.*;


//import java
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RepositorioExemplarLista implements RepositorioExemplar,
Serializable{

    List<Exemplar> exemplares= new ArrayList<>();
    idGeneratorStrategy index;

    public RepositorioExemplarLista() {
        this.exemplares = new ArrayList<Exemplar>();
        index = new SequencialContaIdGeneratorStrategy();
    
    }

    @Override
    public void inserir_exemplar(Exemplar exemplar) throws 
    CodigoJaCadastradoException {
        if(exemplar.getId_exemplar() == null) {
            exemplar.setId_exemplar(index.nextId());
        }

        try {
            buscar_exemplar(exemplar.getId_exemplar());
            throw new CodigoJaCadastradoException();
        }catch (ExemplarNaoCadastradoException ex) {
            exemplares.add(exemplar);
        }


    }

    @Override 
    public void alterar_exemplar(Exemplar exemplar) throws ExemplarNaoCadastradoException {
        //não há necessidade de atualizar o objeto
        buscar_exemplar(exemplar.getId_exemplar());
    }

    @Override
    public void deletar_exemplar(Exemplar exemplar)throws ExemplarNaoCadastradoException {
        if(!exemplares.remove(exemplar)) { 
        //se for direrente de "alunos" remova aluno
            throw new ExemplarNaoCadastradoException();
        }
    }

    @Override
    public Exemplar buscar_exemplar(String id_exemplar) throws 
    ExemplarNaoCadastradoException {
        
        for(Exemplar exemplar : exemplares) { 
            if (exemplar.getId_exemplar().equals(id_exemplar)) {
                return exemplar;
            }
        }
        throw new ExemplarNaoCadastradoException();

    }

    @Override
    public List<Exemplar> getAll() { 
        return new ArrayList<>(exemplares);
    }


    
}
