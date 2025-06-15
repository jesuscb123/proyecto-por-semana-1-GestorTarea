package proyectoPorSemanaKotlin.dam.model

import java.time.LocalDateTime

class Tarea(val titulo: String,
            val descripcion: String,
            val fechaLimite: String) {

    var fechaInicio = LocalDateTime.now().toString()

    var estado: Estado = Estado.PENDIENTE
        private set

    constructor(inicioTarea: String,
                titulo: String,
                descripcion: String,
                fechaLimite: String,
                estado: Estado) : this (titulo, descripcion, fechaLimite){
                    this.fechaInicio = inicioTarea
                    this.estado = estado
                }

    fun cambiarEstado(estado: Estado){
        this.estado = estado
    }


}