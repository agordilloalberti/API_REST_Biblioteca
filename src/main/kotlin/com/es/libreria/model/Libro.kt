package com.es.libreria.model

import Autor
import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

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

    //@Temporal(TemporalType.DATE)
    var anioPublicacion: Int,

    @Column(name = "Precio")
    var precio: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    @JsonBackReference
    var autor: Autor
)