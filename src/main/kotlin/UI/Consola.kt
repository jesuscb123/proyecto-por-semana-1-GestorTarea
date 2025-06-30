package proyectoPorSemanaKotlin.dam.UI



class Consola () : IEntradaSalida {
    override fun mostrar(texto: String) {
        println(texto)
    }

    override fun mostrarError(texto: String) {
        println("Error - $texto")
    }

    override fun pedirEntero(msj: String): Int {
        var numero = 0
        var salir = false
        do {
            try {
                mostrar(msj)
                numero = readln().toInt()
                salir = true
            }catch (e: NumberFormatException){
                mostrarError(e.toString())
            }
        } while (!salir)
        return numero
    }

    override fun pedir(msj: String): String {
        mostrar(msj)
        return readln()
    }

}