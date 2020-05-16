package com.ruben.vistocar

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object ServicesAgendamento {



    val host = "https://fesousa.pythonanywhere.com"
    val TAG = "AppVistoCar"

    fun getAgendamentos (context: Context): List<AgendamentoPai> {
        var agendamentos = ArrayList<AgendamentoPai>()
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/disciplinas"
            val json = HttpHelper.get(url)
            agendamentos = parserJson(json)
            // salvar offline
            for (a in agendamentos) {
                saveOffline(a)
            }
            return agendamentos
        } else {
            val dao = DatabaseManager.getAgendamentoDAO()
            val agendamentos = dao.findAll()
            return agendamentos
        }

    }

    fun getAgendamentos (context: Context, id: Long): AgendamentoPai? {

        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/disciplinas/${id}"
            val json = HttpHelper.get(url)
            val agendamentos = parserJson<AgendamentoPai>(json)

            return agendamentos
        } else {
            val dao = DatabaseManager.getAgendamentoDAO()
            val agendamentos = dao.getById(id)
            return agendamentos
        }

    }

    fun save(agendamento: AgendamentoPai): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val json = HttpHelper.post("$host/disciplinas", agendamento.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(agendamento)
            return Response("OK", "Agendamento salvo no dispositivo")
        }
    }

    fun saveOffline(agendamento: AgendamentoPai) : Boolean {
        val dao = DatabaseManager.getAgendamentoDAO()

        if (! existeAgendamento(agendamento)) {
            dao.insert(agendamento)
        }

        return true

    }

    fun existeAgendamento(agendamento: AgendamentoPai): Boolean {
        val dao = DatabaseManager.getAgendamentoDAO()
        return dao.getById(agendamento.id) != null
    }

    fun delete(agendamento: AgendamentoPai): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/disciplinas/${agendamento.id}"
            val json = HttpHelper.delete(url)

            return parserJson(json)
        } else {
            val dao = DatabaseManager.getAgendamentoDAO()
            dao.delete(agendamento)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}
