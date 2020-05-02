package com.ruben.vistocar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)




        imageView2.setImageResource(R.drawable.logo)

        button.setOnClickListener {
            var intent = Intent(this, TelaInicial ::class.java)
            val nomeUsuario = acessar.text.toString()
            val senhaUsuario = senha.text.toString()

            if(nomeUsuario == "aluno" && senhaUsuario == "impacta"){
                Toast.makeText(this, "Bem vindo $nomeUsuario", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }else {
                Toast.makeText(this, "Usuario ou Senha Incorreto", Toast.LENGTH_SHORT).show()
            }

        var Intent = Intent(this, TelaInicial::class.java)



        }


    }
}

        //button.setOnClickListener {onClickLogin() }

        // procurar pelas preferências, se pediu para guardar usuário e senha
       // var lembrar = Prefs.getBoolean("lembrar")
        //if (lembrar) {
           // var lembrarNome  = Prefs.getString("lembrarNome")
            //var lembrarSenha  = Prefs.getString("lembrarSenha")
            //acessar.setText(lembrarNome)
            //senha.setText(lembrarSenha)
            //checkBox.isChecked = lembrar

    //fun onClickLogin() {

        //val valorUsuario = acessar.text.toString()
        //val valorSenha = senha.text.toString()

        // armazenar valor do checkbox
        //Prefs.setBoolean("lembrar", checkBox.isChecked)
        // verificar se é para pembrar nome e senha
        //if (checkBox.isChecked) {
            //Prefs.setString("lembrarNome", valorUsuario)
            //Prefs.setString("lembrarSenha", valorSenha)
        //} else {
            //Prefs.setString("lembrarNome", "")
            //Prefs.setString("lembrarSenha", "")
        //}
        // criar intent
        //val intent = Intent(context,TelaInicial::class.java)
        // colocar parâmetros (opcional)
        //val params = Bundle()
        //params.putString("nome", "Ruben")
        //intent.putExtras(params)

        // enviar parâmetros simplificado
        //intent.putExtra("numero", 10)

        // fazer a chamada


