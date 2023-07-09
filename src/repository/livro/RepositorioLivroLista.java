package repository.livro;

import model.aluno.Aluno;
import model.livro.*;
import repository.livro.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepositorioLivroLista implements RepositorioLivro, Serializable {

  List<Livro> livros;

  public RepositorioLivroLista() {
    this.livros = new ArrayList<Livro>();
  }

  @Override
  public void inserir_livro(Livro livro) throws LivroJaCadastradoException {
    try {
      buscar_livro(livro.getTitulo());
      throw new LivroJaCadastradoException();
    } catch (LivroNaoCadastradoException ex) {
      livros.add(livro);
    }
  }

  @Override
  public void alterar_livro(Livro livro) throws LivroNaoCadastradoException {
    // Em memória, não há necessidade de atualizar objeto
    buscar_livro(livro.getTitulo());
  }

  @Override
  public void deletar_livro(Livro livro) throws LivroNaoCadastradoException {
    if (!livros.remove(livro)) {
      throw new LivroNaoCadastradoException();
    }
  }
    
    @Override
    public Livro buscar_livro(String titulo) throws LivroNaoCadastradoException {
        
        for(Livro livro: livros) { 
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        throw new LivroNaoCadastradoException();

    }

  @Override
  public List<Livro> getAll() {
    return new ArrayList<>(livros);
  }

}
