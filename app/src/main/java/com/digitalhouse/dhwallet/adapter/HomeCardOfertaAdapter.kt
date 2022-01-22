package com.digitalhouse.dhwallet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.Ofertas

class HomeCardOfertaAdapter(private  val ofertas: List<Ofertas>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return OfertasViewHolder(inflater.inflate(R.layout.item_ofertas_card_info, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is OfertasViewHolder -> holder.bind(ofertas[position])
        }
    }

    override fun getItemCount() = ofertas.size
}

class OfertasViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val imagem: ImageView = view.findViewById(R.id.rv_ofertas)

    fun bind(item: Ofertas){
        item.imagem?.let { imagem.setImageResource(it) }
    }
}
