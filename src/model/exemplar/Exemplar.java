package model.exemplar;

import java.io.Serializable;

//import local
import model.livro.*;


public class Exemplar implements Serializable {

    //Contandor de classe - tentativa de implementação 1
    private static int contador_de_instancias = 0;
    private int codigo;
    private Livro livro;
    private boolean disponivel;
    private String Consultar;

    public Exemplar(int codigo, Livro livro, boolean disponivel, String Consultar) {
        this.codigo = codigo;
        this.livro = livro;
        this.disponivel = disponivel;
        this.Consultar = Consultar;
        contador_de_instancias++;
    }

    public void imprimir_informacoes_livro() {
        Livro livro = this.livro;
        System.out.println("Ttulo: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Autor: " + livro.getGenero());
   
    }


    public static int contador_de_instancias() {
        return contador_de_instancias;
    }
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getConsultar() {
        return this.Consultar;
    }

    public void setConsultar(String Consultar) {
        this.Consultar = Consultar;
    }



}
    
