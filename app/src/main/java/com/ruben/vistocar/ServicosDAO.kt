package com.ruben.vistocar

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ServicosDAO {

    @Query("SELECT * FROM servico where id = :id")
    fun getById(id: Long): ServicosPai?

    @Query("SELECT * FROM servico")
    fun findAll(): List<ServicosPai>

    @Insert
    fun insert(servico: ServicosPai)

    @Delete
    fun delete(servico: ServicosPai)
}
