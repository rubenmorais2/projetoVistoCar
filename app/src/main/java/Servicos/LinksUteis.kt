package Servicos

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.ruben.vistocar.R
import kotlinx.android.synthetic.main.activity_links.*
import kotlinx.android.synthetic.main.toolbar.*

class LinksUteis : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_links)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Links Úteis"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
