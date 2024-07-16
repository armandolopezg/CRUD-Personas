package com.ws_personas.ws_personas.controller

import com.ws_personas.ws_personas.entity.Persona
import com.ws_personas.ws_personas.service.PersonaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import java.util.*

@RestController
@RequestMapping("/personas")
@Tag(name = "Personas", description = "API para gestionar personas")
class PersonaController @Autowired constructor(
    private val personaService: PersonaService
) {

    @GetMapping
    @Operation(summary = "Listar todas las personas", description = "Obtiene una lista de todas las personas registradas, mostrando solo nombre y CURP.")
    fun getAllPersonas(): List<Map<String, String>> {
        return personaService.findAll().map { persona ->
            mapOf("nombre" to persona.nombre, "curp" to persona.curp)
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener persona por ID", description = "Obtiene los detalles de una persona por su ID.")
    fun getPersonaById(@PathVariable id: Long): ResponseEntity<Persona> {
        val persona = personaService.findById(id)
        return if (persona != null) {
            ResponseEntity.ok(persona)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/curp/{curp}")
    @Operation(summary = "Obtener persona por CURP", description = "Obtiene los detalles de una persona por su CURP.")
    fun getPersonaByCurp(@PathVariable curp: String): ResponseEntity<Persona> {
        val persona = personaService.findByCurp(curp)
        return if (persona != null) {
            ResponseEntity.ok(persona)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    @Operation(summary = "Crear nueva persona", description = "Crea una nueva persona. El CURP debe ser único.")
    fun createPersona(@RequestBody persona: Persona): ResponseEntity<Any> {
        if (personaService.findByCurp(persona.curp) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El CURP ya se encuentra registrado")
        }
        val nuevaPersona = persona.copy(fecha_registro = Date(), fecha_modificacion = Date())
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(nuevaPersona))
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar persona", description = "Actualiza los detalles de una persona. La fecha de modificación se actualiza automáticamente.")
    fun updatePersona(@PathVariable id: Long, @RequestBody updatedPersona: Persona): ResponseEntity<Persona> {
        val existentePersona = personaService.findById(id)
        return if (existentePersona != null) {
            val fechaActual = Date()
            val personaToUpdate = existentePersona.copy(
                nombre = updatedPersona.nombre,
                apellido_paterno = updatedPersona.apellido_paterno,
                apellido_materno = updatedPersona.apellido_materno,
                fecha_modificacion = fechaActual
            )
            ResponseEntity.ok(personaService.save(personaToUpdate))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar persona", description = "Elimina una persona por su ID.")
    fun deletePersona(@PathVariable id: Long): ResponseEntity<Void> {
        return if (personaService.findById(id) != null) {
            personaService.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
