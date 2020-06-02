package com.ruben.vistocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(3000)

                    val intent = Intent(baseContext, TelaInicial::class.java)
                    startActivity(intent)
                }catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
