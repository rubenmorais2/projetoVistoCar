package com.ruben.vistocar

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*
import org.w3c.dom.Text

class MainActivity : DebugActivity() {

    private val TAG = "MainActivity"

    //variaveis globais
    private var Email: String? = null
    private var Senha: String? = null

    //Elementos da interface UI
    private var etEmail: EditText? = null
    private var etSenha: EditText? = null
    private var btnButton: Button? = null
    private var cadastro: TextView? = null
    private var tvEsqueciaSenha: TextView? = null
    private var btcheckBox: CheckBox? = null

    //referencias ao banco de dados
    private var mAuth: FirebaseAuth? = null

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        supportActionBar?.title = ""

        imageView2.setImageResource(R.drawable.logo)
        initialize()

        novoCadastro.setOnClickListener {
            intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
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

        private fun initialize() {
            onClickLogin()
            tvEsqueciaSenha = findViewById(R.id.Esqueci) as TextView
            btcheckBox = findViewById(R.id.checkBox) as CheckBox
            cadastro = findViewById(R.id.novoCadastro) as TextView
            etEmail = findViewById(R.id.acessar) as EditText
            etSenha = findViewById(R.id.senha) as EditText
            btnButton = findViewById(R.id.button) as Button

            mAuth = FirebaseAuth.getInstance()

            tvEsqueciaSenha!!
                .setOnClickListener{startActivity(Intent(this@MainActivity, EsqueciaSenha::class.java))}

            cadastro!!
                .setOnClickListener {startActivity(Intent(this@MainActivity, Cadastro::class.java))}

            btnButton!!.setOnClickListener{loginUser()}


        }

        private fun loginUser() {
            Email = etEmail?.text.toString()
            Senha = etSenha?.text.toString()

            if (!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Senha)){
                Log.d(TAG, "User Login")

                mAuth!!.signInWithEmailAndPassword(Email!!, Senha!!).addOnCompleteListener(this){
                    task->

                    //Autenticando usuario, atualizando informações de Ui c/ login
                    if (task.isSuccessful) {
                        Log.d(TAG, "Logado com Sucesso")
                        updateUi()
                    } else {
                        Log.d(TAG, "Erro ao logar", task.exception)
                        Toast.makeText(this@MainActivity, "Não existe nenhum usuário com este email.", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        private fun updateUi() {
            val intent = Intent(this@MainActivity, SplashScreen::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
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