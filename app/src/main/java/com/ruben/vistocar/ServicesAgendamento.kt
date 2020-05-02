package com.ruben.vistocar

import android.content.Context

object ServicesAgendamento {

    fun getAgendamentos(context: Context): List<agendamento> {
        val agendamentos = mutableListOf<agendamento>()

        for (i in 1..10) {
            val a = agendamento()
            a.nome = "Nome $i"
            a.carro = "Carro $i"
            a.modeloCarro = "Modelo do carro $i"
            a.data = "Data $i"
            a.foto = "foto $i"
            agendamentos.add(a)

        }
        return agendamentos
    }
}