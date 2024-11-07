package com.es.libreria.repository

import Autor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface AutorRepository : JpaRepository<Autor, Long>