package com.otaviocsr.livraria.repositories;

import com.otaviocsr.livraria.entities.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AutorRepository extends MongoRepository<Autor, String> {
}