package com.es.libreria.Model

import Autor
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "Libros")
data class Libro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "Titulo", nullable = false)
    var titulo: String,

    @Column(name = "Genero")
    var genero: String,

    @Column(name = "Año_publicación")
    @Temporal(TemporalType.DATE)
    var anioPublicacion: LocalDate,
    var precio: Double,

    @Column(name = "Autor")
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    var autor: Autor
)