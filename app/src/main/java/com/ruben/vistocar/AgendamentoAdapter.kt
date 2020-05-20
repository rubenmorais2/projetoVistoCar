package com.ruben.vistocar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AgendamentoAdapter (val agendamento: List<AgendamentoPai>, val onClick: (AgendamentoPai) ->Unit
): RecyclerView.Adapter<AgendamentoAdapter.AgendamentoViewHolder>() {

    class AgendamentoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val modelo: EditText
        val marca: EditText
        val tipoServico: EditText
        val horario: EditText
        val data: EditText
        val meus_agendamentos: CardView

        init {
            modelo = view.findViewById(R.id.modelo)
            marca = view.findViewById(R.id.marca)
            tipoServico = view.findViewById(R.id.tipoServico)
            horario = view.findViewById(R.id.horario)
            data = view.findViewById(R.id.data)
            meus_agendamentos = view.findViewById(R.id.MyAgendamentos)

        }
    }

    override fun getItemCount() = this.agendamento.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendamentoAdapter.AgendamentoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_meus_agendamentos, parent, false)

        val holder = AgendamentoAdapter.AgendamentoViewHolder(view)
        return holder
    }

        override fun onBindViewHolder(holder: AgendamentoAdapter.AgendamentoViewHolder, position: Int) {
            val context = holder.itemView.context

            val agendamento = agendamento[position]

            holder.itemView.setOnClickListener{ onClick(agendamento)}
        }
}