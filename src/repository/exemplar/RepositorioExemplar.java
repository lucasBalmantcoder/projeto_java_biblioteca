package repository.exemplar;

//import locais
import model.exemplar.*;


//import da linguagem java
import java.util.List;

public interface RepositorioExemplar {

    void inserir_exemplar(Exemplar exemplar) throws CodigoJaCadastradoException;

    void alterar_exemplar(Exemplar exemplar) throws ExemplarNaoCadastradoException;

    void deletar_exemplar(Exemplar exemplar) throws ExemplarNaoCadastradoException;

    Exemplar buscar_exemplar(String id_exemplar) throws ExemplarNaoCadastradoException;

        List<Exemplar> getAll();
 

    
}
