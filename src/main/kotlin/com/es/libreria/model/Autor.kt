

import com.es.libreria.model.Libro
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*


@Entity
@Table(name = "Autores")
data class Autor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "Nombre", nullable = false)
    var nombre: String,

    var nacionalidad: String,

    //@Temporal(TemporalType.DATE)
    var anioNacimiento: Int,

    @Column(name = "Biografia",length = 1000)
    var biografia: String? = null,

    @Column(name = "Libros")
    @OneToMany(mappedBy = "autor", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val libros: MutableList<Libro> = mutableListOf<Libro>()
)