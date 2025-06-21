package proyectoPorSemanaKotlin.dam.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Fecha {
    companion object{
        /**
         * Obtiene la fecha actual formateada.
         *@return fecha actual formateada.
         */
        fun obtenerFechaActualFormateada(): String{
            return DateTimeFormatter.ofPattern("YYYYMMddhhmmss").format(LocalDateTime.now())
        }
    }

}