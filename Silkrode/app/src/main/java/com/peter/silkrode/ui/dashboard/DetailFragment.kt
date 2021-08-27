package com.peter.silkrode.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.peter.silkrode.databinding.FragmentDetailBinding
import com.peter.silkrode.ext.getVmFactory
import com.peter.silkrode.ui.home.HomeViewModel

class DetailFragment : Fragment() {

    private val viewModel by viewModels<DetailViewModel> { getVmFactory() }
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        binding.image = "https://firebasestorage.googleapis.com/v0/b/letsswtich.appspot.com/o/fakeimages%2Fpeterbg.jpg?alt=media&token=44a79532-cbb4-4ce6-910a-31ff1c09d257"

        viewModel.userDetail.observe(viewLifecycleOwner, Observer {
            binding.user = it
        })

        return binding.root
    }
}