
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "libros")
data class Libro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "titulo", nullable = false)
    var titulo: String,

    @Column(name = "genero")
    var genero: String,

    //@Temporal(TemporalType.DATE)
    @Column(name = "anio_publicacion")
    var anioPublicacion: Int,

    @Column(name = "precio")
    var precio: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    @JsonBackReference
    var autor: Autor?
)