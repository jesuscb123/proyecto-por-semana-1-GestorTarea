package proyectoPorSemanaKotlin.dam.data.Database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource

object DataSourceTarea {
        private const val JDBC_URL = "jdbc:h2:file:./data/tienda;AUTO_SERVER=TRUE"
        private const val USER = "sa"
        private const val PASSWORD = ""
        private const val DRIVER = "org.h2.Driver"
        private const val MAX_POOL_SIZE = 10

        fun obtener(): DataSource? {
            try{
                val config = HikariConfig()
                config.jdbcUrl = JDBC_URL
                config.username = USER
                config.password = PASSWORD
                config.driverClassName = DRIVER
                config.maximumPoolSize = MAX_POOL_SIZE
                return HikariDataSource(config)

            }catch (e: IllegalArgumentException){
                return null
            }

        }

    }