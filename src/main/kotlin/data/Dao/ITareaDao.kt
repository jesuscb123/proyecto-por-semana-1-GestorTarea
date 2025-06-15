package proyectoPorSemanaKotlin.dam.data.Dao

import proyectoPorSemanaKotlin.dam.model.Estado
import proyectoPorSemanaKotlin.dam.model.Tarea

interface ITareaDao {
    fun consultarTarea(): Tarea?
    fun aniadirTarea(fechaInicio: String, titulo: String, descripcion: String, fechaLimite: String, estado: Estado): Boolean
    fun eliminarTarea(): Boolean
    fun cambiarEstadoTarea(estado: Estado): Boolean
}