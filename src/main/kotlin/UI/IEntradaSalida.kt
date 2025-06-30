package proyectoPorSemanaKotlin.dam.UI

interface IEntradaSalida {
    fun mostrar(texto: String)
    fun mostrarError(texto: String)
    fun pedirEntero(msj: String): Int
    fun pedir(msj: String): String
}