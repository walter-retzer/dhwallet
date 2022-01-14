package com.digitalhouse.dhwallet

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.dhwallet.adapter.ContactAdapter
import com.digitalhouse.dhwallet.model.Contact
import com.digitalhouse.dhwallet.model.ContactType

class TransferFragment : Fragment(R.layout.transfer_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profile = view.findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {

            val intent = Intent(it.context, MinhaActivity::class.java)
            startActivity(intent)

        }

        val listContact = MutableList(10) {
            Contact(
                image = "https://avatars.githubusercontent.com/u/9528928?v=4",
                name = "Walter Retzer",
                type = ContactType.IRMAO
            )
        }

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerContatos)
        recycler?.adapter = ContactAdapter(listContact)
    }
}
