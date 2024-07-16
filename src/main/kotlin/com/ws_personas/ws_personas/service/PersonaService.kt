package com.ws_personas.ws_personas.service

import com.ws_personas.ws_personas.entity.Persona
import com.ws_personas.ws_personas.repository.PersonaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonaService @Autowired constructor(
    private val personaRepository: PersonaRepository
) {

    fun findAll(): List<Persona> = personaRepository.findAll()

    fun findById(id: Long): Persona? = personaRepository.findById(id).orElse(null)

    fun findByCurp(curp: String): Persona? = personaRepository.findByCurp(curp)

    fun save(persona: Persona): Persona = personaRepository.save(persona)

    fun deleteById(id: Long) = personaRepository.deleteById(id)
}
