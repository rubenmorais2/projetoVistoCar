package com.ruben.vistocar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.agendamento.*

class CriarAgendamento : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agendamento)
        setTitle("Novo Agendamento")

        salvarAgendamento.setOnClickListener {
            val agendamento = agendamento()
        }
    }
}
