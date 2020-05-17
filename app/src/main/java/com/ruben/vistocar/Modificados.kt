package com.ruben.vistocar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import kotlinx.android.synthetic.main.toolbar.*

class Modificados : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificados)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Veículos Modificados"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
