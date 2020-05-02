package com.ruben.vistocar


import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class AgendamentoAdapter (val agendamentos: List<agendamento>, val onClick: (agendamento) ->Unit
): RecyclerView.Adapter<AgendamentoAdapter.AgendamentosViewHolder>() {

    class AgendamentosViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImage: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.cardNome)
            cardImage = view.findViewById(R.id.cardImage)
            cardProgress = view.findViewById(R.id.cardProgress)
            cardView = view.findViewById(R.id.CardViewAgendamento)
        }
    }

    // Quantidade de disciplinas na lista

    override fun getItemCount() = this.agendamentos.size

    // inflar layout do adapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendamentosViewHolder {
        // infla view no adapter
        val view = LayoutInflater.from(parent.context).inflate(R.layout.agendamento_services, parent, false)

        // retornar ViewHolder
        val holder = AgendamentosViewHolder(view)
        return holder
    }

    // bind para atualizar Views com os dados

    override fun onBindViewHolder(holder: AgendamentosViewHolder, position: Int) {
        val context = holder.itemView.context

        // recuperar objeto disciplina
        val disciplina = agendamentos[position]

        // atualizar dados de disciplina


        holder.cardProgress.visibility = View.VISIBLE

    }
}






