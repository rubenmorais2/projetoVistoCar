package com.ruben.vistocar

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "agendamento")
class AgendamentoPai : Serializable {

    @PrimaryKey
    var id: Long = 0
    var edittext: String = ""
    var marca: String = ""
    var modelo: String = ""
    var tipoServico: String = ""
    var horario: String = ""
    var data: String = ""
    var placa: String = ""
    var collection: String = ("usuários")

    override fun toString(): String {
        return "Agendamento(nome'$edittext')"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}
