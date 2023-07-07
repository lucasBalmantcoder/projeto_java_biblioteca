package universidade;

//import java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

//import local
import model.aluno.Aluno;
import repository.aluno.RepositorioAluno;
import repository.aluno.RepositorioAlunoLista;
import repository.conta.RepositorioConta;
import repository.conta.RepositorioContaLista;

//import exce��es
import repository.aluno.AlunoNaoCadastradoException;
import repository.aluno.CPFJaCadastradoException;



public class BibliotecaUnivesidade {
    
    //arquivovo para salvar os dados
    private final File arquivo = new File("biblioteca.liv");
    
    private RepositorioAluno repositorioAluno;
    private RepositorioConta repositorioConta;

    /* Padr�o do projeto Sigleton*/

    //Atributo est�tico que vai manter a �nica 
    //inst�ncia da classe 

    private static BibliotecaUnivesidade instance = null;

    //Construtor deve ser privada garantindo que n�o seja chamado de
    //fora da classe
    private BibliotecaUnivesidade() throws BibliotecaException {
        if(arquivo.exists()) {
               loadData();//falta implementar
        }else {
            repositorioAluno = new RepositorioAlunoLista();
            repositorioConta = new RepositorioContaLista();

        }
    }


    //M�todo getInstance, respons�vel por fornecer a �nica inst�ncia
    //da classe

    public static BibliotecaUnivesidade getInstance() throws BibliotecaException {
        if(instance == null)  {
            instance = new BibliotecaUnivesidade();
        }
        return instance;
    }

    public void inserir_aluno(Aluno aluno) throws CPFJaCadastradoException{
        repositorioAluno.inserir_aluno(aluno);
    }

    public void alterar_aluno(Aluno aluno) throws AlunoNaoCadastradoException {
        repositorioAluno.alterar_aluno(aluno);
    }

    public Aluno buscar_Aluno(String cpf) throws AlunoNaoCadastradoException {
        repositorioAluno.buscar_aluno(cpf);

    }

    public void deletar_aluno(Aluno aluno) throws BibliotecaException,
     AlunoNaoCadastradoException  {
        repositorioAluno.deletar_aluno(aluno);

    }

    public List<Aluno>getAllaAlunos() {
        return repositorioAluno.getAll();
    }

    //talvez seja necessario fazer altera��es no reposit�rio aluno
    //falta implementar os m�todo da conta



    // a partir desse ponto s�o os m�todos de armazenamento de dados
    private void loadData() throws BibliotecaException {
        try { 
            FileInputStream f = new FileInputStream(arquivo);
            ObjectInputStream o = new ObjectInputStream(f);

            repositorioAluno = (RepositorioAluno) o.readObject();
            repositorioConta = (RepositorioConta) o.readObject();

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
            o.writeObject(repositorioAluno);

            o.close();
            f.close();

        }catch (IOException e) {
            throw new BibliotecaException("Erro ao gravar dados no arquivo", e);
            

        }
    }

}

