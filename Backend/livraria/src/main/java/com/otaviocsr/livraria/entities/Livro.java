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

    private Double preco;

    private Integer anoPublicacao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro() {
    }

    public Livro(Long id, String titulo, Double preco, Integer anoPublicacao, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.anoPublicacao = anoPublicacao;
        this.autor = autor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}