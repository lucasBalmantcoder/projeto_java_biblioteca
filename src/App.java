/**
 * @author Lucas Balmant
 * 
 * Esse projeto foi baseado no projeto do professo Enoque
 * 
 * Nas primeiras versões estava com problemas nas chamadas, alguns dos erros acredito que
 * foram causados por conta de alguma incopatiblidade do java com vs code, ou  pode   ser
 * por conta de alguma no própria linguagem que eu desconheço, fiz algumas alterações pa-
 * resolver isso, criei um novo projeto no vs code vazio e quando se faz isso, algumas   
 * algumas pastas são criadas automáticamente elas são:
 * .vs code
 * bin
 * lib
 * src
 * -
 * Deppois copiei, todo o projeto para dentro da pasta src, isso é claro no novo projeto
 * e até o momento todas as minhas chamadas estão funcionando perfeitamente.
 * **/

import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
//import locais


import model.aluno.*;
import repository.aluno.*;
import repository.conta.*;
import repository.RepositoryException;

//import do livro
import model.livro.*;
import repository.livro.*;

//"fachada"
import universidade.BibliotecaUniversidade;
import universidade.BibliotecaException;


class App {
        //chamada de biblioteca
    private static BibliotecaUniversidade biblioteca;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

       
        try {
            System.out.println("Carregando o sistema...");

        //essa chamada aqui estava fazendo meu programa quebrar haha
        
        //Essa linha logo a baixo: 
        /* 
         * Atribui á uma variável, uma intância da classe 'Biblioteca universidade' 
         * por meio do método estático 'getIntance'
         * 
         * A classe implementa o padrão de designer 'Sigleton', que garante que exista
         * apenas uma intância dessa classe em todo o programa, o método 'getInstance'
         * é responsável por retornar essa única instancia existente ou cria--lá caso
         * ainda não tenha sido criada.
         * */
        
            biblioteca = BibliotecaUniversidade.getInstance();


            int opcao;
            do{
                limpaTela();
                System.out.println("    MENU PRINCIPAL");
                System.out.println("====================");
                System.out.println("<1> Cadastro de alunos");
                System.out.println("<2> Cadastrar Livros");
                System.out.println("<3> Emprestimos");
                System.out.println("<0> Sair");
                System.out.printf("Escolha uma opcão:");

                try {

                    opcao = Integer.valueOf(scanner.nextLine());

                } catch (Exception e) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 0: 
                        limpaTela();
                        break;
                    case 1:
                        cadastro_de_alunos();
                        break;

                    case 2:
                        //cadastro_de_livro();
                        break;
                    case 3: 
                        //emprestimos();
                        
                        break;
                
                    default:
                        break;
                }
                
            }while(opcao != 0);

