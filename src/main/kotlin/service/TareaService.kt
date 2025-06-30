package proyectoPorSemanaKotlin.dam.service

import proyectoPorSemanaKotlin.dam.data.Dao.ITareaDao
import proyectoPorSemanaKotlin.dam.model.Estado
import proyectoPorSemanaKotlin.dam.model.Tarea
import proyectoPorSemanaKotlin.dam.utils.Fecha

class TareaService (val tareaRepo: ITareaDao) : ITareaService{
    override fun consultarTarea(): Tarea? {
        return tareaRepo.consultarTarea()
    }

    override fun aniadirTarea(
        titulo: String,
        descripcion: String,
        fechaLimite: String
    ): Boolean {
        val fechaInicio = Fecha.obtenerFechaActualFormateada()
        val estado = Estado.PENDIENTE
        require(titulo.isNotEmpty()) {"El título no puede estar vacío"}
        require(fechaLimite.isNotEmpty()) {"Debes añadir una fecha límite"}
        return tareaRepo.aniadirTarea(fechaInicio, titulo, descripcion, fechaLimite, estado)
    }

    override fun eliminarTarea(id: String): Boolean {
        require(id.isNotEmpty()) {"El id no puede estar vacío."}
        return tareaRepo.eliminarTarea(id)
    }

    override fun cambiarEstadoTarea(id: String, estado: String): Boolean {
        require(id.isNotEmpty()) {"El id no puede estar vacío."}
        val estadoCorrecto = Estado.desdeString(estado)
        require(estadoCorrecto != null) {"El estado debe ser correcto."}
        return tareaRepo.cambiarEstadoTarea(id, estadoCorrecto)
    }

}