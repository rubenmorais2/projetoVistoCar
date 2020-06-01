package com.ruben.vistocar

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.tela_inicial.*
import kotlinx.android.synthetic.main.tela_inicial.layout_menu_lateral
import kotlinx.android.synthetic.main.toolbar.*

class  TelaInicial : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_inicial)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Tela Inicial"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        portaria.setOnClickListener {
            val url = "https://infraestrutura.gov.br/denatran"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        portariaText.setOnClickListener {
            val url = "https://infraestrutura.gov.br/denatran"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        resolucao.setOnClickListener {
            val url = "https://infraestrutura.gov.br/denatran"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        resolucaoText.setOnClickListener {
            val url = "https://infraestrutura.gov.br/denatran"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        abnt.setOnClickListener {
            val url = "https://www.abnt.org.br/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        abntText.setOnClickListener {
            val url = "https://www.abnt.org.br/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        der.setOnClickListener {
            val url = "http://www.der.sp.gov.br/WebSite/Index.aspx"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        derText.setOnClickListener {
            val url = "http://www.der.sp.gov.br/WebSite/Index.aspx"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        denatran.setOnClickListener {
            val url = "https://infraestrutura.gov.br/denatran"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        denatranText.setOnClickListener {
            val url = "https://infraestrutura.gov.br/denatran"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        detranSP.setOnClickListener {
            val url = "http://www.detran.sp.gov.br/wps/portal/portaldetran/cidadao/homeOLD/!ut/p/z1/jZFLc4JAEIR_iweuuw2LuOS2ENRA3haR7CUFSnArvAo2piq_XuPRKDq3qeqve6aaSppQWadbVaRaNXVa7vd36XwwGwvXMwU4vAAicjwG_9HEDHR5EODMCFB5DT8gkMP2x3zwNoXgr2xqBk8Woivzwxf48zm37mfmrQ_h2vbDXRgxuOwyL48k_y84CIYiLj0ZUqmyivysKgLC3cnEYiYbuw4fW7D_OhJ1xnhBZZd_5l3eke9uX91G6_bGgIGt6jVp179rVSidlmTVVCTrDJSq_uoNnDLYNL2myWmQtlUcxwnUc7XkvRiNdt8pJZg!/dz/d5/L2dBISEvZ0FBIS9nQSEh/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        detranSPText.setOnClickListener {
            val url = "http://www.detran.sp.gov.br/wps/portal/portaldetran/cidadao/homeOLD/!ut/p/z1/jZFLc4JAEIR_iweuuw2LuOS2ENRA3haR7CUFSnArvAo2piq_XuPRKDq3qeqve6aaSppQWadbVaRaNXVa7vd36XwwGwvXMwU4vAAicjwG_9HEDHR5EODMCFB5DT8gkMP2x3zwNoXgr2xqBk8Woivzwxf48zm37mfmrQ_h2vbDXRgxuOwyL48k_y84CIYiLj0ZUqmyivysKgLC3cnEYiYbuw4fW7D_OhJ1xnhBZZd_5l3eke9uX91G6_bGgIGt6jVp179rVSidlmTVVCTrDJSq_uoNnDLYNL2myWmQtlUcxwnUc7XkvRiNdt8pJZg!/dz/d5/L2dBISEvZ0FBIS9nQSEh/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        inmetro.setOnClickListener {
            val url = "https://www4.inmetro.gov.br/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        inmetroText.setOnClickListener {
            val url = "https://www4.inmetro.gov.br/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        ibama.setOnClickListener {
            val url = "http://www.ibama.gov.br/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        ibamaText.setOnClickListener {
            val url = "http://www.ibama.gov.br/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        angis.setOnClickListener {
            val url = "http://angis.org.br/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        angisText.setOnClickListener {
            val url = "http://angis.org.br/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

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

            R.id.fale_conosco -> {
                Toast.makeText(this, "Clicou em Fale Conosco", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, FaleConosco::class.java)
                startActivity(intent)
            }

            R.id.services -> {
                Toast.makeText(this, "Clicou em Serviços", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, Services::class.java)
                startActivity(intent)
            }

            R.id.grupo -> {
                Toast.makeText(this, "Clicou em o Grupo", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, SobreNos::class.java)
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




