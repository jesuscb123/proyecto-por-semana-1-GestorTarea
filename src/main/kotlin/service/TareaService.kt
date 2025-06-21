package proyectoPorSemanaKotlin.dam.service

import proyectoPorSemanaKotlin.dam.data.Dao.ITareaDao
import proyectoPorSemanaKotlin.dam.model.Estado
import proyectoPorSemanaKotlin.dam.model.Tarea
import proyectoPorSemanaKotlin.dam.utils.Fecha
import java.time.LocalTime

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
        TODO("Not yet implemented")
    }

    override fun cambiarEstadoTarea(id: String, estado: Estado): Boolean {
        TODO("Not yet implemented")
    }


}