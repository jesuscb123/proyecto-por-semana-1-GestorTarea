package proyectoPorSemanaKotlin.dam.data.Dao

import proyectoPorSemanaKotlin.dam.model.Estado
import proyectoPorSemanaKotlin.dam.model.Tarea
import javax.sql.DataSource

class TareaDao(private val datasource: DataSource) : ITareaDao{

    init{
        val consulta = """
                        CREATE TABLE IF NOT EXISTS Tarea (
                            id INT PRIMARY KEY,
                            titulo VARCHAR(100),
                            descripcion VARCHAR(5OO),
                            fecha_limite VARCHAR(100),
                            estado VARCHAR(100);
        """.trimIndent()

        datasource.connection.use{conn ->
            val stmt = conn.createStatement()
            stmt.executeUpdate(consulta)
        }
    }

    override fun consultarTarea(): Tarea? {
        var tarea: Tarea? = null
        val consulta = "SELECT * FROM Tarea;"
        datasource.connection.use {conn ->
            val stmt = conn.createStatement()
           val rs = stmt.executeQuery(consulta)
            while(rs.next()){
                tarea = Tarea(
                    inicioTarea =  rs.getString("id"),
                    titulo = rs.getString("titulo"),
                    descripcion = rs.getString("descripcion"),
                    fechaLimite = rs.getString("fecha_limite"),
                    estado = Estado.valueOf(rs.getString("estado"))
                )
            }
        }
        return tarea
    }

    override fun aniadirTarea(fechaInicio: String, titulo: String, descripcion: String, fechaLimite: String, estado: Estado): Boolean {
        val consulta = """
                    INSERT INTO Tarea (id, titulo, descripcion, fecha_limite, inicio_tarea, estado)
                    VALUES (?, ?, ?, ?, ?, ?);
        """.trimIndent()
        datasource.connection.use {conn ->
            val stmt = conn.prepareStatement(consulta)
            stmt.setString(1, fechaInicio)
            stmt.setString(2, titulo)
            stmt.setString(3, descripcion)
            stmt.setString(4, fechaLimite)
            stmt.setString(5, estado.name)
            return stmt.executeUpdate() != 0
        }
    }

    override fun eliminarTarea(id: String): Boolean {
        val consulta = """
                DELETE FROM Tarea
                WHERE id = ?;
        """.trimIndent()
        datasource.connection.use {conn ->
            val stmt = conn.prepareStatement(consulta)
            stmt.setString(1, id)
            return stmt.executeUpdate() != 0
        }
    }

    override fun cambiarEstadoTarea(id: String, estado: Estado): Boolean {
        val consulta = """
            UPDATE Tarea 
             SET estado = ?
             WHERE id = ?;
        """.trimIndent()
        datasource.connection.use {conn ->
            val stmt = conn.prepareStatement(consulta)
            stmt.setString(1, estado.name)
            stmt.setString(2, id)
            return stmt.executeUpdate() != 0
        }
    }

}