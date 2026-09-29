package com.otaviocsr.livraria.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Integer anoPublicacao;

    private String autor;

    private String genero;

    private String sinopse;

    private Integer quantidadePaginas;

    public Livro() {
    }

    public Livro(Long id, String titulo, Integer anoPublicacao, String autor,
                 String genero, String sinopse, Integer quantidadePaginas) {
        this.id = id;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
        this.genero = genero;
        this.sinopse = sinopse;
        this.quantidadePaginas = quantidadePaginas;
    }

    public void setId(Long id) {
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