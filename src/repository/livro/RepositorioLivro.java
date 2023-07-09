package repository.livro;

import java.util.List;

import model.livro.Livro;

public interface RepositorioLivro {

    void inserir_livro(Livro livro) throws LivroJaCadastradoException;

    void alterar_livro(Livro livro) throws LivroNaoCadastradoException;

    void deletar_livro(Livro livro) throws LivroNaoCadastradoException;

    Livro buscar_livro(String titulo) throws LivroNaoCadastradoException;

    List<Livro> getAll();

    
}
