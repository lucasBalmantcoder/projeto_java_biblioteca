//Projeto Biblioteca

//importações
import java.util.Scanner;


class app {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            System.out.println("Carregando o sistema...");

            int opcao;
            do{
                limpaTela();
                System.out.println("    MENU PRINCIPAL");
                System.out.println("====================");
                System.out.println("<1> Emprestar Livros");
                System.out.println("<2> Emprestimos");
                System.out.println("<0> Sair");
                System.out.printf("Escolha uma opcão:");

                try {

                    opcao = Integer.valueOf(scanner.nextLine());

                } catch (Exception e) {
                    opcao = 0;
                }

                switch (opcao) {
                    case 1:
                        System.out.println("emprestar livros");
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

}
