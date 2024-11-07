package com.es.libreria.repository

import com.es.libreria.model.Autor
import org.springframework.data.jpa.repository.JpaRepository

interface AutorRepository : JpaRepository<Autor, Long>