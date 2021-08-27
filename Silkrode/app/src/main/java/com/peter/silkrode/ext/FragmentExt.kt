package com.peter.silkrode.ext

import androidx.fragment.app.Fragment
import com.peter.silkrode.SilkrodeApplication
import com.peter.silkrode.factory.UserDetailViewModelFactory
import com.peter.silkrode.factory.ViewModelFactory


/**
 *
 * Extension functions for Fragment.
 */


fun Fragment.getVmFactory(name: String): UserDetailViewModelFactory {
    val repository = (requireContext().applicationContext as SilkrodeApplication).silkrodeRepository
    return UserDetailViewModelFactory(repository, name)
}

fun Fragment.getVmFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as SilkrodeApplication).silkrodeRepository
    return ViewModelFactory(repository)
}