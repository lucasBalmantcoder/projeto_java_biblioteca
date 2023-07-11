package model.livro;

import java.io.Serializable;

public class Livro implements Serializable {

    private String numero;
    private String titulo;
    private String autor;
    private String genero;


    public Livro(String titulo, String autor, String genero) {
        //this.numero = numero;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }



   

  

}   