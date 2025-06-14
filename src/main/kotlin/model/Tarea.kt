package proyectoPorSemanaKotlin.dam.model

import java.time.LocalDateTime

class Tarea(val titulo: String,
            val descripcion: String,
            val fechaLimite: String) {

    val inicioTarea = LocalDateTime.now().toString()

    var estado: Estado = Estado.PENDIENTE
        private set

    fun cambiarEstado(estado: Estado){
        this.estado = estado
    }
}