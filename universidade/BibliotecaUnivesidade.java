package universidade;

import java.io.File;

public class BibliotecaUnivesidade {
    
    //Arquivo para salvar os dados

    private final File file = new File("biblioteca.liv");


    //Atributo est�tico que vai manter a �nica 
    //inst�ncia da classe 

    private static  BibliotecaUnivesidade instance = null;


    //Construtor deve ser privado evitando que seja chamado fora classe

    private BibliotecaUnivesidade() throws BibliotecaException {
        if(file.exists()) {

            load_data();

        } else {
            
        }
    }
}

