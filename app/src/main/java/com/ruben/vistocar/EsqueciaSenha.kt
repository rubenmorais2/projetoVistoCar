package com.ruben.vistocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_esquecia_senha.*
import kotlinx.android.synthetic.main.toolbar.*

class EsqueciaSenha : AppCompatActivity() {

    private val TAG = "EsqueciaSenha"

    //Elementos da interface Ui
    private var etEmailRecuperado: EditText? = null
    private var etSubmit: Button? = null

    //referencias ao Firebase
    private var mAuth: FirebaseAuth? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esquecia_senha)

        setSupportActionBar(toolbar)

        supportActionBar?.title = ("Recuperação de acesso")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initialize()
    }

    private fun initialize() {
        etEmailRecuperado = findViewById(R.id.emailRecuperado) as EditText
        etSubmit = findViewById(R.id.Submit) as Button

        mAuth = FirebaseAuth.getInstance()

        Submit!!.setOnClickListener {sendPasswordEmail()}
    }

    private fun sendPasswordEmail() {
        val emailRecuperado = etEmailRecuperado?.text.toString()

        if (!TextUtils.isEmpty(emailRecuperado)) {
            mAuth!!
                .sendPasswordResetEmail(emailRecuperado)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val message = "Email enviado com sucesso!"
                        Log.d(TAG, message)
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                        updateUi()
                    } else {
                        Log.w(TAG, task.exception!!.message)
                        Toast.makeText(this, "Usuário não encontrado com esse email.", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Entre com um email válido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUi() {
        val intent = Intent(this@EsqueciaSenha, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
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
