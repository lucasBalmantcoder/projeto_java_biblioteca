package repository.livro;

import model.aluno.Aluno;
import model.exemplar.Exemplar;
import model.livro.*;
import pattern.idGeneratorStrategy;
import repository.conta.SequencialContaIdGeneratorStrategy;
import repository.livro.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RepositorioLivroLista implements RepositorioLivro, Serializable  {

  List<Livro> livros;
  idGeneratorStrategy index;

  public RepositorioLivroLista() {
    this.livros = new ArrayList<Livro>();
    index = new SequencialContaIdGeneratorStrategy();

  }

  @Override
  public void inserir_livro(Livro livro) throws LivroJaCadastradoException {
     if (livro.getNumero() == null) {
        livro.setNumero(index.nextId());
      }
    try {
     
      buscar_livro(livro.getNumero());
      throw new LivroJaCadastradoException();
    } catch (LivroNaoCadastradoException ex) {
      livros.add(livro);
    }
  }

  @Override
  public void alterar_livro(Livro livro) throws LivroNaoCadastradoException {
    // Em memória, não há necessidade de atualizar objeto
    buscar_livro(livro.getNumero());
  }

  @Override
  public void deletar_livro(Livro livro) throws LivroNaoCadastradoException {
    if (!livros.remove(livro)) {
      throw new LivroNaoCadastradoException();
    }
  }
    
    @Override
    public Livro buscar_livro(String numero) throws LivroNaoCadastradoException {
        
        for(Livro livro: livros) { 
            if (livro.getNumero().equals(numero)) {
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
