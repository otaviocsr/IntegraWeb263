package com.otaviocsr.livraria.controllers;

import com.otaviocsr.livraria.entities.Livro;
import com.otaviocsr.livraria.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins = "http://localhost:4200")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
        return ResponseEntity.ok(service.criar(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(
            @PathVariable Long id,
            @RequestBody Livro livro) {

        return ResponseEntity.ok(service.atualizar(id, livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}