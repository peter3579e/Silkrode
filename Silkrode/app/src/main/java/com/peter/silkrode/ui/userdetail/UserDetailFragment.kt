package com.peter.silkrode.ui.userdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.peter.silkrode.MobileNavigationDirections
import com.peter.silkrode.databinding.FragmentUserdetailBinding
import com.peter.silkrode.ext.getVmFactory
import com.peter.silkrode.ui.home.HomeViewModel
import com.peter.silkrode.util.Logger

class UserDetailFragment : Fragment() {

    private lateinit var binding: FragmentUserdetailBinding
    private val viewModel by viewModels<UserDetailViewModel> {
        getVmFactory(
            UserDetailFragmentArgs.fromBundle(
                requireArguments()
            ).name
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserdetailBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        binding.cross.setOnClickListener {
            findNavController().navigate(MobileNavigationDirections.navigateToHomeFragment())
        }

        viewModel.userDetail.observe(viewLifecycleOwner, Observer {
            binding.user = it
        })



        return binding.root
    }
}