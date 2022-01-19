package com.digitalhouse.dhwallet.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.SurfaceControl
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.*

private const val CONTENT = 0
private const val HEADER = 1
private const val DATA = 2

class TransactionAdapter(
    private val item: List<GroupTransaction>,
    private val action: (Transaction) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == HEADER) {
            return TransactionHeaderViewHolder(
                inflater.inflate(
                    R.layout.item_header_transaction,
                    parent,
                    false
                )
            )
        }
        if (viewType == DATA) {
            return TransactionDataViewHolder(
                inflater.inflate(
                    R.layout.item_data_transaction,
                    parent,
                    false
                )
            )
        }
        return TransactionViewHolder(
            inflater.inflate(R.layout.item_transactions, parent, false),
            action
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TransactionViewHolder -> holder.bind(item[position])
            is TransactionHeaderViewHolder -> holder.bind(holder.itemView.context.getString(R.string.transferir))
            is TransactionDataViewHolder -> holder.bind(item[position])
        }
    }

    override fun getItemCount() = item.size

    override fun getItemViewType(position: Int): Int {
        if (item[position].type == GroupTypeTransaction.HEADER) {
            return HEADER
        }
        if (item[position].type == GroupTypeTransaction.DATA) {
            return DATA
        }
        return CONTENT
    }
}

class TransactionHeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tituloView: TextView = view.findViewById(R.id.tituloHeader)

    fun bind(titulo: String) {
        tituloView.text = titulo
    }
}

class TransactionDataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tituloView: TextView = view.findViewById(R.id.dataTransaction)

    fun bind(item: GroupTransaction) {
        tituloView.text = item.data
    }
}

class TransactionViewHolder(view: View, action: (Transaction) -> Unit) :
    RecyclerView.ViewHolder(view) {
    val image: ImageView = view.findViewById(R.id.imagemPagamento)
    private val title: TextView = view.findViewById(R.id.nomePagamento)
    private val subtitle: TextView = view.findViewById(R.id.descricaoPagamento)
    private val valor: TextView = view.findViewById(R.id.valorTransaction)
    private val itemCorrente: Transaction? = null

    init {
        view.setOnClickListener {
            itemCorrente?.let {
                action.invoke(it)
            }
        }
    }

    fun bind(item: GroupTransaction) {
        title.text = item.title
        subtitle.text = item.subtitle
        valor.text = item.value
        if (item.sinal == GroupSinalValor.SINAL) {  // mudando para a cor vermelha o valor R$
            valor.setTextColor(Color.RED)
        }
        item.imagem?.let { image.setImageResource(it) }
    }
}
