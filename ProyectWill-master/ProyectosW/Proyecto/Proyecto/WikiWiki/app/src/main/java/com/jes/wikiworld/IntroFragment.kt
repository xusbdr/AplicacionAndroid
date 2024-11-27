package com.jes.wikiworld

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.jes.wikiworld.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntroBinding.inflate(inflater, container, false)

        // Configura el adaptador para ViewPager2
        binding.viewPager.adapter = IntroPagerAdapter(this)

        // Vincula TabLayout con ViewPager2
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = if (position == 0) "Bienvenido" else "Comenzar"
        }.attach()

        // Suaviza la animación de transición entre páginas
        binding.viewPager.setPageTransformer { page, position ->
            page.apply {
                alpha = 1 - Math.abs(position)
                translationX = -position * page.width
            }
        }

        // Detecta el deslizamiento hacia la página "Comenzar"
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                // Muestra u oculta el botón dependiendo de la página
                binding.btnComenzar.visibility = if (position == 1) View.VISIBLE else View.GONE
            }
        })

        // Configura el botón para navegar al fragmento principal
        binding.btnComenzar.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_mainFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
