package com.ruben.vistocar


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.servicos.*
import kotlinx.android.synthetic.main.toolbar.*

class Services : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.servicos)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Serviços"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recuperados.setOnClickListener {
            intent = Intent(this, Recuperados::class.java)
            startActivity(intent)
        }

        recuperados2.setOnClickListener {
            intent = Intent(this, Recuperados::class.java)
            startActivity(intent)
        }

        recuperados3.setOnClickListener {
            intent = Intent(this, Recuperados::class.java)
            startActivity(intent)
        }

        modificados.setOnClickListener {
            intent = Intent(this, Modificados::class.java)
            startActivity(intent)
        }

        modificados2.setOnClickListener {
            intent = Intent(this, Modificados::class.java)
            startActivity(intent)
        }

        modificados3.setOnClickListener {
            intent = Intent(this, Modificados::class.java)
            startActivity(intent)
        }

        gas.setOnClickListener {
            intent = Intent(this, Gas::class.java)
            startActivity(intent)
        }

        gas2.setOnClickListener {
            intent = Intent(this, Gas::class.java)
            startActivity(intent)
        }

        gas3.setOnClickListener {
            intent = Intent(this, Gas::class.java)
            startActivity(intent)
        }

        transporte.setOnClickListener {
            intent = Intent(this, Transporte::class.java)
            startActivity(intent)
        }

        transporte2.setOnClickListener {
            intent = Intent(this, Transporte::class.java)
            startActivity(intent)
        }

        transporte3.setOnClickListener {
            intent = Intent(this, Transporte::class.java)
            startActivity(intent)
        }

        alvaras.setOnClickListener {
            intent = Intent(this, Alvaras::class.java)
            startActivity(intent)
        }

        alvaras2.setOnClickListener {
            intent = Intent(this, Alvaras::class.java)
            startActivity(intent)
        }

        alvaras3.setOnClickListener {
            intent = Intent(this, Alvaras::class.java)
            startActivity(intent)
        }

        mercosul.setOnClickListener {
            intent = Intent(this, InspecaoMercosul::class.java)
            startActivity(intent)
        }

        mercosul2.setOnClickListener {
            intent = Intent(this, InspecaoMercosul::class.java)
            startActivity(intent)
        }

        mercosul3.setOnClickListener {
            intent = Intent(this, InspecaoMercosul::class.java)
            startActivity(intent)
        }

        seguranca.setOnClickListener {
            intent = Intent(this, InspecaoSeguranca::class.java)
            startActivity(intent)
        }

        seguranca2.setOnClickListener {
            intent = Intent(this, InspecaoSeguranca::class.java)
            startActivity(intent)
        }

        seguranca3.setOnClickListener {
            intent = Intent(this, InspecaoSeguranca::class.java)
            startActivity(intent)
        }

        fretamento.setOnClickListener {
            intent = Intent(this, Fretamento::class.java)
            startActivity(intent)
        }

        fretamento2.setOnClickListener {
            intent = Intent(this, Fretamento::class.java)
            startActivity(intent)
        }

        fretamento3.setOnClickListener {
            intent = Intent(this, Fretamento::class.java)
            startActivity(intent)
        }

        homologacao.setOnClickListener {
            intent = Intent(this, Homologacao::class.java)
            startActivity(intent)
        }

        homologacao2.setOnClickListener {
            intent = Intent(this, Homologacao::class.java)
            startActivity(intent)
        }

        homologacao3.setOnClickListener {
            intent = Intent(this, Homologacao::class.java)
            startActivity(intent)
        }

        qualidade.setOnClickListener {
            intent = Intent(this, InspecaoQualidade::class.java)
            startActivity(intent)
        }

        qualidade2.setOnClickListener {
            intent = Intent(this, InspecaoQualidade::class.java)
            startActivity(intent)
        }

        qualidade3.setOnClickListener {
            intent = Intent(this, InspecaoQualidade::class.java)
            startActivity(intent)
        }

        insencao.setOnClickListener {
            intent = Intent(this, InsencaoIPVA::class.java)
            startActivity(intent)
        }

        insencao2.setOnClickListener {
            intent = Intent(this, InsencaoIPVA::class.java)
            startActivity(intent)
        }

        insencao3.setOnClickListener {
            intent = Intent(this, InsencaoIPVA::class.java)
            startActivity(intent)
        }

        acessibilidade.setOnClickListener {
            intent = Intent(this, Acessibilidade::class.java)
            startActivity(intent)
        }

        acessibilidade2.setOnClickListener {
            intent = Intent(this, Acessibilidade::class.java)
            startActivity(intent)
        }

        acessibilidade3.setOnClickListener {
            intent = Intent(this, Acessibilidade::class.java)
            startActivity(intent)
        }

        coleta.setOnClickListener {
            intent = Intent(this, Caminhoes::class.java)
            startActivity(intent)
        }

        coleta2.setOnClickListener {
            intent = Intent(this, Caminhoes::class.java)
            startActivity(intent)
        }

        coleta3.setOnClickListener {
            intent = Intent(this, Caminhoes::class.java)
            startActivity(intent)
        }

        importados.setOnClickListener {
            intent = Intent(this, ProcessoImportacao::class.java)
            startActivity(intent)
        }

        importados2.setOnClickListener {
            intent = Intent(this, ProcessoImportacao::class.java)
            startActivity(intent)
        }

        importados3.setOnClickListener {
            intent = Intent(this, ProcessoImportacao::class.java)
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
