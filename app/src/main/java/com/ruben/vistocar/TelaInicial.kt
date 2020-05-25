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

class  TelaInicial : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {


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

            R.id.localizacao -> {
                Toast.makeText(this, "Clicou em Localização", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MapasActivity::class.java)
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




