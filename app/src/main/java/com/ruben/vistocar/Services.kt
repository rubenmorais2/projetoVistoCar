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
            Toast.makeText(this, "Clicou em Carros Recuperados", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Recuperados::class.java)
            startActivity(intent)
        }

        recuperados2.setOnClickListener {
            Toast.makeText(this, "Clicou em Carros Recuperados", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Recuperados::class.java)
            startActivity(intent)
        }

        recuperados3.setOnClickListener {
            Toast.makeText(this, "Clicou em Carros Recuperados", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Recuperados::class.java)
            startActivity(intent)
        }

        modificados.setOnClickListener {
            Toast.makeText(this, "Clicou em Carros Modificados", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Modificados::class.java)
            startActivity(intent)
        }

        modificados2.setOnClickListener {
            Toast.makeText(this, "Clicou em Carros Modificados", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Modificados::class.java)
            startActivity(intent)
        }

        modificados3.setOnClickListener {
            Toast.makeText(this, "Clicou em Carros Modificados", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Modificados::class.java)
            startActivity(intent)
        }

        gas.setOnClickListener {
            Toast.makeText(this, "Clicou em Gás Natural", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Gas::class.java)
            startActivity(intent)
        }

        gas2.setOnClickListener {
            Toast.makeText(this, "Clicou em Gás Natural", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Gas::class.java)
            startActivity(intent)
        }

        gas3.setOnClickListener {
            Toast.makeText(this, "Clicou em Gás Natural", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Gas::class.java)
            startActivity(intent)
        }

        transporte.setOnClickListener {
            Toast.makeText(this, "Clicou em Transporte", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Transporte::class.java)
            startActivity(intent)
        }

        transporte2.setOnClickListener {
            Toast.makeText(this, "Clicou em Transporte", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Transporte::class.java)
            startActivity(intent)
        }

        transporte3.setOnClickListener {
            Toast.makeText(this, "Clicou em Transporte", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Transporte::class.java)
            startActivity(intent)
        }

        alvaras.setOnClickListener {
            Toast.makeText(this, "Clicou em Alvarás", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Alvaras::class.java)
            startActivity(intent)
        }

        alvaras2.setOnClickListener {
            Toast.makeText(this, "Clicou em Alvarás", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Alvaras::class.java)
            startActivity(intent)
        }

        alvaras3.setOnClickListener {
            Toast.makeText(this, "Clicou em Alvarás", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Alvaras::class.java)
            startActivity(intent)
        }

        mercosul.setOnClickListener {
            Toast.makeText(this, "Clicou em Inspeção Mercosul", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InspecaoMercosul::class.java)
            startActivity(intent)
        }

        mercosul2.setOnClickListener {
            Toast.makeText(this, "Clicou em Inspeção Mercosul", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InspecaoMercosul::class.java)
            startActivity(intent)
        }

        mercosul3.setOnClickListener {
            Toast.makeText(this, "Clicou em Inspeção Mercosul", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InspecaoMercosul::class.java)
            startActivity(intent)
        }

        seguranca.setOnClickListener {
            Toast.makeText(this, "Clicou em Inspeção de Segurança", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InspecaoSeguranca::class.java)
            startActivity(intent)
        }

        seguranca2.setOnClickListener {
            Toast.makeText(this, "Clicou em Inspeção de Segurança", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InspecaoSeguranca::class.java)
            startActivity(intent)
        }

        seguranca3.setOnClickListener {
            Toast.makeText(this, "Clicou em Inspeção de Segurança", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InspecaoSeguranca::class.java)
            startActivity(intent)
        }

        fretamento.setOnClickListener {
            Toast.makeText(this, "Clicou em Fretamento", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Fretamento::class.java)
            startActivity(intent)
        }

        fretamento2.setOnClickListener {
            Toast.makeText(this, "Clicou em Fretamento", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Fretamento::class.java)
            startActivity(intent)
        }

        fretamento3.setOnClickListener {
            Toast.makeText(this, "Clicou em Fretamento", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Fretamento::class.java)
            startActivity(intent)
        }

        homologacao.setOnClickListener {
            Toast.makeText(this, "Clicou em Homologação de Empresas", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Homologacao::class.java)
            startActivity(intent)
        }

        homologacao2.setOnClickListener {
            Toast.makeText(this, "Clicou em Homologação de Empresas", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Homologacao::class.java)
            startActivity(intent)
        }

        homologacao3.setOnClickListener {
            Toast.makeText(this, "Clicou em Homologação de Empresas", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Homologacao::class.java)
            startActivity(intent)
        }

        qualidade.setOnClickListener {
            Toast.makeText(this, "Clicou em Inspeção de Qualidade", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InspecaoQualidade::class.java)
            startActivity(intent)
        }

        qualidade2.setOnClickListener {
            Toast.makeText(this, "Clicou em Inspeção de Qualidade", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InspecaoQualidade::class.java)
            startActivity(intent)
        }

        qualidade3.setOnClickListener {
            Toast.makeText(this, "Clicou em Inspeção de Qualidade", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InspecaoQualidade::class.java)
            startActivity(intent)
        }

        insencao.setOnClickListener {
            Toast.makeText(this, "Clicou em Insenção de IPVA", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InsencaoIPVA::class.java)
            startActivity(intent)
        }

        insencao2.setOnClickListener {
            Toast.makeText(this, "Clicou em Insenção de IPVA", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InsencaoIPVA::class.java)
            startActivity(intent)
        }

        insencao3.setOnClickListener {
            Toast.makeText(this, "Clicou em Insenção de IPVA", Toast.LENGTH_SHORT).show()
            intent = Intent(this, InsencaoIPVA::class.java)
            startActivity(intent)
        }

        acessibilidade.setOnClickListener {
            Toast.makeText(this, "Clicou em Acessibilidade", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Acessibilidade::class.java)
            startActivity(intent)
        }

        acessibilidade2.setOnClickListener {
            Toast.makeText(this, "Clicou em Acessibilidade", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Acessibilidade::class.java)
            startActivity(intent)
        }

        acessibilidade3.setOnClickListener {
            Toast.makeText(this, "Clicou em Acessibilidade", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Acessibilidade::class.java)
            startActivity(intent)
        }

        coleta.setOnClickListener {
            Toast.makeText(this, "Clicou em Coleta de Entulho", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Caminhoes::class.java)
            startActivity(intent)
        }

        coleta2.setOnClickListener {
            Toast.makeText(this, "Clicou em Coleta de Entulho", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Caminhoes::class.java)
            startActivity(intent)
        }

        coleta3.setOnClickListener {
            Toast.makeText(this, "Clicou em Coleta de Entulho", Toast.LENGTH_SHORT).show()
            intent = Intent(this, Caminhoes::class.java)
            startActivity(intent)
        }

        importados.setOnClickListener {
            Toast.makeText(this, "Clicou em Processo de Importação", Toast.LENGTH_SHORT).show()
            intent = Intent(this, ProcessoImportacao::class.java)
            startActivity(intent)
        }

        importados2.setOnClickListener {
            Toast.makeText(this, "Clicou em Processo de Importação", Toast.LENGTH_SHORT).show()
            intent = Intent(this, ProcessoImportacao::class.java)
            startActivity(intent)
        }

        importados3.setOnClickListener {
            Toast.makeText(this, "Clicou em Processo de Importação", Toast.LENGTH_SHORT).show()
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