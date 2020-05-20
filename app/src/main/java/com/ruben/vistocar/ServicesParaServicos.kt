package com.ruben.vistocar

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object ServicesParaServicos {



    val host = "https://rubenmorais2.pythonanywhere.com"
    val TAG = "AppVistoCar"

    fun getServicos (context: Context): List<ServicosPai> {
        var servicos = ArrayList<ServicosPai>()
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/servicos"
            val json = HttpHelper.get(url)
            servicos = parserJson(json)
            // salvar offline
            for (a in servicos) {
                saveOffline(a)
            }
            Log.d(TAG, json)
            return servicos
        } else {
            val dao = DatabaseManager.getServicosDAO()
            val servicos = dao.findAll()
            return servicos
        }

    }

    fun getServicos (context: Context, id: Long): ServicosPai? {

        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/servicos/${id}"
            val json = HttpHelper.get(url)
            val servicos = parserJson<ServicosPai>(json)

            return servicos
        } else {
            val dao = DatabaseManager.getServicosDAO()
            val servicos = dao.getById(id)
            return servicos
        }

    }

    fun save(servicos: ServicosPai): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val json = HttpHelper.post("$host/servicos", servicos.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(servicos)
            return Response("OK", "Servico salvo no dispositivo")
        }
    }

    fun saveOffline(servicos: ServicosPai) : Boolean {
        val dao = DatabaseManager.getServicosDAO()

        if (! existeServico(servicos)) {
            dao.insert(servicos)
        }

        return true

    }

    fun existeServico(servicos: ServicosPai): Boolean {
        val dao = DatabaseManager.getServicosDAO()
        return dao.getById(servicos.id) != null

    }
    fun delete(servicos: ServicosPai): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/servicos/${servicos.id}"
            val json = HttpHelper.delete(url)

            return parserJson(json)
        } else {
            val dao = DatabaseManager.getServicosDAO()
            dao.delete(servicos)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}