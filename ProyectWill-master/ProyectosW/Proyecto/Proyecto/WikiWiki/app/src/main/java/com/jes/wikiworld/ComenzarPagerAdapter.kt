package com.jes.wikiworld


import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ComenzarPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2 // Dos páginas

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BienvenidoFragment() // Página inicial de bienvenida
            1 -> ComenzarFragment() // Página final para navegar
            else -> MainFragment() // Valor por defecto
        }
    }
}
