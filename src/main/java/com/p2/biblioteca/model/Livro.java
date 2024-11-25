package com.p2.biblioteca.model;

public class Livro {
    private int id;
    private String titulo;
    private String sinopse;
    private String autor;
    private String editora;
    private String ano;

    // Construtor padrão
    public Livro() {}

    // Sobrecarga do construtor
    public Livro(Integer id, String titulo, String sinopse, String autor, String editora, String ano) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
    }

    // Construtor com Strings e conversão
    public Livro(String titulo, String sinopse, String autor, String editora, String ano) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;  // Aqui mantemos o tipo Integer
    }

    // Métodos Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}