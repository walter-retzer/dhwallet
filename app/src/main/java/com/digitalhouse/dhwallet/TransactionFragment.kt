package com.digitalhouse.dhwallet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.TransactionAdapter
import com.digitalhouse.dhwallet.model.GroupSinalValor
import com.digitalhouse.dhwallet.model.GroupTransaction
import com.digitalhouse.dhwallet.model.GroupTypeTransaction
import com.digitalhouse.dhwallet.model.Transaction

private const val ARG_ENTRADA = "arg_entrada"
private const val ARG_SAIDA = "arg_saida"

class TransactionFragment : Fragment(R.layout.fragment_transaction) {
    private var entrada: String? = null
    private var saida: String? = null

    private var imagemPagamento: Int = R.drawable.ic_spotify
    private var imagemPagamento2: Int = R.drawable.img_1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            entrada = it.getString(ARG_ENTRADA)
            saida = it.getString(ARG_SAIDA)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entradaView = view.findViewById<TextView>(R.id.entrada)
        entrada?.let {
            entradaView.text = it
        }

        val listTransactions = listOf<GroupTransaction>(
            GroupTransaction(
                type = GroupTypeTransaction.HEADER
            ),

            GroupTransaction(
                type = GroupTypeTransaction.DATA,
                data =  "Hoje"
            ),

            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Dribble Inc.",
                subtitle = "Pagamento",
                value = "+ R$ 45",
                imagem = imagemPagamento2
            ),

            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Spotify Family",
                subtitle = "Pagamento",
                value = "- R$ 163",
                sinal = GroupSinalValor.SINAL,
                imagem = imagemPagamento
            ),

            GroupTransaction(
                type = GroupTypeTransaction.DATA,
                data =  "Qua., 10 de nov."
            ),

            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Dribble Inc.",
                subtitle = "Pagamento",
                value = "+ R$ 45",
                imagem = imagemPagamento2
            )
        )

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerTransactions)
        recycler?.adapter = TransactionAdapter(listTransactions){}
    }

    companion object {
        fun newInstance(paramEntrada: String, paramSaida: String) =
            TransactionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ENTRADA, paramEntrada)
                    putString(ARG_SAIDA, paramSaida)
                }
            }
    }
}
