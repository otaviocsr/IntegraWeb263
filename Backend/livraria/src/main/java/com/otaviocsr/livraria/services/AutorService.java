package com.otaviocsr.livraria.services;

import com.otaviocsr.livraria.entities.Autor;
import com.otaviocsr.livraria.repositories.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> listarTodos() {
        return repository.findAll();
    }

    public Autor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }

    public Autor criar(Autor autor) {
        return repository.save(autor);
    }

    public Autor atualizar(Long id, Autor autor) {

        Autor autorExistente = buscarPorId(id);

        autorExistente.setNome(autor.getNome());
        autorExistente.setNacionalidade(autor.getNacionalidade());

        return repository.save(autorExistente);
    }

    public void deletar(Long id) {

        Autor autor = buscarPorId(id);

        repository.delete(autor);
    }
}