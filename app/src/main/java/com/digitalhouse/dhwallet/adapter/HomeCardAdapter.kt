package com.digitalhouse.dhwallet.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder

class HomeCardAdapter(
    private val itens: List<Fragment>,
    fragment: Fragment,
    private val action: () -> Unit
) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = itens.size

    override fun createFragment(position: Int): Fragment {
        if (itens.isEmpty()) {
            throw IllegalArgumentException("Itens are Empty!")
        }
        return itens[position]
    }

    override fun onBindViewHolder(
        holder: FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
        holder.itemView.setOnClickListener { action.invoke() }
    }
}
