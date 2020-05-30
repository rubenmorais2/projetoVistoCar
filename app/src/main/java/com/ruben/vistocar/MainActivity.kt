package com.ruben.vistocar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*

enum class ProviderType {
    BASIC
}

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        supportActionBar?.title = ""

        imageView2.setImageResource(R.drawable.logo)

        //val bundle = intent.extras
        //val email = bundle?.getString("email")
        //val provider = bundle?.getString("provider")
        //setup(email ?: "", provider ?: "")

        novoCadastro.setOnClickListener {
            intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }


    //fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
    //private fun setup(email: String, provider: String) {

        //acessar.text = email?.toEditable()
        //senha.text = provider?.toEditable()

        button.setOnClickListener {
            onClickLogin()
            //FirebaseAuth.getInstance().signOut()
            //onBackPressed()





            var intent = Intent(this, SplashScreen::class.java)
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

            //armazenar valor do checkbox
            Prefs.setBoolean("lembrar", checkBox.isChecked)
            //verificar se é para pembrar nome e senha
            if (checkBox.isChecked) {
                Prefs.setString("lembrarNome", valorUsuario)
                Prefs.setString("lembrarSenha", valorSenha)
            } else {
                Prefs.setString("lembrarNome", "")
                Prefs.setString("lembrarSenha", "")
            }
        }
    }