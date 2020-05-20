package com.ruben.vistocar

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object AgendamentoService {

    val host = "https://agendar.pythonanywhere.com/"
    val TAG = "AgendarApp"

    fun getAgendamentos (context: Context): List<AgendamentoPai> {
        val agendamentos = mutableListOf<AgendamentoPai>()
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/agendamentos"
            val json = HttpHelper.get(url)

            // salvar offline
            for (a in agendamentos) {
                saveOffline(a)
            }

            Log.d(TAG, json)
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
        if (AndroidUtils.isInternetDisponivel()) {
            val json = HttpHelper.post("$host/agendamentos", agendamento.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(agendamento)
            return Response("OK", "Agendamento salvo no dispositivo")
        }
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
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/agendamentos/${agendamento.id}"
            val json = HttpHelper.delete(url)

            return parserJson(json)
        } else {
            val dao = databaseManagerAgendar.getAgendamentoDAO()
            dao.delete(agendamento)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}
