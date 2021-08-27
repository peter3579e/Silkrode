package com.peter.silkrode.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.peter.silkrode.data.source.SilkrodeRepository
import com.peter.silkrode.ui.dashboard.DetailViewModel
import com.peter.silkrode.ui.home.HomeViewModel

class ViewModelFactory(
        private val silkrodeRepository: SilkrodeRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(silkrodeRepository) as T
        }
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(silkrodeRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}