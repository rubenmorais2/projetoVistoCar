package com.ruben.vistocar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.toolbar.*

class MapasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapas)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Unidade Jaçanã"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onResume() {
        super.onResume()
        val mapaFragment = MapsFragment()
            supportFragmentManager.beginTransaction().replace(R.id.LayoutMapas, mapaFragment).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}


