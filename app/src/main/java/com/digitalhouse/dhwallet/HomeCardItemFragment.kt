package com.digitalhouse.dhwallet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout

private const val ARG_LIMITE = "arg_limite"
private const val ARG_BANDEIRA = "arg_bandeira"
private const val ARG_NUMERO = "arg_numero"
private const val ARG_NOME = "arg_nome"
private const val ARG_VALIDADE = "arg_validade"
private const val ARG_BACKGROUND = "arg_background"

class HomeCardItemFragment : Fragment(R.layout.item_card) {
    private var limite: String? = null
    private var bandeira: Int? = null
    private var numero: String? = null
    private var nome: String? = null
    private var validade: String? = null
    private var background: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            limite = it.getString(ARG_LIMITE)
            bandeira = it.getInt(ARG_BANDEIRA)
            numero = it.getString(ARG_NUMERO)
            nome = it.getString(ARG_NOME)
            validade = it.getString(ARG_VALIDADE)
            background = it.getInt(ARG_BACKGROUND)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val limiteView = view.findViewById<TextView>(R.id.item_card_limit)
        val bandeiraView = view.findViewById<ImageView>(R.id.item_card_flag)
        val numeroView = view.findViewById<TextView>(R.id.item_card_number4)
        val nomeView = view.findViewById<TextView>(R.id.item_card_name)
        val validadeView = view.findViewById<TextView>(R.id.item_card_data_exp)
        val backgroundView = view.findViewById<ConstraintLayout>(R.id.root_card_item)

        limite?.let { limiteView.text = it }
        bandeira?.let { bandeiraView.setImageResource(it) }
        numero?.let { numeroView.text = it }
        nome?.let { nomeView.text = it }
        validade?.let { validadeView.text = it }
        background?.let { backgroundView.setBackgroundResource(it) }
    }

    companion object {
        fun newInstance(limite: String, @DrawableRes bandeira: Int, numero: String, nome: String, validade: String, @DrawableRes background: Int) =
            HomeCardItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_LIMITE, limite)
                    putInt(ARG_BANDEIRA, bandeira)
                    putString(ARG_NUMERO, numero)
                    putString(ARG_NOME, nome)
                    putString(ARG_VALIDADE, validade)
                    putInt(ARG_BACKGROUND, background)
                }
            }
    }
}
