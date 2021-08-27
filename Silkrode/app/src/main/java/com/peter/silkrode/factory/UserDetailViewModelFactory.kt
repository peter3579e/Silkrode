package com.peter.silkrode.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peter.silkrode.data.source.SilkrodeRepository
import com.peter.silkrode.ui.userdetail.UserDetailViewModel

class UserDetailViewModelFactory(
        private val silkrodeRepository: SilkrodeRepository,
        private val name: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(UserDetailViewModel::class.java)) {
            return UserDetailViewModel(silkrodeRepository, name) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}