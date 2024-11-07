package com.es.libreria.controllers
import com.es.libreria.model.Autor
import com.es.libreria.services.AutorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/autores")
class AutorController(private val autorService: AutorService) {

    @PostMapping
    fun crearAutor(@RequestBody autor: Autor): ResponseEntity<Autor> {
        return ResponseEntity.ok(autorService.crearAutor(autor))
    }

    @GetMapping
    fun obtenerTodosLosAutores(): ResponseEntity<List<Autor>> {
        return ResponseEntity.ok(autorService.obtenerTodosLosAutores())
    }

    @GetMapping("/{id}")
    fun obtenerAutor(@PathVariable id: Long): ResponseEntity<Autor> {
        val autor = autorService.obtenerAutorPorId(id)
        return if (autor != null) ResponseEntity.ok(autor) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun eliminarAutor(@PathVariable id: Long): ResponseEntity<Unit> {
        autorService.eliminarAutor(id)
        return ResponseEntity.noContent().build()
    }
}