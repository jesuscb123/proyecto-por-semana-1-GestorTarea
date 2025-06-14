package proyectoPorSemanaKotlin.dam.model

class Tarea(val titulo: String,
            val descripcion: String,
            val fechaLimite: String) {

    var estado: Estado = Estado.PENDIENTE
        private set

    fun cambiarEstado(estado: Estado){
        this.estado = estado
    }
}