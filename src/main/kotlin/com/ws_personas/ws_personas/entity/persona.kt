package com.ws_personas.ws_personas.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "PERSONA")
data class Persona(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "nombre", nullable = false)
    val nombre: String = "",

    @Column(name = "apellido_paterno", nullable = false)
    val apellido_paterno: String = "",

    @Column(name = "apellido_materno", nullable = false)
    val apellido_materno: String = "",

    @Column(name = "fecha_registro", nullable = false)
    val fecha_registro: Date = Date(),

    @Column(name = "curp", nullable = false, unique = true)
    val curp: String = "",

    @Column(name = "fecha_modificacion", nullable = false)
    val fecha_modificacion: Date = Date()
)