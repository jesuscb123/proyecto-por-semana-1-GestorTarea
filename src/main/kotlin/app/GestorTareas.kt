package proyectoPorSemanaKotlin.dam.app

import proyectoPorSemanaKotlin.dam.UI.IEntradaSalida
import proyectoPorSemanaKotlin.dam.service.ITareaService
import java.lang.IllegalArgumentException

class GestorTareas (val tareaService: ITareaService, val consola: IEntradaSalida) {

    companion object{
        const val MENU_TAREA = """
                        GESTOR DE TAREAS
                        ----------------
                        1. Añadir Tarea.
                        2. Consultar tareas.
                        3. Eliminar Tarea.
                        4. Cambiar estado de tarea.
                        5. salir.
        """
    }

    fun iniciar(){
        var salir = false
        while (!salir){
            try{
                consola.mostrar(MENU_TAREA)
                var opcionUsuario = consola.pedirEntero("Introduce una opción")
                if (eleccion(opcionUsuario)) salir = true
            }catch (e: IllegalArgumentException){
                consola.mostrarError(e.toString())
            }
        }
    }

    fun eleccion(opcionUsuario: Int): Boolean {
        when (opcionUsuario){
            1 -> aniadirTarea()
            2 -> tareaService.consultarTarea()
            3 -> eliminarTarea()
            4 -> cambiarEstado()
            5 -> return true
        }
        return false
    }

    fun aniadirTarea(): Boolean{
        val titulo = consola.pedir("Introduce un título para la tarea.")
        val descripcion = consola.pedir("Introduce una descripción para la tarea.")
        val fechaLimite = consola.pedir("Introduce la fecha límite de la tarea.")
        return tareaService.aniadirTarea(titulo, descripcion, fechaLimite)
    }

    fun eliminarTarea(): Boolean{
        val id = consola.pedir("Introduce el id de la tarea que quieres eliminar.")
        return tareaService.eliminarTarea(id)
    }

    fun cambiarEstado(): Boolean{
        val id = consola.pedir("Introduce el id de la tarea")
        val estado = consola.pedir("Introduce el nuevo estado de la tarea.")
        return tareaService.cambiarEstadoTarea(id, estado)
    }

}