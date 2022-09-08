package com.example.banqumisrgraduation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.banqumisrgraduation.R
import com.example.banqumisrgraduation.databinding.FragmentHomeBinding
import com.example.banqumisrgraduation.ui.CoffeBuyActivity
import com.example.banqumisrgraduation.ui.recyclerView.RvAdapterCatalog
import com.example.banqumisrgraduation.ui.recyclerView.RvDataCatalog

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var adapter : RvAdapterCatalog? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
            binding.textHome.setOnClickListener {
                val intent = Intent(requireContext(),CoffeBuyActivity::class.java)
                startActivity(intent)
            }
        adapter = RvAdapterCatalog(listOf(RvDataCatalog(R.drawable.espresso,"Espresso")
            , RvDataCatalog((R.drawable.cappuccino),"Cappuccino")
        ))
        binding.rv.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun buy(view: View) {}
}