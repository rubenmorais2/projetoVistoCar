package com.ruben.vistocar


import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class ServicosAdapter (val servicos: List<ServicosPai>, val onClick: (ServicosPai) ->Unit
): RecyclerView.Adapter<ServicosAdapter.ServicosViewHolder>() {

    class ServicosViewHolder(view: View): RecyclerView.ViewHolder(view){
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

    // Quantidade de agendamentos na lista

    override fun getItemCount() = this.servicos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.services_layout, parent, false)

        val holder = ServicosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ServicosViewHolder, position: Int) {
        val context = holder.itemView.context

        val servicos = servicos[position]

        holder.cardNome.text = servicos.nome
        holder.frase.text = servicos.text

        Picasso.with(context).load(servicos.foto).fit().into(
            holder.cardImage,
            object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                }

                override fun onError() {
                }
            }
        )

        holder.itemView.setOnClickListener{ onClick(ServicosPai())}
    }
}






