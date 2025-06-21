package proyectoPorSemanaKotlin.dam.model

import java.time.LocalDateTime

data class Tarea(val fechaIncio: String,
            val titulo: String,
            val descripcion: String,
            val fechaLimite: String,
            val estado: Estado) {

    override fun toString(): String {
        return "fecha inicio: $fechaIncio - titulo: $titulo, descripción: $descripcion, fecha límite: $fechaLimite, estado: $estado"
    }
}