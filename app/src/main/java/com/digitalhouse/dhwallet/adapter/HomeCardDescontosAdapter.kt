package com.digitalhouse.dhwallet.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.Descontos

class HomeCardDescontosAdapter(private  val descontos: List<Descontos>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return DescontoViewHolder(inflater.inflate(R.layout.item_ofertas_card_info, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is DescontoViewHolder -> holder.bind(descontos[position])
        }
    }

    override fun getItemCount() = descontos.size
}

class DescontoViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val imagem: ImageView = view.findViewById(R.id.rv_ofertas)

    fun bind(item: Descontos){
        item.imagem?.let { imagem.setImageResource(it) }
    }
}
