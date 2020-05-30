package com.ruben.vistocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*

class Cadastro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        setSupportActionBar(toolbar)

        supportActionBar?.title = ("Meu Cadastro")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integração de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        setup()
    }

    private fun setup() {
        title = "Autenticação"

        cadastrar.setOnClickListener {
            if (nome.text.isNotEmpty() && sobrenome.text.isNotEmpty() && Email.text.isNotEmpty() && confirmEmail.text.isNotEmpty() && senha.text.isNotEmpty() && confirmSenha.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(Email.text.toString(), senha.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }
        }

        AcessarCadastro.setOnClickListener {
            if (nome.text.isNotEmpty() && sobrenome.text.isNotEmpty() && Email.text.isNotEmpty() && confirmEmail.text.isNotEmpty() && senha.text.isNotEmpty() && confirmSenha.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(Email.text.toString(), senha.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }
        }

    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Erro de autenticação de usuário")
        builder.setPositiveButton("Aceitar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType) {
        val intent = Intent(this, SplashScreen::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(intent)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}