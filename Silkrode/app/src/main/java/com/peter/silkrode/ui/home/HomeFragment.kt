package com.peter.silkrode.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.peter.silkrode.R
import com.peter.silkrode.databinding.FragmentHomeBinding
import com.peter.silkrode.ext.getVmFactory
import java.util.*

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel> { getVmFactory() }
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val adapter = HomeAdapter()
        binding.userRecyclerView.adapter = adapter
        binding.lifecycleOwner = this

        viewModel.userList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(viewModel.userList.value)
        })


        return binding.root
    }
}