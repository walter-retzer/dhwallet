package com.digitalhouse.dhwallet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.TransactionAdapter
import com.digitalhouse.dhwallet.model.GroupSinalValor
import com.digitalhouse.dhwallet.model.GroupTransaction
import com.digitalhouse.dhwallet.model.GroupTypeTransaction

class TransactionFragment : Fragment(R.layout.fragment_transaction) {
    private var entrada: String? = null
    private var saida: String? = null

    private val myArgs : TransactionFragmentArgs by navArgs()

    private var imagemPagamento: Int = R.drawable.ic_spotify
    private var imagemPagamento2: Int = R.drawable.icon_dribble

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entrada = view.findViewById<TextView>(R.id.entrada)
        val saida = view.findViewById<TextView>(R.id.saida)

        entrada.text = myArgs.argEntrada
        saida.text = myArgs.argSaida

        val listTransactions = mutableListOf<GroupTransaction>(
            GroupTransaction(
                type = GroupTypeTransaction.HEADER
            ),

            GroupTransaction(
                type = GroupTypeTransaction.DATA,
                data = "Hoje"
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
                data = "Qua., 10 de nov."
            ),

            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Dribble Inc.",
                subtitle = "Pagamento",
                value = "+ R$ 45",
                imagem = imagemPagamento2
            )
        )

        val transactionList = view.findViewById<RecyclerView>(R.id.recyclerTransactions)

        transactionList.adapter = TransactionAdapter(listTransactions, view.context.getString(R.string.title_transfer), true) {

            it.title?.let { it1 -> Log.d("TESTE", it1) }
            var conteudo = it.title
            senToTransfer()

        }
    }

    private fun senToTransfer() {
        val action = TransactionFragmentDirections.actionTransactionFragmentToTransferFragment()
        findNavController().navigate(action)
    }

}
