package com.ruben.vistocar

import androidx.room.Room

object databaseManagerAgendar {

    private var dbInstace: AgendamentoDataBase

    init{
        val appContext= VistoCarApplication.getInstance().applicationContext
        dbInstace = Room.databaseBuilder(
            appContext, AgendamentoDataBase::class.java, "car.sqlite"
        ).build()
    }

    fun getAgendamentoDAO(): AgendamentoDAO {
        return dbInstace.agendamentoDAO()
    }
}