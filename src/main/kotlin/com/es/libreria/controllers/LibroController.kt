package com.es.libreria.controllers
import LibroService
import com.es.libreria.model.Libro
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/libros")
class LibroController(private val libroService: LibroService) {

    @PostMapping
    fun crearLibro(@RequestBody libro: Libro): ResponseEntity<Libro> {
        return ResponseEntity.ok(libroService.crearLibro(libro))
    }

    @GetMapping
    fun obtenerTodosLosLibros(): ResponseEntity<List<Libro>> {
        return ResponseEntity.ok(libroService.obtenerTodosLosLibros())
    }

    @GetMapping("/{id}")
    fun obtenerLibroPorId(@PathVariable id: Long): ResponseEntity<Libro> {
        val libro = libroService.obtenerLibro(id)
        return if (libro != null) ResponseEntity.ok(libro) else ResponseEntity.notFound().build()
    }

    @GetMapping("/genero/{genero}")
    fun obtenerLibrosPorGenero(@PathVariable genero: String): ResponseEntity<List<Libro>> {
        return ResponseEntity.ok(libroService.obtenerLibros(genero))
    }

    @DeleteMapping("/{id}")
    fun eliminarLibro(@PathVariable id: Long): ResponseEntity<Unit> {
        libroService.eliminarLibro(id)
        return ResponseEntity.noContent().build()
    }
}