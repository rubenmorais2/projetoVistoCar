package com.ruben.vistocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imageView2.setImageResource(R.drawable.logo)

        button.setOnClickListener {
            val textoUsuario = editText2.text.toString()
            Toast.makeText(this, "Seja Bem Vindo $textoUsuario", Toast.LENGTH_SHORT).show()

            //var intent = Intent(this, TelaInicialActivity::class.java)

            //startActivity(intent)
        }
    }
}
