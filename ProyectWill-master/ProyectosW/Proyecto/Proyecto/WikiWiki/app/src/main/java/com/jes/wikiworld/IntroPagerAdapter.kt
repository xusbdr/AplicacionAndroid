package com.jes.wikiworld
// Asegúrate de importar los paquetes necesarios
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class IntroPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2 // Dos pestañas: Bienvenido y Comenzar

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BienvenidoFragment() // Para la primera pestaña
            1 -> ComenzarFragment()  // Para la segunda pestaña
            else -> throw IllegalStateException("Posición inválida")
        }
    }
}

