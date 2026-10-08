package com.otaviocsr.livraria.controllers;

import com.otaviocsr.livraria.entities.Autor;
import com.otaviocsr.livraria.services.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Autor> criar(@RequestBody Autor autor) {
        return ResponseEntity.ok(service.criar(autor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> atualizar(
            @PathVariable String id,
            @RequestBody Autor autor) {

        return ResponseEntity.ok(service.atualizar(id, autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}