package com.ruben.vistocar

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder

@Entity(tableName = "agendamento")
class AgendamentoPai {

    @PrimaryKey
    var id: Long = 0
    var nome: String = ""
    var modelo: String = ""
    var marca: String = ""
    var tipoServico: String = ""
    var horario: String = ""
    var data: String = ""


    override fun toString(): String {
        return "Agendamento(nome'$nome')"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}
