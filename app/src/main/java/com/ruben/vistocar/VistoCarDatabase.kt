package com.ruben.vistocar

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities=arrayOf(AgendamentoPai::class), version = 1)
abstract class VistoCarDatabase: RoomDatabase() {
    abstract fun agendamentoDAO() : AgendamentoDAO
}