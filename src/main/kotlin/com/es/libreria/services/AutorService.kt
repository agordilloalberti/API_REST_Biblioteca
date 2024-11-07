package com.es.libreria.services

import com.es.libreria.model.Autor
import com.es.libreria.repository.AutorRepository
import org.springframework.stereotype.Service

@Service
class AutorService(private val autorRepository: AutorRepository) {

    fun crearAutor(autor: Autor): Autor {
        return autorRepository.save(autor)
    }

    fun obtenerTodosLosAutores(): List<Autor> {
        return autorRepository.findAll()
    }

    fun obtenerAutorPorId(id: Long): Autor? {
        return autorRepository.findById(id).orElse(null)
    }

    fun eliminarAutor(id: Long) {
        autorRepository.deleteById(id)
    }
}