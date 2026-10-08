package com.otaviocsr.livraria.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "livros")
public class Livro {

    @Id
    private String id;

    private String titulo;

    private Integer anoPublicacao;

    private String autor;

    private String genero;

    private String sinopse;

    private Integer quantidadePaginas;

    public Livro() {
    }

    public Livro(String id, String titulo, Integer anoPublicacao, String autor,
                 String genero, String sinopse, Integer quantidadePaginas) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.genero = genero;
        this.sinopse = sinopse;
        this.quantidadePaginas = quantidadePaginas;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}