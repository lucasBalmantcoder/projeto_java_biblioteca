package model.exemplar;

import java.io.Serializable;

public class Exemplar implements Serializable{
    private int codigo;
    private int data_de_compra;
    private Livro titulo; // não sei dizer se chamada está certa
    private boolean disponivel;
    private boolean consultar;
    



    public Exemplar(int codigo, int data_de_compra, Livro titulo, boolean disponivel, boolean consultar) {
        this.codigo = codigo;
        this.data_de_compra = data_de_compra;
        this.titulo = titulo;
        this.disponivel = disponivel;
        this.consultar = consultar;
    }


    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getData_de_compra() {
        return this.data_de_compra;
    }

    public void setData_de_compra(int data_de_compra) {
        this.data_de_compra = data_de_compra;
    }

    public Livro getTitulo() {
        return this.titulo;
    }

    public void setTitulo(Livro titulo) {
        this.titulo = titulo;
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
        return this.consultar;
    }

    public boolean getConsultar() {
        return this.consultar;
    }

    public void setConsultar(boolean consultar) {
        this.consultar = consultar;
    }

    public String toString(){
        return titulo;
    }


}