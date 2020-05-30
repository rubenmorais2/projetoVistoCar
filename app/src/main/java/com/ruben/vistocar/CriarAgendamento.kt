package com.ruben.vistocar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.agendamento.*
import kotlinx.android.synthetic.main.toolbar.*


class CriarAgendamento : DebugActivity() {

    private val context: Context get() = this
    private var agendamento = listOf<AgendamentoPai>()
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agendamento)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Agendamento"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        salvarAgendamento.setOnClickListener {
            val agendamento = AgendamentoPai()

            //data.setError("Campo vazio")
            agendamento.modelo = modelo.text.toString()
            agendamento.marca = marca.text.toString()
            agendamento.tipoServico = tipoServico.text.toString()
            agendamento.horario = horario.text.toString()
            agendamento.data = data.text.toString()
            //if (modelo.text.isNotEmpty() && marca.text.isNotEmpty() && tipoServico.text.isNotEmpty() && horario.text.isNotEmpty() && data.text.isNotEmpty())  {
                taskAgendamentos(agendamento)
            //}

        }

    }
    private fun taskAgendamentos(agendamento: AgendamentoPai) {
        Thread {
            AgendamentoService.save(agendamento)
            runOnUiThread{
                finish()
            }
        }.start()
    }

    fun notificacao(agendamento: MatchGroup?){
        val intent = Intent(this, MeusAgendamentos::class.java)

        NotificationUtil.create(this, 1, intent, "Visto Car", "Você tem um novo agendamento")
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

