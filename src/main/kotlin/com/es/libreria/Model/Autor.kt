import com.es.libreria.Model.Libro
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "Autores")
data class Autor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "Nombre", nullable = false)
    var nombre: String,

    @Column(name = "Nacinalidad")
    var nacionalidad: String,

    @Column(name = "Año_nacimiento")
    @Temporal(TemporalType.DATE)
    var anioNacimiento: LocalDate,

    @Column(name = "Biografia",length = 1000)
    var biografia: String? = null,

    @Column(name = "Libros")
    @OneToMany(mappedBy = "autor", cascade = [jakarta.persistence.CascadeType.ALL], orphanRemoval = true)
    val libros: MutableList<Libro> = mutableListOf()
)