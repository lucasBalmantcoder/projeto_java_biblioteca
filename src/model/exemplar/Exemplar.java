package model.exemplar;

import java.io.Serializable;

//import local
import model.livro.*;


public class Exemplar implements Serializable {

    //Contandor de classe - tentativa de implementação 1
    private static int contador_de_instancias = 0;
    private String id_exemplar;
    private Livro livro;
    private boolean disponivel;
    private boolean Consulta;

    public Exemplar(Livro livro, boolean disponivel, boolean Consulta) {
        this.livro = livro;
        this.disponivel = disponivel;
        this.Consulta = Consulta;
        contador_de_instancias++;
    }
    public Exemplar( boolean disponivel, boolean Consultar) {
        //this.id_exemplar = id_exemplar;
        //this.livro = livro;
        this.disponivel = disponivel;
        this.Consulta = Consultar;
        contador_de_instancias++;
    }

    public static int getContador_de_instancias() {
        return contador_de_instancias;
    }

    
    //get responsavel pot obter o id de exemplar
    public String getId_exemplar() {
        return this.id_exemplar;
    }

    public void setId_exemplar(String id_exemplar) {
        this.id_exemplar = id_exemplar;
    }

    public Livro getLivro() {
        return this.livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isConsultar() {
        return this.Consulta;
    }

    public boolean getConsultar() {
        return this.Consulta;
    }

    public void setConsultar(boolean Consultar) {
        this.Consulta = Consultar;
    }




}
    
