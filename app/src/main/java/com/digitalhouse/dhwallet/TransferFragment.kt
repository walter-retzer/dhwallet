package com.digitalhouse.dhwallet

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.ContactAdapter
import com.digitalhouse.dhwallet.model.Contact
import com.digitalhouse.dhwallet.model.ContactType

class TransferFragment : Fragment(R.layout.transfer_fragment) {

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

        val profile = view.findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {

        }

        var voltarTransactions = view.findViewById<Toolbar>(R.id.toolbar).setOnClickListener {
            sendToTransaction()
        }

        val listContact = listOf<Contact>(
            Contact(
                image = "https://i.tribune.com.pk/media/images/1616036-cover_playbuzz-1516703815/1616036-cover_playbuzz-1516703815.jpg",
                name = "Joker",
                type = ContactType.PAI
            ),

            Contact(
                image = "https://vejasp.abril.com.br/wp-content/uploads/2016/12/joke1r1.jpg?quality=70&strip=all",
                name = "Coringa",
                type = ContactType.AMIGO
            ),

            Contact(
                image = "https://cdn.mensagenscomamor.com/content/images/m000515918.jpg?v=1&w=800&h=450",
                name = "Arlequina",
                type = ContactType.ESPOSA
            ),

            Contact(
                image = "https://jpimg.com.br/uploads/2019/05/michelle_pfeiffer-tim-burton.jpg",
                name = "Mulher Gato",
                type = ContactType.AMIGA
            ),

            Contact(
                image = "https://www.comboinfinito.com.br/principal/wp-content/uploads/2020/08/batman-wb-montreal.jpg",
                name = "Batman",
                type = ContactType.AMIGO
            ),

            Contact(
                image = "https://www.comboinfinito.com.br/principal/wp-content/uploads/2018/07/pinguim-filme-do-batman.jpg",
                name = "Sr. Pinguim",
                type = ContactType.IRMAO
            ),
        )

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerContatos)
        recycler?.adapter = ContactAdapter(listContact)

        view.findViewById<Button>(R.id.btn_qrcode).setOnClickListener {
            val permission =
                ContextCompat.checkSelfPermission(it.context, Manifest.permission.CAMERA)

            if (permission != PackageManager.PERMISSION_GRANTED) {
                permissionResultCallback.launch(Manifest.permission.CAMERA)
            } else {
                Toast.makeText(requireContext(), "Já está Permitido!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun sendToTransaction() {
        val action =
            TransferFragmentDirections.actionTransferFragmentToTransactionFragment("RS45", "539,88")
        findNavController().navigate(action)
    }
}
