package repository.exemplar;

//import local
import model.exemplar.*;
import repository.exemplar.*;


//import java
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RepositorioExemplarLista implements RepositorioExemplar,
Serializable{

    List<Exemplar> exemplares;

    public RepositorioExemplarLista() {
        this.exemplares = new ArrayList<Exemplar>();
    
    }

    @Override
    public void inserir_exemplar(Exemplar exemplar) throws 
    CodigoJaCadastradoException {
        try {
            buscar_exemplar(exemplar.getCodigo());
            throw new CodigoJaCadastradoException();
        }catch (ExemplarNaoCadastradoException ex) {
            exemplares.add(exemplar);
        }


    }

    @Override 
    public void alterar_exemplar(Exemplar exemplar) throws ExemplarNaoCadastradoException {
        //não há necessidade de atualizar o objeto
        buscar_exemplar(exemplar.getCodigo());
    }

    @Override
    public void deletar_exemplar(Exemplar exemplar)throws ExemplarNaoCadastradoException {
        if(!exemplares.remove(exemplar)) { 
        //se for direrente de "alunos" remova aluno
            throw new ExemplarNaoCadastradoException();
        }
    }

    @Override
    public Exemplar buscar_exemplar(int codigo) throws 
    ExemplarNaoCadastradoException {
        
        for(Exemplar exemplar : exemplares) { 
            if (exemplar.getCodigo() == codigo) {
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
