//IMPORTANDO BIBLIOTECAS//

import java.util.Scanner;


public class app {
    
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        limpa_tela();
        System.out.println("Carregando o sistema...");

        int opcao; //variáveis para armazenar a seleção do menu ->
        //Criando menu
        do{
        limpa_tela();
        System.out.println("MENU PRINCIPAL");
        System.out.println("==== =========");
        System.out.println("<1> Cadastro Clientes");
        System.out.println("<2> Cadastros Contas");
        System.out.println("<3> Caixa Eletronico");
        System.out.println("<0> Sair");
        System.out.printf("Escolha uma opção: ");

        try {
            opcao = Integer.valueOf(scanner.nextLine());
        }catch (Exception e){
            opcao = 0;
        }
            switch (opcao){
                case 0:
                    limpa_tela();
                    break;
                case 1: 
                    limpa_tela();
                    System.out.println("cadastro de Clientes");
                    //cadastro_clientes();
                    break;
                case 2: 
                    System.out.println("cadastro contas");
                    //cadastro_contas();
                    break;
                case 3: 
                System.out.println("caixa eletronico");
                    //caixa_eletronico();
                    break;
                 
            
            }
        
        }while(opcao != 0);
    }
    //imprime limpa tela - basicamente é só impreção de quebra de linha
    private static void limpa_tela(){
        for(int i=0; i< 50; i++){

            System.out.printf("\n");

        }
    } 


}
   