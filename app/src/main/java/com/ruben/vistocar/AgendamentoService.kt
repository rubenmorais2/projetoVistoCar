package com.ruben.vistocar

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object AgendamentoService {

    val host = "https://agendar.pythonanywhere.com/"
    val TAG = "AgendarApp"

    fun getAgendamentos (context: Context): List<AgendamentoPai> {
        var agendamentos = ArrayList<AgendamentoPai>()
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/agendamentos"
            val json = HttpHelper.get(url)
            agendamentos = parserJson(json)
            // salvar offline
            for (d in agendamentos) {
                saveOffline(d)
            }
            return agendamentos
        } else {
            val dao = databaseManagerAgendar.getAgendamentoDAO()
            val agendamentos = dao.findAll()
            return agendamentos
        }

    }

    fun getAgendamento (context: Context, id: Long): AgendamentoPai? {

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

    fun save(agendamentos: AgendamentoPai): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val json = HttpHelper.post("$host/agendamentos", agendamentos.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(agendamentos)
            return Response("OK", "Agendamento salvo no dispositivo")
        }
    }

    fun saveOffline(agendamentos: AgendamentoPai) : Boolean {
        val dao = databaseManagerAgendar.getAgendamentoDAO()

        if (! existeAgendamento(agendamentos)) {
            dao.insert(agendamentos)
        }

        return true

    }

    fun existeAgendamento(agendamentos: AgendamentoPai): Boolean {
        val dao = databaseManagerAgendar.getAgendamentoDAO()
        return dao.getById(agendamentos.id) != null
    }

    fun delete(agendamentos: AgendamentoPai): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/agendamentos/${agendamentos.id}"
            val json = HttpHelper.delete(url)

            return parserJson(json)
        } else {
            val dao = databaseManagerAgendar.getAgendamentoDAO()
            dao.delete(agendamentos)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}