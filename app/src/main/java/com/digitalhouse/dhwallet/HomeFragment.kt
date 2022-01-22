package com.digitalhouse.dhwallet

import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.digitalhouse.dhwallet.adapter.HomeCardAdapter
import com.digitalhouse.dhwallet.adapter.TransactionAdapter
import com.digitalhouse.dhwallet.model.Card
import com.digitalhouse.dhwallet.model.GroupSinalValor
import com.digitalhouse.dhwallet.model.GroupTransaction
import com.digitalhouse.dhwallet.model.GroupTypeTransaction
import com.digitalhouse.dhwallet.util.CustomPageTransformer
import com.digitalhouse.dhwallet.util.decorator.HorizontalMarginItemDecoration

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var imagemPagamento: Int = R.drawable.ic_spotify
    private var imagemPagamento2: Int = R.drawable.icon_dribble
    private var imagemPagamento3: Int = R.drawable.icon_netflix
    private var imagemPagamento4: Int = R.drawable.icon_uber

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listCards = listOf<Card>(
            Card(
                limite = "R$ 1800,00",
                number = "4139",
                name = "WALTER RETZER",
                expireAt = "03/28",
                brand = R.drawable.ic_visa,
                background = R.drawable.background_card
            ),

            Card(
                limite = "R$ 350,00",
                number = "0009",
                name = "DAWID RETZER",
                expireAt = "08/29",
                brand = R.drawable.ic_visa,
                background = R.drawable.background_card2
            ),

            Card(
                limite = "R$ 2200,00",
                number = "4877",
                name = "W.D. RETZER",
                expireAt = "02/25",
                brand = R.drawable.ic_visa,
                background = R.drawable.background_card3
            ),
        )

        val listTransactions = mutableListOf<GroupTransaction>(
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

        val listTransactions2 = mutableListOf<GroupTransaction>(
            GroupTransaction(
                type = GroupTypeTransaction.HEADER
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
                title = "Dribble Inc.",
                subtitle = "Pagamento",
                value = "+ R$ 45",
                imagem = imagemPagamento2
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

        val listTransactions3 = mutableListOf<GroupTransaction>(
            GroupTransaction(
                type = GroupTypeTransaction.HEADER
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
                title = "Spotify Family",
                subtitle = "Pagamento",
                value = "- R$ 163",
                sinal = GroupSinalValor.SINAL,
                imagem = imagemPagamento
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
                title = "Uber Inc.",
                subtitle = "Pagamento",
                value = "- R$ 25",
                sinal = GroupSinalValor.SINAL,
                imagem = imagemPagamento4
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
                title = "Dribble Inc.",
                subtitle = "Pagamento",
                value = "+ R$ 45",
                imagem = imagemPagamento2
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Dribble Inc.",
                subtitle = "Pagamento",
                value = "+ R$ 45",
                imagem = imagemPagamento2
            ),
        )

        val viewPager = view.findViewById<ViewPager2>(R.id.list_card_home)
        viewPager.adapter = HomeCardAdapter(listCards, this) { viewAnimate, card ->
            sendToHomeCardInfo(viewAnimate, card)
        }
        viewPager.addItemDecoration(
            HorizontalMarginItemDecoration(
                view.context,
                R.dimen.viewpager_current_item_horizontal_margin
            )
        )
        viewPager.setPageTransformer(CustomPageTransformer(view.context))
        viewPager.offscreenPageLimit = 1

        val recyclerHome = view.findViewById<RecyclerView>(R.id.recyclerTransactionsHome)
        recyclerHome.adapter =  TransactionAdapter(listTransactions, title = view.context.getString(R.string.transacao), showArrow = true){}

        var viewPagerMudou = object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                if(position == 0){
                    recyclerHome.adapter = TransactionAdapter(listTransactions, view.context.getString(R.string.transacao), true){
                        sendToTransaction()
                    }
                }else if(position == 1){
                    recyclerHome.adapter = TransactionAdapter(listTransactions2, view.context.getString(R.string.transacao), true){
                        sendToTransaction()
                    }
                }else if(position == 2){
                    recyclerHome.adapter = TransactionAdapter(listTransactions3, view.context.getString(R.string.transacao), true){
                        sendToTransaction()
                    }
                }
            }
        }
        viewPager.registerOnPageChangeCallback(viewPagerMudou)

    }

    private fun sendToTransaction() {
        val action =
            HomeFragmentDirections.actionHomeFragmentToTransactionFragment("R$ 45,87", "589,99")
        findNavController().navigate(action)
    }

    private fun sendToHomeCardInfo(rootView: View, card: Card) {
        ViewCompat.getTransitionName(rootView)?.let {
            val extras = FragmentNavigatorExtras(rootView to it)
            val action =
                HomeFragmentDirections.actionHomeFragmentToHomeCardInfo(card)
            findNavController().navigate(action, extras)
        }
    }
}
