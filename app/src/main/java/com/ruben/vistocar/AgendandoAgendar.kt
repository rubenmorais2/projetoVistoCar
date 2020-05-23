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
import kotlinx.android.synthetic.main.layout_meus_agendamentos.*
import kotlinx.android.synthetic.main.meus_agendamentos.*
import kotlinx.android.synthetic.main.toolbar.*

class AgendandoAgendar: AppCompatActivity() {

    private val context: Context get() = this
    var agendamento: AgendamentoPai? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_meus_agendamentos)
        setTitle("Agendamentos")

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_remove, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId
        if (id == R.id.action_remover) {
            AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Deseja excluir o agendamento?")
                .setPositiveButton("Sim") { dialog, which ->
                    dialog.dismiss()
                    taskExcluir()
                }.setNegativeButton("Não") { dialog, which ->
                    dialog.dismiss()
                }.create().show()
        } else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun taskExcluir() {
        if (this.agendamento != null && this.agendamento is AgendamentoPai) {
            Thread {
                AgendamentoService.delete(this.agendamento as AgendamentoPai)
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }

}
