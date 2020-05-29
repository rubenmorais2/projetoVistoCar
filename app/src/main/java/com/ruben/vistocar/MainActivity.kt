package com.ruben.vistocar

import android.content.Context
import android.content.Intent
import android.hardware.biometrics.BiometricPrompt
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.menu_lateral_tela_inicial.*
import java.util.concurrent.Executor

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        supportActionBar?.title = ""

        imageView2.setImageResource(R.drawable.logo)

        button.setOnClickListener {
            onClickLogin()
            var intent = Intent(this, TelaInicial::class.java)
            val nomeUsuario = acessar.text.toString()
            val senhaUsuario = senha.text.toString()

            if (nomeUsuario == "aluno" && senhaUsuario == "impacta") {
                Toast.makeText(this, "Bem vindo $nomeUsuario", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Úsuario ou Senha Incorreto", Toast.LENGTH_SHORT).show()


            }
        }

        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome = Prefs.getString("lembrarNome")
            var lembrarSenha = Prefs.getString("lembrarSenha")
            acessar.setText(lembrarNome)
            senha.setText(lembrarSenha)
            checkBox.isChecked = lembrar
        }
    }

    fun onClickLogin() {

        val valorUsuario = acessar.text.toString()
        val valorSenha = senha.text.toString()

        // armazenar valor do checkbox
        Prefs.setBoolean("lembrar", checkBox.isChecked)
        // verificar se é para pembrar nome e senha
        if (checkBox.isChecked) {
            Prefs.setString("lembrarNome", valorUsuario)
            Prefs.setString("lembrarSenha", valorSenha)
        } else {
            Prefs.setString("lembrarNome", "")
            Prefs.setString("lembrarSenha", "")
        }
    }
}
