import org.springframework.stereotype.Service

@Service
class LibroService(private val libroRepository: LibroRepository) {

    fun crearLibro(libro: Libro): Libro {
        return libroRepository.save(libro)
    }

    fun obtenerTodosLosLibros(): List<Libro> {
        return libroRepository.findAll()
    }

    fun obtenerLibro(id: Long): Libro? {
        return libroRepository.findById(id).orElse(null)
    }

    fun eliminarLibro(id: Long) {
        libroRepository.deleteById(id)
    }

    fun obtenerLibros(genero: String): List<Libro> {
        return libroRepository.findAll().filter { it.genero.equals(genero, ignoreCase = true) }
    }
}