package com.digitalhouse.dhwallet.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.R
import com.digitalhouse.dhwallet.model.*

private const val CONTENT = 0
private const val HEADER = 1
private const val DATA = 2

class TransactionAdapter(
    private val item: MutableList<GroupTransaction>,
    private val title: String,
    private val showArrow: Boolean = false,
    private val action: (GroupTransaction) -> Unit,

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType){
            HEADER -> TransactionHeaderViewHolder(inflater.inflate(R.layout.item_header_transaction, parent,false), action)
            DATA -> TransactionDataViewHolder(inflater.inflate(R.layout.item_data_transaction, parent, false))
            else -> TransactionViewHolder(inflater.inflate(R.layout.item_transactions, parent, false), action)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TransactionViewHolder -> holder.bind(item[position])
            is TransactionHeaderViewHolder -> holder.bind(title, showArrow, item[position])
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

class TransactionHeaderViewHolder(view: View, action: (GroupTransaction) -> Unit) : RecyclerView.ViewHolder(view) {
    private val tituloView: TextView = view.findViewById(R.id.tituloHeader)
    private val arrow: ImageView = view.findViewById(R.id.arrow)
    private var itemCorrente: GroupTransaction? = null

    init {
        view.setOnClickListener {
            itemCorrente?.let {
                action.invoke(it)
            }
        }
    }

    fun bind(titulo: String, showArrow: Boolean, item: GroupTransaction) {
        tituloView.text = titulo
        arrow.isVisible = showArrow
        item.type?.let {
            itemCorrente = item
        }
    }
}

class TransactionDataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tituloView: TextView = view.findViewById(R.id.dataTransaction)

    fun bind(item: GroupTransaction) {
        tituloView.text = item.data
    }
}

class TransactionViewHolder(view: View, action: (GroupTransaction) -> Unit) :
    RecyclerView.ViewHolder(view) {
    val image: ImageView = view.findViewById(R.id.imagemPagamento)
    private val title: TextView = view.findViewById(R.id.nomePagamento)
    private val subtitle: TextView = view.findViewById(R.id.descricaoPagamento)
    private val valor: TextView = view.findViewById(R.id.valorTransaction)
    private var itemCorrente: GroupTransaction? = null

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
        itemCorrente = item
    }
}
