package com.ruben.vistocar

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*

class Cadastro : AppCompatActivity() {

    //Elementos da interface do usuário
    private var etnome: EditText? = null
    private var etsobrenome: EditText? = null
    private var etEmail: EditText? = null
    private var etSenha: EditText? = null
    private var mProgress: ProgressDialog? = null
    private var btCadastrar: Button? = null

    //Referências ao Banco de Dados
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private var TAG = "Cadastro"

    //Variáveis globais

    private var nome: String? = null
    private var sobrenome: String? = null
    private var Email: String? = null
    private var Senha: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        initialize()

        setSupportActionBar(toolbar)

        supportActionBar?.title = ("Meu Cadastro")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun initialize() {
        etnome = findViewById(R.id.nome) as EditText
        etsobrenome = findViewById(R.id.sobrenome) as EditText
        etEmail = findViewById(R.id.Email) as EditText
        etSenha = findViewById(R.id.Senha) as EditText
        mProgress = ProgressDialog(this)
        btCadastrar = findViewById(R.id.Cadastrar) as Button

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("users")
        mAuth = FirebaseAuth.getInstance()

        btCadastrar!!.setOnClickListener {creatNewAccount()

        }

        }


    private fun creatNewAccount() {
        nome = etnome?.text.toString().trim()
        sobrenome = etsobrenome?.text.toString().trim()
        Email = etEmail?.text.toString().trim()
        Senha = etSenha?.text.toString().trim()

        if (!TextUtils.isEmpty(nome) && !TextUtils.isEmpty(sobrenome) && !TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Senha)){
            Toast.makeText(this, "Cadastro efetuado com sucesso!", Toast.LENGTH_SHORT).show()
        } else{
            Toast.makeText(this, "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show()
        }

        mProgress!!.setMessage("Registrando Usuário...")
        mProgress!!.show()

        mAuth!!
            .createUserWithEmailAndPassword(Email!!, Senha!!).addOnCompleteListener(this) {task ->
               mProgress!!.hide()

                if (task.isSuccessful) {
                    Log.d(TAG, "CreateUserWithEmail: Sucess")

                    val userId = mAuth!!.currentUser!!.uid

                    //ver se o usuario verificou o email
                    verifyEmail()

                    val currentUserDb = mDatabaseReference!!.child(userId)
                    currentUserDb.child("nome").setValue(nome)
                    currentUserDb.child("sobrenome").setValue(sobrenome)

                    //Atualizar as informações no banco de dados
                    updateUserInfoAndUi()

                } else {
                    Log.w(TAG, "CreatUserWithEmail: Failure", task.exception)
                    Toast.makeText(this@Cadastro, "Já existe um cadastro com este email.", Toast.LENGTH_LONG).show()
                }
            }

    }

    private fun updateUserInfoAndUi() {
        //Iniciar nova atividade
        val intent = Intent(this@Cadastro, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun verifyEmail() {

        val mUser = mAuth!!.currentUser;
        mUser!!
            .sendEmailVerification()
            .addOnCompleteListener(this) {
            task ->

            if(task.isSuccessful){
                Toast.makeText(this@Cadastro, "Sucesso na verificação de email" + mUser.getEmail(),
                Toast.LENGTH_SHORT).show()

            } else {
                Log.e(TAG, "SendEmailVerification", task.exception)
                Toast.makeText(this@Cadastro, "Falha na verificação de email.",
                Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }
}