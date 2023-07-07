import java.util.Scanner;

import model.aluno.Aluno;
import repository.RepositoryException;

public class App {
        //chamada de biblioteca
    // private static BibliotecaUnivesidade biblioteca;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

         
        try {
            System.out.println("Carregando o sistema...");


            int opcao;
            do{
                limpaTela();
                System.out.println("    MENU PRINCIPAL");
                System.out.println("====================");
                System.out.println("<1> Cadastro de alunos");
                System.out.println("<2> Emprestimos");
                System.out.println("<0> Sair");
                System.out.printf("Escolha uma opc�o:");

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
                        //cadastro_de_alunos();
                        break;

                    case 2:
                        System.out.println("Emprestimos");
                        break;
                    case 3: 
                        System.out.println("Sair");
                        
                        break;
                
                    default:
                        break;
                }
                
            }while(opcao != 0);

            //- bancoFacade.exit();
           // biblioteca.exit();
            
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

    /*
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
            System.out.print("Escolha uma op��o: ");

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
                    inserir_aluno();
                    break;
                case 2:
                    //alterar_aluno();
                    break;
                case 3: 
                    //deletar_aluno();
                    break;
                case 4: 
                    //listar_alunos();

            }
        } while (opcao != 0);
    }

    private static void inserir_aluno() {
        limpaTela();
        System.out.println("CADASTRO DE ALUNO");
        System.out.println("=================");

        System.out.print("NOME: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF:");
        String cpf = scanner.nextLine();
        

        System.out.print("MATRICULA: ");
        String matricula = scanner.nextLine();

        System.out.print("ENDERE�O: ");
        String endereco = scanner.nextLine();

        System.out.print("CONTATO: ");
        String contato = scanner.nextLine();



        Aluno aluno = new Aluno(nome, cpf, matricula,endereco, contato);

        try {
            biblioteca.inserir_aluno(aluno);
            System.out.println("Cliente Cadastrado");
        } catch (RepositoryException ex) {
            System.err.println(ex.getMessage());
        }

         System.out.println("pressione ENTER para continuar ");
         scanner.nextLine();
         scanner.nextLine();
         
    } */
}