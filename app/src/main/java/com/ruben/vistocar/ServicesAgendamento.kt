package com.ruben.vistocar

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

object ServicesAgendamento {

    fun getAgendamentos(context: Context): List<agendamento> {
        val agendamentos = mutableListOf<agendamento>()

        val a = agendamento()
        a.nome = "Veículos Recuperados de Sinistro"
        a.categoria = "1"
        a.foto = "http://www.vistocar.com.br/template/imagens/img-home-1.png"
        agendamentos.add(a)

        a.nome = "Veículos Modificados/ Alteração de Caracteristicas"
        a.categoria = "2"
        a.foto = "https://www.vistocar.com.br/template/imagens/img-home-2.png"
        agendamentos.add(a)

        a.nome = "Gás Natural Veicular (GNV)"
        a.categoria = "3"
        a.foto = "https://www.vistocar.com.br/template/imagens/img-home-3.png"
        agendamentos.add(a)

        a.nome = "Transporte Produtos Perigosos"
        a.categoria = "4"
        a.foto = "https://www.vistocar.com.br/template/imagens/img-home-4.png"
        agendamentos.add(a)

        a.nome = "Inspeção Mercosul (CITV)"
        a.categoria = "5"
        a.foto = "http://www.vistocar.com.br/template/imagens/img-home-5.png"
        agendamentos.add(a)

        a.nome = "Alvarás de Taxis e Escolares"
        a.categoria = "6"
        a.foto = "http://www.vistocar.com.br/template/imagens/img-home-6.png"
        agendamentos.add(a)

        return agendamentos
    }

}