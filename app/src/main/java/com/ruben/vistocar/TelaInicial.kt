package com.ruben.vistocar

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicial : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu_config, menu)
        // vincular evento de buscar
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // ação  quando terminou de buscar e enviou
                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou em Buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Clicou em Atualizar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Clicou em Configuração", Toast.LENGTH_LONG).show()
        } else if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun configuraMenuLateral() {

        // ícone de menu (hamburger) para mostrar o menu
        var toogle = ActionBarDrawerToggle(this, layoutMenuLateral, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_agendamento -> {
                var Intent = Intent(this, agendamento::class.java)
                intent.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }

            R.id.nav_perfil -> {
                Toast.makeText(this, "Clicou no Perfil", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_sair -> {
                finish()
            }

        }

        // fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }
}





