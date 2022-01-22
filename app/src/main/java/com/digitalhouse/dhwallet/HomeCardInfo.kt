package com.digitalhouse.dhwallet

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.HomeCardDescontosAdapter
import com.digitalhouse.dhwallet.adapter.HomeCardOfertaAdapter
import com.digitalhouse.dhwallet.model.Descontos
import com.digitalhouse.dhwallet.model.Ofertas

class HomeCardInfo : Fragment(R.layout.fragment_home_card_info) {

    private val arg: HomeCardInfoArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaOfertas = listOf<Ofertas>(
            Ofertas(
                imagem = R.drawable.oferta
            ),
            Ofertas(
                imagem = R.drawable.oferta
            ),
            Ofertas(
                imagem = R.drawable.oferta
            ),
        )

        val listaDescontos = listOf<Descontos>(
            Descontos(
                imagem = R.drawable.oferta
            ),
           Descontos(
                imagem = R.drawable.oferta
            ),
            Descontos(
                imagem = R.drawable.oferta
            )
        )

        val limitView = view.findViewById<TextView>(R.id.limiteEntrada)
        val numberView = view.findViewById<TextView>(R.id.numero4)
        val buttomTranfer = view.findViewById<ImageView>(R.id.icon_transferir)
        val buttomTrasaction = view.findViewById<ImageView>(R.id.icon_transactions)
        val buttomPayment = view.findViewById<ImageView>(R.id.icon_pagamento)
        val background = view.findViewById<View>(R.id.backgroun_header)
        val bg = view.findViewById<View>(R.id.backgroun_header)

        limitView.text = arg.argCard.limite
        numberView.text = arg.argCard.number
        background.transitionName = view.context.getString(R.string.home_card_info_transaction)
        bg.setBackgroundResource(arg.argCard.background)

        val recyclerOfertas: RecyclerView = view.findViewById(R.id.recycler_ofertas)
        recyclerOfertas.adapter = HomeCardOfertaAdapter(listaOfertas)

        val recyclerDescontos: RecyclerView = view.findViewById(R.id.recycler_descontos)
        recyclerDescontos.adapter = HomeCardDescontosAdapter(listaDescontos)


        val profile = view.findViewById<ImageView>(R.id.icon_transferir)
        profile.setOnClickListener {

            val intent = Intent(it.context, MinhaActivity::class.java)
            startActivity(intent)
        }
    }
}
