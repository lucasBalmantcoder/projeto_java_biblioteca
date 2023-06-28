package teste;

import java.io.File;
import java.io.FileInputStream;

public class Banco_teste{
    //Arquivo para salvar os dados
    private final File file = new File("banco.dat");

    //PADR�O DE PROJETO SIGLETON//

    //atributo est�tico que vai manter a �nica
    //inst�ncia da classe

    private static Banco_teste instance = null;
    
    //Construtor deve ser privado garantindo que n�o vai ser
    //chamado de fora da classe
    private Banco_teste() throws Banco_Exception{
        if(file.exists()){
            loadData();
        }else{
            repositorio_cliente = new Repositorio_cliente_lista();
            repositorio_cont = new Repositorio_conta_lita();
        }
    }

}

