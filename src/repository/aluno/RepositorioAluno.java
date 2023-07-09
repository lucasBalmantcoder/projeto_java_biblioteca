package repository.aluno;

//import locais
import model.aluno.Aluno;

//import da linguagem java
import java.util.List;

public interface RepositorioAluno {

    void inserir_aluno(Aluno aluno) throws CPFJaCadastradoException;

    void alterar_aluno(Aluno aluno) throws AlunoNaoCadastradoException;

    void deletar_aluno(Aluno aluno) throws AlunoNaoCadastradoException;

    Aluno buscar_aluno(String cpf) throws AlunoNaoCadastradoException;

        List<Aluno> getAll();
 

    
}
