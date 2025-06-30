package proyectoPorSemanaKotlin.dam

import proyectoPorSemanaKotlin.dam.UI.Consola
import proyectoPorSemanaKotlin.dam.app.GestorTareas
import proyectoPorSemanaKotlin.dam.data.Dao.TareaDao
import proyectoPorSemanaKotlin.dam.data.Database.DataSourceTarea
import proyectoPorSemanaKotlin.dam.service.TareaService

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val consola = Consola()
    val dataSource = DataSourceTarea().obtener()
    if (dataSource == null){
        consola.mostrarError("Error al conectar con la base de datos.")
    }else{
        val tareaDao = TareaDao(dataSource)
        val tareaService = TareaService(tareaDao)
        val gestorTareas = GestorTareas(tareaService, consola)
    }

}