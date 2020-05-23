package com.ruben.vistocar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.servicos.*
import kotlinx.android.synthetic.main.toolbar.*

class Servicos : AppCompatActivity() {

    private val context: Context get() = this

    private var servicos = listOf<ServicosPai>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.servicos)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Serviços"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerServicos?.layoutManager = LinearLayoutManager(context)
        recyclerServicos?.itemAnimator = DefaultItemAnimator()
        recyclerServicos?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskServicos()
    }

    fun taskServicos() {
        Thread {
            this.servicos = ServicesParaServicos.getServicos(context)
            runOnUiThread {
                recyclerServicos?.adapter = ServicosAdapter(servicos) { onClickServicos() }
            }
        }.start()
    }

    fun onClickServicos() {
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
