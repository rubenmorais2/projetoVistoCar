package com.ruben.vistocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.toolbar.*

class MeusAgendamentos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meus_agendamentos)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Meus Agendamentos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // método sobrescrito para inflar o menu na Actionbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu_config, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.adicionar) {
            Toast.makeText(this, "Clicou em Adicionar", Toast.LENGTH_LONG).show()
            var intent = Intent(this, CriarAgendamento::class.java)
            startActivity(intent)
        } else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
