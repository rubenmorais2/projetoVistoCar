package com.ruben.vistocar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.meus_agendamentos.*
import kotlinx.android.synthetic.main.toolbar.*

class MeusAgendamentos : AppCompatActivity() {

    private val context: Context get() = this
    private var agendamento = listOf<AgendamentoPai>()
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meus_agendamentos)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Meus Agendamentos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerAgendar?.layoutManager = LinearLayoutManager(context)
        recyclerAgendar?.itemAnimator = DefaultItemAnimator()
        recyclerAgendar?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskAgendamentos()
    }

    fun taskAgendamentos(){
        Thread {
            agendamento = AgendamentoService.getAgendamentos(context)
            runOnUiThread{
                recyclerAgendar?.adapter = AgendamentoAdapter(agendamento) {onClickAgendamentos(it)}
            }
        }.start()
    }

    fun onClickAgendamentos(agendamento: AgendamentoPai) {
        Toast.makeText(context, "Clicou Agendamento ${agendamento.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, AgendandoAgendar::class.java)
        startActivityForResult(intent, REQUEST_REMOVE)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_config, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.adicionar) {
            Toast.makeText(this, "Clicou em Adicionar", Toast.LENGTH_LONG).show()
            var intent = Intent(this, CriarAgendamento::class.java)
            startActivityForResult(intent, REQUEST_CADASTRO)
        }else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CADASTRO || requestCode == REQUEST_REMOVE ) {
            // atualizar lista de disciplinas
            taskAgendamentos()
        }
    }
}


