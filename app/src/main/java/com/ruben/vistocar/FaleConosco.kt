package com.ruben.vistocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.ruben.vistocar.R
import kotlinx.android.synthetic.main.fale_conosco.*
import kotlinx.android.synthetic.main.toolbar.*

class FaleConosco : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fale_conosco)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Fale Conosco"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tabela.setOnClickListener {
            Toast.makeText(this, "Clicou na Tabela de preços", Toast.LENGTH_SHORT).show()
            intent = Intent(this, TabelaPrecos::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
