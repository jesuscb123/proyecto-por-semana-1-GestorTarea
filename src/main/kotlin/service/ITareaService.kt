package proyectoPorSemanaKotlin.dam.service

import proyectoPorSemanaKotlin.dam.model.Estado
import proyectoPorSemanaKotlin.dam.model.Tarea

interface ITareaService {
    fun consultarTarea(): Tarea?
    fun aniadirTarea(titulo: String, descripcion: String, fechaLimite: String): Boolean
    fun eliminarTarea(id: String): Boolean
    fun cambiarEstadoTarea(id: String, estado: Estado): Boolean

}