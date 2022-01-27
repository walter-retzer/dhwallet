package com.digitalhouse.dhwallet

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.TransactionAdapter
import com.digitalhouse.dhwallet.model.GroupTransaction
import com.digitalhouse.dhwallet.model.GroupTypeTransaction


class PaymentFragment : Fragment(R.layout.fragment_payment) {

    private var imagemPagamento: Int = R.drawable.icon_earth
    private var imagemPagamento2: Int = R.drawable.icon_nira
    private var imagemPagamento3: Int = R.drawable.icon_aven
    private var imagemPagamento4: Int = R.drawable.icon_circle

    private val permissionResultCallback = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(requireContext(), "Permitido", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "Não Permitido", Toast.LENGTH_SHORT).show()
            activity?.let {
                it.findViewById<Button>(R.id.btn_qrcode).isEnabled = false
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listTransactions = mutableListOf<GroupTransaction>(
            GroupTransaction(
                type = GroupTypeTransaction.HEADER
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Criative Electric.",
                subtitle = "14460, Beirer Curve, \nVenamouth, VT 09239-2090",
                imagem = imagemPagamento
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Python Water Company",
                subtitle = "Burgerplatz, 28, 15663, Eurin",
                imagem = imagemPagamento2
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Link3 Technologies Ltd.",
                subtitle = "6708 Dave Underpass",
                imagem = imagemPagamento3
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Aveva Energie Ltd.",
                subtitle = "7845 Dever, Oregon",
                imagem = imagemPagamento4
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Criative Electric.",
                subtitle = "14460, Beirer Curve, \nVenamouth, VT 09239-2090",
                imagem = imagemPagamento
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Python Water Company",
                subtitle = "Burgerplatz, 28, 15663, Eurin",
                imagem = imagemPagamento2
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Link3 Technologies Ltd.",
                subtitle = "6708 Dave Underpass",
                imagem = imagemPagamento3
            ),
            GroupTransaction(
                type = GroupTypeTransaction.CONTENT,
                title = "Aveva Energie Ltd.",
                subtitle = "7845 Dever, Oregon",
                imagem = imagemPagamento4
            )
        )

        view.findViewById<Button>(R.id.btn_qrcode).setOnClickListener {
            val permission =
                ContextCompat.checkSelfPermission(it.context, Manifest.permission.CAMERA)

            if (permission != PackageManager.PERMISSION_GRANTED) {
                permissionResultCallback.launch(Manifest.permission.CAMERA)
            } else {
                Toast.makeText(requireContext(), "Não Permitido", Toast.LENGTH_SHORT).show()
            }
        }

        val transactionList = view.findViewById<RecyclerView>(R.id.recyclerPayment)
        transactionList.adapter = TransactionAdapter(
            listTransactions, view.context.getString(R.string.usados),
            false,
            {
                it.title?.let { it1 -> Log.d("TESTE", it1) }
                var conteudo = it.title
            },
            { transaction ->
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,
                        getString(R.string.share_payments, transaction.title, transaction.subtitle)
                    )
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(sendIntent, "Compartilhando Contato"))
            }
        )
    }
}
