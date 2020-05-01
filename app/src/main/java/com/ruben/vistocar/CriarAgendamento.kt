package com.ruben.vistocar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.agendamento.*

class CriarAgendamento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agendamento)
        setTitle("Nova Disciplina")

        salvarDisciplina.setOnClickListener {
            val disciplina = agendamento()
        }
    }
}
