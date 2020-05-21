package com.ruben.vistocar

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object ServicesAgendamento {



    val host = "https://rubenmorais2.pythonanywhere.com"
    val TAG = "AppVistoCar"

    fun getAgendamentos (context: Context): List<AgendamentoPai> {
        var agendamentos = ArrayList<AgendamentoPai>()
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/agendamentos"
            val json = HttpHelper.get(url)
            agendamentos = parserJson(json)
            // salvar offline
            for (a in agendamentos) {
                saveOffline(a)
            }
            return agendamentos
        } else {
            val dao = databaseManagerAgendar.getAgendamentoDAO()
            val agendamentos = dao.findAll()
            return agendamentos
        }

    }

    fun getAgendamentos (context: Context, id: Long): AgendamentoPai? {

        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/agendamentos/${id}"
            val json = HttpHelper.get(url)
            val agendamentos = parserJson<AgendamentoPai>(json)

            return agendamentos
        } else {
            val dao = databaseManagerAgendar.getAgendamentoDAO()
            val agendamentos = dao.getById(id)
            return agendamentos
        }

    }

    fun save(agendamento: AgendamentoPai): Response {
            val json = HttpHelper.post("$host/agendamentos", agendamento.toJson())
            return parserJson(json)
        }

    fun saveOffline(agendamento: AgendamentoPai) : Boolean {
        val dao = databaseManagerAgendar.getAgendamentoDAO()

        if (! existeAgendamento(agendamento)) {
            dao.insert(agendamento)
        }

        return true

    }

    fun existeAgendamento(agendamento: AgendamentoPai): Boolean {
        val dao = databaseManagerAgendar.getAgendamentoDAO()
        return dao.getById(agendamento.id) != null
    }

    fun delete(agendamento: AgendamentoPai): Response {
            val url = "$host/agendamentos/${agendamento.id}"
            val json = HttpHelper.delete(url)

            return parserJson(json)


    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}
