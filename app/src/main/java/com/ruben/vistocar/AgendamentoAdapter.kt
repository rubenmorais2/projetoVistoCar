package com.ruben.vistocar


import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class AgendamentoAdapter (val agendamentos: List<AgendamentoPai>, val onClick: (AgendamentoPai) ->Unit
): RecyclerView.Adapter<AgendamentoAdapter.AgendamentosViewHolder>() {

    class AgendamentosViewHolder(view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImage: ImageView
        val cardView: CardView
        val frase: TextView

        init {
            cardNome = view.findViewById(R.id.cardNome)
            cardImage = view.findViewById(R.id.cardImage)
            cardView = view.findViewById(R.id.CardViewAgendamento)
            frase = view.findViewById(R.id.frase)
        }
    }

    // Quantidade de disciplinas na lista

    override fun getItemCount() = this.agendamentos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendamentosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.agendamento_services, parent, false)

        val holder = AgendamentosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: AgendamentosViewHolder, position: Int) {
        val context = holder.itemView.context

        val agendamento = agendamentos[position]

        holder.cardNome.text = agendamento.nome
        holder.frase.text = agendamento.text

        Picasso.with(context).load(agendamento.foto).fit().into(
            holder.cardImage,
            object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                }

                override fun onError() {
                }
            }
        )

        holder.itemView.setOnClickListener{ onClick(AgendamentoPai())}
    }
}






