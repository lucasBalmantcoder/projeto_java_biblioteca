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
//import java.io.FileInputStream;
//import locais
//import java.security.AllPermission;

import model.aluno.*;
//import repository.aluno.*;
//import repository.conta.*;
import repository.RepositoryException;

//import do exemplar
import model.exemplar.*;
import model.livro.*;
//import repository.exemplar.*;


//import do livro
//import model.livro.*;
//import repository.livro.*;

//"fachada"
import facade.BibliotecaUniversidade;
import facade.BibliotecaException;


class App {
        //chamada de biblioteca
    private static BibliotecaUniversidade facade;
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
        
            facade = BibliotecaUniversidade.getInstance();


            cria_dados_testes();


            int opcao;
            do{
                limpaTela();
                System.out.println("    MENU PRINCIPAL");
                System.out.println("========================");
                System.out.println("<1> Cadastro de alunos");
                System.out.println("<2> Cadastrar Livros");
                System.out.println("<3> Cadastrar Exemplares");
                System.out.println("<4> Emprestimos");
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
                        cadastro_de_livro();
                        break;
                    case 3: 
                        cadastro_de_exemplar();
                        
                        break;
                    case 4: 
                        //emprestimos();
                        
                        break;
                
                    default:
                        break;
                }
                
            }while(opcao != 0);

            //- bancoFacade.exit();
           facade.exit();
            
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
            facade.inserir_aluno(aluno);
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
        List<Aluno> alunos = facade.getAllAlunos();
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
            Aluno aluno = facade.buscar_Aluno(cpf);
            System.out.println();
            System.out.println("NOME:" + aluno.getNome());
            System.out.println("CPF:" + aluno.getNome());

            //System.out.println("NOME:" + aluno.getNome());
            System.out.println();

            System.out.println("Excluir Aluno? (s/n)");
            String resposta = scanner.nextLine();

            if(resposta.equalsIgnoreCase("s")){
                facade.deletar_aluno(aluno);
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
            Aluno aluno = facade.buscar_Aluno(cpf);
            System.out.println();
            System.out.println("NOME: " + aluno.getNome());
            System.out.println("NOME: (<ENTER> para não alterar)");

            String nome = scanner.nextLine();

            if(!nome.equals("")) {
                aluno.setNome(nome);
            }
            System.out.println();

            facade.alterar_aluno(aluno);
            System.out.println("Cliente Alterado!");
            System.out.println();
            
        } catch (RepositoryException ex)  {
            System.err.println(ex.getMessage());
        } 
        
        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();

    }

    
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
                    limpaTela(); 
                    break;
                case 1: 
                    inserir_livro();
                    break;
                case 2:
                    alterar_livro();
                    break;
                case 3: 
                    deletar_livro();
                    break;
                case 4: 
                    listar_livros(); 
                    break;
            }
        } while (opcao != 0);
    }

    private static void inserir_livro() { //está funcioando
        limpaTela();
        System.out.println("CADASTRAR LIVRO");
        System.out.println("==================");

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Genero: ");
        String genero = scanner.nextLine();



        //int  = Integer.valueOf(scanner.nextLine());

        //Exemplar exemplar = new Exemplar(codigo, null, false, null);
        
        Livro livro = new Livro(titulo, autor, genero);

        //System.out.print("Genero: ");
        //String genero = scanner.nextLine();

        //Livro livro = new Livro(titulo, autor, genero);

        //Exemplar exemplar = new Exemplar(titulo, autor, codigo);

        try {
            facade.inserir_livro(livro);
            //biblioteca.inserir_livro(livro);
            System.out.println("Livro Cadastrado");
        } catch (RepositoryException ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();
         
         
    }

    private static void alterar_livro() {
        limpaTela();
        System.out.println("Alterar Info Livro");
        System.out.println("==================");

        System.out.print("id: ");
        String id_livro = scanner.nextLine();
        try {
            Livro livro = facade.buscar_Livro(id_livro);
            System.out.println();
            System.out.println("titulo: " + livro.getTitulo());
            System.out.println("Titulo: (<ENTER> para não alterar)");
            System.out.print("Novo Titulo:");
            String titulo = scanner.nextLine();

            if(!livro.equals("")) {
                livro.setTitulo(titulo);
            }
            System.out.println();

            System.out.println();
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Autor: (<ENTER> para não alterar)");
            System.out.print("Autor Novo:");
            String autor = scanner.nextLine();

            if(!livro.equals("")) {
                livro.setAutor(autor);
            }
            System.out.println();

            System.out.println();

            System.out.println();
            System.out.println("Genero: " + livro.getGenero());
            System.out.println("Genero: (<ENTER> para não alterar)");
            System.out.print("Genero Novo:");
            String genero = scanner.nextLine();

            if(!livro.equals("")) {
                livro.setTitulo(genero);
            }
            System.out.println();
            facade.alterar_livro(livro);
            System.out.println("Livro Alterado!");
            System.out.println();
            
        } catch (RepositoryException ex)  {
            System.err.println(ex.getMessage());
        } 
        
        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();

    }

    
    private static void listar_livros() {
        limpaTela();
        List<Livro> livros = facade.getAllLivros();
        System.out.println("Id Autor         Gênero          Título                 ");
        System.out.println("== ============= =============== =======================");
        for (Livro livro : livros) {

            System.out.printf("%-2s ", livro.getId_livro());
            System.out.printf("%-13s ", livro.getAutor());
            System.out.printf("%-16s ", livro.getGenero());
            System.out.printf("%-40s\n", livro.getTitulo());
        }
        System.out.println();
        System.out.println("Pressione ENTER para continuar");
        scanner.nextLine();
    }

    private static void deletar_livro() {
        limpaTela();
        System.out.println("Excluir qual Livro?");
        System.out.println("===================");
        System.out.println("Qual o Id do Livro?");
        String id = scanner.nextLine();

        try {
           
            Livro livro = facade.buscar_Livro(id);
            System.out.println();
            System.out.println("NOME:" + livro.getAutor());
            System.out.println("CPF:" + livro.getTitulo());


            //System.out.println("NOME:" + aluno.getNome());
            System.out.println();

            System.out.println("Excluir Livro? (s/n)");
            String resposta = scanner.nextLine();

            if(resposta.equalsIgnoreCase("s")){
                facade.deletar_livro(livro);
                System.out.println("Livro Deletado!");


            }
        }catch (RepositoryException | BibliotecaException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();
    }

    
    //Chamadas dos métodos do Exemplar
 private static void cadastro_de_exemplar() {
        int opcao;

        do {
            limpaTela();
            System.out.println("CADASTRO DE EXEMPLAR");
            System.out.println("=================");
            System.out.println();
            System.out.println("<1> Incluir Exemplar"); 
            System.out.println("<2> Alterar Exemplar");
            System.out.println("<3> Excluir Exemplar");
            System.out.println("<4> Listar Exemplar");
            System.out.println();
            System.out.print("Escolha uma opção: ");

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
                    inserir_exemplar();
                    break;
                case 2:
                    alterar_exemplar();
                    break;
                case 3: 
                    deletar_exemplar();
                    break;
                case 4: 
                    listar_exemplar(); 
                    break;
            }
        } while (opcao != 0);
    }

    private static void inserir_exemplar() { //está funcioando
        limpaTela();
        System.out.println("CADASTRAR EXEMPLAR");
        System.out.println("==================");

        //System.out.print("codigo: ");
        //String titulo = scanner.nextLine();
        //System.out.print("Data de compra: ");
        //String data_de_compra = scanner.nextLine();
        //System.out.print("Genero: ");
        //String genero = scanner.nextLine();



        //int  = Integer.valueOf(scanner.nextLine());

        //Exemplar exemplar = new Exemplar(codigo, null, false, null);
        System.out.print("Qual o livro que você deseja adicionar?( INSIRA O ID DO LIVRO) \n\n");

        List<Livro> livros = facade.getAllLivros();
        System.out.println("Id Autor         Gênero          Título                 ");
        System.out.println("== ============= =============== =======================");
        for (Livro livro : livros) {
            System.out.printf("%-2s ", livro.getId_livro());
            System.out.printf("%-13s ", livro.getAutor());
            System.out.printf("%-16s ", livro.getGenero());
            System.out.printf("%-40s\n", livro.getTitulo());
        }
        try {
        System.out.print("ID: ");
        String id_livro = scanner.nextLine();
        Livro livro = facade.buscar_Livro(id_livro);

        Exemplar exemplar = new Exemplar(livro ,true,false);

        //System.out.print("Genero: ");
        //String genero = scanner.nextLine();

        //Livro livro = new Livro(titulo, autor, genero);

        //Exemplar exemplar = new Exemplar(titulo, autor, codigo);

        
            facade.inserir_exemplar(exemplar);
            //biblioteca.inserir_livro(livro);
            System.out.println("Livro Cadastrado");
        } catch (RepositoryException ex) {
            System.err.println(ex.getMessage());
        }
        
        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();
         
         
    }

    private static void alterar_exemplar() {
        limpaTela();
        System.out.println("         Alterar Info Exemplar");
        System.out.println("==========================================");

        System.out.print("id: ");
        String id_exemplar = scanner.nextLine();


        try {
            limpaTela();
            System.out.println("         Alterar Info Exemplar");
            System.out.println("===========================================");
            Exemplar exemplar1  = facade.buscar_Exemplar(id_exemplar);

            System.out.println("Id Livro         Consulta Disponivel       ");
            System.out.println("== ============= ======== =================");
            System.out.printf("%-2s ", exemplar1.getId_exemplar());
            System.out.printf("%-13s ", exemplar1.getLivro().getTitulo());
            System.out.printf("%-8s ", exemplar1.getDisponivel());
            System.out.printf("%-31s\n", exemplar1.getConsultar());
            
            System.out.println("Alterar infos de livro? (s/n)");
            String resposta = scanner.nextLine();

            if(resposta.equalsIgnoreCase("s")){
                
                System.out.print("Qual o livro que você deseja adicionar?( INSIRA O ID DO LIVRO) \n\n");

                List<Livro> livros = facade.getAllLivros();
                System.out.println("Id Autor         Gênero          Título                 ");
                System.out.println("== ============= =============== =======================");
                for (Livro livro : livros) {
                    System.out.printf("%-2s ", livro.getId_livro());
                    System.out.printf("%-13s ", livro.getAutor());
                    System.out.printf("%-16s ", livro.getGenero());
                    System.out.printf("%-40s\n", livro.getTitulo());
                
                }
            }

            
            /*
            System.out.println();

            System.out.println();
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Autor: (<ENTER> para não alterar)");
            System.out.print("Autor Novo:");
            String autor = scanner.nextLine();

            if(!livro.equals("")) {
                livro.setAutor(autor);
            }
            System.out.println();

            System.out.println();

            System.out.println();
            System.out.println("Genero: " + livro.getGenero());
            System.out.println("Genero: (<ENTER> para não alterar)");
            System.out.print("Genero Novo:");
            String genero = scanner.nextLine();

            if(!livro.equals("")) {
                livro.setTitulo(genero);
            }
            System.out.println();
            facade.alterar_livro(livro);
            System.out.println("Livro Alterado!");
            System.out.println();
           */
        } catch (RepositoryException ex)  {
            System.err.println(ex.getMessage());
        } 
        
        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();

    }

    
    private static void listar_exemplar() {
        limpaTela();
        List<Exemplar> exemplares = facade.getAllExemplares();
        System.out.println("Id Livro         Consulta Disponivel       ");
        System.out.println("== ============= ======== =================");
        for (Exemplar exemplar : exemplares) {
            System.out.printf("%-2s ", exemplar.getId_exemplar());
            System.out.printf("%-13s ", exemplar.getLivro().getTitulo());
            System.out.printf("%-8s ", exemplar.getDisponivel());
            System.out.printf("%-31s\n", exemplar.getConsultar());
        }
        System.out.println();
        System.out.println("Pressione ENTER para continuar");
        scanner.nextLine();
    }

    private static void deletar_exemplar() {
        limpaTela();
        System.out.println("Excluir qual Exemplar?");
        System.out.println("======================");
        System.out.println("Qual o Id do Exemplar?");
        String id_exemplar = scanner.nextLine();

        try {
           
           Exemplar exemplar = facade.buscar_Exemplar(id_exemplar);
            System.out.println();
            System.out.println("ID:" + exemplar.getId_exemplar());
            System.out.println("Titulo:" + exemplar.getLivro().getTitulo());


            //System.out.println("NOME:" + aluno.getNome());
            System.out.println();

            System.out.println("Excluir Exemplar? (s/n)");
            String resposta = scanner.nextLine();

            if(resposta.equalsIgnoreCase("s")){
                facade.deletar_exemplar(exemplar);
                System.out.println("Exemplar Deletado!");


            }
        }catch (RepositoryException | BibliotecaException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("pressione ENTER para continuar ");
        scanner.nextLine();
    }

     

    //fim das linhas

     

    //parte destinada para dados de teste
    //Está adicionando apenas Usuário
    

    private static void cria_dados_testes(){
        try {
            facade.inserir_aluno(new Aluno("Lucas Balmant", "111.111.111-11", "20230708", "Rua Bom Jardim", "99999999999"));
            facade.inserir_aluno(new Aluno("Peter Parker", "222.222.222-22", "20230709", "Nova York", "22222222222"));

            facade.inserir_livro(new Livro("Berserk", "Kentaro","fantasy"));
            facade.inserir_livro(new Livro("Menino da lua", "Minato","aventura"));

            //dados de teste  de exemplar2
            
            // biblioteca.inserir_exemplar(new Exemplar("macacos voadores", "Jhony bravo", "Fantasia", 02, true, null));
            //biblioteca.inserir_exemplar(new Exemplar("Pantera ", "Michael Rusber", "Terror", 03, true, null));
        } catch (RepositoryException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
