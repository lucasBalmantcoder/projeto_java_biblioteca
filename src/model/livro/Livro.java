package model.livro;

import java.io.Serializable;

public class Livro implements Serializable {

    private String id_livro;
    private String titulo;
    private String autor;
    private String genero;



    public Livro( String titulo, String autor, String genero) {
        //this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }
   

    public String getId_livro() {
        return this.id_livro;
    }

    public void setId_livro(String id_livro) {
        this.id_livro = id_livro;
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