package com.ruben.vistocar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.agendamento.*
import kotlinx.android.synthetic.main.meus_agendamentos.*
import kotlinx.android.synthetic.main.toolbar.*

class CriarAgendamento : DebugActivity() {

    private val context: Context get() = this
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agendamento)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Agendamento"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerAgendar?.layoutManager = LinearLayoutManager(context)
        recyclerAgendar?.itemAnimator = DefaultItemAnimator()
        recyclerAgendar?.setHasFixedSize(true)

        salvarAgendamento.setOnClickListener {
            val agendamento = AgendamentoPai()
            agendamento.modelo = modelo.text.toString()
            agendamento.marca = marca.text.toString()
            agendamento.tipoServico = tipoServico.text.toString()
            agendamento.horario = horario.text.toString()
            agendamento.data = data.text.toString()

            taskAtualizar(agendamento)
        }
    }
    private fun taskAtualizar(agendamento: AgendamentoPai) {
        Thread {
            AgendamentoService.save(agendamento)
            runOnUiThread{
                finish()
            }
        }.start()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.adicionar) {
            Toast.makeText(this, "Clicou em Adicionar", Toast.LENGTH_LONG).show()
            val intent = Intent(context, MeusAgendamentos::class.java)
            startActivityForResult(intent, REQUEST_CADASTRO)
        } else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}

