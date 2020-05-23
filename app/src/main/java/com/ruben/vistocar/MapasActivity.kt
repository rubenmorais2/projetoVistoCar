package com.ruben.vistocar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.SupportMapFragment

class MapasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapas)
    }

    override fun onResume() {
        super.onResume()
        val mapaFragment = MapsFragment()
            supportFragmentManager.beginTransaction().replace(R.id.LayoutMapas, mapaFragment).commit()
    }
}


