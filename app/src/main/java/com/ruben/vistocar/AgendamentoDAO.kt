package com.ruben.vistocar

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AgendamentoDAO {

    @Query("SELECT * FROM agendamento where id = :id")
    fun getById(id: Long): AgendamentoPai?

    @Query("SELECT * FROM agendamento")
    fun findAll(): List<AgendamentoPai>

    @Insert
    fun insert(agendamento: AgendamentoPai)

    @Delete
    fun delete(agendamento: AgendamentoPai)
}