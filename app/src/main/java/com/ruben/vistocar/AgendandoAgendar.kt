package com.ruben.vistocar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.agenda_agendamentos.*
import kotlinx.android.synthetic.main.agendamento.*
import kotlinx.android.synthetic.main.toolbar.*

class AgendandoAgendar: AppCompatActivity() {

    private val context: Context get() = this
    var agendamento: AgendamentoPai? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agenda_agendamentos)

        //val personNames = arrayOf("", "Palio", "Fiat", "Chevrolet", "Renaut", "Volkswagem", "Ford", "Toyota", "Hyundai")
        //val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, personNames)

        //marca.adapter = arrayAdapter

        //marca.onItemSelectedListener = object :

          //  AdapterView.OnItemSelectedListener {
            //override fun onNothingSelected(parent: AdapterView<*>?) {

            //}

            //override fun onItemSelected(
              //  parent: AdapterView<*>?,
                //view: View?,
                //position: Int,
                //id: Long
            //) {
            //}
        //}


        if (intent.getSerializableExtra("agendamento") is AgendamentoPai)
            agendamento = intent.getSerializableExtra("agendamento") as AgendamentoPai


        setSupportActionBar(toolbar)


        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //para atualizar dados
        carro.text = agendamento?.modelo
        model.text = agendamento?.marca
        typeService.text = agendamento?.tipoServico
        time.text = agendamento?.horario
        date.text = agendamento?.data

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
                .setPositiveButton("Sim") {
                    dialog, which ->
                    dialog.dismiss()
                    taskExcluir()
                }.setNegativeButton("Não") {
                    dialog, which ->
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