            //- bancoFacade.exit();
           biblioteca.exit();
            
        } catch (Exception e) {
            System.err.println("Erro ao carregar dados");
            e.printStackTrace();
        }
        System.out.println("Programa terminado");


    }

    private static void limpaTela(){ 
        for(int i = 0; i < 50; i++) {
            System.out.println();

        }
    }


    private static void cadastro_de_alunos() {
        int opcao;

        do {
            limpaTela();
            System.out.println("CADASTRO DE ALUNO");
            System.out.println("=================");
            System.out.println();
            System.out.println("<1> Incluir Aluno"); 
            System.out.println("<2> Alterar Aluno");
            System.out.println("<3> Excluir Aluno");
            System.out.println("<4> Listar Aluno");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try { 
                opcao = Integer.valueOf(scanner.nextLine());

            } catch (Exception e) {
                opcao = 0;
                
            }
            switch (opcao) {
                case 0: 
                    limpaTela(); //ok 
                    break;
                case 1: 
                    inserir_Aluno(); //está funcioando
                    break;
                case 2:
                    alterar_aluno();
                    break;
                case 3: 
                    deletar_aluno(); //está funcionando
                    break;
                case 4: 
                    listar_alunos(); // está funcionando
                    break;
            }
        } while (opcao != 0);
    }

    private static void inserir_Aluno() { //está funcioando
        limpaTela();
        System.out.println("CADASTRO DE ALUNO");
        System.out.println("=================");

        System.out.print("NOME: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF:");
        String cpf = scanner.nextLine();
        

        System.out.print("MATRICULA: ");
        String matricula = scanner.nextLine();

        System.out.print("ENDEREÇO: ");
        String endereco = scanner.nextLine();

        System.out.print("CONTATO: ");
        String contato = scanner.nextLine();

        Aluno aluno = new Aluno(nome, cpf, matricula ,endereco , contato);

        try {
            biblioteca.inserir_aluno(aluno);
            System.out.println("Cliente Cadastrado");
        } catch (RepositoryException ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();
         
         
    }

    //falta arrumar


    private static void listar_alunos() {//está funcionando
        limpaTela();
        List<Aluno> alunos = biblioteca.getAllAlunos();
        System.out.println("CPF            NOME          CONTATO");
        System.out.println("============== ============= ===========");
        for(Aluno aluno: alunos) {
            
            System.out.printf("%14s ", aluno.getCpf());
            System.out.printf("%-13s ", aluno.getNome());
            System.out.printf("%-5s \n", aluno.getContato());
           

        }//456566

        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();


    }

    private static void deletar_aluno() {
        limpaTela();
        System.out.println("Excluir qual Aluno?");
        System.out.println("===================");
        System.out.println("Qual o CPF?");
        String cpf = scanner.nextLine();

        try {
            Aluno aluno = biblioteca.buscar_Aluno(cpf);
            System.out.println();
            System.out.println("NOME:" + aluno.getNome());
            System.out.println("CPF:" + aluno.getNome());

            //System.out.println("NOME:" + aluno.getNome());
            System.out.println();

            System.out.println("Excluir Aluno? (s/n)");
            String resposta = scanner.nextLine();

            if(resposta.equalsIgnoreCase("s")){
                biblioteca.deletar_aluno(aluno);
                System.out.println("ALuno Deletado!");


            }
        }catch (RepositoryException | BibliotecaException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();
    }

    private static void alterar_aluno() {
        limpaTela();
        System.out.println("Alterar Info Aluno");
        System.out.println("==================");

        System.out.print("CPF:");
        String cpf = scanner.nextLine();
        try {
            Aluno aluno = biblioteca.buscar_Aluno(cpf);
            System.out.println();
            System.out.println("NOME: " + aluno.getNome());
            System.out.println("NOME: (<ENTER> para não alterar)");

            String nome = scanner.nextLine();

            if(!nome.equals("")) {
                aluno.setNome(nome);
            }
            System.out.println();

            biblioteca.alterar_aluno(aluno);
            System.out.println("Cliente Alterado!");
            System.out.println();
            
        } catch (RepositoryException ex)  {
            System.err.println(ex.getMessage());
        } 
        
        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();

    }

    /*
    private static void cadastro_de_livro() {
        int opcao;

        do {
            limpaTela();
            System.out.println("CADASTRO DE LIVRO");
            System.out.println("=================");
            System.out.println();
            System.out.println("<1> Incluir Livro"); 
            System.out.println("<2> Alterar Livro");
            System.out.println("<3> Excluir Livro");
            System.out.println("<4> Listar Livros");
            System.out.println();
            System.out.print("Escolha uma opção: ");

            try { 
                opcao = Integer.valueOf(scanner.nextLine());

            } catch (Exception e) {
                opcao = 0;
                
            }
            switch (opcao) {
                case 0: 
                    //limpaTela(); //ok 
                    break;
                case 1: 
                    //inserir_Aluno(); //está funcioando
                    break;
                case 2:
                    //alterar_aluno();
                    break;
                case 3: 
                    //deletar_aluno(); //está funcionando
                    break;
                case 4: 
                    listar_alunos(); // está funcionando
                    break;
            }
        } while (opcao != 0);
    }

    */
    //fim das linhas
}
