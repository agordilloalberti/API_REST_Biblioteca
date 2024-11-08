
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*


@Entity
@Table(name = "Autores")
data class Autor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "nombre", nullable = false)
    var nombre: String,

    var nacionalidad: String,

    //@Temporal(TemporalType.DATE)
    @Column(name = "año_nacimiento")
    var anioNacimiento: Int,

    @Column(name = "Biografia",length = 1000)
    var biografia: String? = null,

    @Column(name = "Libros")
    @OneToMany(mappedBy = "autor", cascade = [CascadeType.ALL], orphanRemoval = true)
    @JsonManagedReference
    val libros: MutableList<Libro> = mutableListOf()
)