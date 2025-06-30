package proyectoPorSemanaKotlin.dam.model

enum class Estado (val texto: String) {
    PENDIENTE("pendiente"),
    REALIZADO("realizado"),
    EN_PROCESO("en proceso");
    companion object{
        fun desdeString(valor: String): Estado? {
            return entries.firstOrNull { it.texto.equals(valor.trim(), ignoreCase = true) }
        }
    }
}