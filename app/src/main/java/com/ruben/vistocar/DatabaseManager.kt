package com.ruben.vistocar

import androidx.room.Room

object DatabaseManager {

    private var dbInstace: VistoCarDatabase

    init{
        val appContext= VistoCarApplication.getInstance().applicationContext
        dbInstace = Room.databaseBuilder(
            appContext, VistoCarDatabase::class.java, "car.sqlite"
        ).build()
    }

    fun getServicosDAO(): ServicosDAO {
        return dbInstace.servicosDAO()
    }
}