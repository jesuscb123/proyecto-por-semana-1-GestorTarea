package proyectoPorSemanaKotlin.dam.data.Dao

import javax.sql.DataSource

class TareaDao(private val datasource: DataSource) {

    init{
        val consulta = """
                        CREATE TABLE IF NOT EXISTS TAREA (
                            
        """.trimIndent()
    }

}