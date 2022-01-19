package com.digitalhouse.dhwallet

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.digitalhouse.dhwallet.adapter.HomeCardAdapter
import com.digitalhouse.dhwallet.adapter.TransactionAdapter
import com.digitalhouse.dhwallet.model.GroupSinalValor
import com.digitalhouse.dhwallet.model.GroupTransaction
import com.digitalhouse.dhwallet.model.GroupTypeTransaction
import com.digitalhouse.dhwallet.util.CustomPageTransformer
import com.digitalhouse.dhwallet.util.decorator.HorizontalMarginItemDecoration

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var imagemPagamento: Int = R.drawable.ic_spotify
    private var imagemPagamento2: Int = R.drawable.img_1
    private var imagemPagamento3: Int = R.drawable.icon_netflix
    private var imagemPagamento4: Int = R.drawable.icon_uber

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listCards = listOf<Fragment>(
            HomeCardItemFragment.newInstance(
                "R$ 1800,00",
                R.drawable.ic_visa,
                "4139",
                "WALTER RETZER",
                "03/28"
            ),
            HomeCardItemFragment.newInstance(
                "R$ 350,00",
                R.drawable.ic_visa,
                "0009",
                "WALTER RETZER",
                "08/25"
            ), HomeCardItemFragment.newInstance(
                "R$ 2200,00",
                R.drawable.ic_visa,
                "4171",
                "WALTER RETZER",
                "03/22"
            )
        )

        val viewPager = view.findViewById<ViewPager2>(R.id.list_card_home)
        viewPager.adapter = HomeCardAdapter(listCards, this) {
            sendToTransaction()
        }
        viewPager.addItemDecoration(
            HorizontalMarginItemDecoration(
                view.context,
                R.dimen.viewpager_current_item_horizontal_margin
            )
        )
        viewPager.setPageTransformer(CustomPageTransformer(view.context))
        viewPager.offscreenPageLimit = 1

        val listTransactions = listOf<GroupTransaction>(
            GroupTransaction(
                type = GroupTypeTransaction.HEADER
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
                type = GroupTypeTransaction.CONTENT,
                title = "Netflix",
                subtitle = "Pagamento",
                value = "- R$ 45",
                sinal = GroupSinalValor.SINAL,
                imagem = imagemPagamento3
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Uber Inc.",
                subtitle = "Pagamento",
                value = "- R$ 35",
                sinal = GroupSinalValor.SINAL,
                imagem = imagemPagamento4
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Uber Inc.",
                subtitle = "Pagamento",
                value = "- R$ 25",
                sinal = GroupSinalValor.SINAL,
                imagem = imagemPagamento4
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
                type = GroupTypeTransaction.CONTENT,
                title = "Netflix",
                subtitle = "Pagamento",
                value = "- R$ 45",
                sinal = GroupSinalValor.SINAL,
                imagem = imagemPagamento3
            )
        )

        val recyclerHome = view.findViewById<RecyclerView>(R.id.recyclerTransactionsHome)
        recyclerHome.adapter = TransactionAdapter(listTransactions, view.context.getString(R.string.transacao), true) {
            sendToTransaction()
        }
    }

    private fun sendToTransaction() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToTransactionFragment("R$ 45,87", "589,99")
        findNavController().navigate(action)
    }

}
