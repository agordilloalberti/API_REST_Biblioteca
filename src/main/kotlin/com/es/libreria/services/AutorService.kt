package com.es.libreria.services

import Autor
import com.es.libreria.repository.AutorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AutorService() {

    @Autowired
    private lateinit var autorRepository: AutorRepository

    fun crearAutor(autor: Autor): Autor {
        return autorRepository.save(autor)
    }

    fun obtenerTodosLosAutores(): List<Autor> {
        return autorRepository.findAll()
    }

    fun obtenerAutor(id: Long): Autor? {
        return autorRepository.findByIdOrNull(id)
    }

    fun eliminarAutor(id: Long) {
        autorRepository.deleteById(id)
    }
}