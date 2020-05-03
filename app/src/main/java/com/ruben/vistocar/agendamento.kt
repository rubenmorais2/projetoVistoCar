package com.ruben.vistocar


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "agendamento")
class agendamento: Serializable {

    @PrimaryKey
    var id: Long = 0
    var nome: String = ""
    var categoria: String = ""
    var foto: String = ""

    override fun toString(): String {
        return "Agendamento(nome'$nome')"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}



