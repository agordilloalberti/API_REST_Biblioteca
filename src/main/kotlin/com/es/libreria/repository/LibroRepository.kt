package com.es.libreria.repository

import com.es.libreria.model.Libro
import org.springframework.data.jpa.repository.JpaRepository

interface LibroRepository : JpaRepository<Libro, Long>