package com.ruben.vistocar


import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "agendamento")
class AgendamentoPai: Serializable{

    @PrimaryKey
    var id: Long = 0
    var nome: String = ""
    var foto: String = ""
    var text: String = ""

    override fun toString(): String {
        return "Agendamento(nome'$nome')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}





