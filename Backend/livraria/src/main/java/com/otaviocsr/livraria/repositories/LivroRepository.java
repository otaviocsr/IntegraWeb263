package com.otaviocsr.livraria.repositories;

import com.otaviocsr.livraria.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}