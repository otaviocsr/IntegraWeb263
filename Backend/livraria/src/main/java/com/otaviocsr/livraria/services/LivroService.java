package com.otaviocsr.livraria.services;

import com.otaviocsr.livraria.entities.Livro;
import com.otaviocsr.livraria.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    // GET BY ID
    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    // POST
    public Livro criar(Livro livro) {
        return repository.save(livro);
    }

    // PUT
    public Livro atualizar(Long id, Livro livro) {

        Livro livroExistente = buscarPorId(id);

        livroExistente.setTitulo(livro.getTitulo());
        livroExistente.setAnoPublicacao(livro.getAnoPublicacao());
        livroExistente.setAutor(livro.getAutor());
        livroExistente.setGenero(livro.getGenero());
        livroExistente.setSinopse(livro.getSinopse());
        livroExistente.setQuantidadePaginas(livro.getQuantidadePaginas());

        return repository.save(livroExistente);
    }

    // DELETE
    public void deletar(Long id) {

        Livro livro = buscarPorId(id);

        repository.delete(livro);
    }
}