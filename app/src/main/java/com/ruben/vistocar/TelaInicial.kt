package com.ruben.vistocar

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.servicos.*
import kotlinx.android.synthetic.main.tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicial : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_inicial)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Tela Inicial"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

    }

    fun cliqueSair() {
        val returnIntent = Intent();
        returnIntent.putExtra("result", "Saída do Visto Car");
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }



    private fun configuraMenuLateral() {

        // ícone de menu (hamburger) para mostrar o menu
        var toogle = ActionBarDrawerToggle(this, layout_menu_lateral, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        layout_menu_lateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_agendamento -> {
                Toast.makeText(this, "Clicou em Meus Agendamentos", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MeusAgendamentos ::class.java)
                startActivity(intent)
            }

            R.id.nav_perfil -> {
                Toast.makeText(this, "Clicou no Perfil", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Perfil ::class.java)
                startActivity(intent)
            }
            R.id.fale_conosco -> {
                Toast.makeText(this, "Clicou em Fale Conosco", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, FaleConosco::class.java)
                startActivity(intent)
            }
            R.id.services -> {
                Toast.makeText(this, "Clicou em Serviços", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Servicos::class.java)
                startActivity(intent)
            }

            R.id.modificados -> {
                Toast.makeText(this, "Clicou em Modificados", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Modificados::class.java)
                startActivity(intent)
            }
            R.id.gas -> {
                Toast.makeText(this, "Clicou em Gás", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Gas::class.java)
                startActivity(intent)
            }
            R.id.transporte -> {
                Toast.makeText(this, "Clicou em Transporte", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Transporte::class.java)
                startActivity(intent)
            }

            R.id.inspecaoM -> {
                Toast.makeText(this, "Clicou em Inspeção Mercosul", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, InspecaoMercosul::class.java)
                startActivity(intent)
            }
            R.id.inspecaoS -> {
                Toast.makeText(this, "Clicou em Inspeção de Segurança", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, InspecaoSeguranca::class.java)
                startActivity(intent)
            }
            R.id.inspecaoQ -> {
                Toast.makeText(this, "Clicou em Inspeção de Qualidade", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, InspecaoQualidade::class.java)
                startActivity(intent)
            }
            R.id.fretamento -> {
                Toast.makeText(this, "Clicou em Fretamento", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Fretamento::class.java)
                startActivity(intent)
            }
            R.id.homologacao -> {
                Toast.makeText(this, "Clicou em Homologação", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Homologacao::class.java)
                startActivity(intent)
            }
            R.id.insencao -> {
                Toast.makeText(this, "Clicou em Insenção", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, InsencaoIPVA::class.java)
                startActivity(intent)
            }
            R.id.acessibilidade -> {
                Toast.makeText(this, "Clicou em Acessibilidade", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Acessibilidade::class.java)
                startActivity(intent)
            }
            R.id.caminhoes -> {
                Toast.makeText(this, "Clicou em Caminhões", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Caminhoes::class.java)
                startActivity(intent)
            }
            R.id.importacao -> {
                Toast.makeText(this, "Clicou em Importação", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, ProcessoImportacao::class.java)
                startActivity(intent)
            }
            R.id.grupo -> {
                Toast.makeText(this, "Clicou em O Grupo", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, SobreNos::class.java)
                startActivity(intent)
            }
            R.id.nav_sair -> {
                Toast.makeText(this, "Obrigado Pela Visita.", Toast.LENGTH_SHORT).show()
                finish()
            }

        }

        // fecha menu depois de tratar o evento
        layout_menu_lateral.closeDrawer(GravityCompat.START)
        return true
    }

}




