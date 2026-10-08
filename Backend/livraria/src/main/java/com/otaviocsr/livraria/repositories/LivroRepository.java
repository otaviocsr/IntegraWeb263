package com.otaviocsr.livraria.repositories;

import com.otaviocsr.livraria.entities.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LivroRepository extends MongoRepository<Livro, String> {
}