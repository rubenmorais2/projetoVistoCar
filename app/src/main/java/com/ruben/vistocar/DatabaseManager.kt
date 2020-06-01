package com.ruben.vistocar

import androidx.room.Room.databaseBuilder

object DatabaseManager {

    private var dbInstace: VistoCarDatabase

    init{
        val appContext= VistoCarApplication.getInstance().applicationContext
        dbInstace = databaseBuilder(
            appContext, VistoCarDatabase::class.java, "car.sqlite"
        ).build()
    }

    fun getAgendamentoDAO(): AgendamentoDAO {
        return dbInstace.agendamentoDAO()
    }
}