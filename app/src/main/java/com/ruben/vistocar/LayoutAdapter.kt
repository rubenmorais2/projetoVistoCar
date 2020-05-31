package com.ruben.vistocar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class LayoutAdapter (val agendamento: List<AgendamentoPai>, val onClick: (AgendamentoPai) ->Unit
): RecyclerView.Adapter<LayoutAdapter.AgendamentoViewHolder>() {

    class AgendamentoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nome_do_usuario: TextView
        val sobrenome_do_usuario: TextView
        val email_do_usuario: TextView

        init {
            nome_do_usuario = view.findViewById(R.id.nome_do_usuario)
            sobrenome_do_usuario = view.findViewById(R.id.sobrenome_do_usuario)
            email_do_usuario = view.findViewById(R.id.email_do_usuario)

        }
    }

    override fun getItemCount() = this.agendamento.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AgendamentoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_lateral_tela_inicial, parent, false)

        val holder = AgendamentoViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: AgendamentoViewHolder, position: Int) {
        val context = holder.itemView.context

        val agendamentos = agendamento[position]

        holder.email_do_usuario.text = agendamentos.email
        holder.nome_do_usuario.text = agendamentos.nome
        holder.sobrenome_do_usuario.text = agendamentos.sobrenome


        holder.itemView.setOnClickListener{ onClick(agendamentos)}
    }
}