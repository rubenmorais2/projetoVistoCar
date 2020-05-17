package com.ruben.vistocar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.ruben.vistocar.R.layout.agendamento
import kotlinx.android.synthetic.main.agendamento.*
import kotlinx.android.synthetic.main.toolbar.*

class CriarAgendamento : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agendamento)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Agendamento"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.adicionar) {
            Toast.makeText(this, "Clicou em Adicionar", Toast.LENGTH_LONG).show()
        } else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}

