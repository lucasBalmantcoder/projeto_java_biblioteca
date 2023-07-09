package universidade;

//import java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

//import local
import model.aluno.Aluno;
import model.conta.Conta;
import repository.aluno.*;
import repository.conta.*;

//import livro
import repository.livro.*;
import model.livro.*;


//import exceções
//import repository.aluno.AlunoNaoCadastradoException;
//import repository.aluno.CPFJaCadastradoException;
//import local.*; com asteriscos serve para fazer chamada



public class BibliotecaUniversidade {
    
    //arquivovo para salvar os dados
    private final File arquivo = new File("biblioteca.liv");
    
    //chmada de arquivo dos repositórios aluno
    private RepositorioAluno repositorioAluno;
    private RepositorioLivro repositorioLivro;
    //private RepositorioConta repositorioConta;

    /* Padrão do projeto Sigleton*/

    //Atributo est?tico que vai manter a ?nica 
    //instância da classe 

    private static BibliotecaUniversidade instance = null;

    //Construtor deve ser privada garantindo que não seja chamado de
    //fora da classe

    private BibliotecaUniversidade() throws BibliotecaException {
        if(arquivo.exists()) {
               loadData();//implementado
        } else {
            repositorioAluno = new RepositorioAlunoLista();
            repositorioLivro = new RepositorioLivroLista();
            //repositorioConta = new RepositorioContaLista();
           //tenta fazer altera??es para fazer as chamadas da conta
        }
    }


    //Método getInstance, responsavel por fornecer a única instância
    //da classe

    public static BibliotecaUniversidade getInstance() throws BibliotecaException {
        if(instance == null)  {
            instance = new BibliotecaUniversidade();
        }
        return instance;
    }


    //Inicialização de chamada do Aluno


    public void inserir_aluno(Aluno aluno) throws CPFJaCadastradoException {
        repositorioAluno.inserir_aluno(aluno);
    }


    public void alterar_aluno(Aluno aluno) throws AlunoNaoCadastradoException {
        repositorioAluno.alterar_aluno(aluno);
        
    }

    public Aluno buscar_Aluno(String cpf) throws AlunoNaoCadastradoException {
        return repositorioAluno.buscar_aluno(cpf);

    }

    public void deletar_aluno(Aluno aluno) throws BibliotecaException,
     AlunoNaoCadastradoException  {
        repositorioAluno.deletar_aluno(aluno);

    }

    public List<Aluno>getAllAlunos() {
        return repositorioAluno.getAll();
    }


    //inicialização de chamadas do Livro

    /***
     * FInalizo toda a parte de inicialização de chamadas
    */
    public void inserir_livro(Livro livro) throws LivroJaCadastradoException {
        repositorioLivro.inserir_livro(livro);
    }

    public void alterar_livro(Livro livro) throws LivroNaoCadastradoException{
        repositorioLivro.alterar_livro(livro);
    } 

    public Livro buscar_Livro(String titulo) throws LivroNaoCadastradoException {
        return repositorioLivro.buscar_livro(titulo);
    }
    
    public void deletar_livro(Livro livro) throws BibliotecaException, LivroNaoCadastradoException {
        repositorioLivro.deletar_livro(livro);
    } 


    //talvez seja necessario fazer alterações no repositório aluno
    //falta implementar os método da conta



    // a partir desse ponto são os métodos de armazenamento de dados
    private void loadData() throws BibliotecaException {
        try { 
            FileInputStream f = new FileInputStream(arquivo);
            ObjectInputStream o = new ObjectInputStream(f);

            repositorioAluno = (RepositorioAluno) o.readObject();
            //repositorioLivro = (RepositorioLivro) o.readObject();
            //repositorioConta = (RepositorioConta) o.readObject();

            o.close();
            f.close();
        }catch (Exception e) {
            throw new BibliotecaException("Erro ao carregar dados do arquivo", e);


        }
    }

    public void exit() throws BibliotecaException { 
        try { 
            FileOutputStream f = new FileOutputStream(arquivo);
            ObjectOutputStream o = new ObjectOutputStream(f);

            //salvar dados 
            o.writeObject(repositorioAluno);
            // o.writeObject(repositorioLivro);
            //o.writeObject(repositorioAluno);

            o.close();
            f.close();

        }catch (IOException e) {
            throw new BibliotecaException("Erro ao gravar dados no arquivo", e);
            

        }
    }

}

