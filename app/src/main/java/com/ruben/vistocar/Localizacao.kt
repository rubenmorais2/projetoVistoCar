package com.ruben.vistocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.localizacao.*
import kotlinx.android.synthetic.main.toolbar.*

class Localizacao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.localizacao)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Unidades e Localização"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        jacana.setOnClickListener {
            intent = Intent(this, Jacana::class.java)
            Toast.makeText(this, "Unidade Jaçanã", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        ipiranga.setOnClickListener {
            intent = Intent(this, Ipiranga::class.java)
            Toast.makeText(this, "Unidade Ipiranga", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        butanta.setOnClickListener {
            intent = Intent(this, Butanta::class.java)
            Toast.makeText(this, "Unidade Butantã", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        saude.setOnClickListener {
            intent = Intent(this, Saude::class.java)
            Toast.makeText(this, "Unidade Saúde", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }
}


