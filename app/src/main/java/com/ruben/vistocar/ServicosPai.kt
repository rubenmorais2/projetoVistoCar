package com.ruben.vistocar

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder

@Entity(tableName = "servico")
class ServicosPai {

    @PrimaryKey
    var id: Long = 0
    var nome: String = ""
    var foto: String = ""
    var text: String = ""

    override fun toString(): String {
        return "Servico(nome'$nome')"
    }
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}
