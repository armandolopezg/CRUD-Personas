package com.ws_personas.ws_personas.repository

import com.ws_personas.ws_personas.entity.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository : JpaRepository<Persona, Long> {
    fun findByCurp(curp: String): Persona?
}
