package com.ruben.vistocar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class AgendamentoAdapter (val agendamento: List<AgendamentoPai>, val onClick: (AgendamentoPai) ->Unit
): RecyclerView.Adapter<AgendamentoAdapter.AgendamentoViewHolder>() {

    class AgendamentoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val car: TextView
        val brand: TextView
        val kindService: TextView
        val schedule: TextView
        val formDate: TextView
        val meus_agendamentos: CardView



        init {
            car = view.findViewById(R.id.carro)
            brand = view.findViewById(R.id.model)
            kindService = view.findViewById(R.id.typeService)
            schedule = view.findViewById(R.id.time)
            formDate = view.findViewById(R.id.date)
            meus_agendamentos = view.findViewById(R.id.MyAgendamentos)

        }
    }

    override fun getItemCount() = this.agendamento.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AgendamentoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_meus_agendamentos, parent, false)

        val holder = AgendamentoViewHolder(view)
        return holder
    }

        override fun onBindViewHolder(holder: AgendamentoViewHolder, position: Int) {
            val context = holder.itemView.context

            val agendamentos = agendamento[position]

            holder.car.text = agendamentos.modelo
            holder.brand.text = agendamentos.marca
            holder.kindService.text = agendamentos.tipoServico
            holder.schedule.text = agendamentos.horario
            holder.formDate.text = agendamentos.data

            holder.itemView.setOnClickListener{ onClick(agendamentos)}
        }
}